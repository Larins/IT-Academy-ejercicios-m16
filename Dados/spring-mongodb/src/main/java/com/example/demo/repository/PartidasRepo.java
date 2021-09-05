package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Partida;


public interface PartidasRepo extends MongoRepository<Partida, Integer>{
	List<Partida> findPartidasByIdUser( int idUser);
    boolean existsPartidasByIdUser(int idUser);
    int deletePartidasByIdUser( int idUser);

}
