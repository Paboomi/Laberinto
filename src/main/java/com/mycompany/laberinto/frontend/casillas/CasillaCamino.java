package com.mycompany.laberinto.frontend.casillas;

import java.awt.Color;

/**
 *
 * @author saien
 */
public class CasillaCamino extends Casilla{

    public CasillaCamino(int id) {
        super(id);
    }

    @Override
    public void setColorFondo() {
        Color backgroundColor = Color.decode("#D2B48C");
        setBackground(backgroundColor);
    }

    @Override
    public void setTexto(String txt) {
        setText(txt);
    }

    
}
