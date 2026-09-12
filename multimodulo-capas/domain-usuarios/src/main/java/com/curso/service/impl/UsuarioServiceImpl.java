package com.curso.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.dto.UsuarioRequestDto;
import com.curso.dto.UsuarioResponseDto;
import com.curso.mapper.UsuarioMapper;
import com.curso.model.Usuario;
import com.curso.repository.UsuarioRepository;
import com.curso.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final UsuarioMapper usuarioMapper;

	// Inyección de dependencias por constructor (la forma más limpia en Spring)
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
		this.usuarioRepository = usuarioRepository;
		this.usuarioMapper = usuarioMapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<UsuarioResponseDto> listarTodos() {
		return usuarioRepository.findAll().stream().map(usuarioMapper::toResponseDto).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioResponseDto buscarPorId(Long id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
		return usuarioMapper.toResponseDto(usuario);
	}

	@Override
	@Transactional
	public UsuarioResponseDto guardar(UsuarioRequestDto requestDto) {
		Usuario usuario = usuarioMapper.toEntity(requestDto);
		Usuario usuarioGuardado = usuarioRepository.save(usuario);
		return usuarioMapper.toResponseDto(usuarioGuardado);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		if (!usuarioRepository.existsById(id)) {
			throw new RuntimeException("Usuario no encontrado con ID: " + id);
		}
		usuarioRepository.deleteById(id);
	}
}