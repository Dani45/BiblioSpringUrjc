package com.ejemplo.controllers;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejemplo.entity.Alternativa;
import com.ejemplo.entity.Categoria;
import com.ejemplo.repository.AlternativasRepository;


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

	
	@RequestMapping("/Alternativa")
	public String Alternativa(Model model, Pageable page) {
		
		model.addAttribute("alternativas", repository.findAll(page));
		return "Alternativa";
	}
	
	@RequestMapping("/AddAlternativa")
	public String Addalternativa(Model model, Pageable page) {

		model.addAttribute("alternativa", repository.findAll(page));

		return "AddAlternativa";
	}
	
	@RequestMapping("/Alternativa/nueva")
	public String nuevaAlternativa(Model model, Alternativa alternativa) {

		repository.save(alternativa);

		return "alternativa_guardada";

	}
	
	/*
	
	
	@RequestMapping("/ver_Alternativa")
	public String viewAlternativa(Model model, Pageable page) {

		model.addAttribute("alternativas", repository.findAll(page));
	
		return "ver_Alternativa";
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
