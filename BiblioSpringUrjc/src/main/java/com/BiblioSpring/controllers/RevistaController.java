package com.BiblioSpring.controllers;


import com.BiblioSpring.entity.Revista;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BiblioSpring.entity.Alternativa;
import com.BiblioSpring.entity.Fanzine;
import com.BiblioSpring.entity.Pelicula;
import com.BiblioSpring.repository.AlternativasRepository;
import com.BiblioSpring.repository.RevistasRepository;

@Controller
public class RevistaController {
	@Autowired
	private RevistasRepository repository;
	@Autowired
	private AlternativasRepository repositoryAlt;

	@SuppressWarnings("deprecation")
	@PostConstruct
	public void init() {
		repository.save(new Revista("Pronto",1964,1));
	}
	
	@RequestMapping("/BiblioSpring/Revista/buscar_Revista")
	public String verFanzinePorNombre(Model model, HttpServletRequest request, @RequestParam String nombre) {

		model.addAttribute("revistas", repository.findByNombre(nombre).get());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "ver_Revista";
	}
	
	@Transactional
	@RequestMapping("/BiblioSpring/Revista/DeleteRevista")
	public String EliminarRevista(Model model, Pageable page, HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		return "DeleteRevista";
	}
	
	@Transactional
	@RequestMapping("/BiblioSpring/Revista/Revista_borrada")
	public String revistaBorrada(Model model, HttpServletRequest request, @RequestParam String nombre, Revista revista) {

		model.addAttribute("revistas", repository.deleteByNombre(nombre));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "revista_borrada";
	}
	
	@RequestMapping("/BiblioSpring/Revista/AddRevista")
	public String AnadirRevista(Model model, Pageable page) {
		return "AddRevista";
	}

	@RequestMapping("/BiblioSpring/Revista/nueva")
	public String nuevaRevista(Model model, Revista revista) {
		repository.save(revista);
		return "revista_guardada";
	}

	@RequestMapping("/BiblioSpring/Revista/ver_Revista")
	public String viewRevista(Model model, Pageable page) {

		model.addAttribute("revistas", repository.findAll(page));

		return "ver_Revista";
	}
	
	/*
	 * @RequestMapping ("/Revista")
	public String Revista(Model modelo, Pageable page) {
		modelo.addAttribute("alternativas", repositoryAlt.findAll(page));
		return "Revista";
	}

	 */
}
