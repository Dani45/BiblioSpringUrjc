package com.BiblioSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BiblioSpring.entity.Libro;

public interface LibrosRepository extends JpaRepository<Libro, Long> {

}
