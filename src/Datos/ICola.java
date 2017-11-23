package Datos;

public interface ICola<T> extends Iterable<T> {

    public boolean isEmpty();

    public void enqueue(T element);

    public void dequeue(T element);

    public void empty();

    public void show();
}
