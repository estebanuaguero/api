package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.utiljdbc.ConnectionWrapper;

public class ExBeginDao extends AbstractExceptionDbDao {

	private static final long serialVersionUID = 9189527380098903220L;

	@SuppressWarnings("rawtypes")
	public ExBeginDao(Class throwerClass, Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super("Comienzo de Transacción", throwerClass,
				"Error al intentar iniciar una transacción.", thirdException,
				connectionWrapper, "TRANSACTION");

	}

}
