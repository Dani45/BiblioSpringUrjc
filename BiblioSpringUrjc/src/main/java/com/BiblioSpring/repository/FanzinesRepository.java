package com.BiblioSpring.repository;

import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.BiblioSpring.entity.Fanzine;

@CacheConfig(cacheNames = "BiblioSpring")
public interface FanzinesRepository extends JpaRepository<Fanzine, Long>, CrudRepository<Fanzine, Long> {

	@Cacheable
	Fanzine findByNombre(String nombre);

	@Cacheable
	Optional<Fanzine> findByLugarPublicacion(String lugarPublicacion);

	@Cacheable
	Optional<Fanzine> deleteByNombre(String nombre);
}
