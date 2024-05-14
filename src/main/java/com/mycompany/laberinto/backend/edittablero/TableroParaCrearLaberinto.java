package com.mycompany.laberinto.backend.edittablero;

import com.mycompany.laberinto.backend.Laberinto;
import com.mycompany.laberinto.backend.ListaLaberintos;
import com.mycompany.laberinto.backend.bots.ListaBot;
import com.mycompany.laberinto.backend.manejararchivos.ArchivoLaberinto;
import com.mycompany.laberinto.frontend.casillas.*;
import com.mycompany.laberinto.personajes.Bot;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TableroParaCrearLaberinto extends JPanel {

    private Casilla[][] casillas;
    private CasillaSalida salida;
    private CasillaOro oro;
    private int cantInicio = 0;
    private ArchivoLaberinto almacenarMaze;
    private ListaBot bots;
    private Random rand = new Random();

    public TableroParaCrearLaberinto(int filas, int columnas) {
        setLayout(new GridLayout(filas, columnas));
        setSize(940, 750);
        setPreferredSize(new Dimension(940, 750));
        //setBackground(Color.GREEN);
        casillas = new Casilla[filas][columnas];
        almacenarMaze = new ArchivoLaberinto();
        bots = new ListaBot();
        iniciarTablero();
    }

    public void iniciarTablero() {
        removeAll();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                casillas[i][j] = new CasillaCamino(1);
                add(casillas[i][j]);
            }
        }
        System.out.println("Tablero Creado");
    }

    private void repintarTablero() {
        removeAll();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                add(casillas[i][j]);
            }
        }
    }

    public void aplicarCasillaOro(int fila, int columna, int id, int cantOro) {
        oro = new CasillaOro(id);
        oro.setOro(cantOro);
        casillas[fila][columna] = oro;
        repintarTablero();
    }

    public void aplicarCasillaSalida(int fila, int columna, int id, int cantOro) {
        salida = new CasillaSalida(id);
        salida.setOro(cantOro);
        casillas[fila][columna] = salida;
        repintarTablero();
    }

    public void aplicarCasillaCamino(int fila, int columna, int id) {
        casillas[fila][columna] = new CasillaCamino(id);
        repintarTablero();
    }

    public void aplicarCasillaPared(int fila, int columna, int id) {
        casillas[fila][columna] = new CasillaPared(id);
        repintarTablero();
    }

    public void aplicarCasillaInicio(int fila, int columna, int id) {
        cantInicio++;
        if (cantInicio <= 1) {
            casillas[fila][columna] = new CasillaInicio(id);
            repintarTablero();
        } else {
            JOptionPane.showMessageDialog(this, "Ya hay una casilla de Inicio");
        }
    }

    public void guardarLaberinto(ListaLaberintos lista, String nombre) {
        Laberinto laberinto = new Laberinto(casillas, nombre);
        laberinto.setBots(bots);
        almacenarMaze.saveNewMazeCreate(lista, nombre, laberinto);
    }
    
    public void guardarBot(int velocidad){
        Bot bot = new Bot();
        bot.setVelocidad(velocidad);
        bot.setSizeMaze(casillas.length);
        bots.addBot(bot);
    }
    

}
