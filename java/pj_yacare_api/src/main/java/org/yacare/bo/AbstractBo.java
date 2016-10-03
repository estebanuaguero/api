package org.yacare.bo;

import org.cendra.commons.utiljdbc.DataSourceWrapper;

public class AbstractBo {
	
//	private final String MSG_1 = "Error al levantar las propiedades de configuración.";
	
	
//	private String urlFiles; // URL de Repositorio de Archivos
//	private Properties properties;
	private DataSourceWrapper dataSourceWrapper;

//	public String getUrlFiles() {
//		return urlFiles;
//	}
//
//	public void setUrlFiles(String urlFiles) {
//		this.urlFiles = urlFiles;
//	}

	public DataSourceWrapper getDataSourceWrapper() {
		return dataSourceWrapper;
	}

	public void setDataSourceWrapper(DataSourceWrapper dataSourceWrapper) {
		this.dataSourceWrapper = dataSourceWrapper;
	}

//	public Properties getProperties() {
//		return properties;
//	}
//
//	public void setProperties(Properties properties) {
//		this.properties = properties;
//	}

//	public void init() {
//
//		if (dataSourceWrapper == null) {
//			if (urlFiles == null) {
////				urlFiles = "/home/java/Dropbox/dev/ws_servlet/Yacare/yacare_files/yacare.properties";
//				urlFiles = "/home/java/Dropbox/dev/ws_servlet/Yacare/yacare_files/yacare.properties";
//			}
//			if (properties == null) {
//				properties = new Properties();
//			}
//			try {
//				properties.load(new FileInputStream(urlFiles));
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//				throw new RuntimeException(MSG_1);
//			} catch (IOException e) {
//				e.printStackTrace();
//				throw new RuntimeException(MSG_1);
//			}
//			dataSourceWrapper = new DataSourceWrapper(properties);
//		}
//
//	}


}
