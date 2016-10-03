package org.cendra.commons.utiljdbc.ex;

class ExSqlVarQueryNullDao extends AbstractExceptionDao {

	private static final long serialVersionUID = 2229426744528040671L;

	@SuppressWarnings("rawtypes")
	public ExSqlVarQueryNullDao(Class throwerClass, Exception thirdException) {
		super("Sentencia SQL para Consultar", throwerClass,
				"La variable sql es nula", thirdException);

	}

}
