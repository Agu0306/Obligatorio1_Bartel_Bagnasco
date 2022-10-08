package com.ctc.Clases;

public class Jugador extends Persona {
    private String _puesto;
    private Byte _numero;
    private Byte _edad;
    private String _estado;
    private Byte _golesPartido;

    private Boolean _cambiable;

    public String get_puesto() {
        return _puesto;
    }

    public void set_puesto(String _puesto) {
        this._puesto = _puesto;
    }

    public Byte get_numero() {
        return _numero;
    }

    public void set_numero(Byte _numero) {
        this._numero = _numero;
    }

    public Byte get_edad() { return _edad; }

    public void set_edad(Byte _edad) {
        this._edad = _edad;
    }

    public String get_estado() { return _estado; }

    public void set_estado(String _estado) { this._estado = _estado; }

    public Byte getGolesPartido() { return _golesPartido; }

    public void setGolesPartido(Byte golesPartido) {
        this._golesPartido = golesPartido;
    }

    public Boolean get_cambiable() { return _cambiable; }

    public void setCambiable(Boolean _cambiable) { this._cambiable = _cambiable; }

    public Jugador(String pNombre, String pApellido, String pPuesto, Byte pNumero, Byte pEdad, String pEstado, Byte pGoles, Boolean pCambiable) {
        super(pNombre, pApellido);
        this._puesto = pPuesto;
        this._numero = pNumero;
        this._edad = pEdad;
        this._estado = pEstado;
        this._golesPartido = pGoles;
        this._cambiable = pCambiable;
    }

    public Jugador() {
    }

    @Override
    public String toString() {
        return super.toString() +
                " Puesto='" + _puesto + '\'' +
                ", Numero=" + _numero +
                ", Edad=" + _edad + '\'' +
                ", Estado=" + _estado;
    }
}
