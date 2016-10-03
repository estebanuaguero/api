package org.cendra.commons.ex;

public class ExNotFound extends AbstractBussinessException {

	private static final long serialVersionUID = -2061350000958408714L;

	@SuppressWarnings("rawtypes")
	public ExNotFound(Class throwerClass, String message) {
		super("Registro/s No Encontrados", throwerClass, message, null);
		super.code = 404;

	}

}
