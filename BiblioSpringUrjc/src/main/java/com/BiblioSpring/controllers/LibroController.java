package com.BiblioSpring.controllers;

import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@PostConstruct
	public void init() {

		// elimina tablas
		repository.deleteAllInBatch();
		repository2.deleteAllInBatch();
		// crea nuevoslibros
		Libro libros = new Libro("Hibernate", "Learn ", "code", new Date("12/12/2020"));
		Libro libros1 = new Libro("Hibernate1", "Learn 1", "code1", new Date("12/12/2021"));
		Libro libros2 = new Libro("Hibernate2", "Learn 2", "code2", new Date("12/12/2022"));
		// Create 2 categorias
		Categoria categorias = new Categoria("informatica");
		Categoria tag2 = new Categoria("Hibernate");
		// add libro referenciado a categoria
		libros.getCategorias().add(categorias);
		libros1.getCategorias().add(tag2);
		libros2.getCategorias().add(categorias);

		categorias.getLibros().add(libros);
		tag2.getLibros().add(libros1);
		categorias.getLibros().add(libros2);
		repository.save(libros);
		repository.save(libros1);
		repository.save(libros2);
	}

	@RequestMapping("/Libro")
	public String Libro(Model model, Pageable page) {
		// para mostrar las categorias añadidas automaticamente
		model.addAttribute("categorias", repository2.findAll(page));

		return "Libro";
	}

	// @GetMapping("/AddLibro")

	@RequestMapping("/AddLibro")
	public String AnadirLibro(Model model, Pageable page) {

		return "AddLibro";
	}

	@RequestMapping("/nuevoLibro")
	public String addlibro(Model model, Pageable page) {

		model.addAttribute("libro", repository.findAll(page));

		return "nuevoLibro";
	}

	// @RequestMapping("/Libro/nuevo")

	@GetMapping("/Libro/nuevo")
	public String nuevoLibro(Model model, Libro libro, Categoria categorias) {
		repository.save(libro);
		return "libro_guardado";

	}

	// vizualizar todos los libros añadidos

	// @RequestMapping("/ver_libro")

	@GetMapping("/ver_libro")
	public String viewLibro(Model model, Pageable page) {

		model.addAttribute("libros", repository.findAll(page));
		return "ver_libro";
	}

	// añadido para enlaces de libro

	// @RequestMapping("/Libro/{idLibro}")

	@GetMapping("/Libro/{idLibro}")
	public String verIndependiente(Model model, @PathVariable long idLibro) {
		model.addAttribute("libros", repository.findById(idLibro).get());

		return "librodb";
	}

}