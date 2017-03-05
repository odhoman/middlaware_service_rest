package com.anibal.educational.rest_service.comps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.anibal.educational.rest_service.comps.util.DbUtil;
import com.anibal.educational.rest_service.domain.DetalleGasto;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.db.DatabaseConnection;

/**
 *  
 * DAO de Detalle de Gasto
 *  
 * @author Jonatan Flores
 *
 */
public class DetalleGastoDao extends RestServiceAbstractAbmDAO<DetalleGasto, DetalleGasto>{

	public DetalleGastoDao() {
		super();
	}

	public DetalleGastoDao(AbstractConfig config) {
		super(config);
	}
	
	@Override
	protected String getMainTableName() {
		return "ac_detalle_gastos";
	}

	@Override
	protected List<String> getInsertFields(DetalleGasto item) {
		
		List<String> fields = new ArrayList<String>();
		fields.add("detalle_id");
		fields.add("gasto_id");
		fields.add("gastos_nro");
		fields.add("tarea");
		fields.add("fecha_gasto");
		fields.add("tipo_cambio");
		fields.add("importe");
		fields.add("code_combination_id");
		fields.add("observaciones");
		
		return fields;
	}

	@Override
	protected void fillInsertParameters(DetalleGasto item, PreparedStatement ps, DatabaseConnection db)
			throws Exception {


		if (item.getDetalleId() == null) {
			item.setDetalleId(DbUtil.getNewSequenceKey(db, "ac_detalle_gs_sq"));
		}

		List<Object> lista = new ArrayList<Object>();
		lista.add(item.getDetalleId());
		lista.add(item.getGastoId());
		lista.add(item.getGastosNro());
		lista.add(item.getTarea());
		lista.add(item.getFechaGasto());
		lista.add(item.getTipoCambio());
		lista.add(item.getImporte());
		lista.add(item.getCodeConvinationId());
		lista.add(item.getObservaciones());

		fillListParameter(1, lista, ps);
		
	}

	@Override
	protected List<String> getUpdateFields(DetalleGasto item) {
		
		List<String> fields = new ArrayList<String>();
		
		fields.add("gasto_id");
		fields.add("gastos_nro");
		fields.add("tarea");
		fields.add("fecha_gasto");
		fields.add("tipo_cambio");
		fields.add("importe");
		fields.add("code_combination_id");
		fields.add("observaciones");
		
		return fields;
	}

	@Override
	protected String getUpdateConditions(DetalleGasto filter) {
		List<String> fields = new ArrayList<String>();

		fields.add("detalle_id");

		return appendFields(fields);
	}

	@Override
	protected void fillUpdateParameters(DetalleGasto filter, DetalleGasto item, PreparedStatement ps,
			DatabaseConnection db) throws Exception {
		
		List<Object> lista = new ArrayList<Object>();

		// Valores a impactar
		lista.add(item.getGastoId());
		lista.add(item.getGastosNro());
		lista.add(item.getTarea());
		lista.add(item.getFechaGasto());
		lista.add(item.getTipoCambio());
		lista.add(item.getImporte());
		lista.add(item.getCodeConvinationId());
		lista.add(item.getObservaciones());

		// Valores de Condiciones/Filtro
		lista.add(filter.getDetalleId());
		
		fillListParameter(1, lista, ps);
		
	}

	@Override
	protected List<String> getSelectFields() {
		List<String> fields = new ArrayList<String>();
		fields.add("detalle_id");
		fields.add("gasto_id");
		fields.add("gastos_nro");
		fields.add("tarea");
		fields.add("fecha_gasto");
		fields.add("tipo_cambio");
		fields.add("importe");
		fields.add("code_combination_id");
		fields.add("observaciones");
		
		return fields;
	}

	@Override
	protected List<String> getSelectTables() {
		List<String> tables = new ArrayList<String>();

		tables.add("ac_detalle_gastos");

		return tables;
	}

	@Override
	protected String getSelectConditions(DetalleGasto filter) {
		
		List<String> fieldsSelectConditions = new ArrayList<String>();
		
		// Valores de Condiciones/Filtro
		
		if (filter.getDetalleId() != null) {
			fieldsSelectConditions.add("detalle_id");
		}

		if (filter.getGastoId() != null) {
			fieldsSelectConditions.add("gasto_id");
		}
		
		if (filter.getGastosNro() != null) {
			fieldsSelectConditions.add("gastos_nro");
		}
		
		if (isNotEmpty(filter.getTarea())) {
			fieldsSelectConditions.add("tarea");
		}
		
		if (filter.getFechaGasto() != null) {
			fieldsSelectConditions.add("fecha_gasto");
		}

		if (filter.getTipoCambio() != null) {
			fieldsSelectConditions.add("tipo_cambio");
		}

		if (filter.getImporte()!=null) {
			fieldsSelectConditions.add("importe");
		}

		if (filter.getCodeConvinationId()!=null) {
			fieldsSelectConditions.add("code_combination_id");
		}
		
		if (isNotEmpty(filter.getObservaciones())) {
			fieldsSelectConditions.add("observaciones");
		}

		return appendFields(fieldsSelectConditions);
	}

	@Override
	protected void fillSelectParameters(DetalleGasto filter, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		
		int sequenceNumber = 0;
		List<Object> lista = new ArrayList<Object>();
		
		sequenceNumber++;

		// Valores de Condiciones/Filtro
		lista.add(filter.getDetalleId());
		lista.add(filter.getGastoId());
		lista.add(filter.getGastosNro());
		lista.add(filter.getTarea());
		lista.add(filter.getFechaGasto());
		lista.add(filter.getTipoCambio());
		lista.add(filter.getImporte());
		lista.add(filter.getCodeConvinationId());
		lista.add(filter.getObservaciones());
		
		fillSelectListParameter(sequenceNumber, lista, ps);
		
	}

	@Override
	protected DetalleGasto loadItem(ResultSet rs) throws Exception {
		
		DetalleGasto dg = new DetalleGasto();
		
		dg.setDetalleId(rs.getLong("detalle_id"));
		dg.setGastoId(getValueOrNull(rs.getLong("gasto_id"),rs));
		dg.setGastosNro(getValueOrNull(rs.getLong("gastos_nro"),rs));
		dg.setTarea(rs.getString("tarea"));
		dg.setFechaGasto(rs.getDate("fecha_gasto"));
		dg.setTipoCambio(getValueOrNull(rs.getDouble("tipo_cambio"),rs));
		dg.setImporte(getValueOrNull(rs.getDouble("importe"),rs));
		dg.setCodeConvinationId(getValueOrNull(rs.getLong("code_combination_id"),rs));
		dg.setObservaciones(rs.getString("observaciones"));
		
		return dg;
	}

	@Override
	protected String getDeleteConditions(DetalleGasto filter) {
		List<String> fields = new ArrayList<String>();

		fields.add("detalle_id");

		return appendFields(fields);
	}

	@Override
	protected void fillDeleteParameters(DetalleGasto filter, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		
		
		int sequenceNumber = 0;
		List<Object> lista = new ArrayList<Object>();
		
		sequenceNumber++;

		// Valores de Condiciones/Filtro
		lista.add(filter.getDetalleId());
		
		fillListParameter(sequenceNumber, lista, ps);
		
	}

}
