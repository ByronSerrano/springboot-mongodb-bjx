package com.example.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.mongodb.domain.Estudiante;

import java.util.List;

public interface EstudiantePersistence extends MongoRepository<Estudiante, String> {

    List<Estudiante> findByFirmaAsistencia(Boolean firmaAsistencia);
}
