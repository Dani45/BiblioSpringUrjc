package com.BiblioSpring.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BiblioSpring.entity.Fanzine;
import com.BiblioSpring.entity.Revista;

public interface RevistasRepository extends JpaRepository<Revista,Long>{
	Optional<Revista> findByNombre(String nombre);
	Optional<Revista> findByAno(Integer ano);
}
