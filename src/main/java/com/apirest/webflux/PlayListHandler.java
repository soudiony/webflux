package com.apirest.webflux;

import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;


@Component   //é um Bin gerenciado pelo Spring
public class PlayListHandler {       //Handler ta fz papel de RestController

    @Autowired
    PlayListService service;  //injeta a interface PlService e seus metodos

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok().contentType(MediaType.APPLICATION_JSON).body(service.findAll(), PlayList.class);

        //agora! ele retorna novamente uma lista de PlayList! recebendo como paramentro
        //como retorno um Mono<ServerResponse>, faz parte da API.. pega uma lista e monta um respotsa com ela
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");  //recebe o "@PathVariable, vindo na reuisicao
        return ok().
                contentType(MediaType.APPLICATION_JSON).
                body(service.findById(id), PlayList.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){
      final Mono<PlayList> playListMono = request.bodyToMono(PlayList.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playListMono.flatMap(service::save), PlayList.class ));  //construindo um Body
                                                       //referencia a imjeção service e :: o metodo
    }

}
