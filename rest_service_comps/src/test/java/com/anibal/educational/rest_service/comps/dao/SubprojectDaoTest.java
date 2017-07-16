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
import com.anibal.educational.rest_service.domain.Subproject;
import com.odhoman.api.utilities.dao.DAOException;

/**
 * 
 * Test del DAO de Subproject
 * 
 * @author Jonatan Flores
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class SubprojectDaoTest {
	
	@Autowired
	SubprojectDao dao;

	@Autowired
	Logger logger;
	

	@Test
	public void testAllSubproject() {
		logger.debug("testAllSubproject: Iniciando...");

		Subproject dg = null;

		try {
			dg = insertSubproject();
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer insertar el Subproject " + dg, e);
			fail(e.getMessage());
		}

		try {
			updateSubproject(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el Subproject " + dg, e);
			fail(e.getMessage());
		}
		
		try {
			updateSubproject2(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el Subproject " + dg, e);
			fail(e.getMessage());
		}

		try {
			dg = getSubproject(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer obtener el Subproject " + dg, e);
			fail(e.getMessage());
		}

		try {
			deleteSubproject(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer eliminar el Subproject " + dg, e);
			fail(e.getMessage());
		}

		logger.debug("testAllSubproject: Finalizando...");
	}

	private void deleteSubproject(Subproject dg) throws DAOException {
		
		logger.debug("Se eliminará el siguiente Subproject con id " + dg.getUserId());

		dao.deleteItem(dg);

		logger.debug("Se elminó el Subproject con id " + dg.getSubprojectId() + " correctamente");

	}

	private Subproject getSubproject(Subproject t) throws DAOException {
		logger.debug("Se obtendra el siguiente Subproject con id " + t.getSubprojectId()
				+ " con los siguientes valores de filtro");
		logger.debug("==> " + t);

		t = dao.getItem(t);

		logger.debug("Se obtuvo el user " + t.getSubprojectId() + " correctamente");
		logger.debug(t);
		return t;
	}

	private void updateSubproject(Subproject tl) throws Exception {
		Subproject filtro = (Subproject) tl.clone();

		tl.setSubprojectName("asdfa");

		logger.debug("Se actualizará el siguiente Subproject con id " + tl.getSubprojectId() + " con los siguientes valores");
		logger.debug("==> " + tl);

		dao.changeItem(filtro, tl);

		logger.debug("Se actualizó el Subproject " + tl.getSubprojectId() + " correctamente");

	}
	
	private void updateSubproject2(Subproject tl) throws Exception {
		Subproject filtro = (Subproject) tl.clone();

		tl.setUserId(1L);
		

		logger.debug("Se actualizará el siguiente Subproject con id " + tl.getSubprojectId() + " con los siguientes valores");
		logger.debug("==> " + tl);

		dao.changeItem(filtro, tl);

		logger.debug("Se actualizó el Subproject " + tl.getSubprojectId() + " correctamente");

	}
	
	private Subproject insertSubproject() throws DAOException {
		Subproject u = new Subproject();
		u.setCreacionFecha(new Date());
		return insertSubproject(u);
	}
	
	private Subproject insertSubproject(Subproject u) throws DAOException {

		logger.debug("Se insertará el siguiente Subproject");
		logger.debug("==> " + u);

		dao.addItem(u);

		return u;
	}


}
