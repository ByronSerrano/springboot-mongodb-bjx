package com.example.mongodb.service;

import com.example.mongodb.domain.Voto;

import java.util.HashMap;
import java.util.Optional;
import java.util.Map;
import java.util.List;
public interface VotoService {

    Voto save(Voto voto);

    Optional<Voto> findById(String id);

    Iterable<Voto> findAll();

    void deleteById(String id);

    Map<String, Long> obtenerVotosPorCandidato();

    List<HashMap> obtenerVotosPorCandidatoYMesa();

}
