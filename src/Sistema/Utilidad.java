package Sistema;

import Datos.ListaIndice;
import Datos.NodoLista;
import Dominio.Crucero;

public class Utilidad {

    //Pre: el crucero no debe encontrarse en la lista
    //Pos: inserta el crucero en la lista por orden de ranking descendente
    public void insertarIndiceRanking(ListaIndice<Crucero> indice, Crucero nuevo) {
        indice.insert(nuevo);
    }

    //Pre: crucero debe encontrarse en la lista
    //Pos: elimina el crucero y lo vuelve a insertar por orden de ranking descendente
    public void actualizarIndiceRanking(ListaIndice<Crucero> indice, Crucero cruise) {
        indice.delete(cruise);
        indice.insert(cruise);
    }

    //Pre:
    //Pos: muestra nombre y ranking de los cruceros  para la ciudad por ranking ascendente
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
    //Pos: imprime nombre y ranking de los cruceros  para la ciudad por ranking desscendente
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
    //Pos: imprime ciudad, nombre y ranking de los cruceros por ranking ascendente
    public void listarIndiceRanking(NodoLista aux) {
        if (aux != null) {
            Crucero crucero = (Crucero) aux.getElement();

            listarIndiceRanking(aux.getNext());
            System.out.println(crucero.getCiudad() + " - " + crucero.getNombre() + " - " + crucero.getRanking());
        }
    }
}
