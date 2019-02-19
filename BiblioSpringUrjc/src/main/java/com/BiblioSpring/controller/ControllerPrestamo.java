package com.BiblioSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerPrestamo {

	@RequestMapping("/Prestamo")
	public String Presamo(Model model) {
		return "Prestamo";
	}
}
