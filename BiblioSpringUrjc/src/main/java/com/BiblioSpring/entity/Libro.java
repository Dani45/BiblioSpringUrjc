package com.BiblioSpring.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Libros")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLibro")
	private long idLibro;

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "autor")
	private String autor;
	@Column(name = "lugarPublicacion")
	private String lugarPublicacion;
	@Column(name = "fechaPublicacion")
	private String fechaPublicacion;
	@Column(name = "fechaPrestamo")
	private String fechaPrestamo;

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}


	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "libro_categoria", joinColumns = { @JoinColumn(name = "idLibro") }, inverseJoinColumns = {
			@JoinColumn(name = "idCategoria") })
	private List<Categoria> categorias = new ArrayList<>();
	
	@ManyToOne
	private User user;

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	/**
	 * 
	 */
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param nombre
	 * @param autor
	 * @param lugarPublicacion
	 * @param fechaPublicacion
	 */
	public Libro(String nombre, String autor, String lugarPublicacion, String fechaPublicacion) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.lugarPublicacion = lugarPublicacion;
		this.fechaPublicacion = fechaPublicacion;
	}


	public Libro(String nombre, String autor, String lugarPublicacion, String fechaPublicacion, Categoria cat) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.lugarPublicacion = lugarPublicacion;
		this.fechaPublicacion = fechaPublicacion;
		this.categorias.add(cat);
	}

	public long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getLugarPublicacion() {
		return lugarPublicacion;
	}

	public void setLugarPublicacion(String lugarPublicacion) {
		this.lugarPublicacion = lugarPublicacion;
	}

	public String getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return "Libro [nombre=" + nombre + ", autor=" + autor + ", lugarPublicacion=" + lugarPublicacion
				+ ", fechaPublicacion=" + fechaPublicacion + "]";
	}

}
