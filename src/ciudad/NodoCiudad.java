package ciudad;

public class NodoCiudad {

    private int dato;
    private NodoCiudad sig;
    private String nombre;
    private ListaCiudad lciudad;

    public NodoCiudad(String nombre) {
        this.dato = dato;
        this.nombre = nombre;
        this.sig = sig;
        this.lciudad = new ListaCiudad();
    }

    public NodoCiudad(int n) {
        this.dato = n;
        this.sig = null;
    }

    //-------------------------------------------------------------------
    public int getDato() {
        return this.dato;
    }

    public void setDato(int d) {
        this.dato = d;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoCiudad getSig() {
        return this.sig;
    }

    public void setSig(NodoCiudad s) {
        this.sig = s;
    }

}
