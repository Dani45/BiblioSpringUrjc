package com.BiblioSpring.repository;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BiblioSpring.entity.Categoria;

@Repository
@CacheConfig(cacheNames = "BiblioSpring")
public interface CategoriasRepository extends JpaRepository<Categoria, Long> {
	@Cacheable
	Categoria findByArea(String area);

}
