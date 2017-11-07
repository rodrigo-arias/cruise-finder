package Dominio;

import Datos.ILista;
import Datos.IListaCiudad;
import java.util.Objects;

public class Ciudad {

    private String nombre;
    private ILista cruceros;

    //==================  Construct  ==================//
    public Ciudad(String nombre) {
        this.nombre = nombre;
        //this.cruceros =  new IListaIniciadorVuelosAerolineas((new OrdenarVueloPorEstrellas()));
    }

    //==================  Properties  =================//
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ILista getCruceros() {
        return cruceros;
    }

    public void setCruceros(ILista cruceros) {
        this.cruceros = cruceros;
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
        Ciudad other = (Ciudad) obj;
        if (nombre == null) {
            if (other.nombre != null) {
                return false;
            }
        } else if (!nombre.equals(other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
