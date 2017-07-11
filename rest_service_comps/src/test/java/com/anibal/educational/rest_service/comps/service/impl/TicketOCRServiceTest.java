package com.anibal.educational.rest_service.comps.service.impl;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.anibal.educational.rest_service.comps.service.TicketOCRService;
import com.anibal.educational.rest_service.comps.service.TicketOCRServiceException;

/** Test del OCR */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class TicketOCRServiceTest {
	
	@Autowired
	private TicketOCRService service;
	
	@Autowired
	private Logger logger;
	
	@Test
	public void testConvertImageToBase64(){
		String txt = null;
		
		logger.debug("testConvertImageToBase64: iniciando ");
		logger.debug("Se intenta convertir una imagen a Base64");
		
		try {
			txt = service.getImageToString("src/test/resources/antonio-restaurant.jpg");
		} catch (TicketOCRServiceException e) {
			logger.error("Hubo un error al querer convertir la imagen a Base64",e);
			fail(e.getMessage());
		}
		
		logger.debug("Imagen convertida Base64: "+ txt);
		logger.debug("testConvertImageToBase64: finalizando ");
	}
	
	@Test
	public void testOCR(){
		String txt = null;
		
		logger.debug("testOCR: iniciando ");
		logger.debug("Se intenta enviar a traducir la imagen al texto");
		
		try {
			txt = service.getOCRStringFromImageBase64(getImageBase64());
		} catch (TicketOCRServiceException e) {
			logger.error("Hubo un error al querer traducir la imagen a text ",e);
			fail(e.getMessage());
		}
		
		logger.debug("El texto es el siguiente: ");
		logger.debug(txt);
		logger.debug("testOCR: finalizando... ");
	}
	
	private static String getImageBase64(){
		return "iVBORw0KGgoAAAANSUhEUgAAAMoAAAA3CAIAAADCC0I4AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAMmSURBVHhe7ZZReuMwCIR7rhzI58lpcpkcpitbgJAQkWyHbNxv/qc1EgOC2bY/vwCEAXuBQGAvEAjsBQKBvUAgsBcIBPYCgcBeIBDYCwQCe4FAYC8QCOwFAoG9QCCwFwgE9gKBwF4gENgLBAJ7gUBgLxDIbns977efluXhHOSTMWvu7f6krxUb2cFjofKFTavXIhWpUw5X1rx4gqqmJkTRyZldgmM/vcp42ln4Jx2qdVsDnFmyFqp09EHTYj46u93JJ/A1KVfyzrz7yzj4y5FdZCfhn3hQhkqwkSOI0xudskdrr5MlC8MnGHuVfs8a/Iv4AnvRoFWCjRzC9VF/ke901/gJ3Jy11/ua+P+8216y0vn/gnYTw93MIj6qpKTHqssUfeNih0/gJkoHNnJ9PmcvWfWKPrWbcHZTKcxtQdqp1ZeFpUQlRbte8Iqq+JrXFuo/oSQtd0pQz8in3S6uykl7+VTbp2FTrBmj3URnN1QwK8guqyJ9pFO+m5LTP1uJ9G33OirKoVvi/qTbWYaOvEeJmH5CDqrA9fnET69q7ipAVwabWPEUbH0LX6W7SXurK41u4fRlpMZFWYMC+TO/io68q0VMu2mNlXJ/gQ/Yi+8aqq1oqSbS0fQbsEj6ejd9kIoOl6gwVZQCbW6C0v0ncETnrnIdrQsTb6/eniqaTSSaSE9hqKrhbre/eEqCPGJZjLvmiu62V3kkR3RuinWkrswxe8mc99jL3CXogjpuIlazxDzRGvFXnVDCdqtTRXfby46lk/uHeLe9ZGNlbP7ljB10GxGFcsVfbBenB+62JzNTdGgvOeJKrTNVLqV0xK7LIXvJ5M0weGgJddJZbgrxR7uJVxHK8dfqklNqd3HU0RkWbS5o7BN4NFuEj9UFCTndXJLd9uIpKfJ0y8QUdrpEzumIGez8N3YvYa1lfbBGX0m5RW3rfDhzcrs/ijB1RaV2P+ybOfinPQAzwF4gENgLBAJ7gUBgLxAI7AUCgb1AILAXCAT2AoHAXiAQ2AsEAnuBQGAvEAjsBQKBvUAgsBcIBPYCgcBeIBDYCwQCe4FAYC8QCOwFwvj9/Qd65BJnN0mKmQAAAABJRU5ErkJggg==";
	}
	
}
