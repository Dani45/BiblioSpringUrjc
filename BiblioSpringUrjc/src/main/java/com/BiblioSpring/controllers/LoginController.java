package com.BiblioSpring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/Prestamo")
	public String Presamo(Model model) {
		return "Prestamo";
	}

	

}