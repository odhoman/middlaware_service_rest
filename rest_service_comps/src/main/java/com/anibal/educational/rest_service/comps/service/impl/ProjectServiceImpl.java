package com.anibal.educational.rest_service.comps.service.impl;

import java.util.List;

import com.anibal.educational.rest_service.comps.service.ProjectService;
import com.anibal.educational.rest_service.comps.service.ProjectServiceException;
import com.anibal.educational.rest_service.domain.Project;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.dao.DAOException;

public class ProjectServiceImpl extends AbstractService implements ProjectService {

	private AbstractAbmDAO<Project, Project> dao = null;

	public ProjectServiceImpl(AbstractAbmDAO<Project, Project> dao) {
		super();
		this.dao = dao;
	}
	
	public ProjectServiceImpl(AbstractAbmDAO<Project, Project> dao, AbstractConfig config) {
		super(config);
		this.dao = dao;
	}
	
	public List<Project> getProjectByUserId(Long userId) throws ProjectServiceException {

		Project filter = new Project();
		filter.setUserId(userId);
		try {
			return dao.getItems(filter);
		} catch (DAOException e) {
			throw new ProjectServiceException(e);
		}
	}
	
	public void createProject(Project pro) throws ProjectServiceException {
		try {
			dao.addItem(pro);
		} catch (DAOException e) {
			throw new ProjectServiceException(e);
		}
	}
	
	public void updateProject(Long projectId, Project pro) throws ProjectServiceException {
		
		Project filter = new Project();
		filter.setProjectId(projectId);
		try {
			dao.changeItem(filter, pro);
		} catch (DAOException e) {
			throw new ProjectServiceException(e);
		}
	}
	
	public void deleteProject(Long projectId) throws ProjectServiceException {
		
		Project filter = new Project();
		filter.setProjectId(projectId);
		try {
			dao.deleteItem(filter);
		} catch (DAOException e) {
			throw new ProjectServiceException(e);
		}
	}

}
