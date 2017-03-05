package com.anibal.educational.rest_service.domain;

import java.util.Date;

public class DetalleGasto implements Cloneable{
	
	private Long detalleId;
	private Long gastoId;
	private Long gastosNro;
	private String tarea;
	private Date fechaGasto;
	private Double tipoCambio;
	private Double importe;
	private Long codeConvinationId;
	private String observaciones;
	
	public DetalleGasto() {
		super();
	}
	
	public DetalleGasto(Long detalleId, Long gastoId, Long gastosNro, String tarea, Date fechaGasto, Double tipoCambio,
			Double importe, Long codeConvinationId, String observaciones) {
		super();
		this.detalleId = detalleId;
		this.gastoId = gastoId;
		this.gastosNro = gastosNro;
		this.tarea = tarea;
		this.fechaGasto = fechaGasto;
		this.tipoCambio = tipoCambio;
		this.importe = importe;
		this.codeConvinationId = codeConvinationId;
		this.observaciones = observaciones;
	}

	public Long getDetalleId() {
		return detalleId;
	}
	public void setDetalleId(Long detalleId) {
		this.detalleId = detalleId;
	}

	public Long getGastoId() {
		return gastoId;
	}

	public void setGastoId(Long gastoId) {
		this.gastoId = gastoId;
	}

	public Long getGastosNro() {
		return gastosNro;
	}

	public void setGastosNro(Long gastosNro) {
		this.gastosNro = gastosNro;
	}
	
	public String getTarea() {
		return tarea;
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	public Date getFechaGasto() {
		return fechaGasto;
	}
	public void setFechaGasto(Date fechaGasto) {
		this.fechaGasto = fechaGasto;
	}
	public Double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public Long getCodeConvinationId() {
		return codeConvinationId;
	}
	public void setCodeConvinationId(Long codeConvinationId) {
		this.codeConvinationId = codeConvinationId;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "DetalleGasto [detalleId=" + detalleId + ", gastoId=" + gastoId + ", gastosNro=" + gastosNro + ", tarea="
				+ tarea + ", fechaGasto=" + fechaGasto + ", tipoCambio=" + tipoCambio + ", importe=" + importe
				+ ", codeConvinationId=" + codeConvinationId + ", observaciones=" + observaciones + "]";
	}
	
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
