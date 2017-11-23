package Datos;

import Dominio.Crucero;

public class ListaIndice<T> extends Lista {

    //==================  Construct  ==================//
    public ListaIndice() {
        super();
    }

    //==================  Properties  =================//
    public NodoLista<T> getInicio() {
        return inicio;
    }

    //===============  Métodos Complem.  ===============//
    //Pre:
    //Pos: agrega el crucero a la lista por ranking descendente
    public void insert(Crucero element) {

        NodoLista<Crucero> aux = this.inicio;

        //Primer elemento
        if (this.isEmpty()) {
            NodoLista<Crucero> nuevo = new NodoLista(element);
            this.inicio = this.fin = nuevo;

            //Es menor al inicio
        } else if (aux.getElement().getRanking() >= element.getRanking()) {
            this.inicio = new NodoLista(element, inicio);

        } else {
            //Busco el final o el siguiente mayor
            while (aux.getNext() != null && aux.getNext().getElement().getRanking() < element.getRanking()) {
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

    public String toString(NodoLista aux) {
        if (aux == null) {
            return "";
        }
        Crucero c = (Crucero) aux.getElement();

        if (aux.getNext() == null) {
            return toString(aux.getNext()) + c.toString();
        } else {
            return toString(aux.getNext()) + "|" + c.toString();
        }

    }

    public String toStringAsc(String ciudad) {
        String ret = "";
        for (Object element : this) {
            Crucero c = (Crucero) element;
            if (c.getCiudad() == ciudad) {
                if (fin.getElement().toString().compareTo(element.toString()) == 0) {
                    ret += element.toString();
                } else {
                    ret += element.toString() + "|";
                }
            }
        }
        return ret;
    }

    public String toStringDesc(NodoLista aux, String ciudad) {
        if (aux == null) {
            return "";
        }
        Crucero c = (Crucero) aux.getElement();
        if (c.getCiudad() == ciudad) {
            if (aux.getNext() == null) {
                return toStringDesc(aux.getNext(), ciudad) + c.toString();
            } else {
                return toStringDesc(aux.getNext(), ciudad) + "|" + c.toString();
            }
        } else {
            return toStringDesc(aux.getNext(), ciudad);
        }
    }
}
