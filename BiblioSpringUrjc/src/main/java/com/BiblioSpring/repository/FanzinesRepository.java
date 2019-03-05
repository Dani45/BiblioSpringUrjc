package com.BiblioSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BiblioSpring.entity.Fanzine;

public interface FanzinesRepository extends JpaRepository<Fanzine, Long> {

}
