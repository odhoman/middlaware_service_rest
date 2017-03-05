package com.anibal.educational.rest_service.comps.service.impl;

import java.util.List;

import com.anibal.educational.rest_service.comps.dao.LibroDao;
import com.anibal.educational.rest_service.comps.service.ServiceRestData;
import com.anibal.educational.rest_service.domain.Libro;
import com.anibal.educational.rest_service.domain.LibroFilter;
import com.anibal.educational.rest_service.domain.Message;
import com.odhoman.api.utilities.config.AbstractConfig;
import com.odhoman.api.utilities.dao.AbstractAbmDAO;

public class ServiceRestDataImpl extends AbstractService implements ServiceRestData{
	
	AbstractAbmDAO<Libro, LibroFilter> dao = null;
	
	public ServiceRestDataImpl() {
		super();
	}

	public ServiceRestDataImpl(AbstractConfig config) {
		super(config);
	}

	public List<Libro> getLibros() {
		
		logger.debug("Entrando... getLibros");
		
		List<Libro> libros = null;
		
		try {
			
			LibroFilter filtro = new LibroFilter();
			
			filtro.setAutor("anibal");
			
			libros = getDao().getItems(filtro);
			
			logger.error("Son "+libros.size()+" libros");
			
    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error al conectar ",e);
			e.printStackTrace();
		}
        
		logger.debug("Saliendo... getLibros");        
        
		return libros;

	}

	public Libro createLibro(Libro libro) {
		logger.debug("Entrando... createLibro");
		logger.debug("Saliendo... createLibro");
		return libro;
	}

	public Libro updateLibro(Long id, Libro libro) {
		logger.debug("Entrando... updateLibro");
		logger.debug("Saliendo... updateLibro");
		// TODO Auto-generated method stub
		return libro;
	}

	public Message deleteLibro(Long id) {
		logger.debug("Entrando... updateLibro");
		logger.debug("Saliendo... updateLibro");
		// TODO Auto-generated method stub
		return new Message(1, "Libro "+id+" Borrado");
	}
	
	protected AbstractAbmDAO<Libro, LibroFilter> getDao(){
		return new LibroDao(config);
	}

}
