package com.anibal.educational.rest_service.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anibal.educational.rest_service.comps.dao.LibroDao;
import com.anibal.educational.rest_service.domain.Libro;
import com.anibal.educational.rest_service.domain.LibroFilter;
import com.anibal.educational.rest_service.domain.Message;

/**
 * Cotrolador de servicio REST para apliacion educativa
 */

@RestController
public class RestServiceController extends AbstractRestService {
	
	@RequestMapping("/listLibros") //GET
    public ResponseEntity<?> get() {
		
//		DatabaseConnection db = null;
//		ResultSet rs = null;
//		PreparedStatement st = null;
		try {
			LibroDao dao = new LibroDao();
			
			LibroFilter filtro = new LibroFilter();
			
			filtro.setAutor("060651");
			
			List<Libro> libros = dao.getItems(filtro);
			
			logger.error("Son "+libros.size()+" libros");
			
//			db = RestServiceUtil.getDbConnectionMgr().getDatabaseConnection(RestServiceCostant.REST_SERVICE_DB_DATASOURCE_NAME);
//			db.connect();	
//			
//			st = db.prepare("select * from operacion_header");
//			rs = st.executeQuery();
//			
//			int i = 0;
//			while(rs.next()) {
//				System.out.println(rs.getString("COMPANIA"));
//				
//				if(i>10){
//					break;
//				}
//			}
    	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error al conectar ",e);
			e.printStackTrace();
		}
//		finally{
//			closeResources(db, st, rs, "");
//		}
        Libro libro = new Libro(1l, "pepe", "las adventuras de pepe", "editorial ani01");
        Libro libro1 = new Libro(2l, "coco", "las adventuras de coco", "editorial ani02");
        Libro libro2 = new Libro(3l, "juan", "las adventuras de juan", "editorial ani03");
        Libro libro3 = new Libro(4l, "rodolfo", "las adventuras de rodolfo", "editorial ani04");

        List<Libro> libros = new ArrayList<Libro>();
        libros.add(libro);
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);

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
