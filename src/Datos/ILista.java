package Datos;

public interface ILista {

    public boolean esVacia();

    public void insertar(Object element);

    public void eliminarInicio();

    public void eliminarFinal();

    public Object buscar(Object element);

    public void vaciar();

    public void mostrar();
}
