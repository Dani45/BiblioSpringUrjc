package com.BiblioSpring.controllers;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

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
	private ContactosRepository repositoryContacto;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FanzinesRepository repositoryFanzine;
	@Autowired
	private PeliculasRepository repositoryPelicula;
	@Autowired
	private RevistasRepository repositoryRevista;

	@PostMapping(value = "/register")
	public String registroCliente(Model model, HttpSession usuario, HttpServletRequest request,
			@RequestParam String name, @RequestParam String email, @RequestParam String password) {
		usuario.setAttribute("name", name);
		usuario.setAttribute("password", password);
		usuario.setAttribute("email", email);
		usuario.setAttribute("registered", true);

		if ((userRepository.findByName(name) == null) && (name != "") && (email != "")) {

			System.out.println(email);

			User nuevoUsuario = new User(name, password, email, "ROLE_USER");

			userRepository.save(nuevoUsuario);

			boolean aux = !(Boolean) usuario.getAttribute("registered");
			model.addAttribute("unregistered", usuario.getAttribute("registered"));
			model.addAttribute("registered", aux);
			String url = "http://localhost:8070/mail/";
			Email nuevoEmail = new Email(name, email);
			RestTemplate rest = new RestTemplate();
			rest.postForEntity(url, nuevoEmail, String.class);
			System.out.println("Datos enviados!");

			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			return ("Index");

		} else {
			model.addAttribute("alert", "Usuario ya existente");
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			return ("new_user");

		}

	}

	@RequestMapping("/new_user")
	public String new_user(Model model, HttpServletRequest request) {
		model.addAttribute("alert", "");
		// atributos del token
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());

		return "new_user";
	}

	@RequestMapping("/")
	public String Index(Model model, HttpServletRequest request, HttpSession usuario) throws ParseException {
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		if (usuario.getAttribute("admin") == null) {
			model.addAttribute("noadmin", true);
		} else {
			model.addAttribute("admin", usuario.getAttribute("admin"));
		}
		model.addAttribute("registered", usuario.getAttribute("registered"));

		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);
		model.addAttribute("Libro", repositoryLibro.findAll());
		model.addAttribute("Categoria", repositoryCategoria.findAll());
		model.addAttribute("Prestamo", repositoryContacto.findAll());

		// model.addAttribute("admin", request.isUserInRole("ADMIN"));
		// model.addAttribute("user", request.isUserInRole("USER"));

		return "Index";
	}

	@RequestMapping("/BiblioSpring/Libro")
	public String Libro(Model model, HttpServletRequest request, HttpSession usuario) {
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		if (usuario.getAttribute("admin") == null) {
			model.addAttribute("noadmin", true);
		} else {
			model.addAttribute("admin", usuario.getAttribute("admin"));
		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);
		model.addAttribute("Libro", repositoryLibro.findAll());
		model.addAttribute("Categoria", repositoryCategoria.findAll());

		// model.addAttribute("admin", request.isUserInRole("ADMIN"));
		// model.addAttribute("user", request.isUserInRole("USER"));

		return "Libro";
	}

	@RequestMapping("/BiblioSpring/Categoria")
	public String Categoria(Model model, Pageable page, HttpServletRequest request, HttpSession usuario) {
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		if (usuario.getAttribute("admin") == null) {
			model.addAttribute("noadmin", true);
		} else {
			model.addAttribute("admin", usuario.getAttribute("admin"));
		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);
		model.addAttribute("Categoria", repositoryCategoria.findAll(page));
		model.addAttribute("Libro", repositoryLibro.findAll());
		return "Categoria";
	}
	// ----------------------------- FIN PERFIL DE USUARIO ----------------------------
	@RequestMapping("/BiblioSpring/Alternativa")
	public String Alternativas(Model model, HttpServletRequest request, HttpSession usuario) {
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		if (usuario.getAttribute("admin") == null) {
			model.addAttribute("noadmin", true);
		} else {
			model.addAttribute("admin", usuario.getAttribute("admin"));
		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);

		// model.addAttribute("admin", request.isUserInRole("ADMIN"));
		// model.addAttribute("user", request.isUserInRole("USER"));

		return "Alternativa";
	}

	@RequestMapping("/BiblioSpring/Contacto")
	public String Contacto(Model model, Pageable page, HttpServletRequest request, HttpSession usuario) {
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		if (usuario.getAttribute("admin") == null) {
			model.addAttribute("noadmin", true);
		} else {
			model.addAttribute("admin", usuario.getAttribute("admin"));
		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());

		return "Contacto";
	}

	@RequestMapping("/BiblioSpring/Administrador")
	public String Administrador(Model model, HttpServletRequest request, HttpSession usuario) {
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);

		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());

		return "Administrador";
	}

	@GetMapping("/BiblioSpring/Login")
	public String Login(Model model, HttpServletRequest request) {
		model.addAttribute("alert", "");

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		return "Login";
	}

	@RequestMapping("/BiblioSpring/login/{loged}")
	public String LoginError(Model model, UsernamePasswordAuthenticationToken user, HttpSession usuario,
			@PathVariable String loged, HttpServletRequest request) {
		if (loged.equals("true")) {

			User usur = userRepository.findByName(user.getName());

			usuario.setAttribute("registered", true);
			usuario.setAttribute("name", usur.getName());
			usuario.setAttribute("password", usur.getPasswordHash());
			usuario.setAttribute("email", usur.getEmail());
			if (usur.getRoles().contains("ROLE_ADMIN")) {
				usuario.setAttribute("admin", true);
				model.addAttribute("admin", usuario.getAttribute("admin"));
				boolean aux2 = !(Boolean) usuario.getAttribute("admin");
				model.addAttribute("noadmin", aux2);
			}
			model.addAttribute("registered", usuario.getAttribute("registered"));
			boolean aux = !(Boolean) usuario.getAttribute("registered");
			model.addAttribute("unregistered", aux);
			model.addAttribute("Libro", repositoryLibro.findAll());
			model.addAttribute("Categoria", repositoryCategoria.findAll());
			model.addAttribute("Prestamo", repositoryContacto.findAll());
			CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());

			return "Index";
		}
		model.addAttribute("alert", "User or password incorrect");
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());

		return "Login";
	}

	@GetMapping("/BiblioSpring/Logout")
	public String Salir(Model model, HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());

		return "Logout";
	}

	@RequestMapping("/BiblioSpring/Fanzine")
	public String Fanzine(Model model, HttpServletRequest request, HttpSession usuario) {

		model.addAttribute("fanzine",repositoryFanzine.findAll());
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		if (usuario.getAttribute("admin") == null) {
			model.addAttribute("noadmin", true);
		} else {
			model.addAttribute("admin", usuario.getAttribute("admin"));
		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "ver_Fanzine";
	}

	@RequestMapping("/BiblioSpring/Pelicula")
	public String Pelicula(Model model, HttpServletRequest request, HttpSession usuario) {

		model.addAttribute("pelicula", repositoryPelicula.findAll());
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		if (usuario.getAttribute("admin") == null) {
			model.addAttribute("noadmin", true);
		} else {
			model.addAttribute("admin", usuario.getAttribute("admin"));
		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "ver_Pelicula";
	}

	@RequestMapping("/BiblioSpring/Revista")
	public String Revista(Model model, HttpServletRequest request, HttpSession usuario) {

		model.addAttribute("Revista", repositoryRevista.findAll());
		if (usuario.getAttribute("registered") == null) {
			usuario.setAttribute("registered", false);

		}
		if (usuario.getAttribute("admin") == null) {
			model.addAttribute("noadmin", true);
		} else {
			model.addAttribute("admin", usuario.getAttribute("admin"));
		}
		model.addAttribute("registered", usuario.getAttribute("registered"));
		boolean aux = !(Boolean) usuario.getAttribute("registered");
		model.addAttribute("unregistered", aux);
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("user", request.isUserInRole("USER"));

		return "ver_Revista";
	}

}