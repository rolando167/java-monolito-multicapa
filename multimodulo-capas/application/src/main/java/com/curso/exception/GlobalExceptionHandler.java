package com.curso.exception;

import java.net.URI;
import java.time.Instant;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ProblemDetail handleResourceNotFound(ResourceNotFoundException ex) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());

		problemDetail.setTitle("Recurso No Encontrado");
		problemDetail.setType(URI.create("https://api.tuempresa.com/errors/resource-not-found"));

		// Propiedades personalizadas
		problemDetail.setProperty("timestamp", Instant.now());
		problemDetail.setProperty("error_code", "ERR_USER_404");

		// Inyectamos el traceId desde el MDC (ajusta la clave según cómo lo guardes:
		// "traceId", "correlationId", etc.)
		String traceId = MDC.get("traceId");
		if (traceId != null) {
			problemDetail.setProperty("traceId", traceId);
		}

		return problemDetail; // Spring lo serializa directamente a ProblemDetail + HTTP Status
	}
}