package com.anibal.educational.rest_service.comps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.anibal.educational.rest_service.comps.util.DbUtil;
import com.anibal.educational.rest_service.domain.Moneda;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.db.DatabaseConnection;

public class MonedaDao extends RestServiceAbstractAbmDAO<Moneda, Moneda>{
	
	public MonedaDao() {
		super();
	}

	public MonedaDao(AbstractConfig config) {
		super(config);
	}
	
	@Override
	protected String getMainTableName() {
		return "AC_TKT_MONEDA_ALL";
	}
	
	@Override
	protected List<String> getInsertFields(Moneda item) {
		return Arrays.asList("MONEDA_ID","MONEDA_NAME","TIPO_CAMBIO","USER_ID","CREACION_FECHA");
	}

	@Override
	protected void fillInsertParameters(Moneda item, PreparedStatement ps, DatabaseConnection db) throws Exception {
		List<Object> fields = new ArrayList<Object>();
		
		if (item.getMonedaId() == null) {
			item.setMonedaId(DbUtil.getNewSequenceKey(db, "AC_TKT_MONEDA_GS_SQ"));
		}
		
		fields.add(item.getMonedaId());
		fields.add(item.getMonedaName());
		fields.add(item.getTipoCambio());
		fields.add(item.getUserId());
		fields.add(item.getCreacionFecha());
		
		fillInsertSelectListParameter(1, fields, ps);
	}

	@Override
	protected List<String> getUpdateFields(Moneda item) {
		List<String> fieldsUpdate = new ArrayList<String>();
		
		if (isNotNull(item.getMonedaName())) {
			fieldsUpdate.add("MONEDA_NAME");
		}
		
		if (isNotNull(item.getTipoCambio())) {
			fieldsUpdate.add("TIPO_CAMBIO");
		}
		
		return fieldsUpdate;
	}

	@Override
	protected String getUpdateConditions(Moneda filter) {
		
		List<String> fields = new ArrayList<String>();

		fields.add("MONEDA_ID");

		return appendFields(fields);
	}

	@Override
	protected void fillUpdateParameters(Moneda filter, Moneda item, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		
		List<Object> fields = new ArrayList<Object>();

		// Valores a impactar
		fields.add(item.getMonedaName());
		fields.add(item.getTipoCambio());

		// Valores de Condiciones/Filtro
		fields.add(filter.getMonedaId());

		fillUpdateListParameter(1, fields, ps);
	}

	@Override
	protected List<String> getSelectFields() {
		return Arrays.asList("MONEDA_ID","MONEDA_NAME","TIPO_CAMBIO","USER_ID","CREACION_FECHA");
	}

	@Override
	protected List<String> getSelectTables() {
		return Arrays.asList("AC_TKT_MONEDA_ALL");
	}

	@Override
	protected String getSelectConditions(Moneda filter) {
		
		List<String> fieldsSelectConditions = new ArrayList<String>();
		
		// Valores de Condiciones/Filtro
		if (filter.getMonedaId() != null) {
			fieldsSelectConditions.add("MONEDA_ID");
		}
		
		if (isNotEmpty(filter.getMonedaName())) {
			fieldsSelectConditions.add("MONEDA_NAME");
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
	protected void fillSelectParameters(Moneda filter, PreparedStatement ps, DatabaseConnection db) throws Exception {
		int sequenceNumber = 0;
		List<Object> fields = new ArrayList<Object>();

		sequenceNumber++;
		
		fields.add(filter.getMonedaId());
		fields.add(filter.getMonedaName());
		fields.add(filter.getUserId());
		fields.add(filter.getCreacionFecha());

		fillSelectListParameter(sequenceNumber, fields, ps);
		
	}

	@Override
	protected Moneda loadItem(ResultSet rs) throws Exception {
		
		Moneda p = new Moneda();
		
		p.setMonedaId(getValueOrNull(rs.getLong("MONEDA_ID"),rs));
		p.setMonedaName(rs.getString("MONEDA_NAME"));
		p.setTipoCambio(getValueOrNull(rs.getDouble("TIPO_CAMBIO"),rs));
		p.setUserId(getValueOrNull(rs.getLong("USER_ID"),rs));
		p.setCreacionFecha(getValueOrNull(rs.getDate("CREACION_FECHA"),rs));
		
		return p;
	}

	@Override
	protected String getDeleteConditions(Moneda filter) {
		List<String> fields = new ArrayList<String>();

		fields.add("MONEDA_ID");

		return appendFields(fields);
	}

	@Override
	protected void fillDeleteParameters(Moneda filter, PreparedStatement ps, DatabaseConnection db) throws Exception {
		
		int sequenceNumber = 0;
		List<Object> lista = new ArrayList<Object>();
		
		sequenceNumber++;

		// Valores de Condiciones/Filtro
		lista.add(filter.getMonedaId());
		
		fillInsertSelectListParameter(sequenceNumber, lista, ps);
		
	}


}
