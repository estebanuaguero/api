package org.cendra.commons.ex;

public abstract class GenericBussinessException extends GenericException {

	private static final long serialVersionUID = -6880395029760547871L;

	@SuppressWarnings("rawtypes")
	public GenericBussinessException(Class throwerClass, String message,
			Exception thirdException) {

		super("BO (Bussiness Object)", "Error de Negocio", throwerClass,
				message, thirdException);

		super.code = 409;
	}
	
	@SuppressWarnings("rawtypes")
	public GenericBussinessException(String subject, Class throwerClass, String message,
			Exception thirdException) {

		super(subject, "Error de Negocio", throwerClass,
				message, thirdException);

		super.code = 409;
	}

}
