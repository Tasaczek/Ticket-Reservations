package com.ticket.Controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.yaml.snakeyaml.util.ArrayUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.Model.*;
import com.ticket.Services.*;

@Controller
public class EntityController {
	
	private final int ilosc_miejsc = 50;	//lista miejsc ma sie odwolywac do tej stałej, wybieranie w np polu graficznym
											//wolne miejsca - zielony kolor, zajete miejsca - czerwony np.
	
	@Autowired
	private FilmService fS;
	
	@Autowired
	private GatunekService gS;
	
	@Autowired
	private MiejsceService mS;
	
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
	
	/*-------------------FILM------------------------*/
	
	@RequestMapping("/movies")
	public String listaFilmow(HttpServletRequest request) {
		List<Film> filmy = fS.showAllFilms(); 
		request.setAttribute("filmy", filmy);
		request.setAttribute("mode", "MODE_MOVIES");
		return "filmy";
	}

	public String dodajFilm() {
		
		return "index";
	}
	
	public String usunFilm() {
		
		return "index";
	}
	
	public String edytujFilm() {
		
		return "index";
	}
	
	
	/*--------------------*/
	
	@RequestMapping("/genres")
	public String listaGatunkow(HttpServletRequest request) {
		List<Gatunek> gatunki = gS.listaGatunkow();
		request.setAttribute("gatunki", gatunki);
		request.setAttribute("mode", "MODE_GENRES");
		
		return "gatunki";
	}
	
	@RequestMapping("/dodajGatunek")
	public String dodajGatunek() {
		
		return "index";
	}
	
	public String usunGatunek() {
		
		return "index";
	}
	
	public String edytujGatunek() {
		
		return "index";
	}
	
	/*--------------------*/
	
	@RequestMapping("/directors")
	public String listaRezyserow(HttpServletRequest request) {
		List<Rezyser> rezyserzy = rS.listaRezyserow();
		request.setAttribute("rezyserzy", rezyserzy);
		request.setAttribute("mode", "MODE_DIRECTORS");
		
		return "rezyserzy";
	}
	
	public String dodajRezysera() {
		
		return "index";
	}
	
	public String usunRezysera() {
		
		return "index";
	}

	public String edytujRezysera() {
	
	return "index";
	}
	
	/*--------------------*/
	
	@RequestMapping("/times")
	public String listaTerminow(HttpServletRequest request) {
		List<Termin> terminy = tS.listaTerminow();
		request.setAttribute("terminy", terminy);
		request.setAttribute("mode", "MODE_TIMES");
		
		return "terminy";
	}
	
	public String dodajTermin() {
		
		return "index";
	}
	
	public String usunTermin() {
		
		return "index";
	}

	public String edytujTermin() {
	
	return "index";
	}
	
	/*--------------------*/
	
	@RequestMapping("/versions")
	public String listaWersji(HttpServletRequest request) {
		List<Wersja> wersje = wS.listaWersji();
		request.setAttribute("wersje", wersje);
		request.setAttribute("mode", "MODE_VERSIONS");
		
		return "wersje_filmu";
	}
	
	public String dodajWersje() {
		
		return "index";
	}
	
	public String usunWersje() {
		
		return "index";
	}

	public String edytujWersje() {
	
	return "index";
	}
	
	/*--------------------BILET-----------------------*/
	
	@RequestMapping("/tickets")
	public String listaBiletow(HttpServletRequest request) {
		List<Bilet> bilety = bS.listaBiletow();
		request.setAttribute("bilety", bilety);
		request.setAttribute("mode", "MODE_TICKETS");
		
		return "bilety";
	}
	
	@GetMapping(value="/reservations")
	public String rezerwujBilet(HttpServletRequest request, @RequestParam int id) {
		Film f = fS.getFilmById(id);
		List<Rodzaj> rodzaje = rodzS.listaRodzajow();
		//zarezerwowane miejsca
		List<Integer> rezerwacje = bS.zarMiejsca(f.getId());
		request.setAttribute("rezerwacje", rezerwacje);
		//
		request.setAttribute("film", f);
		request.setAttribute("rodzaje", rodzaje);
		request.setAttribute("mode", "MODE_RESERVATIONS");
		return "filmy";
	}
	
	@PostMapping(value="/reservations")
	public String rezerwujBiletPost(@ModelAttribute Bilet bilet, HttpServletRequest request, BindingResult bindingResult) {
		
		if(request.getParameter("miejsce")==null) {
			request.setAttribute("error", "Wybierz miejsce!");
		}
		else {
			if(bS.getBiletByMiejsce(bilet.getMiejsce())==null)
				bS.rezerwujBilet(bilet);
			return "redirect:/tickets";
		}
		return "filmy";
	}
	
	@RequestMapping(value="/del-ticket")
	public String usunBilet(@RequestParam int id) {
		bS.usunBilet(id);
	
		return "redirect:/tickets";
	}

	public String edytujBilet() {
	
		return "index";
	}
	
	/*--------------------*/
	
	
	public String dodajMiejsce() {
		
		return "index";
	}
	
	public String usunMiejsce() {
		
		return "index";
	}

	public String edytujMiejsce() {
	
		return "index";
	}
	
	/*--------------------*/
	
	public String dodajRodzaj() {
		
		return "index";
	}
	
	public String usunRodzaj() {
		
		return "index";
	}

	public String edytujRodzaj() {
	
		return "index";
	}
	
}
