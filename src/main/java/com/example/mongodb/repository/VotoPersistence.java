package com.example.mongodb.repository;

import com.example.mongodb.domain.Voto;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface VotoPersistence extends MongoRepository<Voto, String> {

    Optional<Voto> findById(String id);

    // Puedes agregar más métodos según tus necesidades

}

