package com.github.djavanlima.Systask.api.validate;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.djavanlima.Systask.service.exceptions.ItemNotFoundException;
import com.github.djavanlima.Systask.service.exceptions.TaskListNotFoundException;

@RestControllerAdvice
public class ErrorHandler {


    @ExceptionHandler({
        ItemNotFoundException.class,
        TaskListNotFoundException.class
    })
    public ResponseEntity<List<String>> handleBadRequestException(RuntimeException ex) {
		List<String> mensagem = new ArrayList<>();
		mensagem.add(ex.getMessage());
		return ResponseEntity.badRequest().body(mensagem);
	}
}
