package com.yaba.monbudget.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import static com.yaba.monbudget.constant.Constant.BASE_URL;

@Configuration
public class SwaggerConfig {
    private static final String AUTH_HEADER_NAME = "backoffice";
    private static final String GROUPE = "MonBudget";
    private static final String TITLE = "MonBudget";
    private static final String VERSION = "1.0.0";


    public GroupedOpenApi adminApi() {
        return GroupedOpenApi.builder()
                .group(GROUPE)
                .pathsToMatch(BASE_URL + "/**")
                .build();
    }
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(TITLE).version(VERSION))
                .components(new Components()
                        .addSecuritySchemes(AUTH_HEADER_NAME, new SecurityScheme()
                                .type(SecurityScheme.Type.APIKEY)
                                .in(SecurityScheme.In.HEADER)
                                .name(AUTH_HEADER_NAME)))
                .addSecurityItem(new SecurityRequirement().addList(AUTH_HEADER_NAME));
    }

}
