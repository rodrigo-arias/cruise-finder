package Datos;

import Dominio.Crucero;

public class ListaCrucero<T> extends Lista {

    //==================  Construct  ==================//
    public ListaCrucero() {
        super();
    }

    //==================  Properties  =================//
    public NodoLista<T> getInicio() {
        return inicio;
    }

    //===============  Métodos Complem.  ===============//
    //Pre:
    //Pos: retorna el crucero si lo encuentra en la lista, sino retorna null
    public Crucero find(Crucero element) {

        NodoLista<Crucero> aux = this.inicio;

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
    //Pos: agrega el crucero a la lista en orden alfabético
    public void insert(Crucero element) {

        NodoLista<Crucero> aux = this.inicio;

        if (this.isEmpty()) {
            NodoLista<Crucero> nuevo = new NodoLista(element);
            this.inicio = this.fin = nuevo;

        } else if (aux.getElement().compareTo(element) >= 0) {
            this.inicio = new NodoLista(element, inicio);

        } else {

            while (aux.getNext() != null && aux.getNext().getElement().compareTo(element) < 0) {
                aux = aux.getNext();
            }
            NodoLista nuevo = new NodoLista(element, aux.getNext());

            if (aux.getNext() == null) {
                this.fin = nuevo;
            }
            aux.setNext(nuevo);
        }
        this.cantElementos++;
    }
}
