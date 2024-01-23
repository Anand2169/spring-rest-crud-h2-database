package com.bigil.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

	@Bean
	 Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.bigil.rest.controller"))
				.paths(PathSelectors.any())
				.build();
	}
}


/*
 * @Configuration public class SwaggerConfig implements WebMvcConfigurer {
 * 
 * @Bean Docket api() { return new Docket(DocumentationType.SWAGGER_2) .select()
 * .apis(RequestHandlerSelectors.basePackage("com.bigil.rest.controller"))
 * .build() .apiInfo(new ApiInfoBuilder() .title("REST API")
 * .description("Swagger is used to generate documentation for REST API ")
 * .version("1.0.0") .build()); }
 * 
 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
 * registry.addResourceHandler("swagger-ui.html")
 * .addResourceLocations("classpath:/META-INF/resources/");
 * 
 * registry.addResourceHandler("/webjars/**")
 * .addResourceLocations("classpath:/META-INF/resources/webjars/"); } }
 */