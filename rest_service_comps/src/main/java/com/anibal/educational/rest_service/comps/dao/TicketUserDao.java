package com.anibal.educational.rest_service.comps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.anibal.educational.rest_service.comps.util.DbUtil;
import com.anibal.educational.rest_service.domain.TicketUser;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.db.DatabaseConnection;

/**
 *  
 * DAO de User
 *  
 * @author Jonatan Flores
 *
 */
public class TicketUserDao extends RestServiceAbstractAbmDAO<TicketUser, TicketUser>{
	
	public TicketUserDao() {
		super();
	}

	public TicketUserDao(AbstractConfig config) {
		super(config);
	}

	@Override
	protected String getMainTableName() {
		return "ac_tkt_user_all";
	}

	@Override
	protected List<String> getInsertFields(TicketUser item) {
		List<String> fields = new ArrayList<String>();
		fields.add("USER_ID");
		fields.add("USER_NAME");
		fields.add("USER_FIRST_NAME");
		fields.add("USER_LAST_NAME");
		fields.add("USER_EMAIL");
		fields.add("USER_PHONE_NUMBER");
		fields.add("HIRE_DATE_START");
		fields.add("HIRE_DATE_END");
		fields.add("STREET");
		fields.add("CITY");
		fields.add("STATE");
		fields.add("ZIPCODE");
		fields.add("COUNTRY");
		fields.add("EMPLOYEE_ID");
		fields.add("EMPLOYEE_DESC");
		fields.add("IMAGE_ID");
		fields.add("PATH_IMAGE_DESC");
		return fields;
	}

	@Override
	protected void fillInsertParameters(TicketUser item, PreparedStatement ps, DatabaseConnection db) throws Exception {
		if (item.getUserId() == null) {
			item.setUserId(DbUtil.getNewSequenceKey(db, "ac_tkt_user_gs_sq"));
		}
		
		List<Object> fields = new ArrayList<Object>();
		fields.add(item.getUserId());
		fields.add(item.getUserName());
		fields.add(item.getUserFirstame());
		fields.add(item.getUserLastName());
		fields.add(item.getUserEmail());
		fields.add(item.getUserPhoneNumber());
		fields.add(item.getHireDateStart());
		fields.add(item.getHireDateEnd());
		fields.add(item.getStreet());
		fields.add(item.getCity());
		fields.add(item.getState());
		fields.add(item.getZipCode());
		fields.add(item.getCountry());
		fields.add(item.getEmployeeId());
		fields.add(item.getEmployeeDesc());
		fields.add(item.getImageId());
		fields.add(item.getPathImage());

		fillListParameter(1, fields, ps);
		
		
	}

	@Override
	protected List<String> getUpdateFields(TicketUser item) {
		
		List<String> fields = new ArrayList<String>();
		
		fields.add("USER_NAME");
		fields.add("USER_FIRST_NAME");
		fields.add("USER_LAST_NAME");
		fields.add("USER_EMAIL");
		fields.add("USER_PHONE_NUMBER");
		fields.add("HIRE_DATE_START");
		fields.add("HIRE_DATE_END");
		fields.add("STREET");
		fields.add("CITY");
		fields.add("STATE");
		fields.add("ZIPCODE");
		fields.add("COUNTRY");
		fields.add("EMPLOYEE_ID");
		fields.add("EMPLOYEE_DESC");
		fields.add("IMAGE_ID");
		fields.add("PATH_IMAGE_DESC");
		
		return fields;
	}

	@Override
	protected String getUpdateConditions(TicketUser filter) {
		List<String> fields = new ArrayList<String>();

		fields.add("USER_ID");

		return appendFields(fields);
	}

	@Override
	protected void fillUpdateParameters(TicketUser filter, TicketUser item, PreparedStatement ps, DatabaseConnection db)
			throws Exception {
		
		List<Object> fields = new ArrayList<Object>();

		// Valores a impactar
		fields.add(item.getUserName());
		fields.add(item.getUserFirstame());
		fields.add(item.getUserLastName());
		fields.add(item.getUserEmail());
		fields.add(item.getUserPhoneNumber());
		fields.add(item.getHireDateStart());
		fields.add(item.getHireDateEnd());
		fields.add(item.getStreet());
		fields.add(item.getCity());
		fields.add(item.getState());
		fields.add(item.getZipCode());
		fields.add(item.getCountry());
		fields.add(item.getEmployeeId());
		fields.add(item.getEmployeeDesc());
		fields.add(item.getImageId());
		fields.add(item.getPathImage());

		// Valores de Condiciones/Filtro
		fields.add(filter.getUserId());
		
		fillListParameter(1, fields, ps);
		
	}

	@Override
	protected List<String> getSelectFields() {
		List<String> fields = new ArrayList<String>();
		fields.add("USER_ID");
		fields.add("USER_NAME");
		fields.add("USER_FIRST_NAME");
		fields.add("USER_LAST_NAME");
		fields.add("USER_EMAIL");
		fields.add("USER_PHONE_NUMBER");
		fields.add("HIRE_DATE_START");
		fields.add("HIRE_DATE_END");
		fields.add("STREET");
		fields.add("CITY");
		fields.add("STATE");
		fields.add("ZIPCODE");
		fields.add("COUNTRY");
		fields.add("EMPLOYEE_ID");
		fields.add("EMPLOYEE_DESC");
		fields.add("IMAGE_ID");
		fields.add("PATH_IMAGE_DESC");
		return fields;
	}

	@Override
	protected List<String> getSelectTables() {
		List<String> tables = new ArrayList<String>();

		tables.add("ac_tkt_user_all");

		return tables;
	}

	@Override
	protected String getSelectConditions(TicketUser filter) {
		List<String> fieldsSelectConditions = new ArrayList<String>();
		
		// Valores de Condiciones/Filtro
		
		if (filter.getUserId() != null) {
			fieldsSelectConditions.add("USER_ID");
		}

		if (isNotEmpty(filter.getUserName())) {
			fieldsSelectConditions.add("USER_NAME");
		}
		
		if (isNotEmpty(filter.getUserFirstame())) {
			fieldsSelectConditions.add("USER_FIRST_NAME");
		}
		
		if (isNotEmpty(filter.getUserLastName())) {
			fieldsSelectConditions.add("USER_LAST_NAME");
		}
		
		if (isNotEmpty(filter.getUserEmail())) {
			fieldsSelectConditions.add("USER_EMAIL");
		}
		
		if (isNotEmpty(filter.getUserPhoneNumber())) {
			fieldsSelectConditions.add("USER_PHONE_NUMBER");
		}
		
		if (isNotNull(filter.getHireDateStart())) {
			fieldsSelectConditions.add("HIRE_DATE_START");
		}
		
		if (isNotNull(filter.getHireDateEnd())) {
			fieldsSelectConditions.add("HIRE_DATE_END");
		}
		
		if (isNotEmpty(filter.getStreet())) {
			fieldsSelectConditions.add("STREET");
		}
		
		
		if (isNotEmpty(filter.getCity())) {
			fieldsSelectConditions.add("CITY");
		}	
		
		if (isNotEmpty(filter.getState())) {
			fieldsSelectConditions.add("STATE");
		}
		
		if (isNotEmpty(filter.getZipCode())) {
			fieldsSelectConditions.add("ZIPCODE");
		}	
		
		if (isNotEmpty(filter.getCountry())) {
			fieldsSelectConditions.add("COUNTRY");
		}	
		
		if (isNotNull(filter.getEmployeeId())) {
			fieldsSelectConditions.add("EMPLOYEE_ID");
		}	
		
		if (isNotEmpty(filter.getEmployeeDesc())) {
			fieldsSelectConditions.add("EMPLOYEE_DESC");
		}	
		
		if (isNotNull(filter.getImageId())) {
			fieldsSelectConditions.add("IMAGE_ID");
		}	
		
		if (isNotEmpty(filter.getPathImage())) {
			fieldsSelectConditions.add("PATH_IMAGE_DESC");
		}
		
		return appendFields(fieldsSelectConditions);
	}

	@Override
	protected void fillSelectParameters(TicketUser filter, PreparedStatement ps, DatabaseConnection db) throws Exception {
		
		int sequenceNumber = 0;
		List<Object> lista = new ArrayList<Object>();
		
		sequenceNumber++;
		
		lista.add(filter.getUserId());
		lista.add(filter.getUserName());
		lista.add(filter.getUserFirstame());
		lista.add(filter.getUserLastName());
		lista.add(filter.getUserEmail());
		lista.add(filter.getUserPhoneNumber());
		lista.add(filter.getHireDateStart());
		lista.add(filter.getHireDateEnd());
		lista.add(filter.getStreet());
		lista.add(filter.getCity());
		lista.add(filter.getState());
		lista.add(filter.getZipCode());
		lista.add(filter.getCountry());
		lista.add(filter.getEmployeeId());
		lista.add(filter.getEmployeeDesc());
		lista.add(filter.getImageId());
		lista.add(filter.getPathImage());
		
		fillSelectListParameter(sequenceNumber, lista, ps);
		
	}

	@Override
	protected TicketUser loadItem(ResultSet rs) throws Exception {
		
		TicketUser u = new TicketUser();
		
		u.setUserId(getValueOrNull(rs.getLong("USER_ID"),rs));
		u.setUserName(rs.getString("USER_NAME"));
		u.setUserFirstame(rs.getString("USER_FIRST_NAME"));
		u.setUserLastName(rs.getString("USER_LAST_NAME"));
		u.setUserEmail(rs.getString("USER_EMAIL"));
		u.setUserPhoneNumber(rs.getString("USER_PHONE_NUMBER"));
		u.setHireDateStart(getValueOrNull(rs.getDate("HIRE_DATE_START"),rs));
		u.setHireDateEnd(getValueOrNull(rs.getDate("HIRE_DATE_END"),rs));
		u.setStreet(rs.getString("STREET"));
		u.setCity(rs.getString("CITY"));
		u.setState(rs.getString("STATE"));
		u.setZipCode(rs.getString("ZIPCODE"));
		u.setCountry(rs.getString("COUNTRY"));
		u.setEmployeeId(getValueOrNull(rs.getLong("EMPLOYEE_ID"),rs));
		u.setEmployeeDesc(rs.getString("EMPLOYEE_DESC"));
		u.setImageId(getValueOrNull(rs.getLong("IMAGE_ID"),rs));
		u.setPathImage(rs.getString("PATH_IMAGE_DESC"));
		
		return u;
	}

	@Override
	protected String getDeleteConditions(TicketUser filter) {
		List<String> fields = new ArrayList<String>();

		fields.add("USER_ID");

		return appendFields(fields);
	}

	@Override
	protected void fillDeleteParameters(TicketUser filter, PreparedStatement ps, DatabaseConnection db) throws Exception {
		
		int sequenceNumber = 0;
		List<Object> lista = new ArrayList<Object>();
		
		sequenceNumber++;

		// Valores de Condiciones/Filtro
		lista.add(filter.getUserId());
		
		fillListParameter(sequenceNumber, lista, ps);
		
	}
	

}
