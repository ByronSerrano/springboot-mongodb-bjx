package com.example.mongodb.repository;

import com.example.mongodb.domain.MesaElectoral;
import org.springframework.data.mongodb.repository.MongoRepository;



import java.util.List;

public interface MesaElectoralPersistence extends MongoRepository<MesaElectoral, Long> {

    List<MesaElectoral> findByNumMesa(Long numMesa);
}