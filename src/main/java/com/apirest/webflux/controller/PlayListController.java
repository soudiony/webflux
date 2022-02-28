package com.apirest.webflux.controller;

import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.service.PlayListImp;
import com.apirest.webflux.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
public class PlayListController {

    @Autowired
    PlayListService service;  //chama a interface PLS

    @GetMapping(value = "/playlist")
    public Flux<PlayList> getPlayLista() {
        return service.findAll();
    }

    @GetMapping(value = "/playlist/{id}")
    public Mono<PlayList> getPlayListId(@PathVariable String id) {  //@PathVariable é passado na URL, mas nao mais como ?
        return service.findById(id);
    }

    @PostMapping(value = "/playlist")  // aqui passa a PlayList em formato Json e ele vai gravar, (via PostMan)
    public Mono<PlayList> save(@RequestBody PlayList pl) { //@RequestBody, é passo na requisiçao em formato Json
        return service.save(pl);
    }

                    //devolve uma Stream de eventos
    @GetMapping(value = "/playlist/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
        public Flux<Tuple2<Long, PlayList>> getPlayListEvents(){  //Tuple2: intervalo e events

            Flux<Long> intervalo = Flux.interval(Duration.ofSeconds(4));  //criar fluxo de periodo, tipo (Long)..

            Flux<PlayList> eventos = service.findAll(); //retornando um fluxo de PlayList

            System.out.println("Teve Eventos");
            return Flux.zip(intervalo, eventos);   //sera enviado ao cliente 2 coisas, Intervalo e Eventos de PlayList
        }

}
