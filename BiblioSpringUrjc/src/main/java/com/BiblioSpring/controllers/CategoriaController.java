package com.BiblioSpring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.BiblioSpring.entity.Categoria;
import com.BiblioSpring.entity.Libro;
import com.BiblioSpring.repository.CategoriasRepository;

@Controller
public class CategoriaController {
	@Autowired
	private CategoriasRepository repository;

	public Libro libros;

	// añadir
	@RequestMapping("/BiblioSpring/Categoria/AddCategoria")
	public String Addcategoria(Model model, Pageable page,HttpServletRequest request) {

		model.addAttribute("categoria", repository.findAll(page));
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());

		return "AddCategoria";
	}

	// crear nueva
	@RequestMapping("/BiblioSpring/Categoria/nuevo")
	public String nuevaCategoria(Model model, Categoria categoria) {
		// guardar parametro
		repository.save(categoria);

		return "categoria_guardado";

	}

	@RequestMapping("/BiblioSpring/DeleteCategoria")
	public String deleteCategoria(Model model, Pageable page) {

		model.addAttribute("categorias", repository.findAll(page));
		return "DeleteCategoria";
	}

	// eliminar

	@RequestMapping("/BiblioSpring/Categoria/delete")
	public String eliminarcategoria(Model model, Long idCategoria) {
		repository.deleteById(idCategoria);

		return "delete_borrado";
	}
	@GetMapping("/BiblioSpring/Categoria/{idCategoria}")
	public String verIndependiente(Model model, @PathVariable long idCategoria, HttpServletRequest request) {
		model.addAttribute("categorias", repository.findById(idCategoria).get());
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "categoriabd";
	}
}