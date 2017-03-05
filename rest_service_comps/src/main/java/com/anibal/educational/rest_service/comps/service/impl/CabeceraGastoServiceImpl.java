package com.anibal.educational.rest_service.comps.service.impl;

import java.util.List;

import com.anibal.educational.rest_service.comps.service.CabeceraGastoException;
import com.anibal.educational.rest_service.comps.service.CabeceraGastoService;
import com.anibal.educational.rest_service.domain.CabeceraGasto;
import com.anibal.educational.rest_service.domain.DetalleGasto;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.dao.DAOException;

/**
 * Servicio de Cabecera de Gastos
 * 
 * @author Jonatan
 *
 */
public class CabeceraGastoServiceImpl extends AbstractService implements CabeceraGastoService {

	AbstractAbmDAO<CabeceraGasto, CabeceraGasto> dao = null;
	AbstractAbmDAO<DetalleGasto, DetalleGasto> daoDetalle = null;

	public CabeceraGastoServiceImpl(AbstractAbmDAO<CabeceraGasto, CabeceraGasto> dao,
			AbstractAbmDAO<DetalleGasto, DetalleGasto> daoDetalle,AbstractConfig config) {
		super(config);
		this.dao = dao;
		this.daoDetalle = daoDetalle;
	}

	public CabeceraGasto createCabeceraGasto(CabeceraGasto gasto) throws CabeceraGastoException {

		logger.debug("CabeceraGastoServiceImpl - createCabeceraGasto: Iniciando...");

		try {
			// TODO Aca podria haber algun tipo de validacion de entrada

			getDao().addItem(gasto);
		} catch (DAOException e) {
			logger.error("Ocurrio una excepcion al querer insertar un nuevo gasto ", e);
			throw new CabeceraGastoException(e);
		}

		logger.debug("CabeceraGastoServiceImpl - createCabeceraGasto: Finalizando...");

		return gasto;
	}

	public CabeceraGasto getCabeceraGasto(CabeceraGasto filtro) throws CabeceraGastoException {

		CabeceraGasto gasto = null;
		logger.debug("CabeceraGastoServiceImpl - getCabeceraGasto: Iniciando...");

		try {
			gasto = getDao().getItem(filtro);
		} catch (DAOException e) {
			logger.error("Ocurrio una excepcion al querer obtener un gasto ", e);
			throw new CabeceraGastoException(e);
		}

		logger.debug("CabeceraGastoServiceImpl - getCabeceraGasto: Finalizando...");

		return gasto;
	}

	public void updateCabeceraGasto(CabeceraGasto gasto, Long gastoId) throws CabeceraGastoException {

		logger.debug("CabeceraGastoServiceImpl - updateCabeceraGasto: Iniciando...");

		CabeceraGasto filter = new CabeceraGasto();
		filter.setGastoId(gastoId);

		try {
			getDao().changeItem(filter, gasto);
		} catch (DAOException e) {
			logger.error("Ocurrio una excepcion al querer cambiar un gasto ", e);
			throw new CabeceraGastoException(e);
		}

		logger.debug("CabeceraGastoServiceImpl - updateCabeceraGasto: Finalizando...");

	}

	public void deleteCabeceraGasto(Long gastoId) throws CabeceraGastoException {
		logger.debug("CabeceraGastoServiceImpl - deleteCabeceraGasto: Iniciando...");

		CabeceraGasto filter = new CabeceraGasto();
		filter.setGastoId(gastoId);

		try {
			getDao().deleteItem(filter);
		} catch (DAOException e) {
			logger.error("Ocurrio una excepcion al querer eliminar un gasto ", e);
			throw new CabeceraGastoException(e);
		}
		
		//TODO: Ver si es necesario eliminar tambien los detalles de gastos ligdaos a la cabecera

		logger.debug("CabeceraGastoServiceImpl - deleteCabeceraGasto: Finalizando...");

	}

	public void deleteCabecerasGasto(List<CabeceraGasto> filtros) throws CabeceraGastoException {

		logger.debug("CabeceraGastoServiceImpl - deleteCabecerasGasto: Iniciando...");

		try {
			getDao().deleteItems(filtros);
		} catch (DAOException e) {
			logger.error("Ocurrio una excepcion al querer obtener un gasto ", e);
			throw new CabeceraGastoException(e);
		}
		
		//TODO: Ver si es necesario eliminar tambien los detalles de gastos ligdaos a la cabecera

		logger.debug("CabeceraGastoServiceImpl - deleteCabecerasGasto: Finalizando...");

	}

	public AbstractAbmDAO<CabeceraGasto, CabeceraGasto> getDao() {
		return dao;
	}

	public AbstractAbmDAO<DetalleGasto, DetalleGasto> getDaoDetalle() {
		return daoDetalle;
	}
	
	

}
