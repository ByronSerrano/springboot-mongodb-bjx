package com.example.mongodb.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudiante")
public class Estudiante {

    @Id
    private String id;

    private String nombres;
    private String email;
    private Boolean firmaAsistencia;
    private Curso curso;

    // Constructores, getters y setters

    public Estudiante() {
        // Constructor por defecto necesario para MongoDB
    }

    public Estudiante(String nombres, String email, Boolean firmaAsistencia, Curso curso) {
        this.nombres = nombres;
        this.email = email;
        this.firmaAsistencia = firmaAsistencia;
        this.curso = curso;
    }

    // Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getFirmaAsistencia() {
        return firmaAsistencia;
    }

    public void setFirmaAsistencia(Boolean firmaAsistencia) {
        this.firmaAsistencia = firmaAsistencia;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id='" + id + '\'' +
                ", nombres='" + nombres + '\'' +
                ", email='" + email + '\'' +
                ", firmaAsistencia=" + firmaAsistencia +
                ", curso=" + curso +
                '}';
    }
}
