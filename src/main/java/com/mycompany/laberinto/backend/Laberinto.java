package com.mycompany.laberinto.backend;

import com.mycompany.laberinto.backend.bots.ListaBot;
import java.io.Serializable;
import javax.swing.JLabel;

public class Laberinto implements Serializable{
    private JLabel[][] laberinto;
    private String nombre;
    private int oro;
    private ListaBot bots;

    public Laberinto(JLabel[][] maze, String name) {
        this.laberinto = maze;
        this.nombre = name;
    }

    
    public JLabel[][] getLaberinto() {
        return laberinto;
    }

    public void setLaberinto(JLabel[][] laberinto) {
        this.laberinto = laberinto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public ListaBot getBots() {
        return bots;
    }

    public void setBots(ListaBot bots) {
        this.bots = bots;
    }
}
