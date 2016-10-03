package org.cendra.commons.utiljdbc.ex;

public class ExMetaDataDbCloseConnection extends AbstractExceptionDao {

	private static final long serialVersionUID = -8794280264552412829L;

	@SuppressWarnings("rawtypes")
	public ExMetaDataDbCloseConnection(Class throwerClass,
			Exception thirdException) {

		super(
				"Data Source Meta Data",
				throwerClass,
				"No se pudo cerrar la conexion para obtener información del origen de datos.",
				thirdException);

	}

}