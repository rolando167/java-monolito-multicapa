package com.curso.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.dto.CursoResponseDto;
import com.curso.exception.ResourceNotFoundException;
import com.curso.mapper.CursoMapper;
import com.curso.model.entity.Curso;
import com.curso.repository.CursoRepository;
import com.curso.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	private final CursoRepository cursoRepository;
	private final CursoMapper cursoMapper;

	// Inyección por constructor (Spring detecta automáticamente el repositorio)
	public CursoServiceImpl(CursoRepository cursoRepository, CursoMapper cursoMapper) {
		this.cursoRepository = cursoRepository;
		this.cursoMapper = cursoMapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CursoResponseDto> listarCursos() {
		return cursoRepository.findAll().stream().map(cursoMapper::toDto) // <-- ¡Aquí entra la magia de MapStruct!
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public CursoResponseDto buscarPorId(Long id) {
		Curso curso = cursoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado" + id));

		return cursoMapper.toDto(curso); // <-- De entidad a ResponseDto en una sola línea
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