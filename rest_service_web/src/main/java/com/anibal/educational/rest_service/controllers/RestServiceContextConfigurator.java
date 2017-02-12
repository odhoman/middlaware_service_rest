package com.anibal.educational.rest_service.controllers;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anibal.educational.rest_service.comps.config.RestServiceConfig;
import com.anibal.educational.rest_service.comps.service.ServiceRestData;
import com.anibal.educational.rest_service.comps.service.impl.ServiceRestDataImpl;
import com.odhoman.api.utilities.config.AbstractConfig;

@Configuration
public class RestServiceContextConfigurator {

	@Bean
	public ServiceRestData getServiceRestData(){
		return new ServiceRestDataImpl();
	}
	
	@Bean
	public AbstractConfig getAbstractConfig(){
		return RestServiceConfig.getInstance();
	}
	
	@Bean
	public Logger getLogger(){
		return getAbstractConfig().getLogger();
	}
	
}
