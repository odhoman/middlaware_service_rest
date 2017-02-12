package com.anibal.educational.rest_service.comps.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.anibal.educational.rest_service.comps.service.ServiceRestData;
import com.anibal.educational.rest_service.domain.Libro;
import com.anibal.educational.rest_service.domain.Message;

public class DummyServiceRestDataImpl extends AbstractService implements ServiceRestData {

	public List<Libro> getLibros() {
		
		logger.debug("Entrando... getLibros");
		
        Libro libro = new Libro(1l, "pepe", "las adventuras de pepe", "editorial ani01");
        Libro libro1 = new Libro(2l, "coco", "las adventuras de coco", "editorial ani02");
        Libro libro2 = new Libro(3l, "juan", "las adventuras de juan", "editorial ani03");
        Libro libro3 = new Libro(4l, "rodolfo", "las adventuras de rodolfo", "editorial ani04");

        List<Libro> libros = new ArrayList<Libro>();
        libros.add(libro);
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
        
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
	

}
