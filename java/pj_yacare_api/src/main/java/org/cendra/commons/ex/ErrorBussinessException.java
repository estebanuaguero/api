package org.cendra.commons.ex;

public class ErrorBussinessException extends GenericBussinessException {

	private static final long serialVersionUID = -4422237915414219200L;

	@SuppressWarnings("rawtypes")
	public ErrorBussinessException(Class throwerClass, String message,
			Exception thirdException) {

		super(throwerClass, message, thirdException);

	}

}
