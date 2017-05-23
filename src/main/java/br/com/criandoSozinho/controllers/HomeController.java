package br.com.criandoSozinho.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String irPara() {
		return "index.html";
	}
	
	@GetMapping("/teste")
	public String goTo() {
		return "testando.html";
	}
	

}
