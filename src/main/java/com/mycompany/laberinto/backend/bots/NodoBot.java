package com.mycompany.laberinto.backend.bots;

import com.mycompany.laberinto.personajes.Bot;
import java.io.Serializable;

/**
 *
 * @author saien
 */
public class NodoBot implements Serializable{
    private Bot bot;
    private NodoBot siguiente;

    public NodoBot(Bot bot) {
        this.bot = bot;
    }

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public NodoBot getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBot siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
