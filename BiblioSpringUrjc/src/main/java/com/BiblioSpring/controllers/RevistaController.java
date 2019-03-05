package com.BiblioSpring.controllers;


import com.BiblioSpring.entity.Revista;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BiblioSpring.entity.Alternativa;
import com.BiblioSpring.entity.Fanzine;
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
	
	@RequestMapping ("/Revista")
	public String Revista(Model modelo, Pageable page) {
		modelo.addAttribute("alternativas", repositoryAlt.findAll(page));
		return "Revista";
	}

	@RequestMapping("/AddRevista")
	public String AnadirRevista(Model model, Pageable page) {
		return "AddRevista";
	}

	@RequestMapping("/Revista/nueva")
	public String nuevaRevista(Model model, Revista revista) {
		repository.save(revista);
		return "revista_guardada";
	}

	@RequestMapping("/ver_Revista")
	public String viewRevista(Model model, Pageable page) {

		model.addAttribute("revistas", repository.findAll(page));

		return "ver_Revista";
	}
}
