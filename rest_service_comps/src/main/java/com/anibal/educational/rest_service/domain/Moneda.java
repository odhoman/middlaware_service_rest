package com.anibal.educational.rest_service.domain;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Moneda implements Cloneable {

	private Long monedaId;
	private String monedaName;
	private Double tipoCambio;
	private Long userId;
	@JsonSerialize(using = DateSerializer.class)
	private Date creacionFecha;

	public Moneda() {
		super();
	}

	public Long getMonedaId() {
		return monedaId;
	}

	public void setMonedaId(Long monedaId) {
		this.monedaId = monedaId;
	}

	public String getMonedaName() {
		return monedaName;
	}

	public void setMonedaName(String monedaName) {
		this.monedaName = monedaName;
	}

	public Double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreacionFecha() {
		return creacionFecha;
	}

	public void setCreacionFecha(Date creacionFecha) {
		this.creacionFecha = creacionFecha;
	}

	@Override
	public String toString() {
		return "Moneda [monedaId=" + monedaId + ", monedaName=" + monedaName + ", tipoCambio=" + tipoCambio
				+ ", userId=" + userId + ", creacionFecha=" + creacionFecha + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
