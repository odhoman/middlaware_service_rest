package com.anibal.educational.rest_service.domain;

public class TicketLineState {
	
	private Long lineStateId;
	private String lineStateTitle;
	private String lineStateDescription;
	
	public TicketLineState() {
		super();
	}
	
	public Long getLineStateId() {
		return lineStateId;
	}
	public void setLineStateId(Long lineStateId) {
		this.lineStateId = lineStateId;
	}
	public String getLineStateTitle() {
		return lineStateTitle;
	}
	public void setLineStateTitle(String lineStateTitle) {
		this.lineStateTitle = lineStateTitle;
	}
	public String getLineStateDescription() {
		return lineStateDescription;
	}
	public void setLineStateDescription(String lineStateDescription) {
		this.lineStateDescription = lineStateDescription;
	}

	@Override
	public String toString() {
		return "TicketLineState [lineStateId=" + lineStateId + ", lineStateTitle=" + lineStateTitle
				+ ", lineStateDescription=" + lineStateDescription + "]";
	}


}
