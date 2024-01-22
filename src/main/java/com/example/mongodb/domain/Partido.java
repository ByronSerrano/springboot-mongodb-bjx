package com.example.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "partido")
public class Partido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field(name = "candidato")
    private String candidato;

    @Field(name = "num_partido")
    private Long numPartido;

    @Field(name = "nombre_partido")
    private String nombrePartido;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCandidato() {
        return candidato;
    }

    public void setCandidato(String candidato) {
        this.candidato = candidato;
    }

    public Long getNumPartido() {
        return numPartido;
    }

    public void setNumPartido(Long numPartido) {
        this.numPartido = numPartido;
    }

    public String getNombrePartido() {
        return nombrePartido;
    }

    public void setNombrePartido(String nombrePartido) {
        this.nombrePartido = nombrePartido;
    }
}

