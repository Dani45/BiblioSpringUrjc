package com.BiblioSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerPrestamo {

	@RequestMapping("/Prestamo")
	public String padre(Model model) {
		// model.addAttribute("name", "padre");
		return "Prestamo";
	}
}
