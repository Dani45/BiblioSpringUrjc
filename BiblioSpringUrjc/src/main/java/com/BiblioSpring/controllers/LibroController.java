package com.BiblioSpring.controllers;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BiblioSpring.entity.Libro;
import com.BiblioSpring.repository.CategoriasRepository;
import com.BiblioSpring.repository.LibrosRepository;

@Controller
public class LibroController {
	@Autowired
	private LibrosRepository repository;
	@Autowired
	private CategoriasRepository repository2;

	@SuppressWarnings("deprecation")
	@PostConstruct
	public void init() {

		repository.save(new Libro("LA SOCIEDAD DE LOS SOÑADORES INVOLUNTARIOS", "AGUALUSA, JOSÉ EDUARDO", "Madrid",
				new Date("01/02/2018")));
		repository.save(new Libro("LAS LÁGRIMAS", "QUIGNARD, PASCAL", "Madrid", new Date("01/02/2018")));
		repository.save(new Libro("ASESINOS DE SERIES", "SANCHEZ, ROBERTO", "Madrid", new Date("01/02/2018")));
		repository.save(new Libro("ALEACIÓN DE LEY", "SANDERSON, BRANDON", "Madrid", new Date("01/02/2018")));
		repository.save(new Libro("LA LEYENDA DE LA ISLA SIN VOZ", "MONTFORT", "Madrid", new Date("01/02/2018")));
		repository.save(new Libro("SECRETOS IMPERFECTOS", "HJORTH,MICHAEL", "Madrid", new Date("01/02/2018")));
		repository.save(new Libro("BLUE", "STEEL, DANIELLE", "Madrid", new Date("01/02/2018")));
		repository.save(new Libro("MÁS DE TI", "SHERIDAN, MIA", "Madrid", new Date("01/02/2018")));
		repository.save(new Libro("EL CEREBRO DEL INVERSOR", "BERMEJO, PEDRO", "Madrid", new Date("01/02/2018")));
		repository
				.save(new Libro("¿QUIÉN SE HA LLEVADO MI MÁSTER?", "FUENTES, TOMÁS", "Madrid", new Date("01/02/2018")));

	}

	@RequestMapping("/Libro")
	public String Libro(Model model, Pageable page) {
		// para mostrar las categorias añadidas automaticamente
		model.addAttribute("categorias", repository2.findAll(page));
		return "Libro";
	}

	@RequestMapping("/AddLibro")
	public String AnadirLibro(Model model, Pageable page) {

		return "AddLibro";
	}

	@RequestMapping("/nuevoLibro")
	public String addlibro(Model model, Pageable page) {

		model.addAttribute("libro", repository.findAll(page));

		return "nuevoLibro";
	}

	@RequestMapping("/Libro/nuevo")
	public String nuevoLibro(Model model, Libro libro) {

		repository.save(libro);

		return "libro_guardado";

	}

	// vizualizar todos los libros añadidos
	@RequestMapping("/ver_libro")
	public String viewLibro(Model model, Pageable page) {

		model.addAttribute("libros", repository.findAll(page));

		return "ver_libro";
	}

//	añadido para enlaces de libro

	@RequestMapping("/Libro/{idLibro}")

	public String verIndependiente(Model model, @PathVariable long idLibro) {
		model.addAttribute("libros", repository.findById(idLibro).get());
		return "librodb";
	}

}