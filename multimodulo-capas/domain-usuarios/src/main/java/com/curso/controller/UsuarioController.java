package com.curso.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.dto.UsuarioRequestDto;
import com.curso.dto.UsuarioResponseDto;
import com.curso.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping
	public ResponseEntity<List<UsuarioResponseDto>> listarTodos() {
		return ResponseEntity.ok(usuarioService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable("id") Long id) {
		return ResponseEntity.ok(usuarioService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<UsuarioResponseDto> crear(@RequestBody UsuarioRequestDto requestDto) {
		UsuarioResponseDto nuevoUsuario = usuarioService.guardar(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id) {
		usuarioService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}