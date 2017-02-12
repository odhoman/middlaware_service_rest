package com.anibal.educational.rest_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anibal.educational.rest_service.comps.service.ServiceRestData;
import com.anibal.educational.rest_service.domain.Libro;
import com.anibal.educational.rest_service.domain.Message;

/**
 * Cotrolador de servicio REST para aplicacion educativa
 */

@RestController
@ContextConfiguration(classes = RestServiceContextConfigurator.class,loader=AnnotationConfigContextLoader.class)
public class RestServiceController extends AbstractRestService {
	
	@Autowired
	private ServiceRestData serviceRestData;
	
	@RequestMapping("/listLibros") //GET
    public ResponseEntity<?> get() {
		
		logger.debug("Entrando listLibros");
		 List<Libro> libros = null;
		try {
//			LibroDao dao = new LibroDao();
//			
//			LibroFilter filtro = new LibroFilter();
//			
//			filtro.setAutor("060651");
			
			 libros = serviceRestData.getLibros();
			
    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			logger.error("error al conectar ",e);
			e.printStackTrace();
		}
//		finally{
//			closeResources(db, st, rs, "");
//		}

		logger.debug("Saliendo listLibros");
		
        return new ResponseEntity<List<Libro>>(libros, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/libro", method = RequestMethod.POST)
    public ResponseEntity<?> create (@RequestBody Libro libro){

    	System.out.println("Creando libro");
    	
        if(libro.getId() == 0){
           return new ResponseEntity<String>("id 0 invalido", HttpStatus.BAD_REQUEST);
        }
        
        //Aca se crea el libro
        
        System.out.println("Libro Creado");
        
      return  new ResponseEntity<Libro>(libro, HttpStatus.OK);
      
    }
    
    //Se actualiza un libro
    @RequestMapping(value = "/libro/{id}",method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") long id,@RequestBody Libro libro){
    	
    	System.out.println("Actualizado un Libro");
    	
        if(id == 0 || libro==null){
            return new ResponseEntity<String>("id 0 invalido", HttpStatus.BAD_REQUEST);
        }
        
        System.out.println("Libro Actualizado");
        
        return  new ResponseEntity<Libro>(libro, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/libro/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable("id") Long id){
    	
    	System.out.println("Eliminando un Libro");
    	
        if(id == 0){
            return new ResponseEntity<String>("id 0 invalido", HttpStatus.BAD_REQUEST);
        }
        
        Message message = new Message(1, "Libro "+id+" Borrado");
        
        System.out.println("Libro Eliminado");
        
        return  new ResponseEntity<Message>(message, HttpStatus.OK);
    }

}
