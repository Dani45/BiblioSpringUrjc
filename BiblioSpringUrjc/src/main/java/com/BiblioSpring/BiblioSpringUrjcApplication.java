package com.BiblioSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//con esto buscamos todos los controlladores
@ComponentScan(basePackages = { "com.BiblioSpring", "com.BiblioSpring.controller" })

public class BiblioSpringUrjcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiblioSpringUrjcApplication.class, args);
	}

}