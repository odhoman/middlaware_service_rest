package com.anibal.educational.rest_service.comps.service.impl;

import java.io.File;
import java.io.InputStream;

import com.anibal.educational.rest_service.comps.dao.file_managing.impl.FileSystemFileManagingDao;
import com.anibal.educational.rest_service.comps.service.FileManagingException;
import com.anibal.educational.rest_service.comps.service.FileManagingService;
import com.anibal.educational.rest_service.comps.service.TicketUserException;
import com.anibal.educational.rest_service.comps.service.TicketUserService;
import com.anibal.educational.rest_service.comps.util.RestServiceConstant;
import com.anibal.educational.rest_service.domain.TicketUser;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.dao.DAOException;

public class TicketUserServiceImplImpl extends AbstractService implements TicketUserService {

	private AbstractAbmDAO<TicketUser, TicketUser> dao = null;

	public TicketUserServiceImplImpl(AbstractAbmDAO<TicketUser, TicketUser> dao) {
		super();
		this.dao = dao;
	}

	public TicketUser getUser(Long userId) throws TicketUserException {

		TicketUser user = null;

		logger.debug("TicketUserServiceImplImpl - getUser: iniciando");

		TicketUser filter = new TicketUser();
		filter.setUserId(userId);
		try {
			user = dao.getItem(filter);
		} catch (DAOException e) {
			logger.error("TicketUserServiceImplImpl - getUser: ocurrio un error al querer obtener el usuario", e);
			throw new TicketUserException(e);
		}

		logger.debug("TicketUserServiceImplImpl - getUser: finalizando");

		return user;
	}

	public void updateUser(Long id, TicketUser user) throws TicketUserException {

		logger.debug("TicketUserServiceImplImpl - updateUser: iniciando");

		TicketUser filter = new TicketUser();
		filter.setUserId(id);
		try {
			dao.changeItem(filter, user);
		} catch (DAOException e) {
			throw new TicketUserException(e);
		}

		logger.debug("TicketUserServiceImplImpl - updateUser: finalizando");
	}

	public void deleteUser(Long userId) throws TicketUserException {

		logger.debug("TicketUserServiceImplImpl - deleteUser: iniciando");

		TicketUser filter = new TicketUser();
		filter.setUserId(userId);
		try {
			dao.deleteItem(filter);
		} catch (DAOException e) {
			throw new TicketUserException(e);
		}

		logger.debug("TicketUserServiceImplImpl - deleteUser: finalizando");

	}

	public TicketUser createUser(TicketUser user) throws TicketUserException {

		logger.debug("TicketUserServiceImplImpl - createUser: iniciando");

		TicketUser filter = new TicketUser();
		filter.setUserId(user.getUserId());
		try {
			dao.addItem(user);
		} catch (DAOException e) {
			throw new TicketUserException(e);
		}

		logger.debug("TicketUserServiceImplImpl - createUser: finalizando");

		return user;
	}

	public void createUserImage(Long userId, InputStream inputStream, String fileName) throws TicketUserException {

		logger.debug("TicketUserServiceImplImpl - createUserImage: iniciando");

		TicketUser user = new TicketUser();
		String folderPath = config.getProperty(RestServiceConstant.APP_FILE_SYSTEM_USER_FOLDER_DIR);

		logger.debug("TicketUserServiceImplImpl - se guarda la imagen " + fileName + " del usuario id " + userId);

		FileManagingService servie = new FileManagingServiceImpl(new FileSystemFileManagingDao());

		try {
			servie.handleUpload(inputStream, folderPath, fileName);
		} catch (FileManagingException e) {
			logger.error("TicketUserServiceImplImpl - no se pudo  guarda la imagen " + fileName + " del usuario id "
					+ userId);
			throw new TicketUserException(e);
		}

		logger.debug("TicketUserServiceImplImpl - se actualizan los datos del usuario");

		user.setImageId(userId);
		user.setPathImage(folderPath + fileName);

		updateUser(userId, user);

		logger.debug("TicketUserServiceImplImpl - createUserImage: finalizando");

	}

	public File getUserImage(Long userId) throws TicketUserException {

		logger.debug("TicketUserServiceImplImpl - getUserImage: iniciando");
		FileManagingService servie = new FileManagingServiceImpl(new FileSystemFileManagingDao());
		File file = null;

		TicketUser user = getUser(userId);
		
		try {
			
			file = servie.handleDownload(user.getPathImage());
			if (file == null || !file.exists()) {
				logger.error("No existe la imagen solicitada en el path " + user.getPathImage());
				throw new TicketUserException("No existe la imagen solicitada");
			}
		} catch (FileManagingException e) {
			throw new TicketUserException("No se pudo obtener la imagen del usuario");
		}

		logger.debug("TicketUserServiceImplImpl - getUserImage: finalizando");
		
		return file;
	}

}
