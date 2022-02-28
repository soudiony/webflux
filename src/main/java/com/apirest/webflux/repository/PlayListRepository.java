package com.apirest.webflux.repository;

import com.apirest.webflux.document.PlayList;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListRepository extends ReactiveMongoRepository<PlayList, String> {

}
