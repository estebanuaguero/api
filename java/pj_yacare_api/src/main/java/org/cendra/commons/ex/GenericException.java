package org.cendra.commons.ex;

import java.sql.Timestamp;

public abstract class GenericException extends RuntimeException {

	private static final long serialVersionUID = 6937809516512058437L;

	protected int code = 500;
	protected String layer = "unknown";
	protected String title = "";
	protected String message = "";
	protected Timestamp time;

	@SuppressWarnings("rawtypes")
	protected Class throwerClass;
	protected Exception thirdException;
	private String firstTrace = "unknown";

	public Timestamp getTime() {
		return time;
	}

	@SuppressWarnings("rawtypes")
	public Class getThrowerClass() {
		return throwerClass;
	}

	public String getTimeString() {
		return time.toString();
	}

	public String getLayer() {
		return layer;
	}

	public String getTitle() {
		return title;
	}

	public String getFirstTrace() {
		return firstTrace;
	}

	public void setFirstTrace(String firstTrace) {
		this.firstTrace = firstTrace;
	}

	public int getCode() {
		return code;
	}

	@SuppressWarnings("rawtypes")
	public String setFirstTrace(Exception e, Class T) {
		for (StackTraceElement st : e.getStackTrace()) {
			if (T.getName().equals(st.getClassName())) {
				this.firstTrace = "(" + st.getClassName() + "."
						+ st.getMethodName() + ")" + " (" + st.getFileName()
						+ " " + "Linea: " + st.getLineNumber() + ") "
						+ e.getMessage();
				return this.firstTrace;
			}
		}

		return null;

	}

	@SuppressWarnings("rawtypes")
	public GenericException(Class throwerClass) {
		super();
		this.throwerClass = throwerClass;
		time = new Timestamp(System.currentTimeMillis());
		this.setFirstTrace(this, throwerClass);

	}

	@SuppressWarnings("rawtypes")
	public GenericException(Class throwerClass, Exception thirdException) {
		super();
		this.throwerClass = throwerClass;
		this.thirdException = thirdException;
		time = new Timestamp(System.currentTimeMillis());

		if (thirdException instanceof GenericException) {

			this.setThirdException(((GenericException) thirdException)
					.getThirdException());

			this.setFirstTrace(((GenericException) thirdException)
					.getFirstTrace());
		} else {
			this.setFirstTrace(this, throwerClass);
		}

	}

	public Exception getThirdException() {
		return thirdException;
	}

	public void setThirdException(Exception thirdException) {
		this.thirdException = thirdException;
	}

	public String getName() {

		return this.getClass().getCanonicalName();
	}

	public String getMessage() {
		return message;
	}

	public String getTechnicalMessage() {

		return "\n\n\n[" + time + " Start Exception:" + getName() + " "
				+ this.getClass().getCanonicalName() + "]"
				+ getTechnicalMessageTmp() + "\n[" + time + " End Exception:"
				+ getName() + " " + this.getClass().getCanonicalName()
				+ "]\n\n\n";
	}

	private String getTechnicalMessageTmp() {
		if (this.getFirstTrace() == null) {
			firstTrace = "unknown";
		} else if (this.getFirstTrace() != null
				&& this.getFirstTrace().trim().length() == 0) {
			firstTrace = "unknown";
		}

		if (this.thirdException == null
				&& this.getFirstTrace().equalsIgnoreCase("unknown") == false) {
			return "\n[" + getName() + "] = " + "Subject: " + title + "\n["
					+ getName() + "] = " + "Message: " + message + "\n["
					+ getName() + "] = " + "Thrower Class: " + throwerClass
					+ "\n[" + getName() + "] = " + "Layer: " + layer + "\n["
					+ getName() + "] = " + "First Trace: "
					+ this.getFirstTrace();
		} else if (this.thirdException != null
				&& this.getFirstTrace().equalsIgnoreCase("unknown") == true) {
			return "\n[" + getName() + "] = " + "Subject: " + title + "\n["
					+ getName() + "] = " + "Message: " + message + "\n["
					+ getName() + "] = " + "Thrower Class: " + throwerClass
					+ "\n[" + getName() + "] = " + "Layer: " + layer + "\n["
					+ getName() + "] = " + "Cause: " + this.thirdException;
		}

		return "\n[" + getName() + "] = " + "Subject: " + title + "\n["
				+ getName() + "] = " + "Message: " + message + "\n["
				+ getName() + "] = " + "Thrower Class: " + throwerClass + "\n["
				+ getName() + "] = " + "Layer: " + layer + "\n[" + getName()
				+ "] = " + "First Trace: " + this.getFirstTrace() + "\n["
				+ getName() + "] = " + "Cause: " + this.thirdException;

	}

	public String toString() {
		String stackTrace = "";
		for (StackTraceElement st : getStackTrace()) {
			stackTrace += "\n" + st;
		}

		if (thirdException != null) {
			String stackTraceThirdException = "";
			for (StackTraceElement st : thirdException.getStackTrace()) {
				stackTraceThirdException += "\n" + st;
			}
			return "\n\n\n[" + time + " Start Exception:" + getName() + " "
					+ this.getClass().getCanonicalName() + "]"
					+ getTechnicalMessageTmp() + "\n[" + getName() + "] = "
					+ "Stack Trace:\n" + stackTrace + "\n\n[" + getName()
					+ "] = " + "Stack Trace Third Exception:\n"
					+ stackTraceThirdException + "\n\n[" + time
					+ " End Exception:" + getName() + " "
					+ this.getClass().getCanonicalName() + "]\n\n\n";
		} else {
			return "\n\n\n[" + time + " Start Exception:" + getName() + " "
					+ this.getClass().getCanonicalName() + "]"
					+ getTechnicalMessageTmp() + "\n[" + getName() + "] = "
					+ "Stack Trace: " + stackTrace + "\n\n[" + time
					+ " End Exception:" + getName() + " "
					+ this.getClass().getCanonicalName() + "]\n\n\n";
		}
	}

}
