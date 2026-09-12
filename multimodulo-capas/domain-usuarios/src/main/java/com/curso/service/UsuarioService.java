package com.curso.service;

import java.util.List;

import com.curso.dto.UsuarioRequestDto;
import com.curso.dto.UsuarioResponseDto;

public interface UsuarioService {
	List<UsuarioResponseDto> listarTodos();

	UsuarioResponseDto buscarPorId(Long id);

	UsuarioResponseDto guardar(UsuarioRequestDto requestDto);

	void eliminar(Long id);
}