package com.BiblioSpring.controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class Libro {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
private String titulo;
private String autor;
private String Isbn;
protected Libro() {}
public Libro(String titulo,String autor,String ISBN) {
	this.autor=autor;
	this.titulo=titulo;
	this.Isbn=ISBN;
}
public long getId() {
	return id;
}
public String getTitulo() {
	return titulo;
}
public String getAutor() {
	return autor;
}
public String getIsbn() {
	return Isbn;
}
public void setId(long id) {
	this.id=id;
}
public void setTitulo(String titulo) {
	this.titulo=titulo;
}
public void setAutor(String autor) {
	this.autor=autor;
}
public void setIsbn(String Isbn) {
	this.Isbn=Isbn;
}
@Override
public String toString() {
	return "Anuncio [autor=" + autor + ", titulo=" + titulo + ", Isbn=" + Isbn + "]";
}
}
