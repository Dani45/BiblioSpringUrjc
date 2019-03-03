package com.ejemplo.controllers;


import com.ejemplo.entity.Fanzine;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejemplo.entity.Alternativa;
import com.ejemplo.repository.AlternativasRepository;
import com.ejemplo.repository.FanzinesRepository;


@Controller
public class FanzineController {
	
	
	@Autowired
	private FanzinesRepository repository;
	@Autowired
	private AlternativasRepository repositoryAlt;

	@SuppressWarnings("deprecation")
	@PostConstruct
	public void init() {
		repository.save(new Fanzine("Fotofobia",2000, 3, "fanzine"));
		repository.save(new Fanzine("Al Abordaje!!",1992, 149, "fanzine"));
	}
	
	@RequestMapping("/Fanzine")
	public String Fanzine(Model model, Pageable page) {
		model.addAttribute("alternativas", repositoryAlt.findAll(page));
		return "Fanzine";
	}
	

	@RequestMapping("/AddFanzine")
	public String AnadirFanzine(Model model, Pageable page) {
		return "AddFanzine";
	}

	

	@RequestMapping("/Fanzine/nuevo")
	public String nuevoFanzine(Model model, Fanzine fanzine) {
		repository.save(fanzine);
		return "fanzine_guardado";
	}

	// vizualizar todas las alternativas que hemos añadido
	@RequestMapping("/ver_Fanzine")
	public String viewFanzine(Model model, Pageable page) {
		model.addAttribute("fanzines", repository.findAll(page));

		return "ver_Fanzine";
	}
	
	
	//METODOS QUE PUEDEN SER AÑADIDOS PERO NO APORTAN FUNCIONALIDAD
	/*@RequestMapping("/nuevoLibro")
	public String addlibro(Model model, Pageable page) {

		model.addAttribute("libro", repository.findAll(page));

		return "nuevoLibro";
	}*/
	
	
	/*@RequestMapping("/Alternativa/{idAlternativa}")
	public String verAlternativaIndependiente(Model model, @PathVariable long idAlternativa) {
		model.addAttribute("alternativas", repository.findById(idAlternativa));
		return "alternativadb";
	}*/

}