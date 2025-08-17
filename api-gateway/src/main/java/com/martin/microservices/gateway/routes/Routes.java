package com.martin.microservices.gateway.routes;



import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

// PASO 24
// En este archivo definimos las rutas de nuestro API Gateway
// Usamos el modelo de programación funcional para definir las rutas

@Configuration
public class Routes {
    // Aquí puedes definir las rutas de tu API Gateway

    // Usamos Functional Endpoint Programming Model para definir las rutas

    @Bean
    public RouterFunction<ServerResponse> productServiceRoute(){
        return GatewayRouterFunctions.route("product_service")
                // lo que es definir la rule
                // que si la utl es /api/product
                // entonces se redirige a http://localhost:8080
                .route(RequestPredicates.path("/api/product"), HandlerFunctions.http("http://localhost:8080"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> OrderServiceRoute(){
        return GatewayRouterFunctions.route("order_service")
                .route(RequestPredicates.path("/api/order"), HandlerFunctions.http("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> InventoryServiceRoute(){
        return GatewayRouterFunctions.route("inventory_service")
                .route(RequestPredicates.path("/api/inventory"), HandlerFunctions.http("http://localhost:8082"))
                .build();
    }


}
