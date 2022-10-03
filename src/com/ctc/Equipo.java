package com.ctc;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private byte _id;
    private String _nombre;
    private Tecnico _tecnico;
    private List<Jugador> _listatitulares;
    private List<Jugador> _listasuplentes;

    public byte get_id() {
        return _id;
    }

    public void set_id(byte _id) {
        this._id = _id;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public Tecnico get_tecnico() {
        return _tecnico;
    }

    public void set_tecnico(Tecnico _tecnico) {
        this._tecnico = _tecnico;
    }

    public List<Jugador> get_listatitulares() {
        return _listatitulares;
    }

    public void set_listatitulares(List<Jugador> _listatitulares) {
        this._listatitulares = _listatitulares;
    }

    public List<Jugador> get_listasuplentes() {
        return _listasuplentes;
    }

    public void set_listasuplentes(List<Jugador> _listasuplentes) {
        this._listasuplentes = _listasuplentes;
    }

    public Equipo(Byte pId, String pNombre, Tecnico pTecnico, List<Jugador> pListaTitulares, List<Jugador> pListaSuplentes) {
        this._id = pId;
        this._nombre = pNombre;
        this._tecnico = pTecnico;
        this._listatitulares = pListaTitulares;
        this._listasuplentes = pListaSuplentes;
    }

    public Equipo(){ }

    @Override
    public String toString() {
        return "Equipo{" +
                "_nombre='" + _nombre + '\'' +
                ", _tecnico=" + _tecnico +
                ", _listatitulares=" + _listatitulares + ", _listasuplentes=" + _listasuplentes +
                '}';
    }
}
