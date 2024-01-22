package com.example.mongodb.service;

import com.example.mongodb.domain.Voto;
import com.example.mongodb.repository.VotoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotoServiceImpl implements VotoService {

    @Autowired
    private VotoPersistence repository;

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

    // Puedes agregar más métodos según tus necesidades

}
