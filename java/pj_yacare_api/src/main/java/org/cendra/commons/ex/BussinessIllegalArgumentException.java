package org.cendra.commons.ex;

public class BussinessIllegalArgumentException extends BussinessException {

	private static final long serialVersionUID = -5862585548969218069L;

	@SuppressWarnings("rawtypes")
	public BussinessIllegalArgumentException(Class throwerClass, String message) {

		super("Argumento Inválido", throwerClass, message);

		super.code = 422;
	}

}
