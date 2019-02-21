package com.BiblioSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BiblioSpring.entity.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Long> {

}
