package com.anibal.educational.rest_service.comps.service.mail;

public class MailConfigurator {
	
	private String propHost;
	private String propStarttlsEnable;
	private String propPort;
	private String propUser;
	private String propSmtpAuth;
	private String messageInternetAdress;
	private String transportProtocl;
	private String transportUser;
	private String transportPass;
	
	public String getPropHost() {
		return propHost;
	}
	public void setPropHost(String propHost) {
		this.propHost = propHost;
	}
	public String getPropStarttlsEnable() {
		return propStarttlsEnable;
	}
	public void setPropStarttlsEnable(String propStarttlsEnable) {
		this.propStarttlsEnable = propStarttlsEnable;
	}
	public String getPropPort() {
		return propPort;
	}
	public void setPropPort(String propPort) {
		this.propPort = propPort;
	}
	public String getPropUser() {
		return propUser;
	}
	public void setPropUser(String propUser) {
		this.propUser = propUser;
	}
	public String getPropSmtpAuth() {
		return propSmtpAuth;
	}
	public void setPropSmtpAuth(String propSmtpAuth) {
		this.propSmtpAuth = propSmtpAuth;
	}
	public String getMessageInternetAdress() {
		return messageInternetAdress;
	}
	public void setMessageInternetAdress(String messageInternetAdress) {
		this.messageInternetAdress = messageInternetAdress;
	}
	public String getTransportProtocl() {
		return transportProtocl;
	}
	public void setTransportProtocl(String transportProtocl) {
		this.transportProtocl = transportProtocl;
	}
	public String getTransportUser() {
		return transportUser;
	}
	public void setTransportUser(String transportUser) {
		this.transportUser = transportUser;
	}
	public String getTransportPass() {
		return transportPass;
	}
	public void setTransportPass(String transportPass) {
		this.transportPass = transportPass;
	}
	

}
