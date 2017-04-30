package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.domain.TicketUser;

public interface TicketUserService{
	
	public TicketUser getUser(Long userId) throws TicketUserException;
	
	public void updateUser(TicketUser user) throws TicketUserException;
	 
	public void deleteUser(Long userId) throws TicketUserException;
	
}
