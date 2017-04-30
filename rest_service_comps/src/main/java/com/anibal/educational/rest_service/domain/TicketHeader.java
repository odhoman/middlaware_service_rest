package com.anibal.educational.rest_service.domain;

import java.util.Date;

public class TicketHeader implements Cloneable{
	
	private Long ticketId;
	private Long proyectoId;
	private Long subproyectoId;
	private Long tareaId;
	private String proyectoDesc;
	private String subproyectoDesc;
	private String tareaDesc;
	private Date gastosFecha;
	private Date creacionFecha;
	private Double importe;
	private Long userId;
	private String moneda;
	private String monedaFuncional;
	private Double tipoCambio;
	private Date tipoCambioFecha;
	private Long employeeId;
	private String employeeDesc;
	private Long supplierId;
	private String supplierDesc;
	private String email;
	private String phoneNumber;
	private Long departamentId;
	private String departamentDesc;
	
	
	public Long getTicketId() {
		return ticketId;
	}
	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}
	public Long getProyectoId() {
		return proyectoId;
	}
	public void setProyectoId(Long proyectoId) {
		this.proyectoId = proyectoId;
	}
	public Long getSubproyectoId() {
		return subproyectoId;
	}
	public void setSubproyectoId(Long subproyectoId) {
		this.subproyectoId = subproyectoId;
	}
	public Long getTareaId() {
		return tareaId;
	}
	public void setTareaId(Long tareaId) {
		this.tareaId = tareaId;
	}
	public String getProyectoDesc() {
		return proyectoDesc;
	}
	public void setProyectoDesc(String proyectoDesc) {
		this.proyectoDesc = proyectoDesc;
	}
	public String getSubproyectoDesc() {
		return subproyectoDesc;
	}
	public void setSubproyectoDesc(String subproyectoDesc) {
		this.subproyectoDesc = subproyectoDesc;
	}
	public String getTareaDesc() {
		return tareaDesc;
	}
	public void setTareaDesc(String tareaDesc) {
		this.tareaDesc = tareaDesc;
	}
	public Date getGastosFecha() {
		return gastosFecha;
	}
	public void setGastosFecha(Date gastosFecha) {
		this.gastosFecha = gastosFecha;
	}
	public Date getCreacionFecha() {
		return creacionFecha;
	}
	public void setCreacionFecha(Date creacionFecha) {
		this.creacionFecha = creacionFecha;
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
	public Double getTipoCambio() {
		return tipoCambio;
	}
	public void setTipoCambio(Double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}
	public Date getTipoCambioFecha() {
		return tipoCambioFecha;
	}
	public void setTipoCambioFecha(Date tipoCambioFecha) {
		this.tipoCambioFecha = tipoCambioFecha;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeDesc() {
		return employeeDesc;
	}
	public void setEmployeeDesc(String employeeDesc) {
		this.employeeDesc = employeeDesc;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierDesc() {
		return supplierDesc;
	}
	public void setSupplierDesc(String supplierDesc) {
		this.supplierDesc = supplierDesc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
    /**
	 * @return the departamentId
	 */
	public Long getDepartamentId() {
		return departamentId;
	}
	/**
	 * @param departamentId the departamentId to set
	 */
	public void setDepartamentId(Long departamentId) {
		this.departamentId = departamentId;
	}
	/**
	 * @return the departamentDesc
	 */
	public String getDepartamentDesc() {
		return departamentDesc;
	}
	/**
	 * @param departamentDesc the departamentDesc to set
	 */
	public void setDepartamentDesc(String departamentDesc) {
		this.departamentDesc = departamentDesc;
	}
	
	@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TicketHeader [ticketId=" + ticketId + ", proyectoId=" + proyectoId + ", subproyectoId=" + subproyectoId
				+ ", tareaId=" + tareaId + ", proyectoDesc=" + proyectoDesc + ", subproyectoDesc=" + subproyectoDesc
				+ ", tareaDesc=" + tareaDesc + ", gastosFecha=" + gastosFecha + ", creacionFecha=" + creacionFecha
				+ ", importe=" + importe + ", userId=" + userId + ", moneda=" + moneda + ", monedaFuncional="
				+ monedaFuncional + ", tipoCambio=" + tipoCambio + ", tipoCambioFecha=" + tipoCambioFecha
				+ ", employeeId=" + employeeId + ", employeeDesc=" + employeeDesc + ", supplierId=" + supplierId
				+ ", supplierDesc=" + supplierDesc + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", departamentId=" + departamentId + ", departamentDesc=" + departamentDesc + "]";
	}
	
    

}
