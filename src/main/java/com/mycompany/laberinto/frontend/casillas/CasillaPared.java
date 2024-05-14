package com.mycompany.laberinto.frontend.casillas;

import java.awt.Color;

/**
 *
 * @author saien
 */
public class CasillaPared extends Casilla{

    public CasillaPared(int id) {
        super(id);
    }

    @Override
    public void setColorFondo() {
        setBackground(Color.BLACK);
    }

    @Override
    public void setTexto(String txt) {
    }
    
}
