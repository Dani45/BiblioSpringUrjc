package com.BiblioSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BiblioSpring.entity.Contacto;

public interface ContactosRepository extends JpaRepository<Contacto, Long> {

}