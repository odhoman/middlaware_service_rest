package com.anibal.educational.rest_service.comps.service;

import java.io.File;
import java.io.InputStream;

public interface FileManagingService {
	
	public void handleUpload(InputStream inputStream, String path, String fileName) throws FileManagingException;
	
	public File handleDownload(String fullPathToFile) throws FileManagingException;
	

}
