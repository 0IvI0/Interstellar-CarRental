/* package com.interstellarcarrental.carrental.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SpringFoxConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "Interstellar CarRental API",
            "This is a demo application without real resources or functionality.",
            "API TOS",
            "Terms of service",
            new Contact("XY", "interstellarcarrental.com", "exampleEmail.com"),
            "License of API", "API license URL", Collections.emptyList());
    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.interstellarcarrental.carrental.controllers"))
            .paths(PathSelectors.ant("/api/*"))
            .build()
            .apiInfo(apiInfo());
    } 
}
 */