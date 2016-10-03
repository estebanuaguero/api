package org.cendra.commons.ex;

public class BussinessIllegalArgumentException extends BussinessException {

	private static final long serialVersionUID = -1069028565348432521L;

	@SuppressWarnings("rawtypes")
	public BussinessIllegalArgumentException(Class throwerClass, String message) {
		super(throwerClass, message);
		super.title = "Argumento Inválido";
		super.code = 422;
	}

}
