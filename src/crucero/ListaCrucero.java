package crucero;

public class ListaCrucero implements IListaCrucero {

    public ListaCrucero() {
        this.inicio = inicio;
        this.fin = fin;
    }

    private NodoCrucero inicio;
    private NodoCrucero fin;

    public void Lista() {
        this.inicio = null;
        this.fin = null;
    }

    //-------------------------------------------------------------------
    public NodoCrucero getInicio() {
        return inicio;
    }

    public void setInicio(NodoCrucero i) {
        inicio = i;
    }

    public NodoCrucero getFin() {
        return fin;
    }

    public void setFin(NodoCrucero f) {
        fin = f;
    }

    //-------------------------------------------------------------------
    //Pre:
    //Pos: Retorna true si la lista no tiene nodos
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
    public void agregarInicio(int n) {
        //implementar el metodo

    }

    //Pre:
    //Pos: Agrega un nuevo Nodo al final de la lista
    @Override
    public void agregarFinal(int n) {
        // implementar el metodo

    }

    //Pre:
    //Pos: Borra el primer nodo
    @Override
    public void borrarInicio() {
        // implementar el metodo

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

    }

    //-------------------------------------------------------------------
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
    public NodoCrucero obtenerElemento(int n) {
        NodoCrucero resultado = null;
        // implementar el metodo

        return resultado;
    }

    //Pre:
    //Pos: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoCrucero l) {
        // implementar el metodo

    }

    //Pre:
    //Pos: muestra los datos de la lista en orden inverso
    public void mostrarInversoREC(NodoCrucero l) {
        // implementar el metodo

    }

    //Pre:
    //Pos: retorna true si el elemento pertenece a la lista
    public boolean existeDatoREC(NodoCrucero l, int n) {
        boolean resultado = false;
        // implementar el metodo

        return resultado;
    }

}
