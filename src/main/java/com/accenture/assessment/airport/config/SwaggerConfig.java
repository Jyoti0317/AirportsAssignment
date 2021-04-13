package com.accenture.assessment.airport.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Application Web MVC Configuration overriding default MVC configuration
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  /**
   * {@link Docket} bean definition to configure Swagger.
   *
   * @return {@link Docket}
   */
  @Bean
  public Docket airportApi() {
    return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false)
        .apiInfo(apiInfo()).select()
        .apis(RequestHandlerSelectors.basePackage("com.accenture.assessment.airport"))
        .paths(regex("/airport.*")).build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Airport Data Center")
        .description(
            "Airport Data Center API allows user to get all Runway information of each airport for a given country. The api also allows user to get details of top 10 countries with highest no of airports ")
        .version("1.0.0").build();
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}
