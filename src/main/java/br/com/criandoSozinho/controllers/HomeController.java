package br.com.criandoSozinho.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String irPara() {
		return "login2.html";
	}

}
