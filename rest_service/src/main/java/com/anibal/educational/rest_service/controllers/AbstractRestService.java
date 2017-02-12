package com.anibal.educational.rest_service.controllers;

import org.apache.log4j.Logger;

import com.anibal.educational.rest_service.comps.config.RestServiceConfig;

/**
 * Caracteristicas generales de una clase 
 * para el servicio rest.
 *  
 * @author Jonatan Flores
 *
 */
public abstract class AbstractRestService {
	
	protected RestServiceConfig config;
	protected Logger logger;
	
    
    public AbstractRestService() {
		super();
		config = RestServiceConfig.getInstance();
		logger = config.getLogger();
	}

}
