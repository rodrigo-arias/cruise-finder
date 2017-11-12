package Datos;

public class NodoCola {

    private Object element;
    private NodoCola next;

    //==================  Construct  ==================//
    public NodoCola(Object element, NodoCola next) {
        this.element = element;
        this.next = next;
    }

    public NodoCola(Object element) {
        this.element = element;
        this.next = null;
    }

    //==================  Properties  ==================//
    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public NodoCola getNext() {
        return next;
    }

    public void setNext(NodoCola next) {
        this.next = next;
    }

}
