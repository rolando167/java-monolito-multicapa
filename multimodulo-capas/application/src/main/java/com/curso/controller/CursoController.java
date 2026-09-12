package com.curso.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<List<Curso>> listar() {
		List<Curso> cursos = cursoService.listarCursos();
		return ResponseEntity.ok(cursos); // Devuelve 200 OK con la lista
	}

	@PostMapping
	public ResponseEntity<Curso> guardar(@RequestBody Curso curso) {
		Curso nuevoCurso = cursoService.guardarCurso(curso);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCurso); // Devuelve 201 Created
	}

	@GetMapping("/{id}")
	public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {
		Curso curso = cursoService.buscarPorId(id);
		return ResponseEntity.ok(curso);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Curso> actualizar(@PathVariable Long id, @RequestBody Curso cursoDetalles) {
		Curso cursoActualizado = cursoService.actualizarCurso(id, cursoDetalles);
		return ResponseEntity.ok(cursoActualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		cursoService.eliminarCurso(id); // ¡Aquí llamas al servicio!
		return ResponseEntity.noContent().build(); // Devuelve 204 No Content
	}
}