package org.cendra.commons.utiljdbc.ex;

public class ExUnexpectedResult extends AbstractExceptionDao {

	private static final long serialVersionUID = 8971469913696187213L;

	// @SuppressWarnings("rawtypes")
	// public ExUnexpectedResult(Class throwerClass, int cantRows) {
	// super(throwerClass);
	// super.subject = "Cantidad de Registros Devueltos";
	// super.message =
	// "Se esperaba como resultado un solo registro. Registros devueltos "
	// + cantRows;
	//
	// }

	// public ExUnexpectedResult(Class throwerClass, String message) {
	// super(throwerClass);
	// super.subject = "Cantidad de Registros Devueltos";
	// super.message = message;
	//
	// }

	@SuppressWarnings("rawtypes")
	public ExUnexpectedResult(Class throwerClass, String message) {
		super("Cantidad de Registros Devueltos", throwerClass, message,
				null);

	}

	@SuppressWarnings("rawtypes")
	public ExUnexpectedResult(Class throwerClass, int cantRows) {

		super("Cantidad de Registros Devueltos", throwerClass,
				"Se esperaba como resultado un solo registro. Registros devueltos "
						+ cantRows, null);

	}

}
