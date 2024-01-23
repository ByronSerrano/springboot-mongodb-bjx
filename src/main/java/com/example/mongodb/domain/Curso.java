package com.example.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.example.mongodb.domain.MesaElectoral;

import java.io.Serializable;

@Document(collection = "curso")
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field(name = "nombre")
    private String nombre;

    @Field(name = "mesa_id")
    private MesaElectoral mesaId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MesaElectoral getMesaId() {
        return mesaId;
    }

    public void setMesaId(MesaElectoral mesaId) {
        this.mesaId = mesaId;
    }
}
