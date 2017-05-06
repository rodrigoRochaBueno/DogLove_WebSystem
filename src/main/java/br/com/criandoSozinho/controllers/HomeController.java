package br.com.criandoSozinho.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String irPara(){
		return "index.html";
	}
	
	@GetMapping("/cad")
	public String chamar(){
		return "cadastro.html";
	}
	
	@GetMapping("/vamo")
	public String chamar2(){
		return "login2.html";
	}
	
}
