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
		return new DbConnectionManager(getConfig());
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

}
