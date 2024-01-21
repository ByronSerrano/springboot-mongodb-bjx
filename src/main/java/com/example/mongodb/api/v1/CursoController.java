package com.example.mongodb.api.v1;

import com.example.mongodb.domain.Curso;
import com.example.mongodb.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> create(@RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.save(curso), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getAll() {
        List<Curso> cursoList = cursoService.getAllCursos();
        return new ResponseEntity<>(cursoList, HttpStatus.OK);
    }

    @GetMapping("nombre/{nombre}")
    public ResponseEntity<List<Curso>> searchByNombre(@PathVariable("nombre") String nombre) {
        List<Curso> cursoList = cursoService.searchByNombre(nombre);
        return new ResponseEntity<>(cursoList, HttpStatus.OK);
    }
}
