package Dominio;

import Datos.ListaCrucero;
import java.util.Objects;

public class Ciudad {

    private String nombre;
    private ListaCrucero<Crucero> cruceros;

    //==================  Construct  ==================//
    public Ciudad(String nombre) {
        this.nombre = nombre;
        this.cruceros = new ListaCrucero<>();
    }

    //==================  Properties  =================//
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaCrucero<Crucero> getCruceros() {
        return cruceros;
    }

    public void setCruceros(ListaCrucero<Crucero> cruceros) {
        this.cruceros = cruceros;
    }

    //===================  Métodos  ===================//
    //Pre:
    //Pos: recorre la lista de cruceros e imprime sus nombres, estrellas y ranking
    public void listarCruceros() {

        for (Object element : cruceros) {
            Crucero c = (Crucero) element;
            System.out.println(c.getNombre() + " " + c.getEstrellas() + " " + c.getRanking());
        }
    }

    //Pre:
    //Pos: imprime el nombre de la ciudad
    @Override
    public String toString() {
        return this.nombre + "|" + this.cruceros.toString();
    }

    //Pre:
    //Pos: retorna true si las ciudades tienen el mismo nombre
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
        } else if (!nombre.toLowerCase().equals(other.nombre.toLowerCase())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
    
    //Pre:
    //Pos: recorre la lista de cruceros y retorna un string separado por |
    public String retornarCruceros() {
        String ret = "";
        for(Object element:cruceros) {
            if(cruceros.getFin().getElement().toString().compareTo(element.toString()) == 0) {
                ret += element.toString();
            } else {
                ret += element.toString() + "|";
            }
        }
        return ret;
    }
}
