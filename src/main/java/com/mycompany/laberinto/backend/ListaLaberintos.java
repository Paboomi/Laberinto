package com.mycompany.laberinto.backend;

import com.mycompany.laberinto.backend.manejararchivos.ArchivoLaberinto;
import java.util.List;
import java.io.Serializable;

/**
 *
 * @author saien
 */
public class ListaLaberintos implements Serializable{
    private NodoLaberinto inicio;
    private NodoLaberinto fin;
    ArchivoLaberinto filesLaberinto;
    private int size=0;

    public ListaLaberintos() {
        filesLaberinto = new ArchivoLaberinto();
    }
    
    
    
    //Metodo para agregar un laberinto a la lista
    
    public void addLaberinto(Laberinto laberinto){
        NodoLaberinto newMaze = new NodoLaberinto(laberinto);
        
        if (listaVacia()) {
            inicio = newMaze;
            fin = newMaze;
        }else{
            fin.setSiguiente(newMaze);
            fin = newMaze;
        }
        size++;
    }
    
    public void deleteLaberinto(){
        
    }
    
    
    
    // Método para cargar laberintos desde archivos binarios y agregarlos a la lista
    public void cargarLaberintosDesdeArchivos() {
        // Llama al método para cargar los laberintos desde archivos binarios
        // y obtiene la lista de laberintos
        ListaLaberintos laberintos = (ListaLaberintos) filesLaberinto.cargarLaberintos();

        // Agrega cada laberinto a la lista
        NodoLaberinto actual= laberintos.getInicio();
        while (actual != null) {
            addLaberinto(actual.getLaberinto());
            actual = actual.getSiguiente();
        }
    }

    
    private boolean listaVacia(){
        return inicio == null;
    }

    public NodoLaberinto getInicio() {
        return inicio;
    }

    public void setInicio(NodoLaberinto inicio) {
        this.inicio = inicio;
    }

    public NodoLaberinto getFin() {
        return fin;
    }

    public void setFin(NodoLaberinto fin) {
        this.fin = fin;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
}
