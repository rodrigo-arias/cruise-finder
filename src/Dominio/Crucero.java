package Dominio;

public class Crucero {

    private String nombre;
    private String ciudad;
    private int capacidad;
    private int estrellas;
    //private ListaServicios lservicios;

    //==================  Construct  ==================//
    public Crucero(String nombre, String ciudad, int capacidad, int estrellas) {
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estrellas = estrellas;
        //this.lservicios = new ListaServicios();
    }

    //==================  Properties  =================//
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
    //===================  Métodos  ===================//
        @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Crucero other = (Crucero) obj;
        if (nombre == null) {
            if (other.nombre != null) {
                return false;
            }
        } else if (!nombre.equals(other.nombre)) {
            return false;
        }
        return true;
    }
}
