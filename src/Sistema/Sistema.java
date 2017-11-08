package Sistema;

import Datos.ListaCiudad;
import Dominio.Ciudad;
import Dominio.Crucero;
import Dominio.Servicio;
import Sistema.Retorno.Resultado;

public class Sistema implements ISistema {

    //inicialización de lista de ciudades
    private ListaCiudad ciudades;

    //Pre: cantCiudades >= 0;
    //Post: Setea la cantidad de ciudades que se pueden ingresar
    @Override
    public Retorno crearSistemaReservas(int cantCiudades) {

        Retorno ret = new Retorno();
        ciudades = new ListaCiudad();

        if (cantCiudades >= 0) {
            ciudades.setCantMaxima(cantCiudades);
            ret.resultado = Resultado.OK;
        } else {
            ret.resultado = Resultado.ERROR_1;
        }
        return ret;
    }

    //Pre:
    //Post: Se destruyen la lista ciudades
    @Override
    public Retorno destruirSistemaReservas() {

        Retorno ret = new Retorno();

        ciudades = new ListaCiudad();
        System.gc();
        ret.resultado = Resultado.OK;

        return ret;
    }

    //Pre: ciudad != ""
    //Post: Agrega la ciudad al inicio de la lista de ciudades
    @Override
    public Retorno registrarCiudad(String ciudad) {

        Retorno ret = new Retorno();

        if (ciudades.getCantElementos() < ciudades.getCantMaxima() || ciudades.getCantMaxima() == 0) {

            Ciudad nueva = new Ciudad(ciudad);

            if (ciudades.buscar(nueva) == null) {

                ciudades.insertar(nueva);
                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Resultado.ERROR_1;

            }

        } else {
            ret.resultado = Resultado.ERROR_2;
        }
        return ret;
    }

    //Pre: ciudad != "", nombre != ""
    //Post: Agrega el crucero al inicio de la lista de cruceros de la ciudad y
    //con raking 0 en el sistema de reservas
    @Override
    public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad) {

        Retorno ret = new Retorno();
        Ciudad cityFind = new Ciudad(ciudad);
        Ciudad cityLocated = (Ciudad) ciudades.buscar(cityFind);

        if (estrellas < 1 || estrellas > 5) {
            ret.resultado = Retorno.Resultado.ERROR_1;
        } else if (capacidad < 0) {
            ret.resultado = Resultado.ERROR_2;
        } else {
            if (cityLocated == null) {
                ret.resultado = Resultado.ERROR_4;
            } else {

                Crucero nuevo = new Crucero(nombre, ciudad, capacidad, estrellas);
                Crucero cruceroEncontrado = (Crucero) cityLocated.getCruceros().buscar(nuevo);

                if (cruceroEncontrado != null) {
                    ret.resultado = Resultado.ERROR_3;
                } else {
                    // INSERTAR ORDENADO POR RANKING
                    cityLocated.getCruceros().insertar(nuevo);
                    ret.resultado = Resultado.OK;
                }
            }
        }
        return ret;
    }

    @Override
    public Retorno ingresarServicio(String ciudad, String crucero, String servicio) {
        Retorno ret = new Retorno();

        Ciudad cityFind = new Ciudad(ciudad);
        Ciudad cityLocated = (Ciudad) ciudades.buscar(cityFind);
        Crucero cruiseFind = new Crucero(crucero);

        if (cityLocated != null) {

            Crucero cruiseLocated = (Crucero) cityLocated.getCruceros().buscar(cruiseFind);

            if (cruiseLocated != null) {

                Servicio nuevo = new Servicio(servicio);
                cruiseLocated.getServicios().insertar(nuevo);
                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR_2;
        }

        return ret;
    }

    @Override
    public Retorno borrarServicio(String ciudad, String crucero, String servicio) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno realizarReserva(int cliente, String ciudad, String crucero) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno cancelarReserva(int cliente, String ciudad, String crucero) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno ingresarComentario(String ciudad, String crucero, String comentario, int ranking) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno listarServicios(String ciudad, String crucero) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno listarCrucerosCiudad(String ciudad) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno listarCrucerosRankingAsc(String ciudad) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno listarCrucerosRankingDesc(String ciudad) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno listarCrucerosRanking() {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno listarComentarios(String ciudad, String crucero) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno cargarDistancias(int[][] ciudades) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno buscarCamino(int[][] m, String origen, String destino) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

}
