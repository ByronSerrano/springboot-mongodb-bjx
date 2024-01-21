package com.example.mongodb.service;

import com.example.mongodb.domain.MesaElectoral;
import java.util.List;

public interface MesaElectoralService {

    public MesaElectoral save(MesaElectoral mesaElectoral);

    List<MesaElectoral> getAllMesas();

    List<MesaElectoral> searchNumMesa(Long numMesa);

}
