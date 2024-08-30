package com.institucion.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
    public String getStatingMessage() {
        return "BIENVENIDO a esta API de Prueba <br>"+
		"INSTRUCCIONES: Utilizar el archivo de postman para probar las direcciones creadas <br>"+
		"Hecho por Nicolás Barragán";
    }


}
