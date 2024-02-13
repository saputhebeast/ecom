package com.microservices.apigateway.config;

import com.microservices.apigateway.filter.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ApiGatewayConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/item-service/**").filters(f -> f.stripPrefix(1)
                                .filter(jwtAuthenticationFilter))
                        .uri("lb://item-service"))
                .route(p -> p.path("/identity-service/**").filters(f -> f.stripPrefix(1)
                                .filter(jwtAuthenticationFilter))
                        .uri("lb://identity-service"))
                .build();
    }
}
