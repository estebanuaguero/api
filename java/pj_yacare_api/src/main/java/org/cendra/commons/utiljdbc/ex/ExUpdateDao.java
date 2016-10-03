package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.utiljdbc.ConnectionWrapper;

class ExUpdateDao extends AbstractExceptionDbDao {

	private static final long serialVersionUID = 5211806463927374148L;

	@SuppressWarnings("rawtypes")
	public ExUpdateDao(Class throwerClass, Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super("Actualizando un Registro", throwerClass,
				"Error al intentar actualizar un registro.", thirdException,
				connectionWrapper, "UPDATE");

	}

}
