package Datos;

import java.util.Iterator;

public abstract class Lista<T> implements ILista<T> {

    protected NodoLista<T> inicio;
    protected NodoLista<T> fin;
    protected int cantElementos;

    //==================  Construct  ==================//
    public Lista() {
        this.inicio = null;
        this.fin = null;
        this.cantElementos = 0;
    }

    public NodoLista<T> getInicio() {
        return inicio;
    }

    public NodoLista<T> getFin() {
        return fin;
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
    //Post: retorna true si el inicio de la cola es null
    @Override
    public boolean isEmpty() {
        return this.inicio == null;
    }

    //Pre:
    //Pos: agrega el elemento al inicio de la lista
    @Override
    public void insert(T element) {

        NodoLista<T> nuevo = new NodoLista<>(element);
        nuevo.setNext(inicio);

        this.inicio = nuevo;

        if (this.fin == null) {
            this.fin = nuevo;
        }
        this.cantElementos++;
    }

    //Pre:
    //Pos: borra el elemento de la lista
    @Override
    public void delete(T element) {
        if (inicio.getElement().equals(element)) {
            inicio = inicio.getNext();
            this.cantElementos--;
        } else {
            NodoLista<T> aux = inicio;
            while (aux.getNext() != null) {
                if (aux.getNext().getElement().equals(element)) {
                    aux.setNext(aux.getNext().getNext());
                    this.cantElementos--;
                    return;
                } else {
                    aux = aux.getNext();
                }
            }
        }
    }

    //Pre:
    //Pos: elimina todos los nodos de la lista
    @Override
    public void empty() {
        while (inicio != null) {
            this.inicio = this.inicio.getNext();
        }
        this.cantElementos = 0;
    }

    //Pre:
    //Pos: retorna el objecto si lo encuentra en la cola, de lo contrario null
    @Override
    public T find(T element) {

        NodoLista<T> aux = this.inicio;

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
    //Pos: recorre los elementos e imprime sus datos
    @Override
    public void show() {
        if (this.isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            NodoLista<T> aux = this.inicio;

            while (aux != null) {
                if (aux.getNext() != null) {
                    System.out.print(aux.toString() + "|");
                } else {
                    System.out.println(aux.toString());
                }
                aux = aux.getNext();
            }
        }
    }

    public String toString() {
        String ret = "";
        for (T element : this) {
            if (this.fin.getElement().toString().compareTo(element.toString()) == 0) {
                ret += element.toString();
            } else {
                ret += element.toString() + "|";
            }
        }
        return ret;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private NodoLista<T> aux = inicio;

            public boolean hasNext() {
                return aux != null;
            }

            public T next() {
                T actual = aux.getElement();
                aux = aux.getNext();
                return actual;
            }
        };
    }
}
