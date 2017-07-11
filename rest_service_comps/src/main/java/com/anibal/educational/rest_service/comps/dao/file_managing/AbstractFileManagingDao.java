package com.anibal.educational.rest_service.comps.dao.file_managing;

import java.io.InputStream;

import org.apache.log4j.Logger;

import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.config.AppConfig;

public abstract class AbstractFileManagingDao {
	
	protected Logger logger = null;
	protected AbstractConfig config = null;
	
	public AbstractFileManagingDao() {
		this(AppConfig.getInstance());
	}
	
	public AbstractFileManagingDao(AbstractConfig config) {
		setConfiguration(config);
	}
	
	public void setConfiguration(AbstractConfig config) {
		this.config = config;
		logger = this.config.getLogger();
	}
	
	
	public abstract void handleUpload(InputStream inputStream, String path, String fileName) throws FileManagingDaoException; 
	

}
