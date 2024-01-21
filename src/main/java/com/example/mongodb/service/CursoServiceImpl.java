package com.example.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mongodb.domain.Curso;
import com.example.mongodb.repository.CursoPersistence;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoPersistence cursoRepo;

    @Override
    public Curso save(Curso curso) {
        return cursoRepo.save(curso);
    }

    @Override
    public List<Curso> getAllCursos() {
        return cursoRepo.findAll();
    }

    @Override
    public List<Curso> searchByNombre(String nombre) {
        return cursoRepo.findByNombre(nombre);
    }
}
