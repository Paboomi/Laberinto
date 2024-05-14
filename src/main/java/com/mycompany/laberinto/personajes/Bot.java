package com.mycompany.laberinto.personajes;

import com.mycompany.laberinto.backend.generarlaberintos.GenerateMazeFromList;
import java.io.Serializable;
import java.util.Random;

public class Bot implements Runnable, Serializable {

    private GenerateMazeFromList maze;
    private int velocidad;
    private int sizeMaze;
    private Random rand = new Random();

    public Bot() {
    }

    @Override
    public void run() {
        while (true) {
            movimientoBot();
            try {
                Thread.sleep(1000 * velocidad);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Metodo para generar los movimientos
    private void movimientoBot() {
        int y, x;

        do {

            y = numeroAleatorio();
            x = numeroAleatorio();
        } while (!maze.esCasillaValida(y, x));
        maze.moverBot(y, x);
    }

    private int numeroAleatorio() {
        return rand.nextInt(sizeMaze);
    }

    public GenerateMazeFromList getMaze() {
        return maze;
    }

    public void setMaze(GenerateMazeFromList maze) {
        this.maze = maze;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getSizeMaze() {
        return sizeMaze;
    }

    public void setSizeMaze(int sizeMaze) {
        this.sizeMaze = sizeMaze;
    }

}
