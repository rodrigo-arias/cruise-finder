package crucero;

import cruisefind.Retorno;

public interface IListaCrucero {

    public boolean esVacia();

    public Retorno.Resultado agregarInicio(String ciudad, String nombre, int capacidad, int estrellas);

    public Retorno.Resultado agregarFinal(String ciudad, String nombre, int capacidad, int estrellas);

    public void borrarInicio();

    public void borrarFin();

    public void vaciar();

    public void mostrar();
}
