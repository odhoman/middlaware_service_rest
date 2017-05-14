package com.anibal.educational.rest_service.comps.service.impl;

import java.util.List;

import com.anibal.educational.rest_service.comps.service.TicketLineService;
import com.anibal.educational.rest_service.comps.service.TicketLineServiceException;
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
					"TicketLineServiceImpl - getTicketLinesByTicketId: ocurrio un error al querer obtener los ticket del userId "
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

}
