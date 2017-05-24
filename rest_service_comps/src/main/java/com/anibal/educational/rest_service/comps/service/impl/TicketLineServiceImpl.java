package com.anibal.educational.rest_service.comps.service.impl;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.anibal.educational.rest_service.comps.dao.file_managing.impl.FileSystemFileManagingDao;
import com.anibal.educational.rest_service.comps.service.FileManagingException;
import com.anibal.educational.rest_service.comps.service.FileManagingService;
import com.anibal.educational.rest_service.comps.service.TicketLineService;
import com.anibal.educational.rest_service.comps.service.TicketLineServiceException;
import com.anibal.educational.rest_service.comps.util.RestServiceConstant;
import com.anibal.educational.rest_service.domain.TicketLine;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.dao.DAOException;

public class TicketLineServiceImpl extends AbstractService implements TicketLineService {

	private AbstractAbmDAO<TicketLine, TicketLine> dao = null;

	public TicketLineServiceImpl(AbstractAbmDAO<TicketLine, TicketLine> dao) {
		super();
		this.dao = dao;
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

		FileManagingService servie = new FileManagingServiceImpl(new FileSystemFileManagingDao());

		try {
			servie.handleUpload(inputStream, folderPath, fileName);
		} catch (FileManagingException e) {
			logger.error("TicketLineServiceImpl - no se pudo  guarda la imagen " + fileName + " del ticketLine id "
					+ lineId);
			throw new TicketLineServiceException(e);
		}

		logger.debug("TicketLineServiceImpl - se actualizan los datos del ticket line");

		line.setImageId(lineId);
		line.setPathImage(folderPath + fileName);

		updateTicketLine(lineId, line);

		logger.debug("TicketLineServiceImpl - createLineImage: finalizando");

	}

	public File getLineImage(Long lineId) throws TicketLineServiceException {

		logger.debug("TicketLineServiceImpl - getLineImage: iniciando");
		FileManagingService servie = new FileManagingServiceImpl(new FileSystemFileManagingDao());
		File file = null;

		TicketLine line = getTicketLine(lineId);
		
		try {
			
			file = servie.handleDownload(line.getPathImage());
			if (file == null || !file.exists()) {
				logger.error("No existe la imagen solicitada en el path " + line.getPathImage());
				throw new TicketLineServiceException("No existe la imagen solicitada");
			}
		} catch (FileManagingException e) {
			throw new TicketLineServiceException("No se pudo obtener la imagen del TicketLine");
		}

		logger.debug("TicketLineServiceImpl - getLineImage: finalizando");
		
		return file;
	}

}
