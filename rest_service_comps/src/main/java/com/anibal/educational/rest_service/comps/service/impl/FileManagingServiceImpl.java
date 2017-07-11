package com.anibal.educational.rest_service.comps.service.impl;

import java.io.File;
import java.io.InputStream;

import com.anibal.educational.rest_service.comps.dao.file_managing.AbstractFileManagingDao;
import com.anibal.educational.rest_service.comps.dao.file_managing.FileManagingDaoException;
import com.anibal.educational.rest_service.comps.service.FileManagingException;
import com.anibal.educational.rest_service.comps.service.FileManagingService;
import com.odhoman.api.utilities.config.AbstractConfig;

public class FileManagingServiceImpl extends AbstractService implements FileManagingService{
	
	private AbstractFileManagingDao dao;
	
	public FileManagingServiceImpl(AbstractFileManagingDao dao) {
		super();
		this.dao = dao;
	}
	
	public FileManagingServiceImpl(AbstractFileManagingDao dao, AbstractConfig config) {
		super(config);
		this.dao = dao;
	}

	public void handleUpload(InputStream inputStream, String path, String fileName) throws FileManagingException {
		
		logger.debug("FileManagingServiceImpl - handleUpload: Iniciando...");
		
		try {
			dao.handleUpload(inputStream,path,fileName);
		} catch (FileManagingDaoException e) {
			throw new FileManagingException(e);
		}
		
		logger.debug("FileManagingServiceImpl - handleUpload: Finalizando...");
	}
	
	public File handleDownload(String fullPathToFile) throws FileManagingException {
		
		File file = new File(fullPathToFile);
		
		if(file.exists()){
			return file;
		}else{
			logger.error("No existe la imagen solicitada en el path "+ fullPathToFile);
			throw new FileManagingException("No existe la imagen solicitada");
		}
	}

}
