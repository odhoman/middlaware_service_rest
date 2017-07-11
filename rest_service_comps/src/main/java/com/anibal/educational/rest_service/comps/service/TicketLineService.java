package com.anibal.educational.rest_service.comps.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.anibal.educational.rest_service.domain.TicketLine;

public interface TicketLineService {
	
	public List<TicketLine> getTicketLinesByTicketId(Long ticketId) throws TicketLineServiceException;
	
	public TicketLine createTicketLine(TicketLine ticketLine) throws TicketLineServiceException;
	
	public void updateTicketLine(Long id, TicketLine ticketLine) throws TicketLineServiceException;	
	
	public void deleteTicketLine(Long ticketId) throws TicketLineServiceException;	
	
	public TicketLine getTicketLine(Long ticketId) throws TicketLineServiceException;	

	public File getLineImage(Long lineId) throws TicketLineServiceException;
	
	public void createLineImage(Long lineId, InputStream inputStream, String fileName) throws TicketLineServiceException;
	
	public void processLabelDesc(TicketLine line) throws TicketLineServiceException;
	
	public void processAllLabelDesc() throws TicketLineServiceException;
	
	public void notifyLineDescReady(Long lineId,TicketLine line, boolean mustBeLineDesc) throws TicketLineServiceException;
	
}
