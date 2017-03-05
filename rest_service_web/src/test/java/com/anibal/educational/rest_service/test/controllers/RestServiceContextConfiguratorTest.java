package com.anibal.educational.rest_service.test.controllers;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anibal.educational.rest_service.comps.dao.CabeceraGastoDao;
import com.anibal.educational.rest_service.comps.dao.DetalleGastoDao;
import com.anibal.educational.rest_service.comps.service.CabeceraGastoService;
import com.anibal.educational.rest_service.comps.service.DetalleGastoService;
import com.anibal.educational.rest_service.comps.service.ServiceRestData;
import com.anibal.educational.rest_service.comps.service.impl.CabeceraGastoServiceImpl;
import com.anibal.educational.rest_service.comps.service.impl.DetalleGastoServiceImpl;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.db.DatabaseConnection;
import com.odhoman.api.utilities.transac.ApplicationErrorException;

@Configuration
public class RestServiceContextConfiguratorTest {

	@Bean
	public ServiceRestData getServiceRestData(){
		return new ServiceRestDataWebImplTest(new TstWebConfig());
	}
	
	@Bean
	public AbstractConfig getAbstractConfig(){
		return new TstWebConfig();
	}
	
	@Bean
	public Logger getLogger(){
		return getAbstractConfig().getLogger();
	}
	
	
	@Bean
	public CabeceraGastoDao getCabeceraGastoDao(){
		return new CabeceraGastoDaoTestImpl(getAbstractConfig());
	}
	
	@Bean
	public DetalleGastoDao getDetalleGastoDao(){
		return new DetalleGastoDaoTestImpl(getAbstractConfig());
	}
	
	@Bean
	public CabeceraGastoService getCabeceraGastoService(){
		return new CabeceraGastoServiceImpl(getCabeceraGastoDao(),getDetalleGastoDao(),getAbstractConfig());
	}
	
	@Bean
	public DetalleGastoService getDetalleGastoService(){
		return new DetalleGastoServiceImpl(getDetalleGastoDao(),getAbstractConfig());
	}
	
	@Bean
	public DatabaseConnectionCreatorTest getDatabaseConnectionCreator(){
		return new DatabaseConnectionCreatorTest();
	}
	
	public class DatabaseConnectionCreatorTest {
		
		public DatabaseConnection getDatabaseConnection() {
			DatabaseConnection dbc = new DatabaseConnection();
			try {
				dbc.setConfigure(getAbstractConfig());
			} catch (Exception e) {
				throw new ApplicationErrorException("No se pudo configurar el DBC de prueba");
			}
			return dbc;
		}
		
	}
	
	public class CabeceraGastoDaoTestImpl extends CabeceraGastoDao {
		
		public CabeceraGastoDaoTestImpl() {
			super();
		}

		public CabeceraGastoDaoTestImpl(AbstractConfig config) {
			super(config);
		}
		
		@Override
		protected DatabaseConnection getDatabaseConnection() {
			DatabaseConnection dbc = new DatabaseConnection();
			try {
				dbc.setConfigure(getAbstractConfig());
			} catch (Exception e) {
				throw new ApplicationErrorException("No se pudo configurar el DBC de prueba");
			}
			return dbc;
		}
	}
	
	public class DetalleGastoDaoTestImpl extends DetalleGastoDao{
		
		
		public DetalleGastoDaoTestImpl() {
			super();
		}

		public DetalleGastoDaoTestImpl(AbstractConfig config) {
			super(config);
		}
		
		@Override
		protected DatabaseConnection getDatabaseConnection() {
			DatabaseConnection dbc = new DatabaseConnection();
			try {
				dbc.setConfigure(getAbstractConfig());
			} catch (Exception e) {
				throw new ApplicationErrorException("No se pudo configurar el DBC de prueba");
			}
			return dbc;
		}
	}
	
	
}

