package com.anibal.educational.rest_service.comps.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anibal.educational.rest_service.comps.service.ServiceRestData;
import com.odhoman.api.utilities.config.AbstractConfig;

@Configuration
public class AppConfigTest {


	@Bean
	public ServiceRestData getServiceRestData(){
		return new ServiceRestDataImplTest(new TstConfig());
	}
	
	@Bean
	public AbstractConfig getAbstractConfig(){
		return new TstConfig();
	}
	
	@Bean
	public Logger getLogger(){
		return getAbstractConfig().getLogger();
	}
	
	
}

