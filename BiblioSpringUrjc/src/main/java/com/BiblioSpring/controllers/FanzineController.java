package com.BiblioSpring.controllers;


import com.BiblioSpring.entity.Fanzine;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BiblioSpring.entity.Alternativa;
import com.BiblioSpring.repository.AlternativasRepository;
import com.BiblioSpring.repository.FanzinesRepository;


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
	
	
	@RequestMapping("/BiblioSpring/Fanzine/buscar_Fanzine")
	public String verFanzinePorNombre(Model model, HttpServletRequest request, @RequestParam String nombre) {

		model.addAttribute("fanzines", repository.findByNombre(nombre).get());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "ver_Fanzine";
	}
	
	
	@RequestMapping("/BiblioSpring/Fanzine/AddFanzine")
	public String AnadirFanzine(Model model, Pageable page, HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		return "AddFanzine";
	}

	@RequestMapping("/BiblioSpring/Fanzine/nuevo")
	public String nuevoFanzine(Model model, Fanzine fanzine, HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		repository.save(fanzine);
		return "fanzine_guardado";
	}
	
	// vizualizar todas las alternativas que hemos añadido
	@RequestMapping("/BiblioSpring/Fanzine/ver_Fanzine")
	public String viewFanzine(Model model, HttpServletRequest request, Pageable page) {
		model.addAttribute("fanzines", repository.findAll(page));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "ver_Fanzine";	
	}
	
	//COPIADO TAL CUAL DE LIBRO
	/*@GetMapping("/BiblioSpring/Fanzine/nuevo")
	public String nuevoFanzine(Model model, @RequestParam String nombre, @RequestParam Integer ano,
			@RequestParam Integer numero, @RequestParam String lugarPublicacion, @RequestParam String alternativa,
			Alternativa alternativas, Fanzine fanzineAux, HttpServletRequest request) {
		
		try {
			repositoryAlt.findByAlternativa(alternativa);
			Alternativa alt = repositoryAlt.findByAlternativa(alternativa);
			if (alt == null) {
				System.out.println("Alternativas: " + alt);
				alt = repositoryAlt.save(alternativas);
			}
			
			Fanzine fanzine = new Fanzine(nombre, ano, numero, lugarPublicacion);

			System.out.println("Alternativas: " + alt);

			repository.save(fanzine);
			repository.save(fanzineAux);
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			model.addAttribute("user", request.isUserInRole("USER"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "fanzine_guardado";

	}*/


	
	/*
	 * @RequestMapping("/BiblioSpring/Fanzine/buscar_Fanzine")
	public String verFanzinePorNombre(Model model, HttpServletRequest request, @RequestParam String lugarPublicacion) {

		model.addAttribute("fanzines", repository.findByLugarPublicacion(lugarPublicacion).get());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "ver_Fanzine";
	}
	 */
	
	
	//METODOS QUE PUEDEN SER AÑADIDOS PERO NO APORTAN FUNCIONALIDAD
	/*@RequestMapping("/nuevoLibro")
	public String addlibro(Model model, Pageable page) {

		model.addAttribute("libro", repository.findAll(page));

		return "nuevoLibro";
	}
	
	
	@RequestMapping("/Fanzine")
	public String Fanzine(Model model, Pageable page) {
		model.addAttribute("alternativas", repositoryAlt.findAll(page));
		return "Fanzine";
	}
	
	
	
	@RequestMapping("/Alternativa/{idAlternativa}")
	public String verAlternativaIndependiente(Model model, @PathVariable long idAlternativa) {
		model.addAttribute("alternativas", repository.findById(idAlternativa));
		return "alternativadb";
	}*/

}