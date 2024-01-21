package com.example.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import com.example.mongodb.domain.Curso;

public interface CursoPersistence extends MongoRepository<Curso, String> {

    List<Curso> findByNombre(String nombre);

}

