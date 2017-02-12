package com.anibal.educational.rest_service.test.controllers;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anibal.educational.rest_service.comps.service.ServiceRestData;
import com.odhoman.api.utilities.config.AbstractConfig;

@Configuration
public class RestServiceContextConfiguratorTest {

	@Bean
	public ServiceRestData getServiceRestData(){
		return new ServiceRestDataWebImplTest(new TstWebConfig());
	}
	
	@Bean
	public AbstractConfig getAbstractConfig(){
		return new TstWebConfig();
	}
	
	@Bean
	public Logger getLogger(){
		return getAbstractConfig().getLogger();
	}
	
}

