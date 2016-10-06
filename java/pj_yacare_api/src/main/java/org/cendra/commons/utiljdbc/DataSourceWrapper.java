package org.cendra.commons.utiljdbc;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.cendra.commons.utiljdbc.ex.ExGetConnection;
import org.cendra.commons.utiljdbc.ex.ExMetaDataDbCloseConnection;
import org.cendra.commons.utiljdbc.ex.ExMetaDataDbDao;
import org.cendra.commons.utiljdbc.ex.ExStartPoolConnectionDbDao;

public class DataSourceWrapper {

	private DataSource dataSource;

	private DataSourceMetaData dataSourceMetaData;

	private Properties properties;

	public DataSourceWrapper(Properties properties) {
		this.properties = properties;

		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(properties
				.getProperty("jdbc.model.driverClassName"));

		dataSource.setUrl(properties.getProperty("jdbc.model.url"));

		dataSource.setUsername(properties.getProperty("jdbc.model.username"));

		dataSource.setPassword(properties.getProperty("jdbc.model.password"));

		dataSource.setInitialSize(new Integer(properties
				.getProperty("jdbc.model.InitialSize")));

		dataSource.setMaxActive(new Integer(properties
				.getProperty("jdbc.model.MaxActive")));

		init(dataSource);

	}

	public DataSourceWrapper(DataSource dataSource) {
		init(dataSource);
	}

	private void init(DataSource dataSource) {
		this.dataSource = dataSource;

		Connection connection = null;

		System.out.println("\n[..] Conectandose a ");
		System.out.println(toStringPropertiesConnection());

		try {
			connection = dataSource.getConnection();
		} catch (Exception e) {
			throw new ExStartPoolConnectionDbDao(this.getClass(), e);

		}

		try {
			dataSourceMetaData = new DataSourceMetaData();

			dataSourceMetaData.url = connection.getMetaData().getURL();
			dataSourceMetaData.userName = connection.getMetaData()
					.getUserName();
			dataSourceMetaData.databaseProductName = connection.getMetaData()
					.getDatabaseProductName();
			dataSourceMetaData.databaseProductVersion = connection
					.getMetaData().getDatabaseProductVersion();
			dataSourceMetaData.driverName = connection.getMetaData()
					.getDriverName();
			dataSourceMetaData.driverVersion = connection.getMetaData()
					.getDriverVersion();
			dataSourceMetaData.jDBCMajorVersion = connection.getMetaData()
					.getJDBCMajorVersion();
			dataSourceMetaData.jDBCMinorVersion = connection.getMetaData()
					.getJDBCMinorVersion();

		} catch (Exception e) {
			throw new ExMetaDataDbDao(this.getClass(), e);

		} finally {
			
			try {
				if(connection != null && connection.isClosed() == false){
					connection.close();
				}				
				
			} catch (Exception e) {
				throw new ExMetaDataDbCloseConnection(this.getClass(), e);

			}	
		}

		System.out.println("\n[OK] Conectado a");
		System.out.println(dataSourceMetaData + "\n");

		
	}

	public String toStringPropertiesConnection() {

		String r = "";

		r = "\n\t- URL JDBC = " + properties.getProperty("jdbc.model.url")
				+ "\n\t- Driver Class Name = "
				+ properties.getProperty("jdbc.model.driverClassName")
				+ "\n\t- User Name Data Base = "
				+ properties.getProperty("jdbc.model.username")
				+ "\n\t- User Password = "
				+ properties.getProperty("jdbc.model.password")
				+ "\n\t- Initial Size = "
				+ properties.getProperty("jdbc.model.InitialSize")
				+ "\n\t- Max Active = "
				+ properties.getProperty("jdbc.model.MaxActive");

		return r;

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

	public synchronized ConnectionWrapper getConnectionWrapper() {

		try {

			return new ConnectionWrapper(dataSource.getConnection(),
					dataSourceMetaData);

		} catch (Exception e) {

			ExGetConnection ex = new ExGetConnection(this.getClass(), e,
					new ConnectionWrapper(null, dataSourceMetaData));

			// ex.setFirstTrace(e, this.getClass());

			throw ex;
		}

	}

}
