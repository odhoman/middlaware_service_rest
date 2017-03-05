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

import com.anibal.educational.rest_service.comps.service.CabeceraGastoException;
import com.anibal.educational.rest_service.comps.service.CabeceraGastoService;
import com.anibal.educational.rest_service.domain.CabeceraGasto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class CabeceraGastoServiceTest {

	@Autowired
	CabeceraGastoService cabeceraGastoService;

	@Autowired
	Logger logger;

	@Test
	public void testAllCabeceraGastoService() {

		logger.debug("testAllCabeceraGastoService: Iniciando...");
		
		CabeceraGasto cg = null;
		try {
			cg = insertCabeceraGasto();
		} catch (CabeceraGastoException e) {
			logger.error("Ocurrio una excepcion al querer insertar  gasto " + cg, e);
			fail(e.getMessage());
		}
		
		try {
			cg = getCabeceraGasto(cg);
		} catch (CabeceraGastoException e) {
			logger.error("Ocurrio una excepcion al querer obtener  gasto " + cg, e);
			fail(e.getMessage());
		}

		try {
			updateCabeceraGasto(cg,cg);
		} catch (CabeceraGastoException e) {
			logger.error("Ocurrio una excepcion al querer actualizar  gasto " + cg, e);
			fail(e.getMessage());
		}
		
		try {
			deleteCabeceraGasto(cg);
		} catch (CabeceraGastoException e) {
			logger.error("Ocurrio una excepcion al querer actualizar el detalle de gasto " + cg, e);
			fail(e.getMessage());
		}
		
		logger.debug("testAllCabeceraGastoService: Finalizando...");
	}
	
	@Test
	public void testAllCabecerasGastoService(){
		
		logger.debug("testAllCabecerasGastoService: Iniciando...");
		
		CabeceraGasto cg1 = null;
		CabeceraGasto cg2 = null;
		
		List<CabeceraGasto> filtros = new ArrayList<CabeceraGasto>();
		
		try {
			cg1 = insertCabeceraGasto();
		} catch (CabeceraGastoException e) {
			logger.error("Ocurrio una excepcion al querer insertar el detalle de gasto " + cg1, e);
			fail(e.getMessage());
		}
		
		try {
			cg2 = insertCabeceraGasto();
		} catch (CabeceraGastoException e) {
			logger.error("Ocurrio una excepcion al querer insertar el detalle de gasto " + cg2, e);
			fail(e.getMessage());
		}
		
		filtros.add(cg1);
		filtros.add(cg2);
		
		try {
			deleteCabeceraGasto(filtros);
		} catch (CabeceraGastoException e) {
			logger.error("Ocurrio una excepcion al querer eliminar los gastos", e);
			fail(e.getMessage());
		}
		
		logger.debug("testAllCabecerasGastoService: Finalizando...");
	}
	
	private void deleteCabeceraGasto(List<CabeceraGasto> filtros) throws CabeceraGastoException{
		logger.debug("Se intentara eliminar un gasto con ids: ");
		for(CabeceraGasto filtro: filtros)
			logger.debug("==> "+filtro.getGastoId());
		
		cabeceraGastoService.deleteCabecerasGasto(filtros);
		
		logger.debug("Se eliminaron los gastos correctamente");
		
	}
	
	private void deleteCabeceraGasto(CabeceraGasto filtro) throws CabeceraGastoException{
		
		logger.debug("Se intentara eliminar un gasto con id "+filtro.getGastoId());

		cabeceraGastoService.deleteCabeceraGasto(filtro.getGastoId());
		
		logger.debug("Se elimino el gasto con id "+filtro.getGastoId());
		
	}

	private CabeceraGasto insertCabeceraGasto() throws CabeceraGastoException {
		
		logger.debug("Se intentara inserta un nuevo gasto");
		CabeceraGasto cg = new CabeceraGasto();
		cabeceraGastoService.createCabeceraGasto(cg);
		
		logger.debug("Se inserta exitosamente un nuevo gasto con id "+cg.getGastoId());

		return cg;
	}
	
	private CabeceraGasto getCabeceraGasto(CabeceraGasto filtro) throws CabeceraGastoException {
		
		logger.debug("Se intentara obtener un nuevo gasto con id "+filtro.getGastoId());

		CabeceraGasto cg =  cabeceraGastoService.getCabeceraGasto(filtro);
		
		
		logger.debug("Se obtuvo el gasto con id "+filtro.getGastoId());
		
		return cg;

	}
	
	private void updateCabeceraGasto(CabeceraGasto cg,CabeceraGasto filtro) throws CabeceraGastoException{
		
		logger.debug("Se intentara actualizar un gasto con id "+cg.getGastoId());

		cg.setGastoNro(1L);
		cg.setProyectoId(1L);
		cg.setSubProyectoId(1L);
		cg.setProveedor("proveedor");
		cg.setTipoCambio(1D);
		cg.setImporte(1D);
		cg.setUserId(1L);
		cg.setObservaciones("observaciones");
		cg.setFechaGasto(new Date());
		cg.setTipoGasto("GASTO CAMBIADO");
		cg.setCiudad("CIUDAD CAMBIADA");
		cg.setPais("PAIS CAMBIADO");
		
		cabeceraGastoService.updateCabeceraGasto(cg, filtro.getGastoId());
		
		logger.debug("Se actualizo el gasto con id "+filtro.getGastoId());
		
	}

}
