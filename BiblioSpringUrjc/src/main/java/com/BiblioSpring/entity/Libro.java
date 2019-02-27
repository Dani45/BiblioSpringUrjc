package com.BiblioSpring.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "Libro")
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
	private Date fechaPublicacion = new Date();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "libro_categoria", joinColumns = { @JoinColumn(name = "idLibro") }, inverseJoinColumns = {
			@JoinColumn(name = "idCategoria") })
	private Set<Categoria> categorias = new HashSet<Categoria>();

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libro(String nombre, String autor, String lugarPublicacion, Date fechaPublicacion) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.lugarPublicacion = lugarPublicacion;
		this.fechaPublicacion = fechaPublicacion;
	}

	public Libro(String nombre, String autor, String lugarPublicacion, Date fechaPublicacion,
			Set<Categoria> categorias) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.lugarPublicacion = lugarPublicacion;
		this.fechaPublicacion = fechaPublicacion;
		this.categorias = categorias;
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

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", nombre=" + nombre + ", autor=" + autor + ", lugarPublicacion="
				+ lugarPublicacion + ", fechaPublicacion=" + fechaPublicacion + ", categorias=" + categorias
				+ ", getIdLibro()=" + getIdLibro() + ", getNombre()=" + getNombre() + ", getAutor()=" + getAutor()
				+ ", getLugarPublicacion()=" + getLugarPublicacion() + ", getFechaPublicacion()="
				+ getFechaPublicacion() + ", getCategorias()=" + getCategorias() + "]";
	}

}
