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
			logger.error(
					"TicketHeaderServiceImpl - getTicketHeaderByUserId: ocurrio un error al querer obtener los ticket del userId "
							+ userId,
					e);
			throw new TicketHeaderException(e);
		}

		logger.debug("TicketHeaderServiceImpl - getTicketHeaderByUserId: finalizando");

		return tickets;
	}

}
