package com.anibal.educational.rest_service.comps.service;

import java.util.List;

import com.anibal.educational.rest_service.domain.Libro;
import com.anibal.educational.rest_service.domain.Message;

public interface ServiceRestData {
	
	public List<Libro> getLibros();

	public Libro createLibro(Libro libro);

	public Libro updateLibro(Long id, Libro libro);

	public Message deleteLibro(Long id) ;

}
