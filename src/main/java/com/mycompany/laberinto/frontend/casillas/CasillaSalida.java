package com.mycompany.laberinto.frontend.casillas;

import java.awt.Color;

/**
 *
 * @author saien
 */
public class CasillaSalida extends Casilla{
    private int oro;
    public CasillaSalida(int id) {
        super(id);
    }

    @Override
    public void setColorFondo() {
        setBackground(Color.RED);
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    @Override
    public void setTexto(String txt) {
    }
    
    
    
}
