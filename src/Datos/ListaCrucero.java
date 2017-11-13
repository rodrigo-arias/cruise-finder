package Datos;

import Dominio.Crucero;
import java.util.Comparator;

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
    //Pos: Agrega un nuevo Nodo al final de la lista
    public void insert(Crucero element) {

        NodoLista<Crucero> aux = this.inicio;

        //Primer elemento
        if (this.isEmpty()) {
            NodoLista<Crucero> nuevo = new NodoLista(element);
            this.inicio = this.fin = nuevo;

            //Es menor al inicio
        } else if (aux.getElement().compareTo(element) >= 0) {
            this.inicio = new NodoLista(element, inicio);

        } else {
            //Busco el final o el siguiente mayor
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

    public Comparator<Crucero> rankingComparator = new Comparator<Crucero>() {
        public int compare(Crucero c1, Crucero c2) {
            return c1.getRanking() - c2.getRanking();
        }
    };

    public Comparator<Crucero> getRankingComparator() {
        return rankingComparator;
    }
}
