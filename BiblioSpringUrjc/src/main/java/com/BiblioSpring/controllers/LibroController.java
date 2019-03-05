package com.BiblioSpring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BiblioSpring.entity.Categoria;
import com.BiblioSpring.entity.Libro;
import com.BiblioSpring.repository.CategoriasRepository;
import com.BiblioSpring.repository.LibrosRepository;

@Controller
public class LibroController {
	@Autowired
	private LibrosRepository repository;
	@Autowired
	private CategoriasRepository repository2;
	/*
	 * @PostConstruct public void init() {
	 * 
	 * // elimina tablas repository.deleteAllInBatch();
	 * repository2.deleteAllInBatch(); // crea nuevoslibros Libro libros = new
	 * Libro("Hibernate", "Learn ", "code", ("12/12/2020")); Libro libros1 = new
	 * Libro("Hibernate1", "Learn 1", "code1", ("12/12/2021")); Libro libros2 = new
	 * Libro("Hibernate2", "Learn 2", "code2", ("12/12/2022")); // Create 2
	 * categorias Categoria categorias = new Categoria("informatica"); Categoria
	 * tag2 = new Categoria("Hibernate"); // add libro referenciado a categoria
	 * libros.getCategorias().add(categorias); libros1.getCategorias().add(tag2);
	 * libros2.getCategorias().add(categorias);
	 * 
	 * categorias.getLibros().add(libros); tag2.getLibros().add(libros1);
	 * categorias.getLibros().add(libros2); repository.save(libros);
	 * repository.save(libros1); repository.save(libros2); }
	 */
	// @GetMapping("/AddLibro")

	@RequestMapping("/BiblioSpring/Libro/AddLibro")
	public String AnadirLibro(Model model, Pageable page, HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "AddLibro";
	}

	@RequestMapping("/BiblioSpring/Libro/nuevoLibro")
	public String addlibro(Model model, Pageable page, HttpServletRequest request) {

		model.addAttribute("libro", repository.findAll(page));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "nuevoLibro";
	}

	// @RequestMapping("/Libro/nuevo")

	@GetMapping("/BiblioSpring/Libro/nuevo")
	public String nuevoLibro(Model model, @RequestParam String nombre, @RequestParam String autor,
			@RequestParam String lugarPublicacion, @RequestParam String fechaPublicacion, @RequestParam String area,
			Categoria categorias, HttpServletRequest request) {
		try {
			
		
			Categoria cat = repository2.findByArea(area);
		if (cat ==null) {
			System.out.println("categorias: " + cat);
			cat = repository2.save(categorias);
		}
			Libro libros = new Libro(nombre, autor, lugarPublicacion, fechaPublicacion, cat);

			System.out.println("categorias: " + cat);

			repository.save(libros);
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			model.addAttribute("user", request.isUserInRole("USER"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "libro_guardado";

	}

	// vizualizar todos los libros añadidos

	// @RequestMapping("/ver_libro")

	@GetMapping("/BiblioSpring/Libro/ver_libro")
	public String viewLibro(Model model, Pageable page, HttpServletRequest request) {

		model.addAttribute("libros", repository.findAll(page));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		return "ver_libro";
	}

	// añadido para enlaces de libro

	// @RequestMapping("/Libro/{idLibro}")

	@GetMapping("/BiblioSpring/Libro/{idLibro}")
	public String verIndependiente(Model model, @PathVariable long idLibro, HttpServletRequest request) {
		model.addAttribute("libros", repository.findById(idLibro).get());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "librodb";
	}

}