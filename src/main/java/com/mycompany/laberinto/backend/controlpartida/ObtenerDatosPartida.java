package com.mycompany.laberinto.backend.controlpartida;

import com.mycompany.laberinto.personajes.Jugador;

/**
 *
 * @author saien
 */
public class ObtenerDatosPartida {

    private Partida partida;
    private int movIncoherente;
    private int cantAtrapadas;
    private Jugador jugador;
    private int oroJugador;
    public ObtenerDatosPartida(Jugador jugador) {
        movIncoherente = 0;
        oroJugador = 0;
        this.jugador = jugador;
    }

    public void oroObtenido(int oro) {
        oroJugador += oro;
        jugador.setOro(oroJugador);
    }

    public int movIncorrectos(int cant) {
        movIncoherente += cant;
        return movIncoherente;
    }

    public int cantVecesAtrapado(int cant) {
        cantAtrapadas += cant;
        return cantAtrapadas;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

}
