package com.capitole.electroniccommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * Configuration of Open Api (swagger)
 * @author Anderson Casas
 * @Data  2023/09/03
 * @Since  2023/09/03
 */
@Configuration
public class SwaggerConfig {
	
	 @Bean
	  OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("API test capitole")
	              .description("Brands Price Capitol Test API")
	              .version("v0.0.1")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")));
	  }
}