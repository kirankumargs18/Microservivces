package com.globallogic.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * To customize Swagger API documentation, We use Docket Bean (It needs API
 * information object)
 */
@Configuration
public class SwaggerConfig {
	
	
	public static final String AUTHORIZATION_HEADER="Authorization";
	
	private ApiKey apiKey() {

		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}	
	
	private ApiInfo apiInfo() {
		
		return new ApiInfo(
				"Security REST API", 
				"Security Rest API documentation",
				"1",
				"Terms of service", 
				new Contact("Kiran", "www.kiran.com", "kiran@gmail.com"),
				"License of API", 
				"API icense URL",
				Collections.emptyList());
	}
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2) //we need toa 
				.apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext())) //for security
				.securitySchemes(Arrays.asList(apiKey()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
		
	}
	
	
	/**
	 * SecurityContext for swagger
	 * */
	private SecurityContext securityContext() {
		
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
		
	}
	
	/**
	 * Security references
	 * */
	private List<SecurityReference> defaultAuth() {

		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");

		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];

		authorizationScopes[0] = authorizationScope;

		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));

	}

}
