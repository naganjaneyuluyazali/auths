package com.future.payments.router;

import com.future.payments.handler.Handler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration(proxyBeanMethods = false)
public class Router {
    @Bean
    public RouterFunction<ServerResponse> paymentsRouter(Handler handler){
        return route(POST("/payments").and(accept(MediaType.APPLICATION_JSON)), handler :: payments);
    }

    @Bean
    public RouterFunction<ServerResponse> dummyRouter(@Valid Handler handler){
        return route(GET("/").and(accept(APPLICATION_JSON)), handler :: payments);
    }
}
