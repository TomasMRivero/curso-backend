package com.tomasmartinez.cursobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class CursoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoBackendApplication.class, args);
	}

}
