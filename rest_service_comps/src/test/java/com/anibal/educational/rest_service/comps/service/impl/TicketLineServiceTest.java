package com.anibal.educational.rest_service.comps.service.impl;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anibal.educational.rest_service.comps.dao.TicketLineDao;
import com.anibal.educational.rest_service.comps.service.TicketLineService;
import com.anibal.educational.rest_service.comps.service.TicketLineServiceException;
import com.anibal.educational.rest_service.domain.TicketLine;
import com.odhoman.api.utilities.dao.DAOException;

/** Test de TicketLine */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class TicketLineServiceTest {
	
	@Autowired
	TicketLineService service;
	
	@Autowired
	Logger logger;
	
	@Autowired
	TicketLineDao dao;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Test
	public void testAnsychronousLineProcessing() {
		
		int nLines = 3;
		
		List<TicketLine> ltd = null;
		try {
			ltd = createLinesTest(nLines);
		}  catch (DAOException e) {
			logger.error("No se pudieron crear las lines", e);
			fail(e.getMessage());
		}

		for (int i = 0; i < ltd.size(); i++) {
			
			try {
				createImageLine(ltd.get(i).getLineId());
				logger.debug("Imagen de la linea " + ltd.get(i).getLineId()+" creada");
			} catch (TicketLineServiceException e) {
				logger.error("No se pudo crear la imagen de la line", e);
				fail(e.getMessage());
			} catch (FileNotFoundException e) {
				logger.error("No se pudo crear la imagen de la line", e);
				fail(e.getMessage());
			} catch (Exception e) {
				logger.error("No se pudo crear la imagen de la line", e);
				fail(e.getMessage());
			}
		}

    	long milis = new Date().getTime();
    	logger.info("TicketLineServiceTest: testAnsychronousLineProcessing... Iniciando el envio de procesamiento de las lines a las "+ dateFormat.format(new Date()) );
		
		try {
			service.processAllLabelDesc();
		} catch (TicketLineServiceException e) {
			logger.error("No se pudo enviar a procesar asincronicamente las lines", e);
			fail(e.getMessage());
		}
		
		logger.info("TicketLineServiceTest: testAnsychronousLineProcessing... Finalizando Correctamente el envio de procesamiento de las lines a las "+ dateFormat.format(new Date())+" en "+(new Date().getTime()-milis)+" ms...");

		try {
			deleteTicketLines(ltd);

		} catch (DAOException e) {
			logger.error("No se pudieron borrar las lines", e);
			fail(e.getMessage());
		}

		logger.debug(nLines+" lineas procesadas asincronicamente");
		
	}
	
	private void createImageLine(Long lineId) throws Exception{
		logger.debug("Se crea la imagen de la line");
		service.createLineImage(lineId, new FileInputStream(new File("src/test/resources/antonio-restaurant.jpg")), lineId+".jpg");
	}
	
	private List<TicketLine> createLinesTest(int quantity) throws DAOException{
		
		List<TicketLine> list = new ArrayList<TicketLine>();
		
		for (int i = 0; i < quantity; i++) {
			list.add(getTicketLine());
		}
		
		dao.addItems(list);
		
		return list;
	}
	
	private void deleteTicketLines(List<TicketLine> filter) throws DAOException{
		dao.deleteItems(filter);
	}
	
	
	
	private TicketLine getTicketLine(){
		
		TicketLine  tl = new TicketLine();

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
		
		return tl;
	}

}
