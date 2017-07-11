package com.anibal.educational.rest_service.comps.service.impl;

import org.apache.log4j.Logger;

import com.anibal.educational.rest_service.comps.cache.LineStateCacheManager;
import com.anibal.educational.rest_service.comps.service.TicketLineService;
import com.anibal.educational.rest_service.domain.TicketLine;
import com.anibal.educational.rest_service.domain.TicketLineState;
import com.anibal.educational.rest_service.domain.TicketLineStateEnum;

public class AnsychronousLineProcessor extends Thread{
	
	private TicketLineService service;
	private Logger logger;
	private TicketLine line;
	
	public AnsychronousLineProcessor(TicketLineService service, Logger logger, TicketLine line) {
		super();
		this.service = service;
		this.logger = logger;
		this.line = line;
	}

	@Override
	public void run(){
		
		try{
			if(line.getLineStateId().equals(getTicketLineStatePending().getLineStateId())){
				logger.debug("AnsychronousLineProcessor: iniciando procesamiento de la line "+line.getLineId());
				service.processLabelDesc(line);
				logger.debug("AnsychronousLineProcessor: finalizacion correcta de procesamiento de la line "+line.getLineId());
			}else if(line.getLineStateId().equals(getTicketLineStateNotNotified().getLineStateId())){
				logger.debug("AnsychronousLineProcessor: iniciando la notificacion de la line "+line.getLineId());
				service.notifyLineDescReady(line.getLineId(), line,false);
				logger.debug("AnsychronousLineProcessor: finalizacion correcta de la notificacion de la line "+line.getLineId());
			}
			
		}catch (Exception e) {
			logger.error("AnsychronousLineProcessor: run: hubo un error al querer procesar la linea "+line.getLineId(),e);
		}
		
	}
	
	protected TicketLineState getTicketLineStatePending(){
		return LineStateCacheManager.getInstance().getItem(TicketLineStateEnum.PENDING.getEstado());
	} 
	
	protected TicketLineState getTicketLineStateNotNotified(){
		return LineStateCacheManager.getInstance().getItem(TicketLineStateEnum.NOT_NOTIFIED.getEstado());
	}

	public TicketLine getLine() {
		return line;
	} 
	
	
	
}
