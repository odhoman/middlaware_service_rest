package com.anibal.educational.rest_service.comps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.anibal.educational.rest_service.comps.util.DbUtil;
import com.anibal.educational.rest_service.domain.TicketDistribution;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.db.DatabaseConnection;

public class TicketDistributionDao extends RestServiceAbstractAbmDAO<TicketDistribution, TicketDistribution> {

	public TicketDistributionDao(AbstractConfig config) {
		super(config);
	}

	public TicketDistributionDao() {
		super();
	}

	@Override
	protected String getMainTableName() {
		return "AC_TKT_DISTRIBUTIONS_ALL";
	}

	@Override
	protected List<String> getInsertFields(TicketDistribution item) {
		
		List<String> fields = new ArrayList<String>();
		fields.add("DIST_ID");
		fields.add("LINE_ID");
		fields.add("TICKET_ID");
		fields.add("TIPO_GASTO");
		fields.add("LINE_DESC");
		fields.add("GASTOS_FECHA");
		fields.add("CANTIDAD");
		fields.add("CBU_DESC");
		fields.add("IMPORTE");
		fields.add("MONEDA");
		fields.add("MONEDA_FUNCIONAL");
		fields.add("USER_ID");
		fields.add("CREACION_FECHA");
		fields.add("LINE_NRO");
		
		return fields;
	}

	@Override
	protected void fillInsertParameters(TicketDistribution item, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		
		if (item.getTicketId() == null) {
			item.setDistId(DbUtil.getNewSequenceKey(db, "AC_TKT_DISTRIBUTIONS_GS_SQ"));
		}

		List<Object> fields = new ArrayList<Object>();
		fields.add(item.getDistId());
		fields.add(item.getLineId());
		fields.add(item.getTicketId());
		fields.add(item.getTipoGasto());
		fields.add(item.getLineDesc());
		fields.add(item.getGastosFecha());
		fields.add(item.getCantidad());
		fields.add(item.getCbuDesc());
		fields.add(item.getImporte());
		fields.add(item.getMoneda());
		fields.add(item.getMonedaFuncional());
		fields.add(item.getUserId());
		fields.add(item.getCreacionFecha());
		fields.add(item.getLineNro());
		
		fillInsertSelectListParameter(1, fields, ps);
		
	}

	@Override
	protected List<String> getUpdateFields(TicketDistribution item) {
		
		List<String> fields = new ArrayList<String>();
		
		if(item.getLineId()!=null){
			fields.add("LINE_ID");
		}
		
		if(item.getTicketId()!=null){
			fields.add("TICKET_ID");
		}
		
		if(isNotEmpty(item.getTipoGasto())){
			fields.add("TIPO_GASTO");
		}
		
		if(isNotEmpty(item.getLineDesc())){
			fields.add("LINE_DESC");
		}
		
		if(item.getGastosFecha()!=null){
			fields.add("GASTOS_FECHA");
		}
		
		if(item.getCantidad()!=null){
			fields.add("CANTIDAD");
		}
		
		if(isNotEmpty(item.getCbuDesc())){
			fields.add("CBU_DESC");
		}
		
		if(item.getImporte()!=null){
			fields.add("IMPORTE");
		}
		
		if(isNotEmpty(item.getMoneda())){
			fields.add("MONEDA");
		}
		
		if(isNotEmpty(item.getMonedaFuncional())){
			fields.add("MONEDA_FUNCIONAL");
		}
		
		if(item.getUserId()!=null){
			fields.add("USER_ID");
		}
		
		if(item.getCreacionFecha()!=null){
			fields.add("CREACION_FECHA");
		}
		
		if(item.getLineNro()!=null){
			fields.add("LINE_NRO");
		}
		
		return fields;
	}

	@Override
	protected String getUpdateConditions(TicketDistribution filter) {
		List<String> fields = new ArrayList<String>();

		fields.add("DIST_ID");

		return appendFields(fields);
	}

	@Override
	protected void fillUpdateParameters(TicketDistribution filter, TicketDistribution item, PreparedStatement ps,
			DatabaseConnection db) throws Exception {
		
		List<Object> fields = new ArrayList<Object>();
		
		// Valores a impactar
		fields.add(item.getLineId());
		fields.add(item.getTicketId());
		fields.add(item.getTipoGasto());
		fields.add(item.getLineDesc());
		fields.add(item.getGastosFecha());
		fields.add(item.getCantidad());
		fields.add(item.getCbuDesc());
		fields.add(item.getImporte());
		fields.add(item.getMoneda());
		fields.add(item.getMonedaFuncional());
		fields.add(item.getUserId());
		fields.add(item.getCreacionFecha());
		fields.add(item.getLineNro());
		
		// Valores de Condiciones/Filtro
		fields.add(filter.getDistId());
		
		fillUpdateListParameter(1, fields, ps);
	}

	@Override
	protected List<String> getSelectFields() {
		
		List<String> fields = new ArrayList<String>();
		fields.add("DIST_ID");
		fields.add("LINE_ID");
		fields.add("TICKET_ID");
		fields.add("TIPO_GASTO");
		fields.add("LINE_DESC");
		fields.add("GASTOS_FECHA");
		fields.add("CANTIDAD");
		fields.add("CBU_DESC");
		fields.add("IMPORTE");
		fields.add("MONEDA");
		fields.add("MONEDA_FUNCIONAL");
		fields.add("USER_ID");
		fields.add("CREACION_FECHA");
		fields.add("LINE_NRO");
		
		return fields;
	}

	@Override
	protected List<String> getSelectTables() {
		return Arrays.asList("AC_TKT_DISTRIBUTIONS_ALL");
	}

	@Override
	protected String getSelectConditions(TicketDistribution filter) {
		List<String> fields = new ArrayList<String>();
		
		if(filter.getDistId()!=null){
			fields.add("DIST_ID");
		}
		
		if(filter.getLineId()!=null){
			fields.add("LINE_ID");
		}
		
		if(filter.getTicketId()!=null){
			fields.add("TICKET_ID");
		}
		
		if(isNotEmpty(filter.getTipoGasto())){
			fields.add("TIPO_GASTO");
		}
		
		if(isNotEmpty(filter.getLineDesc())){
			fields.add("LINE_DESC");
		}
		
		if(filter.getGastosFecha()!=null){
			fields.add("GASTOS_FECHA");
		}
		
		if(filter.getCantidad()!=null){
			fields.add("CANTIDAD");
		}
		
		if(isNotEmpty(filter.getCbuDesc())){
			fields.add("CBU_DESC");
		}
		
		if(filter.getImporte()!=null){
			fields.add("IMPORTE");
		}
		
		if(isNotEmpty(filter.getMoneda())){
			fields.add("MONEDA");
		}
		
		if(isNotEmpty(filter.getMonedaFuncional())){
			fields.add("MONEDA_FUNCIONAL");
		}
		
		if(filter.getUserId()!=null){
			fields.add("USER_ID");
		}
		
		if(filter.getCreacionFecha()!=null){
			fields.add("CREACION_FECHA");
		}
		
		if(filter.getLineNro()!=null){
			fields.add("LINE_NRO");
		}
		
		return appendFields(fields);
	}

	@Override
	protected void fillSelectParameters(TicketDistribution filter, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		
		int sequenceNumber = 0;
		List<Object> fields = new ArrayList<Object>();

		sequenceNumber++;
		
		fields.add(filter.getDistId());
		fields.add(filter.getLineId());
		fields.add(filter.getTicketId());
		fields.add(filter.getTipoGasto());
		fields.add(filter.getLineDesc());
		fields.add(filter.getGastosFecha());
		fields.add(filter.getCantidad());
		fields.add(filter.getCbuDesc());
		fields.add(filter.getImporte());
		fields.add(filter.getMoneda());
		fields.add(filter.getMonedaFuncional());
		fields.add(filter.getUserId());
		fields.add(filter.getCreacionFecha());
		fields.add(filter.getLineNro());
		
		fillSelectListParameter(sequenceNumber, fields, ps);
		
	}
	
	@Override
	protected TicketDistribution loadItem(ResultSet rs) throws Exception {
		
		TicketDistribution td = new TicketDistribution();
		
		td.setDistId(getValueOrNull(rs.getLong("DIST_ID"),rs));
		td.setLineId(getValueOrNull(rs.getLong("LINE_ID"),rs));
		td.setTicketId(getValueOrNull(rs.getLong("TICKET_ID"),rs));
		td.setTipoGasto(rs.getString("TIPO_GASTO"));
		td.setLineDesc(rs.getString("LINE_DESC"));
		td.setGastosFecha(getValueOrNull(rs.getDate("GASTOS_FECHA"),rs));
		td.setCantidad(getValueOrNull(rs.getLong("CANTIDAD"),rs));
		td.setCbuDesc(rs.getString("CBU_DESC"));
		td.setImporte(getValueOrNull(rs.getDouble("IMPORTE"),rs));
		td.setMoneda(rs.getString("MONEDA"));
		td.setMonedaFuncional(rs.getString("MONEDA_FUNCIONAL"));
		td.setUserId(getValueOrNull(rs.getLong("USER_ID"),rs));
		td.setCreacionFecha(getValueOrNull(rs.getDate("CREACION_FECHA"),rs));
		td.setLineNro(getValueOrNull(rs.getLong("LINE_NRO"),rs));
		
		return td;
	}

	@Override
	protected String getDeleteConditions(TicketDistribution filter) {
		List<String> fields = new ArrayList<String>();

		fields.add("DIST_ID");

		return appendFields(fields);
	}

	@Override
	protected void fillDeleteParameters(TicketDistribution filter, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		int sequenceNumber = 0;
		List<Object> lista = new ArrayList<Object>();
		
		sequenceNumber++;

		// Valores de Condiciones/Filtro
		lista.add(filter.getDistId());
		
		fillInsertSelectListParameter(sequenceNumber, lista, ps);
		
	}



}
