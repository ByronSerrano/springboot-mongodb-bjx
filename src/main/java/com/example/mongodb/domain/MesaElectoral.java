package com.example.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "mesa_electoral")
public class MesaElectoral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    @Field(name = "num_mesa")
    private Long numMesa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getnumMesa() {
        return numMesa;
    }

    public void setnumMesa(Long numMesa) {
        this.numMesa = numMesa;
    }

}