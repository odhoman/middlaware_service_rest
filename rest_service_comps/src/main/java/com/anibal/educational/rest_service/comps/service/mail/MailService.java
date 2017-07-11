package com.anibal.educational.rest_service.comps.service.mail;

public interface MailService {

	public void sendMail(MailContent content, MailConfigurator configurator) throws MailServiceException;

}
