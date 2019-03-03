package com.BiblioSpring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.BiblioSpring.repository.*;

@Controller
public class PrincipalController {
	@Autowired
	private LibrosRepository repositoryLibro;
	@Autowired
	private CategoriasRepository repositoryCategoria;
	@Autowired
	private AlternativasRepository repositoryAlternativas;
	@Autowired
	private ContactosRepository repositoryContacto;

	@RequestMapping("/BiblioSpring")
	public String Index(Model model, HttpServletRequest request) {

		model.addAttribute("Libro", repositoryLibro.findAll());
		model.addAttribute("Categoria", repositoryCategoria.findAll());
		model.addAttribute("Alternativas", repositoryAlternativas.findAll());
		model.addAttribute("Prestamo", repositoryContacto.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "Index";
	}

	@RequestMapping("/BiblioSpring/Libro")
	public String Libro(Model model, HttpServletRequest request) {

		model.addAttribute("Libro", repositoryLibro.findAll());
		model.addAttribute("Categoria", repositoryCategoria.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "Libro";
	}

	@RequestMapping("/BiblioSpring/Categoria")
	public String Categoria(Model model, Pageable page, HttpServletRequest request) {

		model.addAttribute("Categoria", repositoryCategoria.findAll(page));

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "Categoria";
	}

	@RequestMapping("/BiblioSpring/Alternativa")
	public String Alternativas(Model model, HttpServletRequest request) {

		model.addAttribute("Alternativa", repositoryAlternativas.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "Alternativa";
	}

	@RequestMapping("/BiblioSpring/Prestamo")
	public String Prestamo(Model model, HttpServletRequest request) {

		model.addAttribute("Prestamo", repositoryContacto.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "Prestamo";
	}

	@RequestMapping("/BiblioSpring/Contacto")
	public String Contacto(Model model, Pageable page, HttpServletRequest request) {

		// model.addAttribute("Contacto", repositoryContacto.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "Contacto";
	}

	@RequestMapping("/BiblioSpring/Administrador")
	public String Administrador(Model model, HttpServletRequest request) {
		/// modificar pra gestionarlo mejor
		// model.addAttribute("Libro", repositoryLibro.findAll());
		// model.addAttribute("Categoria", repositoryCategoria.findAll());
		// model.addAttribute("Alternativas", repositoryAlternativas.findAll());
		// model.addAttribute("Prestamo", repositoryContacto.findAll());

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "Administrador";
	}

	@GetMapping("/BiblioSpring/Login")
	public String Login(Model model, HttpServletRequest request) {

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "Login";
	}

	@GetMapping("/BiblioSpring/Register")
	public String Register(Model model, HttpServletRequest request) {

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "Register";
	}

	@RequestMapping("/BiblioSpring/LoginError")
	public String LoginError(Model model, HttpServletRequest request) {

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "LoginError";
	}

	@GetMapping("/BiblioSpring/Logout")
	public String Salir(Model model, HttpServletRequest request) {

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "/Logout";
	}

}