package Datos;

import Dominio.Crucero;

public class ListaServicio<T> extends Lista {

    //==================  Construct  ==================//
    public ListaServicio() {
        super();
    }

    //==================  Properties  =================//
    public NodoLista<T> getInicio() {
        return inicio;
    }

    //===============  Métodos Complem.  ===============//
    public void insert(Object element) {

        if (this.isEmpty()) {
            //Creo el nuevo nodo, lo asigno como inicio y sumo la cantidad
            NodoLista nuevo = new NodoLista(element);
            this.inicio = nuevo;
            this.fin = nuevo;
            this.cantElementos++;

        } else {

            NodoLista aux = this.inicio;

            //Identifico el último elemento
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }

            //Creo el nuevo nodo y le asigno el siguiente al que estaba al final
            NodoLista nuevo = new NodoLista(element);
            aux.setNext(nuevo);

            //Asigno el nuevo elemento al final y sumo la cantidad
            this.fin = nuevo;
            this.cantElementos++;
        }
    }

    public String toString() {
        String ret = "";
        for (Object element : this) {
            if (this.getFin().getElement().toString().compareTo(element.toString()) == 0) {
                ret += element.toString();
            } else {
                ret += element.toString() + "|";
            }
        }
        return ret;
    }
}
