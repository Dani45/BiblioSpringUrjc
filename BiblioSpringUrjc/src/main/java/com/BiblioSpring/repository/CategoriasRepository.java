package com.ejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.entity.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Long> {

}
