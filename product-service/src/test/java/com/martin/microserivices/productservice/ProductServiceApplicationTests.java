package com.martin.microserivices.productservice;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;
import org.hamcrest.Matchers;

// Paso 7
// Intergration tests for two endpoints
// El endpoint GET /api/product y el endpoint POST /api/product
// Por lo que vamos a usar TestContainers, la cual es una libreria que permite // crear contenedores de Docker para realizar pruebas de integración
// Desde instances of databases, message brokers, web browsers, or just about anything that can run in a Docker container
// Para usar TestContainers, necesitamos agregar la dependencia en el archivo pom.xml

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) // para que no use el puerto 8080 por defecto e interfiera con otros servicios
class ProductServiceApplicationTests {

	@ServiceConnection // para que TestContainers pueda inyectar las properties de nuestra aplicación
	static MongoDBContainer mongoDBContainer= new MongoDBContainer("mongo:7.0.5");

	@LocalServerPort // para inyectar el puerto en el que se está ejecutando el servicio, que es aleatorio
	private Integer port;

	// se ejecuta antes de cada test
	@BeforeEach
	void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port= port; // puerto donde se ejecuta el servicio
	}

	static {
		mongoDBContainer.start(); // se inicia el contenedor de MongoDB antes de ejecutar los tests

	}

	// Test POST /api/product
	@Test
	void shouldCreateProduct() {
		String requestBody = """
					{
					   "name": "Iphone 15 Pro",
					   "description": "Iphone 15 Pro is a smartphone from Apple",
					   "price": 1000
					}
				""";

		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/product")
				.then()
				.statusCode(201) // Verifica que el producto se crea correctamente con el código de estado 201
				.body("id", Matchers.notNullValue()) // Verifica que el ID del producto no sea nulo
				.body("name", Matchers.equalTo("Iphone 15 Pro")) // Verifica que el nombre del producto sea correcto
				.body("description", Matchers.equalTo("Iphone 15 Pro is a smartphone from Apple")) // Verifica que la descripción del producto sea correcta
				.body("price", Matchers.equalTo(1000)); // Verifica que el precio del producto sea correcto
	}



}
