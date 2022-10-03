package com.ctc.Clases;

public class Arbitro extends Persona{
    private String _puesto;

    public String get_puesto() {return _puesto;}

    public void set_puesto(String _puesto) {this._puesto = _puesto;}

    public Arbitro(String pNombre, String pApellido, String pPuesto) {
        super(pNombre, pApellido);
        this._puesto = pPuesto;
    }

    public Arbitro() {}

    @Override
    public String toString() {
        return "-" + super.toString() +
                " Puesto= '" + _puesto + "\'";
    }
}
