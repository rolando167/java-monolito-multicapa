package com.curso.mapper;

import com.curso.dto.CursoResponseDto;
import com.curso.model.entity.Curso;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-13T12:28:29+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.10 (Oracle Corporation)"
)
@Component
public class CursoMapperImpl implements CursoMapper {

    @Override
    public CursoResponseDto toDto(Curso curso) {
        if ( curso == null ) {
            return null;
        }

        CursoResponseDto cursoResponseDto = new CursoResponseDto();

        cursoResponseDto.setId( curso.getId() );
        cursoResponseDto.setTitulo( curso.getTitulo() );
        cursoResponseDto.setDescripcion( curso.getDescripcion() );

        return cursoResponseDto;
    }

    @Override
    public Curso toEntity(CursoResponseDto cursoResponseDto) {
        if ( cursoResponseDto == null ) {
            return null;
        }

        Curso curso = new Curso();

        curso.setId( cursoResponseDto.getId() );
        curso.setTitulo( cursoResponseDto.getTitulo() );
        curso.setDescripcion( cursoResponseDto.getDescripcion() );

        return curso;
    }
}
