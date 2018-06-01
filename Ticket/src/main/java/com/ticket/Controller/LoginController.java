package com.ticket.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ticket.Model.Users;
import com.ticket.Services.UzytkownikService;

@Controller
public class LoginController {
	
	@Autowired
	private UzytkownikService uS;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String Login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "index";
	}
	
	@RequestMapping(value = "/login-uzytkownik", method = RequestMethod.POST)
	public String LoginUser(@ModelAttribute Users u, final HttpServletRequest request, HttpSession session, BindingResult result) {
		
		if(uS.findUserByLoginAndPassword(u.getUsername(), u.getPassword())!=null) {
			
			Users r = uS.findUserByLoginAndPassword(u.getUsername(), u.getPassword());
			
			session.setAttribute("loggedInUser", r.getUsername());
			
			
			if(r.getRole().equals("ADMIN")) {
				request.setAttribute("mode", "MODE_HOME");
				session.setAttribute("power", r.getRole());
			}
			else
				request.setAttribute("mode", "MODE_HOME");
			
			return "index";
		}
		else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "login";
		}
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpSession session,final HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		session.removeAttribute("loggedInUser");
		session.removeAttribute("power");
		return "index";
	}
}
