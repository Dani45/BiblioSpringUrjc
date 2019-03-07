package com.BiblioSpring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BiblioSpring.entity.Fanzine;

public interface FanzinesRepository extends JpaRepository<Fanzine, Long> {
	Optional<Fanzine> findByNombre(String nombre);
	Optional<Fanzine> findByLugarPublicacion(String lugarPublicacion);
}
