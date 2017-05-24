package com.anibal.educational.rest_service.comps.service.impl;

import java.util.List;

import com.anibal.educational.rest_service.comps.service.TicketHeaderException;
import com.anibal.educational.rest_service.comps.service.TicketHeaderService;
import com.anibal.educational.rest_service.domain.TicketHeader;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.dao.DAOException;

public class TicketHeaderServiceImpl extends AbstractService implements TicketHeaderService {

	private AbstractAbmDAO<TicketHeader, TicketHeader> dao = null;

	public TicketHeaderServiceImpl(AbstractAbmDAO<TicketHeader, TicketHeader> dao) {
		super();
		this.dao = dao;
	}

	public List<TicketHeader> getTicketHeaderByUserId(Long userId) throws TicketHeaderException {

		List<TicketHeader> tickets = null;
		TicketHeader filter = new TicketHeader();
		filter.setUserId(userId);

		logger.debug("TicketHeaderServiceImpl - getTicketHeaderByUserId: iniciando");

		try {
			tickets = dao.getItems(filter);
		} catch (DAOException e) {
			throw new TicketHeaderException(e);
		}

		logger.debug("TicketHeaderServiceImpl - getTicketHeaderByUserId: finalizando");

		return tickets;
	}
	
	public List<TicketHeader> getTicketHeaderByUserAndTicketId(Long userId, Long ticketId) throws TicketHeaderException {

		List<TicketHeader> tickets = null;
		TicketHeader filter = new TicketHeader();
		filter.setUserId(userId);
		filter.setTicketId(ticketId);

		logger.debug("TicketHeaderServiceImpl - getTicketHeaderByUserId: iniciando");

		try {
			tickets = dao.getItems(filter);
		} catch (DAOException e) {
			throw new TicketHeaderException(e);
		}

		logger.debug("TicketHeaderServiceImpl - getTicketHeaderByUserId: finalizando");

		return tickets;
	}

	public TicketHeader createTicketHeader(TicketHeader ticketHeader) throws TicketHeaderException {
		
		logger.debug("TicketHeaderServiceImpl - createTicketHeader: iniciando");
		
		try {
			dao.addItem(ticketHeader);
		} catch (DAOException e) {
			throw new TicketHeaderException(e);
		}
		
		logger.debug("TicketHeaderServiceImpl - createTicketHeader: finalizando");
		
		return ticketHeader;
	}

	public void deleteTicketHeader(Long ticketId) throws TicketHeaderException {
		
		logger.debug("TicketHeaderServiceImpl - createTicketHeader: iniciando");
		
		TicketHeader ticketHeader = new TicketHeader();
		ticketHeader.setTicketId(ticketId);
		try {
			dao.deleteItem(ticketHeader);
		} catch (DAOException e) {
			throw new TicketHeaderException(e);
		}
		
		logger.debug("TicketHeaderServiceImpl - createTicketHeader: finalizando");
	}

	public void updateTicketHeader(Long id, TicketHeader ticketHeader) throws TicketHeaderException {
		
		logger.debug("TicketHeaderServiceImpl - updateTicketHeader: iniciando");
		
		TicketHeader filter = new TicketHeader();
		filter.setTicketId(id);
		
		try {
			dao.changeItem(filter, ticketHeader);
		} catch (DAOException e) {
			throw new TicketHeaderException(e);
		}
		
		logger.debug("TicketHeaderServiceImpl - updateTicketHeader: finalizando");
		
	}

	public TicketHeader getTicketHeaderById(Long ticketId) throws TicketHeaderException {

		logger.debug("TicketHeaderServiceImpl - updateTicketHeader: iniciando");
		
		TicketHeader filter = new TicketHeader();
		filter.setTicketId(ticketId);
		
		TicketHeader ticketHeader = null;
		
		try {
			ticketHeader = dao.getItem(filter);
		} catch (DAOException e) {
			throw new TicketHeaderException(e);
		}
		
		logger.debug("TicketHeaderServiceImpl - updateTicketHeader: finalizando");
		
		return ticketHeader;
	}

}
