package com.BiblioSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCategoria;
	@Column
	private String area;
	@ManyToOne
	private Libro libro;
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categoria(String area) {
		super();
		this.area = area;
	}
	@Override
	public String toString() {
		return "Categoria [area=" + area + ", libro=" + libro + "]";
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	


}
