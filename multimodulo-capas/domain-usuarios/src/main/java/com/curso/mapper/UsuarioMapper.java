package com.curso.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.curso.dto.UsuarioRequestDto;
import com.curso.dto.UsuarioResponseDto;
import com.curso.model.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	UsuarioResponseDto toResponseDto(Usuario usuario);

	@Mapping(target = "id", ignore = true) // El ID lo genera la BD
	Usuario toEntity(UsuarioRequestDto requestDto);
}