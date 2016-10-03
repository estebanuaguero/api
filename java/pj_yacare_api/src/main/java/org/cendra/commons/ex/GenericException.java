package org.cendra.commons.ex;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericException extends RuntimeException {

	private static final long serialVersionUID = 6937809516512058437L;

	protected int code = 500;
	private String layer = "unknown";
	private String subject = "unknown";
	private String message = "";
	private Timestamp time;

	@SuppressWarnings("rawtypes")
	private Class throwerClass;
	private Exception thirdException;
	private List<Exception> stackException = new ArrayList<Exception>();
	@SuppressWarnings("rawtypes")
	private List<Class> stackThrowerClass = new ArrayList<Class>();

	// =====================================================================

	public List<Exception> getStackException() {
		return stackException;
	}

	@SuppressWarnings("rawtypes")
	public GenericException(String layer, String subject, Class throwerClass,
			String message, Exception thirdException) {

		time = new Timestamp(System.currentTimeMillis());

		this.layer = layer;
		this.subject = subject;
		this.throwerClass = throwerClass;
		this.message = message;

		this.thirdException = thirdException;

		stackException(thirdException);

	}

	private void stackException(Exception thirdException) {

		if (thirdException != null) {

			this.stackException.add(thirdException);

			if (thirdException instanceof GenericException) {

				GenericException genericException = (GenericException) thirdException;

				this.stackThrowerClass.add(((GenericException) thirdException)
						.getThrowerClass());

				stackException(genericException.getThirdException());
			} else {
				this.stackThrowerClass.add(throwerClass);
			}
		}
	}

	// =====================================================================

	public Timestamp getTime() {
		return time;
	}

	public String getTimeString() {
		return time.toString();
	}

	public int getCode() {
		return code;
	}

	public String getLayer() {
		return layer;
	}

	public String getSubject() {
		return subject;
	}

	@SuppressWarnings("rawtypes")
	public Class getThrowerClass() {
		return throwerClass;
	}

	public String getMessage() {
		return message;
	}

	public Throwable getCause() {
		if (stackException.size() > 0
				&& stackException.get(stackException.size() - 1) != null) {
			return stackException.get(stackException.size() - 1);
		}

		return this;

	}

	public Exception getThirdException() {
		return thirdException;
	}

	@SuppressWarnings("rawtypes")
	public List<Class> getStackthrowerClass() {
		return stackThrowerClass;
	}

	// =========================================================================

	// public String getTechnicalMessage() {
	//
	// return "\n\n\n[" + time + " Start Exception:" + getName() + " "
	// + this.getClass().getCanonicalName() + "]"
	// + getTechnicalMessageTmp() + "\n[" + time + " End Exception:"
	// + getName() + " " + this.getClass().getCanonicalName()
	// + "]\n\n\n";
	// }

	// private String getTechnicalMessageTmp() {
	// if (this.getFirstTrace() == null) {
	// firstTrace = "unknown";
	// } else if (this.getFirstTrace() != null
	// && this.getFirstTrace().trim().length() == 0) {
	// firstTrace = "unknown";
	// }
	//
	// if (this.thirdException == null
	// && this.getFirstTrace().equalsIgnoreCase("unknown") == false) {
	// return "\n[" + getName() + "] = " + "Subject: " + subject + "\n["
	// + getName() + "] = " + "Message: " + message + "\n["
	// + getName() + "] = " + "Thrower Class: " + throwerClass
	// + "\n[" + getName() + "] = " + "Layer: " + layer + "\n["
	// + getName() + "] = " + "First Trace: "
	// + this.getFirstTrace();
	// } else if (this.thirdException != null
	// && this.getFirstTrace().equalsIgnoreCase("unknown") == true) {
	// return "\n[" + getName() + "] = " + "Subject: " + subject + "\n["
	// + getName() + "] = " + "Message: " + message + "\n["
	// + getName() + "] = " + "Thrower Class: " + throwerClass
	// + "\n[" + getName() + "] = " + "Layer: " + layer + "\n["
	// + getName() + "] = " + "Cause: " + this.thirdException;
	// }
	//
	// return "\n[" + getName() + "] = " + "Subject: " + subject + "\n["
	// + getName() + "] = " + "Message: " + message + "\n["
	// + getName() + "] = " + "Thrower Class: " + throwerClass + "\n["
	// + getName() + "] = " + "Layer: " + layer + "\n[" + getName()
	// + "] = " + "First Trace: " + this.getFirstTrace() + "\n["
	// + getName() + "] = " + "Cause: " + this.thirdException;
	//
	// }

	// public String toString() {
	// String stackTrace = "";
	// for (StackTraceElement st : getStackTrace()) {
	// stackTrace += "\n" + st;
	// }
	//
	// if (thirdException != null) {
	// String stackTraceThirdException = "";
	// for (StackTraceElement st : thirdException.getStackTrace()) {
	// stackTraceThirdException += "\n" + st;
	// }
	// return "\n\n\n[" + time + " Start Exception:" + getName() + " "
	// + this.getClass().getCanonicalName() + "]"
	// + getTechnicalMessageTmp() + "\n[" + getName() + "] = "
	// + "Stack Trace:\n" + stackTrace + "\n\n[" + getName()
	// + "] = " + "Stack Trace Third Exception:\n"
	// + stackTraceThirdException + "\n\n[" + time
	// + " End Exception:" + getName() + " "
	// + this.getClass().getCanonicalName() + "]\n\n\n";
	// } else {
	// return "\n\n\n[" + time + " Start Exception:" + getName() + " "
	// + this.getClass().getCanonicalName() + "]"
	// + getTechnicalMessageTmp() + "\n[" + getName() + "] = "
	// + "Stack Trace: " + stackTrace + "\n\n[" + time
	// + " End Exception:" + getName() + " "
	// + this.getClass().getCanonicalName() + "]\n\n\n";
	// }
	// }

}
