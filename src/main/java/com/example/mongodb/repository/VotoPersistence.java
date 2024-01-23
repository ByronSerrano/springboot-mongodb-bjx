package com.example.mongodb.repository;

import com.example.mongodb.domain.Voto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Map;


import java.util.Optional;

public interface VotoPersistence extends MongoRepository<Voto, String> {

    Optional<Voto> findById(String id);

    @Query("{$group: { _id: { numMesa: '$mesaElectoral.numMesa', candidato: '$partido.candidato' }, votosTotales: { $sum: 1 } } }")
    List<Map<String, Object>> obtenerVotosPorCandidatoYMesa();
}

