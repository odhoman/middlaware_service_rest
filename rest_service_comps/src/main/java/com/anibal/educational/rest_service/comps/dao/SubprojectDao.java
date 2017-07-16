package com.anibal.educational.rest_service.comps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.anibal.educational.rest_service.comps.util.DbUtil;
import com.anibal.educational.rest_service.domain.Subproject;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.db.DatabaseConnection;

public class SubprojectDao extends RestServiceAbstractAbmDAO<Subproject, Subproject>{
	
	public SubprojectDao() {
		super();
	}

	public SubprojectDao(AbstractConfig config) {
		super(config);
	}
	
	@Override
	protected String getMainTableName() {
		return "AC_TKT_SUB_PROJECTS_ALL";
	}
	
	@Override
	protected List<String> getInsertFields(Subproject item) {
		return Arrays.asList("SUB_PROJECT_ID","SUB_PROJECT_NAME","USER_ID","CREACION_FECHA");
	}

	@Override
	protected void fillInsertParameters(Subproject item, PreparedStatement ps, DatabaseConnection db) throws Exception {
		List<Object> fields = new ArrayList<Object>();
		
		if (item.getSubprojectId() == null) {
			item.setSubprojectId(DbUtil.getNewSequenceKey(db, "AC_TKT_SUB_PROJECT_GS_SQ"));
		}
		
		fields.add(item.getSubprojectId());
		fields.add(item.getSubprojectName());
		fields.add(item.getUserId());
		fields.add(item.getCreacionFecha());
		
		fillInsertSelectListParameter(1, fields, ps);
	}

	@Override
	protected List<String> getUpdateFields(Subproject item) {
		List<String> fieldsUpdate = new ArrayList<String>();
		
		if (isNotNull(item.getSubprojectName())) {
			fieldsUpdate.add("SUB_PROJECT_NAME");
		}
		
		if (isNotNull(item.getUserId())) {
			fieldsUpdate.add("USER_ID");
		}
		
		return fieldsUpdate;
	}

	@Override
	protected String getUpdateConditions(Subproject filter) {
		
		List<String> fields = new ArrayList<String>();

		fields.add("SUB_PROJECT_ID");

		return appendFields(fields);
	}

	@Override
	protected void fillUpdateParameters(Subproject filter, Subproject item, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		
		List<Object> fields = new ArrayList<Object>();

		// Valores a impactar
		fields.add(item.getSubprojectName());
		fields.add(item.getUserId());

		// Valores de Condiciones/Filtro
		fields.add(filter.getSubprojectId());

		fillUpdateListParameter(1, fields, ps);
	}

	@Override
	protected List<String> getSelectFields() {
		return Arrays.asList("SUB_PROJECT_ID","SUB_PROJECT_NAME","USER_ID","CREACION_FECHA");
	}

	@Override
	protected List<String> getSelectTables() {
		return Arrays.asList("AC_TKT_SUB_PROJECTS_ALL");
	}

	@Override
	protected String getSelectConditions(Subproject filter) {
		
		List<String> fieldsSelectConditions = new ArrayList<String>();
		
		// Valores de Condiciones/Filtro
		if (filter.getSubprojectId() != null) {
			fieldsSelectConditions.add("SUB_PROJECT_ID");
		}
		
		if (isNotEmpty(filter.getSubprojectName())) {
			fieldsSelectConditions.add("SUB_PROJECT_NAME");
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
	protected void fillSelectParameters(Subproject filter, PreparedStatement ps, DatabaseConnection db) throws Exception {
		int sequenceNumber = 0;
		List<Object> fields = new ArrayList<Object>();

		sequenceNumber++;
		
		fields.add(filter.getSubprojectId());
		fields.add(filter.getSubprojectName());
		fields.add(filter.getUserId());
		fields.add(filter.getCreacionFecha());

		fillSelectListParameter(sequenceNumber, fields, ps);
		
	}

	@Override
	protected Subproject loadItem(ResultSet rs) throws Exception {
		
		Subproject p = new Subproject();
		
		p.setSubprojectId(getValueOrNull(rs.getLong("SUB_PROJECT_ID"),rs));
		p.setSubprojectName(rs.getString("SUB_PROJECT_NAME"));
		p.setUserId(getValueOrNull(rs.getLong("USER_ID"),rs));
		p.setCreacionFecha(getValueOrNull(rs.getDate("CREACION_FECHA"),rs));
		
		return p;
	}

	@Override
	protected String getDeleteConditions(Subproject filter) {
		List<String> fields = new ArrayList<String>();

		fields.add("SUB_PROJECT_ID");

		return appendFields(fields);
	}

	@Override
	protected void fillDeleteParameters(Subproject filter, PreparedStatement ps, DatabaseConnection db) throws Exception {
		
		int sequenceNumber = 0;
		List<Object> lista = new ArrayList<Object>();
		
		sequenceNumber++;

		// Valores de Condiciones/Filtro
		lista.add(filter.getSubprojectId());
		
		fillInsertSelectListParameter(sequenceNumber, lista, ps);
		
	}


}
