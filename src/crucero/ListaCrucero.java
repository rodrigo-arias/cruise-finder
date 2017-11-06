package crucero;

import cruisefind.Retorno;

public class ListaCrucero implements IListaCrucero {

    private NodoCrucero inicio;
    private NodoCrucero fin;

    public ListaCrucero() {
        this.inicio = inicio;
        this.fin = fin;
    }

    public void Lista() {
        this.inicio = null;
        this.fin = null;
    }

    //==================================================//
    //==================  Properties  ==================//
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
    public Retorno.Resultado agregarInicio(String ciudad, String nombre, int capacidad, int estrellas) {

        if (capacidad > 0) {

            if (!this.buscarCrucero(ciudad, nombre)) {

                //Creo el nuevo nodo y le asigno el siguiente
                NodoCrucero nuevo = new NodoCrucero(ciudad, nombre, capacidad, estrellas);
                nuevo.setSig(inicio);

                //Asigno el nuevo elemento al inicio y sumo la cantidad
                this.inicio = nuevo;

                //Primera inserción
                if (this.fin == null) {
                    this.fin = nuevo;
                }
                return Retorno.Resultado.OK;
            } else {
                return Retorno.Resultado.ERROR_1;

            }

        } else {
            return Retorno.Resultado.ERROR_2;
        }

//        if (estrellas < 1 || estrellas > 5) {
//
//            ret.resultado = Resultado.ERROR_1;
//
//        } else if (capacidad < 0) {
//
//            ret.resultado = Resultado.ERROR_2;
//
//        }   else if (!lciudad.buscarCrucero(ciudad, nombre)) {
//
//            ret.resultado = Resultado.ERROR_4;
//        } else if (!lciudad.buscarCiudad(ciudad)) {
//
//            ret.resultado = Resultado.ERROR_4;
//
//        } else {
//            ret.resultado = Resultado.OK;
//        }
//
//        return ret;
    }

    //Pre:
    //Pos: Agrega un nuevo Nodo al final de la lista
    @Override
    public Retorno.Resultado agregarFinal(String ciudad, String nombre, int capacidad, int estrellas) {

        if (capacidad > 0) {

            if (!this.buscarCrucero(ciudad, nombre)) {

                if (this.esVacia()) {
                    this.agregarInicio(ciudad, nombre, capacidad, estrellas);
                } else {

                    NodoCrucero aux = this.inicio;

                    //Identifico el último elemento
                    while (aux.getSig() != null) {
                        aux = aux.getSig();
                    }

                    //Creo el nuevo nodo y le asigno el siguiente al que estaba al final
                    NodoCrucero nuevo = new NodoCrucero(ciudad, nombre, capacidad, estrellas);
                    aux.setSig(nuevo);

                    //Asigno el nuevo elemento al final y sumo la cantidad
                    this.fin = nuevo;
                }

                return Retorno.Resultado.OK;
            } else {
                return Retorno.Resultado.ERROR_1;

            }

        } else {
            return Retorno.Resultado.ERROR_2;
        }
    }

    //Pre:
    //Pos: Borra el primer nodo
    @Override
    public void borrarInicio() {
        if (this.esVacia()) {
            this.inicio = this.inicio.getSig();
        }

    }

    //Pre:
    //Pos: Borra el último nodo
    @Override
    public void borrarFin() {
        if (!this.esVacia()) {
            if (this.inicio == this.fin) {
                this.borrarInicio();
            } else {
                NodoCrucero aux = this.inicio;
                while (aux.getSig().getSig() != null) {
                    aux = aux.getSig();
                }
                this.fin = aux;
                this.fin.setSig(null);
            }
        }
    }

    //Pre:
    //Pos: Elimina todos los nodos de una lista dada
    @Override
    public void vaciar() {
        while (inicio != null) {
            borrarInicio();
        }
    }

    //Pre:
    //Pos: Recorre y muestra los datos de lista
    @Override
    public void mostrar() {
        if (this.esVacia()) {
            System.out.println("La lista es vacía");
        } else {
            NodoCrucero aux = this.inicio;

            while (aux != null) {
                if (aux.getSig() != null) {
                    System.out.print(aux.getNombre() + " - ");
                } else {
                    System.out.println(aux.getNombre());
                }
                aux = aux.getSig();
            }
        }
    }

    //==================================================//
    //===============  Métodos Complem.  ===============//
    //Pre:
    //Pos: Retorna true si encontró una coincidencia, false si no la encontró
    public boolean buscarCrucero(String ciudad, String nombre) {

        boolean retorno = false;
        NodoCrucero aux = this.inicio;

        while (aux != null) {
            if (aux.getCiudad() == ciudad && aux.getNombre() == nombre) {
                retorno = true;
            }
            aux = aux.getSig();
        }
        return retorno;
    }

    //Pre: lista ordenada
    //Pos: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(String ciudad, String nombre) {
        if (this.esVacia()) {
            return;
        }
        if (this.inicio.getCiudad() == ciudad && this.inicio.getNombre() == nombre) {
            this.borrarInicio();
        } else {
            NodoCrucero aux = this.inicio;
            while (aux.getSig() != null && (aux.getSig().getCiudad() != ciudad && aux.getSig().getNombre() != ciudad)) {
                aux = aux.getSig();
            }
            //Elemento encontrado o final de la lista
            if (aux.getSig() != null) {
                NodoCrucero borrar = aux.getSig();
                aux.setSig(borrar.getSig());
                borrar.setSig(null);
            }
        }
    }

    //Pre:
    //Pos: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos() {
        int cant = 0;
        if (!this.esVacia()) {
            NodoCrucero aux = this.inicio;
            while (aux != null) {
                aux = aux.getSig();
                cant++;
            }
        }
        return cant;
    }

    //Pre:
    //Pos:
    public NodoCrucero obtenerElemento(String ciudad, String nombre) {
        NodoCrucero aux = this.inicio;
        while (aux != null && (aux.getNombre() != ciudad && aux.getNombre() != nombre)) {
            aux = aux.getSig();
        }
        //Elemento encontrado o final de la lista
        return aux;

    }

}
