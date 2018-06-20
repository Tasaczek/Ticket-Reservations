package com.ticket.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ticket.Model.*;
import com.ticket.Services.*;

@Controller
public class EntityController {

	@Autowired
	private FilmService fS;

	@Autowired
	private GatunekService gS;

	@Autowired
	private RezyserService rS;

	@Autowired
	private RodzajService rodzS;

	@Autowired
	private TerminService tS;

	@Autowired
	private WersjaService wS;

	@Autowired
	private BiletService bS;

	@RequestMapping(value = { "/", "/home" })
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}

	/*-------------------FILM------------------------*/

	@RequestMapping("/movies")
	public String listaFilmow(HttpServletRequest request) {
		List<Film> filmy = fS.showAllFilms();
		request.setAttribute("filmy", filmy);
		request.setAttribute("mode", "MODE_MOVIES");
		return "filmy";
	}

	/*--------------------*/

	@RequestMapping("/genres")
	public String listaGatunkow(HttpServletRequest request) {
		List<Gatunek> gatunki = gS.listaGatunkow();
		request.setAttribute("gatunki", gatunki);
		request.setAttribute("mode", "MODE_GENRES");
		return "gatunki";
	}

	@RequestMapping(value = "/wybierz")
	public String filmyPoGatunkuWyboru(HttpServletRequest request, @RequestParam int id, @RequestParam char t) {

		if (t == 'g') {
			List<Film> filmy = fS.filmyPoGatunku(id);

			if (filmy.isEmpty()) {
				request.setAttribute("filmy", "Brak danych w bazie!");
				request.setAttribute("mode", "MODE_NULL");
			} else {
				request.setAttribute("filmy", filmy);
				request.setAttribute("mode", "MODE_MOVIES");
			}
		} else if (t == 'w') {
			List<Film> filmy = fS.filmyPoWersji(id);

			if (filmy.isEmpty()) {
				request.setAttribute("filmy", "Brak danych w bazie!");
				request.setAttribute("mode", "MODE_NULL");
			} else {
				request.setAttribute("filmy", filmy);
				request.setAttribute("mode", "MODE_MOVIES");
			}
		} else if (t == 'r') {
			List<Film> filmy = fS.filmyPoRezyserach(id);

			if (filmy.isEmpty()) {
				request.setAttribute("filmy", "Brak danych w bazie!");
				request.setAttribute("mode", "MODE_NULL");
			} else {
				request.setAttribute("filmy", filmy);
				request.setAttribute("mode", "MODE_MOVIES");
			}
		} else if (t == 't') {
			List<Film> filmy = fS.filmyPoTerminie(id);

			if (filmy.isEmpty()) {
				request.setAttribute("filmy", "Brak danych w bazie!");
				request.setAttribute("mode", "MODE_NULL");
			} else {
				request.setAttribute("filmy", filmy);
				request.setAttribute("mode", "MODE_MOVIES");
			}
		}

		return "filmy";
	}

	/*--------------------*/

	@RequestMapping("/directors")
	public String listaRezyserow(HttpServletRequest request) {
		List<Rezyser> rezyserzy = rS.listaRezyserow();
		request.setAttribute("rezyserzy", rezyserzy);
		request.setAttribute("mode", "MODE_DIRECTORS");

		return "rezyserzy";
	}

	/*--------------------*/

	@RequestMapping("/times")
	public String listaTerminow(HttpServletRequest request) {
		List<Termin> terminy = tS.listaTerminow();
		request.setAttribute("terminy", terminy);
		request.setAttribute("mode", "MODE_TIMES");

		return "terminy";
	}

	/*--------------------*/

	@RequestMapping("/versions")
	public String listaWersji(HttpServletRequest request) {
		List<Wersja> wersje = wS.listaWersji();
		request.setAttribute("wersje", wersje);
		request.setAttribute("mode", "MODE_VERSIONS");

		return "wersje_filmu";
	}

	/*--------------------BILET-----------------------*/

	@RequestMapping("/tickets")
	public String listaBiletow(HttpServletRequest request) {
		List<Bilet> bilety = bS.listaBiletow();
		request.setAttribute("bilety", bilety);
		request.setAttribute("mode", "MODE_TICKETS");

		return "bilety";
	}

	@GetMapping(value = "/reservations")
	public String rezerwujBilet(HttpServletRequest request, @RequestParam int id) {
		Film f = fS.getFilmById(id);
		List<Rodzaj> rodzaje = rodzS.listaRodzajow();
		// zarezerwowane miejsca
		List<Integer> rezerwacje = bS.zarMiejsca(f.getId());
		request.setAttribute("rezerwacje", rezerwacje);
		//
		request.setAttribute("film", f);
		request.setAttribute("rodzaje", rodzaje);
		request.setAttribute("mode", "MODE_RESERVATIONS");
		return "filmy";
	}

	@PostMapping(value = "/reservations")
	public String rezerwujBiletPost(@ModelAttribute Bilet bilet, HttpServletRequest request,
			BindingResult bindingResult, RedirectAttributes redirectAttrib) {

		if (request.getParameter("miejsce") == null) {
			request.setAttribute("error", "Wybierz miejsce!");
		} else {
			if (bS.getBiletByFilmIdAndMiejsce(bilet.getFilm().getId(), bilet.getMiejsce()) == null) {
				bS.rezerwujBilet(bilet);

				Bilet n = bS.getBiletByFilmIdAndMiejsce(bilet.getFilm().getId(), bilet.getMiejsce());
				createPDF pdf = new createPDF(n); // tworzenie obiektu PDF
				String url = pdf.run(); // stworzenie pliku PDF
				
				redirectAttrib.addAttribute("url",url);	//atrybut przekazywany do f. wyświetlającej link
			}

			return "redirect:/link";
		}
		return "filmy";
	}

	//Link do pobrania biletu
	@GetMapping(value="/link")
	public String linkDoBiletu(@RequestParam String url,HttpServletRequest request) {

		request.setAttribute("adr", url);
		return "link";
	}
	
	//Pobranie biletu
	@GetMapping(value="/pobierzBilet")
	public String pobierzBilet() {
		
		return "pobierzBilet";
	}

	@PostMapping(value="/pobierzBilet")
	public String downloadBilet(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="link",required=false) String link) {
		
		try {
			DefaultResourceLoader loader = new DefaultResourceLoader();
			InputStream is = loader.getResource("file:./src/main/resources/pliki/"+link).getInputStream();
			//classpath: trzeba zamienic na file: do bezpośredniego działania
			IOUtils.copy(is, response.getOutputStream());
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=Bilet.pdf");
	        response.flushBuffer();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return "pobierzBilet";
	}

	/*--------------------*/

	@GetMapping(value = "/szukaj")
	public String wyszukajPo() {

		return "wyszukaj";
	}

}
