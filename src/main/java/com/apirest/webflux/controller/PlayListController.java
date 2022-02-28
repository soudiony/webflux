package com.apirest.webflux.controller;

import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.service.PlayListImp;
import com.apirest.webflux.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
public class PlayListController {

    @Autowired
    PlayListService service;  //chama a interface PLS

    @GetMapping(value = "/playlist")
    public Flux<PlayList> getPlayLista(){
        return service.findAll();
    }

    @GetMapping(value = "/playlist/{id}")
    public Mono<PlayList> getPlayListId(@PathVariable String id){  //@PathVariable é passado na URL, mas nao mais como ?
      return service.findById(id);
    }

    @PostMapping(value = "/playlist")  // aqui passa a PlayList em formato Json e ele vai gravar, (via PostMan)
    public Mono<PlayList> save(@RequestBody PlayList pl){ //@RequestBody, é passo na requisiçao em formato Json
       return service.save(pl);
    }




}
