package org.cendra.commons.ex;

public class BussinessAutenticationException extends BussinessException {

	private static final long serialVersionUID = -647927306289100199L;

	@SuppressWarnings("rawtypes")
	public BussinessAutenticationException(Class throwerClass, String message) {

		super("Autenticación Fallida", throwerClass, message);

//		super.code = 404;
	}

}
