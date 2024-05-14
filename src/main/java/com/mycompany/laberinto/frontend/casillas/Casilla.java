package com.mycompany.laberinto.frontend.casillas;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author saien
 */
public abstract class Casilla extends JLabel{
    private int id;

    public Casilla(int id) {
        this.id = id;
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setColorFondo();
    }
    
    public abstract void setColorFondo();
    public abstract void setTexto(String txt);
    
}
