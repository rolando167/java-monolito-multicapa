package com.curso.service;

import java.util.List;
import java.util.Optional;

import com.curso.model.entity.Curso;

public interface CursoService {

	List<Curso> listarCursos();

	Curso buscarPorId(Long id);

	Curso guardarCurso(Curso curso);

	Curso actualizarCurso(Long id, Curso cursoDetalles);

	void eliminarCurso(Long id);
}