package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="libros")
public class Libro {

	@Id
	private int id;
	@Field (name="nombre")
	private String nombre;
	@Field (name="autor")
	private String autor;
	@Field (name="editorial")
	private String editorial;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Libro() {
	}

	@Override
	public String toString() {
		return "Libro [id = " + id + ", nombre = " + nombre + ", autor = " + autor + ", editorial = " + editorial + "]";

	}


}
