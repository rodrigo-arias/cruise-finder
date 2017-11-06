package ciudad;

public class NodoCiudad {

    private String nombre;
    private NodoCiudad sig;

    public NodoCiudad(String nombre) {
        this.nombre = nombre;
        this.sig = null;
    }

    //==================================================//
    //==================  Properties  ==================//
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
