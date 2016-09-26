package org.utiljdbc.ex;

import java.util.ArrayList;
import java.util.List;

import org.utiljdbc.ConnectionWrapper;
import org.utiljdbc.DataSourceMetaData;

abstract class GenericExceptionDbDao extends GenericExceptionDao {

	private static final long serialVersionUID = 6279912367266829619L;

	protected String operationType = "unknown";

	private DataSourceMetaData dataSourceMetaData;
	private List<String> sqlList = new ArrayList<String>();

	@SuppressWarnings("rawtypes")
	public GenericExceptionDbDao(Class throwerClass, Exception thirdException, ConnectionWrapper connectionWrapper) {
		super(throwerClass, thirdException);

		dataSourceMetaData = connectionWrapper.getDataSourceMetaData();
		sqlList = connectionWrapper.getSqlList();

		if (thirdException instanceof GenericExceptionDbDao) {

			this.setThirdException(((GenericExceptionDbDao) thirdException).getThirdException());

			this.setFirstTrace(((GenericExceptionDbDao) thirdException).getFirstTrace());
		}
	}

	public String getTechnicalMessage() {

		return "\n[==================================== Start Exception - Technical Message ===================================================]" + "\n- Date Exception = " + super.time
				+ "\n- Code Exception =  " + getCode() + " " + "\n- Name Exception =  " + this.getClass().getCanonicalName() + "\n" + getTechnicalMessageTmp()
				+ "\n[==================================== End Exception - Technical Message =====================================================]\n\n";

		// return "\n\n\n[" + super.time + " Start Exception:" + getCode() + " " + this.getClass().getCanonicalName() + "]"
		// + getTechnicalMessageTmp()
		// + "\n[" + time + " End Exception:" + getCode()+ " " + this.getClass().getCanonicalName() + "]\n\n\n";
	}

	private String getTechnicalMessageTmp() {
		String jDBCMajorVersion = "unknown";
		String jDBCMinorVersion = "unknown";
		if (getjDBCMajorVersion() > -1) {
			jDBCMajorVersion = getjDBCMajorVersion() + "";
		}
		if (getjDBCMinorVersion() > -1) {
			jDBCMinorVersion = getjDBCMinorVersion() + "";
		}

		String r = "";

		r = "\n\t- Subject = " + title + "\n\t- Message = " + message + "\n\t- Thrower Class = " + throwerClass + "\n\t- Layer = " + layer + "\n\t- Operation Type = " + operationType
				+ "\n\t- URL JDBC = " + this.getUrl() + "\n\t- User Name Data Base = " + this.getUserName() + "\n\t- Data Base Product Name = " + this.getDatabaseProductName()
				+ "\n\t- Database Product Version = " + this.getDatabaseProductVersion() + "\n\t- Driver JDBC Name = " + this.getDriverName() + "\n\t- Driver JDBC Version = "
				+ this.getDriverVersion() + "\n\t- JDBC Major Version = " + jDBCMajorVersion + "\n\t- JDBC Minor Version = " + jDBCMinorVersion + "\n\t- SQL = "
				+ this.getSql().replace("\n", "\n\t\t")

				+ "\n\t- First Trace = " + "\n\t\t------------------------------------------------------------------------------------------" + "\n\t\t- "
				+ this.getFirstTrace().replace("\n", "\n\t\t") + "\n\t\t------------------------------------------------------------------------------------------" + "\n\t- Cause = "
				+ "\n\t\t------------------------------------------------------------------------------------------\n\t\t" + this.thirdException.toString().replace("\n", "\n\t\t")
				+ "\n\t\t------------------------------------------------------------------------------------------";

		if (this instanceof ExFindJsonDao) {

			r += "\n\t- JSON Source = ";
			r += "\n\t\t------------------------------------------------------------------------------------------";
			r += "\n\t\t" + ((ExFindJsonDao) this).getJson();
			r += "\n\t\t------------------------------------------------------------------------------------------";
		}

		return r;

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

			return "\n[==================================== Start Exception - Technical Message ===================================================]" + "\n- Date Exception = " + super.time
					+ "\n- Code Exception =  " + getCode() + " " + "\n- Name Exception =  " + this.getClass().getCanonicalName() + "\n" + getTechnicalMessageTmp()

					+ "\n\t- Stack Trace =" + "\n\t\t------------------------------------------------------------------------------------------" + stackTrace.replace("\n", "\n\t\t")
					+ "\n\t\t------------------------------------------------------------------------------------------"

					+ "\n\t- Stack Trace Third Exception = " + "\n\t\t------------------------------------------------------------------------------------------"
					+ stackTraceThirdException.replace("\n", "\n\t\t") + "\n\t\t------------------------------------------------------------------------------------------"
					+ "\n[==================================== End Exception - Technical Message =====================================================]\n\n";
		} else {
			return "\n[==================================== Start Exception - Technical Message ===================================================]\n\n" + "\n- Date Exception = " + super.time
					+ "\n- Code Exception =  " + getCode() + " " + "\n- Name Exception =  " + this.getClass().getCanonicalName() + "\n" + getTechnicalMessageTmp() + "\n\t- Stack Trace ="
					+ "\n\t\t------------------------------------------------------------------------------------------" + stackTrace.replace("\n", "\n\t\t")
					+ "\n\t\t------------------------------------------------------------------------------------------"
					+ "\n==================================== End Exception - Technical Message =====================================================\n\n";
		}
	}

	public String getSql() {
		if (this.getSqlList() == null) {
			return "unknown";
		}
		if (this.getSqlList().size() == 0) {
			return "unknown";
		}
		String r = "";
		r += "\n------------------------------------------------------------------------------------------";
		for (String sql : this.getSqlList()) {

			r += "\n" + sql;
			r += "\n------------------------------------------------------------------------------------------";
		}

		return r;
	}

	public List<String> getSqlList() {
		return sqlList;
	}

	public String getUrl() {
		return dataSourceMetaData.url;
	}

	public String getUserName() {
		return dataSourceMetaData.userName;
	}

	public String getDatabaseProductName() {
		return dataSourceMetaData.databaseProductName;
	}

	public String getDatabaseProductVersion() {
		return dataSourceMetaData.databaseProductVersion;
	}

	public String getDriverName() {
		return dataSourceMetaData.driverName;
	}

	public String getDriverVersion() {
		return dataSourceMetaData.driverVersion;
	}

	public int getjDBCMajorVersion() {
		return dataSourceMetaData.jDBCMajorVersion;
	}

	public int getjDBCMinorVersion() {
		return dataSourceMetaData.jDBCMinorVersion;
	}

}
