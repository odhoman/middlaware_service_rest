package com.anibal.educational.rest_service.comps.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.client.RestTemplate;

import com.anibal.educational.rest_service.comps.config.RestServiceConfig;
import com.anibal.educational.rest_service.comps.service.mail.MailConfigurator;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.db.DbConnectionManager;

public class RestServiceUtil {
	
	private static DbConnectionManager dbConnectionMgr = null;
	private static AbstractConfig config = null;
	
	/** Devuelve un DbConnectionManager configurado */
	
	public static DbConnectionManager getDbConnectionMgr() {
		
		if (null == dbConnectionMgr) {
			dbConnectionMgr = new DbConnectionManager(getConfig());
		}
		return dbConnectionMgr;
	}
	
	public static AbstractConfig getConfig() {
		if(null == config) {
			setConfig(RestServiceConfig.getInstance());
		}	
		return config; 
	}
	
	public static void setConfig(AbstractConfig cfg) {
		config = cfg;
	}
	
	/** Construye el nombre del archivos desde un nombre y la extension del archivo original */
	
	public static String buildFileName(String name, String originalFileName) {

		String fileName = null;
		
		if (originalFileName != null && !originalFileName.isEmpty() && originalFileName.indexOf(".") > 0
				&& originalFileName.split("\\.").length >= 2) {
			List<String> list = Arrays.asList(originalFileName.split("\\."));
			fileName = name+"."+list.get(list.size()-1);
		} else {
			fileName = name;
		}
		
		return fileName;
	}
	
	/** Crea el configurador de mail smtp */
	
	public static MailConfigurator createConfiguratorSmtpMailing(AbstractConfig config){
		MailConfigurator conf = new MailConfigurator();
		
		conf.setPropHost(config.getProperty(RestServiceConstant.APP_EMAIL_SMTP_PROPHOST));
		conf.setPropStarttlsEnable(config.getProperty(RestServiceConstant.APP_EMAIL_SMTP_PROPSTARTTLSENABLE));
		conf.setPropPort(config.getProperty(RestServiceConstant.APP_EMAIL_SMTP_PROPPORT));
		conf.setPropPort(config.getProperty(RestServiceConstant.APP_EMAIL_SMTP_PROPPORT));
		conf.setPropUser(config.getProperty(RestServiceConstant.APP_EMAIL_SMTP_PROPUSER));
		conf.setPropSmtpAuth(config.getProperty(RestServiceConstant.APP_EMAIL_SMTP_PROPSMTPAUTH));
		conf.setMessageInternetAdress(config.getProperty(RestServiceConstant.APP_EMAIL_SMTP_MESSAGEINTERNETADRESS));
		conf.setTransportProtocl(config.getProperty(RestServiceConstant.APP_EMAIL_SMTP_TRANSPORTPROTOCL));
		conf.setTransportUser(config.getProperty(RestServiceConstant.APP_EMAIL_SMTP_TRANSPORTUSER));
		conf.setTransportPass(config.getProperty(RestServiceConstant.APP_EMAIL_SMTP_TRANSPORTPASS));
		
		return conf;
	}
	
	@SuppressWarnings("resource")
	public static String getImageToString(String pathFile) throws Exception  {
		
		String image = null;
		File file = new File(pathFile);

		// Reading a Image file from file system
		FileInputStream imageInFile = new FileInputStream(file);
		byte imageData[] = new byte[(int) file.length()];
		imageInFile.read(imageData);

		// Converting Image byte array into Base64 String
		image = encodeImage(imageData);
		
		return image;
	}
	
	public static String encodeImage(byte[] imageByteArray) {
        return Base64.encodeBase64URLSafeString(imageByteArray);
	}
	
	public static RestTemplate getAppRestTemplate(){
		RestTemplate rt = new RestTemplate();
		rt.setErrorHandler(new RestServiceErrorHandler(getConfig().getLogger()));
		return rt;
	}

}
