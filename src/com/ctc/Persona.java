package com.ctc;

public class Persona {
    private String _nombre;
    private String _apellido;

    public String get_nombre() {return _nombre;}

    public void set_nombre(String _nombre) {this._nombre = _nombre;}

    public String get_apellido() {return _apellido;}

    public void set_apellido(String _apellido) {this._apellido = _apellido;}

    public Persona(String pNombre, String pApellido) {
        _nombre = pNombre;
        _apellido = pApellido;
    }

    public Persona(){}

    @Override
    public String toString() {
        return "Nombre:'" + _nombre + '\'' + ", Apellido: '" + _apellido + '\'';
    }

}
