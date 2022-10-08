package com.ctc.Metodos;

import com.ctc.Clases.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metodo {
    //region Objetos y listas
    public static Partido partido = new Partido();
    public static Equipo equipoLocal = new Equipo();
    public static List<Jugador> jugadoresEquipoLocal = new ArrayList<>();
    public static List<Jugador> jugadoresTitularesEquipoLocal = new ArrayList<>();
    public static List<Jugador> jugadoresSuplentesEquipoLocal = new ArrayList<>();
    public static Equipo equipoVisitante = new Equipo();
    public static List<Jugador> jugadoresEquipoVisitante = new ArrayList<>();
    public static List<Jugador> jugadoresTitularesEquipoVisitante = new ArrayList<>();
    public static List<Jugador> jugadoresSuplentesEquipoVisitante = new ArrayList<>();
    public static List<Arbitro> ternaArbitral = new ArrayList<>();
    public static List<Jugador> jugadoresExpulsados = new ArrayList<>();

    //endregion

    //region Métodos auxiliares equipos
    public static Jugador BuscarJugadorEquipoLocal(byte pNumero) {
        for (Jugador jugador : jugadoresEquipoLocal) {
            if (jugador.get_numero() == pNumero) {
                return jugador;
            }
        }
        return null;
    }
    public static Jugador BuscarJugadorEquipoVisitante(byte pNumero) {
        for (Jugador jugador : jugadoresEquipoVisitante) {
            if (jugador.get_numero() == pNumero) {
                return jugador;
            }
        }
        return null;
    }
    //endregion

    //region Ingresar equipos, arbitros y datos del partido
    public static boolean IngresarEquipoLocal() {
        Scanner scan = new Scanner(System.in);

        String nombre, apellido, puesto, estado, nombreEquipo;
        byte numero, edad;

        System.out.println("Ingrese nombre del equipo local");
        nombreEquipo = scan.next();

        System.out.println("Ingrese nombre del DT de " + nombreEquipo);
        nombre = scan.next();

        System.out.println("Ingrese apellido del DT de " + nombreEquipo);
        apellido = scan.next();

        System.out.println("Ingrese edad del DT de " + nombreEquipo);
        edad = scan.nextByte();
        Tecnico dt = new Tecnico(nombre, apellido, edad);

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

            Jugador jugador = new Jugador(nombre, apellido, puesto, numero, edad, estado, (byte) 0, true);
            if (BuscarJugadorEquipoLocal(jugador.get_numero()) == null) {
                jugadoresEquipoLocal.add(jugador);
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

            Jugador jugador = new Jugador(nombre, apellido, puesto, numero, edad, estado, (byte) 0, true);
            if (BuscarJugadorEquipoLocal(jugador.get_numero()) == null) {
                jugadoresEquipoLocal.add(jugador);
                jugadoresSuplentesEquipoLocal.add(jugador);
                System.out.println("Ingresado con éxito");
            } else {
                System.out.println("No se pudo ingresar porque el número es repetido");
            }
        }
        equipoLocal = new Equipo((byte) 1, nombreEquipo, dt, jugadoresTitularesEquipoLocal, jugadoresSuplentesEquipoLocal, jugadoresEquipoLocal);

        if (jugadoresTitularesEquipoLocal.size() == 3 && jugadoresSuplentesEquipoLocal.size() == 1) {
            return true;
        }
        return false;
    }
    public static boolean IngresarEquipoVisitante() {
        Scanner scan = new Scanner(System.in);

        String nombre, apellido, puesto, estado, nombreEquipo;
        byte numero, edad;

        System.out.println("Ingrese nombre del equipo visitante");
        nombreEquipo = scan.next();

        System.out.println("Ingrese nombre del DT de " + nombreEquipo);
        nombre = scan.next();

        System.out.println("Ingrese apellido del DT de " + nombreEquipo);
        apellido = scan.next();

        System.out.println("Ingrese edad del DT de " + nombreEquipo);
        edad = scan.nextByte();
        Tecnico dt = new Tecnico(nombre, apellido, edad);

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

            Jugador jugador = new Jugador(nombre, apellido, puesto, numero, edad, estado, (byte) 0, true);
            if (BuscarJugadorEquipoVisitante(jugador.get_numero()) == null) {
                jugadoresEquipoVisitante.add(jugador);
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

            Jugador jugador = new Jugador(nombre, apellido, puesto, numero, edad, estado, (byte) 0, true);
            if (BuscarJugadorEquipoVisitante(jugador.get_numero()) == null) {
                jugadoresEquipoVisitante.add(jugador);
                jugadoresSuplentesEquipoVisitante.add(jugador);
                System.out.println("Ingresado con éxito");
            } else {
                System.out.println("No se pudo ingresar porque el número es repetido");
            }
        }
        equipoVisitante = new Equipo((byte) 2, nombreEquipo, dt, jugadoresTitularesEquipoVisitante, jugadoresSuplentesEquipoVisitante, jugadoresEquipoVisitante);

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
    public static Partido IngresarDatosPartido(){
        Scanner scan = new Scanner(System.in);

        String estadio, fecha, hora, clima;
        int minutos = 0;

        System.out.println("Ingrese estadio");
        estadio = scan.nextLine();

        System.out.println("Ingrese fecha");
        fecha = scan.next();

        System.out.println("Ingrese hora");
        hora = scan.next();

        System.out.println("Ingrese clima");
        clima = scan.next();

        partido = new Partido(estadio, fecha, hora, clima, minutos);

        return partido;
    }
    //endregion

    //region Funciones del partido
    public static void IniciarPartido() {
        System.out.println("Iniciando partido");
        System.out.println("");
        if (IngresarDatosPartido() != null && IngresarArbitros() && IngresarEquipoLocal() && IngresarEquipoVisitante()) {
            System.out.println("Iniciando partido");
            System.out.println("Arbitros: ");
            for (Arbitro arbitro : ternaArbitral) {
                System.out.println(arbitro);
            }

            System.out.println("");

            System.out.println("Datos del partido: ");
            System.out.println("Estadio: " + partido.get_estadio());
            System.out.println("Fecha: " + partido.get_fecha());
            System.out.println("Hora: " + partido.get_hora());
            System.out.println("Clima: " + partido.get_clima());

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
    }

    public static void finalizarPartido() {
        Scanner scan = new Scanner(System.in);

        int minutos;

        System.out.println("");
        System.out.println("Ingrese los minutos jugados");
        minutos = scan.nextInt();
        partido.set_minutosJugados(minutos);

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

        System.out.println("");
        System.out.println("Jugadores expulsados: ");
        System.out.println(jugadoresExpulsados);

        System.out.println("");
        System.out.println("Goleadores: ");
        for (byte i = 0; i < equipoLocal.get_listaJugadores().size(); i++) {
            if (equipoLocal.get_listaJugadores().get(i).getGolesPartido() > 0) {
                System.out.println(equipoLocal.get_nombre() + ":");
                System.out.println("Jugador: " + equipoLocal.get_listaJugadores().get(i).get_numero() + " " + equipoLocal.get_listaJugadores().get(i).get_nombre() + " " + equipoLocal.get_listaJugadores().get(i).get_apellido() + " - Goles: " + equipoLocal.get_listaJugadores().get(i).getGolesPartido());
            }
        }

        for (byte i = 0; i < equipoVisitante.get_listaJugadores().size(); i++) {
            if (equipoVisitante.get_listaJugadores().get(i).getGolesPartido() > 0) {
                System.out.println("Jugador: " + equipoVisitante.get_listaJugadores().get(i).get_numero() + " " + equipoVisitante.get_listaJugadores().get(i).get_nombre() + " " + equipoVisitante.get_listaJugadores().get(i).get_apellido() + " - Goles: " + equipoVisitante.get_listaJugadores().get(i).getGolesPartido());
            }
        }

        System.out.println("Minutos jugados: " + partido.get_minutosJugados());
    }

    public static void expulsarJugador() {
        Scanner scan = new Scanner(System.in);
        byte idequipo;
        byte numero;

        System.out.println("Ingrese id de equipo: ");
        System.out.println("1- " + equipoLocal.get_nombre());
        System.out.println("2- " + equipoVisitante.get_nombre());
        idequipo = scan.nextByte();

        if (idequipo == 1 || idequipo == 2) {
            System.out.println("Ingrese número del jugador");
            numero = scan.nextByte();

            for (byte j = 0; j < equipoLocal.get_listatitulares().size(); j++) {
                for (byte k = 0; k < equipoLocal.get_listasuplentes().size(); k++) {
                    if (idequipo == 1 && equipoLocal.get_listatitulares().get(j).get_numero() == numero) {
                        jugadoresExpulsados.add(equipoLocal.get_listatitulares().get(j));
                        equipoLocal.get_listatitulares().remove(equipoLocal.get_listatitulares().get(j));
                    } else if (idequipo == 1 && equipoLocal.get_listasuplentes().get(k).get_numero() == numero) {
                        jugadoresExpulsados.add(equipoLocal.get_listasuplentes().get(k));
                        equipoLocal.get_listasuplentes().remove(equipoLocal.get_listasuplentes().get(k));
                    }
                }
            }

            for (byte j = 0; j < equipoVisitante.get_listatitulares().size(); j++) {
                for (byte k = 0; k < equipoVisitante.get_listasuplentes().size(); k++) {
                    if (idequipo == 2 && equipoVisitante.get_listatitulares().get(j).get_numero() == numero) {
                        jugadoresExpulsados.add(equipoVisitante.get_listatitulares().get(j));
                        equipoVisitante.get_listatitulares().remove(equipoVisitante.get_listatitulares().get(j));
                    } else if (idequipo == 2 && equipoVisitante.get_listasuplentes().get(k).get_numero() == numero) {
                        jugadoresExpulsados.add(equipoVisitante.get_listasuplentes().get(k));
                        equipoVisitante.get_listasuplentes().remove(equipoVisitante.get_listasuplentes().get(k));
                    }
                }
            }
        } else {
            System.out.println("No existe el equipo");
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

        if (idequipo == 1 || idequipo == 2) {
            System.out.println("Ingrese número del jugador");
            numero = scan.nextByte();

            for (byte i = 0; i < equipoLocal.get_listatitulares().size(); i++) {
                if (idequipo == 1 && equipoLocal.get_listatitulares().get(i).get_numero() == numero) {
                    equipoLocal.get_listatitulares().get(i).setGolesPartido((byte) (equipoLocal.get_listatitulares().get(i).getGolesPartido() + 1));
                    System.out.println("Gol de jugador " + equipoLocal.get_listatitulares().get(i).get_nombre() + " " + equipoLocal.get_listatitulares().get(i).get_apellido() + " ingresado con éxito.");
                }
            }

            for (byte j = 0; j < equipoVisitante.get_listatitulares().size(); j++) {
                if (idequipo == 2 && equipoVisitante.get_listatitulares().get(j).get_numero() == numero) {
                    equipoVisitante.get_listatitulares().get(j).setGolesPartido((byte) (equipoVisitante.get_listatitulares().get(j).getGolesPartido() + 1));
                    System.out.println("Gol de jugador " + equipoVisitante.get_listatitulares().get(j).get_nombre() + " " + equipoVisitante.get_listatitulares().get(j).get_apellido() + " ingresado con éxito.");
                }
            }
        } else {
            System.out.println("No existe el equipo");
        }
    }

    public static void cambiarJugador(){
        Scanner scan = new Scanner(System.in);
        byte idequipo;
        byte numeroTitular;
        byte numeroSuplente;

        System.out.println("Ingrese id de equipo: ");
        System.out.println("1- " + equipoLocal.get_nombre());
        System.out.println("2- " + equipoVisitante.get_nombre());
        idequipo = scan.nextByte();

        if (idequipo == 1) {
            System.out.println("Ingrese número del jugador titular del equipo local");
            numeroTitular = scan.nextByte();

            System.out.println("Ingrese número del jugador suplente del equipo local");
            numeroSuplente = scan.nextByte();

            for (byte i = 0; i < equipoLocal.get_listatitulares().size(); i++) {
                for(byte j = 0; j < equipoLocal.get_listasuplentes().size(); j++){
                    if(equipoLocal.get_listatitulares().get(i).get_numero() == numeroTitular && equipoLocal.get_listatitulares().get(i).get_cambiable()){
                        if(equipoLocal.get_listasuplentes().get(j).get_numero() == numeroSuplente && equipoLocal.get_listasuplentes().get(j).get_cambiable()){
                            equipoLocal.get_listatitulares().get(i).setCambiable(false);
                            equipoLocal.get_listasuplentes().add(equipoLocal.get_listatitulares().get(i));
                            equipoLocal.get_listatitulares().remove(equipoLocal.get_listatitulares().get(i));

                            equipoLocal.get_listasuplentes().get(j).setCambiable(false);
                            equipoLocal.get_listatitulares().add(equipoLocal.get_listasuplentes().get(j));
                            equipoLocal.get_listasuplentes().remove(equipoLocal.get_listasuplentes().get(j));
                        }
                    }
                }
            }
        }
        else if(idequipo == 2){
            System.out.println("Ingrese número del jugador titular del equipo visitante");
            numeroTitular = scan.nextByte();

            System.out.println("Ingrese número del jugador suplente del equipo visitante");
            numeroSuplente = scan.nextByte();

            for (byte i = 0; i < equipoVisitante.get_listatitulares().size(); i++) {
                for(byte j = 0; j < equipoVisitante.get_listasuplentes().size(); j++){
                    if(equipoVisitante.get_listatitulares().get(i).get_numero() == numeroTitular && equipoVisitante.get_listatitulares().get(i).get_cambiable()){
                        if(equipoVisitante.get_listasuplentes().get(j).get_numero() == numeroSuplente && equipoVisitante.get_listasuplentes().get(j).get_cambiable()){
                            equipoVisitante.get_listatitulares().get(i).setCambiable(false);
                            equipoVisitante.get_listasuplentes().add(equipoVisitante.get_listatitulares().get(i));
                            equipoVisitante.get_listatitulares().remove(equipoVisitante.get_listatitulares().get(i));

                            equipoVisitante.get_listasuplentes().get(j).setCambiable(false);
                            equipoVisitante.get_listatitulares().add(equipoVisitante.get_listasuplentes().get(j));
                            equipoVisitante.get_listasuplentes().remove(equipoVisitante.get_listasuplentes().get(j));
                        }
                    }
                }
            }
        }
        else{
            System.out.println("No existe el equipo");
        }
    }
    //endregion
}
