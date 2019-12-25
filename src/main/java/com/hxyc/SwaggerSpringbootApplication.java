package com.hxyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerSpringbootApplication.class, args);
	}

}
