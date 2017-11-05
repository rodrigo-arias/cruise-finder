package cruisefind;

import ciudad.ListaCiudad;
import cruisefind.Retorno.Resultado;

public class Sistema implements ISistema {

    //inicialización de lista de ciudades
    private ListaCiudad lciudad;

    //Pre: cantCiudades >= 0;
    //Post:
    @Override
    public Retorno crearSistemaReservas(int cantCiudades) {

        Retorno ret = new Retorno();
        lciudad = new ListaCiudad();

        if (cantCiudades >= 0) {
            lciudad.setCantMaxima(cantCiudades);
            ret.resultado = Resultado.OK;
        } else {
            ret.resultado = Resultado.ERROR_1;
        }
        return ret;
    }

    @Override
    public Retorno destruirSistemaReservas() {
        Retorno ret = new Retorno();

        System.gc();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno registrarCiudad(String ciudad) {

        Retorno ret = new Retorno();

        ret.resultado = lciudad.agregarInicio(ciudad);

        return ret;
    }

    @Override
    public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno ingresarServicio(String ciudad, String crucero, String servicio) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

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
