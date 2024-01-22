package com.example.mongodb.service;

import com.example.mongodb.domain.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {

    Estudiante save(Estudiante estudiante);

    Optional<Estudiante> findById(String id);

    List<Estudiante> findAll();

    void deleteById(String id);

    List<Estudiante> buscarPorFirmaAsistencia(Boolean firmaAsistencia);

    Optional<Estudiante> find(String id);
}


