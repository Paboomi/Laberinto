package com.mycompany.laberinto.frontend.casillas;

import java.awt.Color;

/**
 *
 * @author saien
 */
public class CasillaInicio extends Casilla{

    public CasillaInicio(int id) {
        super(id);
    }

    @Override
    public void setColorFondo() {
        setBackground(Color.BLUE);
    }

    @Override
    public void setTexto(String txt) {
    }
    
}
