package com.anibal.educational.rest_service.controllers;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anibal.educational.rest_service.comps.config.RestServiceConfig;
import com.anibal.educational.rest_service.comps.dao.CabeceraGastoDao;
import com.anibal.educational.rest_service.comps.dao.DetalleGastoDao;
import com.anibal.educational.rest_service.comps.dao.MonedaDao;
import com.anibal.educational.rest_service.comps.dao.ProjectDao;
import com.anibal.educational.rest_service.comps.dao.SubprojectDao;
import com.anibal.educational.rest_service.comps.dao.TicketDistributionDao;
import com.anibal.educational.rest_service.comps.dao.TicketHeaderDao;
import com.anibal.educational.rest_service.comps.dao.TicketLineDao;
import com.anibal.educational.rest_service.comps.dao.TicketUserDao;
import com.anibal.educational.rest_service.comps.dao.file_managing.AbstractFileManagingDao;
import com.anibal.educational.rest_service.comps.dao.file_managing.impl.FileSystemFileManagingDao;
import com.anibal.educational.rest_service.comps.service.CabeceraGastoService;
import com.anibal.educational.rest_service.comps.service.DetalleGastoService;
import com.anibal.educational.rest_service.comps.service.FileManagingService;
import com.anibal.educational.rest_service.comps.service.MonedaService;
import com.anibal.educational.rest_service.comps.service.ProjectService;
import com.anibal.educational.rest_service.comps.service.ServiceRestData;
import com.anibal.educational.rest_service.comps.service.SubprojectService;
import com.anibal.educational.rest_service.comps.service.TicketDistributionService;
import com.anibal.educational.rest_service.comps.service.TicketHeaderService;
import com.anibal.educational.rest_service.comps.service.TicketLineService;
import com.anibal.educational.rest_service.comps.service.TicketOCRService;
import com.anibal.educational.rest_service.comps.service.TicketPushNotificationService;
import com.anibal.educational.rest_service.comps.service.TicketUserService;
import com.anibal.educational.rest_service.comps.service.impl.CabeceraGastoServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.DetalleGastoServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.FileManagingServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.MonedaServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.ProjectServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.ServiceRestDataImpl;
import com.anibal.educational.rest_service.comps.service.impl.SubprojectServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.TicketDistributionServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.TicketHeaderServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.TicketLineServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.TicketOCRServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.TicketPushNotificationServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.TicketUserServiceImpl;
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
	public FileManagingService getFileManagingService(){
		return new FileManagingServiceImpl(getAbstractFileManagingDao(),getAbstractConfig());
	}
	
	@Bean
	public AbstractFileManagingDao getAbstractFileManagingDao(){
		return new FileSystemFileManagingDao(getAbstractConfig());
	}
	
	@Bean
	public TicketUserService getTicketUserService(){
		return new TicketUserServiceImpl(new TicketUserDao(),getFileManagingService());
	}
	
	@Bean
	public TicketLineService getTicketLineService(){
		return new TicketLineServiceImpl(new TicketLineDao(),getTicketOCRService(),getFileManagingService(), getTicketPushNotificationService());
	}
	
	@Bean
	public TicketOCRService getTicketOCRService(){
		return new TicketOCRServiceImpl(getAbstractConfig());
	}
	
	@Bean
	public TicketPushNotificationService getTicketPushNotificationService(){
		return new TicketPushNotificationServiceImpl(getAbstractConfig());
	}
	
	@Bean
	public TicketDistributionService getTicketDistributionService(){
		return new TicketDistributionServiceImpl(new TicketDistributionDao());
	}
	
	@Bean
	public MonedaService getMonedaService(){
		return new MonedaServiceImpl(new MonedaDao());
	}
	
	@Bean
	public ProjectService getProjectService(){
		return new ProjectServiceImpl(new ProjectDao());
	}
	
	@Bean
	public SubprojectService getSubprojectService(){
		return new SubprojectServiceImpl(new SubprojectDao());
	}
	
}

