package com.github.djavanlima.Systask.service.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
		super(message);
  }

	public ItemNotFoundException() {
		super("Item não encontrado");
	}
}
