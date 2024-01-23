package com.example.mongodb.api.v1;

import com.example.mongodb.domain.Estudiante;
import com.example.mongodb.domain.Voto;
import com.example.mongodb.service.EstudianteService;
import com.example.mongodb.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/voto")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @Autowired
    private EstudianteService estudianteService;

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
            //Change firmaAsistencia
            Estudiante estudiante = voto.getEstudiante();
            estudiante.setFirmaAsistencia(true);
            //save in Estudiante
            estudianteService.save(estudiante);
            //save the Vote
            Voto votoResult = votoService.save(voto);
            return new ResponseEntity<>(votoResult, HttpStatus.CREATED);
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

    //Total Votes per Candidate
    @GetMapping(value = "/votosPorCandidato", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerVotosPorCandidato() {
        Map<String, Long> votosPorCandidato = votoService.obtenerVotosPorCandidato();
        return new ResponseEntity<>(votosPorCandidato, HttpStatus.OK);
    }

    //Total Votes per Candidate and Mesa
    /*
    @GetMapping(value = "/votosPorCandidatoYMesa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerVotosPorCandidatoYMesa() {
        List<HashMap> votosPorCandidatoYMesa = votoService.obtenerVotosPorCandidatoYMesa();
        return new ResponseEntity<>(votosPorCandidatoYMesa, HttpStatus.OK);
    }

     */

    @GetMapping(value = "/votosPorCandidatoYMesa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerVotosPorCandidatoYMesa() {
        List<HashMap> votosPorCandidatoYMesa = votoService.obtenerVotosPorCandidatoYMesa();
        return new ResponseEntity<>(votosPorCandidatoYMesa, HttpStatus.OK);
    }


}

