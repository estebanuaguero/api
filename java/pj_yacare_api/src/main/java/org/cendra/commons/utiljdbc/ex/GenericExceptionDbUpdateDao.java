package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.utiljdbc.ConnectionWrapper;

abstract class GenericExceptionDbUpdateDao extends GenericExceptionDbDao {

	private static final long serialVersionUID = 544651746325669234L;

	public GenericExceptionDbUpdateDao(
			@SuppressWarnings("rawtypes") Class throwerClass,
			Exception thirdException,
			ConnectionWrapper connectionWrapper) {

		super(throwerClass, thirdException, connectionWrapper);

		super.operationType = "UPDATE";
	}

}
