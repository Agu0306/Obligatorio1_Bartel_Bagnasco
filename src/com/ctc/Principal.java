package com.ctc;
import com.ctc.Metodos.*;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Metodo.IniciarPartido();

        byte opcion;

        do {
            System.out.println("");
            System.out.println("0- Salir");
            System.out.println("1- Expulsar jugador");
            System.out.println("2- Anotar gol");
            System.out.println("3- Cambiar jugador");
            opcion = scan.nextByte();
            switch (opcion) {
                case 0:
                    Metodo.finalizarPartido();
                    break;
                case 1:
                    Metodo.expulsarJugador();
                    break;
                case 2:
                    Metodo.anotarGol();
                    break;
                case 3:
                    Metodo.cambiarJugador();
                    break;
                default:
                    System.out.println("Número fuera de rango. Ingrese otro");
            }
        }
        while (opcion > 0);
    }
}
