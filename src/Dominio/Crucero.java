package Dominio;

import Datos.ListaGenerica;
import java.util.Objects;

public class Crucero {

    private String nombre;
    private String ciudad;
    private int capacidad;
    private int estrellas;
    private int ranking;
    private ListaGenerica servicios;
    private ListaGenerica comentarios;

    //==================  Construct  ==================//
    public Crucero(String nombre, String ciudad, int capacidad, int estrellas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.estrellas = estrellas;
        this.ranking = 0;
        this.servicios = new ListaGenerica();
        this.comentarios = new ListaGenerica();
    }

    public Crucero(String nombre) {
        this.nombre = nombre;
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

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public ListaGenerica getServicios() {
        return servicios;
    }

    public void setServicios(ListaGenerica lservicios) {
        this.servicios = lservicios;
    }

    public ListaGenerica getComentarios() {
        return comentarios;
    }

    public void setComentarios(ListaGenerica comentarios) {
        this.comentarios = comentarios;
    }

    //===================  Métodos  ===================//
    public void actualizarRanking() {
        int total = 0;
        int comments = 0;

        for (Object o : comentarios) {

            Comentario com = (Comentario) o;
            total += com.getRanking();

            comments++;
        }
        this.ranking = total / comments;
    }

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
}
