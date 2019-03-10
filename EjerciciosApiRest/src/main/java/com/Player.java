package com;

import java.util.List;

public class Player {
	//Este sería el User con
	// private long idUsuario;
	// private String nombre;
	// private String email;
	
	private long idPlayer;
	private String nombreJugador;
	private String apodo;
	
	public Player() {
		
	}
	
	public Player(String nombreJugador, String apodo) {
		this.nombreJugador = nombreJugador;
		this.apodo = apodo;
	}
	
	public String getNombreJugador() {
		return nombreJugador;
	}
	
	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	
	
}
