package org.cendra.commons.utiljdbc.ex;

public class ExMetaDataDbDao extends AbstractExceptionDao {

	private static final long serialVersionUID = -2941309691921374399L;

	@SuppressWarnings("rawtypes")
	public ExMetaDataDbDao(Class throwerClass, Exception thirdException) {
		super("Data Source Meta Data", throwerClass,
				"No se pudo obtener información del origen de datos.",
				thirdException);

	}

}
