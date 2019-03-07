package com.BiblioSpring.controllers;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BiblioSpring.entity.Alternativa;
import com.BiblioSpring.entity.Categoria;
import com.BiblioSpring.repository.AlternativasRepository;


@Controller
public class AlternativaController {
	
	
	@Autowired
	private AlternativasRepository repository;

	@SuppressWarnings("deprecation")
	@PostConstruct
	public void init() {
		repository.save(new Alternativa("fanzine"));
		repository.save(new Alternativa("pelicula"));
		repository.save(new Alternativa("revista"));
	}
	
	@RequestMapping("/BiblioSpring/Alternativa/buscar_Alternativa")
	public String verAlternativaPorNombre(Model model, HttpServletRequest request, @RequestParam String alternativa) {

		model.addAttribute("alternativas", repository.findByAlternativa(alternativa));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "ver_Alternativa";
	}
	
	
	@RequestMapping("/BiblioSpring/Alternativa/ver_Alternativa")
	public String viewAlternativa(Model model, Pageable page) {

		model.addAttribute("alternativas", repository.findAll(page));
	
		return "ver_Alternativa";
	}
	
	
	
	
	@RequestMapping("/BiblioSpring/Alternativa/AddAlternativa")
	public String Addalternativa(Model model, Pageable page, HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("alternativas", repository.findAll(page));

		return "AddAlternativa";
	}
	
	@RequestMapping("/BiblioSpring/Alternativa/nueva")
	public String nuevaAlternativa(Model model, Alternativa alternativa,HttpServletRequest request) { //, 
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		repository.save(alternativa);
		return "alternativa_guardada";
	}
	
	/*
	
	
	@RequestMapping("/ver_Alternativa")
	public String viewAlternativa(Model model, Pageable page) {

		model.addAttribute("alternativas", repository.findAll(page));
	
		return "ver_Alternativa";
	}


	@RequestMapping("/Alternativa")
	public String Alternativa(Model model, Pageable page) {
		
		model.addAttribute("alternativas", repository.findAll(page));
		return "Alternativa";
	}
	

	
	@RequestMapping("/DeleteAlternativa")
	public String eliminarAlternativa(Model model, Pageable page) {

		model.addAttribute("alternativas", repository.findAll(page));
		return "BorrarAltern";
	}
	
	@RequestMapping("/Alternativa/delete")
	public String alternativaEliminada(Model model, Long idAlternativa) {
		repository.deleteById(idAlternativa);

		return "borradoAlternativa";
	}*/


}
