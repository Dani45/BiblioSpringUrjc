package com.BiblioSpring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.BiblioSpring.entity.Fanzine;

public interface FanzinesRepository extends JpaRepository<Fanzine, Long> , CrudRepository<Fanzine,Long>{
	Fanzine findByNombre(String nombre);
	Optional<Fanzine> findByLugarPublicacion(String lugarPublicacion);
	Optional<Fanzine> deleteByNombre(String nombre);
}
