package Datos;

public interface ILista extends Iterable<Object> {

    public boolean isEmpty();

    public void insert(Object element);
    
    public void delete(Object element);

    public Object find(Object element);

    public void empty();

    public void show();
}
