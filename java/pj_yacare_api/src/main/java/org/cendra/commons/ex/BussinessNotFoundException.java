package org.cendra.commons.ex;

public class BussinessNotFoundException extends BussinessException {

	private static final long serialVersionUID = -647927306289100199L;

	@SuppressWarnings("rawtypes")
	public BussinessNotFoundException(Class throwerClass, String message) {

		super("Objeto No Encontrado", throwerClass, message);

		super.code = 404;
	}

}
