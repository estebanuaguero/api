package org.cendra.commons.ex;

public abstract class GenericBussinessException extends GenericException {

	private static final long serialVersionUID = 4407724867597122424L;

	@SuppressWarnings("rawtypes")
	public GenericBussinessException(Class throwerClass, String message) {
		super(throwerClass);
		super.title = "Error de Negocio";
		super.message = message;
		super.layer = "BO (Bussiness Object)";
		super.code = 409;

	}

	@SuppressWarnings("rawtypes")
	public GenericBussinessException(Class throwerClass,
			Exception thirdException) {
		super(throwerClass, thirdException);
		super.title = "Error de Negocio";
		super.layer = "BO (Bussiness Object)";
		super.code = 409;

	}

}
