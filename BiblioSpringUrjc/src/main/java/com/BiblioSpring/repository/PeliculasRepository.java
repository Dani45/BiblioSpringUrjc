package com.BiblioSpring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BiblioSpring.entity.Pelicula;


public interface PeliculasRepository extends JpaRepository<Pelicula, Long> {
	//Pelicula findByNombre(String nombre);
	Optional<Pelicula> findByNombre(String nombre);
	//Optional<Pelicula> findByLugarPublicacion(String lugarPublicacion);
}
