package com.example.mongodb.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.mongodb.domain.Estudiante;
import com.example.mongodb.service.EstudianteService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTodo() {
        List<Estudiante> listaEstudiantes = estudianteService.findAll();
        return new ResponseEntity<>(listaEstudiantes, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> guardar(@RequestBody Estudiante estudiante) {
        Estudiante estudianteGuardado = estudianteService.save(estudiante);
        return new ResponseEntity<>(estudianteGuardado, HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody Estudiante estudiante) {
        Estudiante estudianteActualizado = estudianteService.save(estudiante);
        return new ResponseEntity<>(estudianteActualizado, HttpStatus.OK);
    }

    @GetMapping(value = "id/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> buscarPorId(@Valid @PathVariable("id") String id) {
        Optional<Estudiante> estudiante = estudianteService.findById(id);
        return estudiante.map(value -> new ResponseEntity<>((Object) value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>("Estudiante no encontrado", HttpStatus.NOT_FOUND));
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> eliminar(@PathVariable("id") String id) {
        estudianteService.deleteById(id);
        return new ResponseEntity<>("Estudiante eliminado correctamente", HttpStatus.OK);
    }

    @GetMapping(value = "/firma/{firmaAsistencia}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> buscarPorFirmaAsistencia(@PathVariable("firmaAsistencia") Boolean firmaAsistencia) {
        List<Estudiante> estudiantes = estudianteService.buscarPorFirmaAsistencia(firmaAsistencia);
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }
}


