package crucero;

public class NodoCrucero {

    private int dato;
    private String nombre;
    private String ciudad;
    private int capacidad;
    private int estrellas;
    private NodoCrucero sig;

    public NodoCrucero(int dato, String nombre, String ciudad, int capacidad, int estrellas, NodoCrucero sig) {
        this.dato = dato;
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estrellas = estrellas;
        //this.lservicios = new ListaServicios();
        this.sig = sig;
    }

    public NodoCrucero(int n) {
        this.dato = n;
        this.sig = null;
    }

    //-------------------------------------------------------------------
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public NodoCrucero getSig() {
        return sig;
    }

    public void setSig(NodoCrucero sig) {
        this.sig = sig;
    }
}
