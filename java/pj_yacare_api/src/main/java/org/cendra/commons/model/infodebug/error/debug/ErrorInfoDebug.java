package org.cendra.commons.model.infodebug.error.debug;

import java.sql.Timestamp;

import org.cendra.commons.ex.GenericException;
import org.cendra.commons.model.infodebug.InfoHost;

public class ErrorInfoDebug {

	private String dateException = "unknown";
	private ErrorInfoDebugException exception;
	private InfoHost host = new InfoHost();
	

	@SuppressWarnings("rawtypes")
	public ErrorInfoDebug(Exception exception, Class clazz) {

		this.exception = new ErrorInfoDebugException(exception, clazz);

		if (exception instanceof GenericException) {
			GenericException genericException = (GenericException) exception;

			dateException = genericException.getTime().toString();

		} else {
			dateException = new Timestamp(System.currentTimeMillis())
					.toString();

		}

	}

	public String getDateException() {
		return dateException;
	}

	public void setDateException(String dateException) {
		this.dateException = dateException;
	}

	public InfoHost getHost() {
		return host;
	}

	public void setHost(InfoHost host) {
		this.host = host;
	}

	public ErrorInfoDebugException getException() {
		return exception;
	}

	public void setException(ErrorInfoDebugException exception) {
		this.exception = exception;
	}

}
