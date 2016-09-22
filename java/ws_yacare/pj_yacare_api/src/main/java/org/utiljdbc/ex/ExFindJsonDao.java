package org.utiljdbc.ex;

import org.utiljdbc.ConnectionWrapper;

public class ExFindJsonDao extends GenericExceptionDbQueryDao {

	private static final long serialVersionUID = 7666637278827515912L;

	private String json;

	@SuppressWarnings("rawtypes")
	public ExFindJsonDao(Class throwerClass, Exception thirdException, ConnectionWrapper connectionWrapper, String json) {

		super(throwerClass, thirdException, connectionWrapper);

		this.json = json;

		super.title = "Consultando uno o más Registros";
		super.message = "Error al intentar consultar uno o más de registros.\n";

	}

	public String getJson() {
		return json;
	}

}
