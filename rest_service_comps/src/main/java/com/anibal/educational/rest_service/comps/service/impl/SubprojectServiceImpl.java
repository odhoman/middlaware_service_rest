package com.anibal.educational.rest_service.comps.service.impl;

import java.util.List;

import com.anibal.educational.rest_service.comps.service.SubprojectService;
import com.anibal.educational.rest_service.comps.service.SubprojectServiceException;
import com.anibal.educational.rest_service.domain.Subproject;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.dao.DAOException;

public class SubprojectServiceImpl extends AbstractService implements SubprojectService {

	private AbstractAbmDAO<Subproject, Subproject> dao = null;

	public SubprojectServiceImpl(AbstractAbmDAO<Subproject, Subproject> dao) {
		super();
		this.dao = dao;
	}
	
	public SubprojectServiceImpl(AbstractAbmDAO<Subproject, Subproject> dao, AbstractConfig config) {
		super(config);
		this.dao = dao;
	}
	
	public List<Subproject> getSubprojectByUserId(Long userId) throws SubprojectServiceException {

		Subproject filter = new Subproject();
		filter.setUserId(userId);
		try {
			return dao.getItems(filter);
		} catch (DAOException e) {
			throw new SubprojectServiceException(e);
		}
	}
	
	public void createSubproject(Subproject pro) throws SubprojectServiceException {
		try {
			dao.addItem(pro);
		} catch (DAOException e) {
			throw new SubprojectServiceException(e);
		}
	}
	
	public void updateSubproject(Long projectId, Subproject pro) throws SubprojectServiceException {
		
		Subproject filter = new Subproject();
		filter.setSubprojectId(projectId);
		try {
			dao.changeItem(filter, pro);
		} catch (DAOException e) {
			throw new SubprojectServiceException(e);
		}
	}
	
	public void deleteSubproject(Long projectId) throws SubprojectServiceException {
		
		Subproject filter = new Subproject();
		filter.setSubprojectId(projectId);
		try {
			dao.deleteItem(filter);
		} catch (DAOException e) {
			throw new SubprojectServiceException(e);
		}
	}
}
