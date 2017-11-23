package Datos;

public class NodoCola<T> {

    private T element;
    private NodoCola next;

    //==================  Construct  ==================//
    public NodoCola(T element, NodoCola<T> next) {
        this.element = element;
        this.next = next;
    }

    public NodoCola(T element) {
        this.element = element;
        this.next = null;
    }

    //==================  Properties  ==================//
    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public NodoCola<T> getNext() {
        return next;
    }

    public void setNext(NodoCola<T> next) {
        this.next = next;
    }
}
