package com.anibal.educational.rest_service.comps.service;

import java.util.List;

import com.anibal.educational.rest_service.domain.CabeceraGasto;

public interface CabeceraGastoService {
	
	public CabeceraGasto createCabeceraGasto(CabeceraGasto gasto) throws CabeceraGastoException;
	
	public CabeceraGasto getCabeceraGasto(CabeceraGasto filtro) throws CabeceraGastoException;
	
	public void updateCabeceraGasto(CabeceraGasto gasto, Long gastoId) throws CabeceraGastoException;
	
	public void deleteCabeceraGasto(Long gastoId) throws CabeceraGastoException;
	
	public void deleteCabecerasGasto(List<CabeceraGasto> filtros) throws CabeceraGastoException;

}
