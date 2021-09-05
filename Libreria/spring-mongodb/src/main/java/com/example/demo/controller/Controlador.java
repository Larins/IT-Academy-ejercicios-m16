package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Libro;
import com.example.demo.repository.LibroRepository;

@RestController
public class Controlador {

	@Autowired
	private LibroRepository repositorio;

	@PostMapping("/inserta") //localhost:8080/inserta
	public String saveBook(@RequestBody Libro libro) {
		repositorio.save(libro);
		return "Insertado libro: " + libro.getId() + " - " + libro.getNombre();
 	}

 	@GetMapping("/") //localhost:8080/
 	public List<Libro> getBooks() {
 		List<Libro> lista = repositorio.findAll();
 		return lista;
 	}

}
