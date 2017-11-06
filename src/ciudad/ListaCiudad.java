package ciudad;

import cruisefind.Retorno;

public class ListaCiudad implements IListaCiudad {

    private NodoCiudad inicio;
    private NodoCiudad fin;
    private int cantMaxima;
    private int cantElementos;

    public ListaCiudad() {
        this.inicio = null;
        this.fin = null;
        this.cantMaxima = 0;
        this.cantElementos = 0;
    }

    //==================================================//
    //==================  Properties  ==================//
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
    public Retorno.Resultado agregarInicio(String ciudad) {

        if (cantElementos < cantMaxima || cantMaxima == 0) {

            if (!this.buscarCiudad(ciudad)) {

                //Creo el nuevo nodo y le asigno el siguiente
                NodoCiudad nuevo = new NodoCiudad(ciudad);
                nuevo.setSig(inicio);

                //Asigno el nuevo elemento al inicio y sumo la cantidad
                this.inicio = nuevo;
                this.cantElementos++;

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
    }

    //Pre:
    //Pos: Agrega un nuevo Nodo al final de la lista
    @Override
    public Retorno.Resultado agregarFinal(String ciudad) {

        if (cantElementos < cantMaxima || cantMaxima == 0) {

            if (!this.buscarCiudad(ciudad)) {

                if (this.esVacia()) {
                    this.agregarInicio(ciudad);
                } else {

                    NodoCiudad aux = this.inicio;

                    //Identifico el último elemento
                    while (aux.getSig() != null) {
                        aux = aux.getSig();
                    }

                    //Creo el nuevo nodo y le asigno el siguiente al que estaba al final
                    NodoCiudad nuevo = new NodoCiudad(ciudad);
                    aux.setSig(nuevo);

                    //Asigno el nuevo elemento al final y sumo la cantidad
                    this.fin = nuevo;
                    this.cantElementos++;
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
                NodoCiudad aux = this.inicio;
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
            NodoCiudad aux = this.inicio;

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

    //Pre: lista ordenada
    //Pos: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(String ciudad) {
        if (this.esVacia()) {
            return;
        }
        if (this.inicio.getNombre() == ciudad) {
            this.borrarInicio();
        } else {
            NodoCiudad aux = this.inicio;
            while (aux.getSig() != null && aux.getSig().getNombre() != ciudad) {
                aux = aux.getSig();
            }
            //Elemento encontrado o final de la lista
            if (aux.getSig() != null) {
                NodoCiudad borrar = aux.getSig();
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
            NodoCiudad aux = this.inicio;
            while (aux != null) {
                aux = aux.getSig();
                cant++;
            }
        }
        return cant;
    }

    //Pre:
    //Pos:
    public NodoCiudad obtenerElemento(String ciudad) {
        NodoCiudad aux = this.inicio;
        while (aux != null && aux.getNombre() != ciudad) {
            aux = aux.getSig();
        }
        //Elemento encontrado o final de la lista
        return aux;

    }

    //==================================================//
    //=============  Métodos Recursivos. ===============//
    //Pre:
    //Pos: muestra los datos de la lista en orden de enlace
    public void mostrarRec(NodoCiudad n) {
        if (n != null) {
            System.out.println(n.getNombre());
            mostrarRec(n.getSig());
        }
    }

    //Pre:
    //Pos: muestra los datos de la lista en orden inverso
    public void mostrarInversoRec(NodoCiudad n) {
        if (n != null) {
            mostrarInversoRec(n.getSig());
            System.out.println(n.getNombre());
        }

    }

    //Pre:
    //Pos: retorna true si el elemento pertenece a la lista
    public boolean existeDatoRec(NodoCiudad n, String ciudad) {
        if (n != null) {
            if (n.getNombre() == ciudad) {
                return true;
            } else {
                return existeDatoRec(n.getSig(), ciudad);
            }
        } else {
            return false;
        }
    }
}
