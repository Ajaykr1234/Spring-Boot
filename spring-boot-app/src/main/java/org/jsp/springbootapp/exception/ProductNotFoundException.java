package org.jsp.springbootapp.exception;

public class ProductNotFoundException extends RuntimeException {
	
	public ProductNotFoundException(String message) {
		super(message);
	}

}
