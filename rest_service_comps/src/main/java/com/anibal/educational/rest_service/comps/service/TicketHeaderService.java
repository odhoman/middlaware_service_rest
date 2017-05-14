package com.anibal.educational.rest_service.comps.service;

import java.util.List;

import com.anibal.educational.rest_service.domain.TicketHeader;

public interface TicketHeaderService {
	
	public TicketHeader createTicketHeader(TicketHeader ticketHeader) throws TicketHeaderException;
	
	public void deleteTicketHeader(Long ticketId) throws TicketHeaderException;
	
	public void updateTicketHeader(Long id, TicketHeader ticketHeader) throws TicketHeaderException;
	
	public List<TicketHeader> getTicketHeaderByUserId(Long userId) throws TicketHeaderException;
	
	public TicketHeader getTicketHeaderById(Long ticketId) throws TicketHeaderException;
		
}
