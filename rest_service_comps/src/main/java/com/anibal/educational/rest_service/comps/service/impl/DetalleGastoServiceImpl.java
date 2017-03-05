package com.anibal.educational.rest_service.comps.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.anibal.educational.rest_service.comps.service.DetalleGastoService;
import com.anibal.educational.rest_service.comps.service.DetalleGastoServiceException;
import com.anibal.educational.rest_service.domain.DetalleGasto;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.dao.DAOException;

/**
 * Servicio de Detalle de Gastos
 * 
 * @author Jonatan
 *
 */
public class DetalleGastoServiceImpl extends AbstractService implements DetalleGastoService{
	
	AbstractAbmDAO<DetalleGasto, DetalleGasto> dao = null;

	public DetalleGastoServiceImpl(AbstractAbmDAO<DetalleGasto, DetalleGasto> dao, AbstractConfig config) {
		super(config);
		this.dao = dao;
	}

	public List<DetalleGasto> createDetallesGastos(List<DetalleGasto> detalles) throws DetalleGastoServiceException {

		logger.debug("DetalleGastoServiceImpl - createDetallesGastos: Iniciando...");
		
		try {
			getDao().addItems(detalles);
		} catch (DAOException e) {
			logger.error("Ocurrio una exception al querer insertar los detalles de gastos",e);
			throw new DetalleGastoServiceException(e);
		}
		
		logger.debug("DetalleGastoServiceImpl - createDetallesGastos: Finalizando...");
		
		return detalles;
	}

	public void updateDetallesGastos(List<DetalleGasto> detalles) throws DetalleGastoServiceException {
		
		logger.debug("DetalleGastoServiceImpl - updateDetallesGastos: Iniciando...");
		List<DetalleGasto> filtros = new ArrayList<DetalleGasto>();
		
		for(DetalleGasto dg: detalles){
			DetalleGasto filtro = new DetalleGasto();
			filtro.setDetalleId(dg.getDetalleId());
			filtros.add(filtro);
		}
		
		try {
			getDao().changeDifferentItems(filtros, detalles);
		} catch (DAOException e) {
			logger.error("Ocurrio una exception al querer actualizar los detalles de gastos",e);
			throw new DetalleGastoServiceException(e);
		}
		
		logger.debug("DetalleGastoServiceImpl - updateDetallesGastos: Finalizando...");
		
	}

	public void deleteDetallesGastos(List<DetalleGasto> detalles) throws DetalleGastoServiceException {
		
		logger.debug("DetalleGastoServiceImpl - deleteDetallesGastos: Iniciando...");
		
		List<DetalleGasto> filtros = new ArrayList<DetalleGasto>();
		
		for(DetalleGasto dg: detalles){
			DetalleGasto filtro = new DetalleGasto();
			filtro.setDetalleId(dg.getDetalleId());
			filtros.add(filtro);
		}
		
		try {
			getDao().deleteItems(filtros);
		} catch (DAOException e) {
			logger.error("Ocurrio una exception al querer eliminar los detalles de gastos",e);
			throw new DetalleGastoServiceException(e);
		}
		
		
		
		logger.debug("DetalleGastoServiceImpl - deleteDetallesGastos: Finalizando...");
		
	}

	public List<DetalleGasto> getDetallesGastos(DetalleGasto filtro) throws DetalleGastoServiceException {
		
		List<DetalleGasto> detalles = new ArrayList<DetalleGasto>();
		
		logger.debug("DetalleGastoServiceImpl - getDetallesGastos: Iniciando...");
		
		try {
			detalles = getDao().getItems(filtro);
		} catch (DAOException e) {
			logger.error("Ocurrio una exception al querer obtener los detalles de gastos",e);
			throw new DetalleGastoServiceException(e);
		}
		
		logger.debug("DetalleGastoServiceImpl - getDetallesGastos: Finalizando...");
		
		return detalles;
	}

	public AbstractAbmDAO<DetalleGasto, DetalleGasto> getDao() {
		return dao;
	}

}
