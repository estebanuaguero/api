package org.cendra.commons.ex;

public class BussinessException extends GenericBussinessException {

	private static final long serialVersionUID = -3676488775228724330L;

	@SuppressWarnings("rawtypes")
	public BussinessException(Class throwerClass, String message) {

		super(throwerClass, message, null);
	}
	
	@SuppressWarnings("rawtypes")
	public BussinessException(String subject, Class throwerClass, String message) {

		super(subject, throwerClass, message, null);
	}

}
