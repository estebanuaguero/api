package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.utiljdbc.ConnectionWrapper;

public class ExFindDao extends AbstractExceptionDbDao {

	private static final long serialVersionUID = -7006496101956738739L;

	@SuppressWarnings("rawtypes")
	public ExFindDao(Class throwerClass, Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super(
				"Consultando Listado de Registros",
				throwerClass,
				"Error al intentar consultar un listado del total de registros.",
				thirdException, connectionWrapper, "QUERY");

	}

}
