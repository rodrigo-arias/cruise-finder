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
    //Pre:
    //Pos: retorna true si el inicio de la lista es null
    @Override
    public boolean isEmpty() {
        return this.inicio == null;
    }

    //Pre:
    //Pos: agrega el elemento al final de la cola
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

    //Pre:
    //Pos: borra el elemento del inicio de la cola
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

    //Pre:
    //Pos: elimina todos los nodos de la cola
    @Override
    public void empty() {
        inicio = inicio.getNext();
        if (inicio == null) {
            fin = null;
        }
        this.cantElementos = 0;
    }

    //Pre:
    //Pos: retorna el objecto si lo encuentra en la cola, sino retorna null
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
    //Pos: recorre los elementos e imprime sus datos
    @Override
    public void show() {
        if (this.isEmpty()) {
            System.out.println("La cola está vacía");
        } else {
            NodoCola aux = this.inicio;
            System.out.print("Cola de espera en el crucero ");

            while (aux != null) {
                if (aux.getNext() != null) {
                    System.out.print(aux.getElement() + "|");
                } else {
                    System.out.println(aux.getElement());
                }
                aux = aux.getNext();
            }
        }
    }

    //Pre:
    //Pos: retorna el primer nodo de la cola
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
    
        public String toString() {
        String ret = "";
        for (Object element : this) {
            if (this.fin.getElement().toString().compareTo(element.toString()) == 0) {
                ret += element.toString();
            } else {
                ret += element.toString() + "|";
            }
        }
        return ret;
    }
}
