package crucero;

public interface IListaCrucero {

    public boolean esVacia();

    public void agregarInicio(int n);

    public void agregarFinal(int n);

    public void borrarInicio();

    public void borrarFin();

    public void vaciar();

    public void mostrar();

    //otros metodos para analizar
//    public void agregarOrd(int n);
//    public void borrarElemento(int n);
//    public int cantElementos();
//    public NodoLista obtenerElemento(int n);
//    public void mostrarREC(NodoLista l);
}
