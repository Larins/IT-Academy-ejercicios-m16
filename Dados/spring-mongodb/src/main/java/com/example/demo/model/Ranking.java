package com.example.demo.model;


import java.util.ArrayList;
import java.util.List;

public class Ranking {
    private List<StatsJugador> listaestadistca;
    private List<Jugador> rankingUsersMejor;
    private List<Jugador> rankingUsersPeor;

    public Ranking(List<StatsJugador> listaestadistca) {
        this.listaestadistca = listaestadistca;
    }

    public List<StatsJugador> getListaestadistca() {
        return listaestadistca;
    }

    public void setListaestadistca(List<StatsJugador> listaestadistca) {
        this.listaestadistca = listaestadistca;
    }

    public List<Jugador> getRankingUsersMejor() {
        StatsJugador auxUser;
        List<Jugador> auxList = new ArrayList<Jugador>();

        for (int i = 0; i < listaestadistca.size() - 1; i++) {
            for (int j = i + 1; j < listaestadistca.size() - 1; j++) {
                // he de comparar el elemento actual con el siguiente
                if (listaestadistca.get(i).getPorcentajeExito() < listaestadistca.get(j).getPorcentajeExito()) {
                    auxUser = listaestadistca.get(i);
                    this.listaestadistca.set(i, this.listaestadistca.get(j));
                    this.listaestadistca.set(j, auxUser);

                }
            }
        }

        for (StatsJugador sp : listaestadistca) {
            if (sp.getPorcentajeExito() != 0) {
                auxList.add(sp.getJugador());
            }
        }

        setRankingUsersPeor(auxList);
        return auxList;
    }

    public void setRankingUsersMejor(List<Jugador> rankingUsersMejor) {
        this.rankingUsersMejor = rankingUsersMejor;
    }

    public List<Jugador> getRankingUsersPeor() {
        StatsJugador auxUser;
        List<Jugador> auxList = new ArrayList<Jugador>();

        if (listaestadistca != null) {
            for (int i = 0; i < listaestadistca.size() - 1; i++) {
                for (int j = i + 1; j < listaestadistca.size() - 1; j++) {
                    // he de comparar el elemento actual con el siguiente
                    if (listaestadistca.get(i).getPorcentajeFracaso() < listaestadistca.get(j).getPorcentajeFracaso()) {
                        auxUser = listaestadistca.get(i);
                        this.listaestadistca.set(i, this.listaestadistca.get(j));
                        this.listaestadistca.set(j, auxUser);
                    }
                }
            }
            setListaestadistca(listaestadistca);
        }

        for (StatsJugador sp : getListaestadistca()) {
            if (sp.getPorcentajeFracaso() != 0) {
                auxList.add(sp.getJugador());
            }
        }
        setRankingUsersPeor(auxList);
        return auxList;
    }

    public void setRankingUsersPeor(List<Jugador> rankingUsersPeor) {
        this.rankingUsersPeor = rankingUsersPeor;
    }

}
