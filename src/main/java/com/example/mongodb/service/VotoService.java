package com.example.mongodb.service;

import com.example.mongodb.domain.Voto;
import java.util.Optional;

public interface VotoService {

    Voto save(Voto voto);

    Optional<Voto> findById(String id);

    Iterable<Voto> findAll();

    void deleteById(String id);

    // Puedes agregar más métodos según tus necesidades

}
