package com.curso.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.model.entity.Curso;
import com.curso.repository.CursoRepository;
import com.curso.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	private final CursoRepository cursoRepository;

	// Inyección por constructor (Spring detecta automáticamente el repositorio)
	public CursoServiceImpl(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Curso> listarCursos() {
		return cursoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Curso> buscarPorId(Long id) {
		return cursoRepository.findById(id);
	}

	@Override
	@Transactional
	public Curso guardarCurso(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	@Transactional
	public void eliminarCurso(Long id) {
		cursoRepository.deleteById(id);
	}
}