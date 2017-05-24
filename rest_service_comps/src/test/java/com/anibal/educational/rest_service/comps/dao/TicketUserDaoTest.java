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
import com.anibal.educational.rest_service.domain.TicketUser;
import com.odhoman.api.utilities.dao.DAOException;

/**
 * 
 * Test del DAO de User
 * 
 * @author Jonatan Flores
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class TicketUserDaoTest {

	@Autowired
	TicketUserDao dao;

	@Autowired
	Logger logger;

	@Test
	public void testAllUser() {

		logger.debug("testAllUser: Iniciando...");

		TicketUser dg = null;

		try {
			dg = insertUser();
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer insertar el user " + dg, e);
			fail(e.getMessage());
		}

		try {
			updateUser(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el user " + dg, e);
			fail(e.getMessage());
		}
		
		try {
			updateUser2(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el user " + dg, e);
			fail(e.getMessage());
		}

		try {
			dg = getUser(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer obtener el user " + dg, e);
			fail(e.getMessage());
		}

		try {
			deleteUser(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer eliminar el user " + dg, e);
			fail(e.getMessage());
		}

		logger.debug("testAllUser: Finalizando...");

	}

	private void deleteUser(TicketUser dg) throws DAOException {

		logger.debug("Se eliminará el siguiente user con id " + dg.getUserId());

		dao.deleteItem(dg);

		logger.debug("Se elminó el user con id " + dg.getUserId() + " correctamente");

	}

	private TicketUser getUser(TicketUser dg) throws DAOException {

		logger.debug("Se obtendra el siguiente user con id " + dg.getUserId() + " con los siguientes valores de filtro");
		logger.debug("==> " + dg);

		dg = dao.getItem(dg);

		logger.debug("Se obtuvo el user " + dg.getUserId() + " correctamente");
		logger.debug(dg);

		return dg;
	}

	private void updateUser2(TicketUser u) throws Exception {

		TicketUser filtro = (TicketUser) u.clone();

//		u.setUserName("NOMBRE_CAMbiado");
//		u.setUserFirstame("Juan");
//		u.setUserLastName("PEREZ");
//		u.setUserEmail("asdfads@gmail.com");
//		u.setUserPhoneNumber("12156545654");
//		u.setHireDateStart(new Date());
//		u.setHireDateEnd(new Date());
//		u.setStreet("calle");
		u.setCity("ciudad");
		u.setState("BUenos Aires");
		u.setZipCode("1657");
		u.setCountry("Argentina");
		u.setEmployeeId(5L);
		u.setEmployeeDesc("empleado comun");
		u.setImageId(3L);
		u.setPathImage("path");

		logger.debug(
				"Se actualizará el siguiente detalle usuario con id " + u.getUserId() + " con los siguientes valores");
		logger.debug("==> " + u);

		dao.changeItem(filtro, u);

		logger.debug("Se actualizó el usuario " + u.getUserId() + " correctamente");

	}
	
	
	private void updateUser(TicketUser u) throws Exception {

		TicketUser filtro = (TicketUser) u.clone();

		u.setUserName("NOMBRE_CAMbiado");
		u.setUserFirstame("Juan");
		u.setUserLastName("PEREZ");
		u.setUserEmail("asdfads@gmail.com");
		u.setUserPhoneNumber("12156545654");
		u.setHireDateStart(new Date());
		u.setHireDateEnd(new Date());
		u.setStreet("calle");
		u.setUserPassword("5f4dcc3b5aa765d61d8327deb882cf99");
//		u.setCity("ciudad");
//		u.setState("BUenos Aires");
//		u.setZipCode("1657");
//		u.setCountry("Argentina");
//		u.setEmployeeId(5L);
//		u.setEmployeeDesc("empleado comun");
//		u.setImageId(3L);
//		u.setPathImage("path");

		logger.debug(
				"Se actualizará el siguiente detalle usuario con id " + u.getUserId() + " con los siguientes valores");
		logger.debug("==> " + u);

		dao.changeItem(filtro, u);

		logger.debug("Se actualizó el usuario " + u.getUserId() + " correctamente");

	}

	private TicketUser insertUser() throws DAOException {

		TicketUser u = new TicketUser();
		
		u.setUserPassword("11111111111111111111111111111111");

		logger.debug("Se insertará el siguiente usuario");
		logger.debug("==> " + u);

		dao.addItem(u);

		return u;
	}

}
