package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.utiljdbc.ConnectionWrapper;

public class ExUpdateInsertDao extends GenericExceptionDbUpdateDao {

	private static final long serialVersionUID = 5211806463927374148L;

	@SuppressWarnings("rawtypes")
	public ExUpdateInsertDao(Class throwerClass, Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super(throwerClass, thirdException, connectionWrapper);

		super.title = "Actualizando o Insertando un Registro";
		super.message = "Error al intentar actualizar o insertar un registro.";

	}

}
