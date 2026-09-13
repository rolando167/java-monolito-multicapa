package com.curso.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	// Aquí podrás añadir consultas personalizadas más adelante si lo necesitas

	// Spring traduce esto automáticamente a un SELECT buscando por la columna
	// public_id
	Optional<Curso> findByPublicId(UUID publicId);
}