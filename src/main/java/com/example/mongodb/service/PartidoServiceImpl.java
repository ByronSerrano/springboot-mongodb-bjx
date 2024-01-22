package com.example.mongodb.service;
import com.example.mongodb.domain.Partido;
import com.example.mongodb.repository.PartidoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoServiceImpl implements PartidoService {

    @Autowired
    private PartidoPersistence partidoRepo;

    @Override
    public Partido save(Partido partido) {
        return partidoRepo.save(partido);
    }

    @Override
    public Optional<Partido> find(String id) {
        return partidoRepo.findById(id);
    }

    @Override
    public List<Partido> findAll() {
        return partidoRepo.findAll();
    }

    @Override
    public void delete(String id) {
        partidoRepo.deleteById(id);
    }

    @Override
    public Optional<Partido> buscarPorCandidato(String candidato) {
        return partidoRepo.findByCandidato(candidato);
    }
}
