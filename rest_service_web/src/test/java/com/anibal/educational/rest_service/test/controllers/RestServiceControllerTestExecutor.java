package com.anibal.educational.rest_service.test.controllers;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.client.RestTemplate;

import com.anibal.educational.rest_service.domain.CabeceraGasto;
import com.anibal.educational.rest_service.domain.DetalleGasto;
import com.anibal.educational.rest_service.domain.Message;

/**
 * Test del controlador de los servicios REST de aplicacion educativa
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = RestServiceContextConfiguratorTest.class, loader = AnnotationConfigContextLoader.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RestServiceControllerTestExecutor {

	public static final String REST_SERVICE_URI = "http://localhost:8081";

	static Long gastoCabeceraId = 1000000L;
	static Long [] gastoCabeceraIds = new Long[]{1000001L,1000002L};
	static Long [] detalleGastos = new Long[]{50000L,50001L,50002L,50003L,50004L};

	@BeforeClass
	public static void oneTimeSetUp() {

		System.out.println("\n" + RestServiceControllerTestExecutor.class.getName()
				+ " Iniciando el servicio para probar metodos rest");

		String[] args = new String[] { "--server.port=8081" };
		RestServiceAplicationTest.main(args);

	}

	@AfterClass
	public static void oneTimeTearDown() {
		System.out.println("\n" + RestServiceControllerTestExecutor.class.getName() + " Bajando el servicio.");
	}
	
	
	@Test /* POST */
	public void m1createGastoCabecera1() {
		String urlTest = REST_SERVICE_URI + "/createGastoCabecera";
		System.out.println("Testing POST createGastoCabecera ----------");

		System.out.println("URL: " + urlTest);

		RestTemplate restTemplate = new RestTemplate();
		CabeceraGasto cabeceraGasto = new CabeceraGasto();
		cabeceraGasto.setGastoId(gastoCabeceraId);

		try {
			restTemplate.postForLocation(urlTest, cabeceraGasto, CabeceraGasto.class);
		} catch (Exception e) {
			System.err.println("Testing POST createGastoCabecera fail --- " + e.getMessage());
			fail(e.getMessage());
		}

		System.out.println("Testing POST createGastoCabecera successfull-----------\n");
	}
	
	@Test /* POST */
	public void m1createGastoCabecera2() {
		String urlTest = REST_SERVICE_URI + "/createGastoCabecera";
		System.out.println("Testing POST createGastoCabecera ----------");

		System.out.println("URL: " + urlTest);

		RestTemplate restTemplate = new RestTemplate();
		CabeceraGasto cabeceraGasto = new CabeceraGasto();
		cabeceraGasto.setGastoId(gastoCabeceraIds[0]);

		try {
			restTemplate.postForLocation(urlTest, cabeceraGasto, CabeceraGasto.class);
		} catch (Exception e) {
			System.err.println("Testing POST createGastoCabecera fail --- " + e.getMessage());
			fail(e.getMessage());
		}

		System.out.println("Testing POST createGastoCabecera successfull-----------\n");
	}
	
	
	@Test /* POST */
	public void m1createGastoCabecera3() {
		String urlTest = REST_SERVICE_URI + "/createGastoCabecera";
		System.out.println("Testing POST createGastoCabecera ----------");

		System.out.println("URL: " + urlTest);

		RestTemplate restTemplate = new RestTemplate();
		CabeceraGasto cabeceraGasto = new CabeceraGasto();
		cabeceraGasto.setGastoId(gastoCabeceraIds[1]);

		try {
			restTemplate.postForLocation(urlTest, cabeceraGasto, CabeceraGasto.class);
		} catch (Exception e) {
			System.err.println("Testing POST createGastoCabecera fail --- " + e.getMessage());
			fail(e.getMessage());
		}

		System.out.println("Testing POST createGastoCabecera successfull-----------\n");
	}

	@Test /* PUT */
	public void m2updateGasto() {
		String urlTest = REST_SERVICE_URI + "/updateGasto/" + gastoCabeceraId;

		System.out.println("Testing PUT updateGasto ----------");
		System.out.println("URL: " + urlTest);

		CabeceraGasto cabeceraGasto = new CabeceraGasto();

		cabeceraGasto.setGastoNro(9999L);
		cabeceraGasto.setProyectoId(9999L);
		cabeceraGasto.setSubProyectoId(9999L);
		cabeceraGasto.setTipoGasto("gasto");
		cabeceraGasto.setCiudad("ciudad");
		cabeceraGasto.setPais("pais");
		cabeceraGasto.setProveedor("proveedor");
		cabeceraGasto.setTipoCambio(1D);
		cabeceraGasto.setImporte(1D);
		cabeceraGasto.setUserId(1L);
		cabeceraGasto.setObservaciones("observaciones");
		cabeceraGasto.setFechaGasto(new Date());
		cabeceraGasto.setGastoId(gastoCabeceraId);

		RestTemplate restTemplate = new RestTemplate();

		try {
			restTemplate.put(urlTest, cabeceraGasto);
		} catch (Exception e) {
			System.err.println("Testing PUT updateGasto fail --- " + e.getMessage());
			fail(e.getMessage());
		}

		System.out.println("Testing PUT updateGasto successfull-----------\n");
	}

	@Test /* GET */
	public void m3getGasto() {

		String urlTest = REST_SERVICE_URI + "/getGasto/" + gastoCabeceraId;
		System.out.println("Testing GET getGasto ----------");
		System.out.println("URL: " + urlTest);

		CabeceraGasto gasto = null;
		RestTemplate restTemplate = new RestTemplate();

		try {
			gasto = restTemplate.getForObject(urlTest, CabeceraGasto.class);
		} catch (Exception e) {
			System.err.println("Testing GET getGasto fail --- " + e.getMessage());
			fail(e.getMessage());
		}

		System.out.println("Se obtuvo el siguiente gasto ");
		System.out.println("==> " + gasto);

		System.out.println("Testing GET getGasto successfull-----------\n");
	}

	@Test /* DELETE */
	public void m4deleteGasto() {

		String urlTest = REST_SERVICE_URI + "/deleteGasto/" + gastoCabeceraId;
		System.out.println("Testing DELETE deleteGasto ----------");
		System.out.println("URL: " + urlTest);

		RestTemplate restTemplate = new RestTemplate();

		try {
			restTemplate.delete(urlTest);
		} catch (Exception e) {
			System.err.println("Testing DELETE deleteGasto fail --- " + e.getMessage());
			fail(e.getMessage());
		}

		System.out.println("Testing DELETE deleteGasto successfull-----------\n");

	}
	
	
	@Test /* DELETE */
	public void m4deleteGastos() {

		String urlTest = REST_SERVICE_URI + "/deleteGastos";
		System.out.println("Testing DELETE deleteGastos ----------");
		System.out.println("URL: " + urlTest);

		RestTemplate restTemplate = new RestTemplate();

		
		List<CabeceraGasto> gastos = new ArrayList<CabeceraGasto>();
		for (int i = 0; i < gastoCabeceraIds.length; i++) {
			CabeceraGasto gasto = new CabeceraGasto();
			gasto.setGastoId(gastoCabeceraIds[i]);
			gastos.add(gasto);
		}
		
		try {
			restTemplate.put(urlTest, gastos);
		} catch (Exception e) {
			System.err.println("Testing DELETE deleteGastos fail --- " + e.getMessage());
			fail(e.getMessage());
		}

		System.out.println("Testing DELETE deleteGastos successfull-----------\n");

	}
	
	@Test /* POST */
	public void m5createDetallesGasto() {
		String urlTest = REST_SERVICE_URI + "/createDetallesGasto";
		System.out.println("Testing POST createDetallesGasto ----------");

		System.out.println("URL: " + urlTest);

		List<DetalleGasto> detalles = new ArrayList<DetalleGasto>();
		
		for (int i = 0; i < detalleGastos.length; i++) {
			DetalleGasto detalle = new DetalleGasto();
			detalle.setDetalleId(detalleGastos[i]);
			detalles.add(detalle);
		}
		
		RestTemplate restTemplate = new RestTemplate();

		try {
			restTemplate.postForLocation(urlTest, detalles, List.class);
		} catch (Exception e) {
			System.err.println("Testing POST createDetallesGasto fail --- " + e.getMessage());
			fail(e.getMessage());
		}

		System.out.println("Testing POST createDetallesGasto successfull-----------\n");
	}
	
	@Test /* PUT */
	public void m6updateDetallesGasto() {
		
		String urlTest = REST_SERVICE_URI + "/updateDetallesGasto";

		System.out.println("Testing PUT updateDetallesGasto ----------");
		System.out.println("URL: " + urlTest);

		List<DetalleGasto> detalles = new ArrayList<DetalleGasto>();
		for (int i = 0; i < detalleGastos.length; i++) {
			DetalleGasto detalle = new DetalleGasto();
			detalle.setDetalleId(detalleGastos[i]);
			detalles.add(detalle);
			
			if (i == 0) {
				detalle.setGastoId(gastoCabeceraId);
				detalle.setGastosNro(2999999L);

			} else if (i == 1) {
				detalle.setGastoId(gastoCabeceraId);
				detalle.setTarea("TAREA CAMBIADA");
				detalle.setFechaGasto(new Date());

			} else if (i == 2) {
				detalle.setGastoId(gastoCabeceraId);
				detalle.setTipoCambio(9999.25D);
				detalle.setImporte(58685.87D);
			} else if (i == 3) {
				detalle.setGastoId(gastoCabeceraId);
				detalle.setCodeConvinationId(999999L);
				detalle.setObservaciones("OBSERVACIONES CAMBIADAS");
			} else if (i == 4) {
				detalle.setGastoId(gastoCabeceraId);
			}
		}
		
		RestTemplate restTemplate = new RestTemplate();

		try {
			restTemplate.put(urlTest, detalles);
		} catch (Exception e) {
			System.err.println("Testing PUT updateDetallesGasto fail --- " + e.getMessage());
			fail(e.getMessage());
		}

		System.out.println("Testing PUT updateDetallesGasto successfull-----------\n");
	}
	
	@Test /* GET */
	public void m7getDetallesGasto() {

		String urlTest = REST_SERVICE_URI + "/getDetallesGasto/"+gastoCabeceraId;
		System.out.println("Testing GET getDetallesGasto ----------");
		System.out.println("URL: " + urlTest);
		
		RestTemplate restTemplate = new RestTemplate();
		List<?> detalles = null;
		
		try {
			detalles = restTemplate.getForObject(urlTest, List.class);
		} catch (Exception e) {
			System.err.println("Testing GET getDetallesGasto fail --- " + e.getMessage());
			fail(e.getMessage());
		}
		System.out.println("Se obtuvieron los siguientes detalles de gastos: ");
		
		for(Object o: detalles){
			System.out.println("==> " + o);
		}

		System.out.println("Testing GET getDetallesGasto successfull-----------\n");
	}
	
	
	@Test /* DELETE */
	public void m8deleteDetallesGasto() {

		String urlTest = REST_SERVICE_URI + "/deleteDetallesGasto";
		System.out.println("Testing DELETE deleteDetallesGasto ----------");
		System.out.println("URL: " + urlTest);
		
		Message mensaje = null;
		List<DetalleGasto> detalles = new ArrayList<DetalleGasto>();
		
		for (int i = 0; i < detalleGastos.length; i++) {
			DetalleGasto detalle = new DetalleGasto();
			detalle.setDetalleId(detalleGastos[i]);
			detalles.add(detalle);
		}

		RestTemplate restTemplate = new RestTemplate();

		try {
			restTemplate.put(urlTest, detalles);
		} catch (Exception e) {
			System.err.println("Testing DELETE deleteDetallesGasto fail --- " + e.getMessage());
			fail(e.getMessage());
		}
		
		System.out.println(mensaje);

		System.out.println("Testing GET deleteDetallesGasto successfull-----------\n");

	}


}
