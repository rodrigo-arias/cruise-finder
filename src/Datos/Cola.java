package Datos;

import java.util.Iterator;

public class Cola implements ICola {

    protected NodoCola inicio;
    protected NodoCola fin;
    protected int cantElementos;

    //==================  Construct  ==================//
    public Cola() {
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
    @Override
    public boolean isEmpty() {
        return this.inicio == null;
    }

    @Override
    public void insert(Object element) {

        NodoCola nuevo = new NodoCola(element);

        if (!this.isEmpty()) {

            fin.setNext(nuevo);
            fin = fin.getNext();

        } else {
            inicio = fin = nuevo;
        }
        this.cantElementos++;
    }

    @Override
    public void delete(Object element) {
        if (inicio.getElement().equals(element)) {
            inicio = inicio.getNext();

            if (inicio == null) {
                fin = null;
            }
        } else {

            NodoCola aux = inicio;
            while (aux.getNext() != null) {

                if (aux.getNext().getElement().equals(element)) {
                    aux.setNext(aux.getNext().getNext());

                    if (aux.getNext() == null) {
                        fin = aux;
                    }
                    return;
                } else {
                    aux = aux.getNext();
                }
            }
        }
        this.cantElementos--;
    }

    @Override
    public void empty() {
        inicio = inicio.getNext();
        if (inicio == null) {
            fin = null;
        }
        this.cantElementos = 0;
    }

    @Override
    public Object find(Object element) {

        NodoCola aux = inicio;

        while (aux != null) {
            if (aux.getElement().equals(element)) {
                return aux.getElement();
            } else {
                aux = aux.getNext();
            }
        }
        return aux;
    }

    //Pre:
    //Pos: Recorre y muestra los datos de lista
    @Override
    public void show() {
        if (this.isEmpty()) {
            System.out.println("La cola está vacía");
        } else {
            NodoCola aux = this.inicio;

            while (aux != null) {
                if (aux.getNext() != null) {
                    System.out.print(aux.getElement().toString() + " - ");
                } else {
                    System.out.println(aux.getElement().toString());
                }
                aux = aux.getNext();
            }
        }
    }

    public Object first() {
        return this.inicio.getElement();
    }

    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            private NodoCola aux = inicio;

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
