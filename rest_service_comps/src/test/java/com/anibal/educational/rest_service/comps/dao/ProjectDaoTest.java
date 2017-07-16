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
import com.anibal.educational.rest_service.domain.Project;
import com.odhoman.api.utilities.dao.DAOException;


/**
 * 
 * Test del DAO de Project
 * 
 * @author Jonatan Flores
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class ProjectDaoTest {
	
	@Autowired
	ProjectDao dao;

	@Autowired
	Logger logger;
	

	@Test
	public void testAllProject() {
		logger.debug("testAllProject: Iniciando...");

		Project dg = null;

		try {
			dg = insertProject();
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer insertar el Project " + dg, e);
			fail(e.getMessage());
		}

		try {
			updateProject(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el Project " + dg, e);
			fail(e.getMessage());
		}
		
		try {
			updateProject2(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el Project " + dg, e);
			fail(e.getMessage());
		}

		try {
			dg = getProject(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer obtener el Project " + dg, e);
			fail(e.getMessage());
		}

		try {
			deleteProject(dg);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer eliminar el Project " + dg, e);
			fail(e.getMessage());
		}

		logger.debug("testAllProject: Finalizando...");
	}

	private void deleteProject(Project dg) throws DAOException {
		
		logger.debug("Se eliminará el siguiente Project con id " + dg.getUserId());

		dao.deleteItem(dg);

		logger.debug("Se elminó el Project con id " + dg.getProjectId() + " correctamente");

	}

	private Project getProject(Project t) throws DAOException {
		logger.debug("Se obtendra el siguiente Project con id " + t.getProjectId()
				+ " con los siguientes valores de filtro");
		logger.debug("==> " + t);

		t = dao.getItem(t);

		logger.debug("Se obtuvo el user " + t.getProjectId() + " correctamente");
		logger.debug(t);
		return t;
	}

	private void updateProject(Project tl) throws Exception {
		Project filtro = (Project) tl.clone();

		tl.setProjectName("asdfa");

		logger.debug("Se actualizará el siguiente Project con id " + tl.getProjectId() + " con los siguientes valores");
		logger.debug("==> " + tl);

		dao.changeItem(filtro, tl);

		logger.debug("Se actualizó el Project " + tl.getProjectId() + " correctamente");

	}
	
	private void updateProject2(Project tl) throws Exception {
		Project filtro = (Project) tl.clone();

		tl.setUserId(1L);
		

		logger.debug("Se actualizará el siguiente Project con id " + tl.getProjectId() + " con los siguientes valores");
		logger.debug("==> " + tl);

		dao.changeItem(filtro, tl);

		logger.debug("Se actualizó el Project " + tl.getProjectId() + " correctamente");

	}
	
	private Project insertProject() throws DAOException {
		Project u = new Project();
		u.setCreacionFecha(new Date());
		return insertProject(u);
	}
	
	private Project insertProject(Project u) throws DAOException {

		logger.debug("Se insertará el siguiente Project");
		logger.debug("==> " + u);

		dao.addItem(u);

		return u;
	}

}
