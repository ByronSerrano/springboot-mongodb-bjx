package com.example.mongodb.service;

import java.util.List;
import com.example.mongodb.domain.Curso;

public interface CursoService {

    Curso save(Curso curso);

    List<Curso> getAllCursos();

    List<Curso> searchByNombre(String nombre);

}
