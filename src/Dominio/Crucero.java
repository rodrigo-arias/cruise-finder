package Dominio;

import Datos.Cola;
import Datos.ListaGenerica;
import Datos.ListaReserva;
import Datos.ListaServicio;
import Datos.NodoLista;
import java.util.Objects;

public class Crucero implements Comparable<Crucero> {

    private String nombre;
    private String ciudad;
    private int capacidad;
    private int estrellas;
    private int ranking;
    private ListaServicio servicios;
    private ListaGenerica comentarios;
    private ListaReserva reservas;
    private Cola esperas;
    private int disponibles;

    //==================  Construct  ==================//
    public Crucero(String nombre, String ciudad, int capacidad, int estrellas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.estrellas = estrellas;
        this.ranking = 0;
        this.servicios = new ListaServicio();
        this.comentarios = new ListaGenerica();
        this.reservas = new ListaReserva();
        this.esperas = new Cola();
        this.disponibles = capacidad;
    }

    public Crucero(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
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

    public ListaServicio getServicios() {
        return servicios;
    }

    public void setServicios(ListaServicio lservicios) {
        this.servicios = lservicios;
    }

    public ListaGenerica getComentarios() {
        return comentarios;
    }

    public void setComentarios(ListaGenerica comentarios) {
        this.comentarios = comentarios;
    }

    public ListaReserva getReservas() {
        return reservas;
    }

    public void setReservas(ListaReserva reservas) {
        this.reservas = reservas;
    }

    public Cola getEsperas() {
        return esperas;
    }

    public void setEsperas(Cola esperas) {
        this.esperas = esperas;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    //===================  Métodos  ===================//
    //Pre:
    //Pos: actualiza el ranking del crucero como promedio de todos los rankings de comentarios
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

    //Pre:
    //Pos: elimina al cliente de la lista de reservas y agrega al primero de la cola de esperas si existe
    public void eliminarReserva(int cliente) {
        this.reservas.delete(cliente);
        this.disponibles++;

        if (!esperas.isEmpty()) {
            int firstHold = (int) esperas.first();
            this.esperas.delete(firstHold);
            this.reservas.insert(firstHold);
            this.disponibles--;
        }
    }

    //Pre:
    //Pos: elimina al cliente de la cola de espera
    public void eliminarEspera(int cliente) {
        this.esperas.delete(cliente);
    }

    //Pre:
    //Pos: recorre la lista de servicios e imprime número y nombre
    public void listarServicios() {
        int num = 1;
            for(Object element:servicios) {
            System.out.println(num + " - " + element.toString());
            num++;
        }
    }

    //Pre:
    //Pos: recorre la lista de cruceros e imprime sus número y comentario
    public void listarComentarios() {
        int num = 1;
        for (Object element : comentarios) {
            System.out.println(num + " - " + element.toString());
            num++;
        }
    }

    //Pre:
    //Pos: retorna el crucero con todos sus datos
    @Override
    public String toString() {
        return this.nombre + ";" +
                this.ciudad + ";" +
                this.capacidad + ";" +
                this.estrellas + ";" +
                this.ranking + ";" +
                this.servicios.toString() +  ";" +
                this.comentarios.toString() +  ";" +
                this.reservas.toString() +  ";" + 
                this.esperas.toString() +  ";" +
                this.disponibles;
    }

    //Pre:
    //Pos: retorna 0 si el crucero tiene el mismo nombre al comparado < 0 si tiene otro nombre
    @Override
    public int compareTo(Crucero element) {
        Crucero other = element;
        return this.nombre.compareTo(other.nombre);
    }

    //Pre:
    //Pos: retorna true si las ciudades y el crucero tienen el mismo nombre
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
        } else if (ciudad == null) {
            if (other.ciudad != null) {
                return false;
            }
        } else if (!nombre.toLowerCase().equals(other.nombre.toLowerCase()) || !ciudad.toLowerCase().equals(other.ciudad.toLowerCase())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.nombre.toLowerCase());
        return hash;
    }
}
