package com.piassa.sales_analytics_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Sales Analytics API",
				version = "1.0",
				description = "API para gerenciamento de produtos e vendas",
				contact = @Contact(
						name = "Cliente",
						email = "cliente@email.com"
				),
				license = @License(
						name = "MIT",
						url = "https://opensource.org/licenses/MIT"
				)
		)
)
@SpringBootApplication
public class SalesAnalyticsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesAnalyticsApiApplication.class, args);
	}

}
