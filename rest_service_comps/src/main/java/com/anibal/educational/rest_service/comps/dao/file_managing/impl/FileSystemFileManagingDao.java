package com.anibal.educational.rest_service.comps.dao.file_managing.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.anibal.educational.rest_service.comps.dao.file_managing.AbstractFileManagingDao;
import com.anibal.educational.rest_service.comps.dao.file_managing.FileManagingDaoException;
import com.odhoman.api.utilities.config.AbstractConfig;

public class FileSystemFileManagingDao extends AbstractFileManagingDao {

	public FileSystemFileManagingDao(AbstractConfig config) {
		super(config);
	}
	
	@Override
	public void handleUpload(InputStream inputStream, String path ,String fileName) throws FileManagingDaoException {

		logger.debug("FileSystemFileManagingDao - handleUpload: Iniciando...");
		
		File file = new File(path+fileName);
				
		if(file.exists()){
			file.delete();
		}
		
		OutputStream outputStream = null;
		try {

			outputStream = new FileOutputStream(path+fileName);

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

		} catch (IOException e) {
			throw new FileManagingDaoException(e);
		} catch(Exception e) {
			throw new FileManagingDaoException(e);
		} finally {

			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("Ocurrio un error al querer cerrar el inputStream ",e);
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					logger.error("Ocurrio un error al querer cerrar el outputStream ",e);
				}
			}
		}

		logger.debug("FileSystemFileManagingDao - handleUpload: Finalizando...");
	}

}
