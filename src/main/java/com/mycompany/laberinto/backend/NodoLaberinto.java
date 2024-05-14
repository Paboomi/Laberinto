package com.mycompany.laberinto.backend;


/**
 *
 * @author saien
 */
public class NodoLaberinto {
    private Laberinto laberinto;
    private NodoLaberinto siguiente;

    public NodoLaberinto(Laberinto laberinto) {
        this.laberinto = laberinto;
    }
    
    
    //Getters y setters

    public Laberinto getLaberinto() {
        return laberinto;
    }

    public void setLaberinto(Laberinto laberinto) {
        this.laberinto = laberinto;
    }

    public NodoLaberinto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLaberinto siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
