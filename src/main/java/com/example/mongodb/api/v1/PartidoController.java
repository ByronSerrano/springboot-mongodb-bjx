package com.example.mongodb.api.v1;

import com.example.mongodb.domain.Partido;
import com.example.mongodb.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/partido")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardar(@Valid @RequestBody Partido partido) {
        try {
            Partido partidoGuardado = partidoService.save(partido);
            return new ResponseEntity<>(partidoGuardado, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTodo() {
        Iterable<Partido> listaPartidos = partidoService.findAll();
        List<Partido> partidoList = new ArrayList<>();
        listaPartidos.forEach(partidoList::add);
        return new ResponseEntity<>(partidoList, HttpStatus.OK);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@Valid @RequestBody Partido partido) {
        try {
            Partido partidoActualizado = partidoService.save(partido);
            return new ResponseEntity<>(partidoActualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarPorId(@Valid @PathVariable("id") String id) {
        Optional<Partido> partido = partidoService.find(id);
        return partido.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/candidato/{candidato}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> buscarPorCandidato(@Valid @PathVariable("candidato") String candidato) {
        Optional<Partido> partido = partidoService.buscarPorCandidato(candidato);
        return partido.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminar(@Valid @PathVariable("id") String id) {
        partidoService.delete(id);
        return new ResponseEntity<>("Partido eliminado correctamente", HttpStatus.OK);
    }
}


