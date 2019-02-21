package com.ejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.entity.Contacto;

public interface ContactosRepository extends JpaRepository<Contacto, Long> {

}