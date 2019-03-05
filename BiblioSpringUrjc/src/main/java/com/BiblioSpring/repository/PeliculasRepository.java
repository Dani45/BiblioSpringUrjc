package com.BiblioSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BiblioSpring.entity.Pelicula;


public interface PeliculasRepository extends JpaRepository<Pelicula, Long> {

}
