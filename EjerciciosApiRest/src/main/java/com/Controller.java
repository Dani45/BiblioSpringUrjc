package com;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RestController
public class Controller {
	// private User destinatario;
	// private String mensaje;
	// private float deuda;
	
	@Autowired
	private ServiceTeam serviceTeam;
	
	/*@GetMapping("/jugadores")
	public Player jugadores() {
		return new Player("Avatar","Jugador");
	}*/
	
	@RequestMapping (value = "/teams", method = RequestMethod.GET)
	public List<Team> getTeams() {
		return serviceTeam.getEquipos();
	}
	
	@RequestMapping (value = "/team/{teamName}", method = RequestMethod.GET)
	public Team getTeam(@PathVariable ("teamName") String teamName) {
		return serviceTeam.getEquipo(teamName);
	}
	
	/*@RequestMapping (value = "/teams", method = RequestMethod.POST)
	public ResponseEntity <Boolean> addTeam (@RequestBody Team team){
		serviceTeam.addTeam(team);
		return new ResponseEntity<Boolean> (true, HttpStatus.CREATED);
	}*/
}
