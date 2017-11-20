package Datos;

public class ListaReserva<String> extends Lista {

    //==================  Construct  ==================//
    public ListaReserva() {
        super();
    }

    //===============  Métodos Complem.  ===============//
    //Pre:
    //Pos:
    @Override
    public void show() {
        if (this.isEmpty()) {
            System.out.println("No hay reservas para el crucero");
        } else {
            NodoLista<String> aux = this.inicio;
            System.out.print("Reservas en el crucero ");

            while (aux != null) {
                if (aux.getNext() != null) {
                    System.out.print(aux.getElement() + "|");
                } else {
                    System.out.println(aux.getElement());
                }
                aux = aux.getNext();
            }
        }
    }
}
