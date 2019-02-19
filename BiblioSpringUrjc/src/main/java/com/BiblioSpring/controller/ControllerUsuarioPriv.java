package com.BiblioSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerUsuarioPriv {
	
	@RequestMapping("/usuarioPrivado")
	public String mostrar(Model modelo) {
		return "PaginaUsuarioPrivada";
	}
	
	@RequestMapping("/Alquilar")
	public String alquilar(Model model) {
		return "Alquilar";
	}
	
	@RequestMapping("/Renovar")
	public String renovar(Model model) {
		return "Renovar";
	}
	
	@RequestMapping("/Reservar")
	public String reservar(Model model) {
		return "Reservar";
	}
	
	@RequestMapping("/Opinar")
	public String opinar(Model model) {
		return "Opinar";
	}
	
	@RequestMapping("/CambiarDatosPersonales")
	public String cambiarDatosPersonales(Model model) {
		return "CambiarDatosPersonales";
	}
	
	@RequestMapping("/VerDeuda")
	public String verDeuda(Model model) {
		return "VerDeuda";
	}
}

