package org.cendra.commons.model.infodebug.error.debug;

import org.cendra.commons.model.infodebug.InfoHost;

public class ErrorInfoDebug {

	private ErrorInfoDebugException exception;
	private InfoHost host = new InfoHost();

	@SuppressWarnings("rawtypes")
	public ErrorInfoDebug(Exception exception, Class clazz) {

		this.exception = new ErrorInfoDebugException(exception, clazz);
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
