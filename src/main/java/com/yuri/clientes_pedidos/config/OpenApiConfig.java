package com.yuri.clientes_pedidos.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API de Clientes")
						.version("1.0.0")
						.description("API REST para gerenciamento de Clientes")
						.contact(new Contact()
								.name("Yuri Freitas")
								.url("https://github.com/YuriiFreitass")
						)
				);

	}
}
