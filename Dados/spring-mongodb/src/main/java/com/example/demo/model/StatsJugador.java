package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class StatsJugador implements IStatsJugador {
    private Jugador jugador;
    private List<Partida> partidasJugador= new ArrayList<Partida>();
    private double porcentajeExito;
    private double porcentajeFracaso;
    private int totalGanadas;
    private int totalPerdidas;
    private int totalPartidas;
    
    public StatsJugador(Jugador player, List<Partida> partidas){
        this.jugador=jugador;
        this.partidasJugador=partidas;
    }
  
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador player) {
        this.jugador = jugador;
    }

    public int getTotalGanadas() {
        return totalGanadas;
    }

    public void setTotalGanadas(int totalGanadas) {
        this.totalGanadas = totalGanadas;
    }

    public int getTotalPerdidas() {
        return totalPerdidas;
    }

    public void setTotalPerdidas(int totalPerdidas) {
        this.totalPerdidas = totalPerdidas;
    }

    public int getTotalPartidas() {
        return totalPartidas;
    }

    public void setTotalPartidas(int totalPartidas) {
        this.totalPartidas = totalPartidas;
    }

    public List<Partida> getPartidasJugador() {
        return partidasJugador;
    }

    public void setPartidasJugador(List<Partida> partidasJugador) {
        this.partidasJugador = partidasJugador;
    }

    public double getPorcentajeExito() {
        return porcentajeExito;
    }

    public void setPorcentajeExito(double porcentajeExito) {
        this.porcentajeExito = porcentajeExito;
    }

    public double getPorcentajeFracaso() {
        return porcentajeFracaso;
    }

    public void setPorcentajeFracaso(double porcentajeFracaso) {
        this.porcentajeFracaso = porcentajeFracaso;
    }
    
    @Override
    public double getPorcentajeExito(List<Partida> partidas) {
        int totalGanadas=0;
        
        setTotalPartidas(partidas.size());
        
        if(getTotalPartidas()>0){
            for(Partida p:partidas){
                if(p.isResultado()==true){
                    totalGanadas++;
                    setTotalGanadas(totalGanadas);
                }
            }
                double averga=((getTotalGanadas()*100)/getTotalPartidas());
                setPorcentajeExito(averga);
            return getPorcentajeExito(); 
        }else{
            return 0;
        }
       
    }
    
    @Override
    public double getPorcentajeFracaso(List<Partida> partidas) {
         int totalPerdidas=0;
        
        setTotalPartidas(partidas.size());
        
        if(getTotalPartidas()>0){
            for(Partida p:partidas){
                if(p.isResultado()==false){
                    totalPerdidas++;
                    setTotalPerdidas(totalPerdidas);
                }
            }
            double average=((getTotalPerdidas()*100)/getTotalPartidas());
            setPorcentajeFracaso(average);
           return  getPorcentajeFracaso();
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estadísticas del jugador=").append(jugador.getNombre());
        sb.append(", partidas del jugador=").append(getPartidasJugador().toString());
        sb.append(", porcentaje ganadas=").append(getPorcentajeExito(getPartidasJugador()));
        sb.append(", porcentaje perdidas=").append(getPorcentajeFracaso(getPartidasJugador()));
        sb.append(", Total partides jugadess=").append(getTotalPartidas());
        sb.append('}');
        sb.append("\n");
            return sb.toString();
        }

}
