package ciudad;

import cruisefind.Retorno;

public class ListaCiudad implements IListaCiudad {

    public ListaCiudad() {
        this.inicio = inicio;
        this.fin = fin;
        this.cantMaxima = 0;
        this.cantElementos = 0;
    }

    private NodoCiudad inicio;
    private NodoCiudad fin;
    private int cantMaxima;
    private int cantElementos;

    public void Lista() {
        this.inicio = null;
        this.fin = null;
    }

    //-------------------------------------------------------------------
    public NodoCiudad getInicio() {
        return inicio;
    }

    public void setInicio(NodoCiudad i) {
        inicio = i;
    }

    public NodoCiudad getFin() {
        return fin;
    }

    public void setFin(NodoCiudad f) {
        fin = f;
    }

    public int getCantMaxima() {
        return cantMaxima;
    }

    public void setCantMaxima(int cantMaxima) {
        this.cantMaxima = cantMaxima;
    }

    public int getCantElementos() {
        return cantElementos;
    }

    public void setCantElementos(int cantElementos) {
        this.cantElementos = cantElementos;
    }

    //-------------------------------------------------------------------
    //Pre:
    //Post: Retorna true si la lista no tiene nodos
    @Override
    public boolean esVacia() {
        if (this.inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    //Pre:
    //Pos: Agrega un nuevo Nodo al principio de la lista
    @Override
    public Retorno.Resultado agregarInicio(String ciudad) {

        //falta implementar buscar ciudad / implementar el metodo
        if (cantElementos < cantMaxima || cantMaxima == 0) {

            if (!this.buscarCiudad(ciudad)) {

                //creo el nuevo nodo
                NodoCiudad nuevo = new NodoCiudad(ciudad);

                //para que es????
                nuevo.setSig(inicio);
                this.inicio = nuevo;

                //sumo uno a la cantidad de elementos
                this.cantElementos++;

                //falta igualar siguiente con fin cuando es un elemento
                return Retorno.Resultado.OK;
            } else {
                return Retorno.Resultado.ERROR_1;

            }

        } else {
            return Retorno.Resultado.ERROR_2;
        }
    }

    //Pre:
    //Pos: Agrega un nuevo Nodo al final de la lista
    @Override
    public void agregarFinal(String Ciudad) {
        // implementar el metodo

    }

    //Pre:
    //Pos: Borra el primer nodo
    @Override
    public void borrarInicio() {
        // implementar el metodo
        if (this.esVacia()) {
            this.inicio = this.inicio.getSig();
        }

    }

    //Pre:
    //Pos: Borra el último nodo
    @Override
    public void borrarFin() {
        // implementar el metodo
    }

    //Pre:
    //Pos: elimina todos los nodos de una lista dada
    @Override
    public void vaciar() {
        // implementar el metodo
    }

    //Pre:
    //Pos: Recorre y muestra los datos de lista
    @Override
    public void mostrar() {
        // implementar el metodo
        NodoCiudad aux = this.inicio;

        while (aux != null) {
            System.out.print(aux.getNombre() + " -");
            aux = aux.getSig();
        }

    }

    //----------------------------------------------------------------------
    public boolean buscarCiudad(String ciudad) {

        boolean retorno = false;
        NodoCiudad aux = this.inicio;

        while (aux != null) {
            if (aux.getNombre() == ciudad) {
                retorno = true;
            }
            aux = aux.getSig();
        }
        return retorno;
    }

    //----------------------------------------------------------------------
    //Pre: lista ordenada => mantiena orden
    //Pos: inserta nuevo elemento en orden ascendente
    public void agregarOrd(int n) {
        // implementar el metodo

    }

    //Pre: lista ordenada
    //Pos: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(int n) {
        // implementar el metodo
    }

    //Pre:
    //Pos: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos() {
        int resultado = 0;
        // implementar el metodo

        return resultado;
    }

    //Pre: //Pos:
    public NodoCiudad obtenerElemento(int n) {
        NodoCiudad resultado = null;
        // implementar el metodo

        return resultado;
    }

    /**
     * *** para resolver en forma recursiva Métodos RECURSIVOS ****
     */
    //Pre:
    //Pos: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoCiudad l) {
        // implementar el metodo

    }

    //Pre:
    //Pos: muestra los datos de la lista en orden inverso
    public void mostrarInversoREC(NodoCiudad l) {
        // implementar el metodo

    }

    //Pre:
    //Pos: retorna true si el elemento pertenece a la lista
    public boolean existeDatoREC(NodoCiudad l, int n) {
        boolean resultado = false;
        // implementar el metodo

        return resultado;
    }
}
