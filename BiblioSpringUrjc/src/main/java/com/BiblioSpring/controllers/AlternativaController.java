package com.BiblioSpring.controllers;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BiblioSpring.entity.Categoria;
import com.BiblioSpring.entity.Fanzine;
import com.BiblioSpring.entity.Pelicula;
import com.BiblioSpring.entity.Revista;
import com.BiblioSpring.repository.FanzinesRepository;
import com.BiblioSpring.repository.PeliculasRepository;
import com.BiblioSpring.repository.RevistasRepository;


@Controller
public class AlternativaController {
	
	
	@Autowired
	private FanzinesRepository repositoryFanzine;
	@Autowired
	private PeliculasRepository repositoryPelicula;
	@Autowired
	private RevistasRepository repositoryRevista;

	
	@SuppressWarnings("deprecation")
	@PostConstruct
	public void init() {
		repositoryFanzine.save(new Fanzine("OnePieze",2000, 3, "Japon"));
		repositoryFanzine.save(new Fanzine("Naruto",1992, 149, "Japon"));
		repositoryFanzine.save(new Fanzine("Dragon Ball",1992, 149, "Japon"));
		repositoryPelicula.save(new Pelicula("Avatar",2000,"Austria"));
		repositoryPelicula.save(new Pelicula("La última canción",2008, "Inglaterra"));
		repositoryRevista.save(new Revista("Pronto",1964,1));
	}
	
	@RequestMapping("/BiblioSpring/Alternativa/buscar_Alternativa")
	public String verAlternativaPorNombre(Model model, HttpServletRequest request,@RequestParam int valor, @RequestParam String nombre,HttpSession usuario) {
			if(usuario.getAttribute("registered") == null) {
				usuario.setAttribute("registered", false);		

			}
			if(usuario.getAttribute("admin") == null) {
				model.addAttribute("noadmin", true);
			}else {
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
			model.addAttribute("Revista",r);
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			model.addAttribute("user", request.isUserInRole("USER"));

			return "ver_Revista";
			
			
		}
		if(valor==3) {
			Pelicula p=repositoryPelicula.findByNombre(nombre);
			if(p==null) {
				return "Pagina_Error";
			}
			model.addAttribute("pelicula",p);
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			model.addAttribute("user", request.isUserInRole("USER"));

			return "ver_Pelicula";
		}
		if(valor==4) {
			Fanzine f=repositoryFanzine.findByNombre(nombre);
			if(f==null) {
				return "Pagina_Error";
			}
			model.addAttribute("fanzine",f);
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			model.addAttribute("user", request.isUserInRole("USER"));

			return "ver_Fanzine";
		}

		return "Alternativa";
	}
	@RequestMapping("/BiblioSpring/Pelicula/AddPelicula")
	public String AnadirPelicula(Model model, Pageable page,HttpServletRequest request) {
		return "AddPelicula";
	}

	@RequestMapping("/BiblioSpring/Pelicula/nueva")
	public String nuevaPelicula(Model model, Pelicula pelicula,HttpServletRequest request, HttpSession usuario) {

		repositoryPelicula.save(pelicula);
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		if (usuario.getAttribute("admin") != null) {
			usuario.setAttribute("admin", true);

		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		model.addAttribute("admin", usuario.getAttribute("admin"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);
		model.addAttribute("pelicula",repositoryPelicula.findAll());

		return "ver_Pelicula";

	}
	
	@Transactional
	@RequestMapping("/BiblioSpring/Pelicula/DeletePelicula")
	public String EliminarPelicula(Model model, Pageable page, HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		return "DeletePelicula";
	}
	
	@Transactional
	@RequestMapping("/BiblioSpring/Pelicula/Pelicula_borrada")
	public String peliculaBorrada(Model model, HttpServletRequest request,HttpSession usuario, @RequestParam String nombre) {

		repositoryPelicula.deleteByNombre(nombre);
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		if (usuario.getAttribute("admin") != null) {
			usuario.setAttribute("admin", true);

		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		model.addAttribute("admin", usuario.getAttribute("admin"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);
		model.addAttribute("pelicula",repositoryPelicula.findAll());

		return "ver_Pelicula";
	}
	@Transactional
	@RequestMapping("/BiblioSpring/Revista/DeleteRevista")
	public String EliminarRevista(Model model, Pageable page, HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		return "DeleteRevista";
	}
	
	@Transactional
	@RequestMapping("/BiblioSpring/Revista/Revista_borrada")
	public String revistaBorrada(Model model, HttpServletRequest request,HttpSession usuario, @RequestParam String nombre) {

		 repositoryRevista.deleteByNombre(nombre);
		 if (usuario.getAttribute("registered") == null) {
				usuario.setAttribute("registered", false);

			}
			if (usuario.getAttribute("admin") != null) {
				usuario.setAttribute("admin", true);

			}
			model.addAttribute("registered", usuario.getAttribute("registered"));
			model.addAttribute("admin", usuario.getAttribute("admin"));
			boolean aux = !(Boolean) usuario.getAttribute("registered");
			model.addAttribute("unregistered", aux);
			model.addAttribute("Revista",repositoryRevista.findAll());
			return "ver_Revista";
		}
	
	@RequestMapping("/BiblioSpring/Revista/AddRevista")
	public String AnadirRevista(Model model, Pageable page) {
		return "AddRevista";
	}

	@RequestMapping("/BiblioSpring/Revista/nueva")
	public String nuevaRevista(Model model, Revista revista,HttpSession usuario) {
		repositoryRevista.save(revista);
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		if (usuario.getAttribute("admin") != null) {
			usuario.setAttribute("admin", true);

		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		model.addAttribute("admin", usuario.getAttribute("admin"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);
		model.addAttribute("Revista",repositoryRevista.findAll());
		return "ver_Revista";
		}

	
	@Transactional
	@RequestMapping("/BiblioSpring/Fanzine/DeleteFanzine")
	public String EliminarFanzine(Model model, Pageable page, HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		return "DeleteFanzine";
	}
	
	@Transactional
	@RequestMapping("/BiblioSpring/Fanzine/Fanzine_borrado")
	public String fanzineBorrado(Model model, HttpServletRequest request,HttpSession usuario, @RequestParam String nombre) {

		 repositoryFanzine.deleteByNombre(nombre);
		 if (usuario.getAttribute("registered") == null) {
				usuario.setAttribute("registered", false);

			}
			if (usuario.getAttribute("admin") != null) {
				usuario.setAttribute("admin", true);

			}
			model.addAttribute("registered", usuario.getAttribute("registered"));
			model.addAttribute("admin", usuario.getAttribute("admin"));
			boolean aux = !(Boolean) usuario.getAttribute("registered");
			model.addAttribute("unregistered", aux);
			model.addAttribute("fanzine",repositoryFanzine.findAll());
			return "ver_Fanzine";
		}
	
	
	@RequestMapping("/BiblioSpring/Fanzine/AddFanzine")
	public String AnadirFanzine(Model model, Pageable page, HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		return "AddFanzine";
	}

	@RequestMapping("/BiblioSpring/Fanzine/nuevo")
	public String nuevoFanzine(Model model, Fanzine fanzine,HttpSession usuario, HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		repositoryFanzine.save(fanzine);
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		if (usuario.getAttribute("admin") != null) {
			usuario.setAttribute("admin", true);

		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		model.addAttribute("admin", usuario.getAttribute("admin"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);
		model.addAttribute("fanzine",repositoryFanzine.findAll());
		return "ver_Fanzine";
	}
	


}
