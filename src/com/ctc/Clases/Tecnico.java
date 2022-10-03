package com.ctc.Clases;

public class Tecnico extends Persona{
    private Byte _edad;

    public Byte get_edad() {return _edad;}

    public void set_edad(Byte _edad) {this._edad = _edad;}

    public Tecnico(String pNombre, String pApellido, Byte pEdad) {
        super(pNombre, pApellido);
        this._edad = pEdad;
    }

    public Tecnico(){}

    @Override
    public String toString() {
        return "DT: " +
                super.toString() +
                ", Edad=" + _edad;
    }
}
