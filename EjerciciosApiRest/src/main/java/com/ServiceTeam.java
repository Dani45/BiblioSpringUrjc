package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service
@Component
public class ServiceTeam {
	
	//La clave sería el mensaje y el valor sería el destinatario
	private Map<String, Team> mapaEquipos  = new HashMap<String,Team>();
	
	public ServiceTeam() {
		crearEquipos();
	}
	
	/*public ServiceTeam(List<Team> equipos, Team equipo) {
		this.equipo = equipo;
		this.equipos = equipos;
		this.addTeam(new Team("equipo4"));
		this.addTeam(new Team("equipo5"));
		this.addTeam(new Team("equipo6"));
		
		equipos.add(new Team("Equipo1"));
		equipos.add(new Team("Equipo2"));
		equipos.add(new Team("Equipo3"));
	}*/
	
	
	//todos estos equipos y jugadores lo tendríamos que coger del repositorio
	//podríamos crear un mensaje predeterminado y que envíe siempre el mismo
	public void crearEquipos() {
		List<Team> equipos = new ArrayList<Team>();
		
		//franja del Equipo 1
		Player jugador1 = new Player("Jugador1","ApodoJugador1");
		Player jugador2 = new Player("Jugador2","ApodoJugador2");
		
		List<Player> jugadores1y2 = new ArrayList<Player>();
		
		jugadores1y2.add(jugador1);
		jugadores1y2.add(jugador2);
		
		Team equipo1 = new Team("Equipo1",jugadores1y2);
		equipos.add(equipo1); 
		
		//franja del Equipo 2
		Player jugador3 = new Player("Jugador3","ApodoJugador3");
		Player jugador4 = new Player("Jugador4","ApodoJugador4");
		
		List<Player> jugadores3y4 = new ArrayList<Player>();
		
		jugadores3y4.add(jugador3);
		jugadores3y4.add(jugador4);
		
		Team equipo2 = new Team("Equipo2",jugadores3y4);
		equipos.add(equipo2); 
		
		//asocio el nombre del equipo con el objeto Team
		for (Team team: equipos) {
			mapaEquipos.put(team.getNombreEquipo(), team);
		}
	}

	public List<Team> getEquipos() {
		return new ArrayList<Team> (mapaEquipos.values());
	}

	public Team getEquipo(String nombre) {
		return mapaEquipos.get(nombre);
	}

	/*public void addTeam (Team team) {
		equipos.add(team);
	}*/
	
	
	
}
