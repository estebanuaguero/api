package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.utiljdbc.ConnectionWrapper;

public class ExDeleteDao extends AbstractExceptionDbDao {

	private static final long serialVersionUID = 4917330156524908643L;

	@SuppressWarnings("rawtypes")
	public ExDeleteDao(Class throwerClass, Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super("Borrando un Registro", throwerClass,
				"Error al intentar borrar un registro.", thirdException,
				connectionWrapper, "DELETE");

	}

}
