package com.finra.assessment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket apiDoc()
    {
        return (new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.finra.assessment"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaInfo()));
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo("FINRA Assessment api",
                "This is a simple api for generating standard alpha-numeric combinations",
                "1.0",
                "Terms Of Service",
                new Contact(" HIRAL MAHESHBHAI PUROHIT","","hiralmhsh@gmail.com"),
                "License Version",
                "License URL"
                );
        return  apiInfo;
    }
}
