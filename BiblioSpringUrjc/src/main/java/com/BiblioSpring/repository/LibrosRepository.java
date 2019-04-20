package com.BiblioSpring.repository;

import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BiblioSpring.entity.Libro;

@Repository
@CacheConfig(cacheNames = "BiblioSpring")
public interface LibrosRepository extends JpaRepository<Libro, Long> {

	@Cacheable
	Libro findByNombre(String nombre);

}
