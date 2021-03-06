package com.anibal.educational.rest_service.comps.service.impl;

import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.config.ConfigConstants;

public class TstConfig extends AbstractConfig {

	private static final long serialVersionUID = -5409595243763576499L;

	public TstConfig() {
		setProperty(ConfigConstants.APP_DB_CONNECTION_TYPE, "simple");
		setProperty(ConfigConstants.COMMON_DB_DATASOURCE, "");
		setProperty(ConfigConstants.COMMON_DB_DRIVER, "oracle.jdbc.OracleDriver");
		setProperty(ConfigConstants.COMMON_DB_URL,
				"jdbc:oracle:thin:@ystad.cy0u7vgbjqzt.us-west-2.rds.amazonaws.com:1521:ystadesa");
		setProperty(ConfigConstants.COMMON_DB_USER, "wallander");
		setProperty(ConfigConstants.COMMON_DB_PASSWORD, "Wallander2016");

		setProperty(ConfigConstants.LOG4J_CONFIG_PATH, "log4j-test.properties");
		setLogger(getLogger(ConfigConstants.LOG4J_CONFIG_PATH, "test"));
	}

	@Override
	protected void preloadClasses() {

	}

}
