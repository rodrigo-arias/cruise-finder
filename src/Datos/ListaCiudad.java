package Datos;

import Dominio.Ciudad;

public class ListaCiudad<T> extends Lista {

    private int cantMaxima;

    //==================  Construct  ==================//
    public ListaCiudad() {
        super();
        this.cantMaxima = 0;
    }

    //==================  Properties  =================//
    public int getCantMaxima() {
        return cantMaxima;
    }

    public void setCantMaxima(int cantMaxima) {
        this.cantMaxima = cantMaxima;
    }

    //===============  Métodos Complem.  ===============//
    //Pre:
    //Pos: retorna la ciudad si la encuentra en la lista, sino retorna null
    public Ciudad find(Ciudad element) {

        NodoLista<Ciudad> aux = this.inicio;

        while (aux != null && !aux.getElement().equals(element)) {
            aux = aux.getNext();
        }
        if (aux != null) {
            return aux.getElement();
        } else {
            return null;
        }
    }

    //Pre:
    //Pos: recorre la lista de ciudades e imprime su nombre
    @Override
    public void show() {
        if (this.isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            NodoLista<T> aux = this.inicio;

            while (aux != null) {
                if (aux.getNext() != null) {
                    System.out.print(aux.getElement().toString() + "|");
                } else {
                    System.out.println(aux.getElement().toString());
                }
                aux = aux.getNext();
            }
        }
    }

    //Pre:
    //Pos: retorna el índice de la ciudad en la lista, sino retorna -1
    public int findIndex(String ciudad) {

        NodoLista<Ciudad> aux = this.inicio;
        boolean encontrado = false;
        int index = -1;

        while (aux != null && !encontrado) {
            if (aux.getElement().getNombre() == ciudad) {
                encontrado = true;
            }
            index++;
            aux = aux.getNext();
        }
        if (encontrado) {
            return index;
        } else {
            return -1;
        }
    }

    //Pre:
    //Pos: retorna el nombre de la ciudad si encuentra el índice, sino retorna vacío
    public String findByIndex(int index) {

        NodoLista<Ciudad> aux = this.inicio;
        int i = 0;
        String ciudad = "";

        while (aux != null) {
            if (i == index) {
                ciudad = aux.getElement().getNombre();
            }
            i++;
            aux = aux.getNext();
        }
        return ciudad;
    }
}
