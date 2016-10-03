package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.utiljdbc.ConnectionWrapper;

class ExInsertDao extends AbstractExceptionDbDao {

	private static final long serialVersionUID = 3034770828948130227L;

	@SuppressWarnings("rawtypes")
	public ExInsertDao(Class throwerClass, Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super("Insertando un Registro", throwerClass,
				"Error al intentar insertar un registro.", thirdException,
				connectionWrapper, "INSERT");

	}

}
