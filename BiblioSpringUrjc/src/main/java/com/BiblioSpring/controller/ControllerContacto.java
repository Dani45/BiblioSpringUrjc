package com.BiblioSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ControllerContacto {
	@RequestMapping("/Contacto")
	public String contacto(Model model) {
		// model.addAttribute("name", "monitor");
		return "Contacto";
	}

}