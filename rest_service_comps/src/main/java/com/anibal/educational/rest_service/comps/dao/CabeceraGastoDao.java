package com.anibal.educational.rest_service.comps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.anibal.educational.rest_service.comps.util.DbUtil;
import com.anibal.educational.rest_service.domain.CabeceraGasto;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.db.DatabaseConnection;

/**
 *  
 * DAO de Cabecera Gasto
 *  
 * @author Jonatan Flores
 *
 */
public class CabeceraGastoDao extends RestServiceAbstractAbmDAO<CabeceraGasto, CabeceraGasto> {

	public CabeceraGastoDao() {
		super();
	}

	public CabeceraGastoDao(AbstractConfig config) {
		super(config);
	}

	@Override
	protected String getMainTableName() {
		return "ac_cabecera_gastos";
	}

	@Override
	protected List<String> getInsertFields(CabeceraGasto item) {

		List<String> fields = new ArrayList<String>();
		fields.add("gasto_id");
		fields.add("gastos_nro");
		fields.add("proyecto_id");
		fields.add("subproyecto_id");
		fields.add("tipo_gasto");
		fields.add("ciudad");
		fields.add("pais");
		fields.add("fecha_gasto");
		fields.add("proveedor");
		fields.add("tipo_cambio");
		fields.add("importe");
		fields.add("usuario_id");
		fields.add("observaciones");

		return fields;

	}

	@Override
	protected void fillInsertParameters(CabeceraGasto item, PreparedStatement ps, DatabaseConnection db)
			throws Exception {

		if (item.getGastoId() == null) {
			item.setGastoId(DbUtil.getNewSequenceKey(db, "ac_cabecera_gs_sq"));
		}

		ps.setLong(1, item.getGastoId());

		List<Object> lista = new ArrayList<Object>();
		lista.add(item.getGastoNro());
		lista.add(item.getProyectoId());
		lista.add(item.getSubProyectoId());
		lista.add(item.getTipoGasto());
		lista.add(item.getCiudad());
		lista.add(item.getPais());
		lista.add(item.getFechaGasto());
		lista.add(item.getProveedor());
		lista.add(item.getTipoCambio());
		lista.add(item.getImporte());
		lista.add(item.getUserId());
		lista.add(item.getObservaciones());

		fillListParameter(2, lista, ps);

	}

	@Override
	protected List<String> getUpdateFields(CabeceraGasto item) {

		List<String> fields = new ArrayList<String>();

		fields.add("gastos_nro");
		fields.add("proyecto_id");
		fields.add("subproyecto_id");
		fields.add("tipo_gasto");
		fields.add("ciudad");
		fields.add("pais");
		fields.add("fecha_gasto");
		fields.add("proveedor");
		fields.add("tipo_cambio");
		fields.add("importe");
		fields.add("usuario_id");
		fields.add("observaciones");
		//
		// if (item.getGastoNro() != null) {
		// fields.add("gastos_nro");
		// }
		//
		// if (item.getProyectoId() != null) {
		// fields.add("proyecto_id");
		// }
		//
		// if (item.getSubProyectoId() != null) {
		// fields.add("subproyecto_id");
		// }
		//
		// if (isNotEmpty(item.getTipoGasto())) {
		// fields.add("tipo_gasto");
		// }
		//
		// if (isNotEmpty(item.getCiudad())) {
		// fields.add("ciudad");
		// }
		//
		// if (isNotEmpty(item.getPais())) {
		// fields.add("pais");
		// }
		//
		// if (item.getFechaGasto() != null) {
		// fields.add("fecha_gasto");
		// }
		//
		// if (isNotEmpty(item.getProveedor())) {
		// fields.add("proveedor");
		// }
		//
		// if (item.getTipoCambio() != null) {
		// fields.add("tipo_cambio");
		// }
		//
		// if (item.getImporte() != null) {
		// fields.add("importe");
		// }
		//
		// if (item.getUserId() != null) {
		// fields.add("usuario_id");
		// }
		//
		// if (isNotEmpty(item.getObservaciones())) {
		// fields.add("observaciones");
		// }

		return fields;
	}

	@Override
	protected String getUpdateConditions(CabeceraGasto filter) {
		List<String> fields = new ArrayList<String>();

		// if (filter.getGastoNro() != null) {
		fields.add("gasto_id");
		// }

		// if (filter.getGastoNro() != null) {
		// fields.add("gastos_nro");
		// }
		//
		// if (filter.getProyectoId() != null) {
		// fields.add("proyecto_id");
		// }
		//
		// if (filter.getSubProyectoId() != null) {
		// fields.add("subproyecto_id");
		// }
		//
		// if (isNotEmpty(filter.getTipoGasto())) {
		// fields.add("tipo_gasto");
		// }
		//
		// if (isNotEmpty(filter.getCiudad())) {
		// fields.add("ciudad");
		// }
		//
		// if (isNotEmpty(filter.getPais())) {
		// fields.add("pais");
		// }
		//
		// if (filter.getFechaGasto() != null) {
		// fields.add("fecha_gasto");
		// }
		//
		// if (isNotEmpty(filter.getProveedor())) {
		// fields.add("proveedor");
		// }
		//
		// if (filter.getTipoCambio() != null) {
		// fields.add("tipo_cambio");
		// }
		//
		// if (filter.getImporte() != null) {
		// fields.add("importe");
		// }
		//
		// if (filter.getUserId() != null) {
		// fields.add("usuario_id");
		// }
		//
		// if (isNotEmpty(filter.getObservaciones())) {
		// fields.add("observaciones");
		// }

		return appendFields(fields);
	}

	@Override
	protected void fillUpdateParameters(CabeceraGasto filter, CabeceraGasto item, PreparedStatement ps,
			DatabaseConnection db) throws Exception {

		int sequenceNumber = 0;

		// Valores a impactar

		// if (item.getGastoNro() != null) {
		// sequenceNumber++;
		// ps.setLong(sequenceNumber, item.getGastoNro());
		// }

		sequenceNumber++;

		List<Object> lista = new ArrayList<Object>();

		// Valores a impactar
		lista.add(item.getGastoNro());
		lista.add(item.getProyectoId());
		lista.add(item.getSubProyectoId());
		lista.add(item.getTipoGasto());
		lista.add(item.getCiudad());
		lista.add(item.getPais());
		lista.add(item.getFechaGasto());
		lista.add(item.getProveedor());
		lista.add(item.getTipoCambio());
		lista.add(item.getImporte());
		lista.add(item.getUserId());
		lista.add(item.getObservaciones());

		// Valores de Condiciones/Filtro
		lista.add(filter.getGastoId());

		// sequenceNumber =
		
		fillListParameter(sequenceNumber, lista, ps);

		// if (item.getProyectoId() != null) {
		// sequenceNumber++;
		// ps.setLong(sequenceNumber, item.getProyectoId());
		// }
		//
		// if (item.getSubProyectoId() != null) {
		// sequenceNumber++;
		// ps.setLong(sequenceNumber, item.getSubProyectoId());
		// }
		//
		// if (isNotEmpty(item.getTipoGasto())) {
		// sequenceNumber++;
		// ps.setString(sequenceNumber, item.getTipoGasto());
		// }
		//
		// if (isNotEmpty(item.getCiudad())) {
		// sequenceNumber++;
		// ps.setString(sequenceNumber, item.getCiudad());
		// }
		//
		// if (isNotEmpty(item.getPais())) {
		// sequenceNumber++;
		// ps.setString(sequenceNumber, item.getPais());
		// }
		//
		// if (item.getFechaGasto() != null) {
		// sequenceNumber++;
		// ps.setDate(sequenceNumber, new
		// java.sql.Date(item.getFechaGasto().getTime()));
		// }
		//
		// if (isNotEmpty(item.getProveedor())) {
		// sequenceNumber++;
		// ps.setString(sequenceNumber, item.getProveedor());
		// }
		//
		// if (item.getTipoCambio() != null) {
		// sequenceNumber++;
		// ps.setDouble(sequenceNumber, item.getTipoCambio());
		// }
		//
		// if (item.getImporte() != null) {
		// sequenceNumber++;
		// ps.setDouble(sequenceNumber, item.getImporte());
		// }
		//
		// if (item.getUserId() != null) {
		// sequenceNumber++;
		// ps.setLong(sequenceNumber, item.getUserId());
		// }
		//
		// if (isNotEmpty(item.getObservaciones())) {
		// sequenceNumber++;
		// ps.setString(sequenceNumber, item.getObservaciones());
		// }
		//
		// Valores de Condiciones/Filtro

		// if (filter.getGastoId() != null) {
		//// sequenceNumber++;
		// ps.setLong(sequenceNumber, filter.getGastoId());
		// }
		//
		// if (filter.getGastoNro() != null) {
		// sequenceNumber++;
		// ps.setLong(sequenceNumber, filter.getGastoNro());
		// }
		//
		// if (filter.getProyectoId() != null) {
		// sequenceNumber++;
		// ps.setLong(sequenceNumber, filter.getProyectoId());
		// }
		//
		// if (filter.getSubProyectoId() != null) {
		// sequenceNumber++;
		// ps.setLong(sequenceNumber, filter.getSubProyectoId());
		// }
		//
		// if (isNotEmpty(filter.getTipoGasto())) {
		// sequenceNumber++;
		// ps.setString(sequenceNumber, filter.getTipoGasto());
		// }
		//
		// if (isNotEmpty(filter.getCiudad())) {
		// sequenceNumber++;
		// ps.setString(sequenceNumber, filter.getCiudad());
		// }
		//
		// if (isNotEmpty(filter.getPais())) {
		// sequenceNumber++;
		// ps.setString(sequenceNumber, filter.getPais());
		// }
		//
		// if (filter.getFechaGasto() != null) {
		// sequenceNumber++;
		// ps.setDate(sequenceNumber, new
		// java.sql.Date(filter.getFechaGasto().getTime()));
		// }
		//
		// if (isNotEmpty(filter.getProveedor())) {
		// sequenceNumber++;
		// ps.setString(sequenceNumber, filter.getProveedor());
		// }
		//
		// if (filter.getTipoCambio() != null) {
		// sequenceNumber++;
		// ps.setDouble(sequenceNumber, filter.getTipoCambio());
		// }
		//
		// if (filter.getImporte() != null) {
		// sequenceNumber++;
		// ps.setDouble(sequenceNumber, filter.getImporte());
		// }
		//
		// if (filter.getUserId() != null) {
		// sequenceNumber++;
		// ps.setLong(sequenceNumber, filter.getUserId());
		// }
		//
		// if (isNotEmpty(filter.getObservaciones())) {
		// sequenceNumber++;
		// ps.setString(sequenceNumber, filter.getObservaciones());
		// }

	}

	@Override
	protected List<String> getSelectFields() {

		List<String> fields = new ArrayList<String>();
		fields.add("gasto_id");
		fields.add("gastos_nro");
		fields.add("proyecto_id");
		fields.add("subproyecto_id");
		fields.add("tipo_gasto");
		fields.add("ciudad");
		fields.add("pais");
		fields.add("fecha_gasto");
		fields.add("proveedor");
		fields.add("tipo_cambio");
		fields.add("importe");
		fields.add("usuario_id");
		fields.add("observaciones");

		return fields;
	}

	@Override
	protected List<String> getSelectTables() {
		List<String> tables = new ArrayList<String>();

		tables.add("ac_cabecera_gastos");

		return tables;
	}

	@Override
	protected String getSelectConditions(CabeceraGasto filter) {
		List<String> fieldsSelectConditions = new ArrayList<String>();

		// Valores de Condiciones/Filtro

		if (filter.getGastoId() != null) {
			fieldsSelectConditions.add("gasto_id");
		}

		if (filter.getGastoNro() != null) {
			fieldsSelectConditions.add("gastos_nro");
		}

		if (filter.getProyectoId() != null) {
			fieldsSelectConditions.add("proyecto_id");
		}

		if (filter.getSubProyectoId() != null) {
			fieldsSelectConditions.add("subproyecto_id");
		}

		if (isNotEmpty(filter.getTipoGasto())) {
			fieldsSelectConditions.add("tipo_gasto");
		}

		if (isNotEmpty(filter.getCiudad())) {
			fieldsSelectConditions.add("ciudad");
		}

		if (isNotEmpty(filter.getPais())) {
			fieldsSelectConditions.add("pais");
		}

		if (filter.getFechaGasto() != null) {
			fieldsSelectConditions.add("fecha_gasto");
		}

		if (isNotEmpty(filter.getProveedor())) {
			fieldsSelectConditions.add("proveedor");
		}

		if (filter.getTipoCambio() != null) {
			fieldsSelectConditions.add("tipo_cambio");
		}

		if (filter.getImporte() != null) {
			fieldsSelectConditions.add("importe");
		}

		if (filter.getUserId() != null) {
			fieldsSelectConditions.add("usuario_id");
		}

		if (isNotEmpty(filter.getObservaciones())) {
			fieldsSelectConditions.add("observaciones");
		}

		return appendFields(fieldsSelectConditions);
	}

	@Override
	protected void fillSelectParameters(CabeceraGasto filter, PreparedStatement ps, DatabaseConnection db)
			throws Exception {

		Integer sequenceNumber = 0;

		// Valores de Condiciones/Filtro

		if (filter.getGastoId() != null) {
			sequenceNumber++;
			ps.setLong(sequenceNumber, filter.getGastoId());
		}

		if (filter.getGastoNro() != null) {
			sequenceNumber++;
			ps.setLong(sequenceNumber, filter.getGastoNro());
		}

		if (filter.getProyectoId() != null) {
			sequenceNumber++;
			ps.setLong(sequenceNumber, filter.getProyectoId());
		}

		if (filter.getSubProyectoId() != null) {
			sequenceNumber++;
			ps.setLong(sequenceNumber, filter.getSubProyectoId());
		}

		if (isNotEmpty(filter.getTipoGasto())) {
			sequenceNumber++;
			ps.setString(sequenceNumber, filter.getTipoGasto());
		}

		if (isNotEmpty(filter.getCiudad())) {
			sequenceNumber++;
			ps.setString(sequenceNumber, filter.getCiudad());
		}

		if (isNotEmpty(filter.getPais())) {
			sequenceNumber++;
			ps.setString(sequenceNumber, filter.getPais());
		}

		if (filter.getFechaGasto() != null) {
			sequenceNumber++;
			ps.setDate(sequenceNumber, new java.sql.Date(filter.getFechaGasto().getTime()));
		}

		if (isNotEmpty(filter.getProveedor())) {
			sequenceNumber++;
			ps.setString(sequenceNumber, filter.getProveedor());
		}

		if (filter.getTipoCambio() != null) {
			sequenceNumber++;
			ps.setDouble(sequenceNumber, filter.getTipoCambio());
		}

		if (filter.getImporte() != null) {
			sequenceNumber++;
			ps.setDouble(sequenceNumber, filter.getImporte());
		}

		if (filter.getUserId() != null) {
			sequenceNumber++;
			ps.setLong(sequenceNumber, filter.getUserId());
		}

		if (isNotEmpty(filter.getObservaciones())) {
			sequenceNumber++;
			ps.setString(sequenceNumber, filter.getObservaciones());
		}

	}

	@Override
	protected CabeceraGasto loadItem(ResultSet rs) throws Exception {
		CabeceraGasto cg = new CabeceraGasto();

		cg.setGastoId(rs.getLong("gasto_id"));
		cg.setGastoNro(getValueOrNull(rs.getLong("gastos_nro"), rs));
		cg.setProyectoId(getValueOrNull(rs.getLong("proyecto_id"), rs));
		cg.setSubProyectoId(getValueOrNull(rs.getLong("subproyecto_id"), rs));
		cg.setTipoGasto(rs.getString("tipo_gasto"));
		cg.setCiudad(rs.getString("ciudad"));
		cg.setPais(rs.getString("pais"));
		cg.setFechaGasto(rs.getDate("fecha_gasto"));
		cg.setProveedor(rs.getString("proveedor"));
		cg.setTipoCambio(getValueOrNull(rs.getDouble("tipo_cambio"), rs));
		cg.setImporte(getValueOrNull(rs.getDouble("importe"), rs));
		cg.setUserId(getValueOrNull(rs.getLong("usuario_id"), rs));
		cg.setObservaciones(rs.getString("observaciones"));

		return cg;
	}



	@Override
	protected String getDeleteConditions(CabeceraGasto filter) {

		List<String> fieldsDeleteConditions = new ArrayList<String>();

		// Valores de Condiciones/Filtro

		if (filter.getGastoId() != null) {
			fieldsDeleteConditions.add("gasto_id");
		}

//		if (filter.getGastoNro() != null) {
//			fieldsDeleteConditions.add("gastos_nro");
//		}
//
//		if (filter.getProyectoId() != null) {
//			fieldsDeleteConditions.add("proyecto_id");
//		}
//
//		if (filter.getSubProyectoId() != null) {
//			fieldsDeleteConditions.add("subproyecto_id");
//		}
//
//		if (isNotEmpty(filter.getTipoGasto())) {
//			fieldsDeleteConditions.add("tipo_gasto");
//		}
//
//		if (isNotEmpty(filter.getCiudad())) {
//			fieldsDeleteConditions.add("ciudad");
//		}
//
//		if (isNotEmpty(filter.getPais())) {
//			fieldsDeleteConditions.add("pais");
//		}
//
//		if (filter.getFechaGasto() != null) {
//			fieldsDeleteConditions.add("fecha_gasto");
//		}
//
//		if (isNotEmpty(filter.getProveedor())) {
//			fieldsDeleteConditions.add("proveedor");
//		}
//
//		if (filter.getTipoCambio() != null) {
//			fieldsDeleteConditions.add("tipo_cambio");
//		}
//
//		if (filter.getImporte() != null) {
//			fieldsDeleteConditions.add("importe");
//		}
//
//		if (filter.getUserId() != null) {
//			fieldsDeleteConditions.add("usuario_id");
//		}
//
//		if (isNotEmpty(filter.getObservaciones())) {
//			fieldsDeleteConditions.add("observaciones");
//		}

		return appendFields(fieldsDeleteConditions);
	}

	@Override
	protected void fillDeleteParameters(CabeceraGasto filter, PreparedStatement ps, DatabaseConnection db)
			throws Exception {

		int sequenceNumber = 0;

		// Valores de Condiciones/Filtro

		if (filter.getGastoId() != null) {
			sequenceNumber++;
			ps.setLong(sequenceNumber, filter.getGastoId());
		}

//		if (filter.getGastoNro() != null) {
//			sequenceNumber++;
//			ps.setLong(sequenceNumber, filter.getGastoNro());
//		}
//
//		if (filter.getProyectoId() != null) {
//			sequenceNumber++;
//			ps.setLong(sequenceNumber, filter.getProyectoId());
//		}
//
//		if (filter.getSubProyectoId() != null) {
//			sequenceNumber++;
//			ps.setLong(sequenceNumber, filter.getSubProyectoId());
//		}
//
//		if (isNotEmpty(filter.getTipoGasto())) {
//			sequenceNumber++;
//			ps.setString(sequenceNumber, filter.getTipoGasto());
//		}
//
//		if (isNotEmpty(filter.getCiudad())) {
//			sequenceNumber++;
//			ps.setString(sequenceNumber, filter.getCiudad());
//		}
//
//		if (isNotEmpty(filter.getPais())) {
//			sequenceNumber++;
//			ps.setString(sequenceNumber, filter.getPais());
//		}
//
//		if (filter.getFechaGasto() != null) {
//			sequenceNumber++;
//			ps.setDate(sequenceNumber, new java.sql.Date(filter.getFechaGasto().getTime()));
//		}
//
//		if (isNotEmpty(filter.getProveedor())) {
//			sequenceNumber++;
//			ps.setString(sequenceNumber, filter.getProveedor());
//		}
//
//		if (filter.getTipoCambio() != null) {
//			sequenceNumber++;
//			ps.setDouble(sequenceNumber, filter.getTipoCambio());
//		}
//
//		if (filter.getImporte() != null) {
//			sequenceNumber++;
//			ps.setDouble(sequenceNumber, filter.getImporte());
//		}
//
//		if (filter.getUserId() != null) {
//			sequenceNumber++;
//			ps.setLong(sequenceNumber, filter.getUserId());
//		}
//
//		if (isNotEmpty(filter.getObservaciones())) {
//			sequenceNumber++;
//			ps.setString(sequenceNumber, filter.getObservaciones());
//		}

	}

}
