package cruisefind;

public interface IListaCiudad {

    //metodos de la interfaz
    public boolean esVacia();

    public Retorno.Resultado agregarInicio(String ciudad);

    public void agregarFinal(String Ciudad);

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
