package com.anibal.educational.rest_service.test.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Luncher de la aplicacion */

@SpringBootApplication
public class RestServiceAplicationTest{

	public static void main(String[] args) {

		args = new String[] { "--server.port=8081" };

		SpringApplication.run(RestServiceAplicationTest.class, args);
	}

}
