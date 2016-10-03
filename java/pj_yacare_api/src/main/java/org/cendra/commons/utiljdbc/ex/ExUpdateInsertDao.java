package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.utiljdbc.ConnectionWrapper;

public class ExUpdateInsertDao extends AbstractExceptionDbDao {

	private static final long serialVersionUID = 5211806463927374148L;

	@SuppressWarnings("rawtypes")
	public ExUpdateInsertDao(Class throwerClass, Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super("Actualizando o Insertando un Registro", throwerClass,
				"Error al intentar actualizar o insertar un registro.",
				thirdException, connectionWrapper, "UPDATE");

	}

}
