package com.anibal.educational.rest_service.comps.config;

import com.odhoman.api.utilities.config.AppConfig;

/**
 * Configurador General de la aplicacion
 * 
 * @author Jonatan Flores
 *
 */
public class RestServiceConfig extends AppConfig {

	/**
	 * Autogenerated UID
	 */
	private static final long serialVersionUID = 1684706179604287726L;

	/**
	 * Instancia singleton
	 */
	private static RestServiceConfig actConfig = null;

	/**
	 * Constructor privado para forzar singleton;
	 */
	protected RestServiceConfig() {
	}

	/**
	 * @see AppConfig#getInstance()
	 */
	public static RestServiceConfig getInstance() {
		if (actConfig == null) {
			synchronized (RestServiceConfig.class) {
				actConfig = new RestServiceConfig();
			}
		}
		return actConfig;
	}
	
	
}