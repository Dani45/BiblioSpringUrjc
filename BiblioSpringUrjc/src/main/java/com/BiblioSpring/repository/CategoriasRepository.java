package com.BiblioSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BiblioSpring.entity.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Long> {
	List<Categoria> findByArea(String area);
}
