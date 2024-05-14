package com.mycompany.laberinto.backend.bots;

import com.mycompany.laberinto.personajes.Bot;
import java.io.Serializable;

/**
 *
 * @author saien
 */
public class ListaBot implements Serializable {

    private NodoBot inicio;
    private NodoBot fin;
    private int size = 0;

    public ListaBot() {
        
    }
    
    public void addBot(Bot bot){
        NodoBot newBot = new NodoBot(bot);
        
        if (listaVacia()) {
            inicio = newBot;
            fin = newBot;
        }else{
            fin.setSiguiente(newBot);
            fin=newBot;
        }
        size++;
    }
    
    public Bot getBot(int indice){
        
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        NodoBot current = inicio;
        
        for (int i = 0; i < indice; i++) {
            current = current.getSiguiente();
            
        }
        return current.getBot();
    }
    
    private boolean listaVacia(){
        return inicio == null;
    }

    public NodoBot getInicio() {
        return inicio;
    }

    public void setInicio(NodoBot inicio) {
        this.inicio = inicio;
    }

    public NodoBot getFin() {
        return fin;
    }

    public void setFin(NodoBot fin) {
        this.fin = fin;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
}
