package com.ejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ejemplo.entity.Fanzine;

public interface FanzinesRepository extends JpaRepository<Fanzine, Long> {

}
