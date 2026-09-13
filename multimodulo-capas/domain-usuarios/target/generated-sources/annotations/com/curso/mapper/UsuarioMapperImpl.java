package com.curso.mapper;

import com.curso.dto.UsuarioRequestDto;
import com.curso.dto.UsuarioResponseDto;
import com.curso.model.Usuario;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-13T11:29:57+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioResponseDto toResponseDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioResponseDto usuarioResponseDto = new UsuarioResponseDto();

        usuarioResponseDto.setId( usuario.getId() );
        usuarioResponseDto.setNombre( usuario.getNombre() );
        usuarioResponseDto.setEmail( usuario.getEmail() );

        return usuarioResponseDto;
    }

    @Override
    public Usuario toEntity(UsuarioRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNombre( requestDto.getNombre() );
        usuario.setEmail( requestDto.getEmail() );

        return usuario;
    }
}
