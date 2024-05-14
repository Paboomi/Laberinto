package com.mycompany.laberinto.backend.generarlaberintos;

import com.mycompany.laberinto.backend.ListaLaberintos;
import com.mycompany.laberinto.backend.NodoLaberinto;
import com.mycompany.laberinto.backend.bots.ListaBot;
import com.mycompany.laberinto.backend.controlpartida.ObtenerDatosPartida;
import com.mycompany.laberinto.backend.util.ActualizarDatos;
import com.mycompany.laberinto.frontend.casillas.*;
import com.mycompany.laberinto.personajes.Bot;
import com.mycompany.laberinto.personajes.Jugador;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GenerateMazeFromList extends JPanel {

    private int penalizacion;
    private int posX;
    private int posY;
    private JLabel[][] tablero;
    private ListaLaberintos lista;
    private String nombreLaberinto;
    private CasillaSalida salida;
    private CasillaOro oro;
    private ListaBot bots;
    private int oroSalida;
    private Color colorOriginal;
    private ObtenerDatosPartida datosPartida;
    private Jugador jugador;
    private int cantOro;
    private ActualizarDatos observador;

    private Color bgCamino = Color.decode("#D2B48C");
    Color bgOro = Color.decode("#FFBF00");

    public GenerateMazeFromList(ListaLaberintos lista, String nombreLaberinto, Jugador jugador) {
        this.lista = lista;
        this.nombreLaberinto = nombreLaberinto;
        this.jugador = jugador;
        datosPartida = new ObtenerDatosPartida(jugador);
        mostrarTablero();
        //iniciarBots();
        // Agregar KeyListener para manejar los movimientos del jugador
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                moverJugador(e.getKeyCode());
            }
        });
        requestFocusInWindow();
    }

    private void mostrarTablero() {
        removeAll();
        obtenerLaberinto();
        setLayout(new GridLayout(tablero.length, tablero.length));
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                add(tablero[i][j]);

                if (tablero[i][j] instanceof CasillaInicio) {
                    posX = j;
                    posY = i;
                }
            }
        }
        revalidate();
        repaint();
    }

    //Obtenemos el laberinto desde nuestro directorio
    private void obtenerLaberinto() {
        NodoLaberinto actual = lista.getInicio();
        while (!actual.getLaberinto().getNombre().equals(nombreLaberinto)) {
            actual = actual.getSiguiente();
        }
        tablero = actual.getLaberinto().getLaberinto();
        bots = actual.getLaberinto().getBots();
    }

    //Colocamos cada bot en un hilo
    private void iniciarBots() {
        for (int i = 0; i < bots.getSize(); i++) {
            //Obtener el bot de la lista
            Bot botito = bots.getBot(i);
            botito.setMaze(this);
            //Crear un hilo con el bot
            Thread botThread = new Thread(botito);
            botThread.start();
        }
    }

    public void moverJugador(int direccion) {
        colorOriginal = tablero[posY][posX].getBackground();
        int tempX = posX;
        int tempY = posY;
        switch (direccion) {
            case KeyEvent.VK_W:
                tempY--;
                if (tempY < 0 || tablero[tempY][tempX].getBackground().equals(Color.BLACK)) {
                    if (tablero[tempY][tempX].getBackground().equals(Color.BLACK)) {
                        casillaParedEncontrada();
                    }
                    tempY++;
                } else {
                    VerificarTipoCasilla(tempY, tempX);
                }
                break;
            case KeyEvent.VK_A:
                tempX--;
                if (tempX < 0 || tablero[tempY][tempX].getBackground().equals(Color.BLACK)) {
                    if (tablero[tempY][tempX].getBackground().equals(Color.BLACK)) {
                        casillaParedEncontrada();
                    }
                    tempX++;
                } else {
                    VerificarTipoCasilla(tempY, tempX);
                }
                break;
            case KeyEvent.VK_S:
                tempY++;
                if (tempY >= tablero.length || tablero[tempY][tempX].getBackground().equals(Color.BLACK)) {
                    if (tablero[tempY][tempX].getBackground().equals(Color.BLACK)) {
                        casillaParedEncontrada();
                    }
                    tempY--;
                } else {
                    VerificarTipoCasilla(tempY, tempX);
                }
                break;
            case KeyEvent.VK_D:
                tempX++;
                if (tempX >= tablero.length || tablero[tempY][tempX].getBackground().equals(Color.BLACK)) {
                    if (tablero[tempY][tempX].getBackground().equals(Color.BLACK)) {
                        casillaParedEncontrada();
                    }
                    tempX--;
                } else {
                    VerificarTipoCasilla(tempY, tempX);
                }
                break;
        }

//        tablero[posY][posX].setBackground(colorOriginal);
        actualizarPosicion(tempX, tempY);
    }

    private void VerificarTipoCasilla(int tempY, int tempX) {

        Casilla casillaNueva = (Casilla) tablero[tempY][tempX];

        if (casillaNueva instanceof CasillaCamino) {
        } else if (casillaNueva instanceof CasillaSalida) {
            salida = (CasillaSalida) casillaNueva;
            oroSalida = salida.getOro();
            System.out.println(oroSalida);
            notificarCambios();
            if (salida.getOro() == jugador.getOro()) {
                JOptionPane.showMessageDialog(this, "Felicidades has salido del Laberinto");
                setFocusable(false);
            } else {
                JOptionPane.showMessageDialog(this, "No tienes suficiente oro para salir del Laberinto");

            }
        } else if (casillaNueva instanceof CasillaInicio) {
        } else {
            oro = (CasillaOro) casillaNueva;
            cantOro += oro.getOro();
            jugador.setOro(cantOro);
            notificarCambios();
        }
    }

    private void actualizarPosicion(int x, int y) {
        if (tablero[posY][posX] instanceof CasillaCamino) {
            tablero[posY][posX].setBackground(bgCamino);
        } else if (tablero[posY][posX] instanceof CasillaOro) {
            tablero[posY][posX].setBackground(bgCamino);
        } else if (tablero[posY][posX] instanceof CasillaSalida) {
            tablero[posY][posX].setBackground(Color.RED);
        }
        posX = x;
        posY = y;
        tablero[posY][posX].setBackground(Color.GREEN);

    }

    public void moverBot(int x, int y) {
        int botX = x;
        int botY = y;

        actualizarPosicionBot(botX, botY);

    }

    public boolean esCasillaValida(int y, int x) {
        return y >= 0 && y < tablero.length && x >= 0 && x < tablero.length
                && (tablero[y][x] instanceof CasillaCamino || tablero[y][x] instanceof CasillaOro);

    }

    private void actualizarPosicionBot(int botX, int botY) {
        // Verificar si la nueva posición es válida
        if (esCasillaValida(botY, botX)) {
            Color colorOriginaCasilla = tablero[botY][botX].getBackground();
            //Verificamos que el jugador no este en la misma posicion
            if (posX == botX && posY == botY) {
                JOptionPane.showMessageDialog(this, "El Bot te ha atrapado");
                datosPartida.cantVecesAtrapado(1);
            } else {
                // Realizar el movimiento del bot
                tablero[botY][botX].setBackground(Color.PINK);
                tablero[botY][botX].setBackground(colorOriginaCasilla);
            }
        }
    }

    private void casillaParedEncontrada() {
        JOptionPane.showMessageDialog(this, "Movimiento no valido. Obtienes 1 penalización");
        penalizacion = datosPartida.movIncorrectos(1);
        if (penalizacion == 3) {
            JOptionPane.showMessageDialog(this, "El Juego ha terminado. Has llego a 3 penalizaciones");
            setFocusable(false);
        }
    }

    private void notificarCambios() {
        if (observador != null) {
            observador.actualizar();
        }
    }

    public int getOroSalida() {
        return oroSalida;
    }

}
