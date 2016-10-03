package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.utiljdbc.ConnectionWrapper;

public class ExGetConnection extends AbstractExceptionDbDao {

	private static final long serialVersionUID = -2102866873730658179L;

	@SuppressWarnings("rawtypes")
	public ExGetConnection(Class throwerClass, Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super("Comienzo de Conexión", throwerClass,
				"Error al intentar iniciar una conexión.", thirdException,
				connectionWrapper, "GET_CONNECT");

	}

}
