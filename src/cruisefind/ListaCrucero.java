package cruisefind;

public class ListaCrucero implements IListaCrucero {

    private NodoCrucero inicio;
    private NodoCrucero fin;

    //Constructor
    public void Lista() {
        this.inicio = null;
        this.fin = null;
    }

    //Inicio
    public void setInicio(NodoCrucero i) {
        inicio = i;
    }

    public NodoCrucero getInicio() {
        return inicio;
    }

    //Fin
    public void setFin(NodoCrucero f) {
        fin = f;
    }

    public NodoCrucero getFin() {
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
    public void agregarInicio(int n) {
        //implementar el metodo

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

    }

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
    public NodoCrucero obtenerElemento(int n) {
        NodoCrucero resultado = null;
        // implementar el metodo

        return resultado;
    }

    /**
     * *** para resolver en forma recursiva Métodos RECURSIVOS ****
     */
    //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoCrucero l) {
        // implementar el metodo

    }

    //PRE:
    //POS: muestra los datos de la lista en orden inverso
    public void mostrarInversoREC(NodoCrucero l) {
        // implementar el metodo

    }

    //PRE:
    //POS: retorna true si el elemento pertenece a la lista
    public boolean existeDatoREC(NodoCrucero l, int n) {
        boolean resultado = false;
        // implementar el metodo

        return resultado;
    }

}
