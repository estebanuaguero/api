package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.utiljdbc.ConnectionWrapper;

public class ExRollBackDao extends AbstractExceptionDbDao {

	private static final long serialVersionUID = -6120023563624756822L;

	@SuppressWarnings("rawtypes")
	public ExRollBackDao(Class throwerClass, Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super("Deshacer de Cambios de una Transacción", throwerClass,
				"Error al intentar deshacer los cambios de una transacción.",
				thirdException, connectionWrapper, "TRANSACTION");

	}

}
