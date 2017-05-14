package com.anibal.educational.rest_service.comps.dao.file_managing;

import java.io.InputStream;

import org.apache.log4j.Logger;

import com.anibal.educational.rest_service.comps.util.RestServiceUtil;
import com.odhoman.api.utilities.config.AbstractConfig;

public abstract class AbstractFileManagingDao {
	
	protected Logger logger = RestServiceUtil.getConfig().getLogger();
	protected AbstractConfig config = RestServiceUtil.getConfig();
	
	
	public abstract void handleUpload(InputStream inputStream, String path, String fileName) throws FileManagingDaoException; 
	

}
