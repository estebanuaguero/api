package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.ex.AbstractBussinessException;

public class ExUnexpectedResult extends AbstractBussinessException {

	private static final long serialVersionUID = -4434047353851242707L;

	@SuppressWarnings("rawtypes")
	public ExUnexpectedResult(Class throwerClass, String message) {
		super("Cantidad de Registros Devueltos", throwerClass, message, null);

	}

	@SuppressWarnings("rawtypes")
	public ExUnexpectedResult(Class throwerClass, int cantRows) {

		super("Cantidad de Registros Devueltos", throwerClass,
				"Se esperaba como resultado un solo registro. Registros devueltos "
						+ cantRows, null);

	}

}
