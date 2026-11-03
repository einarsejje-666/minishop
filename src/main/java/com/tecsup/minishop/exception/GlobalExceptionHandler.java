package com.tecsup.minishop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * Convierte las excepciones no controladas en una respuesta HTTP 500.
 * Necesario porque MockMvc no tiene la página de error de Tomcat: sin este
 * handler la RuntimeException se propaga como ServletException y la prueba
 * "debe retornar 500 cuando el ID no existe" fallaría.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntime(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", ex.getMessage()));
    }
}
