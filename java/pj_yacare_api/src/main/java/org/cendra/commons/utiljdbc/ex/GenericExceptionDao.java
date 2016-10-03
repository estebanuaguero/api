package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.ex.GenericException;

public abstract class GenericExceptionDao extends GenericException {

	private static final long serialVersionUID = 5688518031659935816L;

	@SuppressWarnings("rawtypes")
	public GenericExceptionDao(Class throwerClass, Exception thirdException) {
		super(throwerClass, thirdException);
		super.layer = "DAO (Data Access Object)";

	}

	@SuppressWarnings("rawtypes")
	public GenericExceptionDao(Class throwerClass) {
		super(throwerClass);
		super.layer = "DAO (Data Access Object)";

	}

}
