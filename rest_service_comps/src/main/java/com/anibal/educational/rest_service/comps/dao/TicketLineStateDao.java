package com.anibal.educational.rest_service.comps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.anibal.educational.rest_service.domain.TicketLineState;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.db.DatabaseConnection;
import com.odhoman.api.utilities.transac.ApplicationErrorException;

public class TicketLineStateDao extends RestServiceAbstractAbmDAO<TicketLineState,TicketLineState>{
	
	public TicketLineStateDao() {
		super();
	}
	
	public TicketLineStateDao(AbstractConfig config) {
		super(config);
	}

	@Override
	protected String getMainTableName() {
		throw new ApplicationErrorException("Metodo no implementado");
	}

	@Override
	protected List<String> getInsertFields(TicketLineState item) {
		throw new ApplicationErrorException("Metodo no implementado");
	}

	@Override
	protected void fillInsertParameters(TicketLineState item, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		throw new ApplicationErrorException("Metodo no implementado");
		
	}

	@Override
	protected List<String> getUpdateFields(TicketLineState item) {
		throw new ApplicationErrorException("Metodo no implementado");
	}

	@Override
	protected String getUpdateConditions(TicketLineState filter) {
		throw new ApplicationErrorException("Metodo no implementado");
	}

	@Override
	protected void fillUpdateParameters(TicketLineState filter, TicketLineState item, PreparedStatement ps,
			DatabaseConnection db) throws Exception {
		throw new ApplicationErrorException("Metodo no implementado");
		
	}

	@Override
	protected List<String> getSelectFields() {
		return Arrays.asList("LINE_STATE_ID", "LINE_STATE_TITLE", "LINE_STATE_DESCRIPTION");
	}

	@Override
	protected List<String> getSelectTables() {
		return Arrays.asList("AC_TKT_LINE_STATE_ALL");
	}

	@Override
	protected String getSelectConditions(TicketLineState filter) {
		
		List<String> fieldsSelectConditions = new ArrayList<String>();
		
		if (filter.getLineStateId()!= null) {
			fieldsSelectConditions.add("LINE_STATE_ID");
		}
		
		if (filter.getLineStateTitle()!= null) {
			fieldsSelectConditions.add("LINE_STATE_TITLE");
		}
		
		if (filter.getLineStateTitle()!= null) {
			fieldsSelectConditions.add("LINE_STATE_DESCRIPTION");
		}
		
		return appendFields(fieldsSelectConditions);
	}

	@Override
	protected void fillSelectParameters(TicketLineState filter, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		
		int sequenceNumber = 0;
		List<Object> fields = new ArrayList<Object>();

		sequenceNumber++;
		
		fields.add(filter.getLineStateId());
		fields.add(filter.getLineStateTitle());
		fields.add(filter.getLineStateDescription());

		fillSelectListParameter(sequenceNumber, fields, ps);
		
	}

	@Override
	protected TicketLineState loadItem(ResultSet rs) throws Exception {
		TicketLineState tl = new TicketLineState();
		
		tl.setLineStateId(getValueOrNull(rs.getLong("LINE_STATE_ID"),rs));
		tl.setLineStateTitle(rs.getString("LINE_STATE_TITLE"));
		tl.setLineStateDescription(rs.getString("LINE_STATE_DESCRIPTION"));
		
		return tl;
	}

	@Override
	protected String getDeleteConditions(TicketLineState filter) {
		throw new ApplicationErrorException("Metodo no implementado");
	}

	@Override
	protected void fillDeleteParameters(TicketLineState filter, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		throw new ApplicationErrorException("Metodo no implementado");
	}
	

}
