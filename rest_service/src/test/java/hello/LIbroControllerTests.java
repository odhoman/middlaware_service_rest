package hello;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Test del controlador de los servicios REST de aplicacion educativa
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LIbroControllerTests {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080";
	
	@Test /* GET */
	public void listLibrosTest(){
		System.out.println("\nTesting GET listLibros");
		System.out.println("URL: "+REST_SERVICE_URI+"/listLibros");
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			
			List<?> libros = restTemplate.getForObject(REST_SERVICE_URI+"/listLibros", List.class);
			
			System.out.println("== Se obtuvieron los siguientes resultados ");
			
			for (int i = 0; i < libros.size(); i++) 
				System.out.println("===== > "+libros.get(i));
			
		} catch (Exception e) {
			System.err.println("Testing GET listLibros fail --- "+e.getMessage());	
		}
		
		System.out.println("Testing GET listLibros successfull-----------\n");		
	}

	
	@Test /* PUT */
    public void updateLibro() {
		System.out.println("Testing PUT update Libro ----------");
		System.out.println("URL: "+REST_SERVICE_URI+"/libro/1");
		
        RestTemplate restTemplate = new RestTemplate();
        Libro libro  = new Libro(1L,"Borges","El Aleph","Planeta");
        
        try {
        	restTemplate.put(REST_SERVICE_URI+"/libro/1", libro);
		} catch (Exception e) {
			System.err.println("Testing PUT update Libro fail --- "+e.getMessage());
		}
        
		System.out.println("Testing PUT update Libro successfull-----------\n");
    }
	
	
	@Test /* POST */
	public void createLibro() {
		System.out.println("Testing POST create Libro ----------");
		System.out.println("URL: "+REST_SERVICE_URI+"/libro");
		
    	RestTemplate restTemplate = new RestTemplate();
        Libro libro  = new Libro(1L,"Borges","El Aleph","Planeta");
        
        try {
        	restTemplate.postForLocation(REST_SERVICE_URI+"/libro", libro, Libro.class);
		} catch (Exception e) {
			System.err.println("Testing POST create Libro fail --- "+e.getMessage());
		}
        
		System.out.println("Testing POST update Libro successfull-----------\n");
    }
	
	@Test /* DELETE */
	public void deleteLibro() {
		
		System.out.println("Testing DELETE delete Libro ----------");
		System.out.println("URL: "+REST_SERVICE_URI+"/libro/1");
		
    	RestTemplate restTemplate = new RestTemplate();
        
        try {
        	restTemplate.delete(REST_SERVICE_URI+"/libro/1");
		} catch (Exception e) {
			System.err.println("Testing DELETE delete fail --- "+e.getMessage());
		}
        
		System.out.println("Testing DELETE delete successfull-----------\n");
		
    }

}
