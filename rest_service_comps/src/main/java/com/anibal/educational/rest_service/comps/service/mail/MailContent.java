package com.anibal.educational.rest_service.comps.service.mail;

public class MailContent {
	
	private String subject;
	private String body;
	private String to;
	private String from;
	
	public MailContent(String subject, String body, String to, String from) {
		super();
		this.subject = subject;
		this.body = body;
		this.to = to;
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

}
