package cruisefind;

public interface ISistema {

    Retorno crearSistemaReservas(int cantCiudades);

    Retorno destruirSistemaReservas();

    Retorno registrarCiudad(String ciudad);

    Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad);

    Retorno ingresarServicio(String ciudad, String crucero, String servicio);

    Retorno borrarServicio(String ciudad, String crucero, String servicio);

    Retorno realizarReserva(int cliente, String ciudad, String crucero);

    Retorno cancelarReserva(int cliente, String ciudad, String crucero);

    Retorno ingresarComentario(String ciudad, String crucero, String comentario, int ranking);

    Retorno listarServicios(String ciudad, String crucero);

    Retorno listarCrucerosCiudad(String ciudad);

    Retorno listarCrucerosRankingAsc(String ciudad);

    Retorno listarCrucerosRankingDesc(String ciudad);

    Retorno listarCrucerosRanking();

    Retorno listarComentarios(String ciudad, String crucero);

    Retorno cargarDistancias(int[][] ciudades);

    Retorno buscarCamino(int[][] m, String origen, String destino);

}
