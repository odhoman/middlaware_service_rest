package com.anibal.educational.rest_service.domain;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TicketDistribution implements Cloneable{
	
	private Long distId;
	private Long lineId;
	private Long ticketId;
	private String tipoGasto;
	private String lineDesc;
	@JsonSerialize(using = DateSerializer.class)	
	private Date  gastosFecha;
	private Long cantidad;
	private String cbuDesc;
	private Double importe;
	private String moneda;
	private String monedaFuncional;
	private Long userId;
	@JsonSerialize(using = DateSerializer.class)	
	private Date creacionFecha;
	private Long lineNro;
	
	
	public Long getDistId() {
		return distId;
	}



	public void setDistId(Long distId) {
		this.distId = distId;
	}



	public Long getLineId() {
		return lineId;
	}



	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}



	public Long getTicketId() {
		return ticketId;
	}



	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}



	public String getTipoGasto() {
		return tipoGasto;
	}



	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}



	public String getLineDesc() {
		return lineDesc;
	}



	public void setLineDesc(String lineDesc) {
		this.lineDesc = lineDesc;
	}



	public Date getGastosFecha() {
		return gastosFecha;
	}



	public void setGastosFecha(Date gastosFecha) {
		this.gastosFecha = gastosFecha;
	}



	public Long getCantidad() {
		return cantidad;
	}



	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}



	public String getCbuDesc() {
		return cbuDesc;
	}



	public void setCbuDesc(String cbuDesc) {
		this.cbuDesc = cbuDesc;
	}



	public Double getImporte() {
		return importe;
	}



	public void setImporte(Double importe) {
		this.importe = importe;
	}



	public String getMoneda() {
		return moneda;
	}



	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}



	public String getMonedaFuncional() {
		return monedaFuncional;
	}



	public void setMonedaFuncional(String monedaFuncional) {
		this.monedaFuncional = monedaFuncional;
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



	public Long getLineNro() {
		return lineNro;
	}



	public void setLineNro(Long lineNro) {
		this.lineNro = lineNro;
	}

	@Override
	public String toString() {
		return "TicketDistribution [distId=" + distId + ", lineId=" + lineId + ", ticketId=" + ticketId + ", tipoGasto="
				+ tipoGasto + ", lineDesc=" + lineDesc + ", gastosFecha=" + gastosFecha + ", cantidad=" + cantidad
				+ ", cbuDesc=" + cbuDesc + ", importe=" + importe + ", moneda=" + moneda + ", monedaFuncional="
				+ monedaFuncional + ", userId=" + userId + ", creacionFecha=" + creacionFecha + ", lineNro=" + lineNro
				+ "]";
	}
	
	@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
