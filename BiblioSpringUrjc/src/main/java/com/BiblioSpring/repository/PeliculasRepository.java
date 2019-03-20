package com.BiblioSpring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.BiblioSpring.entity.Fanzine;
import com.BiblioSpring.entity.Pelicula;


public interface PeliculasRepository extends JpaRepository<Pelicula, Long>, CrudRepository<Pelicula,Long> {
	Optional<Pelicula> findByNombre(String nombre);
	Optional<Pelicula> deleteByNombre(String nombre);
}
