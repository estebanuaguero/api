package org.cendra.commons.model.infodebug.error;

import org.cendra.commons.ex.GenericException;
import org.cendra.commons.model.infodebug.error.debug.ErrorInfoDebug;

public class ErrorInfo {

	private int code = 500;
	private String subject = "unknown";
	private String message = "unknown";

	protected ErrorInfoDebug infoDebug;

	@SuppressWarnings("rawtypes")
	public ErrorInfo(Exception exception, Class clazz) {

		infoDebug = new ErrorInfoDebug(exception, clazz);

		if (exception instanceof GenericException) {
			
			GenericException genericException = (GenericException) exception;
			
			subject = genericException.getTitle();
			code = genericException.getCode();
		}

		message = exception.getMessage();

	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorInfoDebug getInfoDebug() {
		return infoDebug;
	}

	public void setInfoDebug(ErrorInfoDebug infoDebug) {
		this.infoDebug = infoDebug;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
