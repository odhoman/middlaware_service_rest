package com.anibal.educational.rest_service.test.controllers;

import com.anibal.educational.rest_service.comps.dao.LibroDao;
import com.anibal.educational.rest_service.comps.service.impl.ServiceRestDataImpl;
import com.anibal.educational.rest_service.domain.Libro;
import com.anibal.educational.rest_service.domain.LibroFilter;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.db.DatabaseConnection;
import com.odhoman.api.utilities.transac.ApplicationErrorException;

public class ServiceRestDataWebImplTest extends ServiceRestDataImpl {
	
	public ServiceRestDataWebImplTest() {
		super();
	}

	public ServiceRestDataWebImplTest(AbstractConfig config) {
		super(config);
	}

	
	protected AbstractAbmDAO<Libro, LibroFilter> getDao(){
		return new LibroDaoTest(config);
	}
	
	public class LibroDaoTest extends LibroDao{
		
		public LibroDaoTest() {
			super();
		}

		public LibroDaoTest(AbstractConfig config) {
			super(config);
		}

		@Override
		protected DatabaseConnection getDatabaseConnection() {
			DatabaseConnection dbc = new DatabaseConnection();
			try {
				dbc.setConfigure(new TstWebConfig());
			} catch (Exception e) {
				throw new ApplicationErrorException("No se pudo configurar el DBC de prueba");
			}
			return dbc;
		}
		
	}
	
	
	
	
	
}
