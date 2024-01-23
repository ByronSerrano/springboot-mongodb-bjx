package com.example.mongodb.service;

import com.example.mongodb.domain.Voto;
import com.example.mongodb.repository.VotoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;

import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;

import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;

import java.util.Optional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VotoServiceImpl implements VotoService {

    @Autowired
    private VotoPersistence repository;
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public Voto save(Voto voto) {
        return repository.save(voto);
    }

    @Override
    public Optional<Voto> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Voto> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    //test

    @Override
    public Map<String, Long> obtenerVotosPorCandidato() {
        List<Voto> listaVotos = repository.findAll();
        Map<String, Long> votosPorCandidato = new HashMap<>();

        for (Voto voto : listaVotos) {
            String candidato = voto.getPartido().getCandidato();
            votosPorCandidato.put(candidato, votosPorCandidato.getOrDefault(candidato, 0L) + 1);
        }

        return votosPorCandidato;
    }
    /*
    @Override
    public List<HashMap> obtenerVotosPorCandidatoYMesa() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("mesaElectoral.numMesa", "partido.candidato")
                        .count().as("totalVotos")
                        .first("mesaElectoral.numMesa").as("numMesa")
                        .first("partido.candidato").as("candidato"),
                Aggregation.project("numMesa", "candidato", "totalVotos")
                        .andExclude("_id")
        );

        AggregationResults<HashMap> results = mongoTemplate.aggregate(aggregation, "voto", HashMap.class);
        return results.getMappedResults();
    }
     */

    @Override
    public List<HashMap> obtenerVotosPorCandidatoYMesa() {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("mesaElectoral.numMesa", "partido.candidato")
                        .count().as("totalVotos")
                        .first("mesaElectoral.numMesa").as("numMesa")
                        .first("partido.candidato").as("candidato"),
                Aggregation.project("numMesa", "candidato", "totalVotos")
                        .andExclude("_id")
        );

        AggregationResults<HashMap> results = mongoTemplate.aggregate(aggregation, "voto", HashMap.class);
        return results.getMappedResults();
    }


}
