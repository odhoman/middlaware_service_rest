package com.anibal.educational.rest_service.comps.service;

import java.util.List;

import com.anibal.educational.rest_service.domain.TicketHeader;

public interface TicketHeaderService {
	
	public List<TicketHeader> getTicketHeaderByUserId(Long userId) throws TicketHeaderException;
		
}
