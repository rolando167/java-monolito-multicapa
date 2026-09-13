package com.curso.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String titulo;

	@Column(length = 255)
	private String descripcion;

	@Column(name = "public_id", unique = true, updatable = false)
	private UUID publicId = UUID.randomUUID(); // Se genera automáticamente al crear nuevos

	// Constructor vacío obligatorio para JPA
	public Curso() {
	}

	public Curso(Long id, String titulo, String descripcion, UUID publicId) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.publicId = publicId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UUID getPublicId() {
		return publicId;
	}

	public void setPublicId(UUID publicId) {
		this.publicId = publicId;
	}

}
