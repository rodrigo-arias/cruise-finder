package cruisefind;

public class NodoCrucero {

    public NodoCrucero(int dato, String nombre, String ciudad, int capacidad, int estrellas, NodoCrucero sig) {
        this.dato = dato;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.estrellas = estrellas;
        this.sig = sig;
    }

    private int dato;
    private String nombre;
    private String ciudad;
    private int capacidad;
    private int estrellas;
    private NodoCrucero sig;

    //Constructor
    public NodoCrucero(int n) {
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
    public void setSig(NodoCrucero s) {
        this.sig = s;
    }

    public NodoCrucero getSig() {
        return this.sig;
    }

}
