package com.anibal.educational.rest_service.comps.service.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailServiceImpl implements MailService{
	
	public void sendMail(MailContent content, MailConfigurator configurator) throws MailServiceException{
		
		try {
			// Propiedades de la conexión
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", configurator.getPropHost());
			props.setProperty("mail.smtp.starttls.enable", configurator.getPropStarttlsEnable());
			props.setProperty("mail.smtp.port", configurator.getPropPort());
			props.setProperty("mail.smtp.user", configurator.getPropUser());
			props.setProperty("mail.smtp.auth", configurator.getPropSmtpAuth());

			// Preparamos la sesion
			Session session = Session.getDefaultInstance(props);

			// Construimos el mensaje
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(configurator.getMessageInternetAdress()));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(content.getTo()));
			message.setSubject(content.getSubject());
			message.setText(content.getBody());

			// Lo enviamos.
			Transport t = session.getTransport(configurator.getTransportProtocl());
			t.connect(configurator.getTransportUser(), configurator.getTransportPass());
			t.sendMessage(message, message.getAllRecipients());

			// Cierre.
			t.close();
			
		} catch (Exception e) {
			throw new MailServiceException(e);
		}
	}
}
