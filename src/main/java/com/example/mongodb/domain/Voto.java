package com.example.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "voto")
public class Voto {

    @Id
    private String id;

    private Estudiante estudiante;

    private Partido partido;

    private boolean votoNulo;

    // Constructores, getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public boolean isVotoNulo() {
        return votoNulo;
    }

    public void setVotoNulo(boolean votoNulo) {
        this.votoNulo = votoNulo;
    }

    @Override
    public String toString() {
        return "Voto [id=" + id + ", estudiante=" + estudiante + ", partido=" + partido + ", votoNulo=" + votoNulo + "]";
    }
}
