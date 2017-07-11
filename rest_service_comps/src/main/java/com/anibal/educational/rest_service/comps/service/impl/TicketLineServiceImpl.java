package com.anibal.educational.rest_service.comps.service.impl;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.anibal.educational.rest_service.comps.cache.LineStateCacheManager;
import com.anibal.educational.rest_service.comps.service.FileManagingException;
import com.anibal.educational.rest_service.comps.service.FileManagingService;
import com.anibal.educational.rest_service.comps.service.NoLineDescAvailableException;
import com.anibal.educational.rest_service.comps.service.NotLineToProcessServiceException;
import com.anibal.educational.rest_service.comps.service.TicketLineNotificationServiceException;
import com.anibal.educational.rest_service.comps.service.TicketLineService;
import com.anibal.educational.rest_service.comps.service.TicketLineServiceException;
import com.anibal.educational.rest_service.comps.service.TicketOCRService;
import com.anibal.educational.rest_service.comps.service.TicketOCRServiceException;
import com.anibal.educational.rest_service.comps.service.TicketPushNotificationService;
import com.anibal.educational.rest_service.comps.service.TicketPushNotificationServiceException;
import com.anibal.educational.rest_service.comps.util.RestServiceConstant;
import com.anibal.educational.rest_service.domain.TicketLine;
import com.anibal.educational.rest_service.domain.TicketLineState;
import com.anibal.educational.rest_service.domain.TicketLineStateEnum;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.dao.DAOException;
import com.odhoman.api.utilities.paging.EnumOrderInfo;
import com.odhoman.api.utilities.paging.OrderInfo;
import com.odhoman.api.utilities.paging.PageInfo;

public class TicketLineServiceImpl extends AbstractService implements TicketLineService {

	private AbstractAbmDAO<TicketLine, TicketLine> dao;
	private TicketOCRService service;
	private FileManagingService fileManagingService;
	private TicketPushNotificationService notificationService;

	public TicketLineServiceImpl(AbstractAbmDAO<TicketLine, TicketLine> dao, TicketOCRService service, FileManagingService fileManagingService, TicketPushNotificationService notificationService) {
		super();
		this.dao = dao;
		this.service = service;
		this.fileManagingService = fileManagingService;
		this.notificationService = notificationService;
	}
	
	public TicketLineServiceImpl(AbstractAbmDAO<TicketLine, TicketLine> dao, TicketOCRService service, FileManagingService fileManagingService, TicketPushNotificationService notificationService, AbstractConfig config) {
		super(config);
		this.dao = dao;
		this.service = service;
		this.fileManagingService = fileManagingService;
		this.notificationService = notificationService;
	}

	public List<TicketLine> getTicketLinesByTicketId(Long ticketId) throws TicketLineServiceException {

		List<TicketLine> tickets = null;
		TicketLine filter = new TicketLine();
		filter.setTicketId(ticketId);

		logger.debug("TicketLineServiceImpl - getTicketLinesByTicketId: iniciando");

		try {
			tickets = dao.getItems(filter);
		} catch (DAOException e) {
			logger.error(
					"TicketLineServiceImpl - getTicketLinesByTicketId: ocurrio un error al querer obtener los ticket del lineId "
							+ ticketId,
					e);
			throw new TicketLineServiceException(e);
		}

		logger.debug("TicketLineServiceImpl - getTicketLinesByTicketId: finalizando");

		return tickets;
	}

	public TicketLine createTicketLine(TicketLine ticketLine) throws TicketLineServiceException {

		logger.debug("TicketLineServiceImpl - createTicketLine: iniciando");

		try {
			dao.addItem(ticketLine);
		} catch (DAOException e) {
			throw new TicketLineServiceException(e);
		}

		logger.debug("TicketLineServiceImpl - createTicketLine: finalizando");

		return ticketLine;
	}

	public void updateTicketLine(Long id, TicketLine ticketLine) throws TicketLineServiceException {

		logger.debug("TicketLineServiceImpl - updateTicketLine: iniciando");

		TicketLine filter = new TicketLine();
		filter.setLineId(id);

		try {
			dao.changeItem(filter, ticketLine);
		} catch (DAOException e) {
			throw new TicketLineServiceException(e);
		}

		logger.debug("TicketLineServiceImpl - updateTicketLine: finalizando");
	}

	public void deleteTicketLine(Long ticketId) throws TicketLineServiceException {

		logger.debug("TicketLineServiceImpl - deleteTicketLine: iniciando");

		TicketLine filter = new TicketLine();
		filter.setLineId(ticketId);

		try {
			dao.deleteItem(filter);
		} catch (DAOException e) {
			throw new TicketLineServiceException(e);
		}

		logger.debug("TicketLineServiceImpl - deleteTicketLine: finalizando");
	}

	public TicketLine getTicketLine(Long ticketId) throws TicketLineServiceException {

		logger.debug("TicketLineServiceImpl - getTicketLine: iniciando");

		TicketLine filter = new TicketLine();
		filter.setLineId(ticketId);

		TicketLine ticketLine = new TicketLine();

		try {
			ticketLine = dao.getItem(filter);
		} catch (DAOException e) {
			throw new TicketLineServiceException(e);
		}

		logger.debug("TicketLineServiceImpl - getTicketLine: finalizando");

		return ticketLine;

	}
	
	
	public void createLineImage(Long lineId, InputStream inputStream, String fileName) throws TicketLineServiceException {

		logger.debug("TicketLineServiceImpl - createLineImage: iniciando");

		TicketLine line = new TicketLine();
		String folderPath = config.getProperty(RestServiceConstant.APP_FILE_SYSTEM_LINE_FOLDER_DIR);

		logger.debug("TicketLineServiceImpl - se guarda la imagen " + fileName + " del ticketLine id " + lineId);

		try {
			fileManagingService.handleUpload(inputStream, folderPath, fileName);
		} catch (FileManagingException e) {
			logger.error("TicketLineServiceImpl - no se pudo  guarda la imagen " + fileName + " del ticketLine id "
					+ lineId);
			throw new TicketLineServiceException(e);
		}

		logger.debug("TicketLineServiceImpl - se actualizan los datos del ticket line");

		line.setImageId(lineId);
		
		// Se indica el path de la imagen
		line.setPathImage(folderPath + fileName);
		
		//Se pone la line en estado pending
		line.setLineStateId(getTicketLineStatePending().getLineStateId());

		updateTicketLine(lineId, line);

		logger.debug("TicketLineServiceImpl - createLineImage: finalizando");

	}

	public File getLineImage(Long lineId) throws TicketLineServiceException {

		logger.debug("TicketLineServiceImpl - getLineImage: iniciando");
		File file = null;

		TicketLine line = getTicketLine(lineId);
		
		try {
			
			file = fileManagingService.handleDownload(line.getPathImage());
			if (file == null || !file.exists()) {
				logger.error("No existe la imagen solicitada en el path " + line.getPathImage());
				throw new TicketLineServiceException("No existe la imagen solicitada");
			}
		} catch (FileManagingException e) {
			throw new TicketLineServiceException("No se pudo obtener la imagen del TicketLine",e);
		}

		logger.debug("TicketLineServiceImpl - getLineImage: finalizando");
		
		return file;
	}
	
	public void processLabelDesc(TicketLine line) throws TicketLineServiceException{
		
		Long lineId = line.getLineId();
		
		try {
			
			//Se envia a traducir la imagen
			line.setLineDesc(service.getOCRStringFromImageBase64(service.getImageToString(line.getPathImage()))) ;
			
			//Se actualiza la descripcion y se notifica que fue procesado 
			notifyLineDescReady(lineId, line,true);
			
		} catch (TicketOCRServiceException e) {
			logger.error("Hubo un error al querer traducir la imagen. Line "+line+e);
			line.setLineDesc(null);
			line.setLineStateId(getTicketLineStatePending().getLineStateId());
			updateTicketLine(lineId, line);
			throw new TicketLineServiceException(e);
		}  catch (TicketLineNotificationServiceException e) {
			logger.error("Hubo un error al querer notificar que se proceso la Line "+line,e);
			line.setLineStateId(getTicketLineStateNotNotified().getLineStateId());
			updateTicketLine(lineId, line);
			throw new TicketLineServiceException(e);
		} catch (NoLineDescAvailableException e){
			logger.error("No hay una descripcion obligatoria de la line para guardar "+line+e);
			line.setLineDesc(null);
			line.setLineStateId(getTicketLineStatePending().getLineStateId());
			updateTicketLine(lineId, line);
			throw new TicketLineServiceException(e);
		} catch (TicketLineServiceException e){
			logger.error("Hubo un error al querer actualizar el estado de la Line "+line+e);
			line.setLineDesc(null);
			line.setLineStateId(getTicketLineStatePending().getLineStateId());
			updateTicketLine(lineId, line);
			throw new TicketLineServiceException(e);
		}
		
	}
	
	public void notifyLineDescReady(Long lineId,TicketLine line, boolean mustExistLineDesc) throws TicketLineServiceException{
		
		//Se pone la line en estado notifing
		line.setLineStateId(getTicketLineStateNotifing().getLineStateId());
		
		if(mustExistLineDesc && (line.getLineDesc() == null))
			throw new NoLineDescAvailableException("No hay una descripcion de la line para guardar ");
		
		try {
			
			updateTicketLine(lineId, line);
		
			notificationService.performNotification(line);
		
			//Se pone la line en estado not notified
			line.setLineStateId(getTicketLineStateNotified().getLineStateId());
			updateTicketLine(lineId, line);
		
		} catch (TicketLineServiceException e) {
			throw new TicketLineNotificationServiceException(e);
		} catch (TicketPushNotificationServiceException e) {
			throw new TicketLineNotificationServiceException(e);
		}
	}
	
	protected TicketLineState getTicketLineStateInProcess(){
		return LineStateCacheManager.getInstance().getItem(TicketLineStateEnum.IN_PROCESS.getEstado());
	} 
	
	protected TicketLineState getTicketLineStateProcessed(){
		return LineStateCacheManager.getInstance().getItem(TicketLineStateEnum.PROCESSED.getEstado());
	} 
	
	protected TicketLineState getTicketLineStatePending(){
		return LineStateCacheManager.getInstance().getItem(TicketLineStateEnum.PENDING.getEstado());
	} 
	
	protected TicketLineState getTicketLineStateNotified(){
		return LineStateCacheManager.getInstance().getItem(TicketLineStateEnum.NOTIFIED.getEstado());
	} 
	
	protected TicketLineState getTicketLineStateNotNotified(){
		return LineStateCacheManager.getInstance().getItem(TicketLineStateEnum.NOT_NOTIFIED.getEstado());
	} 
	
	protected TicketLineState getTicketLineStateNotifing(){
		return LineStateCacheManager.getInstance().getItem(TicketLineStateEnum.NOTIFING.getEstado());
	} 
	
	public void processAllLabelDesc() throws TicketLineServiceException{
		
		List<TicketLine> lineNP = getLinesNotProcessed();
		
		//Se actualiza las lines a estado in process
		//Se pone la line en estado in process
		TicketLine lineInProcess = new TicketLine();
		lineInProcess.setLineStateId(getTicketLineStateInProcess().getLineStateId());
		
		try {
			dao.changeItems(lineNP, lineInProcess);
		} catch (DAOException e1) {
			logger.error("No se pudieron actualizar las lines a in process antes de enviar a procesarlas",e1);
			throw new TicketLineServiceException(e1);
		}
		
		for(TicketLine line: lineNP){
			
			try {
				startThread(getAnsychronousLineProcessor(this,logger,line));
			} catch (Exception e) {
				throw new TicketLineServiceException(e);
			}
		}
		
	}
	
	protected void startThread(AnsychronousLineProcessor thread) throws Exception{
		thread.start();
	}
	
	protected void startThread(AnsychronousLineProcessor thread, boolean isLastOnBatch) throws Exception{
		thread.start();
		logger.debug("Thread de la line "+thread.getLine().getLineId()+" iniciado");
		if(isLastOnBatch){
			thread.join();
		}
	}
	
	protected AnsychronousLineProcessor getAnsychronousLineProcessor(TicketLineService service, Logger logger, TicketLine line){
		return new AnsychronousLineProcessor(service, logger, line);
	}
	
	protected List<TicketLine> getLinesNotProcessed() throws TicketLineServiceException{
		
		List<TicketLine> lineNP = new ArrayList<TicketLine>();
		
		int maxThreads = Integer.parseInt(config.getProperty(RestServiceConstant.APP_MAX_THREADS_LINEPROCESSING, "20"));
		
		List<TicketLine> filtros = new ArrayList<TicketLine>();
		filtros.add(new TicketLine(getTicketLineStateNotNotified().getLineStateId()));
		filtros.add(new TicketLine(getTicketLineStatePending().getLineStateId()));
		
		try {
			lineNP.addAll(dao.getItems(filtros, 
									   new PageInfo(1, maxThreads),
									   new OrderInfo("LINE_ID", EnumOrderInfo.ORDER_TYPE_ASC.getDescripcion())));
		} catch (DAOException e) {
			throw new TicketLineServiceException(e);
		}
		
		if(lineNP.isEmpty())
			throw new NotLineToProcessServiceException("TicketLineServiceImpl - getLinesNotProcessed: No hay lines para procesar.");
		
		return lineNP;
		
	}
	
	

}
