package br.com.criandoSozinho.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String irPara(){
		return "index.html";
	}
	
	@GetMapping("/please")
	public String chamar(){
		return "pfvr.html";
	}
	
	@GetMapping("/vamo")
	public String chamar2(){
		return "web.html";
	}
	
	@GetMapping("/")
	public String irPara2(){
		return "index2.html";
	}

}
