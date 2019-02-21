package com.ejemplo.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejemplo.entity.Contacto;
import com.ejemplo.repository.ContactosRepository;

@Controller

public class ContactoController {

	@Autowired
	private ContactosRepository repository;

	@PostConstruct
	public void init() {
		repository.save(new Contacto("Pepe", "Hola caracola", "XXXX", "eww"));
		repository.save(new Contacto("Juan", "Hola caracola", "XXXX", "sdad"));
	}

	@RequestMapping("/Contacto")
	public String contacto(Model model, Pageable page) {

		return "Contacto";
	}

	@RequestMapping("/nuevoContacto")
	public String addcontacto(Model model, Pageable page) {

		model.addAttribute("contacto", repository.findAll(page));

		return "nuevoContacto";
	}

	@RequestMapping("/Contacto/nuevo")
	public String nuevoContacto(Model model, Contacto contacto) {

		repository.save(contacto);

		return "contacto_guardado";

	}

	@RequestMapping("/ver_Contacto")
	public String viewContacto(Model model, Pageable page) {

		model.addAttribute("contactos", repository.findAll(page));

		return "ver_Contacto";
	}
}