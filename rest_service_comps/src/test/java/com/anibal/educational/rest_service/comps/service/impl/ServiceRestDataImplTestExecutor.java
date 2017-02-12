package com.anibal.educational.rest_service.comps.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anibal.educational.rest_service.comps.service.ServiceRestData;
import com.anibal.educational.rest_service.domain.Libro;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigTest.class})
public class ServiceRestDataImplTestExecutor {
	
	@Autowired ServiceRestData serviceRestData;
	
	@Test
	public void testGetLibros(){
		
		for(Libro libro : serviceRestData.getLibros())
			System.out.println(libro);
	}
	

}
