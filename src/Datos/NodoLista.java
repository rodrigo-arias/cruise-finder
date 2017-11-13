package Datos;

public class NodoLista<T> {

    private T element;
    private NodoLista<T> next;

    //==================  Construct  ==================//
    public NodoLista(T element) {
        this.element = element;
        this.next = null;
    }

    public NodoLista(T element, NodoLista<T> next) {
        this.element = element;
        this.next = next;
    }

    //==================  Properties  ==================//
    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public NodoLista<T> getNext() {
        return this.next;
    }

    public void setNext(NodoLista<T> n) {
        this.next = n;
    }
}
