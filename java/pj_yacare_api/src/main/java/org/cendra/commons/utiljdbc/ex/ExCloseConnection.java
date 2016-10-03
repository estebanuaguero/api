package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.utiljdbc.ConnectionWrapper;

public class ExCloseConnection extends AbstractExceptionDbDao {

	private static final long serialVersionUID = -8151654714014791263L;

	@SuppressWarnings("rawtypes")
	public ExCloseConnection(Class throwerClass, Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super("Cierre de Conexión", throwerClass,
				"Error al intentar cerrar una conexión.", thirdException,
				connectionWrapper, "END_CONNECT");

	}

}
