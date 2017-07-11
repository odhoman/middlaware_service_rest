package com.anibal.educational.rest_service.domain;

public enum TicketLineStateEnum {
	
	PENDING("PEN"),
	IN_PROCESS("INP"),
	PROCESSED("PRO"),
	NOTIFIED("NOT"),
	NOTIFING("NTG"),
	NOT_NOTIFIED("NNT");
	
	private final String estado;
	
	private TicketLineStateEnum(String estado){
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

}
