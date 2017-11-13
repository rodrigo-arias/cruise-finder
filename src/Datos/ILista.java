package Datos;

public interface ILista<T> extends Iterable<T> {

    public boolean isEmpty();

    public void insert(T element);

    public void delete(T element);

    public T find(T element);

    public void empty();

    public void show();
}
