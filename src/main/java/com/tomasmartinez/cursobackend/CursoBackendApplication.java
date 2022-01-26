package com.tomasmartinez.cursobackend;

import com.tomasmartinez.cursobackend.models.Category;
import com.tomasmartinez.cursobackend.models.Product;
import com.tomasmartinez.cursobackend.repository.CategoryRepository;
import com.tomasmartinez.cursobackend.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CursoBackendApplication {

	private static final Logger logger = LogManager.getLogger(CursoBackendApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(CursoBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(CategoryRepository categoryRepository, ProductRepository productRepository){
			return (args -> {
				try{
					Category lacteos = Category.builder().name("lacteos").build();
					categoryRepository.save(lacteos);
					Category harinas = Category.builder().name("harinas").build();
					categoryRepository.save(harinas);

					productRepository.save(Product.builder().name("fideos").category(harinas).stock(15).createdDate(new Date()).build());
					productRepository.save(Product.builder().name("leche").category(lacteos).stock(30).createdDate(new Date()).build());
					productRepository.save(Product.builder().name("crema").category(lacteos).stock(45).createdDate(new Date()).build());

					for (Product p : productRepository.findAll()) {
						logger.info(p.toString());
					}
					logger.info("");
				}catch(Exception e){
					logger.error(e.getMessage());
				};
			});
	}
}
