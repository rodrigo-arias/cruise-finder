package Dominio;

import Datos.ListaCrucero;
import Datos.NodoLista;
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

    public void listarCruceros() {
        for (Object element : cruceros) {
            System.out.println(element.toString());
        }
    }

    //Pre:
    //Pos: muestra los datos de la lista en orden de enlace
    public void listarCrucerosRankingAsc(NodoLista aux) {
        if (aux != null) {
            System.out.println(aux.getElement().toString());
            listarCrucerosRankingAsc(aux.getNext());
        }
    }

    //Pre:
    //Pos: muestra los datos de la lista en orden inverso
    public void listarCrucerosRankingDesc(NodoLista aux) {
        if (aux != null) {
            listarCrucerosRankingDesc(aux.getNext());
            System.out.println(aux.getElement().toString());
        }

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
