package com.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	// Aquí podrás añadir consultas personalizadas más adelante si lo necesitas
}