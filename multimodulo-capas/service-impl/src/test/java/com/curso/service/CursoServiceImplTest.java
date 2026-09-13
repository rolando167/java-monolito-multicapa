package com.curso.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.curso.dto.CursoResponseDto;
import com.curso.mapper.CursoMapper;
import com.curso.model.entity.Curso;
import com.curso.repository.CursoRepository;
import com.curso.service.impl.CursoServiceImpl;

@ExtendWith(MockitoExtension.class)
class CursoServiceImplTest {

	@Mock
	private CursoRepository cursoRepository;

	@Mock
	private CursoMapper cursoMapper;

	@InjectMocks
	private CursoServiceImpl cursoService;

	@Test
	@DisplayName("Debería listar todos los cursos y mapearlos a DTO")
	void listarCursos_deberiaRetornarListaDeDtos() {
		// Given (Datos de prueba)
		Curso curso = new Curso();
		curso.setId(1L);
		curso.setTitulo("Spring Boot 3");

		CursoResponseDto dto = new CursoResponseDto();
		dto.setId(1L);
		dto.setTitulo("Spring Boot 3");

		when(cursoRepository.findAll()).thenReturn(List.of(curso));
		when(cursoMapper.toDto(curso)).thenReturn(dto);

		// When (Ejecutamos el método a testear)
		List<CursoResponseDto> resultado = cursoService.listarCursos();

		// Then (Aserciones)
		assertThat(resultado).hasSize(1);
		assertThat(resultado.get(0).getTitulo()).isEqualTo("Spring Boot 3");

		verify(cursoRepository, times(1)).findAll();
		verify(cursoMapper, times(1)).toDto(curso);
	}

	@Test
	@DisplayName("Debería buscar un curso por ID y devolver su DTO cuando existe")
	void buscarPorId_cuandoExiste_deberiaRetornarDto() {
		Long id = 10L;
		Curso curso = new Curso();
		curso.setId(id);
		curso.setTitulo("Java Avanzado");

		CursoResponseDto dto = new CursoResponseDto();
		dto.setId(id);
		dto.setTitulo("Java Avanzado");

		when(cursoRepository.findById(id)).thenReturn(Optional.of(curso));
		when(cursoMapper.toDto(curso)).thenReturn(dto);

		CursoResponseDto resultado = cursoService.buscarPorId(id);

		assertThat(resultado).isNotNull();
		assertThat(resultado.getId()).isEqualTo(id);
		verify(cursoRepository).findById(id);
	}

	@Test
	@DisplayName("Debería lanzar RuntimeException cuando se busca un ID que no existe")
	void buscarPorId_cuandoNoExist_deberiaLanzarExcepcion() {
		Long id = 99L;
		when(cursoRepository.findById(id)).thenReturn(Optional.empty());

		assertThatThrownBy(() -> cursoService.buscarPorId(id)).isInstanceOf(RuntimeException.class)
				.hasMessage("Curso no encontrado");
	}

	@Test
	@DisplayName("Debería eliminar un curso cuando existe")
	void eliminarCurso_cuandoExiste_deberiaBorrarlo() {
		Long id = 1L;
		when(cursoRepository.existsById(id)).thenReturn(true);
		doNothing().when(cursoRepository).deleteById(id);

		cursoService.eliminarCurso(id);

		verify(cursoRepository, times(1)).existsById(id);
		verify(cursoRepository, times(1)).deleteById(id);
	}

	@Test
	@DisplayName("Debería lanzar excepción al intentar eliminar un curso que no existe")
	void eliminarCurso_cuandoNoExiste_deberiaLanzarExcepcion() {
		Long id = 99L;
		when(cursoRepository.existsById(id)).thenReturn(false);

		assertThatThrownBy(() -> cursoService.eliminarCurso(id)).isInstanceOf(RuntimeException.class)
				.hasMessage("Curso no encontrado con id: " + id);

		verify(cursoRepository, never()).deleteById(any());
	}
}