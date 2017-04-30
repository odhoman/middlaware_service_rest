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
import com.anibal.educational.rest_service.domain.TicketHeader;
import com.odhoman.api.utilities.dao.DAOException;

/**
 * 
 * Test del DAO de TicketHeader
 * 
 * @author Jonatan Flores
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class TicketHeaderDaoTest {

	@Autowired
	TicketHeaderDao dao;

	@Autowired
	Logger logger;

	@Test
	public void testAllTicketHeader() {
		logger.debug("testAllTicketHeader: Iniciando...");

		TicketHeader dg = null;

		try {
			dg = insertTicketHeader();
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer insertar el TicketHeader " + dg, e);
			fail(e.getMessage());
		}

		try {
			updateTicketHeader(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el TicketHeader " + dg, e);
			fail(e.getMessage());
		}

//		try {
//			dg = getTicketHeader(dg);
//		} catch (Exception e) {
//			logger.error("Ocurrio una excepcion al querer obtener el TicketHeader " + dg, e);
//			fail(e.getMessage());
//		}
//
//		try {
//			deleteTicketHeader(dg);
//		} catch (Exception e) {
//			logger.error("Ocurrio una excepcion al querer eliminar el TicketHeader " + dg, e);
//			fail(e.getMessage());
//		}

		logger.debug("testAllTicketHeader: Finalizando...");
	}

	private void deleteTicketHeader(TicketHeader dg) throws DAOException {

		logger.debug("Se eliminará el siguiente TicketHeader con id " + dg.getUserId());

		dao.deleteItem(dg);

		logger.debug("Se elminó el TicketHeader con id " + dg.getUserId() + " correctamente");

	}

	private TicketHeader getTicketHeader(TicketHeader t) throws DAOException {
		logger.debug("Se obtendra el siguiente TicketHeader con id " + t.getUserId()
				+ " con los siguientes valores de filtro");
		logger.debug("==> " + t);

		t = dao.getItem(t);

		logger.debug("Se obtuvo el user " + t.getUserId() + " correctamente");
		logger.debug(t);
		return t;
	}

	private void updateTicketHeader(TicketHeader t) throws Exception {
		TicketHeader filtro = (TicketHeader) t.clone();

		t.setProyectoId(123L);
		t.setSubproyectoId(123L);
		t.setTareaId(43434L);
		t.setProyectoDesc("PROYECTO DESC");
		t.setSubproyectoDesc("SUBPROYECTO_DESC");
		t.setTareaDesc("TAREA_DESC");
		t.setGastosFecha(new Date());
		t.setCreacionFecha(new Date());
		t.setImporte(43345345D);
		t.setUserId(852L);
		t.setMoneda("MONEDA");
		t.setMonedaFuncional("MON_FUN");
		t.setTipoCambio(343434D);
		t.setTipoCambioFecha(new Date());
		t.setEmployeeId(5453L);
		t.setEmployeeDesc("EMPLOYEE_DESC");
		t.setSupplierId(85L);
		t.setSupplierDesc("SUPPLIER_DESC");
		t.setEmail("EMAIL");
		t.setPhoneNumber("PHONE_NUMBER");
		t.setDepartamentId(55155L);
		t.setDepartamentDesc("DEPARTMENT_DESC");

		logger.debug(
				"Se actualizará el siguiente TicketHeader con id " + t.getUserId() + " con los siguientes valores");
		logger.debug("==> " + t);

		dao.changeItem(filtro, t);

		logger.debug("Se actualizó el TicketHeader " + t.getUserId() + " correctamente");

	}

	private TicketHeader insertTicketHeader() throws DAOException {
		TicketHeader u = new TicketHeader();

		logger.debug("Se insertará el siguiente TicketHeader");
		logger.debug("==> " + u);

		dao.addItem(u);

		return u;
	}

}
