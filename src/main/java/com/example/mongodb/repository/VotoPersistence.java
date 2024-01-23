package com.example.mongodb.repository;

import com.example.mongodb.domain.Voto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.Optional;

public interface VotoPersistence extends MongoRepository<Voto, String> {

    Optional<Voto> findById(String id);

    List<HashMap> findByMesaElectoral_NumMesa();

    @Aggregation(pipeline = {
            "{$group: {_id: '$mesaElectoral.numMesa', totalVotos: {$sum: 1}}}",
            "{$project: {_id: 0, numMesa: '$_id', totalVotos: 1}}"
    })
    List<HashMap> obtenerVotosPorCandidatoYMesa();
}

