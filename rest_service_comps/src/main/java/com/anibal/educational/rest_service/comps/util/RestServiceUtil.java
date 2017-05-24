package com.anibal.educational.rest_service.comps.util;

import com.anibal.educational.rest_service.comps.config.RestServiceConfig;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.db.DbConnectionManager;

public class RestServiceUtil {
	
	private static DbConnectionManager dbConnectionMgr = null;
	private static AbstractConfig config = null;
	
	/** Devuelve un DbConnectionManager configurado */
	
	public static DbConnectionManager getDbConnectionMgr() {
		
		if (null == dbConnectionMgr) {
			dbConnectionMgr = new DbConnectionManager(getConfig());
		}
		return dbConnectionMgr;
	}
	
	public static AbstractConfig getConfig() {
		if(null == config) {
			setConfig(RestServiceConfig.getInstance());
		}	
		return config; 
	}
	
	public static void setConfig(AbstractConfig cfg) {
		config = cfg;
	}
	
	/** Construye el nombre del archivos desde un nombre y la extension del archivo original */
	
	public static String buildFileName(String name, String originalFileName) {

		String fileName = null;
		if (originalFileName != null && !originalFileName.isEmpty() && originalFileName.indexOf(".") > 0
				&& originalFileName.split("\\.").length == 2 && !originalFileName.split("\\.")[1].isEmpty()) {
			String[] aux = originalFileName.split("\\.");
			fileName = name + "." + aux[1];
		} else {
			fileName = name;
		}
		return fileName;
	}

}
