package org.jsp.springbootapp.exception;

public class MerchantNotFoundException extends RuntimeException {
	
	public MerchantNotFoundException(String message) {
		super(message);
	}

}
