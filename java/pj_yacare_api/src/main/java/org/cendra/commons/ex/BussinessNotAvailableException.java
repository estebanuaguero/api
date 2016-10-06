package org.cendra.commons.ex;

public class BussinessNotAvailableException extends BussinessException {

	private static final long serialVersionUID = 4575635731621817981L;

	@SuppressWarnings("rawtypes")
	public BussinessNotAvailableException(Class throwerClass, String message) {

		super("No Disponible", throwerClass, message);

		super.code = 403;
	}

}
