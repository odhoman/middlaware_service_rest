package com.anibal.educational.rest_service.comps.dao;

import static org.junit.Assert.assertTrue;
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
import com.anibal.educational.rest_service.domain.TicketLine;
import com.anibal.educational.rest_service.domain.TicketLineState;
import com.odhoman.api.utilities.dao.DAOException;
import com.odhoman.api.utilities.paging.EnumOrderInfo;
import com.odhoman.api.utilities.paging.OrderInfo;
import com.odhoman.api.utilities.paging.PageInfo;

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
	public void testDifferentsLines(){
		
		logger.debug("testDiferentsLines: Iniciando...");
		
		TicketLine dg1 = new TicketLine();
		TicketLine dg2 = new TicketLine();
		OrderInfo oi = new OrderInfo("LINE_ID", EnumOrderInfo.ORDER_TYPE_ASC.getDescripcion());
		PageInfo pi = new PageInfo(1, 2);
		List<TicketLine> filtros = new ArrayList<TicketLine>();
		List<TicketLine> resultados = null;
		dg1.setLineStateId(getTicketLineStateProcessed().getLineStateId());
		dg2.setLineStateId(getTicketLineStateNotified().getLineStateId());
		filtros.add(dg1);
		filtros.add(dg2);

		try {
			insertTicketsLine(filtros);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer insertar el TicketLinea ", e);
			fail(e.getMessage());
		}
		
		try {
			updateCustomeLine(dg1);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el TicketLine " + dg1, e);
			fail(e.getMessage());
		}
		
		try {
			updateCustomeLine(dg2);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer actualizar el TicketLine " + dg2, e);
			fail(e.getMessage());
		}
		
		try {
			resultados = getTicketLineByFilters(filtros,oi,pi);
			assertTrue(resultados.size() == 2);
			assertTrue(resultados.get(0).getLineId() < resultados.get(1).getLineId());
		} catch (Exception e) {
			logger.error("No se pudieron obtener lo resultados con los filtros especificados", e);
			fail(e.getMessage());
		}
		
		try {
			deleteTicketLine(dg1);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer eliminar el TicketLine " + dg1, e);
			fail(e.getMessage());
		}
		
		try {
			deleteTicketLine(dg2);
		} catch (Exception e) {
			logger.error("Ocurrio una excepcion al querer eliminar el TicketLine " + dg2, e);
			fail(e.getMessage());
		}
		
		logger.debug("testDiferentsLines: Finalizando...");
	}

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

		logger.debug("Se elminó el TicketLine con id " + dg.getLineId() + " correctamente");

	}

	private TicketLine getTicketLine(TicketLine t) throws DAOException {
		logger.debug("Se obtendra el siguiente TicketLine con id " + t.getLineId()
				+ " con los siguientes valores de filtro");
		logger.debug("==> " + t);

		t = dao.getItem(t);

		logger.debug("Se obtuvo el user " + t.getLineId() + " correctamente");
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

		logger.debug("Se actualizará el siguiente TicketLine con id " + tl.getLineId() + " con los siguientes valores");
		logger.debug("==> " + tl);

		dao.changeItem(filtro, tl);

		logger.debug("Se actualizó el TicketLine " + tl.getLineId() + " correctamente");

	}
	
	private void updateCustomeLine(TicketLine tl) throws Exception{
		
		TicketLine filtro = (TicketLine) tl.clone();
		logger.debug("Se actualizará el siguiente TicketLine con id " + tl.getLineId() + " con los siguientes valores");
		logger.debug("==> " + tl);

		dao.changeItem(filtro, tl);

		logger.debug("Se actualizó el TicketLine " + tl.getLineId() + " correctamente");
		
	}
	
	private void updateTicketLine2(TicketLine tl) throws Exception {
		TicketLine filtro = (TicketLine) tl.clone();

		tl.setTicketId(2342L);
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
		tl.setLineStateId(4L);

		logger.debug("Se actualizará el siguiente TicketLine con id " + tl.getLineId() + " con los siguientes valores");
		logger.debug("==> " + tl);

		dao.changeItem(filtro, tl);

		logger.debug("Se actualizó el TicketLine " + tl.getLineId() + " correctamente");

	}
	
	@SuppressWarnings("unused")
	private List<TicketLine> getTicketLineByFilters(List<TicketLine> filters) throws Exception{
		return dao.getItems(filters);
	}
	
	private List<TicketLine> getTicketLineByFilters(List<TicketLine> filters, OrderInfo oi, PageInfo pi) throws Exception{
		return dao.getItems(filters, pi, oi);
	}


	private TicketLine insertTicketLine() throws DAOException {
		TicketLine u = new TicketLine();

		return insertTicketLine(u);
	}
	
	private TicketLine insertTicketLine(TicketLine u) throws DAOException {

		logger.debug("Se insertará el siguiente TicketLine");
		logger.debug("==> " + u);

		dao.addItem(u);

		return u;
	}
	
	private void insertTicketsLine(List<TicketLine> list) throws DAOException {
		dao.addItems(list);
	}
	
	protected TicketLineState getTicketLineStateProcessed(){
		TicketLineState tls = new TicketLineState();
		
		tls.setLineStateId(3L);
		return tls;
	} 
	
	protected TicketLineState getTicketLineStatePending(){
		TicketLineState tls = new TicketLineState();
		
		tls.setLineStateId(1L);
		return tls;
	} 
	
	protected TicketLineState getTicketLineStateNotifing(){
		TicketLineState tls = new TicketLineState();
		
		tls.setLineStateId(6L);
		return tls;
	} 
	
	protected TicketLineState getTicketLineStateNotified(){
		TicketLineState tls = new TicketLineState();
		
		tls.setLineStateId(4L);
		return tls;
	} 

}
