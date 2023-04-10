package com.example.Sistema.de.Registro.v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// El método main es el punto de entrada de la aplicación Java
//@SpringBootApplication es una anotación de Spring Boot que combina las anotaciones @Configuration, @EnableAutoConfiguration y @ComponentScan.
// Esta anotación se utiliza para marcar la clase principal de una aplicación Spring Boot, lo que permite que Spring Boot realice la configuración
// automática de la aplicación y habilite otras funcionalidades importantes


@SpringBootApplication
public class SistemaDeRegistroV2Application {


	// El método run de la clase SpringApplication se utiliza para iniciar la aplicación Spring Boot
	// Recibe como parámetros la clase principal y los argumentos de la línea de comandos
	public static void main(String[] args) {
		SpringApplication.run(SistemaDeRegistroV2Application.class, args);
	}

}
