package com.BiblioSpring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BiblioSpring.entity.Email;
import com.BiblioSpring.entity.User;
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
	@Autowired
	private UserRepository userRepository;		
	
	// ----------------------------- REGISTRAR NUEVO USUARIO --------------------------
	/*
	@RequestMapping("/new_user")
	public String new_user (Model model, HttpServletRequest request) {
		model.addAttribute("alert", " ");
		// atributos del token
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		
		return "/BiblioSpring/Libro/AddLibro";
	}
	*/
	@PostMapping(value = "/register")
public String registroCliente(Model model, HttpServletRequest request,@RequestParam String name,@RequestParam String email,@RequestParam String password) {
		
		if((userRepository.findByName(name) == null) && (name!="") && (email!="")) {
			
			System.out.println(email);
			
			User nuevoUsuario = new User (name, password,email,  "ROLE_USER");
			Email nuevoEmail = new Email(name,email);
			userRepository.save(nuevoUsuario);
			
			/*
		    String url= "http://localhost:8070/mail/";
		    RestTemplate rest = new RestTemplate();	
		    rest.postForLocation(url, nuevoEmail);
		    System.out.println("Datos enviados!");
			*/
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			return ("/BiblioSpring");
			
		} else {
			model.addAttribute("alert", "Usuario ya existente");
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			return("/new_user");
			
		}
	
	}

	@RequestMapping("/new_user")
	public String new_user (Model model, HttpServletRequest request) {
		model.addAttribute("alert", "");
		// atributos del token
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		
		return "new_user";
	}
	@RequestMapping("/BiblioSpring")
	public String Index(Model model, HttpServletRequest request) {

		model.addAttribute("Libro", repositoryLibro.findAll());
		model.addAttribute("Categoria", repositoryCategoria.findAll());
		model.addAttribute("Alternativas", repositoryAlternativas.findAll());
		model.addAttribute("Prestamo", repositoryContacto.findAll());

		// model.addAttribute("admin", request.isUserInRole("ADMIN"));
		// model.addAttribute("user", request.isUserInRole("USER"));

		return "Index";
	}

	@RequestMapping("/BiblioSpring/Libro")
	public String Libro(Model model, HttpServletRequest request) {

		model.addAttribute("Libro", repositoryLibro.findAll());
		model.addAttribute("Categoria", repositoryCategoria.findAll());

		// model.addAttribute("admin", request.isUserInRole("ADMIN"));
		// model.addAttribute("user", request.isUserInRole("USER"));

		return "Libro";
	}

	@RequestMapping("/BiblioSpring/Categoria")
	public String Categoria(Model model, Pageable page, HttpServletRequest request) {

		model.addAttribute("Categoria", repositoryCategoria.findAll(page));

		// model.addAttribute("admin", request.isUserInRole("ADMIN"));
		// model.addAttribute("user", request.isUserInRole("USER"));

		return "Categoria";
	}

	@RequestMapping("/BiblioSpring/Alternativa")
	public String Alternativas(Model model, HttpServletRequest request) {

		model.addAttribute("Alternativa", repositoryAlternativas.findAll());

		// model.addAttribute("admin", request.isUserInRole("ADMIN"));
		// model.addAttribute("user", request.isUserInRole("USER"));

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

		// model.addAttribute("admin", request.isUserInRole("ADMIN"));
		// model.addAttribute("user", request.isUserInRole("USER"));

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
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
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