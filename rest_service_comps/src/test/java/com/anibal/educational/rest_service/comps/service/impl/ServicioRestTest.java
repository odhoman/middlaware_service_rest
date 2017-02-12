package com.anibal.educational.rest_service.comps.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.anibal.educational.rest_service.comps.service.ServiceRestData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigTest.class,loader=AnnotationConfigContextLoader.class)
public class ServicioRestTest {
	
	@Autowired
	private ServiceRestData serviceRestData;

	@Test
	public void getLibros(){
		System.out.println(serviceRestData.getLibros());
	}
	
}
