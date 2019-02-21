package com.ejemplo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.entity.Libro;

public interface LibrosRepository extends JpaRepository<Libro, Long> {
	// Optional<Libro> findById(Long idLibro);
}
