package Datos;

public class ListaServicio<T> extends Lista {

    //==================  Construct  ==================//
    public ListaServicio() {
        super();
    }

    //===============  Métodos Complem.  ===============//
    public void insert(String element) {
        NodoLista nuevo = new NodoLista(element);

        if (this.isEmpty()) {
            this.inicio = nuevo;
            this.fin = nuevo;
        } else {
            this.fin.setNext(nuevo);
            this.fin = nuevo;
        }

        this.cantElementos++;
    }

    @Override
    public String toString() {
        String ret = "";
        for (Object element : this) {
            if (this.getFin().getElement().toString().compareTo(element.toString()) == 0) {
                ret += element.toString();
            } else {
                ret += element.toString() + "|";
            }
        }
        return ret;
    }
}
