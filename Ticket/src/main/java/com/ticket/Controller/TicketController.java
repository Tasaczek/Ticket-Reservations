package com.ticket.Controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ticket.Model.Film;
import com.ticket.Services.FilmService;
import com.ticket.Services.UzytkownikService;

@Controller
public class TicketController {
	
	@Autowired
	private UzytkownikService uS;
	
	@RequestMapping(value = {"/","/home"})
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	
	
}
