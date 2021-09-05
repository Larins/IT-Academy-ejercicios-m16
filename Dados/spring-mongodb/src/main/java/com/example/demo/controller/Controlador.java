package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Jugador;
import com.example.demo.model.Libro;
import com.example.demo.model.Partida;
import com.example.demo.model.Ranking;
import com.example.demo.model.StatsJugador;
import com.example.demo.repository.JugadoresRepo;
import com.example.demo.repository.LibroRepository;
import com.example.demo.repository.PartidasRepo;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class Controlador {
    
    @Autowired
    private JugadoresRepo jugadoresRepo;
    
    @Autowired
    private PartidasRepo partidasRepo;
    
    @PostMapping(value = "/Auth")
    public Jugador isRegister(@RequestBody Jugador user) {
        return null;
    }
    
   	//POST: método para crear cada jugador
    @PostMapping(value = "jugador")
    public ResponseEntity<Jugador> createJugador(@RequestBody Jugador user) {
        Jugador pl = jugadoresRepo.save(user);
        return ResponseEntity.ok(pl);
    }
    
    //PUT: método para modificar atributos de un jugador
    @PutMapping(value = "/jugador/{idUser}")
    public String modifyUser(@PathVariable("idUser") int idUser, @RequestBody Jugador user) {
        if (jugadoresRepo.existsById(idUser)) {
            jugadoresRepo.save(user);
            return "¡Los datos del usuario han sido modificados!";
        } else {
            return "No se han podido modificar los datos del usuario :(";
        }
    }
    
    //POST: método para que un jugador juegue una partida (haga una tirada de dados)
    @PostMapping (value = "/jugadores/{idUser}/partidas")
    public void createPartida(@PathVariable("idUser") int idUser, @RequestBody Partida partida) {
        partida.setIdUser(idUser);
        partidasRepo.save(partida);
    }

    //DELETE: método para eliminar las partidas de un jugador
    @DeleteMapping(value = "/jugador/{idUser}/partidas")
    public String deleteAllGamesOneJugador(@PathVariable("idUser") int idUser) {
        if((jugadoresRepo.findById(idUser)!= null) && (partidasRepo.existsPartidasByIdUser(idUser))) {
            partidasRepo.deletePartidasByIdUser(idUser);
            return "Eliminado todas las partidas del usuario " + idUser;
        } else {     
            return "No hay partidas asociadas al usuario " + idUser;
        }
    }
    
    //GET: método para printar la lista de usuarios, cada uno con con sus estadísticas (porcentaje medio de éxito)    
    @GetMapping(value = "/jugadores")
    public String getAllJugadores() {
    List<StatsJugador> allJugadoresStats = new ArrayList<StatsJugador>();
    List<Jugador> allUsers  = new ArrayList<Jugador>();
    List<Partida> allPartidas  = new ArrayList<Partida>();
    allUsers.addAll(jugadoresRepo.findAll());
    for (Jugador u: allUsers) {
        allPartidas = partidasRepo.findPartidasByIdUser(u.getId());
        allJugadoresStats.add(new StatsJugador(u, allPartidas));
    }
    return allJugadoresStats.toString();
    }
        
    //GET: método para printar las partidas de un jugador en concreto
    @GetMapping(value = "/jugador/{idUser}/partidas")
    public List<Partida> getListGamesOnejugador(@PathVariable("idUser") int idUser) {
        if(jugadoresRepo.findById(idUser)!= null) {
            List<Partida> partidasjugador = partidasRepo.findPartidasByIdUser(idUser);
            return partidasjugador;
        } else {
            return null;
        }
    }

    //GET: método para printar la estadística general (porcentaje medio de éxitos entre todos los jugadores)
	
    
    //GET: método para printar al mejor jugador (con mayor porcentaje medio de éxitos)    
    @GetMapping(value = "/jugador/ranking/peor")
    public List<Jugador> getListAllGamesRankingPeor() {
    List<StatsJugador> allJugadoresStats = new ArrayList<StatsJugador>();
    List<Jugador> allUsers = new ArrayList<Jugador>();
    List<Partida> allPartidas = new ArrayList<Partida>();
    allUsers.addAll(jugadoresRepo.findAll());
    for (Jugador u: allUsers) {
        allPartidas = partidasRepo.findPartidasByIdUser(u.getId());
        allJugadoresStats.add(new StatsJugador(u, allPartidas));
    }
    Ranking ranking = new Ranking(allJugadoresStats);
	return ranking.getRankingUsersPeor();
    }
    
    //GET: método para printar al peor jugador (con menor porcentaje medio de éxitos)
    @GetMapping(value = "/jugador/ranking/mejor")
    public List<Jugador> getListAllGamesRankingMejor() {
    List<StatsJugador> allJugadoresStats = new ArrayList<StatsJugador>();
    List<Jugador> allUsers = new ArrayList<Jugador>();
    List<Partida> allPartidas = new ArrayList<Partida>();
    allUsers.addAll(jugadoresRepo.findAll());
    for (Jugador u: allUsers) {
        allPartidas = partidasRepo.findPartidasByIdUser(u.getId());
        allJugadoresStats.add(new StatsJugador(u, allPartidas));
    }
    Ranking ranking = new Ranking(allJugadoresStats);
    return ranking.getRankingUsersMejor();
    }
   
}



    
