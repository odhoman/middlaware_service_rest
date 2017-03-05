package com.anibal.educational.rest_service.comps.service;

import java.util.List;

import com.anibal.educational.rest_service.domain.DetalleGasto;

public interface DetalleGastoService {
	
	public List<DetalleGasto> createDetallesGastos(List<DetalleGasto> detalles) throws DetalleGastoServiceException;
	
	public void updateDetallesGastos(List<DetalleGasto> detalles) throws DetalleGastoServiceException;
	
	public void deleteDetallesGastos(List<DetalleGasto> detalles) throws DetalleGastoServiceException;
	
	public List<DetalleGasto> getDetallesGastos(DetalleGasto filtro) throws DetalleGastoServiceException;

}
