package com.example.mongodb.api.v1;

import com.example.mongodb.domain.Voto;
import com.example.mongodb.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/voto")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listar() {
        Iterable<Voto> listaVotos = votoService.findAll();
        List<Voto> listaVotosConvertida = new ArrayList<>();
        listaVotos.forEach(listaVotosConvertida::add);
        return new ResponseEntity<>(listaVotosConvertida, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardar(@RequestBody Voto voto) {
        try {
            Voto votoGuardado = votoService.save(voto);
            return new ResponseEntity<>(votoGuardado, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody Voto voto) {
        try {
            Voto votoActualizado = votoService.save(voto);
            return new ResponseEntity<>(votoActualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminar(@RequestBody Voto voto) {
        votoService.deleteById(voto.getId());
        return new ResponseEntity<>("Voto eliminado correctamente", HttpStatus.OK);
    }

    // Puedes agregar más endpoints según tus necesidades

}

