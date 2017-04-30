package com.anibal.educational.rest_service.comps.service.impl;

import com.anibal.educational.rest_service.comps.service.TicketUserException;
import com.anibal.educational.rest_service.comps.service.TicketUserService;
import com.anibal.educational.rest_service.domain.TicketUser;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.dao.DAOException;

public class TicketUserServiceImplImpl  extends AbstractService implements TicketUserService {
	
	
	private AbstractAbmDAO<TicketUser, TicketUser> dao = null;

	public TicketUserServiceImplImpl(AbstractAbmDAO<TicketUser, TicketUser> dao) {
		super();
		this.dao = dao;
	}

	public TicketUser getUser(Long userId) throws TicketUserException {
		
		TicketUser user = null;
		
		logger.debug("TicketUserServiceImplImpl - getUser: iniciando");
		
		TicketUser filter = new TicketUser();
		filter.setUserId(userId);
		try {
			user = dao.getItem(filter);
		} catch (DAOException e) {
			logger.error("TicketUserServiceImplImpl - getUser: ocurrio un error al querer obtener el usuario",e);
			throw new TicketUserException(e);
		}
		
		logger.debug("TicketUserServiceImplImpl - getUser: finalizando");
		
		return user;
	}

	public void updateUser(TicketUser user) throws TicketUserException {
		
		logger.debug("TicketUserServiceImplImpl - updateUser: iniciando");
		
		TicketUser filter = new TicketUser();
		filter.setUserId(user.getUserId());
		try {
			dao.changeItem(filter, user);
		} catch (DAOException e) {
			logger.error("TicketUserServiceImplImpl - updateUser: ocurrio un error al querer actualizar un usuario",e);
			throw new TicketUserException(e);
		}
		
		logger.debug("TicketUserServiceImplImpl - updateUser: finalizando");
	}

	public void deleteUser(Long userId) throws TicketUserException {
		
		logger.debug("TicketUserServiceImplImpl - deleteUser: iniciando");
		
		TicketUser filter = new TicketUser();
		filter.setUserId(userId);
		try {
			dao.deleteItem(filter);
		} catch (DAOException e) {
			logger.error("TicketUserServiceImplImpl - deleteUser: ocurrio un error al querer eliminar el usuario",e);
			throw new TicketUserException(e);
		}
		
		logger.debug("TicketUserServiceImplImpl - deleteUser: finalizando");
		
	}


}
