package com.anibal.educational.rest_service.domain;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Project implements Cloneable {

	private Long projectId;
	private String projectName;
	private Long userId;
	@JsonSerialize(using = DateSerializer.class)
	private Date creacionFecha;

	public Project() {
		super();
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreacionFecha() {
		return creacionFecha;
	}

	public void setCreacionFecha(Date creacionFecha) {
		this.creacionFecha = creacionFecha;
	}
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", userId=" + userId
				+ ", creacionFecha=" + creacionFecha + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
