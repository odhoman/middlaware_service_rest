package com.anibal.educational.rest_service.comps.dao;

import static org.junit.Assert.fail;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anibal.educational.rest_service.comps.service.impl.AppConfigTest;
import com.anibal.educational.rest_service.domain.TicketDistribution;
import com.odhoman.api.utilities.dao.DAOException;


/**
 * 
 * Test del DAO de TicketDistribution
 * 
 * @author Jonatan Flores
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class TicketDistributionDaoTest {

	
	@Autowired
	TicketDistributionDao dao;
	
	@Autowired
	Logger logger;
	
	@Test
	public void testAllTicketDistributions() {
		logger.debug("testAllTicketDistributions: Iniciando...");

		TicketDistribution dg = null;

		try {
			dg = insertTicketDistribution();
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer insertar el TicketDistribution " + dg, e);
			fail(e.getMessage());
		}

		try {
			updateTicketDistribution(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el TicketDistribution " + dg, e);
			fail(e.getMessage());
		}
		
		try {
			updateTicketDistribution2(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el TicketDistribution " + dg, e);
			fail(e.getMessage());
		}

		try {
			dg = getTicketDistribution(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer obtener el TicketDistribution " + dg, e);
			fail(e.getMessage());
		}

		try {
			deleteTicketDistribution(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer eliminar el TicketDistribution " + dg, e);
			fail(e.getMessage());
		}

		logger.debug("testAllTicketDistributions: Finalizando...");
	}

	private void deleteTicketDistribution(TicketDistribution dg) throws DAOException {

		logger.debug("Se eliminará el siguiente TicketDistribution con id " + dg.getUserId());

		dao.deleteItem(dg);

		logger.debug("Se elminó el TicketDistribution con id " + dg.getUserId() + " correctamente");

	}

	private TicketDistribution getTicketDistribution(TicketDistribution t) throws DAOException {
		logger.debug("Se obtendra el siguiente TicketDistribution con id " + t.getUserId()
				+ " con los siguientes valores de filtro");
		logger.debug("==> " + t);

		t = dao.getItem(t);

		logger.debug("Se obtuvo el user " + t.getUserId() + " correctamente");
		logger.debug(t);
		return t;
	}

	private void updateTicketDistribution(TicketDistribution td) throws Exception {
		TicketDistribution filtro = (TicketDistribution) td.clone();

		td.setLineId(1000L);
		td.setTicketId(1111L);
		td.setTipoGasto("GASTO CAMBIANDO 1");
		td.setLineDesc("LINEA CAMBIADA 1");
		td.setGastosFecha(new Date());
		td.setCantidad(3333L);
		
		logger.debug(
				"Se actualizará el siguiente TicketDistribution con id " + td.getUserId() + " con los siguientes valores");
		logger.debug("==> " + td);

		dao.changeItem(filtro, td);

		logger.debug("Se actualizó el TicketDistribution " + td.getDistId() + " correctamente");

	}
	
	private void updateTicketDistribution2(TicketDistribution td) throws Exception {
		
		TicketDistribution filtro = (TicketDistribution) td.clone();
		
		td.setCbuDesc("123456789");
		td.setImporte(25487.21D);
		td.setMoneda("MON ");
		td.setMonedaFuncional("MON FUN");
		td.setUserId(321654L);
		td.setCreacionFecha(new Date());
		td.setLineNro(216546L);
		logger.debug(
				"Se actualizará el siguiente TicketDistribution con id " + td.getDistId() + " con los siguientes valores");
		logger.debug("==> " + td);

		dao.changeItem(filtro, td);

		logger.debug("Se actualizó el TicketDistribution " + td.getUserId() + " correctamente");

	}

	private TicketDistribution insertTicketDistribution() throws DAOException {
		TicketDistribution u = new TicketDistribution();

		logger.debug("Se insertará el siguiente TicketDistribution");
		logger.debug("==> " + u);

		dao.addItem(u);

		return u;
	}

	
}
