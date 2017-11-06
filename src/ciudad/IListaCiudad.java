package ciudad;

import cruisefind.Retorno;

public interface IListaCiudad {

    public boolean esVacia();

    public Retorno.Resultado agregarInicio(String ciudad);

    public Retorno.Resultado agregarFinal(String Ciudad);

    public void borrarInicio();

    public void borrarFin();

    public void vaciar();

    public void mostrar();
}
