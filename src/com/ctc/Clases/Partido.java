package com.ctc.Clases;

public class Partido {
    private String _estadio;
    private String _fecha;
    private String _hora;
    private String _clima;
    private int _minutosJugados;
    public String get_estadio() {
        return _estadio;
    }

    public void set_estadio(String _estadio) {
        this._estadio = _estadio;
    }

    public String get_fecha() {
        return _fecha;
    }

    public void set_fecha(String _fecha) {
        this._fecha = _fecha;
    }

    public String get_hora() {
        return _hora;
    }

    public void set_hora(String _hora) {
        this._hora = _hora;
    }

    public String get_clima() {
        return _clima;
    }

    public void set_clima(String _clima) {
        this._clima = _clima;
    }

    public int get_minutosJugados() {
        return _minutosJugados;
    }
    public void set_minutosJugados(int _minutosJugados) {
        this._minutosJugados = _minutosJugados;
    }

    public Partido(String pEstadio, String pFecha, String pHora, String pClima, int pMinutosJugados) {
        this._estadio = pEstadio;
        this._fecha = pFecha;
        this._hora = pHora;
        this._clima = pClima;
        this._minutosJugados = pMinutosJugados;
    }

    public Partido(){}

    @Override
    public String toString() {
        return "Partido{" +
                "_estadio='" + _estadio + '\'' +
                ", _fecha='" + _fecha + '\'' +
                ", _hora='" + _hora + '\'' +
                ", _clima='" + _clima + '\'' +
                ", _minutosJugados=" + _minutosJugados +
                '}';
    }
}
