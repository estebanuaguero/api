package org.cendra.commons.ex;

public class BussinessNotFoundException extends BussinessException {

	private static final long serialVersionUID = 9024174513169416449L;

	@SuppressWarnings("rawtypes")
	public BussinessNotFoundException(Class throwerClass, String message) {
		super(throwerClass, message);
		super.title = "Objeto No Encontrado";
		super.code = 404;
	}

}
