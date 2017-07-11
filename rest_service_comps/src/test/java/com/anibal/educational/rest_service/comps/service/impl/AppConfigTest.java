package com.anibal.educational.rest_service.comps.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anibal.educational.rest_service.comps.dao.CabeceraGastoDao;
import com.anibal.educational.rest_service.comps.dao.DetalleGastoDao;
import com.anibal.educational.rest_service.comps.dao.TicketDistributionDao;
import com.anibal.educational.rest_service.comps.dao.TicketHeaderDao;
import com.anibal.educational.rest_service.comps.dao.TicketLineDao;
import com.anibal.educational.rest_service.comps.dao.TicketLineStateDao;
import com.anibal.educational.rest_service.comps.dao.TicketUserDao;
import com.anibal.educational.rest_service.comps.dao.file_managing.AbstractFileManagingDao;
import com.anibal.educational.rest_service.comps.dao.file_managing.impl.FileSystemFileManagingDao;
import com.anibal.educational.rest_service.comps.service.CabeceraGastoService;
import com.anibal.educational.rest_service.comps.service.DetalleGastoService;
import com.anibal.educational.rest_service.comps.service.FileManagingService;
import com.anibal.educational.rest_service.comps.service.TicketLineService;
import com.anibal.educational.rest_service.comps.service.TicketLineServiceException;
import com.anibal.educational.rest_service.comps.service.TicketOCRService;
import com.anibal.educational.rest_service.comps.service.TicketPushNotificationService;
import com.anibal.educational.rest_service.domain.TicketLine;
import com.anibal.educational.rest_service.domain.TicketLineState;
import com.anibal.educational.rest_service.domain.ocr.push.request.Data;
import com.anibal.educational.rest_service.domain.ocr.push.request.PushOCRNotificationRequest;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.config.ConfigConstants;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.dao.DAOException;
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
	public TicketUserDao getUserDao(){
		return new UserDaoTestImpl(getAbstractConfig());
	}
	
	@Bean
	public TicketHeaderDao getTicketHeaderDao(){
		return new TicketHeaderDaoTestImp(getAbstractConfig());
	}
	
	@Bean
	public TicketDistributionDao getTicketDistributionDao(){
		return new TicketDistributionDaoImpl(getAbstractConfig());
	}
	
	@Bean
	public TicketLineDao getTicketLineDao(){
		return new TicketLineDaoImpl(getAbstractConfig());
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
	public TicketLineStateDao getTicketLineStateDao(){
		return new TicketLineStateDaoImpl(getAbstractConfig());
	}
	
	@Bean
	public TicketOCRService getTicketOCRService(){
		return new TicketOCRServiceImpl(getAbstractConfig());
	}
	
	@Bean
	public TicketPushNotificationService getTicketPushNotificationService(){
		return new TicketPushNotificationServiceTestImpl(getAbstractConfig());
	}
	
	@Bean 
	public FileManagingService getFileManagingService(){
		return new FileManagingServiceImpl(getAbstractFileManagingDao(),getAbstractConfig());
	}
	
	@Bean
	public AbstractFileManagingDao getAbstractFileManagingDao(){
		return new FileSystemFileManagingDao(getAbstractConfig());
	}
	
	@Bean
	public TicketLineService getTicketLineService(){
		return new TicketLineServiceImplTest(getTicketLineDao(), getTicketOCRService(), getFileManagingService(), getTicketPushNotificationService(), getAbstractConfig());
	}
	 
	public class TicketPushNotificationServiceTestImpl extends TicketPushNotificationServiceImpl{
		
		public TicketPushNotificationServiceTestImpl() {
			super();
		}

		public TicketPushNotificationServiceTestImpl(AbstractConfig config) {
			super(config);
		}
		
		protected PushOCRNotificationRequest getPushOCRNotificationRequest(TicketLine line){
			
			PushOCRNotificationRequest request = new PushOCRNotificationRequest();
			request.setTo("/topics/user-"+line.getUserId());
			Data data = new Data();
			data.setTitle("Ticket Procesado");
			data.setBody("Tu ticket fue procesado");
			data.setLineId(""+line.getLineId());
			request.setData(data);
			
			return request;
		}

	}
	
	public class TicketLineServiceImplTest extends TicketLineServiceImpl{

		public TicketLineServiceImplTest(AbstractAbmDAO<TicketLine, TicketLine> dao, TicketOCRService service, FileManagingService fileManagingService, TicketPushNotificationService notificationServic) {
			super(dao, service, fileManagingService,notificationServic);
		}
		
		public TicketLineServiceImplTest(AbstractAbmDAO<TicketLine, TicketLine> dao, TicketOCRService service, FileManagingService fileManagingService, TicketPushNotificationService notificationServic, AbstractConfig config) {
			super(dao, service, fileManagingService, notificationServic,config);
		}
		
		protected TicketLineState getTicketLineStateInProcess(){
			TicketLineState tls = new TicketLineState();
			
			tls.setLineStateId(2L);
			return tls;
		} 
		
		protected TicketLineState getTicketLineStateNotNotified(){
			TicketLineState tls = new TicketLineState();
			
			tls.setLineStateId(5L);
			return tls;
		} 
		
		protected TicketLineState getTicketLineStateProcessed(){
			TicketLineState tls = new TicketLineState();
			
			tls.setLineStateId(3L);
			return tls;
		} 
		
		protected TicketLineState getTicketLineStatePending(){
			TicketLineState tls = new TicketLineState();
			
			tls.setLineStateId(1L);
			return tls;
		} 
		
		protected TicketLineState getTicketLineStateNotifing(){
			TicketLineState tls = new TicketLineState();
			
			tls.setLineStateId(6L);
			return tls;
		} 
		
		protected TicketLineState getTicketLineStateNotified(){
			TicketLineState tls = new TicketLineState();
			
			tls.setLineStateId(4L);
			return tls;
		} 
		
		protected AnsychronousLineProcessor getAnsychronousLineProcessor(TicketLineService service, Logger logger, TicketLine line){
			return new AnsychronousLineProcessorTest(service, logger, line);
		}
		
		protected void startThread(AnsychronousLineProcessor thread) throws Exception{
			thread.start();
			getLogger().debug("Thread de la line "+thread.getLine().getLineId()+" iniciado");
			thread.join();
		}
		
		public void processAllLabelDesc() throws TicketLineServiceException{
			
			List<TicketLine> lineNP = getLinesNotProcessed();
			
			//Se actualiza las lines a estado in process
			//Se pone la line en estado in process
			TicketLine lineInProcess = new TicketLine();
			lineInProcess.setLineStateId(getTicketLineStateInProcess().getLineStateId());
			
			try {
				getTicketLineDao().changeItems(lineNP, lineInProcess);
			} catch (DAOException e1) {
				logger.error("No se pudieron actualizar las lines a in process antes de enviar a procesarlas",e1);
				throw new TicketLineServiceException(e1);
			}
			
			for(int i = 0; i<lineNP.size(); i++){
				
				TicketLine line = lineNP.get(i);
				
				try {
					startThread(getAnsychronousLineProcessor(this,logger,line), true);
				} catch (Exception e) {
					throw new TicketLineServiceException(e);
				}
			}
			
		}
		
	}
	
	public class AnsychronousLineProcessorTest extends AnsychronousLineProcessor{
		
		public AnsychronousLineProcessorTest(TicketLineService service, Logger logger, TicketLine line) {
			super(service, logger, line);
		}

		protected TicketLineState getTicketLineStatePending(){
			TicketLineState tls = new TicketLineState();
			
			tls.setLineStateId(1L);
			return tls;
		} 
		
		protected TicketLineState getTicketLineStateNotNotified(){
			TicketLineState tls = new TicketLineState();
			
			tls.setLineStateId(5L);
			return tls;
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
	
	public class UserDaoTestImpl extends TicketUserDao{
		
		public UserDaoTestImpl() {
			super();
		}

		public UserDaoTestImpl(AbstractConfig config) {
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
	
	public class TicketHeaderDaoTestImp extends TicketHeaderDao{
		
		public TicketHeaderDaoTestImp() {
			super();
		}

		public TicketHeaderDaoTestImp(AbstractConfig config) {
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
	
	public class TicketLineDaoImpl extends TicketLineDao{
		
		public TicketLineDaoImpl() {
			super();
		}

		public TicketLineDaoImpl(AbstractConfig config) {
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
	
	public class TicketDistributionDaoImpl extends TicketDistributionDao{
		
		public TicketDistributionDaoImpl() {
			super();
		}

		public TicketDistributionDaoImpl(AbstractConfig config) {
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
	
	public class TicketLineStateDaoImpl extends TicketLineStateDao{
		
		public TicketLineStateDaoImpl() {
			super();
		}

		public TicketLineStateDaoImpl(AbstractConfig config) {
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
	
			setProperty("app.ocr.default.service", "TEXT_DETECTION");
			setProperty("app.ocr.default.url", "https://vision.googleapis.com/v1/images:annotate");
			setProperty("app.ocr.default.key", "AIzaSyBwgcUR268DnLjq4_oW6iq8ARWFP9hwenc");
			setProperty("app.ocr.default.key", "AIzaSyBwgcUR268DnLjq4_oW6iq8ARWFP9hwenc");
			
			setProperty("app.ocr.push.notification.autorization_key", "Authorization");
			setProperty("app.file.system.line.folder.dir", "C:\\temp\\uploads\\lines\\");
			
			setProperty("app.ocr.push.notification.url", "https://fcm.googleapis.com/fcm/send");
			setProperty("app.ocr.push.notification.autorization", "key=AAAAwrEMTNA:APA91bGOrajDBa5Dv7yaogIIMxuBxTgBpvIN0it0N5xNOsB5KxMQteINFY6EThUIfEibbK6qRq7bb8Cdljn4qPbCwg0NoJmCPojngCNA7hTrMGUCaBR1xF7o7msrL4zLtqbb64F1Ixps");
			
			setProperty("app.ocr.push.notification.to" , "/topics/user-");
			setProperty("app.ocr.push.notification.title", "Ticket Procesado");
			setProperty("app.ocr.push.notification.body", "Su Ticket fue procesado");
			setProperty("app.ocr.push.notification.autorization_key", "Authorization");
			
		}

		@Override
		protected void preloadClasses() {

		}

	}
	
}

