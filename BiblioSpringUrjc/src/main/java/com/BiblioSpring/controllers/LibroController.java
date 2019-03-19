package com.BiblioSpring.controllers;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.web.csrf.CsrfToken;
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

	@PostConstruct
	public void init() {
		Libro l1=new Libro("LA SOCIEDAD DE LOS SOÑADORES INVOLUNTARIOS", "AGUALUSA, JOSÉ EDUARDO", "Madrid",("01/02/2018"));
		Libro l2=new Libro("LAS LÁGRIMAS", "QUIGNARD, PASCAL", "Madrid",("01/02/2017"));
		Libro l3=new Libro("ASESINOS DE SERIES", "SANCHEZ, ROBERTO", "Madrid", ("01/02/2017"));
		Libro l4=new Libro("ALEACIÓN DE LEY", "SANDERSON, BRANDON", "Madrid", ("01/02/2017"));
		Libro l5=new Libro("LA LEYENDA DE LA ISLA SIN VOZ", "MONTFORT", "Madrid",("01/02/2017"));
		Libro l6=new Libro("SECRETOS IMPERFECTOS", "HJORTH,MICHAEL", "Madrid", ("01/02/2017"));
		Libro l7=new Libro("BLUE", "STEEL, DANIELLE", "Madrid", ("01/02/2017"));
		Libro l8=new Libro("MÁS DE TI", "SHERIDAN, MIA", "Madrid", ("01/02/2017"));
		Libro l9=new Libro("EL CEREBRO DEL INVERSOR", "BERMEJO, PEDRO", "Madrid", ("01/02/2017"));
		Libro l0=new Libro("QUIÉN SE HA LLEVADO MI MÁSTER", "FUENTES, TOMÁS", "Madrid", ("01/02/2017"));
		repository.save(l1);
		repository.save(l2);
		repository.save(l3);
		repository.save(l4);
		repository.save(l5);
		repository.save(l6);
		repository.save(l7);
		repository.save(l8);
		repository.save(l9);
		repository.save(l0);
		Categoria c1 = new Categoria("informatica");
		Categoria c2=new Categoria("Literatura");
		Categoria c3=new Categoria("Administracion");
		l1.getCategorias().add(c2);
		l2.getCategorias().add(c2);
		l3.getCategorias().add(c2);
		l4.getCategorias().add(c2);
		l5.getCategorias().add(c2);
		l6.getCategorias().add(c2);
		l7.getCategorias().add(c2);
		l8.getCategorias().add(c2);
		l9.getCategorias().add(c3);
		l0.getCategorias().add(c3);
		repository2.save(c1);
		repository2.save(c2);
		repository2.save(c3);	
	}
	
	// @GetMapping("/AddLibro")

	@RequestMapping("/BiblioSpring/Libro/AddLibro")
	public String AnadirLibro(Model model, Pageable page, HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());

		return "AddLibro";
	}
/*
	@RequestMapping("/BiblioSpring/Libro/nuevoLibro")
	public String addlibro(Model model, Pageable page, HttpServletRequest request) {

		model.addAttribute("libro", repository.findAll(page));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "nuevoLibro";
	}
*/

	@GetMapping("/BiblioSpring/Libro/nuevo")
	public String nuevoLibro(Model model, @RequestParam String nombre, @RequestParam String autor,
			@RequestParam String lugarPublicacion, @RequestParam String fechaPublicacion, @RequestParam String area,
			Categoria categorias, Libro libros2, HttpServletRequest request,HttpSession usuario) {
		if(usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);		

		}
		if(usuario.getAttribute("admin") != null) {
			usuario.setAttribute("admin", true);		

		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		model.addAttribute("admin", usuario.getAttribute("admin"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);
		try {

			Categoria cat = repository2.findByArea(area);
			if (cat == null) {
				System.out.println("categorias: " + cat);
				cat = repository2.save(categorias);
			}
			Libro libros = new Libro(nombre, autor, lugarPublicacion, fechaPublicacion, cat);

			System.out.println("categorias: " + cat);

			repository.save(libros);
			repository.save(libros2);
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			model.addAttribute("user", request.isUserInRole("USER"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "Index";

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