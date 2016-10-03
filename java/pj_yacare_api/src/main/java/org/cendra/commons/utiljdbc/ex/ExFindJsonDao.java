package org.cendra.commons.utiljdbc.ex;

import org.cendra.commons.utiljdbc.ConnectionWrapper;

public class ExFindJsonDao extends AbstractExceptionDbDao {

	private static final long serialVersionUID = 7666637278827515912L;

	private String json;

	@SuppressWarnings("rawtypes")
	public ExFindJsonDao(Class throwerClass, Exception thirdException,
			ConnectionWrapper connectionWrapper, String json) {

		super("Consultando uno o más Registros", throwerClass,
				"Error al intentar consultar uno o más de registros.",
				thirdException, connectionWrapper, "QUERY");

		this.json = json;

	}

	public String getJson() {
		return json;
	}

}
