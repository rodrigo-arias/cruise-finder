package Datos;

public class NodoLista {

    private Object element;
    private NodoLista next;

    //==================  Construct  ==================//
    public NodoLista(Object element) {
        this.element = element;
        this.next = null;
    }

    public NodoLista(Object element, NodoLista next) {
        this.element = element;
        this.next = next;
    }

    //==================  Properties  ==================//
    public Object getElement() {
        return element;
    }

    public void setElement(String nombre) {
        this.element = element;
    }

    public NodoLista getNext() {
        return this.next;
    }

    public void setNext(NodoLista s) {
        this.next = s;
    }
}
