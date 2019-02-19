package com.BiblioSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerAlternativa {
	@RequestMapping("/Alternativa")
	public String alternativa(Model model) {

		return "Alternativa";
	}
}
