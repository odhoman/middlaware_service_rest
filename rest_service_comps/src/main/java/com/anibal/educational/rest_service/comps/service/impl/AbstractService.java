package com.anibal.educational.rest_service.comps.service.impl;

import org.apache.log4j.Logger;

import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.config.AppConfig;

public class AbstractService {
	
	protected AbstractConfig config = null;
	protected Logger logger = null;
	
	public AbstractService() {
		this(AppConfig.getInstance());
	}
	
	public AbstractService(AbstractConfig config) {
		setConfiguration(config);
	}
	
	public void setConfiguration(AbstractConfig config) {
		this.config = config;
		logger = this.config.getLogger();
	}


}
