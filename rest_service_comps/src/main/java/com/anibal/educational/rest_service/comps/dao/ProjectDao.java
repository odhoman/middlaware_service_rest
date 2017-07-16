package com.anibal.educational.rest_service.comps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.anibal.educational.rest_service.comps.util.DbUtil;
import com.anibal.educational.rest_service.domain.Project;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.db.DatabaseConnection;

public class ProjectDao extends RestServiceAbstractAbmDAO<Project, Project>{

	public ProjectDao() {
		super();
	}

	public ProjectDao(AbstractConfig config) {
		super(config);
	}
	
	@Override
	protected String getMainTableName() {
		return "AC_TKT_PROJECTS_ALL";
	}
	
	@Override
	protected List<String> getInsertFields(Project item) {
		return Arrays.asList("PROJECT_ID","PROJECT_NAME","USER_ID","CREACION_FECHA");
	}

	@Override
	protected void fillInsertParameters(Project item, PreparedStatement ps, DatabaseConnection db) throws Exception {
		List<Object> fields = new ArrayList<Object>();
		
		if (item.getProjectId() == null) {
			item.setProjectId(DbUtil.getNewSequenceKey(db, "AC_TKT_PROJECT_GS_SQ"));
		}
		
		fields.add(item.getProjectId());
		fields.add(item.getProjectName());
		fields.add(item.getUserId());
		fields.add(item.getCreacionFecha());
		
		fillInsertSelectListParameter(1, fields, ps);
	}

	@Override
	protected List<String> getUpdateFields(Project item) {
		List<String> fieldsUpdate = new ArrayList<String>();
		
		if (isNotNull(item.getProjectName())) {
			fieldsUpdate.add("PROJECT_NAME");
		}
		
		if (isNotNull(item.getUserId())) {
			fieldsUpdate.add("USER_ID");
		}
		
		return fieldsUpdate;
	}

	@Override
	protected String getUpdateConditions(Project filter) {
		
		List<String> fields = new ArrayList<String>();

		fields.add("PROJECT_ID");

		return appendFields(fields);
	}

	@Override
	protected void fillUpdateParameters(Project filter, Project item, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		
		List<Object> fields = new ArrayList<Object>();

		// Valores a impactar
		fields.add(item.getProjectName());
		fields.add(item.getUserId());

		// Valores de Condiciones/Filtro
		fields.add(filter.getProjectId());

		fillUpdateListParameter(1, fields, ps);
	}

	@Override
	protected List<String> getSelectFields() {
		return Arrays.asList("PROJECT_ID","PROJECT_NAME","USER_ID","CREACION_FECHA");
	}

	@Override
	protected List<String> getSelectTables() {
		return Arrays.asList("AC_TKT_PROJECTS_ALL");
	}

	@Override
	protected String getSelectConditions(Project filter) {
		
		List<String> fieldsSelectConditions = new ArrayList<String>();
		
		// Valores de Condiciones/Filtro
		if (filter.getProjectId() != null) {
			fieldsSelectConditions.add("PROJECT_ID");
		}
		
		if (isNotEmpty(filter.getProjectName())) {
			fieldsSelectConditions.add("PROJECT_NAME");
		}
		
		if (isNotNull(filter.getUserId())) {
			fieldsSelectConditions.add("USER_ID");
		}
		
		if (isNotNull(filter.getCreacionFecha())) {
			fieldsSelectConditions.add("CREACION_FECHA");
		}
		
		return appendFields(fieldsSelectConditions);
	}

	@Override
	protected void fillSelectParameters(Project filter, PreparedStatement ps, DatabaseConnection db) throws Exception {
		int sequenceNumber = 0;
		List<Object> fields = new ArrayList<Object>();

		sequenceNumber++;
		
		fields.add(filter.getProjectId());
		fields.add(filter.getProjectName());
		fields.add(filter.getUserId());
		fields.add(filter.getCreacionFecha());

		fillSelectListParameter(sequenceNumber, fields, ps);
		
	}

	@Override
	protected Project loadItem(ResultSet rs) throws Exception {
		
		Project p = new Project();
		
		p.setProjectId(getValueOrNull(rs.getLong("PROJECT_ID"),rs));
		p.setProjectName(rs.getString("PROJECT_NAME"));
		p.setUserId(getValueOrNull(rs.getLong("USER_ID"),rs));
		p.setCreacionFecha(getValueOrNull(rs.getDate("CREACION_FECHA"),rs));
		
		return p;
	}

	@Override
	protected String getDeleteConditions(Project filter) {
		List<String> fields = new ArrayList<String>();

		fields.add("PROJECT_ID");

		return appendFields(fields);
	}

	@Override
	protected void fillDeleteParameters(Project filter, PreparedStatement ps, DatabaseConnection db) throws Exception {
		
		int sequenceNumber = 0;
		List<Object> lista = new ArrayList<Object>();
		
		sequenceNumber++;

		// Valores de Condiciones/Filtro
		lista.add(filter.getProjectId());
		
		fillInsertSelectListParameter(sequenceNumber, lista, ps);
		
	}

}

