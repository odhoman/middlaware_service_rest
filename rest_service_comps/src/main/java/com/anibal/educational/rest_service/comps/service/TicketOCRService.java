package com.anibal.educational.rest_service.comps.service;

public interface TicketOCRService {
	
	public String getImageToString(String pathFile) throws TicketOCRServiceException;
	
	public String getOCRStringFromImageBase64(String imageString) throws TicketOCRServiceException;
	
	public String getOCRStringFromImageBase64(String imageString, String url, String key, String serviceType) throws TicketOCRServiceException;

}
