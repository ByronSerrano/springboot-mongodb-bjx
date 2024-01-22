package com.example.mongodb.service;

import com.example.mongodb.domain.Partido;

import java.util.List;
import java.util.Optional;

public interface PartidoService {

    Optional<Partido> find(String id);

    Partido save(Partido partido);

    void delete(String id);

    Iterable<Partido> findAll();

    Optional<Partido> buscarPorCandidato(String candidato);
}

