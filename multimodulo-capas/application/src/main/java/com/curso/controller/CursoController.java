package com.curso.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.entity.Curso;
import com.curso.service.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

	private final CursoService cursoService;

	public CursoController(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	@GetMapping
	public List<Curso> listar() {
		return cursoService.listarCursos();
	}

	@PostMapping
	public Curso guardar(@RequestBody Curso curso) {
		return cursoService.guardarCurso(curso);
	}
}