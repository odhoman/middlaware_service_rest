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

}
