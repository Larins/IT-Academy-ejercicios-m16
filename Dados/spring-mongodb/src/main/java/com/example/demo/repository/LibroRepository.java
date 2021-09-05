package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Libro;

public interface LibroRepository extends MongoRepository<Libro, Integer> {

}
