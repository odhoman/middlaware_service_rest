package com.anibal.educational.rest_service.comps.service.impl;

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

import com.anibal.educational.rest_service.comps.service.DetalleGastoService;
import com.anibal.educational.rest_service.comps.service.DetalleGastoServiceException;
import com.anibal.educational.rest_service.domain.DetalleGasto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class DetalleGastoServiceTest {

	@Autowired
	DetalleGastoService detalleGastoService;

	@Autowired
	Logger logger;

	@Test
	public void testAllDetalleGastoService() {

		List<DetalleGasto> detalles = null;

		logger.debug("testAllDetalleGastoService: Iniciando...");

		try {
			detalles = insertDetallesGastos();
		} catch (DetalleGastoServiceException e) {
			logger.error("Ocurrio una excepcion al querer insertar los detalles de gastos ", e);
			fail(e.getMessage());
		}

		try {
			detalles = updateDetallesGasto(detalles);
		} catch (DetalleGastoServiceException e) {
			logger.error("Ocurrio una excepcion al querer actualizar los detalles de gastos ", e);
			fail(e.getMessage());
		}

		DetalleGasto filtro = new DetalleGasto();
		filtro.setGastoId(9999999L);

		try {
			detalles = getDetallesGastos(filtro);
		} catch (DetalleGastoServiceException e) {
			logger.error("Ocurrio una excepcion al querer obtener los detalles de gastos ", e);
			fail(e.getMessage());
		}
		
		try {

			deleteDetallesGastos(detalles);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer obtener los detalles de gastos ", e);
			fail(e.getMessage());
		}

		logger.debug("testAllDetalleGastoService: Finalizado...");

	}

	private void deleteDetallesGastos(List<DetalleGasto> detalles) throws DetalleGastoServiceException {
		logger.debug("Se intenta eliminar los detalles de gastos");

		detalleGastoService.deleteDetallesGastos(detalles);

		logger.debug("Se eliminaron correctamente los detalles de gastos:");
	}

	private List<DetalleGasto> getDetallesGastos(DetalleGasto filtro) throws DetalleGastoServiceException {
		logger.debug("Se intenta obtener detalles de gastos");

		List<DetalleGasto> detalles = detalleGastoService.getDetallesGastos(filtro);

		logger.debug("Se obtuvieron correctamente los siguientes detalles de gastos:");
		for (DetalleGasto dg : detalles)
			logger.debug("==> " + dg);

		return detalles;
	}

	private List<DetalleGasto> updateDetallesGasto(List<DetalleGasto> detalles) throws DetalleGastoServiceException {

		logger.debug("Se intenta insertar detalles de gastos");

		for (int i = 0; i < detalles.size(); i++) {

			DetalleGasto dg = detalles.get(i);
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

		detalleGastoService.updateDetallesGastos(detalles);

		logger.debug("Se actualizaron correctamente los siguientes detalles de gastos:");
		for (DetalleGasto dg : detalles)
			logger.debug("==> " + dg);

		return detalles;

	}

	private List<DetalleGasto> insertDetallesGastos() throws DetalleGastoServiceException {
		List<DetalleGasto> detalles = new ArrayList<DetalleGasto>();

		logger.debug("Se intenta insertar detalles de gastos");

		for (int i = 0; i < 5; i++) {
			DetalleGasto dg = new DetalleGasto();
			dg.setGastoId(999L);
			detalles.add(dg);
		}

		detalleGastoService.createDetallesGastos(detalles);

		logger.debug("Se insertaron correctamente los siguientes detalles de gastos:");
		for (DetalleGasto dg : detalles)
			logger.debug("==> " + dg);

		return detalles;
	}

}
