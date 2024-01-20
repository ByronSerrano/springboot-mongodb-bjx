package com.example.mongodb.api.v1;

import com.example.mongodb.domain.Pais;
import com.example.mongodb.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pais")
public class PaisController {

	@Autowired
	private PaisService paisService;

	@PostMapping
	public ResponseEntity<Pais> create(@RequestBody Pais pais) {
		return new ResponseEntity<>(paisService.save(pais), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Pais>> getAll() {
		List<Pais> paisEntityList = paisService.getAllPais();
		return new ResponseEntity<>(paisEntityList, HttpStatus.OK);
	}

	@GetMapping("{name}/archivo/name")
	public ResponseEntity<List<Pais>> search(@PathVariable("name") String name) {
		List<Pais> paisList = paisService.searchPais(name);
		return new ResponseEntity<>(paisList, HttpStatus.OK);
	}
}
