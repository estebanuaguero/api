package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.ex.GenericException;

abstract class AbstractExceptionDao extends GenericException {

	private static final long serialVersionUID = -3498262347742330970L;

	@SuppressWarnings("rawtypes")
	public AbstractExceptionDao(String subject, Class throwerClass,
			String message, Exception thirdException) {
		super("DAO (Data Access Object)", subject, throwerClass, message, thirdException);

	}

}
