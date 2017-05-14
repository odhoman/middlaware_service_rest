package com.anibal.educational.rest_service.controllers;

import org.apache.log4j.Logger;    
import org.springframework.beans.factory.annotation.Autowired;

import com.odhoman.api.utilities.config.AbstractConfig;

/**
 * Caracteristicas generales de una clase 
 * para el servicio rest.
 *  
 * @author Jonatan Flores
 *
 */

public abstract class AbstractRestService {
	
	@Autowired
	protected AbstractConfig abstractConfig;
	
	@Autowired
	protected Logger logger;
	
    

}
