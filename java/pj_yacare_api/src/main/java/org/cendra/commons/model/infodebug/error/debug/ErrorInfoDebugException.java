package org.cendra.commons.model.infodebug.error.debug;

import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.ex.GenericException;
import org.cendra.commons.utiljdbc.ex.ExFindJsonDao;
import org.cendra.commons.utiljdbc.ex.GenericExceptionDbDao;

public class ErrorInfoDebugException {

	// public String getJavaIoTmpDir() {
	// return System.getProperty("java.io.tmpdir");
	// }
	//
	// public void setJavaIoTmpDir(String javaIoTmpDir) {
	// // this.javaIoTmpDir = javaIoTmpDir;
	// }

	// /** Default temp file path */
	// @SuppressWarnings("unused")
	// private String javaIoTmpDir = "unknown";

	private String nameException = "unknown";
	private String throwerClass = "unknown";
	private String layer = "unknown";
	private ErrorInfoDebugDb debugDb;

	private String firstTrace = "unknown";
	private String cause = "unknown";
	private List<String> stackTrace;
	private List<String> stackTraceThirdException;

	@SuppressWarnings("rawtypes")
	public ErrorInfoDebugException(Exception exception, Class clazz) {

		if (exception instanceof GenericExceptionDbDao) {

			GenericExceptionDbDao genericExceptionDbDao = (GenericExceptionDbDao) exception;

			debugDb = new ErrorInfoDebugDb();

			debugDb.setOperationType(genericExceptionDbDao.getOperationType());
			debugDb.setuRLJDBC(genericExceptionDbDao.getUrl());
			debugDb.setUserNameDataBase(genericExceptionDbDao.getUserName());
			debugDb.setDataBaseProductName(genericExceptionDbDao
					.getDatabaseProductName());
			debugDb.setDatabaseProductVersion(genericExceptionDbDao
					.getDatabaseProductVersion());
			debugDb.setDriverJDBCName(genericExceptionDbDao.getDriverName());
			debugDb.setDriverJDBCVersion(genericExceptionDbDao
					.getDriverVersion());
			if (genericExceptionDbDao.getjDBCMajorVersion() > -1) {
				debugDb.setjDBCMajorVersion(genericExceptionDbDao
						.getjDBCMajorVersion() + "");
			}
			if (genericExceptionDbDao.getjDBCMinorVersion() > -1) {
				debugDb.setjDBCMinorVersion(genericExceptionDbDao
						.getjDBCMinorVersion() + "");
			}
			if (genericExceptionDbDao instanceof ExFindJsonDao) {
				ExFindJsonDao exFindJsonDao = (ExFindJsonDao) genericExceptionDbDao;

				debugDb.setJsonSource(exFindJsonDao.getJson());
			}

			debugDb.setSql(genericExceptionDbDao.getSqlList());
		}

		if (exception instanceof GenericException) {
			GenericException genericException = (GenericException) exception;

			nameException = genericException.getName();
			if (genericException.getThrowerClass() != null) {
				throwerClass = genericException.getThrowerClass().toString();
			}

			if (genericException.getLayer() == null
					&& genericException.getThirdException() != null) {
				if (genericException.getThirdException() != null) {
					layer = genericException.getThirdException().toString();
				}
			} else {
				layer = genericException.getLayer();
			}

			firstTrace = genericException.getFirstTrace();

			if (genericException.getThirdException() != null) {
				cause = genericException.getThirdException().toString();
			}

			if (genericException.getThirdException() != null) {
				stackTraceThirdException = new ArrayList<String>();

				for (StackTraceElement st : genericException
						.getThirdException().getStackTrace()) {
					stackTraceThirdException.add(st.toString());
				}
			}

		} else {

			throwerClass = clazz.toString();

			for (StackTraceElement st : exception.getStackTrace()) {

				if (clazz.getName().equals(st.getClassName())) {

					this.firstTrace = "(" + st.getClassName() + "."
							+ st.getMethodName() + ")" + " ("
							+ st.getFileName() + " " + "Linea: "
							+ st.getLineNumber() + ") "
							+ exception.getMessage();

					break;

				}
			}

			cause = exception.toString();
		}

		stackTrace = new ArrayList<String>();

		for (StackTraceElement st : exception.getStackTrace()) {
			stackTrace.add(st.toString());
		}

	}

	public String getNameException() {
		return nameException.getClass().getCanonicalName();
	}

	public void setNameException(String nameException) {
		this.nameException = nameException;
	}

	public String getThrowerClass() {

		return throwerClass;
	}

	public void setThrowerClass(String throwerClass) {
		this.throwerClass = throwerClass;
	}

	public String getLayer() {
		return layer;
	}

	public void setLayer(String layer) {
		this.layer = layer;
	}

	public ErrorInfoDebugDb getDebugDb() {
		return debugDb;
	}

	public void setDebugDb(ErrorInfoDebugDb debugDb) {
		this.debugDb = debugDb;
	}

	public String getFirstTrace() {

		return firstTrace;
	}

	public void setFirstTrace(String firstTrace) {
		this.firstTrace = firstTrace;
	}

	public String getCause() {

		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public List<String> getStackTrace() {

		return stackTrace;
	}

	public void setStackTrace(List<String> stackTrace) {
		this.stackTrace = stackTrace;
	}

	public List<String> getStackTraceThirdException() {

		return stackTraceThirdException;
	}

	public void setStackTraceThirdException(
			List<String> stackTraceThirdException) {
		this.stackTraceThirdException = stackTraceThirdException;
	}

}
