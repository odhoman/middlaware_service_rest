package com.anibal.educational.rest_service.comps.service;

import java.util.List;

import com.anibal.educational.rest_service.domain.TicketLine;

public interface TicketLineService {
	
	public List<TicketLine> getTicketLinesByTicketId(Long ticketId) throws TicketLineServiceException;

}
