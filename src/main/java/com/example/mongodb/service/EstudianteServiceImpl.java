package com.example.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mongodb.domain.Estudiante;
import com.example.mongodb.repository.EstudiantePersistence;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudiantePersistence repository;

    @Override
    public Estudiante save(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    @Override
    public Optional<Estudiante> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Estudiante> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Estudiante> buscarPorFirmaAsistencia(Boolean firmaAsistencia) {
        return repository.findByFirmaAsistencia(firmaAsistencia);
    }

    @Override
    public Optional<Estudiante> find(String id) {
        return repository.findById(id);
    }
}


