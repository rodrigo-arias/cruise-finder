package Datos;

import Dominio.Ciudad;

public class ListaCiudad<T> extends Lista {

    private int cantMaxima;

    //==================  Construct  ==================//
    public ListaCiudad() {
        super();
        this.cantMaxima = 0;
    }

    //==================  Properties  =================//
    public int getCantMaxima() {
        return cantMaxima;
    }

    public void setCantMaxima(int cantMaxima) {
        this.cantMaxima = cantMaxima;
    }

    //==================================================//
    //===============  Métodos Complem.  ===============//
    public Ciudad find(Ciudad element) {

        NodoLista<Ciudad> aux = this.inicio;

        while (aux != null && !aux.getElement().equals(element)) {
            aux = aux.getNext();
        }
        if (aux != null) {
            return aux.getElement();
        } else {
            return null;
        }
    }

    /*

    @Override
    public void insertEnd(Object element) {

        if (this.isEmpty()) {
            //Creo el nuevo nodo, lo asigno como inicio y sumo la cantidad
            NodoLista nuevo = new NodoLista(element);
            this.inicio = nuevo;
            this.fin = nuevo;
            this.cantElementos++;

        } else {

            NodoLista aux = this.inicio;

            //Identifico el último elemento
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }

            //Creo el nuevo nodo y le asigno el siguiente al que estaba al final
            NodoLista nuevo = new NodoLista(element);
            aux.setNext(nuevo);

            //Asigno el nuevo elemento al final y sumo la cantidad
            this.fin = nuevo;
            this.cantElementos++;
        }
    }

    //Pre: lista ordenada
    //Pos: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(String ciudad) {
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

    //Pre:
    //Pos: Borra el primer nodo
    @Override
    public void eliminarInicio() {
        if (this.esVacia()) {
            this.inicio = this.inicio.getNext();
        }

    }

    //Pre:
    //Pos: Borra el último nodo
    @Override
    public void eliminarFinal() {
        if (!this.esVacia()) {
            if (this.inicio == this.fin) {
                this.eliminarInicio();
            } else {
                NodoLista aux = this.inicio;
                while (aux.getNext().getNext() != null) {
                    aux = aux.getNext();
                }
                this.fin = aux;
                this.fin.setNext(null);
            }
        }
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
