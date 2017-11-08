package Datos;

public class ListaCrucero extends Lista {

    //==================  Construct  ==================//
    public ListaCrucero() {
        super();
    }

    //==================  Properties  =================//
    //===============  Métodos Complem.  ===============//
    //Pre: lista ordenada
    //Pos: Borra la primer ocurrencia de un elemento dado
    /*public void borrarElemento(String ciudad) {
        if (this.esVacia()) {
            return;
        }
        if (this.inicio.toString() == ciudad) {
            this.eliminarInicio();
        } else {
            NodoLista aux = this.inicio;
            while (aux.getNext() != null && aux.getNext().toString() != ciudad) {
                aux = aux.getNext();
            }
            //Elemento encontrado o final de la lista
            if (aux.getNext() != null) {
                NodoLista borrar = aux.getNext();
                aux.setNext(borrar.getNext());
                borrar.setNext(null);
            }
        }
    }

    //Pre:
    //Pos: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos() {
        int cant = 0;
        if (!this.esVacia()) {
            NodoLista aux = this.inicio;
            while (aux != null) {
                aux = aux.getNext();
                cant++;
            }
        }
        return cant;
    }

    //Pre:
    //Pos:
    public NodoLista obtenerElemento(String ciudad) {
        NodoLista aux = this.inicio;
        while (aux != null && aux.toString() != ciudad) {
            aux = aux.getNext();
        }
        //Elemento encontrado o final de la lista
        return aux;

    }

    //==================================================//
    //=============  Métodos Recursivos. ===============//
    //Pre:
    //Pos: muestra los datos de la lista en orden de enlace
    public void mostrarRec(NodoLista n) {
        if (n != null) {
            System.out.println(n.toString());
            mostrarRec(n.getNext());
        }
    }

    //Pre:
    //Pos: muestra los datos de la lista en orden inverso
    public void mostrarInversoRec(NodoLista n) {
        if (n != null) {
            mostrarInversoRec(n.getNext());
            System.out.println(n.toString());
        }

    }

    //Pre:
    //Pos: retorna true si el elemento pertenece a la lista
    public boolean existeDatoRec(NodoLista n, String ciudad) {
        if (n != null) {
            if (n.toString() == ciudad) {
                return true;
            } else {
                return existeDatoRec(n.getNext(), ciudad);
            }
        } else {
            return false;
        }
    }*/
}
