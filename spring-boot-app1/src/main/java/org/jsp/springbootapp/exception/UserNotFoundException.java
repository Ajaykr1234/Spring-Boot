package org.jsp.springbootapp.exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException (String message) {
		super(message);
	}

}
