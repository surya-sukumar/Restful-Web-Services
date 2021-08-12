package com.example.Springbootservices.restfulwebservices;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.tokens.DocumentEndToken;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

//Configuration
@Configuration
//Enable Swagger
@EnableSwagger2
public class SwaggerConfig {

    //Bean
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2);
    }
    //Bean - Docket

    //all paths
    //all apis

}
