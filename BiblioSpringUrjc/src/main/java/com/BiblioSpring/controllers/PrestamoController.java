package com.ejemplo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrestamoController {

	@RequestMapping("/Prestamo")
	public String Presamo(Model model) {
		return "Prestamo";
	}
}
