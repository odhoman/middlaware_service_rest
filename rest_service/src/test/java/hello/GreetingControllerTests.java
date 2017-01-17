/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingControllerTests {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080";

    @Test /* PUT */
    public void getLibros() throws Exception {
		System.out.println("Testing update User API ------ GET----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity(REST_SERVICE_URI+"/listLibros", ResponseEntity.class);
    }
	
    
    @Test /* PUT */
    public void updateLibro() throws Exception {
		System.out.println("Testing update User API ------ PUT----------");
        RestTemplate restTemplate = new RestTemplate();
        Libro user  = new Libro(1L,"Borges","El Aleph","Planeta");
        restTemplate.put(REST_SERVICE_URI+"/user/1", user);
        System.out.println(user);
    }
    
    @Test /* POST */
    public void createLibro() throws Exception {
		System.out.println("Testing update User API ------ POST----------");
        RestTemplate restTemplate = new RestTemplate();
        Libro user  = new Libro(1L,"Borges","El Aleph","Planeta");
        restTemplate.postForObject(REST_SERVICE_URI+"/user/1", user, ResponseEntity.class);
        System.out.println(user);
    }
    
    
    @Test /* DELETE */
    public void deleteLibro() throws Exception {
		System.out.println("Testing update User API ------ DELETE----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/1");
    }


}
