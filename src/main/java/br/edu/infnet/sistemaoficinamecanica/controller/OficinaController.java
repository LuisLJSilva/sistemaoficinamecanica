package br.edu.infnet.sistemaoficinamecanica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OficinaController {
	
	@GetMapping(value = "/")
	public String telaHome() {
		return "home";
	}
	
	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}
	
	@GetMapping(value = "/menu")
	public String telaMenu() {
		return "menu";
	}
	
	@GetMapping(value = "/sobre")
	public String telaSobre() {
		return "sobre";
	}

}
