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
import com.anibal.educational.rest_service.domain.CabeceraGasto;
import com.odhoman.api.utilities.dao.DAOException;

/**
 * 
 * Test del DAO de Cabecera Gasto
 * 
 * @author Jonatan Flores
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class CabeceraGastoDaoTest {

	@Autowired
	CabeceraGastoDao dao;

	@Autowired
	Logger logger;

	@Test
	public void testAllGastoCabecera() {

		logger.debug("test1AllGastoCabecera: Iniciando...");

		CabeceraGasto gastoPrueba = null;

		try {

			gastoPrueba = insertCabeceraGasto();

		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer insertar el gasto " + gastoPrueba, e);
			fail(e.getMessage());
			return;
		}

		try {
			updateCabeceraGasto(gastoPrueba);
		} catch (CloneNotSupportedException e) {
			logger.error("Ocurrio una excepcion al querer clonar el gasto " + gastoPrueba, e);
			fail(e.getMessage());
			return;
		} catch (DAOException e) {
			logger.error("Ocurrio una excepcion al querer actualizar el gasto " + gastoPrueba, e);
			fail(e.getMessage());
			return;
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el gasto " + gastoPrueba, e);
			fail(e.getMessage());
			return;
		}
		try {

			gastoPrueba = getCabeceraGasto(gastoPrueba);

		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer obtener el gasto " + gastoPrueba, e);
			fail(e.getMessage());
			return;
		}

		try {

			deleteCabeceraGasto(gastoPrueba);

		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer obtener el gasto " + gastoPrueba, e);
			fail(e.getMessage());
			return;
		}

		logger.debug("test1AllGastoCabecera: Finalizando...");

	}

	private List<CabeceraGasto> insertCabecerasGastos() throws Exception {

		List<CabeceraGasto> lista = new ArrayList<CabeceraGasto>();

		for (int i = 0; i < 5; i++) {

			CabeceraGasto gasto = new CabeceraGasto();

			gasto.setGastoNro(1L + i);
			gasto.setProyectoId(1L + i);
			gasto.setSubProyectoId(1L + i);
			gasto.setTipoGasto("gasto" + i);
			gasto.setCiudad("ciudad" + i);
			gasto.setPais("pais" + i);
			gasto.setProveedor("proveedor" + i);
			gasto.setTipoCambio(1D + i);
			gasto.setImporte(1D + i);
			gasto.setUserId(1L + i);
			gasto.setObservaciones("observaciones" + i);
			gasto.setFechaGasto(new Date());

			lista.add(gasto);

		}

		logger.debug("Se insertarán " + lista.size() + " gastos nuevos");
		dao.addItems(lista);

		logger.debug("Se han insertado correctamente los siguientes gastos:");
		for (int i = 0; i < lista.size(); i++) {
			logger.debug("== >" + lista.get(i));
		}
		return lista;

	}

	private List<CabeceraGasto> updateCabecerasGastos(List<CabeceraGasto> filtros, List<CabeceraGasto> lista)
			throws Exception {

		List<CabeceraGasto> listaCambiada = new ArrayList<CabeceraGasto>();

		for (int i = 0; i < lista.size(); i++) {

			CabeceraGasto gastoPrueba = new CabeceraGasto();
			gastoPrueba.setGastoId(lista.get(i).getGastoId());

			if (i == 0) {
				gastoPrueba.setGastoNro(9999L);
				gastoPrueba.setProyectoId(9999L);
				gastoPrueba.setSubProyectoId(9999L);
				gastoPrueba.setTipoGasto("gasto");
				gastoPrueba.setCiudad("ciudad");
				gastoPrueba.setPais("pais");
				gastoPrueba.setProveedor("proveedor");
				gastoPrueba.setTipoCambio(1D);
				gastoPrueba.setImporte(1D);
				gastoPrueba.setUserId(1L);
				gastoPrueba.setObservaciones("observaciones");
				gastoPrueba.setFechaGasto(new Date());

			} else if (i == 1) {

				gastoPrueba.setGastoNro(1L);
				gastoPrueba.setProyectoId(1L);
				gastoPrueba.setSubProyectoId(1L);
				gastoPrueba.setProveedor("proveedor");
				gastoPrueba.setTipoCambio(1D);
				gastoPrueba.setImporte(1D);
				gastoPrueba.setUserId(1L);
				gastoPrueba.setObservaciones("observaciones");
				gastoPrueba.setFechaGasto(new Date());

				gastoPrueba.setTipoGasto("GASTO CAMBIADO");
				gastoPrueba.setCiudad("CIUDAD CAMBIADA");
				gastoPrueba.setPais("PAIS CAMBIADO");

			} else if (i == 2) {

				gastoPrueba.setGastoNro(1L);
				gastoPrueba.setProyectoId(1L);
				gastoPrueba.setSubProyectoId(1L);
				gastoPrueba.setTipoGasto("gasto");
				gastoPrueba.setCiudad("ciudad");
				gastoPrueba.setPais("pais");
				gastoPrueba.setImporte(1D);
				gastoPrueba.setUserId(1L);
				gastoPrueba.setObservaciones("observaciones");
				gastoPrueba.setFechaGasto(new Date());

				gastoPrueba.setProveedor("proveedor cambiado");
				gastoPrueba.setTipoCambio(99.99D);

			} else if (i == 3) {
				gastoPrueba.setImporte(99999D);
				gastoPrueba.setUserId(99999L);

				gastoPrueba.setGastoNro(1L);
				gastoPrueba.setProyectoId(1L);
				gastoPrueba.setSubProyectoId(1L);
				gastoPrueba.setTipoGasto("gasto");
				gastoPrueba.setCiudad("ciudad");
				gastoPrueba.setPais("pais");
				gastoPrueba.setProveedor("proveedor");
				gastoPrueba.setTipoCambio(1D);
				gastoPrueba.setObservaciones("observaciones");
				gastoPrueba.setFechaGasto(new Date());

			} else if (i == 4) {
				gastoPrueba.setObservaciones(null);
				gastoPrueba.setFechaGasto(null);

				gastoPrueba.setGastoNro(null);
				gastoPrueba.setProyectoId(null);
				gastoPrueba.setSubProyectoId(null);
				gastoPrueba.setTipoGasto(null);
				gastoPrueba.setCiudad(null);
				gastoPrueba.setPais(null);
				gastoPrueba.setProveedor(null);
				gastoPrueba.setTipoCambio(null);
				gastoPrueba.setImporte(null);
				gastoPrueba.setUserId(null);
			}

			listaCambiada.add(gastoPrueba);

		}

		dao.changeDifferentItems(filtros, listaCambiada);

		return listaCambiada;

	}

	private void deleteCabecerasGastos(List<CabeceraGasto> filtros) throws Exception {
		dao.deleteItems(filtros);
	}

	@Test
	public void testAllCabecerasGastos() {

		List<CabeceraGasto> lista = null;
		try {
			lista = insertCabecerasGastos();
		} catch (Exception e) {
			logger.debug("Ocurrio una excepcion al querer insertar los gastos", e);
			fail(e.getMessage());
		}

		List<CabeceraGasto> filtros = new ArrayList<CabeceraGasto>();

		for (CabeceraGasto cg : lista) {
			CabeceraGasto cg2 = new CabeceraGasto();
			cg2.setGastoId(cg.getGastoId());
			filtros.add(cg2);
		}

		try {
			filtros = updateCabecerasGastos(filtros, lista);
		} catch (Exception e) {
			logger.debug("Ocurrio una excepcion al querer actualizar los gastos", e);
			fail(e.getMessage());
		}

		try {
			deleteCabecerasGastos(filtros);
		} catch (Exception e) {
			logger.debug("Ocurrio una excepcion al querer eliminar los gastos", e);
			fail(e.getMessage());
		}

	}

	private CabeceraGasto insertCabeceraGasto() throws Exception {

		CabeceraGasto gastoPrueba = new CabeceraGasto();

		// gastoPrueba.setGastoNro(1L);
		// gastoPrueba.setProyectoId(1L);
		// gastoPrueba.setSubProyectoId(1L);
		// gastoPrueba.setTipoGasto("gasto");
		// gastoPrueba.setCiudad("ciudad");
		// gastoPrueba.setPais("pais");
		// gastoPrueba.setProveedor("proveedor");
		// gastoPrueba.setTipoCambio(1D);
		// gastoPrueba.setImporte(1D);
		// gastoPrueba.setUserId(1L);
		// gastoPrueba.setObservaciones("observaciones");
		// gastoPrueba.setFechaGasto(new Date());

		logger.debug("Se insertará el siguiente gasto " + gastoPrueba);

		dao.addItem(gastoPrueba);

		logger.debug("Se insertó exitosamente, el gasto " + gastoPrueba + " con id " + gastoPrueba.getGastoId());

		return gastoPrueba;

	}

	private void updateCabeceraGasto(CabeceraGasto gc) throws Exception {

		CabeceraGasto filtro = (CabeceraGasto) gc.clone();

		gc.setProyectoId(132L);
		gc.setGastoNro(1232L);
		gc.setSubProyectoId(1232L);
		gc.setTipoGasto("gasto3e23e");
		gc.setCiudad("ciudad23e");
		gc.setPais("pais23e2");
		gc.setProveedor("proveede32e3eor");
		gc.setTipoCambio(323232D);
		gc.setImporte(114141D);
		gc.setUserId(141424L);
		gc.setObservaciones("34f14f143f1");
		gc.setFechaGasto(new Date());

		logger.debug("Se intentará actualiza el gasto " + gc.getGastoId() + " con los siguientes valores");
		logger.debug("==> " + gc);

		dao.changeItem(filtro, gc);

		logger.debug("Se actualizó el gasto " + gc.getGastoId() + " correctamente");

	}

	private CabeceraGasto getCabeceraGasto(CabeceraGasto cg) throws Exception {

		logger.debug("Se intentará obtener el gasto con los siguiente valores de filtro ");
		logger.debug("==> " + cg);

		CabeceraGasto cg2 = dao.getItem(cg);

		logger.debug("Se encontró el gasto con los siguientes valores");
		logger.debug("==> " + cg);

		return cg2;

	}

	private void deleteCabeceraGasto(CabeceraGasto cg) throws Exception {

		logger.debug("Se intentará eliminar el gasto con los siguiente valores de filtro ");
		logger.debug("==> " + cg);

		dao.deleteItem(cg);

		logger.debug("Se pudo eliminar exitosamente el gasto");
	}

}
