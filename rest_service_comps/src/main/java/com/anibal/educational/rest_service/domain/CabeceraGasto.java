package com.anibal.educational.rest_service.domain;

import java.util.Date;

public class CabeceraGasto implements Cloneable{
	
	private Long gastoId;
	private Long gastoNro;
	private Long proyectoId;
	private Long subProyectoId;
	private String tipoGasto;
	private String ciudad;
	private String pais;
	private Date fechaGasto;
	private String proveedor;
	private Double tipoCambio;
	private Double importe;
	private Long userId;
	private String observaciones;
	
	public CabeceraGasto() {
		super();
	}
	
	public CabeceraGasto(Long gastoId, Long gastoNro, Long proyectoId, Long subProyectoId, String tipoGasto,
			String ciudad, String pais, Date fechaGasto, String proveedor, Double tipoCambio, Double importe,
			Long userId, String observaciones) {
		super();
		this.gastoId = gastoId;
		this.gastoNro = gastoNro;
		this.proyectoId = proyectoId;
		this.subProyectoId = subProyectoId;
		this.tipoGasto = tipoGasto;
		this.ciudad = ciudad;
		this.pais = pais;
		this.fechaGasto = fechaGasto;
		this.proveedor = proveedor;
		this.tipoCambio = tipoCambio;
		this.importe = importe;
		this.userId = userId;
		this.observaciones = observaciones;
	}

	public Long getGastoId() {
		return gastoId;
	}
	public void setGastoId(Long gastoId) {
		this.gastoId = gastoId;
	}
	public Long getGastoNro() {
		return gastoNro;
	}
	public void setGastoNro(Long gastoNro) {
		this.gastoNro = gastoNro;
	}
	public Long getProyectoId() {
		return proyectoId;
	}
	public void setProyectoId(Long proyectoId) {
		this.proyectoId = proyectoId;
	}
	public Long getSubProyectoId() {
		return subProyectoId;
	}
	public void setSubProyectoId(Long subProyectoId) {
		this.subProyectoId = subProyectoId;
	}
	public String getTipoGasto() {
		return tipoGasto;
	}
	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Date getFechaGasto() {
		return fechaGasto;
	}
	public void setFechaGasto(Date fechaGasto) {
		this.fechaGasto = fechaGasto;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	
	@Override
	public String toString() {
		return "CabeceraGastos [gastoId=" + gastoId + ", gastoNro=" + gastoNro + ", proyectoId=" + proyectoId
				+ ", subProyectoId=" + subProyectoId + ", tipoGasto=" + tipoGasto + ", ciudad=" + ciudad + ", pais="
				+ pais + ", fechaGasto=" + fechaGasto + ", proveedor=" + proveedor + ", tipoCambio=" + tipoCambio
				+ ", importe=" + importe + ", userId=" + userId + ", observaciones=" + observaciones + "]";
	}

}
