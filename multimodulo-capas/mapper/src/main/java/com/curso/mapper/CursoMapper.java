package com.curso.mapper;

import org.mapstruct.Mapper;

import com.curso.dto.CursoResponseDto;
import com.curso.model.entity.Curso;

@Mapper(componentModel = "spring") // Para que Spring lo reconozca como un @Bean inyectable
public interface CursoMapper {

	CursoResponseDto toDto(Curso curso);

	Curso toEntity(CursoResponseDto cursoResponseDto);
}
