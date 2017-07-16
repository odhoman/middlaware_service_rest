package com.anibal.educational.rest_service.domain;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Subproject implements Cloneable {

	private Long subprojectId;
	private String subprojectName;
	private Long userId;
	@JsonSerialize(using = DateSerializer.class)
	private Date creacionFecha;

	public Subproject() {
		super();
	}

	public Long getSubprojectId() {
		return subprojectId;
	}

	public void setSubprojectId(Long subprojectId) {
		this.subprojectId = subprojectId;
	}

	public String getSubprojectName() {
		return subprojectName;
	}

	public void setSubprojectName(String subprojectName) {
		this.subprojectName = subprojectName;
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
		return "Subproject [subprojectId=" + subprojectId + ", subprojectName=" + subprojectName + ", userId=" + userId
				+ ", creacionFecha=" + creacionFecha + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
