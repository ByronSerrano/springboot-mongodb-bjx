package com.example.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.mongodb.domain.Partido;
import java.util.Optional;

public interface PartidoPersistence extends MongoRepository<Partido, String> {
    Optional<Partido> findByCandidato(String candidato);

    void deleteById(String id);
}
