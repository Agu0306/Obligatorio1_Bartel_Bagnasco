package com.ctc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    //region Objetos y listas
    public static Equipo equipoLocal = new Equipo();
    public static List<Jugador> jugadoresTitularesEquipoLocal = new ArrayList<Jugador>();
    public static List<Jugador> jugadoresSuplentesEquipoLocal = new ArrayList<Jugador>();
    public static Equipo equipoVisitante = new Equipo();
    public static List<Jugador> jugadoresTitularesEquipoVisitante = new ArrayList<Jugador>();
    public static List<Jugador> jugadoresSuplentesEquipoVisitante = new ArrayList<Jugador>();
    public static List<Arbitro> ternaArbitral = new ArrayList<Arbitro>();
    public static List<Jugador> jugadoresExpulsados = new ArrayList<Jugador>();

    //endregion
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        IniciarPartido();

        byte opcion;

        do {
            System.out.println("");
            System.out.println("0- Salir");
            System.out.println("1- Expulsar jugador");
            System.out.println("2- Anotar gol");
            opcion = scan.nextByte();
            switch (opcion) {
                case 0:
                    finalizarPartido();
                    break;
                case 1:
                    expulsarJugador();
                    break;
                case 2:
                    anotarGol();
                    break;
                default:
                    System.out.println("Número fuera de rango. Ingrese otro");
            }
        }
        while (opcion > 0);
    }

    //region Métodos auxiliares equipos
    public static Jugador BuscarJugadorEquipoLocal(byte pNumero) {
        for (byte i = 0; i < jugadoresTitularesEquipoLocal.size(); i++) {
            if (jugadoresTitularesEquipoLocal.get(i).get_numero() == pNumero) {
                return jugadoresTitularesEquipoLocal.get(i);
            }
        }

        for (byte j = 0; j < jugadoresSuplentesEquipoLocal.size(); j++) {
            if (jugadoresSuplentesEquipoLocal.get(j).get_numero() == pNumero) {
                return jugadoresSuplentesEquipoLocal.get(j);
            }
        }
        return null;
    }

    public static Jugador BuscarJugadorEquipoVisitante(byte pNumero) {
        for (byte i = 0; i < jugadoresTitularesEquipoVisitante.size(); i++) {
            if (jugadoresTitularesEquipoVisitante.get(i).get_numero() == pNumero) {
                return jugadoresTitularesEquipoVisitante.get(i);
            }
        }

        for (byte j = 0; j < jugadoresSuplentesEquipoVisitante.size(); j++) {
            if (jugadoresSuplentesEquipoVisitante.get(j).get_numero() == pNumero) {
                return jugadoresSuplentesEquipoVisitante.get(j);
            }
        }
        return null;
    }
    //endregion

    //region Ingresar equipos y arbitros
    public static boolean IngresarEquipoLocal() {
        Scanner scan = new Scanner(System.in);

        String nombre, apellido, puesto, estado, nombreEquipo;
        Byte numero, edad;

        System.out.println("Ingrese nombre del equipo local");
        nombreEquipo = scan.next();

        System.out.println("Ingrese nombre del DT de " + nombreEquipo);
        nombre = scan.next();

        System.out.println("Ingrese apellido del DT de " + nombreEquipo);
        apellido = scan.next();

        System.out.println("Ingrese edad del DT de " + nombreEquipo);
        edad = scan.nextByte();
        Tecnico dt = new Tecnico(nombre, apellido, edad);
        ;

        while (jugadoresTitularesEquipoLocal.size() < 3) {
            System.out.println("Ingrese nombre del jugador titular de " + nombreEquipo);
            nombre = scan.next();

            System.out.println("Ingrese apellido del jugador titular de " + nombreEquipo);
            apellido = scan.next();

            System.out.println("Ingrese puesto del jugador titular de " + nombreEquipo);
            puesto = scan.next();

            System.out.println("Ingrese numero del jugador titular de " + nombreEquipo);
            numero = scan.nextByte();

            System.out.println("Ingrese edad del jugador titular de " + nombreEquipo);
            edad = scan.nextByte();

            estado = "Titular";

            Jugador jugador = new Jugador(nombre, apellido, puesto, numero, edad, estado, (byte) 0);
            if (BuscarJugadorEquipoLocal(jugador.get_numero()) == null) {
                jugadoresTitularesEquipoLocal.add(jugador);
                System.out.println("Ingresado con éxito");
            } else {
                System.out.println("No se pudo ingresar porque el número es repetido");
            }
        }

        while (jugadoresSuplentesEquipoLocal.size() < 1) {
            System.out.println("Ingrese nombre del jugador suplente de " + nombreEquipo);
            nombre = scan.next();

            System.out.println("Ingrese apellido del jugador suplente de " + nombreEquipo);
            apellido = scan.next();

            System.out.println("Ingrese puesto del jugador suplente de " + nombreEquipo);
            puesto = scan.next();

            System.out.println("Ingrese numero del jugador suplente de " + nombreEquipo);
            numero = scan.nextByte();

            System.out.println("Ingrese edad del jugador suplente de " + nombreEquipo);
            edad = scan.nextByte();

            estado = "Suplente";

            Jugador jugador = new Jugador(nombre, apellido, puesto, numero, edad, estado, (byte) 0);
            if (BuscarJugadorEquipoVisitante(jugador.get_numero()) == null) {
                jugadoresSuplentesEquipoLocal.add(jugador);
                System.out.println("Ingresado con éxito");
            } else {
                System.out.println("No se pudo ingresar porque el número es repetido");
            }
        }
        Equipo equipo = new Equipo((byte) 1, nombreEquipo, dt, jugadoresTitularesEquipoLocal, jugadoresSuplentesEquipoLocal);
        equipoLocal = equipo;

        if (jugadoresTitularesEquipoLocal.size() == 3 && jugadoresSuplentesEquipoLocal.size() == 1) {
            return true;
        }
        return false;
    }

    public static boolean IngresarEquipoVisitante() {
        Scanner scan = new Scanner(System.in);

        String nombre, apellido, puesto, estado, nombreEquipo;
        Byte numero, edad;

        System.out.println("Ingrese nombre del equipo visitante");
        nombreEquipo = scan.next();

        System.out.println("Ingrese nombre del DT de " + nombreEquipo);
        nombre = scan.next();

        System.out.println("Ingrese apellido del DT de " + nombreEquipo);
        apellido = scan.next();

        System.out.println("Ingrese edad del DT de " + nombreEquipo);
        edad = scan.nextByte();
        Tecnico dt = new Tecnico(nombre, apellido, edad);
        ;

        while (jugadoresTitularesEquipoVisitante.size() < 3) {
            System.out.println("Ingrese nombre del jugador titular de " + nombreEquipo);
            nombre = scan.next();

            System.out.println("Ingrese apellido del jugador titular de " + nombreEquipo);
            apellido = scan.next();

            System.out.println("Ingrese puesto del jugador titular de " + nombreEquipo);
            puesto = scan.next();

            System.out.println("Ingrese numero del jugador titular de " + nombreEquipo);
            numero = scan.nextByte();

            System.out.println("Ingrese edad del jugador titular de " + nombreEquipo);
            edad = scan.nextByte();

            estado = "Titular";

            Jugador jugador = new Jugador(nombre, apellido, puesto, numero, edad, estado, (byte) 0);
            if (BuscarJugadorEquipoVisitante(jugador.get_numero()) == null) {
                jugadoresTitularesEquipoVisitante.add(jugador);
                System.out.println("Ingresado con éxito");
            } else {
                System.out.println("No se pudo ingresar porque el número es repetido");
            }
        }

        while (jugadoresSuplentesEquipoVisitante.size() < 1) {
            System.out.println("Ingrese nombre del jugador suplente de " + nombreEquipo);
            nombre = scan.next();

            System.out.println("Ingrese apellido del jugador suplente de " + nombreEquipo);
            apellido = scan.next();

            System.out.println("Ingrese puesto del jugador suplente de " + nombreEquipo);
            puesto = scan.next();

            System.out.println("Ingrese numero del jugador suplente de " + nombreEquipo);
            numero = scan.nextByte();

            System.out.println("Ingrese edad del jugador suplente de " + nombreEquipo);
            edad = scan.nextByte();

            estado = "Suplente";

            Jugador jugador = new Jugador(nombre, apellido, puesto, numero, edad, estado, (byte) 0);
            if (BuscarJugadorEquipoVisitante(jugador.get_numero()) == null) {
                jugadoresSuplentesEquipoVisitante.add(jugador);
                System.out.println("Ingresado con éxito");
            } else {
                System.out.println("No se pudo ingresar porque el número es repetido");
            }
            ;
        }
        Equipo equipo = new Equipo((byte) 2, nombreEquipo, dt, jugadoresTitularesEquipoVisitante, jugadoresSuplentesEquipoVisitante);
        equipoVisitante = equipo;

        if (jugadoresTitularesEquipoVisitante.size() == 3 && jugadoresSuplentesEquipoVisitante.size() == 1) {
            return true;
        }
        return false;
    }

    public static boolean IngresarArbitros() {
        Scanner scan = new Scanner(System.in);

        String nombre, apellido, puesto;

        for (byte i = 1; i < 4; i++) {
            System.out.println("Ingrese nombre del arbitro " + i);
            nombre = scan.next();

            System.out.println("Ingrese apellido del arbitro " + i);
            apellido = scan.next();

            System.out.println("Ingrese puesto del arbitro " + i);
            puesto = scan.next();

            Arbitro arbitro = new Arbitro(nombre, apellido, puesto);
            ternaArbitral.add(arbitro);
        }

        if (ternaArbitral.size() == 3) {
            return true;
        }
        return false;
    }
    //endregion

    //region Funciones del partido
    public static boolean IniciarPartido() {
        if (IngresarArbitros() && IngresarEquipoLocal() && IngresarEquipoVisitante()) {
            System.out.println("Iniciando partido");
            System.out.println("Arbitros: ");
            for (Arbitro arbitro : ternaArbitral) {
                System.out.println(arbitro);
            }

            System.out.println("");

            System.out.println("Equipo local: " + equipoLocal.get_nombre());
            System.out.println(equipoLocal.get_tecnico());

            System.out.println("Titulares: ");
            for (byte j = 0; j < equipoLocal.get_listatitulares().size(); j++) {
                System.out.println(equipoLocal.get_listatitulares().get(j).get_numero() + " - " + equipoLocal.get_listatitulares().get(j).get_nombre() + " - " + equipoLocal.get_listatitulares().get(j).get_apellido());
            }

            System.out.println("Suplentes: ");
            for (byte j = 0; j < equipoLocal.get_listasuplentes().size(); j++) {
                System.out.println(equipoLocal.get_listasuplentes().get(j).get_numero() + " - " + equipoLocal.get_listasuplentes().get(j).get_nombre() + " - " + equipoLocal.get_listasuplentes().get(j).get_apellido());
            }

            System.out.println("");

            System.out.println("Equipo visitante: " + equipoVisitante.get_nombre());
            System.out.println(equipoVisitante.get_tecnico());

            System.out.println("Titulares: ");
            for (byte j = 0; j < equipoVisitante.get_listatitulares().size(); j++) {
                System.out.println(equipoVisitante.get_listatitulares().get(j).get_numero() + " - " + equipoVisitante.get_listatitulares().get(j).get_nombre() + " - " + equipoVisitante.get_listatitulares().get(j).get_apellido());
            }

            System.out.println("Suplentes: ");
            for (byte j = 0; j < equipoVisitante.get_listasuplentes().size(); j++) {
                System.out.println(equipoVisitante.get_listasuplentes().get(j).get_numero() + " - " + equipoVisitante.get_listasuplentes().get(j).get_nombre() + " - " + equipoVisitante.get_listasuplentes().get(j).get_apellido());
            }
        } else {
            System.out.println("No se puede iniciar el partido porque falta ingresar datos");
        }
        return false;
    }

    public static void finalizarPartido() {
        System.out.println("Equipo local: " + equipoLocal.get_nombre());
        System.out.println(equipoLocal.get_tecnico());

        System.out.println("Titulares: ");
        for (byte j = 0; j < equipoLocal.get_listatitulares().size(); j++) {
            System.out.println(equipoLocal.get_listatitulares().get(j).get_numero() + " - " + equipoLocal.get_listatitulares().get(j).get_nombre() + " - " + equipoLocal.get_listatitulares().get(j).get_apellido());
        }

        System.out.println("Suplentes: ");
        for (byte j = 0; j < equipoLocal.get_listasuplentes().size(); j++) {
            System.out.println(equipoLocal.get_listasuplentes().get(j).get_numero() + " - " + equipoLocal.get_listasuplentes().get(j).get_nombre() + " - " + equipoLocal.get_listasuplentes().get(j).get_apellido());
        }

        System.out.println("");

        System.out.println("Equipo visitante: " + equipoVisitante.get_nombre());
        System.out.println(equipoVisitante.get_tecnico());

        System.out.println("Titulares: ");
        for (byte j = 0; j < equipoVisitante.get_listatitulares().size(); j++) {
            System.out.println(equipoVisitante.get_listatitulares().get(j).get_numero() + " - " + equipoVisitante.get_listatitulares().get(j).get_nombre() + " - " + equipoVisitante.get_listatitulares().get(j).get_apellido());
        }

        System.out.println("Suplentes: ");
        for (byte j = 0; j < equipoVisitante.get_listasuplentes().size(); j++) {
            System.out.println(equipoVisitante.get_listasuplentes().get(j).get_numero() + " - " + equipoVisitante.get_listasuplentes().get(j).get_nombre() + " - " + equipoVisitante.get_listasuplentes().get(j).get_apellido());
        }

        System.out.println("");
        System.out.println("Jugadores expulsados: ");
        System.out.println(jugadoresExpulsados);

        System.out.println("");
        System.out.println("Goleadores: ");
        System.out.println(equipoLocal.get_nombre() + ":");
        for (byte i = 0; i < equipoLocal.get_listatitulares().size(); i++) {
            for (byte j = 0; j < equipoLocal.get_listasuplentes().size(); j++) {
                if (equipoLocal.get_listatitulares().get(i).getGolesPartido() > 0) {
                    System.out.println("Jugador: " + equipoLocal.get_listatitulares().get(i).get_numero() + " " + equipoLocal.get_listatitulares().get(i).get_nombre() + " " + equipoLocal.get_listatitulares().get(i).get_apellido() + " - Goles: " + equipoLocal.get_listatitulares().get(i).getGolesPartido());
                }
                if(equipoLocal.get_listasuplentes().get(j).getGolesPartido() > 0){
                    System.out.println("Jugador: " + equipoLocal.get_listatitulares().get(j).get_numero() + " " + equipoLocal.get_listatitulares().get(j).get_nombre() + " " + equipoLocal.get_listatitulares().get(j).get_apellido() + " - Goles: " + equipoLocal.get_listatitulares().get(j).getGolesPartido());
                }
            }
        }

        System.out.println(equipoVisitante.get_nombre() + ":");
        for(byte i = 0; i < equipoVisitante.get_listatitulares().size(); i++){
            for(byte j = 0; j < equipoVisitante.get_listasuplentes().size(); j++){
                if(equipoVisitante.get_listatitulares().get(i).getGolesPartido() > 0){
                    System.out.println("Jugador: " + equipoVisitante.get_listasuplentes().get(j).get_numero() + " " + equipoVisitante.get_listatitulares().get(i).get_nombre() + " " + equipoVisitante.get_listatitulares().get(i).get_apellido() + " - Goles: " + equipoVisitante.get_listatitulares().get(i).getGolesPartido());
                }
                if(equipoVisitante.get_listasuplentes().get(j).getGolesPartido() > 0){
                    System.out.println("Jugador: " + equipoVisitante.get_listasuplentes().get(j).get_numero() + " " + equipoVisitante.get_listasuplentes().get(j).get_nombre() + " " + equipoVisitante.get_listasuplentes().get(j).get_apellido() + " - Goles: " + equipoVisitante.get_listasuplentes().get(j).getGolesPartido());
                }
            }
        }
    }

    public static void expulsarJugador() {
        Scanner scan = new Scanner(System.in);
        byte idequipo;
        byte numero;

        System.out.println("Ingrese id de equipo: ");
        System.out.println("1- " + equipoLocal.get_nombre());
        System.out.println("2- " + equipoVisitante.get_nombre());
        idequipo = scan.nextByte();

        System.out.println("Ingrese número del jugador");
        numero = scan.nextByte();

        for (byte j = 0; j < equipoLocal.get_listatitulares().size(); j++) {
            for (byte k = 0; k < equipoLocal.get_listasuplentes().size(); k++) {
                if (equipoLocal.get_id() == idequipo && equipoLocal.get_listatitulares().get(j).get_numero() == numero) {
                    jugadoresExpulsados.add(equipoLocal.get_listatitulares().get(j));
                    equipoLocal.get_listatitulares().remove(equipoLocal.get_listatitulares().get(j));
                } else if (equipoLocal.get_id() == idequipo && equipoLocal.get_listasuplentes().get(k).get_numero() == numero) {
                    jugadoresExpulsados.add(equipoLocal.get_listasuplentes().get(k));
                    equipoLocal.get_listasuplentes().remove(equipoLocal.get_listasuplentes().get(k));
                }
            }
        }

        for (byte j = 0; j < equipoVisitante.get_listatitulares().size(); j++) {
            for (byte k = 0; k < equipoVisitante.get_listasuplentes().size(); k++) {
                if (equipoVisitante.get_id() == idequipo && equipoVisitante.get_listatitulares().get(j).get_numero() == numero) {
                    jugadoresExpulsados.add(equipoVisitante.get_listatitulares().get(j));
                    equipoVisitante.get_listatitulares().remove(equipoVisitante.get_listatitulares().get(j));
                } else if (equipoVisitante.get_id() == idequipo && equipoVisitante.get_listasuplentes().get(k).get_numero() == numero) {
                    jugadoresExpulsados.add(equipoVisitante.get_listasuplentes().get(k));
                    equipoVisitante.get_listasuplentes().remove(equipoVisitante.get_listasuplentes().get(k));
                }
            }
        }
    }

    public static void anotarGol() {
        Scanner scan = new Scanner(System.in);
        byte idequipo;
        byte numero;

        System.out.println("Ingrese id de equipo: ");
        System.out.println("1- " + equipoLocal.get_nombre());
        System.out.println("2- " + equipoVisitante.get_nombre());
        idequipo = scan.nextByte();

        System.out.println("Ingrese número del jugador");
        numero = scan.nextByte();

        for (byte i = 0; i < equipoLocal.get_listatitulares().size(); i++) {
            if (equipoLocal.get_id() == idequipo && equipoLocal.get_listatitulares().get(i).get_numero() == numero) {
                equipoLocal.get_listatitulares().get(i).setGolesPartido((byte) (equipoLocal.get_listatitulares().get(i).getGolesPartido() + 1));
                System.out.println("Gol de jugador " + equipoLocal.get_listatitulares().get(i).get_nombre() + " " + equipoLocal.get_listatitulares().get(i).get_apellido() + " ingresado con éxito.");
            }
        }

        for(byte j = 0; j < equipoVisitante.get_listatitulares().size(); j++){
            if(equipoVisitante.get_id() == idequipo && equipoVisitante.get_listatitulares().get(j).get_numero() == numero){
                equipoVisitante.get_listatitulares().get(j).setGolesPartido((byte) (equipoVisitante.get_listatitulares().get(j).getGolesPartido() + 1));
                System.out.println("Gol de jugador " + equipoVisitante.get_listatitulares().get(j).get_nombre() + " " + equipoVisitante.get_listatitulares().get(j).get_apellido() + " ingresado con éxito.");
            }
        }
    }
    //endregion

}
