package com.anibal.educational.rest_service.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.anibal.educational.rest_service.comps.service.NotLineToProcessServiceException;
import com.anibal.educational.rest_service.comps.service.TicketLineService;
import com.anibal.educational.rest_service.comps.service.TicketLineServiceException;

@Component
@ContextConfiguration(classes = RestServiceContextConfigurator.class,loader=AnnotationConfigContextLoader.class)
public class LinesProcessorBatch {
	
	@Autowired
    Logger logger;
	
	@Autowired
	TicketLineService service;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 60000)
    public void performProcessLines() {
    	
    	long milis = new Date().getTime();
    	logger.info("LinesProcessorBatch: performProcessLines... Iniciando el envio de procesamiento de las lines a las "+ dateFormat.format(new Date()) );
    	
    	try {
			service.processAllLabelDesc();
		} catch (NotLineToProcessServiceException e) {
			logger.info(e);
		} catch (TicketLineServiceException e) {
			logger.error("LinesProcessorBatch: performProcessLines: Hubo un error al querer procesar las lines...",e);
			logger.error("LinesProcessorBatch: performProcessLines... Finalizando CON ERROR a las "+ dateFormat.format(new Date())+" en "+(new Date().getTime()-milis)+" ms...");
		  	return;
		}
    	
    	logger.info("LinesProcessorBatch: performProcessLines... Finalizando Correctamente el envio de procesamiento de las lines a las "+ dateFormat.format(new Date())+" en "+(new Date().getTime()-milis)+" ms...");
    }
}
