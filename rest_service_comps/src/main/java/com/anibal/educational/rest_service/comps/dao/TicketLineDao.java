package com.anibal.educational.rest_service.comps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.anibal.educational.rest_service.comps.util.DbUtil;
import com.anibal.educational.rest_service.domain.TicketLine;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.db.DatabaseConnection;

public class TicketLineDao extends RestServiceAbstractAbmDAO<TicketLine, TicketLine> {

	public TicketLineDao() {
		super();
	}

	public TicketLineDao(AbstractConfig config) {
		super(config);
	}
	
	@Override
	protected String getMainTableName() {
		return "AC_TKT_LINES_ALL";
	}

	@Override
	protected List<String> getInsertFields(TicketLine item) {

		return Arrays.asList("LINE_ID", "TICKET_ID", "TIPO_GASTO", "PROVEEDOR_ID", "CIUDAD_ID", "PAIS_ID",
				"CIUDAD_DESC", "PAIS_DESC", "PROYECTO_ID", "SUBPROYECTO_ID", "TAREA_ID", "PROYECTO_DESC",
				"SUBPROYECTO_DESC", "TAREA_DESC", "GASTOS_FECHA", "IMPORTE", "MONEDA", "MONEDA_FUNCIONAL",
				"TIPO_CAMBIO", "TIPO_CAMBIO_FECHA", "USER_ID", "CREACION_FECHA", "IMAGE_ID", "PATH_IMAGE_ID");
	}

	@Override
	protected void fillInsertParameters(TicketLine item, PreparedStatement ps, DatabaseConnection db) throws Exception {
		List<Object> fields = new ArrayList<Object>();

		if (item.getLineId() == null) {
			item.setLineId(DbUtil.getNewSequenceKey(db, "ac_tkt_line_gs_sq"));
		}
		
		fields.add(item.getLineId());
		fields.add(item.getTicketId());
		fields.add(item.getTipoGasto());
		fields.add(item.getProveedorId());
		fields.add(item.getCiudadId());
		fields.add(item.getPaisId());
		fields.add(item.getCiudadDesc());
		fields.add(item.getPaisDesc());
		fields.add(item.getProyectoId());
		fields.add(item.getSubproyectoId());
		fields.add(item.getTareaId());
		fields.add(item.getProyectoDesc());
		fields.add(item.getSubproyectoDesc());
		fields.add(item.getTareaDesc());
		fields.add(item.getGastosFecha());
		fields.add(item.getImporte());
		fields.add(item.getMoneda());
		fields.add(item.getMonedaFuncional());
		fields.add(item.getTipoCambio());
		fields.add(item.getTipoCambioFecha());
		fields.add(item.getUserId());
		fields.add(item.getCreacionFecha());
		fields.add(item.getImageId());
		fields.add(item.getPathImageId());
		

		fillInsertSelectListParameter(1, fields, ps);
		
	}

	@Override
	protected List<String> getUpdateFields(TicketLine item) {
		
		List<String> fieldsUpdate = new ArrayList<String>();
		
		if (item.getTicketId() != null) {
			fieldsUpdate.add("TICKET_ID");
		}
		
		if (isNotEmpty(item.getTipoGasto())) {
			fieldsUpdate.add("TIPO_GASTO");
		}
		
		if (item.getProveedorId() != null) {
			fieldsUpdate.add("PROVEEDOR_ID");
		}
		
		if (item.getCiudadId() != null) {
			fieldsUpdate.add("CIUDAD_ID");
		}
		
		if (item.getPaisId() != null) {
			fieldsUpdate.add("PAIS_ID");
		}
		
		if (isNotEmpty(item.getCiudadDesc())) {
			fieldsUpdate.add("CIUDAD_DESC");
		}
		
		if (isNotEmpty(item.getPaisDesc())) {
			fieldsUpdate.add("PAIS_DESC");
		}

		if (item.getProyectoId() != null) {
			fieldsUpdate.add("PROYECTO_ID");
		}
		
		if (item.getSubproyectoId() != null) {
			fieldsUpdate.add("SUBPROYECTO_ID");
		}
		
		if (item.getTareaId() != null) {
			fieldsUpdate.add("TAREA_ID");
		}	
		
		if (isNotEmpty(item.getProyectoDesc())) {
			fieldsUpdate.add("PROYECTO_DESC");
		}
		
		if (isNotEmpty(item.getSubproyectoDesc())) {
			fieldsUpdate.add("SUBPROYECTO_DESC");
		}
		
		if (isNotEmpty(item.getTareaDesc())) {
			fieldsUpdate.add("TAREA_DESC");
		}
		
		if (item.getGastosFecha()!= null) {
			fieldsUpdate.add("GASTOS_FECHA");
		}	
		
		if (item.getImporte()!= null) {
			fieldsUpdate.add("IMPORTE");
		}	
		
		if (isNotEmpty(item.getMoneda())){
			fieldsUpdate.add("MONEDA");
		}	
		
		if (isNotEmpty(item.getMonedaFuncional())) {
			fieldsUpdate.add("MONEDA_FUNCIONAL");
		}
		
		if (item.getTipoCambio()!= null) {
			fieldsUpdate.add("TIPO_CAMBIO");
		}	
		
		if (item.getTipoCambioFecha()!= null) {
			fieldsUpdate.add("TIPO_CAMBIO_FECHA");
		}	
		
		if (item.getUserId()!= null) {
			fieldsUpdate.add("USER_ID");
		}	
		
		if (item.getCreacionFecha()!= null) {
			fieldsUpdate.add("CREACION_FECHA");
		}	
		
		if (item.getImageId()!= null) {
			fieldsUpdate.add("IMAGE_ID");
		}
		
		if (isNotEmpty(item.getPathImageId())) {
			fieldsUpdate.add("PATH_IMAGE_ID");
		}
		
		return fieldsUpdate;
	}

	@Override
	protected String getUpdateConditions(TicketLine filter) {
		List<String> fields = new ArrayList<String>();

		fields.add("LINE_ID");

		return appendFields(fields);

	}

	@Override
	protected void fillUpdateParameters(TicketLine filter, TicketLine item, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		
		List<Object> fields = new ArrayList<Object>();

		// Valores a impactar
		fields.add(item.getTicketId());
		fields.add(item.getTipoGasto());
		fields.add(item.getProveedorId());
		fields.add(item.getCiudadId());
		fields.add(item.getPaisId());
		fields.add(item.getCiudadDesc());
		fields.add(item.getPaisDesc());
		fields.add(item.getProyectoId());
		fields.add(item.getSubproyectoId());
		fields.add(item.getTareaId());
		fields.add(item.getProyectoDesc());
		fields.add(item.getSubproyectoDesc());
		fields.add(item.getTareaDesc());
		fields.add(item.getGastosFecha());
		fields.add(item.getImporte());
		fields.add(item.getMoneda());
		fields.add(item.getMonedaFuncional());
		fields.add(item.getTipoCambio());
		fields.add(item.getTipoCambioFecha());
		fields.add(item.getUserId());
		fields.add(item.getCreacionFecha());
		fields.add(item.getImageId());
		fields.add(item.getPathImageId());

		// Valores de Condiciones/Filtro
		fields.add(filter.getLineId());

		fillUpdateListParameter(1, fields, ps);
		
	}

	@Override
	protected List<String> getSelectFields() {
		return Arrays.asList("LINE_ID", "TICKET_ID", "TIPO_GASTO", "PROVEEDOR_ID", "CIUDAD_ID", "PAIS_ID",
				"CIUDAD_DESC", "PAIS_DESC", "PROYECTO_ID", "SUBPROYECTO_ID", "TAREA_ID", "PROYECTO_DESC",
				"SUBPROYECTO_DESC", "TAREA_DESC", "GASTOS_FECHA", "IMPORTE", "MONEDA", "MONEDA_FUNCIONAL",
				"TIPO_CAMBIO", "TIPO_CAMBIO_FECHA", "USER_ID", "CREACION_FECHA", "IMAGE_ID", "PATH_IMAGE_ID");
	}

	@Override
	protected List<String> getSelectTables() {
		return Arrays.asList("AC_TKT_LINES_ALL");
	}

	@Override
	protected String getSelectConditions(TicketLine filter) {
		List<String> fieldsSelectConditions = new ArrayList<String>();
		
		// Valores de Condiciones/Filtro
		if (filter.getLineId() != null) {
			fieldsSelectConditions.add("LINE_ID");
		}
		
		if (filter.getTicketId() != null) {
			fieldsSelectConditions.add("TICKET_ID");
		}
		
		if (isNotEmpty(filter.getTipoGasto())) {
			fieldsSelectConditions.add("TIPO_GASTO");
		}
		
		if (filter.getProveedorId() != null) {
			fieldsSelectConditions.add("PROVEEDOR_ID");
		}
		
		if (filter.getCiudadId() != null) {
			fieldsSelectConditions.add("CIUDAD_ID");
		}
		
		if (filter.getPaisId() != null) {
			fieldsSelectConditions.add("PAIS_ID");
		}
		
		if (isNotEmpty(filter.getCiudadDesc())) {
			fieldsSelectConditions.add("CIUDAD_DESC");
		}
		
		if (isNotEmpty(filter.getPaisDesc())) {
			fieldsSelectConditions.add("PAIS_DESC");
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
		
		if (isNotEmpty(filter.getProyectoDesc())) {
			fieldsSelectConditions.add("PROYECTO_DESC");
		}
		
		if (isNotEmpty(filter.getSubproyectoDesc())) {
			fieldsSelectConditions.add("SUBPROYECTO_DESC");
		}
		
		if (isNotEmpty(filter.getTareaDesc())) {
			fieldsSelectConditions.add("TAREA_DESC");
		}
		
		if (filter.getGastosFecha()!= null) {
			fieldsSelectConditions.add("GASTOS_FECHA");
		}	
		
		if (filter.getImporte()!= null) {
			fieldsSelectConditions.add("IMPORTE");
		}	
		
		if (isNotEmpty(filter.getMoneda())){
			fieldsSelectConditions.add("MONEDA");
		}	
		
		if (isNotEmpty(filter.getMonedaFuncional())) {
			fieldsSelectConditions.add("MONEDA_FUNCIONAL");
		}
		
		if (filter.getTipoCambio()!= null) {
			fieldsSelectConditions.add("TIPO_CAMBIO");
		}	
		
		if (filter.getTipoCambioFecha()!= null) {
			fieldsSelectConditions.add("TIPO_CAMBIO_FECHA");
		}	
		
		if (filter.getUserId()!= null) {
			fieldsSelectConditions.add("USER_ID");
		}	
		
		if (filter.getCreacionFecha()!= null) {
			fieldsSelectConditions.add("CREACION_FECHA");
		}	
		
		if (filter.getImageId()!= null) {
			fieldsSelectConditions.add("IMAGE_ID");
		}
		
		if (isNotEmpty(filter.getPathImageId())) {
			fieldsSelectConditions.add("PATH_IMAGE_ID");
		}
		
		return appendFields(fieldsSelectConditions);
	}

	@Override
	protected void fillSelectParameters(TicketLine filter, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		int sequenceNumber = 0;
		List<Object> fields = new ArrayList<Object>();

		sequenceNumber++;
		
		fields.add(filter.getLineId());
		fields.add(filter.getTicketId());
		fields.add(filter.getTipoGasto());
		fields.add(filter.getProveedorId());
		fields.add(filter.getCiudadId());
		fields.add(filter.getPaisId());
		fields.add(filter.getCiudadDesc());
		fields.add(filter.getPaisDesc());
		fields.add(filter.getProyectoId());
		fields.add(filter.getSubproyectoId());
		fields.add(filter.getTareaId());
		fields.add(filter.getProyectoDesc());
		fields.add(filter.getSubproyectoDesc());
		fields.add(filter.getTareaDesc());
		fields.add(filter.getGastosFecha());
		fields.add(filter.getImporte());
		fields.add(filter.getMoneda());
		fields.add(filter.getMonedaFuncional());
		fields.add(filter.getTipoCambio());
		fields.add(filter.getTipoCambioFecha());
		fields.add(filter.getUserId());
		fields.add(filter.getCreacionFecha());
		fields.add(filter.getImageId());
		fields.add(filter.getPathImageId());

		fillSelectListParameter(sequenceNumber, fields, ps);
		
	}

	@Override
	protected TicketLine loadItem(ResultSet rs) throws Exception {
		TicketLine tl = new TicketLine();
		
		tl.setLineId(getValueOrNull(rs.getLong("LINE_ID"),rs));
		tl.setTicketId(getValueOrNull(rs.getLong("TICKET_ID"),rs));
		tl.setTipoGasto(rs.getString("TIPO_GASTO"));
		tl.setProveedorId(getValueOrNull(rs.getLong("PROVEEDOR_ID"),rs));
		tl.setCiudadId(getValueOrNull(rs.getLong("CIUDAD_ID"),rs));
		tl.setPaisId(getValueOrNull(rs.getLong("PAIS_ID"),rs));
		tl.setCiudadDesc(rs.getString("CIUDAD_DESC"));
		tl.setPaisDesc(rs.getString("PAIS_DESC"));
		tl.setProyectoId(getValueOrNull(rs.getLong("PROYECTO_ID"),rs));
		tl.setSubproyectoId(getValueOrNull(rs.getLong("SUBPROYECTO_ID"),rs));
		tl.setTareaId(getValueOrNull(rs.getLong("TAREA_ID"),rs));
		tl.setProyectoDesc(rs.getString("PROYECTO_DESC"));
		tl.setSubproyectoDesc(rs.getString("SUBPROYECTO_DESC"));
		tl.setTareaDesc(rs.getString("TAREA_DESC"));
		tl.setGastosFecha(getValueOrNull(rs.getDate("GASTOS_FECHA"),rs));
		tl.setImporte(getValueOrNull(rs.getDouble("IMPORTE"),rs));
		tl.setMoneda(rs.getString("MONEDA"));
		tl.setMonedaFuncional(rs.getString("MONEDA_FUNCIONAL"));
		tl.setTipoCambio(getValueOrNull(rs.getDouble("TIPO_CAMBIO"),rs));
		tl.setTipoCambioFecha(getValueOrNull(rs.getDate("TIPO_CAMBIO_FECHA"),rs));
		tl.setUserId(getValueOrNull(rs.getLong("USER_ID"),rs));
		tl.setCreacionFecha(getValueOrNull(rs.getDate("CREACION_FECHA"),rs));
		tl.setImageId(getValueOrNull(rs.getLong("IMAGE_ID"),rs));
		tl.setPathImageId(rs.getString("PATH_IMAGE_ID"));
		
		return tl;
	}

	@Override
	protected String getDeleteConditions(TicketLine filter) {
		List<String> fields = new ArrayList<String>();

		fields.add("LINE_ID");

		return appendFields(fields);
	}

	@Override
	protected void fillDeleteParameters(TicketLine filter, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		
		int sequenceNumber = 0;
		List<Object> lista = new ArrayList<Object>();
		
		sequenceNumber++;

		// Valores de Condiciones/Filtro
		lista.add(filter.getLineId());
		
		fillInsertSelectListParameter(sequenceNumber, lista, ps);
		
	}

}
