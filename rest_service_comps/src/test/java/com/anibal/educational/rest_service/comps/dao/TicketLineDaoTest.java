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
import com.anibal.educational.rest_service.domain.TicketLine;
import com.odhoman.api.utilities.dao.DAOException;

/**
 * 
 * Test del DAO de TicketLine
 * 
 * @author Jonatan Flores
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class TicketLineDaoTest {

	@Autowired
	TicketLineDao dao;

	@Autowired
	Logger logger;

	@Test
	public void testAllTicketLine() {
		logger.debug("testAllTicketLine: Iniciando...");

		TicketLine dg = null;

		try {
			dg = insertTicketLine();
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer insertar el TicketLine " + dg, e);
			fail(e.getMessage());
		}

		try {
			updateTicketLine(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el TicketLine " + dg, e);
			fail(e.getMessage());
		}
		
		try {
			updateTicketLine2(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el TicketLine " + dg, e);
			fail(e.getMessage());
		}

		try {
			dg = getTicketLine(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer obtener el TicketLine " + dg, e);
			fail(e.getMessage());
		}

		try {
			deleteTicketLine(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer eliminar el TicketLine " + dg, e);
			fail(e.getMessage());
		}

		logger.debug("testAllTicketLine: Finalizando...");
	}

	private void deleteTicketLine(TicketLine dg) throws DAOException {
		
		logger.debug("Se eliminará el siguiente TicketLine con id " + dg.getUserId());

		dao.deleteItem(dg);

		logger.debug("Se elminó el TicketLine con id " + dg.getUserId() + " correctamente");

	}

	private TicketLine getTicketLine(TicketLine t) throws DAOException {
		logger.debug("Se obtendra el siguiente TicketLine con id " + t.getUserId()
				+ " con los siguientes valores de filtro");
		logger.debug("==> " + t);

		t = dao.getItem(t);

		logger.debug("Se obtuvo el user " + t.getUserId() + " correctamente");
		logger.debug(t);
		return t;
	}

	private void updateTicketLine(TicketLine tl) throws Exception {
		TicketLine filtro = (TicketLine) tl.clone();

		tl.setTicketId(2342L);
		tl.setTipoGasto("asdfa");
		tl.setProveedorId(42342L);
		tl.setProveedorDesc("proveedor desc");
		tl.setCiudadId(855L);
		tl.setPaisId(55365L);
		tl.setCiudadDesc("ciudad");
		tl.setPaisDesc("pais");
		tl.setProyectoId(43545L);
		tl.setSubproyectoId(34534L);
		tl.setTareaId(4363L);
		tl.setProyectoDesc("ProyectoDesc");
//		tl.setSubproyectoDesc("SubproyectoDesc");
//		tl.setTareaDesc("TareaDesc");
//		tl.setGastosFecha(new Date());
//		tl.setImporte(234234D);
//		tl.setMoneda("moneda");
//		tl.setMonedaFuncional("mon fun");
//		tl.setTipoCambio(344D);
//		tl.setTipoCambioFecha(new Date());
//		tl.setUserId(234L);
//		tl.setCreacionFecha(new Date());
//		tl.setImageId(23424L);
//		tl.setPathImageId("PathImageId");

		logger.debug("Se actualizará el siguiente TicketLine con id " + tl.getUserId() + " con los siguientes valores");
		logger.debug("==> " + tl);

		dao.changeItem(filtro, tl);

		logger.debug("Se actualizó el TicketLine " + tl.getUserId() + " correctamente");

	}
	
	private void updateTicketLine2(TicketLine tl) throws Exception {
		TicketLine filtro = (TicketLine) tl.clone();

		tl.setTicketId(2342L);
//		tl.setTipoGasto("asdfa");
//		tl.setProveedorId(42342L);
//		tl.setCiudadId(855L);
//		tl.setPaisId(55365L);
//		tl.setCiudadDesc("ciudad");
//		tl.setPaisDesc("pais");
//		tl.setProyectoId(43545L);
//		tl.setSubproyectoId(34534L);
//		tl.setTareaId(4363L);
//		tl.setProyectoDesc("ProyectoDesc");
		tl.setSubproyectoDesc("SubproyectoDesc");
		tl.setTareaDesc("TareaDesc");
		tl.setGastosFecha(new Date());
		tl.setImporte(234234D);
		tl.setMoneda("moneda");
		tl.setMonedaFuncional("mon fun");
		tl.setTipoCambio(344D);
		tl.setTipoCambioFecha(new Date());
		tl.setUserId(234L);
		tl.setCreacionFecha(new Date());
		tl.setImageId(23424L);
		tl.setPathImage("PathImageId");
		tl.setLineDesc("lineDesc");

		logger.debug("Se actualizará el siguiente TicketLine con id " + tl.getUserId() + " con los siguientes valores");
		logger.debug("==> " + tl);

		dao.changeItem(filtro, tl);

		logger.debug("Se actualizó el TicketLine " + tl.getUserId() + " correctamente");

	}


	private TicketLine insertTicketLine() throws DAOException {
		TicketLine u = new TicketLine();

		logger.debug("Se insertará el siguiente TicketLine");
		logger.debug("==> " + u);

		dao.addItem(u);

		return u;
	}

}
