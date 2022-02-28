/*package com.apirest.webflux;

import com.apirest.webflux.document.PlayList;
import com.apirest.webflux.repository.PlayListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component   //é um Bin gerenciado pelo Spring
public class DummyData implements CommandLineRunner {


    private final PlayListRepository playlistRepository;

    DummyData(PlayListRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    	playlistRepository.deleteAll()
                .thenMany(
                        Flux.just("API REST Spring Boot", "Deploy de uma aplicação java no IBM Cloud", "Java 8",
                                "Github", "Spring Security", "Web Service RESTFULL", "Bean no Spring Framework")
                                .map(nome -> new PlayList(UUID.randomUUID().toString(), nome))
                                .flatMap(playlistRepository::save))
               .subscribe(System.out::println);
    }

}*/
