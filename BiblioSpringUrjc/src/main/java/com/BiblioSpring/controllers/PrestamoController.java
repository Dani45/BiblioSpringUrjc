package com.BiblioSpring.controllers;
import com.BiblioSpring.entity.*;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.NoSuchElementException;

import com.BiblioSpring.repository.CategoriasRepository;
import com.BiblioSpring.repository.ContactosRepository;
import com.BiblioSpring.repository.FanzinesRepository;
import com.BiblioSpring.repository.LibrosRepository;
import com.BiblioSpring.repository.PeliculasRepository;
import com.BiblioSpring.repository.RevistasRepository;
import com.BiblioSpring.repository.UserRepository;
@Controller
public class PrestamoController {
	@Autowired
	private LibrosRepository repositoryLibro;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FanzinesRepository repositoryFanzine;
	@Autowired
	private PeliculasRepository repositoryPelicula;
	@Autowired
	private RevistasRepository repositoryRevista;
	@RequestMapping("/BiblioSpring/Prestamo")
	public String Prestamo(Model model, HttpServletRequest request, HttpSession usuario) {
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		if (usuario.getAttribute("admin") != null) {
			model.addAttribute("admin", usuario.getAttribute("admin"));
		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "Prestamo";
	}
	@RequestMapping("/BiblioSpring/Prestamo/Controller")
	public String PrestamoControlador(Model model, HttpServletRequest request, HttpSession usuario,
			@RequestParam int valor,@RequestParam String nombre,@RequestParam String fechaPrestamo) {
		
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);
		}
		String name = (String) usuario.getAttribute("name");
		String date = (String) usuario.getAttribute("date");
		String icon = (String) usuario.getAttribute("icon");
		String email = (String) usuario.getAttribute("email");
		
		// se mandan los datos al modelo
		model.addAttribute("name", name);
		model.addAttribute("password", "*******");
		model.addAttribute("email", email);
		model.addAttribute("alert"," ");	
		User u=userRepository.findByName(name);
		if (usuario.getAttribute("admin") != null) {
			model.addAttribute("admin", usuario.getAttribute("admin"));
		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);
		if(valor==2) {
			
			Revista r=repositoryRevista.findByNombre(nombre);
			if(r==null) {
				return "Pagina_Error";
			}
		    r.setFechaPrestamo(fechaPrestamo);
			r.setUser(u);
			repositoryRevista.save(r);
			u.addRevistas(r);
			userRepository.save(u);
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			model.addAttribute("user", request.isUserInRole("USER"));
		}
		if(valor==3) {
			Pelicula p=repositoryPelicula.findByNombre(nombre);
			if(p==null) {
				return "Pagina_Error";
			}
			p.setFechaPrestamo(fechaPrestamo);
			p.setUser(u);
			repositoryPelicula.save(p);
			u.addPeliculas(p);
			userRepository.save(u);
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			model.addAttribute("user", request.isUserInRole("USER"));

		}
		if(valor==4) {
			Fanzine f=repositoryFanzine.findByNombre(nombre);
			if(f==null) {
				return "Pagina_Error";
			}
			f.setFechaPrestamo(fechaPrestamo);
			f.setUser(u);
			repositoryFanzine.save(f);
			u.addFancines(f);
			userRepository.save(u);
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			model.addAttribute("user", request.isUserInRole("USER"));

		}
		if(valor==5) {
			Libro l=repositoryLibro.findByNombre(name);
			if(l==null) {
				return "Pagina_Error";
			}
			l.setFechaPrestamo(fechaPrestamo);
			l.setUser(u);
			repositoryLibro.save(l);
			u.addlibros(l);
			userRepository.save(u);
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			model.addAttribute("user", request.isUserInRole("USER"));
		}
		model.addAttribute("libros", u.getLibros());
		model.addAttribute("peliculas", u.getPeliculas());
		model.addAttribute("fancines", u.getFancines());
		model.addAttribute("revistas", u.getRevistas());

		return "profile";
	}
	@RequestMapping("/BiblioSpring/profile")
	public String init (Model model, HttpSession usuario, HttpServletRequest request) {		
		// se cogen del usuario los atributos
		String name = (String) usuario.getAttribute("name");
		String date = (String) usuario.getAttribute("date");
		String icon = (String) usuario.getAttribute("icon");
		String email = (String) usuario.getAttribute("email");
		
		// se mandan los datos al modelo
		model.addAttribute("name", name);
		model.addAttribute("password", "*******");
		model.addAttribute("email", email);
		model.addAttribute("alert"," ");	

		// se muestra el link de iniciar/registrar usuario si es false
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		User u=userRepository.findByName(name);
		if (usuario.getAttribute("admin") == null) {
			model.addAttribute("noadmin", true);
		} else {
			model.addAttribute("admin", usuario.getAttribute("admin"));
		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);	
		model.addAttribute("libros", u.getLibros());
		model.addAttribute("peliculas", u.getPeliculas());
		model.addAttribute("fancines", u.getFancines());
		model.addAttribute("revistas", u.getRevistas());
		
		// se devuelve el nombre de la lista, siendo el PERFIL del usuario
		return "profile";
	}
}
