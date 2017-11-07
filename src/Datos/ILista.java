package Datos;

public interface ILista {

    public boolean esVacia();

    public void insertarInicio(Object element);

    public void insertarFinal(Object element);

    public void eliminarInicio();

    public void eliminarFinal();

    public boolean buscar(Object element);

    public void vaciar();

    public void mostrar();
}
