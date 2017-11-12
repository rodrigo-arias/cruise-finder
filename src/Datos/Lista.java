package Datos;

import java.util.Iterator;

public abstract class Lista implements ILista {

    protected NodoLista inicio;
    protected NodoLista fin;
    protected int cantElementos;

    //==================  Construct  ==================//
    public Lista() {
        this.inicio = null;
        this.fin = null;
        this.cantElementos = 0;
    }

    //==================  Properties  =================//
    public int getCantElementos() {
        return cantElementos;
    }

    public void setCantElementos(int cantElementos) {
        this.cantElementos = cantElementos;
    }
    //================  Métodos Básicos  ===============//
    //Pre:
    //Post: Retorna true si la lista no tiene nodos

    @Override
    public boolean isEmpty() {
        return this.inicio == null;
    }

    //Pre:
    //Pos: Agrega un nuevo Nodo al final de la lista
    @Override
    public void insert(Object element) {
        //inicio = new NodoLista(element, this.inicio);

        NodoLista nuevo = new NodoLista(element);

        nuevo.setNext(inicio);

        this.inicio = nuevo;

        if (this.fin == null) {
            this.fin = nuevo;
        }

        this.cantElementos++;
    }

//Pre:
//Pos: Elimina el elemento de la lista
    @Override
    public void delete(Object element) {
        if (inicio.getElement().equals(element)) {
            inicio = inicio.getNext();
        } else {
            NodoLista aux = inicio;
            while (aux.getNext() != null) {
                if (aux.getNext().getElement().equals(element)) {
                    aux.setNext(aux.getNext().getNext());
                    return;
                } else {
                    aux = aux.getNext();
                }
            }
        }
        this.cantElementos--;
    }

    //Pre:
    //Pos: Elimina todos los nodos de una lista dada
    @Override
    public void empty() {
        while (inicio != null) {
            this.inicio = this.inicio.getNext();
        }
        this.cantElementos = 0;
    }

    //Pre:
    //Pos: Recorre y muestra los datos de lista
    @Override
    public void show() {
        if (this.isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            NodoLista aux = this.inicio;

            while (aux != null) {
                if (aux.getNext() != null) {
                    System.out.print(aux.toString() + " - ");
                } else {
                    System.out.println(aux.toString());
                }
                aux = aux.getNext();
            }
        }
    }

    //Pre:
    //Pos: Retorna true si encontró una coincidencia, false si no la encontró
    @Override
    public Object find(Object element) {

        NodoLista aux = this.inicio;

        while (aux != null) {
            if (aux.getElement().equals(element)) {
                return aux.getElement();
            } else {
                aux = aux.getNext();
            }
        }
        return aux;
    }

    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            private NodoLista aux = inicio;

            public boolean hasNext() {
                return aux != null;
            }

            public Object next() {
                Object actual = aux.getElement();
                aux = aux.getNext();
                return actual;
            }
        };
    }

}
