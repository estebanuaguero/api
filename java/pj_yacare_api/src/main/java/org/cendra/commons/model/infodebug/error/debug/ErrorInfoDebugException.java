package org.cendra.commons.model.infodebug.error.debug;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.ex.GenericException;
import org.cendra.commons.utiljdbc.ex.AbstractExceptionDbDao;
import org.cendra.commons.utiljdbc.ex.ExFindJsonDao;

public class ErrorInfoDebugException {

	private String dateException = "unknown";
	private String nameException = "unknown";
	private String throwerClass = "unknown";
	private String cause = "unknown";
	private ErrorInfoDebugDb debugDb;
	private List<String> simpleStackTrace = new ArrayList<String>();
	private List<String> stackTrace;

	@SuppressWarnings("rawtypes")
	public ErrorInfoDebugException(Exception exception, Class clazz) {

		debugDb(exception);

		simpleStackTrace.add(getFirstTrace(exception, clazz));

		if (exception instanceof GenericException) {
			GenericException genericException = (GenericException) exception;

			simpleStackTrace.add(getFirstTrace(genericException,
					genericException.getThrowerClass()));

			dateException = genericException.getTime().toString();

		} else {

			dateException = new Timestamp(System.currentTimeMillis())
					.toString();

		}

		throwerClass = clazz.toString();

		cause = exception.getCause().toString();
		nameException = exception.getClass().toString();

		stackTrace = new ArrayList<String>();

		for (StackTraceElement st : exception.getStackTrace()) {
			stackTrace.add(st.toString());
		}

		if (exception instanceof GenericException) {

			GenericException genericException = (GenericException) exception;

			for (int i = genericException.getStackException().size() - 1; i >= 0; i--) {

				Exception e = genericException.getStackException().get(i);
				simpleStackTrace.add(getFirstTrace(e, genericException
						.getStackthrowerClass().get(i)));
			}

		}

	}

	@SuppressWarnings("rawtypes")
	private String getFirstTrace(Exception e, Class T) {
		for (StackTraceElement st : e.getStackTrace()) {
			if (T.getName().equals(st.getClassName())) {

				String firstTrace = st.getClassName() + "."
						+ st.getMethodName() + " (" + st.getFileName() + " "
						+ ":" + st.getLineNumber() + ") " + e.getMessage();
				return firstTrace;
			}
		}

		return null;
	}

	private void debugDb(Exception exception) {

		if (exception instanceof AbstractExceptionDbDao) {

			AbstractExceptionDbDao genericExceptionDbDao = (AbstractExceptionDbDao) exception;

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

			debugDb.setStackStm(genericExceptionDbDao.getSqlList());

			return;

		} else if (exception instanceof GenericException) {

			GenericException genericException = (GenericException) exception;

			debugDb(genericException.getThirdException());
		}
	}

	public String getDateException() {
		return dateException;
	}

	public void setDateException(String dateException) {
		this.dateException = dateException;
	}

	public String getNameException() {
		return nameException;
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

	public ErrorInfoDebugDb getDebugDb() {
		return debugDb;
	}

	public void setDebugDb(ErrorInfoDebugDb debugDb) {
		this.debugDb = debugDb;
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

	public List<String> getSimpleStackTrace() {
		return simpleStackTrace;
	}

	public void setSimpleStackTrace(List<String> simpleStackTrace) {
		this.simpleStackTrace = simpleStackTrace;
	}

}
