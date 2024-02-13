package com.bookstore.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/users/**").uri("lb://user-service"))
                .route("order-service", r -> r.path("/orders/**").uri("lb://order-service"))
                .route("book-inventory-service", r -> r.path("/books/**").uri("lb://book-inventory-service"))
                .route("payment-service", r -> r.path("/payments/**").uri("lb://payment-service"))
                .build();
    }

    /*
    **
    @Bean
    public RouterFunction<ServerResponse> helloRoute() {
        return RouterFunctions
                .route()
                .GET("/hello", request -> ServerResponse.ok().body("Hello world"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> orderRoute() {
        return route("/orders").GET("/", http()).build();
    }
     */
}
