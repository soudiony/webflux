package com.apirest.webflux.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document   //mapeia entre objeto PlayList e o BD
public class PlayList {
    @Id
    private String id;
    private String nome;

   public String getId() {
      return id; }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PlayList(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
