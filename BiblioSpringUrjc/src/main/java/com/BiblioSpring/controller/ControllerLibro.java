package com.BiblioSpring.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.BiblioSpring.controller.Libro;

@Controller
public class ControllerLibro {
@Autowired
private LibroRepository repository;

@PostConstruct
public void init() {
	repository.save(new Libro("LA SOCIEDAD DE LOS SOÑADORES INVOLUNTARIOS","AGUALUSA, JOSÉ EDUARDO","1234567891"));
	repository.save(new Libro("LAS LÁGRIMAS","QUIGNARD, PASCAL","1234567891"));
	repository.save(new Libro("ASESINOS DE SERIES","SANCHEZ, ROBERTO","1234567891"));
	repository.save(new Libro("ALEACIÓN DE LEY","SANDERSON, BRANDON","1234567891"));
	repository.save(new Libro("LA LEYENDA DE LA ISLA SIN VOZ","MONTFORT, VANESSA","1234567891"));
	repository.save(new Libro("SECRETOS IMPERFECTOS","HJORTH,MICHAEL","1234567891"));
	repository.save(new Libro("BLUE","STEEL, DANIELLE","1234567891"));
	repository.save(new Libro("MÁS DE TI","SHERIDAN, MIA","1234567891"));
	repository.save(new Libro("EL CEREBRO DEL INVERSOR","BERMEJO, PEDRO","1234567891"));
	repository.save(new Libro("¿QUIÉN SE HA LLEVADO MI MÁSTER?","FUENTES, TOMÁS","1234567891"));
}
	@RequestMapping("/Libro")
	public String libro(Model model) {
		return "Libro";
	}
	@RequestMapping("/Libro/{id}")
	public String verAnuncio(Model model, @PathVariable long id) {
		
		Libro libro = repository.findById(id);
		if(libro!=null) {
        model.addAttribute("libro", libro);
		}
		return "librodb";
	}
	
	
	
}