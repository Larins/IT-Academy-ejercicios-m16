package com.example.demo.model;
import java.util.List;

public interface IStatsJugador {
    double getPorcentajeExito(List<Partida> partidas);
    double getPorcentajeFracaso(List<Partida> partidas);
}
