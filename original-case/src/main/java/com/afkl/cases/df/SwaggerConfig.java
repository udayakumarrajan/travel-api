/**
 * 
 */
package com.afkl.cases.df;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Udayakumar.Rajan
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private final String applicationName = "KLM Case X01";

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.afkl.cases.df.controller")).paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder().title(this.applicationName).description("Travel API").contact(contact())
				.version("1.0.0").build();
	}

	private Contact contact() {
		return new Contact("Udayakumar Rajan", "https://www.linkedin.com/in/udayakumar-rajan-257a13108/",
				"udayakumar.rajan@outlook.com");
	}

}
