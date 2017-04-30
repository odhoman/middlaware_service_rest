package com.anibal.educational.rest_service.domain;

import java.util.Date;

public class TicketLine implements Cloneable {

	private Long lineId;
	private Long ticketId;
	private String tipoGasto;
	private Long proveedorId;
	private Long ciudadId;
	private Long paisId;
	private String ciudadDesc;
	private String paisDesc;
	private Long proyectoId;
	private Long subproyectoId;
	private Long tareaId;
	private String proyectoDesc;
	private String subproyectoDesc;
	private String tareaDesc;
	private Date gastosFecha;
	private Double importe;
	private String moneda;
	private String monedaFuncional;
	private Double tipoCambio;
	private Date tipoCambioFecha;
	private Long userId;
	private Date creacionFecha;
	private Long imageId;
	private String PathImageId;
	/**
	 * @return the lineId
	 */
	public Long getLineId() {
		return lineId;
	}
	/**
	 * @param lineId the lineId to set
	 */
	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}
	/**
	 * @return the ticketId
	 */
	public Long getTicketId() {
		return ticketId;
	}
	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	/**
	 * @return the tipoGasto
	 */
	public String getTipoGasto() {
		return tipoGasto;
	}
	/**
	 * @param tipoGasto the tipoGasto to set
	 */
	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
	/**
	 * @return the proveedorId
	 */
	public Long getProveedorId() {
		return proveedorId;
	}
	/**
	 * @param proveedorId the proveedorId to set
	 */
	public void setProveedorId(Long proveedorId) {
		this.proveedorId = proveedorId;
	}
	/**
	 * @return the ciudadId
	 */
	public Long getCiudadId() {
		return ciudadId;
	}
	/**
	 * @param ciudadId the ciudadId to set
	 */
	public void setCiudadId(Long ciudadId) {
		this.ciudadId = ciudadId;
	}
	/**
	 * @return the paisId
	 */
	public Long getPaisId() {
		return paisId;
	}
	/**
	 * @param paisId the paisId to set
	 */
	public void setPaisId(Long paisId) {
		this.paisId = paisId;
	}
	/**
	 * @return the ciudadDesc
	 */
	public String getCiudadDesc() {
		return ciudadDesc;
	}
	/**
	 * @param ciudadDesc the ciudadDesc to set
	 */
	public void setCiudadDesc(String ciudadDesc) {
		this.ciudadDesc = ciudadDesc;
	}
	/**
	 * @return the paisDesc
	 */
	public String getPaisDesc() {
		return paisDesc;
	}
	/**
	 * @param paisDesc the paisDesc to set
	 */
	public void setPaisDesc(String paisDesc) {
		this.paisDesc = paisDesc;
	}
	/**
	 * @return the proyectoId
	 */
	public Long getProyectoId() {
		return proyectoId;
	}
	/**
	 * @param proyectoId the proyectoId to set
	 */
	public void setProyectoId(Long proyectoId) {
		this.proyectoId = proyectoId;
	}
	/**
	 * @return the subproyectoId
	 */
	public Long getSubproyectoId() {
		return subproyectoId;
	}
	/**
	 * @param subproyectoId the subproyectoId to set
	 */
	public void setSubproyectoId(Long subproyectoId) {
		this.subproyectoId = subproyectoId;
	}
	/**
	 * @return the tareaId
	 */
	public Long getTareaId() {
		return tareaId;
	}
	/**
	 * @param tareaId the tareaId to set
	 */
	public void setTareaId(Long tareaId) {
		this.tareaId = tareaId;
	}
	/**
	 * @return the proyectoDesc
	 */
	public String getProyectoDesc() {
		return proyectoDesc;
	}
	/**
	 * @param proyectoDesc the proyectoDesc to set
	 */
	public void setProyectoDesc(String proyectoDesc) {
		this.proyectoDesc = proyectoDesc;
	}
	/**
	 * @return the subproyectoDesc
	 */
	public String getSubproyectoDesc() {
		return subproyectoDesc;
	}
	/**
	 * @param subproyectoDesc the subproyectoDesc to set
	 */
	public void setSubproyectoDesc(String subproyectoDesc) {
		this.subproyectoDesc = subproyectoDesc;
	}
	/**
	 * @return the tareaDesc
	 */
	public String getTareaDesc() {
		return tareaDesc;
	}
	/**
	 * @param tareaDesc the tareaDesc to set
	 */
	public void setTareaDesc(String tareaDesc) {
		this.tareaDesc = tareaDesc;
	}
	/**
	 * @return the gastosFecha
	 */
	public Date getGastosFecha() {
		return gastosFecha;
	}
	/**
	 * @param gastosFecha the gastosFecha to set
	 */
	public void setGastosFecha(Date gastosFecha) {
		this.gastosFecha = gastosFecha;
	}
	/**
	 * @return the importe
	 */
	public Double getImporte() {
		return importe;
	}
	/**
	 * @param importe the importe to set
	 */
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	/**
	 * @return the moneda
	 */
	public String getMoneda() {
		return moneda;
	}
	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	/**
	 * @return the monedaFuncional
	 */
	public String getMonedaFuncional() {
		return monedaFuncional;
	}
	/**
	 * @param monedaFuncional the monedaFuncional to set
	 */
	public void setMonedaFuncional(String monedaFuncional) {
		this.monedaFuncional = monedaFuncional;
	}
	/**
	 * @return the tipoCambio
	 */
	public Double getTipoCambio() {
		return tipoCambio;
	}
	/**
	 * @param tipoCambio the tipoCambio to set
	 */
	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	/**
	 * @return the tipoCambioFecha
	 */
	public Date getTipoCambioFecha() {
		return tipoCambioFecha;
	}
	/**
	 * @param tipoCambioFecha the tipoCambioFecha to set
	 */
	public void setTipoCambioFecha(Date tipoCambioFecha) {
		this.tipoCambioFecha = tipoCambioFecha;
	}
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * @return the creacionFecha
	 */
	public Date getCreacionFecha() {
		return creacionFecha;
	}
	/**
	 * @param creacionFecha the creacionFecha to set
	 */
	public void setCreacionFecha(Date creacionFecha) {
		this.creacionFecha = creacionFecha;
	}
	/**
	 * @return the pathImageId
	 */
	public String getPathImageId() {
		return PathImageId;
	}
	/**
	 * @param pathImageId the pathImageId to set
	 */
	public void setPathImageId(String pathImageId) {
		PathImageId = pathImageId;
	}
	
	
	/**
	 * @return the imageId
	 */
	public Long getImageId() {
		return imageId;
	}
	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TicketLine [lineId=" + lineId + ", ticketId=" + ticketId + ", tipoGasto=" + tipoGasto + ", proveedorId="
				+ proveedorId + ", ciudadId=" + ciudadId + ", paisId=" + paisId + ", ciudadDesc=" + ciudadDesc
				+ ", paisDesc=" + paisDesc + ", proyectoId=" + proyectoId + ", subproyectoId=" + subproyectoId
				+ ", tareaId=" + tareaId + ", proyectoDesc=" + proyectoDesc + ", subproyectoDesc=" + subproyectoDesc
				+ ", tareaDesc=" + tareaDesc + ", gastosFecha=" + gastosFecha + ", importe=" + importe + ", moneda="
				+ moneda + ", monedaFuncional=" + monedaFuncional + ", tipoCambio=" + tipoCambio + ", tipoCambioFecha="
				+ tipoCambioFecha + ", userId=" + userId + ", creacionFecha=" + creacionFecha + ", imageId=" + imageId
				+ ", PathImageId=" + PathImageId + "]";
	}
	@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
