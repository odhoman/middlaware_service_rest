package com.anibal.educational.rest_service.controllers;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anibal.educational.rest_service.comps.config.RestServiceConfig;
import com.anibal.educational.rest_service.comps.dao.CabeceraGastoDao;
import com.anibal.educational.rest_service.comps.dao.DetalleGastoDao;
import com.anibal.educational.rest_service.comps.dao.TicketHeaderDao;
import com.anibal.educational.rest_service.comps.dao.TicketLineDao;
import com.anibal.educational.rest_service.comps.dao.TicketUserDao;
import com.anibal.educational.rest_service.comps.service.CabeceraGastoService;
import com.anibal.educational.rest_service.comps.service.DetalleGastoService;
import com.anibal.educational.rest_service.comps.service.ServiceRestData;
import com.anibal.educational.rest_service.comps.service.TicketHeaderService;
import com.anibal.educational.rest_service.comps.service.TicketLineService;
import com.anibal.educational.rest_service.comps.service.TicketUserService;
import com.anibal.educational.rest_service.comps.service.impl.CabeceraGastoServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.DetalleGastoServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.ServiceRestDataImpl;
import com.anibal.educational.rest_service.comps.service.impl.TicketHeaderServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.TicketLineServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.TicketUserServiceImplImpl;
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
	
	@Bean
	public CabeceraGastoService getCabeceraGastoService(){
		return new CabeceraGastoServiceImpl(new CabeceraGastoDao(), new DetalleGastoDao(), getAbstractConfig());
	}
	
	@Bean
	public DetalleGastoService getDetalleGastoService(){
		return new DetalleGastoServiceImpl(new DetalleGastoDao(), getAbstractConfig());
	}
	
	@Bean
	public TicketHeaderService getTicketHeaderService(){
		return new TicketHeaderServiceImpl(new TicketHeaderDao());
	}
	
	
	@Bean
	public TicketUserService getTicketUserService(){
		return new TicketUserServiceImplImpl(new TicketUserDao());
	}
	
	@Bean
	public TicketLineService getTicketLineService(){
		return new TicketLineServiceImpl(new TicketLineDao());
	}
	
}

