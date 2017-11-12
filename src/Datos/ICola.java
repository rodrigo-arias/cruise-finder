package Datos;

public interface ICola extends Iterable<Object> {

    public boolean isEmpty();

    public void insert(Object element);

    public void delete(Object element);

    public Object find(Object element);

    public void empty();

    public void show();
}
