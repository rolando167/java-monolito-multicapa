package com.curso.service;

import java.util.List;
import java.util.Optional;

import com.curso.model.entity.Curso;

public interface CursoService {

	List<Curso> listarCursos();

	Optional<Curso> buscarPorId(Long id);

	Curso guardarCurso(Curso curso);

	void eliminarCurso(Long id);
}