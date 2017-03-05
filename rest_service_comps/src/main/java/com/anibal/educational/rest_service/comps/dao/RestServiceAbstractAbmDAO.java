package com.anibal.educational.rest_service.comps.dao;

import com.anibal.educational.rest_service.comps.util.RestServiceCostant;
import com.anibal.educational.rest_service.comps.util.RestServiceUtil;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;
import com.odhoman.api.utilities.db.DatabaseConnection;

/**
 * Dao abastracto para esta aplicación
 * 
 * @author Jonatan
 *
 */
public abstract class RestServiceAbstractAbmDAO<F,T> extends AbstractAbmDAO<F,T>{
	
	public RestServiceAbstractAbmDAO() {
		super();
	}

	public RestServiceAbstractAbmDAO(AbstractConfig config) {
		super(config);
	}
	
	@Override
	protected DatabaseConnection getDatabaseConnection() {
		return RestServiceUtil.getDbConnectionMgr().getDatabaseConnection(RestServiceCostant.REST_SERVICE_DB_DATASOURCE_NAME);
	}

}
