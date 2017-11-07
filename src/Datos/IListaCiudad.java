package Datos;

import Sistema.Retorno;

public class IListaCiudad implements ILista {

    private NodoLista inicio;
    private NodoLista fin;
    private int cantMaxima;
    private int cantElementos;

    //==================  Construct  ==================//
    public IListaCiudad() {
        this.inicio = null;
        this.fin = null;
        this.cantMaxima = 0;
        this.cantElementos = 0;
    }

    //==================  Properties  =================//
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

    //==================================================//
    //================  Métodos Básicos  ===============//
    //Pre:
    //Post: Retorna true si la lista no tiene nodos
    @Override
    public boolean esVacia() {
        return this.inicio == null;
    }

    //Pre:
    //Pos: Agrega un nuevo Nodo al principio de la lista
    @Override
    public void insertarInicio(Object element) {

        //Creo el nuevo nodo, lo asigno como inicio y sumo la cantidad
        NodoLista nuevo = new NodoLista(element, inicio);
        this.inicio = nuevo;
        this.cantElementos++;

        //Primera inserción
        if (this.fin == null) {
            this.fin = nuevo;
        }
    }

    //Pre:
    //Pos: Agrega un nuevo Nodo al final de la lista
    @Override
    public void insertarFinal(Object element) {

        if (this.esVacia()) {
            this.insertarInicio(element);
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

    //Pre:
    //Pos: Elimina todos los nodos de una lista dada
    @Override
    public void vaciar() {
        while (inicio != null) {
            eliminarInicio();
        }
    }

    //Pre:
    //Pos: Recorre y muestra los datos de lista
    @Override
    public void mostrar() {
        if (this.esVacia()) {
            System.out.println("La lista es vacía");
        } else {
            NodoLista aux = this.inicio;

            while (aux != null) {
                if (aux.getNext() != null) {
                    System.out.print(aux.toString() + " - ");
                } else {
                    System.out.println(aux.toString());
                }
                aux = aux.getNext();
            }
        }
    }

    //Pre:
    //Pos: Retorna true si encontró una coincidencia, false si no la encontró
    @Override
    public boolean buscar(Object element) {

        NodoLista aux = this.inicio;

        while (aux != null) {
            if (aux.getElement().equals(element)) {
                return true;
            } else {
                aux = aux.getNext();
            }
        }
        return false;
    }

    //==================================================//
    //===============  Métodos Complem.  ===============//
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
    }
}
