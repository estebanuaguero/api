package org.cendra.commons.ex;

public class BussinessException extends GenericBussinessException {

	private static final long serialVersionUID = 2512937152079189103L;

	@SuppressWarnings("rawtypes")
	public BussinessException(Class throwerClass, String message) {
		super(throwerClass, message);
		
	}

}
