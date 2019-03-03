package com.BiblioSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BiblioSpring.entity.Categoria;

@Repository
public interface CategoriasRepository extends JpaRepository<Categoria, Long> {
	Categoria findByArea(String area);

}
