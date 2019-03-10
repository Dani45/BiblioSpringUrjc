package com;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Team {
	//esto en principio sobraria
	private long idTeam;
	private String nombreEquipo;
	
	@JsonIgnore
	private List<Player> jugadores;
	
	public Team() {
		
	}
	
	public Team (String nombreEquipo, List<Player>jugadores) { //, List<Player>jugadores
		this.nombreEquipo = nombreEquipo;
		this.jugadores = jugadores;
	}

	public long getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(long idTeam) {
		this.idTeam = idTeam;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public List<Player> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Player> jugadores) {
		this.jugadores = jugadores;
	}
	
	
	
}
