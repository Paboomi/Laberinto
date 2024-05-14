package com.mycompany.laberinto.frontend.casillas;

import java.awt.Color;

/**
 *
 * @author saien
 */
public class CasillaOro extends Casilla {
    private int oro;
    public CasillaOro(int id) {
        super(id);
    }

    @Override
    public void setColorFondo() {
        Color backgroundColor = Color.decode("#FFBF00");
        setBackground(backgroundColor);
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    @Override
    public void setTexto(String txt) {
        setText(txt);
        setForeground(Color.BLACK);
        setHorizontalTextPosition(CENTER);
    }
    
    
}
