package org.cendra.commons.ex;

public class ErrorBussinessException extends GenericBussinessException {

	private static final long serialVersionUID = 4544610784582607288L;

	@SuppressWarnings("rawtypes")
	public ErrorBussinessException(Class throwerClass, Exception thirdException, String message) {
		super(throwerClass, thirdException );	
		super.message = message;
	}

}
