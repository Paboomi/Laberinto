package com.mycompany.laberinto.frontend.principal;

import com.mycompany.laberinto.backend.Laberinto;
import com.mycompany.laberinto.backend.ListaLaberintos;
import com.mycompany.laberinto.backend.bots.ListaBot;
import com.mycompany.laberinto.backend.manejararchivos.ArchivoLaberinto;
import com.mycompany.laberinto.frontend.casillas.Casilla;
import com.mycompany.laberinto.frontend.casillas.CasillaCamino;
import com.mycompany.laberinto.frontend.casillas.CasillaInicio;
import com.mycompany.laberinto.frontend.casillas.CasillaOro;
import com.mycompany.laberinto.frontend.casillas.CasillaPared;
import com.mycompany.laberinto.frontend.casillas.CasillaSalida;
import com.mycompany.laberinto.personajes.Bot;
import java.io.Serializable;

/**
 *
 * @author saien
 */
public class LaberintoDefault implements Serializable{

    private Casilla[][] casillas = new Casilla[30][30];
    ListaBot bots = new ListaBot();
    ArchivoLaberinto almacenarMaze = new ArchivoLaberinto();
    ListaLaberintos lista = new ListaLaberintos();

    public LaberintoDefault() {
        crearBordes();
        crearSalidas();
        crearCamino();
        crearPared();
        crearCasillaOro();
        crearInicio();
        crearBot();
        guardarLaberinto();
    }

    
    private void crearBordes() {
        //Borde superior
        for (int i = 0; i < 1; i++) {
            casillas[0][i] = new CasillaPared(2);
        }
        //Borde lateral izquierdo y derecho
        for (int i = 0; i < casillas.length; i++) {
            casillas[i][0] = new CasillaPared(2);
            casillas[i][casillas[i].length - 1] = new CasillaPared(2);
        }

        //Borde inferior
        for (int i = 0; i < 1; i++) {
            casillas[casillas.length - 1][i] = new CasillaPared(2);
        }
    }

    private void crearSalidas() {
        casillas[1][0] = new CasillaSalida(4);
        casillas[0][9] = new CasillaSalida(4);
        casillas[1][29] = new CasillaSalida(4);
        casillas[21][29] = new CasillaSalida(4);
        casillas[29][13] = new CasillaSalida(4);
    }

    private void crearCamino() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {

                if (!(casillas[i][j] instanceof CasillaPared) && !(casillas[i][j] instanceof CasillaSalida)) {
                    casillas[i][j] = new CasillaCamino(1);
                }
            }
        }
    }

    private void crearPared() {
        //Fila1
        casillas[1][7] = new CasillaPared(2);
        casillas[1][17] = new CasillaPared(2);
        casillas[1][26] = new CasillaPared(2);
        //Fila 2
        for (int i = 1; i < 6; i++) {
            casillas[2][i] = new CasillaPared(2);
        }
        for (int i = 8; i < 11; i++) {
            casillas[2][i] = new CasillaPared(2);

        }
        for (int i = 12; i < 15; i++) {
            casillas[2][i] = new CasillaPared(2);
        }
        casillas[2][16] = new CasillaPared(2);
        for (int i = 19; i < 25; i++) {
            casillas[2][i] = new CasillaPared(2);
        }
        casillas[2][27] = new CasillaPared(2);
        //Fila 3     
        casillas[3][5] = new CasillaPared(2);
        casillas[3][7] = new CasillaPared(2);
        casillas[3][10] = new CasillaPared(2);
        casillas[3][12] = new CasillaPared(2);
        casillas[3][14] = new CasillaPared(2);
        casillas[3][16] = new CasillaPared(2);
        casillas[3][18] = new CasillaPared(2);
        casillas[3][20] = new CasillaPared(2);

        for (int i = 24; i < 26; i++) {
            casillas[3][i] = new CasillaPared(2);
        }

        //Fila 4
        for (int i = 2; i < 4; i++) {
            casillas[4][i] = new CasillaPared(2);
        }

        casillas[4][5] = new CasillaPared(2);
        casillas[3][10] = new CasillaPared(2);
        casillas[3][12] = new CasillaPared(2);
        casillas[3][14] = new CasillaPared(2);

        for (int i = 16; i < 18; i++) {
            casillas[4][i] = new CasillaPared(2);
        }
        casillas[3][20] = new CasillaPared(2);
        casillas[3][22] = new CasillaPared(2);
        casillas[3][25] = new CasillaPared(2);
        casillas[3][27] = new CasillaPared(2);

        for (int i = 24; i < 26; i++) {
            casillas[3][i] = new CasillaPared(2);
        }

        // Fila 5
        casillas[5][2] = new CasillaPared(2);
        casillas[5][5] = new CasillaPared(2);

        for (int i = 7; i < 13; i++) {
            casillas[5][i] = new CasillaPared(2);
        }
        casillas[5][14] = new CasillaPared(2);
        casillas[5][18] = new CasillaPared(2);
        casillas[5][20] = new CasillaPared(2);
        for (int i = 22; i < 26; i++) {
            casillas[5][i] = new CasillaPared(2);
        }
        casillas[5][27] = new CasillaPared(2);

        //Fila 6
        for (int i = 2; i < 4; i++) {
            casillas[6][i] = new CasillaPared(2);
        }
        casillas[6][10] = new CasillaPared(2);
        casillas[6][12] = new CasillaPared(2);
        casillas[6][22] = new CasillaPared(2);
        casillas[6][27] = new CasillaPared(2);
        casillas[6][28] = new CasillaPared(2);

        //Fila 7
        casillas[7][1] = new CasillaPared(2);
        casillas[7][5] = new CasillaPared(2);
        casillas[7][7] = new CasillaPared(2);
        casillas[7][9] = new CasillaPared(2);
        casillas[7][12] = new CasillaPared(2);
        casillas[7][13] = new CasillaPared(2);
        casillas[7][15] = new CasillaPared(2);
        casillas[7][16] = new CasillaPared(2);
        for (int i = 18; i < 23; i++) {
            casillas[7][i] = new CasillaPared(2);
        }
        casillas[7][24] = new CasillaPared(2);
        casillas[7][26] = new CasillaPared(2);
        casillas[7][27] = new CasillaPared(2);

        //Fila 8
        casillas[8][3] = new CasillaPared(2);
        casillas[8][5] = new CasillaPared(2);
        casillas[8][9] = new CasillaPared(2);
        casillas[7][11] = new CasillaPared(2);
        casillas[7][13] = new CasillaPared(2);
        casillas[7][16] = new CasillaPared(2);
        casillas[7][18] = new CasillaPared(2);
        casillas[7][24] = new CasillaPared(2);
        casillas[7][27] = new CasillaPared(2);

        //Fila 9
        casillas[9][2] = new CasillaPared(2);
        casillas[9][3] = new CasillaPared(2);
        casillas[9][5] = new CasillaPared(2);
        casillas[9][6] = new CasillaPared(2);
        casillas[9][7] = new CasillaPared(2);
        casillas[9][9] = new CasillaPared(2);
        casillas[9][11] = new CasillaPared(2);
        casillas[9][13] = new CasillaPared(2);
        casillas[9][14] = new CasillaPared(2);
        casillas[9][16] = new CasillaPared(2);
        casillas[9][18] = new CasillaPared(2);
        casillas[9][19] = new CasillaPared(2);
        casillas[9][20] = new CasillaPared(2);
        casillas[9][22] = new CasillaPared(2);
        casillas[9][23] = new CasillaPared(2);
        casillas[9][24] = new CasillaPared(2);
        casillas[9][25] = new CasillaPared(2);
        casillas[9][27] = new CasillaPared(2);

        //Fila 10
        casillas[10][5] = new CasillaPared(2);
        casillas[10][7] = new CasillaPared(2);
        casillas[10][9] = new CasillaPared(2);
        casillas[10][11] = new CasillaPared(2);
        casillas[10][13] = new CasillaPared(2);
        casillas[10][16] = new CasillaPared(2);
        casillas[10][20] = new CasillaPared(2);
        casillas[10][23] = new CasillaPared(2);
        casillas[10][25] = new CasillaPared(2);
        casillas[10][27] = new CasillaPared(2);

        //Fila 11
        casillas[11][1] = new CasillaPared(2);
        casillas[11][2] = new CasillaPared(2);
        casillas[11][4] = new CasillaPared(2);
        casillas[11][6] = new CasillaPared(2);
        casillas[11][9] = new CasillaPared(2);
        casillas[11][11] = new CasillaPared(2);
        casillas[11][13] = new CasillaPared(2);
        casillas[11][14] = new CasillaPared(2);
        casillas[11][16] = new CasillaPared(2);
        casillas[11][17] = new CasillaPared(2);
        casillas[11][18] = new CasillaPared(2);
        casillas[11][19] = new CasillaPared(2);
        casillas[11][20] = new CasillaPared(2);
        casillas[11][22] = new CasillaPared(2);
        casillas[11][24] = new CasillaPared(2);
        casillas[11][25] = new CasillaPared(2);
        casillas[11][27] = new CasillaPared(2);

        //Fila 12
        casillas[12][3] = new CasillaPared(2);
        casillas[12][6] = new CasillaPared(2);
        casillas[12][7] = new CasillaPared(2);
        casillas[12][8] = new CasillaPared(2);
        casillas[12][11] = new CasillaPared(2);
        casillas[12][13] = new CasillaPared(2);
        casillas[12][25] = new CasillaPared(2);
        casillas[12][27] = new CasillaPared(2);

        //Fila 13
        casillas[13][1] = new CasillaPared(2);
        casillas[13][3] = new CasillaPared(2);
        casillas[13][4] = new CasillaPared(2);
        casillas[13][6] = new CasillaPared(2);
        casillas[13][9] = new CasillaPared(2);
        casillas[13][11] = new CasillaPared(2);
        casillas[13][15] = new CasillaPared(2);
        casillas[13][17] = new CasillaPared(2);
        casillas[13][18] = new CasillaPared(2);
        casillas[13][20] = new CasillaPared(2);
        casillas[13][23] = new CasillaPared(2);
        casillas[13][25] = new CasillaPared(2);
        casillas[13][27] = new CasillaPared(2);

        //Fila 14
        casillas[14][3] = new CasillaPared(2);
        casillas[14][6] = new CasillaPared(2);
        casillas[14][8] = new CasillaPared(2);
        casillas[14][9] = new CasillaPared(2);
        casillas[14][11] = new CasillaPared(2);
        casillas[14][13] = new CasillaPared(2);
        casillas[14][15] = new CasillaPared(2);
        casillas[14][16] = new CasillaPared(2);
        casillas[14][19] = new CasillaPared(2);
        casillas[14][22] = new CasillaPared(2);
        casillas[14][25] = new CasillaPared(2);
        casillas[14][27] = new CasillaPared(2);

        //Fila 15
        casillas[15][1] = new CasillaPared(2);
        casillas[15][3] = new CasillaPared(2);
        casillas[15][4] = new CasillaPared(2);
        casillas[15][9] = new CasillaPared(2);
        casillas[15][11] = new CasillaPared(2);
        casillas[15][12] = new CasillaPared(2);
        casillas[15][13] = new CasillaPared(2);
        casillas[15][15] = new CasillaPared(2);
        casillas[15][21] = new CasillaPared(2);
        casillas[15][25] = new CasillaPared(2);
        casillas[15][26] = new CasillaPared(2);
        casillas[15][27] = new CasillaPared(2);

        //Fila 16
        casillas[16][3] = new CasillaPared(2);
        casillas[16][6] = new CasillaPared(2);
        casillas[16][8] = new CasillaPared(2);
        casillas[16][9] = new CasillaPared(2);
        casillas[16][12] = new CasillaPared(2);
        casillas[16][15] = new CasillaPared(2);
        casillas[16][17] = new CasillaPared(2);
        casillas[16][18] = new CasillaPared(2);
        casillas[16][19] = new CasillaPared(2);
        casillas[16][20] = new CasillaPared(2);
        casillas[16][21] = new CasillaPared(2);
        casillas[16][23] = new CasillaPared(2);
        casillas[16][25] = new CasillaPared(2);
        casillas[16][27] = new CasillaPared(2);

        //Fila 17
        casillas[17][1] = new CasillaPared(2);
        casillas[17][5] = new CasillaPared(2);
        casillas[17][6] = new CasillaPared(2);
        casillas[17][7] = new CasillaPared(2);
        casillas[17][9] = new CasillaPared(2);
        casillas[17][11] = new CasillaPared(2);
        casillas[17][13] = new CasillaPared(2);
        casillas[17][17] = new CasillaPared(2);
        casillas[17][26] = new CasillaPared(2);
        casillas[17][27] = new CasillaPared(2);

        //Fila 18
        casillas[18][2] = new CasillaPared(2);
        casillas[18][4] = new CasillaPared(2);
        casillas[18][9] = new CasillaPared(2);
        for (int i = 12; i < 25; i++) {
            casillas[18][i] = new CasillaPared(2);

        }

        //Fila 19
        casillas[19][2] = new CasillaPared(2);
        casillas[19][6] = new CasillaPared(2);
        casillas[19][24] = new CasillaPared(2);
        casillas[19][25] = new CasillaPared(2);
        casillas[19][27] = new CasillaPared(2);

        //Fila 20
        for (int i = 2; i < 7; i++) {
            casillas[20][i] = new CasillaPared(2);

        }
        for (int i = 9; i < 23; i++) {
            casillas[20][i] = new CasillaPared(2);
        }

        casillas[20][25] = new CasillaPared(2);
        casillas[20][27] = new CasillaPared(2);
        casillas[20][28] = new CasillaPared(2);

        //Fila 21
        casillas[21][2] = new CasillaPared(2);
        casillas[21][6] = new CasillaPared(2);
        casillas[21][8] = new CasillaPared(2);
        casillas[21][23] = new CasillaPared(2);
        casillas[21][25] = new CasillaPared(2);

        //Fila 22
        casillas[22][4] = new CasillaPared(2);
        casillas[22][6] = new CasillaPared(2);
        casillas[22][9] = new CasillaPared(2);
        casillas[22][23] = new CasillaPared(2);
        for (int i = 11; i < 17; i++) {
            casillas[22][i] = new CasillaPared(2);
        }
        casillas[22][18] = new CasillaPared(2);
        casillas[22][19] = new CasillaPared(2);
        casillas[22][20] = new CasillaPared(2);
        casillas[22][25] = new CasillaPared(2);
        casillas[22][27] = new CasillaPared(2);
        casillas[22][28] = new CasillaPared(2);

        //Fila 23
        for (int i = 1; i < 5; i++) {
            casillas[23][i] = new CasillaPared(2);
        }
        casillas[23][6] = new CasillaPared(2);
        casillas[23][8] = new CasillaPared(2);
        casillas[23][11] = new CasillaPared(2);
        casillas[22][23] = new CasillaPared(2);
        casillas[23][16] = new CasillaPared(2);
        casillas[23][20] = new CasillaPared(2);
        for (int i = 22; i < 26; i++) {
            casillas[23][i] = new CasillaPared(2);
        }
        casillas[23][27] = new CasillaPared(2);

        //Fila 24
        casillas[24][2] = new CasillaPared(2);
        casillas[24][6] = new CasillaPared(2);
        casillas[24][9] = new CasillaPared(2);
        for (int i = 11; i < 15; i++) {
            casillas[24][i] = new CasillaPared(2);
        }
        casillas[24][16] = new CasillaPared(2);
        casillas[24][17] = new CasillaPared(2);
        casillas[24][18] = new CasillaPared(2);
        casillas[24][20] = new CasillaPared(2);
        casillas[24][25] = new CasillaPared(2);

        //Fila 25
        casillas[25][2] = new CasillaPared(2);
        casillas[25][3] = new CasillaPared(2);
        casillas[25][4] = new CasillaPared(2);
        for (int i = 6; i < 10; i++) {
            casillas[25][i] = new CasillaPared(2);
        }
        casillas[25][11] = new CasillaPared(2);
        casillas[25][16] = new CasillaPared(2);
        casillas[25][18] = new CasillaPared(2);
        casillas[25][20] = new CasillaPared(2);
        casillas[25][21] = new CasillaPared(2);
        casillas[25][22] = new CasillaPared(2);
        casillas[25][24] = new CasillaPared(2);
        casillas[25][26] = new CasillaPared(2);
        casillas[25][27] = new CasillaPared(2);

        //Fila 26
        casillas[26][2] = new CasillaPared(2);
        casillas[26][13] = new CasillaPared(2);
        casillas[26][16] = new CasillaPared(2);
        casillas[26][18] = new CasillaPared(2);
        casillas[26][24] = new CasillaPared(2);
        casillas[26][26] = new CasillaPared(2);

        //Fila 27
        for (int i = 2; i < 11; i++) {
            casillas[27][i] = new CasillaPared(2);
        }
        casillas[27][12] = new CasillaPared(2);
        casillas[27][14] = new CasillaPared(2);
        casillas[27][15] = new CasillaPared(2);
        casillas[27][16] = new CasillaPared(2);
        casillas[27][18] = new CasillaPared(2);
        for (int i = 20; i < 24; i++) {
            casillas[27][i] = new CasillaPared(2);
        }
        casillas[27][28] = new CasillaPared(2);

        //Fila 28
        casillas[28][7] = new CasillaPared(2);
        casillas[28][12] = new CasillaPared(2);
        casillas[28][26] = new CasillaPared(2);
    }

    private void crearCasillaOro() {
        //Fila 3
        CasillaOro oro1 = new CasillaOro(5);
        CasillaOro oro2 = new CasillaOro(5);
        CasillaOro oro3 = new CasillaOro(5);
        CasillaOro oro4 = new CasillaOro(5);
        CasillaOro oro5 = new CasillaOro(5);
        oro1.setOro(5);
        oro2.setOro(7);
        oro3.setOro(3);
        oro4.setOro(5);
        oro5.setOro(5);
        casillas[3][4] = oro1;
        casillas[3][8] = oro2;
        casillas[3][9] = oro3;
        casillas[3][13] = oro4;
        casillas[3][17] = oro5;
        
        //Fila 5
        CasillaOro oro6 = new CasillaOro(5);
        oro6.setOro(3);
        casillas[5][1] = oro6;
        
        //Fila 7
        CasillaOro oro7 = new CasillaOro(5);
        oro7.setOro(7);
        casillas[7][28] = oro7;
        
        //Fila 8
        CasillaOro oro8 = new CasillaOro(5);
        oro8.setOro(1);
        casillas[8][28] = oro8;
        
        //Fila 9
        CasillaOro oro9 = new CasillaOro(5);
        oro9.setOro(1);
        casillas[9][26] = oro9;

        //Fila 10
        CasillaOro oro10 = new CasillaOro(5);
        oro10.setOro(2);
        casillas[10][19] = oro10;

        //Fila 11
        CasillaOro oro11 = new CasillaOro(5);
        oro11.setOro(1);
        casillas[11][3] = oro11;

        //Fila 14
        CasillaOro oro12 = new CasillaOro(5);
        oro12.setOro(2);
        casillas[14][12] = oro12;

        //Fila 15
        CasillaOro oro13 = new CasillaOro(5);
        oro13.setOro(1);
        casillas[15][8] = oro13;

        //Fila 16
        CasillaOro oro14 = new CasillaOro(5);
        oro14.setOro(4);
        casillas[16][26] = oro14;

        //Fila 17
        CasillaOro oro15 = new CasillaOro(5);
        oro15.setOro(2);
        casillas[17][18] = oro15;

        //Fila 18
        CasillaOro oro16 = new CasillaOro(5);
        oro16.setOro(5);
        casillas[18][1] = oro16;

        //Fila 19
        CasillaOro oro17 = new CasillaOro(5);
        CasillaOro oro18 = new CasillaOro(5);
        CasillaOro oro19 = new CasillaOro(5);
        CasillaOro oro20 = new CasillaOro(5);
        oro17.setOro(7);
        oro18.setOro(7);
        oro19.setOro(2);
        oro20.setOro(3);
        casillas[19][1] = oro17;
        casillas[19][13] = oro18;
        casillas[19][17] = oro19;
        casillas[19][21] = oro20;
        
        //Fila 23
        CasillaOro oro21 = new CasillaOro(5);
        oro21.setOro(3);
        casillas[23][12] = oro21;

        //Fila 24
        CasillaOro oro22 = new CasillaOro(5);
        oro22.setOro(3);
        casillas[24][8] = oro22;

        //Fila 25
        CasillaOro oro23 = new CasillaOro(5);
        CasillaOro oro24 = new CasillaOro(5);
        oro23.setOro(9);
        oro24.setOro(5);
        casillas[25][17] = oro23;
        casillas[25][25] = oro24;

        //Fila 28
        CasillaOro oro25 = new CasillaOro(5);
        CasillaOro oro26 = new CasillaOro(5);
        oro25.setOro(8);
        oro26.setOro(10);
        casillas[28][6] = oro25;
        casillas[28][28] = oro26;

        
    }
    
    private void crearInicio(){
        casillas[12][1] = new CasillaInicio(3);
    }
    
    private void crearBot(){
        for (int i = 0; i <=5; i++) {
            Bot bot = new Bot();
            bot.setVelocidad(i);
            bot.setSizeMaze(casillas.length);
            bots.addBot(bot);
        }
    }
    
    private void guardarLaberinto(){
        Laberinto laberinto = new Laberinto(casillas, "Default");
        laberinto.setBots(bots);
        almacenarMaze.saveNewMazeCreate(lista, "Default", laberinto);
    }
}
