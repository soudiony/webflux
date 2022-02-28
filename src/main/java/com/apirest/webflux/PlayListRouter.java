package com.apirest.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

// ROUTER E HANDLER - PROGRAMAÇÃO ESTILO FUNCIONAL

@Configuration
public class PlayListRouter {

    @Bean
    public RouterFunction<ServerResponse> routeX(PlayListHandler handlerX) {

        return RouterFunctions  //tipo de metodo (CRUD) + media type + metodo correspondetente na classe handler
           .route(GET("playlist").and(accept(MediaType.APPLICATION_JSON)), handlerX::findAll) //aceita (mediatype - JSON  e o metodo findAll da classe handlerX
           .andRoute(GET("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)), handlerX::findById)
           .andRoute(POST("playlist/").and(accept(MediaType.APPLICATION_JSON)), handlerX::save);

    }
}
