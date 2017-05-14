package com.anibal.educational.rest_service.comps.service;

import java.util.List;

import com.anibal.educational.rest_service.domain.TicketLine;

public interface TicketLineService {
	
	public List<TicketLine> getTicketLinesByTicketId(Long ticketId) throws TicketLineServiceException;
	
	public TicketLine createTicketLine(TicketLine ticketLine) throws TicketLineServiceException;
	
	public void updateTicketLine(Long id, TicketLine ticketLine) throws TicketLineServiceException;	
	
	public void deleteTicketLine(Long ticketId) throws TicketLineServiceException;	
	
	public TicketLine getTicketLine(Long ticketId) throws TicketLineServiceException;	

}
