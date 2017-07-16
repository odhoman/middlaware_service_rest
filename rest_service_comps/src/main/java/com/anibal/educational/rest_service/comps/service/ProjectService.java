package com.anibal.educational.rest_service.comps.service;

import java.util.List;

import com.anibal.educational.rest_service.domain.Project;

public interface ProjectService {
	
	public List<Project> getProjectByUserId(Long userId) throws ProjectServiceException;

	public void createProject(Project pro) throws ProjectServiceException;
	
	public void updateProject(Long projectId, Project pro) throws ProjectServiceException;
	
	public void deleteProject(Long projectId) throws ProjectServiceException;
	
}	