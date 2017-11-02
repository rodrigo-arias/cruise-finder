package ciudad;

import ciudad.ListaCiudad;

public class NodoCiudad {

    private int dato;
    private String nombre;
    private NodoCiudad sig;
    private ListaCiudad lcrucero;

    public NodoCiudad(String nombre) {
        this.dato = dato;
        this.nombre = nombre;
        this.sig = sig;
        this.lcrucero = new ListaCiudad();
    }

    public String getNombre() {
        return nombre;
    }

    //Constructor
    public NodoCiudad(int n) {
        this.dato = n;
        this.sig = null;
    }

    //Dato
    public void setDato(int d) {
        this.dato = d;
    }

    public int getDato() {
        return this.dato;
    }

    //Siguiente
    public void setSig(NodoCiudad s) {
        this.sig = s;
    }

    public NodoCiudad getSig() {
        return this.sig;
    }

}
