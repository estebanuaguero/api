package org.cendra.commons.utiljdbc.ex;

public class ExStartPoolConnectionDbDao extends AbstractExceptionDao {

	private static final long serialVersionUID = -2941309691921374399L;

	@SuppressWarnings("rawtypes")
	public ExStartPoolConnectionDbDao(Class throwerClass, Exception thirdException) {
		super("Data Source - Pool Connection", throwerClass,
				"No se pudo obtener las conexiones a la base de datos. Error al tratar de iniciar el pool de conexiones.",
				thirdException);

	}

}
