package com.BiblioSpring.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.BiblioSpring.entity.Fanzine;
import com.BiblioSpring.entity.Pelicula;
import com.BiblioSpring.entity.Revista;

public interface RevistasRepository extends JpaRepository<Revista,Long>, CrudRepository<Revista,Long>{
	Revista findByNombre(String nombre);
	Optional<Revista> findByAno(Integer ano);
	Optional<Revista> deleteByNombre(String nombre);
}
