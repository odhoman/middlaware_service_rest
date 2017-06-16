package com.anibal.educational.rest_service.comps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.anibal.educational.rest_service.comps.util.DbUtil;
import com.anibal.educational.rest_service.domain.TicketHeader;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.db.DatabaseConnection;

/**
 * 
 * DAO de TicketHeader
 * 
 * @author Jonatan Flores
 *
 */
public class TicketHeaderDao extends RestServiceAbstractAbmDAO<TicketHeader, TicketHeader> {

	
	public TicketHeaderDao() {
		super();
	}

	public TicketHeaderDao(AbstractConfig config) {
		super(config);
	}
	@Override
	protected String getMainTableName() {
		return "AC_TKT_HEADER_ALL";
	}

	@Override
	protected List<String> getInsertFields(TicketHeader item) {
		List<String> fields = new ArrayList<String>();

		fields.add("TICKET_ID");
		fields.add("PROYECTO_ID");
		fields.add("SUBPROYECTO_ID");
		fields.add("TAREA_ID");
		fields.add("PROYECTO_DESC");
		fields.add("SUBPROYECTO_DESC");
		fields.add("TAREA_DESC");
		fields.add("GASTOS_FECHA");
		fields.add("CREACION_FECHA");
		fields.add("IMPORTE");
		fields.add("USER_ID");
		fields.add("MONEDA");
		fields.add("MONEDA_FUNCIONAL");
		fields.add("TIPO_CAMBIO");
		fields.add("TIPO_CAMBIO_FECHA");
		fields.add("EMPLOYEE_ID");
		fields.add("EMPLOYEE_DESC");
		fields.add("PROVEEDOR_ID");
		fields.add("PROVEEDOR_DESC");
		fields.add("EMAIL");
		fields.add("PHONE_NUMBER");
		fields.add("DEPARTMENT_ID");
		fields.add("DEPARTMENT_DESC");

		return fields;

	}

	@Override
	protected void fillInsertParameters(TicketHeader item, PreparedStatement ps, DatabaseConnection db)
			throws Exception {

		if (item.getTicketId() == null) {
			item.setTicketId(DbUtil.getNewSequenceKey(db, "ac_tkt_header_gs_sq"));
		}

		List<Object> fields = new ArrayList<Object>();
		fields.add(item.getTicketId());
		fields.add(item.getProyectoId());
		fields.add(item.getSubproyectoId());
		fields.add(item.getTareaId());
		fields.add(item.getProyectoDesc());
		fields.add(item.getSubproyectoDesc());
		fields.add(item.getTareaDesc());
		fields.add(item.getGastosFecha());
		fields.add(item.getCreacionFecha());
		fields.add(item.getImporte());
		fields.add(item.getUserId());
		fields.add(item.getMoneda());
		fields.add(item.getMonedaFuncional());
		fields.add(item.getTipoCambio());
		fields.add(item.getTipoCambioFecha());
		fields.add(item.getEmployeeId());
		fields.add(item.getEmployeeDesc());
		fields.add(item.getProveedorId());
		fields.add(item.getProveedorDesc());
		fields.add(item.getEmail());
		fields.add(item.getPhoneNumber());
		fields.add(item.getDepartamentId());
		fields.add(item.getDepartamentDesc());

		fillInsertSelectListParameter(1, fields, ps);

	}

	@Override
	protected List<String> getUpdateFields(TicketHeader item) {
		List<String> fieldsSelectConditions = new ArrayList<String>();


		if (item.getProyectoId() != null) {
			fieldsSelectConditions.add("PROYECTO_ID");
		}

		if (item.getSubproyectoId() != null) {
			fieldsSelectConditions.add("SUBPROYECTO_ID");
		}

		if (item.getTareaId() != null) {
			fieldsSelectConditions.add("TAREA_ID");
		}

		if (item.getProyectoDesc() != null) {
			fieldsSelectConditions.add("PROYECTO_DESC");
		}

		if (isNotEmpty(item.getSubproyectoDesc())) {
			fieldsSelectConditions.add("SUBPROYECTO_DESC");
		}

		if (isNotEmpty(item.getTareaDesc())) {
			fieldsSelectConditions.add("TAREA_DESC");
		}

		if (item.getGastosFecha() != null) {
			fieldsSelectConditions.add("GASTOS_FECHA");
		}

		if (item.getCreacionFecha() != null) {
			fieldsSelectConditions.add("CREACION_FECHA");
		}

		if (item.getImporte() != null) {
			fieldsSelectConditions.add("IMPORTE");
		}

		if (item.getUserId() != null) {
			fieldsSelectConditions.add("USER_ID");
		}

		if (isNotEmpty(item.getMoneda())) {
			fieldsSelectConditions.add("MONEDA");
		}

		if (isNotEmpty(item.getMonedaFuncional())) {
			fieldsSelectConditions.add("MONEDA_FUNCIONAL");
		}

		if (item.getTipoCambio() != null) {
			fieldsSelectConditions.add("TIPO_CAMBIO");
		}

		if (item.getTipoCambioFecha() != null) {
			fieldsSelectConditions.add("TIPO_CAMBIO_FECHA");
		}

		if (item.getEmployeeId() != null) {
			fieldsSelectConditions.add("EMPLOYEE_ID");
		}

		if (isNotEmpty(item.getEmployeeDesc())) {
			fieldsSelectConditions.add("EMPLOYEE_DESC");
		}

		if (item.getProveedorId() != null) {
			fieldsSelectConditions.add("PROVEEDOR_ID");
		}

		if (isNotEmpty(item.getProveedorDesc())) {
			fieldsSelectConditions.add("PROVEEDOR_DESC");
		}

		if (isNotEmpty(item.getEmail())) {
			fieldsSelectConditions.add("EMAIL");
		}

		if (isNotEmpty(item.getPhoneNumber())) {
			fieldsSelectConditions.add("PHONE_NUMBER");
		}

		if (item.getDepartamentId() != null) {
			fieldsSelectConditions.add("DEPARTMENT_ID");
		}

		if (isNotEmpty(item.getDepartamentDesc())) {
			fieldsSelectConditions.add("DEPARTMENT_DESC");
		}

		return fieldsSelectConditions;

	}

	@Override
	protected String getUpdateConditions(TicketHeader filter) {
		List<String> fields = new ArrayList<String>();

		fields.add("TICKET_ID");

		return appendFields(fields);
	}

	@Override
	protected void fillUpdateParameters(TicketHeader filter, TicketHeader item, PreparedStatement ps,
			DatabaseConnection db) throws Exception {

		List<Object> fields = new ArrayList<Object>();

		// Valores a impactar
		fields.add(item.getProyectoId());
		fields.add(item.getSubproyectoId());
		fields.add(item.getTareaId());
		fields.add(item.getProyectoDesc());
		fields.add(item.getSubproyectoDesc());
		fields.add(item.getTareaDesc());
		fields.add(item.getGastosFecha());
		fields.add(item.getCreacionFecha());
		fields.add(item.getImporte());
		fields.add(item.getUserId());
		fields.add(item.getMoneda());
		fields.add(item.getMonedaFuncional());
		fields.add(item.getTipoCambio());
		fields.add(item.getTipoCambioFecha());
		fields.add(item.getEmployeeId());
		fields.add(item.getEmployeeDesc());
		fields.add(item.getProveedorId());
		fields.add(item.getProveedorDesc());
		fields.add(item.getEmail());
		fields.add(item.getPhoneNumber());
		fields.add(item.getDepartamentId());
		fields.add(item.getDepartamentDesc());

		// Valores de Condiciones/Filtro
		fields.add(filter.getTicketId());

		fillUpdateListParameter(1, fields, ps);

	}

	@Override
	protected List<String> getSelectFields() {
		List<String> fields = new ArrayList<String>();

		fields.add("TICKET_ID");
		fields.add("PROYECTO_ID");
		fields.add("SUBPROYECTO_ID");
		fields.add("TAREA_ID");
		fields.add("PROYECTO_DESC");
		fields.add("SUBPROYECTO_DESC");
		fields.add("TAREA_DESC");
		fields.add("GASTOS_FECHA");
		fields.add("CREACION_FECHA");
		fields.add("IMPORTE");
		fields.add("USER_ID");
		fields.add("MONEDA");
		fields.add("MONEDA_FUNCIONAL");
		fields.add("TIPO_CAMBIO");
		fields.add("TIPO_CAMBIO_FECHA");
		fields.add("EMPLOYEE_ID");
		fields.add("EMPLOYEE_DESC");
		fields.add("PROVEEDOR_ID");
		fields.add("PROVEEDOR_DESC");
		fields.add("EMAIL");
		fields.add("PHONE_NUMBER");
		fields.add("DEPARTMENT_ID");
		fields.add("DEPARTMENT_DESC");

		return fields;
	}

	@Override
	protected List<String> getSelectTables() {
		List<String> tables = new ArrayList<String>();
		tables.add("AC_TKT_HEADER_ALL");
		return tables;
	}

	@Override
	protected String getSelectConditions(TicketHeader filter) {
		List<String> fieldsSelectConditions = new ArrayList<String>();

		// Valores de Condiciones/Filtro

		if (filter.getTicketId() != null) {
			fieldsSelectConditions.add("TICKET_ID");
		}

		if (filter.getProyectoId() != null) {
			fieldsSelectConditions.add("PROYECTO_ID");
		}

		if (filter.getSubproyectoId() != null) {
			fieldsSelectConditions.add("SUBPROYECTO_ID");
		}

		if (filter.getTareaId() != null) {
			fieldsSelectConditions.add("TAREA_ID");
		}

		if (filter.getProyectoDesc() != null) {
			fieldsSelectConditions.add("PROYECTO_DESC");
		}

		if (isNotEmpty(filter.getSubproyectoDesc())) {
			fieldsSelectConditions.add("SUBPROYECTO_DESC");
		}

		if (isNotEmpty(filter.getTareaDesc())) {
			fieldsSelectConditions.add("TAREA_DESC");
		}

		if (filter.getGastosFecha() != null) {
			fieldsSelectConditions.add("GASTOS_FECHA");
		}

		if (filter.getCreacionFecha() != null) {
			fieldsSelectConditions.add("CREACION_FECHA");
		}

		if (filter.getImporte() != null) {
			fieldsSelectConditions.add("IMPORTE");
		}

		if (filter.getUserId() != null) {
			fieldsSelectConditions.add("USER_ID");
		}

		if (isNotEmpty(filter.getMoneda())) {
			fieldsSelectConditions.add("MONEDA");
		}

		if (isNotEmpty(filter.getMonedaFuncional())) {
			fieldsSelectConditions.add("MONEDA_FUNCIONAL");
		}

		if (filter.getTipoCambio() != null) {
			fieldsSelectConditions.add("TIPO_CAMBIO");
		}

		if (filter.getTipoCambioFecha() != null) {
			fieldsSelectConditions.add("TIPO_CAMBIO_FECHA");
		}

		if (filter.getEmployeeId() != null) {
			fieldsSelectConditions.add("EMPLOYEE_ID");
		}

		if (isNotEmpty(filter.getEmployeeDesc())) {
			fieldsSelectConditions.add("EMPLOYEE_DESC");
		}

		if (filter.getProveedorId() != null) {
			fieldsSelectConditions.add("PROVEEDOR_ID");
		}

		if (isNotEmpty(filter.getProveedorDesc())) {
			fieldsSelectConditions.add("PROVEEDOR_DESC");
		}

		if (isNotEmpty(filter.getEmail())) {
			fieldsSelectConditions.add("EMAIL");
		}

		if (isNotEmpty(filter.getPhoneNumber())) {
			fieldsSelectConditions.add("PHONE_NUMBER");
		}

		if (filter.getDepartamentId() != null) {
			fieldsSelectConditions.add("DEPARTMENT_ID");
		}

		if (isNotEmpty(filter.getDepartamentDesc())) {
			fieldsSelectConditions.add("DEPARTMENT_DESC");
		}

		return appendFields(fieldsSelectConditions);
	}

	@Override
	protected void fillSelectParameters(TicketHeader filter, PreparedStatement ps, DatabaseConnection db)
			throws Exception {

		int sequenceNumber = 0;
		List<Object> fields = new ArrayList<Object>();

		sequenceNumber++;

		// Valores a obtener
		fields.add(filter.getTicketId());
		fields.add(filter.getProyectoId());
		fields.add(filter.getSubproyectoId());
		fields.add(filter.getTareaId());
		fields.add(filter.getProyectoDesc());
		fields.add(filter.getSubproyectoDesc());
		fields.add(filter.getTareaDesc());
		fields.add(filter.getGastosFecha());
		fields.add(filter.getCreacionFecha());
		fields.add(filter.getImporte());
		fields.add(filter.getUserId());
		fields.add(filter.getMoneda());
		fields.add(filter.getMonedaFuncional());
		fields.add(filter.getTipoCambio());
		fields.add(filter.getTipoCambioFecha());
		fields.add(filter.getEmployeeId());
		fields.add(filter.getEmployeeDesc());
		fields.add(filter.getProveedorId());
		fields.add(filter.getProveedorDesc());
		fields.add(filter.getEmail());
		fields.add(filter.getPhoneNumber());
		fields.add(filter.getDepartamentId());
		fields.add(filter.getDepartamentDesc());

		fillSelectListParameter(sequenceNumber, fields, ps);

	}

	@Override
	protected TicketHeader loadItem(ResultSet rs) throws Exception {
		TicketHeader t = new TicketHeader();
		
		t.setTicketId(getValueOrNull(rs.getLong("TICKET_ID"),rs));
		t.setProyectoId(getValueOrNull(rs.getLong("PROYECTO_ID"),rs));
		t.setSubproyectoId(getValueOrNull(rs.getLong("SUBPROYECTO_ID"),rs));
		t.setTareaId(getValueOrNull(rs.getLong("TAREA_ID"),rs));
		t.setProyectoDesc(rs.getString("PROYECTO_DESC"));
		t.setSubproyectoDesc(rs.getString("SUBPROYECTO_DESC"));
		t.setTareaDesc(rs.getString("TAREA_DESC"));
		t.setGastosFecha(getValueOrNull(rs.getDate("GASTOS_FECHA"),rs));
		t.setCreacionFecha(getValueOrNull(rs.getDate("CREACION_FECHA"),rs));
		t.setImporte(getValueOrNull(rs.getDouble("IMPORTE"),rs));
		t.setUserId(getValueOrNull(rs.getLong("USER_ID"),rs));
		t.setMoneda(rs.getString("MONEDA"));
		t.setMonedaFuncional(rs.getString("MONEDA_FUNCIONAL"));
		t.setTipoCambio(getValueOrNull(rs.getDouble("TIPO_CAMBIO"),rs));
		t.setTipoCambioFecha(getValueOrNull(rs.getDate("TIPO_CAMBIO_FECHA"),rs));
		t.setEmployeeId(getValueOrNull(rs.getLong("EMPLOYEE_ID"),rs));
		t.setEmployeeDesc(rs.getString("EMPLOYEE_DESC"));
		t.setProveedorId(getValueOrNull(rs.getLong("PROVEEDOR_ID"),rs));
		t.setProveedorDesc(rs.getString("PROVEEDOR_DESC"));
		t.setEmail(rs.getString("EMAIL"));
		t.setPhoneNumber(rs.getString("PHONE_NUMBER"));
		t.setDepartamentId(getValueOrNull(rs.getLong("DEPARTMENT_ID"),rs));
		t.setDepartamentDesc(rs.getString("DEPARTMENT_DESC"));
		
		return t;
	}

	@Override
	protected String getDeleteConditions(TicketHeader filter) {
		List<String> fields = new ArrayList<String>();

		fields.add("TICKET_ID");

		return appendFields(fields);
	}

	@Override
	protected void fillDeleteParameters(TicketHeader filter, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		int sequenceNumber = 0;
		List<Object> lista = new ArrayList<Object>();
		
		sequenceNumber++;

		// Valores de Condiciones/Filtro
		lista.add(filter.getTicketId());
		
		fillInsertSelectListParameter(sequenceNumber, lista, ps);

	}
}
