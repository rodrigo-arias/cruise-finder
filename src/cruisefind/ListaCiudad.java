package cruisefind;

public class ListaCiudad implements IListaCiudad {

    public ListaCiudad() {
        this.inicio = inicio;
        this.fin = fin;
        this.capacidad = 0;
        this.cantElementos = 0;
    }

    private NodoCiudad inicio;
    private NodoCiudad fin;
    private int capacidad;
    private int cantElementos;

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    //Constructor
    public void Lista() {
        this.inicio = null;
        this.fin = null;
    }

    //Inicio
    public void setInicio(NodoCiudad i) {
        inicio = i;
    }

    public NodoCiudad getInicio() {
        return inicio;
    }

    //Fin
    public void setFin(NodoCiudad f) {
        fin = f;
    }

    public NodoCiudad getFin() {
        return fin;
    }

    /**
     * ***Métodos Básicos****
     */
    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    public boolean esVacia() {
        if (this.inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    //PRE:
    //POS: Agrega un nuevo Nodo al principio de la lista
    public Retorno.Resultado agregarInicio(String ciudad) {

        //falta implementar buscar ciudad
        //implementar el metodo
        if (cantElementos < capacidad || capacidad == 0) {

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

    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
    public void agregarFinal(int n) {
        // implementar el metodo

    }

    //PRE:
    //POS: Borra el primer nodo
    public void borrarInicio() {
        // implementar el metodo
        if (this.esVacia()) {
            this.inicio = this.inicio.getSig();
        }

    }

    //PRE:
    //POS: Borra el último nodo
    public void borrarFin() {
        // implementar el metodo

    }

    //PRE:
    //POS: elimina todos los nodos de una lista dada
    public void vaciar() {
        // implementar el metodo
    }

    //PRE:
    //POS: Recorre y muestra los datos de lista
    public void mostrar() {
        // implementar el metodo
        NodoCiudad aux = this.inicio;

        while (aux != null) {
            System.out.print(aux.getNombre() + " -");
            aux = aux.getSig();
        }

    }

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
    /**
     * ***Otros Métodos (iterativos)****
     */
    //PRE: lista ordenada => mantiena orden
    //POS: inserta nuevo elemento en orden ascendente
    public void agregarOrd(int n) {
        // implementar el metodo

    }

    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(int n) {
        // implementar el metodo
    }

    //PRE:
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos() {
        int resultado = 0;
        // implementar el metodo

        return resultado;
    }

    //PRE: //POS:
    public NodoCiudad obtenerElemento(int n) {
        NodoCiudad resultado = null;
        // implementar el metodo

        return resultado;
    }

    /**
     * *** para resolver en forma recursiva Métodos RECURSIVOS ****
     */
    //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoCiudad l) {
        // implementar el metodo

    }

    //PRE:
    //POS: muestra los datos de la lista en orden inverso
    public void mostrarInversoREC(NodoCiudad l) {
        // implementar el metodo

    }

    //PRE:
    //POS: retorna true si el elemento pertenece a la lista
    public boolean existeDatoREC(NodoCiudad l, int n) {
        boolean resultado = false;
        // implementar el metodo

        return resultado;
    }

    @Override
    public void agregarFinal(String Ciudad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
