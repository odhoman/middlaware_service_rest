package com.anibal.educational.rest_service.domain;

public class Libro {

	private Long id;
	private String autor;
	private String titulo;
	private String editorial;

	public Libro(Long id, String autor, String titulo, String editorial) {

		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.editorial = editorial;
	}

	public Libro() {
	}

	public Long getId() {
		return id;
	}

	public String getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", autor=" + autor + ", titulo=" + titulo
				+ ", editorial=" + editorial + "]";
	}
	
}
