package com.anibal.educational.rest_service.comps.service;

import com.anibal.educational.rest_service.domain.Moneda;

public interface MonedaService {
	
	public Moneda getMoneda(Long monedaId) throws MonedaServiceException;
	
	public void updateMoneda(Long monedaId, Moneda moneda) throws MonedaServiceException;
	
}
