package com.curso.service.impl;

import java.util.List;

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
	public Curso buscarPorId(Long id) {
		return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
		// O una excepción personalizada que luego mapees a 404
	}

	@Override
	@Transactional
	public Curso guardarCurso(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public Curso actualizarCurso(Long id, Curso cursoDetalles) {
		Curso cursoExistente = cursoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + id));

		cursoExistente.setTitulo(cursoDetalles.getTitulo());
		cursoExistente.setDescripcion(cursoDetalles.getDescripcion());

		return cursoRepository.save(cursoExistente);
	}

	@Override
	@Transactional
	public void eliminarCurso(Long id) {
		if (!cursoRepository.existsById(id)) {
			throw new RuntimeException("Curso no encontrado con id: " + id);
		}
		cursoRepository.deleteById(id);
	}
}