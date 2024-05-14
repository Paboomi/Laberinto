package com.mycompany.laberinto.backend.manejararchivos;

import com.mycompany.laberinto.backend.Laberinto;
import com.mycompany.laberinto.backend.ListaLaberintos;
import com.mycompany.laberinto.backend.NodoLaberinto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

public class ArchivoLaberinto {

//    private static final String DIRE_PATH = "com/mycompany/login/files";
    private static final String DIRE_PATH = "/mnt/datos/JAVA/PROYECTO 2 IPC1 2024/Laberinto/Laberintos";
    private static final String PREFIX_PATH = "Laberinto.obj";

    public void saveNewMaze(ListaLaberintos lista, String nombre, Laberinto laberinto) {

        NodoLaberinto actual = lista.getInicio();
        boolean nombreExiste = false;
        while (actual != null) {
            if (actual.getLaberinto().getNombre().equals(nombre)) {
                nombreExiste = true;
                break;
            }

            actual = actual.getSiguiente();
        }
        if (nombreExiste) {
            System.out.println("Ya existe un laberinto con este nombre");
        } else {
            int i = 0;
            lista.addLaberinto(laberinto);
            actual = lista.getInicio();
            while (actual != null) {
                String nombreArchivo = DIRE_PATH + "/" + i + PREFIX_PATH;
                saveFile(actual.getLaberinto(), nombreArchivo);
                i++;

            }
            System.out.println("El archivo se ha guardado");
        }

    }

    public void saveNewMazeCreate(ListaLaberintos lista, String nombre, Laberinto laberinto) {
        NodoLaberinto actual = lista.getInicio();
        boolean nombreExiste = false;
        while (actual != null) {
            if (actual.getLaberinto().getNombre().equals(nombre)) {
                nombreExiste = true;
                break;
            }

            actual = actual.getSiguiente();
        }
        if (nombreExiste) {
            System.out.println("Ya existe un laberinto con este nombre");
        } else {
            lista.addLaberinto(laberinto);
            String nombreArchivo = DIRE_PATH+"/"+LocalDateTime.now() +"_"+ PREFIX_PATH;
            saveFile(laberinto, nombreArchivo);

            System.out.println("El archivo se ha guardado");
        }
    }

    public void deleteFile() {

    }

    private void saveFile(Laberinto laberinto, String nameFile) {
        File fileBin = new File(nameFile);
        try (FileOutputStream fileOutput = new FileOutputStream(fileBin); ObjectOutputStream objectStream = new ObjectOutputStream(fileOutput)) {
            objectStream.writeObject(laberinto);
            System.out.println("Archivo guardado con exito");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se ha guardado el archivo");
        }
    }

    public ListaLaberintos cargarLaberintos() {
        ListaLaberintos listaLaberintos = new ListaLaberintos();

        File directorio = new File(DIRE_PATH);
        File[] archivos = directorio.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(".obj")) {
                    try (FileInputStream fileInput = new FileInputStream(archivo); ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {

                        Laberinto laberinto = (Laberinto) objectInput.readObject();
                        listaLaberintos.addLaberinto(laberinto);

                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                        System.out.println("Error al cargar el laberinto desde el archivo: " + archivo.getName());
                    }
                }
            }
        }

        return listaLaberintos;
    }
}
