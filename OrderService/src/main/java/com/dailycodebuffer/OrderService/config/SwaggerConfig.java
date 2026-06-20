package com.dailycodebuffer.OrderService.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {

    @Bean
    public OpenAPI orderServiceOpenAPI() {
        String title = "Order Service API";
        String version = "1.0";
        if (!StringUtils.hasText(title) || !StringUtils.hasText(version)) {
            throw new IllegalStateException(
                    "OpenAPI info.title and info.version must not be null or empty");
        }
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .version(version)
                        .description("REST API for managing order placement and lifecycle"))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}
