package com.curso.config;

import java.io.IOException;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class UserLoggingFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			// Buscamos si la petición trae una cabecera "X-User-Id", si no, ponemos
			// "ANONIMO"
			String userId = request.getHeader("X-User-Id");
			if (userId == null || userId.isBlank()) {
				userId = "ANONIMO";
			}

			MDC.put("userId", userId);

			// Continuamos con el flujo normal de la petición (Controller, Service, etc.)
			filterChain.doFilter(request, response);
		} finally {
			// ¡Vital! Limpiamos el MDC para que el hilo no conserve el usuario de esta
			// petición
			MDC.remove("userId");
		}
	}
}
