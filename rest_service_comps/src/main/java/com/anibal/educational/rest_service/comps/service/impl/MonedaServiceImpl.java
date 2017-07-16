package com.anibal.educational.rest_service.comps.service.impl;

import com.anibal.educational.rest_service.comps.service.MonedaService;
import com.anibal.educational.rest_service.comps.service.MonedaServiceException;
import com.anibal.educational.rest_service.domain.Moneda;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.dao.DAOException;

public class MonedaServiceImpl extends AbstractService implements MonedaService{
	
	private AbstractAbmDAO<Moneda, Moneda> dao = null;

	public MonedaServiceImpl(AbstractAbmDAO<Moneda, Moneda> dao) {
		super();
		this.dao = dao;
	}
	
	public MonedaServiceImpl(AbstractAbmDAO<Moneda, Moneda> dao, AbstractConfig config) {
		super(config);
		this.dao = dao;
	}
	
	public Moneda getMoneda(Long moendaId) throws MonedaServiceException {

		Moneda filter = new Moneda();
		filter.setMonedaId(moendaId);
		try {
			return dao.getItem(filter);
		} catch (DAOException e) {
			throw new MonedaServiceException(e);
		}
	}
	
	
	public void updateMoneda(Long projectId, Moneda pro) throws MonedaServiceException {
		
		Moneda filter = new Moneda();
		filter.setMonedaId(projectId);
		
		pro.setMonedaName(null);
		pro.setMonedaName(null);
		pro.setUserId(null);
		
		try {
			dao.changeItem(filter, pro);
		} catch (DAOException e) {
			throw new MonedaServiceException(e);
		}
	}

}
