package com.capitole.electroniccommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	 @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("API test capitole")
	              .description("Brands Price Capitol Test API")
	              .version("v0.0.1")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")));
	  }
}