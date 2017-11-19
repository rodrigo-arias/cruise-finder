package Sistema;

import Datos.ListaIndice;
import Datos.NodoLista;
import Dominio.Crucero;

public class Utilidad {

    public Retorno.Resultado retornarResultado(Retorno metodo) {
        return metodo.resultado;
    }

    public void insertarIndiceRanking(ListaIndice<Crucero> indice, Crucero nuevo) {
        indice.insert(nuevo);
    }

    public void actualizarIndiceRanking(ListaIndice<Crucero> indice, Crucero cruise) {
        indice.delete(cruise);
        indice.insert(cruise);
    }

    //Pre:
    //Pos: muestra los datos de la lista en orden de enlace
    public void listarIndiceRankingAsc(NodoLista aux, String ciudad) {
        if (aux != null) {
            Crucero crucero = (Crucero) aux.getElement();

            if (crucero.getCiudad() == ciudad) {
                System.out.println(crucero.getNombre() + " - " + crucero.getRanking());
            }

            listarIndiceRankingAsc(aux.getNext(), ciudad);
        }
    }

    //Pre:
    //Pos: muestra los datos de la lista en orden inverso
    public void listarIndiceRankingDesc(NodoLista aux, String ciudad) {
        if (aux != null) {
            Crucero crucero = (Crucero) aux.getElement();

            listarIndiceRankingDesc(aux.getNext(), ciudad);

            if (crucero.getCiudad() == ciudad) {
                System.out.println(crucero.getNombre() + " - " + crucero.getRanking());
            }
        }
    }

    //Pre:
    //Pos: muestra los datos de la lista en orden de enlace
    public void listarIndiceRanking(NodoLista aux) {
        if (aux != null) {
            Crucero crucero = (Crucero) aux.getElement();

            listarIndiceRanking(aux.getNext());
            System.out.println(crucero.getCiudad() + " - " + crucero.getNombre() + " - " + crucero.getRanking());
        }
    }
}
