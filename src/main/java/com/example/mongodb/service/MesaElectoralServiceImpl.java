package com.example.mongodb.service;

import com.example.mongodb.domain.MesaElectoral;
import com.example.mongodb.repository.MesaElectoralPersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaElectoralServiceImpl implements MesaElectoralService {
    @Autowired
    private MesaElectoralPersistence mesaRepo;

    @Override
    public MesaElectoral save(MesaElectoral mesaElectoral) {
        return mesaRepo.save(mesaElectoral);
    }

    @Override
    public List<MesaElectoral> getAllMesas() {
        return mesaRepo.findAll();
    }

    @Override
    public List<MesaElectoral> searchNumMesa(Long name) {
        return mesaRepo.findByNumMesa(name);
    }
}
