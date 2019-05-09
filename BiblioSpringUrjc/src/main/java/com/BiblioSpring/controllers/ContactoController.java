package com.BiblioSpring.controllers;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BiblioSpring.entity.Contacto;
import com.BiblioSpring.repository.ContactosRepository;

@Controller

public class ContactoController {

	@Autowired
	private ContactosRepository repository;
/*
	@PostConstruct
	public void init() {
		repository.save(new Contacto("Pepe", "Hola caracola", "XXXX", "eww"));
		repository.save(new Contacto("Juan", "Hola caracola", "XXXX", "sdad"));
	}
*/
	@RequestMapping("/BiblioSpring/nuevoContacto")
	public String addcontacto(Model model, Pageable page, HttpServletRequest request) {

		model.addAttribute("contacto", repository.findAll(page));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "nuevoContacto";
	}

	@RequestMapping("/BiblioSpring/Contacto/nuevo")
	public String nuevoContacto(Model model, Contacto contacto, HttpServletRequest request) {

		repository.save(contacto);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "contacto_guardado";

	}

	@RequestMapping("/BiblioSpring/ver_Contacto")
	public String viewContacto(Model model, Pageable page, HttpServletRequest request) {

		model.addAttribute("contactos", repository.findAll(page));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		return "ver_Contacto";
	}
}