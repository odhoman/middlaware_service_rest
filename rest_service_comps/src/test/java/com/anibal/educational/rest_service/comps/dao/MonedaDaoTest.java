package com.anibal.educational.rest_service.comps.dao;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anibal.educational.rest_service.comps.service.impl.AppConfigTest;
import com.anibal.educational.rest_service.domain.Moneda;
import com.odhoman.api.utilities.dao.DAOException;

/**
 * 
 * Test del DAO de Moneda
 * 
 * @author Jonatan Flores
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class MonedaDaoTest {
	
	@Autowired
	MonedaDao dao;

	@Autowired
	Logger logger;
	

	@Test
	public void testAllMoneda() {
		logger.debug("testAllMoneda: Iniciando...");

		Moneda dg = null;

		try {
			dg = insertMoneda();
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer insertar el Moneda " + dg, e);
			fail(e.getMessage());
		}

		try {
			updateMoneda(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el Moneda " + dg, e);
			fail(e.getMessage());
		}
		
		try {
			updateMoneda2(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el Moneda " + dg, e);
			fail(e.getMessage());
		}

		try {
			dg = getMoneda(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer obtener el Moneda " + dg, e);
			fail(e.getMessage());
		}

		try {
			deleteMoneda(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer eliminar el Moneda " + dg, e);
			fail(e.getMessage());
		}

		logger.debug("testAllMoneda: Finalizando...");
	}

	private void deleteMoneda(Moneda dg) throws DAOException {
		
		logger.debug("Se eliminará el siguiente Moneda con id " + dg.getUserId());

		dao.deleteItem(dg);

		logger.debug("Se elminó el Moneda con id " + dg.getMonedaId() + " correctamente");

	}

	private Moneda getMoneda(Moneda t) throws DAOException {
		logger.debug("Se obtendra el siguiente Moneda con id " + t.getMonedaId()
				+ " con los siguientes valores de filtro");
		logger.debug("==> " + t);

		t = dao.getItem(t);

		logger.debug("Se obtuvo el user " + t.getMonedaId() + " correctamente");
		logger.debug(t);
		return t;
	}

	private void updateMoneda(Moneda tl) throws Exception {
		Moneda filtro = (Moneda) tl.clone();

		tl.setMonedaName("asdfa");
		tl.setTipoCambio(25.21D);

		logger.debug("Se actualizará el siguiente Moneda con id " + tl.getMonedaId() + " con los siguientes valores");
		logger.debug("==> " + tl);

		dao.changeItem(filtro, tl);

		logger.debug("Se actualizó el Moneda " + tl.getMonedaId() + " correctamente");

	}
	
	private void updateMoneda2(Moneda tl) throws Exception {
		Moneda filtro = (Moneda) tl.clone();

		tl.setMonedaName("EQRQER");
		tl.setTipoCambio(78.222D);

		logger.debug("Se actualizará el siguiente Moneda con id " + tl.getMonedaId() + " con los siguientes valores");
		logger.debug("==> " + tl);

		dao.changeItem(filtro, tl);

		logger.debug("Se actualizó el Moneda " + tl.getMonedaId() + " correctamente");

	}
	
	private Moneda insertMoneda() throws DAOException {
		Moneda u = new Moneda();
		return insertMoneda(u);
	}
	
	private Moneda insertMoneda(Moneda u) throws DAOException {

		logger.debug("Se insertará el siguiente Moneda");
		logger.debug("==> " + u);

		dao.addItem(u);

		return u;
	}

}
