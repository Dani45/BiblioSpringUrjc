package com.BiblioSpring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BiblioSpring.entity.Libro;

@Repository
public interface LibrosRepository extends JpaRepository<Libro, Long> {
	Optional<Libro> findByNombre(String nombre);

}
