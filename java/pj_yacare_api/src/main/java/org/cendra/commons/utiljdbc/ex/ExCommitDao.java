package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.utiljdbc.ConnectionWrapper;

public class ExCommitDao extends AbstractExceptionDbDao {

	private static final long serialVersionUID = 6896292342225230993L;

	@SuppressWarnings("rawtypes")
	public ExCommitDao(Class throwerClass, Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super("Fin de Transacción", throwerClass,
				"Error al intentar confirmar una transacción.", thirdException,
				connectionWrapper, "TRANSACTION");

	}

}
