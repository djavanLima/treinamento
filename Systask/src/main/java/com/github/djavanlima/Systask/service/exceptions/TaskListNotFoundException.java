package com.github.djavanlima.Systask.service.exceptions;

public class TaskListNotFoundException extends RuntimeException {
    public TaskListNotFoundException(String message) {
		super(message);
  }

	public TaskListNotFoundException() {
		super("Lista de tarefas não encontrado");
	}
}
