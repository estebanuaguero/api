package org.cendra.commons.model.infodebug.error.debug;

import java.util.List;

public class ErrorInfoDebugDb {

	private String operationType = "unknown";
	private String uRLJDBC = "unknown";
	private String userNameDataBase = "unknown";
	private String dataBaseProductName = "unknown";
	private String databaseProductVersion = "unknown";
	private String driverJDBCName = "unknown";
	private String driverJDBCVersion = "unknown";
	private String jDBCMajorVersion = "unknown";
	private String jDBCMinorVersion = "unknown";
	private String jsonSource = "unknown";
	private List<String> sql;

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getuRLJDBC() {
		return uRLJDBC;
	}

	public void setuRLJDBC(String uRLJDBC) {
		this.uRLJDBC = uRLJDBC;
	}

	public String getUserNameDataBase() {
		return userNameDataBase;
	}

	public void setUserNameDataBase(String userNameDataBase) {
		this.userNameDataBase = userNameDataBase;
	}

	public String getDataBaseProductName() {
		return dataBaseProductName;
	}

	public void setDataBaseProductName(String dataBaseProductName) {
		this.dataBaseProductName = dataBaseProductName;
	}

	public String getDatabaseProductVersion() {
		return databaseProductVersion;
	}

	public void setDatabaseProductVersion(String databaseProductVersion) {
		this.databaseProductVersion = databaseProductVersion;
	}

	public String getDriverJDBCName() {
		return driverJDBCName;
	}

	public void setDriverJDBCName(String driverJDBCName) {
		this.driverJDBCName = driverJDBCName;
	}

	public String getDriverJDBCVersion() {
		return driverJDBCVersion;
	}

	public void setDriverJDBCVersion(String driverJDBCVersion) {
		this.driverJDBCVersion = driverJDBCVersion;
	}

	public String getjDBCMajorVersion() {
		return jDBCMajorVersion;
	}

	public void setjDBCMajorVersion(String jDBCMajorVersion) {
		this.jDBCMajorVersion = jDBCMajorVersion;
	}

	public String getjDBCMinorVersion() {
		return jDBCMinorVersion;
	}

	public void setjDBCMinorVersion(String jDBCMinorVersion) {
		this.jDBCMinorVersion = jDBCMinorVersion;
	}

	public String getJsonSource() {
		return jsonSource;
	}

	public void setJsonSource(String jsonSource) {
		this.jsonSource = jsonSource;
	}

	public List<String> getSql() {
		return sql;
	}

	public void setSql(List<String> sql) {
		this.sql = sql;
	}

}
