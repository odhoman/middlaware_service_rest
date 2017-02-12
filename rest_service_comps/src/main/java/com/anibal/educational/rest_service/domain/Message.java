package com.anibal.educational.rest_service.domain;

public class Message {
	
	private int codigo;
	private String description;
	
	public Message() {
	}
	
	public Message(int codigo, String description) {
		super();
		this.codigo = codigo;
		this.description = description;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
