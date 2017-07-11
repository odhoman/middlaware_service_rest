package com.anibal.educational.rest_service.comps.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anibal.educational.rest_service.comps.service.impl.AppConfigTest;
import com.anibal.educational.rest_service.domain.TicketLineState;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class TicketLineStateDaoTest {
	
	@Autowired
	TicketLineStateDao dao;
	
	@Autowired
	Logger logger;
	
	@Test
	public void testAllTicketLineState() {
		
		List<TicketLineState> list = null;
		
		try {
			list = dao.getItems(new TicketLineState());
		} catch (Exception e) {
			logger.error("No se pudieron obtener los estados de las lines", e);
			fail(e.getMessage());
		}
		
		System.out.println("Estados obtenidos");
		
		for(TicketLineState state: list)
			System.out.println("===> "+state);
	}

}
