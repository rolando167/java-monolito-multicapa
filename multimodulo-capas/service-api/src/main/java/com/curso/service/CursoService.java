package com.curso.service;

import java.util.List;
import java.util.UUID;

import com.curso.dto.CursoResponseDto;
import com.curso.model.entity.Curso;

public interface CursoService {

	List<CursoResponseDto> listarCursos();

	CursoResponseDto buscarPorId(Long id);

	CursoResponseDto buscarPorIdPublico(UUID id);

	Curso guardarCurso(Curso curso);

	Curso actualizarCurso(Long id, Curso cursoDetalles);

	void eliminarCurso(Long id);
}