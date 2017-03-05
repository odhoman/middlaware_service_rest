package com.anibal.educational.rest_service.comps.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anibal.educational.rest_service.comps.service.impl.AppConfigTest;
import com.anibal.educational.rest_service.domain.DetalleGasto;
import com.odhoman.api.utilities.dao.DAOException;

/**
 * 
 * Test del DAO de Detalle de Gasto
 * 
 * @author Jonatan Flores
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class DetalleGastoDaoTest {

	@Autowired
	DetalleGastoDao dao;

	@Autowired
	Logger logger;

	@Test
	public void testAllDetalleGasto() {

		logger.debug("testAllDetalleGasto: Iniciando...");

		DetalleGasto dg = null;

		try {
			dg = insertDetalleGasto();
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer insertar el detalle de gasto " + dg, e);
			fail(e.getMessage());
		}

		try {
			updateDetallGasto(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el detalle de gasto " + dg, e);
			fail(e.getMessage());
		}

		try {
			dg = getDetalleGasto(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer obtener el detalle de gasto " + dg, e);
			fail(e.getMessage());
		}

		try {
			deleteDetalleGasto(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer eliminar el detalle de gasto " + dg, e);
			fail(e.getMessage());
		}

		logger.debug("testAllDetalleGasto: Finalizando...");

	}

	@Test
	public void testAllDetallesGasto() {
		
		logger.debug("testAllDetallesGasto: Iniciando...");

		List<DetalleGasto> lista = null;

		try {
			lista = insertDetallesGastos();
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer insertar los detalles de gasto ", e);
			fail(e.getMessage());
		}

		try {
			lista = updateDetallesGastos(lista);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar los detalles de gasto ", e);
			fail(e.getMessage());
		}
		
		try {
			DetalleGasto filtro = new DetalleGasto();
			filtro.setGastoId(9999999L);
			lista = getDetallesGastos(filtro);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer obtener los detalles de gasto ", e);
			fail(e.getMessage());
		}
		
		try {
			deleteDetallesGasto(lista);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer eliminar los detalles de gasto ", e);
			fail(e.getMessage());
		}
		
		logger.debug("testAllDetallesGasto: Finalizando...");

	}

	private void deleteDetallesGasto(List<DetalleGasto> filters) throws Exception{
		
		logger.debug("Se insertarán eliminar detalles de gasto con los siguientes filtros ");
		
		for (DetalleGasto dg : filters)
			logger.debug("==> " + dg);
		
		dao.deleteItems(filters);
		
		logger.debug("Se eliminaron correctamente los detalles de gastos");
		
	}
	
	
	
	
	
	private List<DetalleGasto> getDetallesGastos(DetalleGasto filtro) throws Exception {

		List<DetalleGasto> newList = null;
		logger.debug("Se insertarán obtener detalles de gasto con el siguiente filtro ");
		logger.debug("==> " + filtro);

		newList = dao.getItems(filtro);
		
		logger.debug("Se consiguieron " + newList.size() + " detalles de gastos con los siguientes valores");

		for (DetalleGasto dg : newList)
			logger.debug("==> " + dg);
		
		return newList;
	}

	private List<DetalleGasto> updateDetallesGastos(List<DetalleGasto> filters) throws Exception {

		List<DetalleGasto> newList = new ArrayList<DetalleGasto>();

		for (int i = 0; i < filters.size(); i++) {

			DetalleGasto dg = filters.get(i);
			newList.add(dg);

			if (i == 0) {
				dg.setGastoId(9999999L);
				dg.setGastosNro(2999999L);

			} else if (i == 1) {
				dg.setGastoId(9999999L);
				dg.setTarea("TAREA CAMBIADA");
				dg.setFechaGasto(new Date());

			} else if (i == 2) {
				dg.setGastoId(9999999L);
				dg.setTipoCambio(9999.25D);
				dg.setImporte(58685.87D);
			} else if (i == 3) {
				dg.setGastoId(9999999L);
				dg.setCodeConvinationId(999999L);
				dg.setObservaciones("OBSERVACIONES CAMBIADAS");
			} else if (i == 4) {
				dg.setGastoId(9999999L);
			}
		}

		logger.debug("Se insertarán actualizar" + filters.size() + " detalles de gasto");

		dao.changeDifferentItems(filters, newList);

		logger.debug("Se actualizaron" + newList.size() + " detalles de gastos con los siguientes valores");

		for (DetalleGasto dg : newList)
			logger.debug("==> " + dg);

		return newList;
	}

	private List<DetalleGasto> insertDetallesGastos() throws Exception {

		List<DetalleGasto> lista = new ArrayList<DetalleGasto>();

		for (int i = 0; i < 5; i++)
			lista.add(new DetalleGasto());

		logger.debug("Se insertarán " + lista.size() + " detalles de gasto");

		dao.addItems(lista);

		logger.debug("Se insertaron correctamente los siguientes detalles de gasto");

		for (DetalleGasto dg : lista)
			logger.debug("==> " + dg);

		return lista;

	}

	private void deleteDetalleGasto(DetalleGasto dg) throws Exception {

		logger.debug("Se eliminará el siguiente detalle de gasto con id " + dg.getDetalleId());

		dao.deleteItem(dg);

		logger.debug("Se elminó el detalle de gasto con id " + dg.getDetalleId() + " correctamente");
	}

	private DetalleGasto getDetalleGasto(DetalleGasto dg) throws Exception {

		logger.debug("Se obtendra el siguiente detalle de gasto con id " + dg.getDetalleId()
				+ " con los siguientes valores de filtro");
		logger.debug("==> " + dg);

		dg = dao.getItem(dg);

		logger.debug("Se obtuvo el detalle de gasto " + dg.getDetalleId() + " correctamente");

		return dg;
	}

	private void updateDetallGasto(DetalleGasto dg) throws Exception {

		DetalleGasto filtro = (DetalleGasto) dg.clone();

		dg.setGastoId(234L);
		dg.setGastosNro(2L);
		dg.setTarea("tarea");
		dg.setFechaGasto(new Date());
		dg.setTipoCambio(545D);
		dg.setImporte(2342D);
		dg.setCodeConvinationId(141L);
		dg.setObservaciones("sdfsdf");

		logger.debug("Se actualizará el siguiente detalle de gasto con id " + dg.getDetalleId()
				+ " con los siguientes valores");
		logger.debug("==> " + dg);

		dao.changeItem(filtro, dg);

		logger.debug("Se actualizó el detalle de gasto " + dg.getDetalleId() + " correctamente");

	}

	private DetalleGasto insertDetalleGasto() throws DAOException {

		DetalleGasto dg = new DetalleGasto();

		logger.debug("Se insertará el siguiente detalle de gasto ");
		logger.debug("==> " + dg);

		dao.addItem(dg);

		logger.debug("Se insertó el siguiente detalle con id " + dg.getDetalleId());

		return dg;
	}

}
