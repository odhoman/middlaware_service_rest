package com.anibal.educational.rest_service.comps.service.impl;

import com.anibal.educational.rest_service.comps.service.TicketDistributionException;
import com.anibal.educational.rest_service.comps.service.TicketDistributionService;
import com.anibal.educational.rest_service.domain.TicketDistribution;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;

public class TicketDistributionServiceImpl implements TicketDistributionService{
	
	private AbstractAbmDAO<TicketDistribution, TicketDistribution> dao = null;

	public TicketDistributionServiceImpl(AbstractAbmDAO<TicketDistribution, TicketDistribution> dao) {
		super();
		this.dao = dao;
	}
	
	public TicketDistribution createTicketDistribution(TicketDistribution TicketDistribution)
			throws TicketDistributionException {
		
		try {
			dao.addItem(TicketDistribution);
		} catch (Exception e) {
			throw new TicketDistributionException(e);
		}
		return TicketDistribution;
	}

	public void deleteTicketDistribution(Long distId) throws TicketDistributionException {
		
		try {
			TicketDistribution filter = new TicketDistribution();
			filter.setDistId(distId);
			
			dao.deleteItem(filter);
		} catch (Exception e) {
			throw new TicketDistributionException(e);
		}
	}

	public void updateTicketDistribution(Long distId, TicketDistribution TicketDistribution)
			throws TicketDistributionException {
		
		try {
			TicketDistribution filter = new TicketDistribution();
			filter.setDistId(distId);
			
			dao.changeItem(filter, TicketDistribution);
		} catch (Exception e) {
			throw new TicketDistributionException(e);
		}
		
	}

	public TicketDistribution getTicketDistributionById(Long distId) throws TicketDistributionException {
		
		TicketDistribution dist = null;
		
		try {
			TicketDistribution filter = new TicketDistribution();
			filter.setDistId(distId);
			
			dist = dao.getItem(filter);
		} catch (Exception e) {
			throw new TicketDistributionException(e);
		}
		
		return dist;
	}

}
