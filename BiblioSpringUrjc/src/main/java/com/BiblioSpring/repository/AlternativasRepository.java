package com.BiblioSpring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BiblioSpring.entity.Alternativa;
import com.BiblioSpring.entity.Categoria;

public interface AlternativasRepository extends JpaRepository<Alternativa, Long> {
	//Alternativa findByAlternativa(String alternativa);
	Optional<Alternativa> findByAlternativa (String alternativa);
}
