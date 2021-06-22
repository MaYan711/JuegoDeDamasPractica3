package src.jugadores;

import src.principal.*;
import src.tablero.*;

public class Jugador {

    private String nombre;
    private int puntuacionParcial;
    private int puntuacion;
    private int partidasJugadas;
    private int partidasGanadas;
    private Ficha ficha;
    //private Casilla casilla;


    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 0;
        this.partidasGanadas = 0;

    }

    //public Jugador(){

    //}

    public int getPuntuacionParcial() {
        return puntuacionParcial;
    }

    public void setPuntuacionParcial(int puntuacionParcial) {
        this.puntuacionParcial = puntuacionParcial;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }
}