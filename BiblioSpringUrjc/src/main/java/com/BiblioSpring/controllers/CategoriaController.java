package com.BiblioSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BiblioSpring.entity.Categoria;
import com.BiblioSpring.entity.Libro;
import com.BiblioSpring.repository.CategoriasRepository;

@Controller
public class CategoriaController {
	@Autowired
	private CategoriasRepository repository;

	public Libro libros;

	@RequestMapping("/Categoria")
	public String viewcategoria(Model model, Pageable page) {
		// mostrar
		model.addAttribute("categorias", repository.findAll(page));

		return "Categoria";
	}

	// añadir
	@RequestMapping("/AddCategoria")
	public String Addcategoria(Model model, Pageable page) {

		model.addAttribute("categoria", repository.findAll(page));

		return "AddCategoria";
	}

	// crear nueva
	@RequestMapping("/Categoria/nuevo")
	public String nuevaCategoria(Model model, Categoria categoria) {
		// guardar parametro
		repository.save(categoria);

		return "categoria_guardado";

	}

	@RequestMapping("/DeleteCategoria")
	public String deleteCategoria(Model model, Pageable page) {

		model.addAttribute("categorias", repository.findAll(page));
		return "DeleteCategoria";
	}

	// eliminar

	@RequestMapping("/Categoria/delete")
	public String eliminarcategoria(Model model, Long idCategoria) {
		repository.deleteById(idCategoria);

		return "delete_borrado";
	}
}