package com.anibal.educational.rest_service.comps.service;

import java.util.List;

import com.anibal.educational.rest_service.domain.Subproject;

public interface SubprojectService {
	
	public List<Subproject> getSubprojectByUserId(Long userId) throws SubprojectServiceException;

	public void createSubproject(Subproject pro) throws SubprojectServiceException;
	
	public void updateSubproject(Long projectId, Subproject pro) throws SubprojectServiceException;
	
	public void deleteSubproject(Long projectId) throws SubprojectServiceException;

}
