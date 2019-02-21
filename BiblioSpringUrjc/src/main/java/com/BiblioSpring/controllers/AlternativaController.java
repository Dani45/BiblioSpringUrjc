package com.BiblioSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlternativaController {
	@RequestMapping("/Alternativa")
	public String alternativa(Model model) {

		return "Alternativa";
	}
}
