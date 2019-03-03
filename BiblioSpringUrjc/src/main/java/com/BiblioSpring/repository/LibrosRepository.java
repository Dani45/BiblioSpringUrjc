package com.BiblioSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BiblioSpring.entity.Libro;

@Repository
public interface LibrosRepository extends JpaRepository<Libro, Long> {
	Libro findByNombre(String nombre);
}
