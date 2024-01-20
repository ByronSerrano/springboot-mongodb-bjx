package com.example.mongodb.api.v1;

import com.example.mongodb.domain.MesaElectoral;
import com.example.mongodb.service.MesaElectoralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mesa")
public class MesaElectoralController {

    @Autowired
    private MesaElectoralService mesaService;

    @PostMapping
    public ResponseEntity<MesaElectoral> create(@RequestBody MesaElectoral mesaElectoral) {
        return new ResponseEntity<>(mesaService.save(mesaElectoral), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MesaElectoral>> getAll() {
        List<MesaElectoral> paisEntityList = mesaService.getAllMesas();
        return new ResponseEntity<>(paisEntityList, HttpStatus.OK);
    }

    @GetMapping("numMesa/{numMesa}")
    public ResponseEntity<List<MesaElectoral>> search(@PathVariable("numMesa") Long numMesa) {
        List<MesaElectoral> mesaList = mesaService.searchNumMesa(numMesa);
        return new ResponseEntity<>(mesaList, HttpStatus.OK);
    }
}
