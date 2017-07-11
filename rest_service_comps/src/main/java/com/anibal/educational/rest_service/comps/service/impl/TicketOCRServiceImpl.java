package com.anibal.educational.rest_service.comps.service.impl;

import java.util.Arrays;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.anibal.educational.rest_service.comps.service.TicketOCRService;
import com.anibal.educational.rest_service.comps.service.TicketOCRServiceException;
import com.anibal.educational.rest_service.comps.util.RestServiceConstant;
import com.anibal.educational.rest_service.comps.util.RestServiceUtil;
import com.anibal.educational.rest_service.domain.ocr.request.Feature;
import com.anibal.educational.rest_service.domain.ocr.request.Image;
import com.anibal.educational.rest_service.domain.ocr.request.OCRRequest;
import com.anibal.educational.rest_service.domain.ocr.request.Request;
import com.anibal.educational.rest_service.domain.ocr.response.OCRResponse;
import com.odhoman.api.utilities.config.AbstractConfig;

public class TicketOCRServiceImpl extends AbstractService implements TicketOCRService {

	public TicketOCRServiceImpl() {
		super();
	}

	public TicketOCRServiceImpl(AbstractConfig config) {
		super(config);
	}

	public String getImageToString(String pathFile) throws TicketOCRServiceException {
		String image = null;
		try {
			image = RestServiceUtil.getImageToString(pathFile);
		} catch (Exception e) {
			throw new TicketOCRServiceException(e);
		}

		return image;
	}

	public String getOCRStringFromImageBase64(String imageString) throws TicketOCRServiceException {
		return getOCRStringFromImageBase64(imageString, config.getProperty(RestServiceConstant.APP_OCR_DEFAULT_URL),
										   config.getProperty(RestServiceConstant.APP_OCR_DEFAULT_KEY),
										   config.getProperty(RestServiceConstant.APP_OCR_DEFAULT_SERVICE));
	}
	
	public String getOCRStringFromImageBase64(String imageString, String url, String key, String serviceType) throws TicketOCRServiceException {
		
		String response = null;
		RestTemplate restTemplate = new RestTemplate();

		try {
			OCRResponse respuesta = restTemplate.postForObject(getUriComponentsBuilder(url,key).build().encode().toUri(), getOCRRequest(imageString,serviceType), OCRResponse.class);
			response = respuesta.getResponses().get(0).getTextAnnotations().get(0).getDescription();
		} catch (Exception e) {
			throw new TicketOCRServiceException(e);
		}

		return response;
	}
	
	private OCRRequest getOCRRequest(String imageString, String serviceType){
		
		Feature fea = new Feature();
		Image im = new Image();
		im.setContent(imageString);
		fea.setType(serviceType);
		Request req = new Request();
		req.setFeatures(Arrays.asList(fea));
		req.setImage(im);
		OCRRequest request = new OCRRequest();
		request.setRequests(Arrays.asList(req));
		
		return request;	
	}
	
	private UriComponentsBuilder getUriComponentsBuilder(String url,String key){
		return UriComponentsBuilder.fromHttpUrl(url).queryParam("key", key);
	}

}
