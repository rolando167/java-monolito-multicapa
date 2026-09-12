package com.curso.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// Maneja cuando no se encuentra un recurso (ej. Curso no encontrado)
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {
		Map<String, Object> respuesta = new HashMap<>();
		respuesta.put("timestamp", LocalDateTime.now());
		respuesta.put("status", HttpStatus.NOT_FOUND.value());
		respuesta.put("error", "No encontrado o error en la petición");
		respuesta.put("message", ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	}
}