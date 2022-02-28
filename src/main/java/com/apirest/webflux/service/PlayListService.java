package com.apirest.webflux.service;


import com.apirest.webflux.document.PlayList;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayListService {  //metodos para convrsar com o BD

    Flux<PlayList> findAll();  //ele nao devolve uma Lista, retorna um tipo Flux, ou seja, varios elementos
    Mono<PlayList> findById(String id); //devolve apenas 1 elemento
    Mono<PlayList> save(PlayList playList);

}
