package com.BiblioSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ControllerCategoria {

	@RequestMapping("/Categoria")
	public String categoria(Model model) {
		// model.addAttribute("name", "monitor");
		return "Categoria";
	}
}