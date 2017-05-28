package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.domain.TicketDistribution;

public interface TicketDistributionService {
	
	public TicketDistribution createTicketDistribution(TicketDistribution TicketDistribution) throws TicketDistributionException;
	
	public void deleteTicketDistribution(Long ticketId) throws TicketDistributionException;
	
	public void updateTicketDistribution(Long id, TicketDistribution TicketDistribution) throws TicketDistributionException;
	
	public TicketDistribution getTicketDistributionById(Long ticketId) throws TicketDistributionException;

}
