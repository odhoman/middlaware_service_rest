package com.anibal.educational.rest_service.comps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anibal.educational.rest_service.comps.util.RestServiceCostant;
import com.anibal.educational.rest_service.comps.util.RestServiceUtil;
import com.anibal.educational.rest_service.domain.Libro;
import com.anibal.educational.rest_service.domain.LibroFilter;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.db.DatabaseConnection;

@Component
public class LibroDao extends AbstractAbmDAO<Libro, LibroFilter>{
	
	public LibroDao() {
		super();
	}

	public LibroDao(AbstractConfig config) {
		super(config);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected DatabaseConnection getDatabaseConnection() {
		return RestServiceUtil.getDbConnectionMgr().getDatabaseConnection(RestServiceCostant.REST_SERVICE_DB_DATASOURCE_NAME);
	}

	@Override
	protected String getMainTableName() {
		// TODO Auto-generated method stub
		return "AC_CLIENTES";
	}

	@Override
	protected List<String> getInsertFields(Libro item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void fillInsertParameters(Libro item, PreparedStatement ps,
			DatabaseConnection db) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List<String> getUpdateFields(Libro item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getUpdateConditions(LibroFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void fillUpdateParameters(LibroFilter filter, Libro item,
			PreparedStatement ps, DatabaseConnection db) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List<String> getSelectFields() {
		List<String> fields = new ArrayList<String>();
		fields.add("CLI.NOMBRE");
		fields.add("CLI.CODIGO");
		
		
		
		
		return fields;
	}

	@Override
	protected List<String> getSelectTables() {
		// TODO Auto-generated method stub
		return Arrays.asList("AC_CLIENTES CLI");
	}

	@Override
	protected String getSelectConditions(LibroFilter filter) {
		
		StringBuffer selectConditions = new StringBuffer();
		int sequenceNumber = 0;
		
		if(filter.getAutor()!=null){
			if(sequenceNumber > 0) 
				selectConditions.append(" AND ");
			
			selectConditions.append(" NOMBRE = ? ");
		}
		
		return selectConditions.toString();
	}

	@Override
	protected void fillSelectParameters(LibroFilter filter,
			PreparedStatement ps, DatabaseConnection db) throws Exception {
		
		int sequenceNumber = 0;
		
		if(filter.getAutor()!=null){
			sequenceNumber++;
			ps.setString(sequenceNumber, filter.getAutor());
		}
		
	}

	@Override
	protected Libro loadItem(ResultSet rs) throws Exception {

		Libro libro = new Libro();
		
		libro.setId((rs.getLong("CODIGO")));
		libro.setAutor(rs.getString("NOMBRE"));
		
		return libro;
	}

	@Override
	protected String getDeleteConditions(LibroFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void fillDeleteParameters(LibroFilter filter,
			PreparedStatement ps, DatabaseConnection db) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
