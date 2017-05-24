package com.anibal.educational.rest_service.comps.service;

import java.io.File;
import java.io.InputStream;

import com.anibal.educational.rest_service.domain.TicketUser;

public interface TicketUserService{
	
	public TicketUser getUser(Long userId) throws TicketUserException;
	
	public void updateUser(Long userId,TicketUser user) throws TicketUserException;
	 
	public void deleteUser(Long userId) throws TicketUserException;
	
	public TicketUser createUser(TicketUser user) throws TicketUserException;
	
	public void createUserImage(Long userId, InputStream inputStream, String fileName) throws TicketUserException;
	
	public File getUserImage(Long userId) throws TicketUserException;
	
	public TicketUser performAuthentication(String userName, String pass) throws TicketUserException;
	
}
