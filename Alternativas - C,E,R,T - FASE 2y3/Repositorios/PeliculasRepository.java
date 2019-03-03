package com.ejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.entity.Pelicula;

public interface PeliculasRepository extends JpaRepository<Pelicula, Long> {

}
