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

    public static List<Jugador> golesEquipoLocal = new ArrayList<>();
    public static Equipo equipoVisitante = new Equipo();
    public static List<Jugador> jugadoresEquipoVisitante = new ArrayList<>();
    public static List<Jugador> jugadoresTitularesEquipoVisitante = new ArrayList<>();
    public static List<Jugador> jugadoresSuplentesEquipoVisitante = new ArrayList<>();

    public static List<Jugador> golesEquipoVisitante = new ArrayList<>();
    public static List<Arbitro> ternaArbitral = new ArrayList<>();
    public static List<Jugador> jugadoresExpulsados = new ArrayList<>();

    //endregion

    //region Métodos auxiliares equipos
    public static Jugador BuscarJugadorEquipoLocal(byte pNumero) { // Buscar jugador para verificar que el número ingresado sea diferente.
        for (Jugador jugador : jugadoresEquipoLocal) {
            if (jugador.get_numero() == pNumero) {
                return jugador;
            }
        }
        return null;
    }
    public static Jugador BuscarJugadorEquipoVisitante(byte pNumero) { // Buscar jugador para verificar que el número ingresado sea diferente.
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

        System.out.println("Ingrese nombre del equipo local"); // Pedimos los datos a ingresar.
        nombreEquipo = scan.next();

        System.out.println("Ingrese nombre del DT de " + nombreEquipo);
        nombre = scan.next();

        System.out.println("Ingrese apellido del DT de " + nombreEquipo);
        apellido = scan.next();

        System.out.println("Ingrese edad del DT de " + nombreEquipo);
        edad = scan.nextByte();
        Tecnico dt = new Tecnico(nombre, apellido, edad);

        while (jugadoresTitularesEquipoLocal.size() < 11) { // Pedimos que ingrese jugadores hasta que la lista de titulares tenga 11 objetos.
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

        while (jugadoresSuplentesEquipoLocal.size() < 5) { // Pedimos que ingrese jugadores hasta que la lista de suplentes tenga 5 objetos.
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
            if (BuscarJugadorEquipoLocal(jugador.get_numero()) == null) { // Si el número del jugador ingresado es diferente a cualquiera de los ya ingresados, lo agrega.
                jugadoresEquipoLocal.add(jugador);
                jugadoresSuplentesEquipoLocal.add(jugador);
                System.out.println("Ingresado con éxito");
            } else {
                System.out.println("No se pudo ingresar porque el número es repetido");
            }
        }
        equipoLocal = new Equipo((byte) 1, nombreEquipo, dt, jugadoresTitularesEquipoLocal, jugadoresSuplentesEquipoLocal, jugadoresEquipoLocal);

        if (jugadoresTitularesEquipoLocal.size() == 11 && jugadoresSuplentesEquipoLocal.size() == 5) {
            return true;
        }
        return false;
    }
    public static boolean IngresarEquipoVisitante() {
        Scanner scan = new Scanner(System.in);

        String nombre, apellido, puesto, estado, nombreEquipo;
        byte numero, edad;

        System.out.println("Ingrese nombre del equipo visitante"); // Pedimos los datos a ingresar.
        nombreEquipo = scan.next();

        System.out.println("Ingrese nombre del DT de " + nombreEquipo);
        nombre = scan.next();

        System.out.println("Ingrese apellido del DT de " + nombreEquipo);
        apellido = scan.next();

        System.out.println("Ingrese edad del DT de " + nombreEquipo);
        edad = scan.nextByte();
        Tecnico dt = new Tecnico(nombre, apellido, edad);

        while (jugadoresTitularesEquipoVisitante.size() < 11) { // Pedimos que ingrese jugadores hasta que la lista de titulares tenga 11 objetos.
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
            if (BuscarJugadorEquipoVisitante(jugador.get_numero()) == null) { // Si el número del jugador ingresado es diferente a cualquiera de los ya ingresados, lo agrega.
                jugadoresEquipoVisitante.add(jugador);
                jugadoresTitularesEquipoVisitante.add(jugador);
                System.out.println("Ingresado con éxito");
            } else {
                System.out.println("No se pudo ingresar porque el número es repetido");
            }
        }

        while (jugadoresSuplentesEquipoVisitante.size() < 5) { // Pedimos que ingrese jugadores hasta que la lista de suplentes tenga 5 objetos.
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

        if (jugadoresTitularesEquipoVisitante.size() == 11 && jugadoresSuplentesEquipoVisitante.size() == 5) {
            return true;
        }
        return false;
    }
    public static boolean IngresarArbitros() {
        Scanner scan = new Scanner(System.in);

        String nombre, apellido, puesto;

        for (byte i = 1; i < 4; i++) { // Pedimos que ingrese 3 arbitros
            System.out.println("Ingrese nombre del arbitro " + i);
            nombre = scan.next();

            System.out.println("Ingrese apellido del arbitro " + i);
            apellido = scan.next();

            System.out.println("Ingrese puesto del arbitro " + i);
            puesto = scan.next();

            Arbitro arbitro = new Arbitro(nombre, apellido, puesto);
            ternaArbitral.add(arbitro); // Agregamos el elemento a la lista de arbitros.
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

        System.out.println("Ingrese estadio"); // Pedimos los datos.
        estadio = scan.nextLine();

        System.out.println("Ingrese fecha");
        fecha = scan.next();

        System.out.println("Ingrese hora");
        hora = scan.next();

        System.out.println("Ingrese clima");
        clima = scan.next();

        partido = new Partido(estadio, fecha, hora, clima, minutos); // Instanciamos la clase partido, y se la asignamos a la variable global antes declarada.

        return partido;
    }
    //endregion

    //region Funciones del partido
    public static void IniciarPartido() {
        System.out.println("Iniciando partido");
        System.out.println("");
        if (IngresarDatosPartido() != null && IngresarArbitros() && IngresarEquipoLocal() && IngresarEquipoVisitante()) { // Verificamos que los datos del partido, la terna arbitral, y los datos de ambos equipos estén ingresados.
            System.out.println("Iniciando partido");
            System.out.println("Arbitros: ");
            for (Arbitro arbitro : ternaArbitral) { // Mostramos la terna arbitral.
                System.out.println(arbitro);
            }

            System.out.println("");

            System.out.println("Datos del partido: "); // Mostramos los datos del partido.
            System.out.println("Estadio: " + partido.get_estadio());
            System.out.println("Fecha: " + partido.get_fecha());
            System.out.println("Hora: " + partido.get_hora());
            System.out.println("Clima: " + partido.get_clima());

            System.out.println("");

            System.out.println("Equipo local: " + equipoLocal.get_nombre()); // Mostramos los datos de los equipos.
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
        int golesEquipoL = 0;
        int golesEquipoV = 0;

        System.out.println("");
        System.out.println("Ingrese los minutos jugados");
        minutos = scan.nextInt();
        partido.set_minutosJugados(minutos); // Le asignamos los minutos jugados al objeto partido.
        System.out.println("");

        System.out.println("Fin del partido");

        System.out.println("");

        System.out.println("Resultado: " ); // Mostramos el resultado del partido.
        for (Jugador jugadorEquipoL : golesEquipoLocal) {
            golesEquipoL += jugadorEquipoL.getGolesPartido();
        }
        for (Jugador jugadorEquipoV : golesEquipoVisitante) {
            golesEquipoV += jugadorEquipoV.getGolesPartido();
        }
        System.out.println(equipoLocal.get_nombre() + " " + golesEquipoL + " - " + golesEquipoV + " " + equipoVisitante.get_nombre());

        System.out.println("");

        System.out.println("Equipo local: " + equipoLocal.get_nombre()); // Mostramos los datos del equipo local al final del partido.
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

        System.out.println("Equipo visitante: " + equipoVisitante.get_nombre()); // Mostramos los datos del equipo visitante al final del partido.
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

        System.out.println("Jugadores expulsados: "); // Mostramos los jugadores que fueron expulsados.
        System.out.println(jugadoresExpulsados);

        System.out.println("");

        System.out.println("Goleadores: "); // Mostramos los jugadores que hicieron uno o más goles.
        System.out.println("Equipo: " + equipoLocal.get_nombre());
        for (byte i = 0; i < golesEquipoLocal.size(); i++) {
            System.out.println("Jugador: " + golesEquipoLocal.get(i).get_numero() + " " + golesEquipoLocal.get(i).get_nombre() + " " + golesEquipoLocal.get(i).get_apellido() + " - Goles: " + golesEquipoLocal.get(i).getGolesPartido());
        }

        System.out.println("");

        System.out.println("Equipo: " + equipoVisitante.get_nombre());
        for (byte j = 0; j < golesEquipoVisitante.size(); j++) {
            System.out.println("Jugador: " + golesEquipoVisitante.get(j).get_numero() + " " + golesEquipoVisitante.get(j).get_nombre() + " " + golesEquipoVisitante.get(j).get_apellido() + " - Goles: " + golesEquipoVisitante.get(j).getGolesPartido());
        }

        System.out.println("");

        System.out.println("Minutos jugados: " + partido.get_minutosJugados()); // Mostramos los minutos jugados.
    }
    public static void expulsarJugador() {
        Scanner scan = new Scanner(System.in);
        byte idequipo;
        byte numero;

        System.out.println("Ingrese id de equipo: ");
        System.out.println("1- " + equipoLocal.get_nombre());
        System.out.println("2- " + equipoVisitante.get_nombre());
        idequipo = scan.nextByte();

        if (idequipo == 1 || idequipo == 2) { // Verifica si el id del equipo es válido.
            System.out.println("Ingrese número del jugador");
            numero = scan.nextByte();

            for (byte j = 0; j < equipoLocal.get_listatitulares().size(); j++) { // Recorremos la lista de titulares del equipo local.
                for (byte k = 0; k < equipoLocal.get_listasuplentes().size(); k++) { // Recorremos la lista de suplentes del equipo local.
                    if (idequipo == 1 && equipoLocal.get_listatitulares().get(j).get_numero() == numero) { // Verificamos si el número de jugador ingresado está en la lista de titulares.
                        jugadoresExpulsados.add(equipoLocal.get_listatitulares().get(j));
                        equipoLocal.get_listatitulares().remove(equipoLocal.get_listatitulares().get(j));
                    } else if (idequipo == 1 && equipoLocal.get_listasuplentes().get(k).get_numero() == numero) { // Verificamos si el número de jugador ingresado está en la lista de suplentes.
                        jugadoresExpulsados.add(equipoLocal.get_listasuplentes().get(k));
                        equipoLocal.get_listasuplentes().remove(equipoLocal.get_listasuplentes().get(k));
                    }
                }
            }

            for (byte j = 0; j < equipoVisitante.get_listatitulares().size(); j++) { // // Recorremos la lista de titulares del equipo visitante.
                for (byte k = 0; k < equipoVisitante.get_listasuplentes().size(); k++) { // Recorremos la lista de suplentes del equipo visitante.
                    if (idequipo == 2 && equipoVisitante.get_listatitulares().get(j).get_numero() == numero) { // Verificamos si el número de jugador ingresado está en la lista de titulares.
                        jugadoresExpulsados.add(equipoVisitante.get_listatitulares().get(j));
                        equipoVisitante.get_listatitulares().remove(equipoVisitante.get_listatitulares().get(j));
                    } else if (idequipo == 2 && equipoVisitante.get_listasuplentes().get(k).get_numero() == numero) { // Verificamos si el número de jugador ingresado está en la lista de suplentes.
                        jugadoresExpulsados.add(equipoVisitante.get_listasuplentes().get(k));
                        equipoVisitante.get_listasuplentes().remove(equipoVisitante.get_listasuplentes().get(k));
                    }
                }
            }
        } else {
            System.out.println("No existe el equipo"); // Si el ID del equipo ingresado no es válido, se informa del error.
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

        if (idequipo == 1 || idequipo == 2) { // Verificamos si el ID del equipo es válido.
            System.out.println("Ingrese número del jugador");
            numero = scan.nextByte();

            for (byte i = 0; i < equipoLocal.get_listatitulares().size(); i++) { // Recorremos la lista de titulares del equipo local.
                if (idequipo == 1 && equipoLocal.get_listatitulares().get(i).get_numero() == numero) { // Verificamos si el número de jugador ingresado está en la lista de titulares.
                    golesEquipoLocal.add(equipoLocal.get_listatitulares().get(i));
                    equipoLocal.get_listatitulares().get(i).setGolesPartido((byte) (equipoLocal.get_listatitulares().get(i).getGolesPartido() + 1));
                    System.out.println("Gol de jugador " + equipoLocal.get_listatitulares().get(i).get_nombre() + " " + equipoLocal.get_listatitulares().get(i).get_apellido() + " ingresado con éxito.");
                }
            }

            for (byte j = 0; j < equipoVisitante.get_listatitulares().size(); j++) { // Recorremos la lista de titulares del equipo visitante.
                if (idequipo == 2 && equipoVisitante.get_listatitulares().get(j).get_numero() == numero) { // Verificamos si el número de jugador ingresado está en la lista de titulares.
                    golesEquipoVisitante.add(equipoVisitante.get_listatitulares().get(j));
                    equipoVisitante.get_listatitulares().get(j).setGolesPartido((byte) (equipoVisitante.get_listatitulares().get(j).getGolesPartido() + 1));
                    System.out.println("Gol de jugador " + equipoVisitante.get_listatitulares().get(j).get_nombre() + " " + equipoVisitante.get_listatitulares().get(j).get_apellido() + " ingresado con éxito.");
                }
            }
        } else {
            System.out.println("No existe el equipo"); // Si el ID de equipo ingresado no es válido, se informa del error.
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

        if (idequipo == 1) { // Verificamos si el id del equipo ingresado es el del equipo local.
            System.out.println("Ingrese número del jugador titular del equipo local");
            numeroTitular = scan.nextByte();

            System.out.println("Ingrese número del jugador suplente del equipo local");
            numeroSuplente = scan.nextByte();

            for (byte i = 0; i < equipoLocal.get_listatitulares().size(); i++) { // Recorremos la lista de titulares.
                for(byte j = 0; j < equipoLocal.get_listasuplentes().size(); j++){ // Recorremos la lista de suplentes.
                    if(equipoLocal.get_listatitulares().get(i).get_numero() == numeroTitular && equipoLocal.get_listatitulares().get(i).get_cambiable()){ // Verificamos si uno de los números ingresados es el de un jugador titular y el estado 'cambiable' es true.
                        if(equipoLocal.get_listasuplentes().get(j).get_numero() == numeroSuplente && equipoLocal.get_listasuplentes().get(j).get_cambiable()){ // Verificamos si el otro número ingresado es el de un jugador suplente y el estado 'cambiable' es true.
                            equipoLocal.get_listatitulares().get(i).setCambiable(false); // Cambiamos el estado de cambiable a false, esto para que no pueda volver a ingresar.
                            equipoLocal.get_listasuplentes().add(equipoLocal.get_listatitulares().get(i)); // Agregamos el jugador que ingresa a la de titulares.
                            equipoLocal.get_listatitulares().remove(equipoLocal.get_listatitulares().get(i)); // Eliminamos al jugador que sale de la lista de titulares.

                            equipoLocal.get_listatitulares().add(equipoLocal.get_listasuplentes().get(j)); // Agregamos al jugador que sale a la lista de suplentes.
                            equipoLocal.get_listasuplentes().remove(equipoLocal.get_listasuplentes().get(j)); // Eliminamos al jugador que ingresa de la lista de suplentes.
                        }
                    }
                }
            }
        }
        else if(idequipo == 2){// Verificamos si el id del equipo ingresado es el del equipo visitante.
            System.out.println("Ingrese número del jugador titular del equipo visitante");
            numeroTitular = scan.nextByte();

            System.out.println("Ingrese número del jugador suplente del equipo visitante");
            numeroSuplente = scan.nextByte();

            for (byte i = 0; i < equipoVisitante.get_listatitulares().size(); i++) { // Recorremos la lista de titulares.
                for(byte j = 0; j < equipoVisitante.get_listasuplentes().size(); j++){ // Recorremos la lista de suplentes.
                    if(equipoVisitante.get_listatitulares().get(i).get_numero() == numeroTitular && equipoVisitante.get_listatitulares().get(i).get_cambiable()){ // Verificamos si uno de los números ingresados es el de un jugador titular y el estado 'cambiable' es true.
                        if(equipoVisitante.get_listasuplentes().get(j).get_numero() == numeroSuplente && equipoVisitante.get_listasuplentes().get(j).get_cambiable()){ // Verificamos si el otro número ingresado es el de un jugador suplente y el estado 'cambiable' es true.
                            equipoVisitante.get_listatitulares().get(i).setCambiable(false); // Cambiamos el estado de cambiable a false, esto para que no se pueda volver a cambiar por ese jugador.
                            equipoVisitante.get_listasuplentes().add(equipoVisitante.get_listatitulares().get(i)); // Agregamos el jugador que ingresa a la de titulares.
                            equipoVisitante.get_listatitulares().remove(equipoVisitante.get_listatitulares().get(i)); // Eliminamos al jugador que sale de la lista de titulares.

                            equipoVisitante.get_listatitulares().add(equipoVisitante.get_listasuplentes().get(j)); // Agregamos al jugador que sale a la lista de suplentes.
                            equipoVisitante.get_listasuplentes().remove(equipoVisitante.get_listasuplentes().get(j)); // Eliminamos al jugador que ingresa de la lista de suplentes.
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
