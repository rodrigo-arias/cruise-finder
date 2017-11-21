package Sistema;

import Dominio.Ciudad;
import Dominio.Crucero;

public class Main {

    public static void main(String[] args) {

        Sistema s = new Sistema();
        Prueba p = new Prueba();
        PruebaIncremental(s, p);
    }

    public static void PruebaIncremental(Sistema s, Prueba p) {

        //1.1.Crear Sistema de Reservas
        p.ver(s.crearSistemaReservas(6), Retorno.Resultado.OK, "Se creó el sistema de reservas con límite de ciudades");
        p.ver(s.crearSistemaReservas(0), Retorno.Resultado.OK, "Se creó el sistema de reservas sin límite de ciudades");
        p.ver(s.crearSistemaReservas(-1), Retorno.Resultado.ERROR_1, "La cantidad de ciudades no pueden ser menores a 0");

        //1.2.Destruir Sistema de Reservas
        p.ver(s.destruirSistemaReservas(), Retorno.Resultado.OK, "Se destruyó el sistema de reservas");
        p.ver(s.crearSistemaReservas(6), Retorno.Resultado.OK, "Se creó el sistema de reservas");

        //1.3.Registrar Ciudad
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCiudad("Santiago"), Retorno.Resultado.OK, "Se ingresó Santiago");
        p.ver(s.registrarCiudad("Lima"), Retorno.Resultado.OK, "Se ingresó Lima");
        p.ver(s.registrarCiudad("San Pablo"), Retorno.Resultado.OK, "Se ingresó San Pablo");
        p.ver(s.registrarCiudad("Panamá"), Retorno.Resultado.OK, "Se ingresó Panamá");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.ERROR_1, "Montevideo ya existe");
        p.ver(s.registrarCiudad("New York"), Retorno.Resultado.OK, "Se ingresó New York");
        p.ver(s.registrarCiudad("Buenos Aires"), Retorno.Resultado.ERROR_2, "Se sobrepasa el límite de ciudades gestionados por el sistema");
        s.ciudades.show();

        //1.4.Registrar Crucero
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3), Retorno.Resultado.OK, "Se ingresó Royal Caribbean Int. en Montevideo");
        p.ver(s.registrarCrucero("Santiago", "Carnival Cruise Lines", 6, 2800), Retorno.Resultado.ERROR_1, "La cantidad de estrellas no está entre 1 y 5");
        p.ver(s.registrarCrucero("Santiago", "Royal Caribbean Int.", 5, -1), Retorno.Resultado.ERROR_2, "La capacidad es menor a 0");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 4, 3100), Retorno.Resultado.ERROR_3, "Ya existe un crucero con ese nombre para Montevideo");
        p.ver(s.registrarCrucero("Asuncion", "Disney Cruise Line", 5, 2200), Retorno.Resultado.ERROR_4, "La ciudad no existe");
        p.ver(s.registrarCrucero("Santiago", "Royal Caribbean Int.", 4, 2000), Retorno.Resultado.OK, "Se registró el crucero Royal Caribbean Int. en Santiago");
        p.ver(s.registrarCrucero("Santiago", "Disney Cruise Line", 5, 2200), Retorno.Resultado.OK, "Se registró el crucero Disney Cruise Line en Santiago");
        p.ver(s.registrarCrucero("Santiago", "Carnival Cruise Lines", 3, 1800), Retorno.Resultado.OK, "Se registró el crucero Carnival Cruise Lines en Santiago");
        p.ver(s.listarCrucerosCiudad("Santiago"), Retorno.Resultado.OK, "Listado de Cruceros en Santiago");

        //1.5.Ingresar Servicio
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino"), Retorno.Resultado.OK, "Se ingresó Casino como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Carnival Cruise Lines", "Masajes"), Retorno.Resultado.ERROR_1, "No existe el crucero en Montevideo");
        p.ver(s.ingresarServicio("Buenos Aires", "Royal Caribbean Int.", "Piscina"), Retorno.Resultado.ERROR_2, "No existe la ciudad en el sistema");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Piscina"), Retorno.Resultado.OK, "Se ingresó Piscina como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Masajes"), Retorno.Resultado.OK, "Se ingresó Masajes como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.listarServicios("Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Listado de servicios de Royal Caribbean Int. en Santiago");

        //1.6.Borrar Servicio
        p.ver(s.borrarServicio("Montevideo", "Royal Caribbean Int.", "Piscina"), Retorno.Resultado.OK, "Se eliminó Piscina como servicio del Royal Caribbean Int. de Montevideo");
        p.ver(s.borrarServicio("Montevideo", "Carnival Cruise Lines", "Masajes"), Retorno.Resultado.ERROR_1, "No existe el crucero en Montevideo");
        p.ver(s.borrarServicio("Montevideo", "Royal Caribbean Int.", "Pensión completa"), Retorno.Resultado.ERROR_2, "No existe el servicio");
        p.ver(s.borrarServicio("Buenos Aires", "Royal Caribbean Int.", "Piscina"), Retorno.Resultado.ERROR_3, "No existe la ciudad en el sistema");
        p.ver(s.listarServicios("Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Listado de servicios de Royal Caribbean Int. en Santiago");

        //1.7.Realizar Reserva
        p.ver(s.realizarReserva(1, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realizó la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(2, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realizó la reserva del cliente 2 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(3, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realizó la reserva del cliente 3 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(4, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "El cliente 4 quedó en lista de espera para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(5, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "El cliente 5 quedó en lista de espera para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(6, "Montevideo", "Disney Cruise Line"), Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.realizarReserva(7, "Bogotá", "Royal Caribbean Int."), Retorno.Resultado.ERROR_2, "No existe la ciudad Bogotá");

        Ciudad citytemp = new Ciudad("Montevideo");
        Ciudad cityfound = s.ciudades.find(citytemp);
        Crucero cruisetemp = new Crucero("Royal Caribbean Int.", "Montevideo");
        Crucero cruisefound = cityfound.getCruceros().find(cruisetemp);
        cruisefound.getReservas().show();
        cruisefound.getEsperas().show();

        //1.8.Cancelar Reserva
        p.ver(s.cancelarReserva(2, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se canceló la reserva del cliente 2 para el Royal Caribbean Int. de Montevideo, pasa el cliente 4 de la lista de espera");
        p.ver(s.cancelarReserva(5, "Montevideo", "Disney Cruise Line"), Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.cancelarReserva(7, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.ERROR_2, "El cliente 7 no tiene reservas para el Royal Caribbean Int. de Montevideo");
        p.ver(s.cancelarReserva(2, "Asunción", "Royal Caribbean Int."), Retorno.Resultado.ERROR_3, "No existe la ciudad Asunción");

        cruisefound.getReservas().show();
        cruisefound.getEsperas().show();

        //1.9.Ingresar Comentario
        p.ver(s.ingresarComentario("Santiago", "Royal Caribbean Int.", "Me gusto", 4), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Santiago", "Royal Caribbean Int.", "Me gusto", 4), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Tienen que mejorar la limpieza", 2), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Santiago", "Carnival Cruise Lines", "Excelente", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Carnival Cruise Lines de Santiago");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "No me gusto nada", -1), Retorno.Resultado.ERROR_1, "El ranking del comentario no está entre 0 y 5");
        p.ver(s.ingresarComentario("Montevideo", "Disney Cruise Line", "El crucero está muy bueno", 4), Retorno.Resultado.ERROR_2, "No se encontró un crucero con ese nombre para Montevideo");
        p.ver(s.ingresarComentario("Asunción", "Royal Caribbean Int.", "Se pueden mejorar algunas cosas", 3), Retorno.Resultado.ERROR_3, "No se encontró la ciudad Asunción");
        s.listarCrucerosRanking();

        p.ver(s.ingresarComentario("Santiago", "Royal Caribbean Int.", "No me gustó", 2), Retorno.Resultado.OK, "Se ingresó un comentario en el Royal Caribbean Int. de Santiago");
        p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Me encantó", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Me encantó", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Me encantó", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Me encantó", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
        s.listarCrucerosRanking();

        //1.10.Listado de Servicios
        p.ver(s.listarServicios("Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Listado de servicios de Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Habitación King"), Retorno.Resultado.OK, "Se ingresó Habitación King como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.listarServicios("Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Listado de servicios de Royal Caribbean Int. en Montevideo");
        p.ver(s.listarServicios("New York", "Disney Cruise Line"), Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en New York");
        p.ver(s.listarServicios("Asunción", "Royal Caribbean Int."), Retorno.Resultado.ERROR_2, "No existe la ciudad Asunción");

        //1.11.Listado de Cruceros por Ciudad
        p.ver(s.listarCrucerosCiudad("Santiago"), Retorno.Resultado.OK, "Se listan los cruceros de Santiago por nombre");
        p.ver(s.registrarCrucero("Santiago", "Costa Concordia", 3, 3), Retorno.Resultado.OK, "Se ingresó Costa Concordia en Santiago");
        p.ver(s.listarCrucerosCiudad("Santiago"), Retorno.Resultado.OK, "Se listan los cruceros de Santiago por nombre");
        p.ver(s.listarCrucerosCiudad("Brasilia"), Retorno.Resultado.ERROR_1, "No existe la ciudad Brasilia");

        //1.12.Listado de Cruceros por Ranking para una ciudad
        p.ver(s.listarCrucerosRankingAsc("Santiago"), Retorno.Resultado.OK, "Se listan los cruceros de Santiago por ranking ascendente");
        p.ver(s.listarCrucerosRankingAsc("Bogotá"), Retorno.Resultado.ERROR_1, "No existe la ciudad Bogotá");
        p.ver(s.listarCrucerosRankingDesc("Santiago"), Retorno.Resultado.OK, "Se listan los cruceros de Santiago por ranking ascendente");
        p.ver(s.listarCrucerosRankingDesc("Bogotá"), Retorno.Resultado.ERROR_1, "No existe la ciudad Bogotá");

        //1.13.Listado de Cruceros por Ranking
        s.listarCrucerosRanking();
        p.ver(s.ingresarComentario("Santiago", "Costa Concordia", "Aceptable", 3), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
        s.listarCrucerosRanking();

        //1.14.Listado de Comentarios
        p.ver(s.listarComentarios("Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se listan los serivios del Royal Caribbean Int. en Montevideo");
        p.ver(s.listarComentarios("Montevideo", "Disney Cruise Line"), Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.listarComentarios("Brasilia", "Royal Caribbean Int."), Retorno.Resultado.ERROR_2, "No existe la ciudad Brasilia");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Mala limpieza", 2), Retorno.Resultado.OK, "Se ingresó un comentario en el Royal Caribbean Int. de Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Aceptable", 3), Retorno.Resultado.OK, "Se ingresó un comentario en el Royal Caribbean Int. de Montevideo");
        p.ver(s.listarComentarios("Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se listan los serivios del Royal Caribbean Int. en Montevideo");

        //2.1.Cargar Matriz de Distancias
        int[][] matrizError = {{0, 10, 25, 15, 30, 0}};
        int[][] matrizDistance = {{0, 10, 25, 15, 30, 0}, {10, 0, 20, 0, 0, 0}, {25, 20, 0, 0, 0, 40}, {15, 0, 0, 0, 0, 45}, {30, 0, 0, 0, 0, 25}, {0, 0, 40, 45, 25, 0}};
        /* nota: última ciudad ingresada corresponde al primer elemento de la matriz */
        p.ver(s.cargarDistancias(matrizError), Retorno.Resultado.ERROR_1, "La dimensión de la matriz no coincide con la cantidad de ciudades del sistema");
        p.ver(s.cargarDistancias(matrizDistance), Retorno.Resultado.OK, "Se cargó la matriz de distancias");

        //2.2.Camino más corto
        p.ver(s.buscarCamino(matrizDistance, "Montevideo", "New York"), Retorno.Resultado.OK, "Se muestra el camino mas corto de Montevideo a New York");
        p.ver(s.buscarCamino(matrizDistance, "Lima", "New York"), Retorno.Resultado.OK, "Se muestra el camino mas corto de Lima a New York");
        p.ver(s.buscarCamino(matrizDistance, "Buenos Aires", "San Pablo"), Retorno.Resultado.ERROR_1, "La ciudad origen no existe en el sistema");
        p.ver(s.buscarCamino(matrizDistance, "Montevideo", "Buenos Aires"), Retorno.Resultado.ERROR_2, "La ciudad destino no existe en el sistema");
        p.ver(s.buscarCamino(matrizDistance, "Montevideo", "Montevideo"), Retorno.Resultado.ERROR_3, "Se ingresó un origen y destino iguales");
        p.ver(s.buscarCamino(matrizDistance, "Montevideo", "Lima"), Retorno.Resultado.OK, "Se muestra el camino mas corto de Montevideo a New York");

        //Imprimir Pruebas
        p.imprimirResultadosPrueba();
    }
}
