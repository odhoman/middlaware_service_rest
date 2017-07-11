package com.anibal.educational.rest_service.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.anibal.educational.rest_service.comps.cache.LineStateCacheManager;
import com.anibal.educational.rest_service.comps.dao.TicketLineStateDao;
import com.anibal.educational.rest_service.comps.util.RestServiceUtil;
import com.anibal.educational.rest_service.domain.TicketLineState;

@WebListener
public class CacheServletInitializer implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
    	
    	try {
			LineStateCacheManager.getInstance()
					.load(new TicketLineStateDao(RestServiceUtil.getConfig()).getItems(new TicketLineState()));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void contextDestroyed(ServletContextEvent event) {
        // Webapp shutdown.
    }
}
