package com.anibal.educational.rest_service.comps.service.impl;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anibal.educational.rest_service.comps.dao.CabeceraGastoDao;
import com.anibal.educational.rest_service.comps.dao.DetalleGastoDao;
import com.anibal.educational.rest_service.comps.service.CabeceraGastoService;
import com.anibal.educational.rest_service.comps.service.DetalleGastoService;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.config.ConfigConstants;
import com.odhoman.api.utilities.db.DatabaseConnection;
import com.odhoman.api.utilities.transac.ApplicationErrorException;
@Configuration
public class AppConfigTest {

	@Bean
	public AbstractConfig getAbstractConfig(){
		return new TstConfig();
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
				dbc.setConfigure(new TstConfig());
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
				dbc.setConfigure(new TstConfig());
			} catch (Exception e) {
				throw new ApplicationErrorException("No se pudo configurar el DBC de prueba");
			}
			return dbc;
		}
	}
	
	public class TstConfig extends AbstractConfig {

		private static final long serialVersionUID = -5409595243763576499L;

		public TstConfig() {
			setProperty(ConfigConstants.APP_DB_CONNECTION_TYPE, "simple");
			setProperty(ConfigConstants.COMMON_DB_DATASOURCE, "");
			setProperty(ConfigConstants.COMMON_DB_DRIVER, "oracle.jdbc.OracleDriver");
			setProperty(ConfigConstants.COMMON_DB_URL,
					"jdbc:oracle:thin:@ystad.cy0u7vgbjqzt.us-west-2.rds.amazonaws.com:1521:ystadesa");
			setProperty(ConfigConstants.COMMON_DB_USER, "wallander");
			setProperty(ConfigConstants.COMMON_DB_PASSWORD, "Wallander2016");

			setProperty(ConfigConstants.LOG4J_CONFIG_PATH, "log4j-test.properties");
			setLogger(getLogger(ConfigConstants.LOG4J_CONFIG_PATH, "test"));
		}

		@Override
		protected void preloadClasses() {

		}

	}
	
}

