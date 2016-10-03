package org.cendra.commons.utiljdbc.ex;

class ExSqlVarQueryEmptyDao extends AbstractExceptionDao {

	private static final long serialVersionUID = -1427650804793558258L;

	@SuppressWarnings("rawtypes")
	public ExSqlVarQueryEmptyDao(Class throwerClass, Exception thirdException) {
		super("Sentencia SQL para Consultar", throwerClass,
				"La variable sql esta vacia", thirdException);

	}

}
