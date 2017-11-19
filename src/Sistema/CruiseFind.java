package Sistema;

public class CruiseFind {

    public static void main(String[] args) {

        //declaración global
        Sistema s = new Sistema();
        Prueba p = new Prueba();
        //llamada a pruebas
        //        Prueba11_crearSistemaReservas(s, p);
        //        Prueba12_destruirSistemaReservas(s, p);
        Prueba13_registrarCiudad(s, p);
        //        Prueba14_registrarCrucero(s, p);
        //        Prueba15_ingresarServicio(s, p);
        //        Prueba16_borrarServicio(s, p);
        //        Prueba17_realizarRerserva(s, p);
        //        Prueba18_cancelarRerserva(s, p);
        //        Prueba19_ingresarComentario(s, p);
        //        Prueba110_listarServicios(s, p);
        //        Prueba111_listarCrucerosCiudad(s, p);
        //        Prueba112_listarCrucerosRanking(s, p);
        //        Prueba114_listarComentarios(s, p);
        Prueba20_buscarCamino(s, p);
        //PruebaIncremental(s, p);
    }

    //declaración de pruebas
    public static void Prueba11_crearSistemaReservas(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.crearSistemaReservas(0), Retorno.Resultado.OK, "Se creó el sistema de reservas sin límite de ciudades");
        p.ver(s.crearSistemaReservas(-1), Retorno.Resultado.ERROR_1, "La cantidad de ciudades no pueden ser menores a 0");
        p.imprimirResultadosPrueba();

    }

    public static void Prueba12_destruirSistemaReservas(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(1), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.destruirSistemaReservas(), Retorno.Resultado.OK, "Se destruyó el sistema de reservas");
        p.imprimirResultadosPrueba();

    }

    public static void Prueba13_registrarCiudad(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(6), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("New York"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCiudad("Panamá"), Retorno.Resultado.OK, "Se ingresó Santiago");
        p.ver(s.registrarCiudad("San Pablo"), Retorno.Resultado.OK, "Se ingresó Lima");
        p.ver(s.registrarCiudad("Lima"), Retorno.Resultado.OK, "Se ingresó San Pablo");
        p.ver(s.registrarCiudad("Santiago"), Retorno.Resultado.OK, "Se ingresó Panamá");
        p.ver(s.registrarCiudad("New York"), Retorno.Resultado.ERROR_1, "Montevideo ya existe");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó New York");
        p.ver(s.registrarCiudad("Buenos Aires"), Retorno.Resultado.ERROR_2, "Se sobrepasa el límite de ciudades gestionados por el sistema");
        p.imprimirResultadosPrueba();

    }

    public static void Prueba14_registrarCrucero(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresó Royal Caribbean Int. en Montevideo");
        p.ver(s.registrarCrucero("Santiago", "Carnival Cruise Lines", 6, 2800), Retorno.Resultado.ERROR_1, "La cantidad de estrellas no está entre 1 y 5");
        p.ver(s.registrarCrucero("Santiago", "Royal Caribbean Int.", 5, -1), Retorno.Resultado.ERROR_2, "La capacidad es menor a 0");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 4, 3100), Retorno.Resultado.ERROR_3, "Ya existe un crucero con ese nombre para Montevideo");
        p.ver(s.registrarCrucero("Lima", "Disney Cruise Line", 5, 2200), Retorno.Resultado.ERROR_4, "La ciudad no existe");
        p.ver(s.registrarCiudad("Santiago"), Retorno.Resultado.OK, "Se ingresó Santiago");
        p.ver(s.registrarCrucero("Santiago", "Disney Cruise Line", 5, 2200), Retorno.Resultado.OK, "Se registró el crucero en Santiago");
        p.ver(s.listarCrucerosCiudad("Santiago"), Retorno.Resultado.OK, "Listado de Cruceros en Santiago");
        p.imprimirResultadosPrueba();
    }

    public static void Prueba15_ingresarServicio(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresó Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino"), Retorno.Resultado.OK, "Se ingresó Casino como servicio del Royal Caribbean Int. en Montevideo");
        p.imprimirResultadosPrueba();
    }

    public static void Prueba16_borrarServicio(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresó Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino"), Retorno.Resultado.OK, "Se ingresó Casino como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.borrarServicio("Montevideo", "Disney Cruise Line", "Casino"), Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.borrarServicio("Montevideo", "Royal Caribbean Int.", "Piscina"), Retorno.Resultado.ERROR_2, "No existe un servicio Piscina en el Royal Caribbean Int.");
        p.ver(s.borrarServicio("Santiago", "Royal Caribbean Int.", "Casino"), Retorno.Resultado.ERROR_3, "No existe la ciudad Santiago");
        p.imprimirResultadosPrueba();
    }

    public static void Prueba17_realizarRerserva(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3), Retorno.Resultado.OK, "Se ingresó Royal Caribbean Int. en Montevideo");
        p.ver(s.realizarReserva(1, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realizó la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(2, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realizó la reserva del cliente 2 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(3, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realizó la reserva del cliente 3 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(4, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "El cliente 4 quedó en lista de espera para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(5, "Montevideo", "Disney Cruise Line"), Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.realizarReserva(6, "San Pablo", "Royal Caribbean Int."), Retorno.Resultado.ERROR_2, "No existe la ciudad San Pablo");
        p.imprimirResultadosPrueba();
    }

    public static void Prueba18_cancelarRerserva(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3), Retorno.Resultado.OK, "Se ingresó Royal Caribbean Int. en Montevideo");
        p.ver(s.realizarReserva(1, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realizó la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(2, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realizó la reserva del cliente 2 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(1, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realizó la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(4, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "El cliente 4 quedó en lista de espera para el Royal Caribbean Int. de Montevideo");
        p.ver(s.cancelarReserva(1, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se canceló la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo, pasa el cliente 4 de a lista de espera");
        p.ver(s.cancelarReserva(5, "Montevideo", "Disney Cruise Line"), Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.cancelarReserva(7, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.ERROR_2, "El cliente 7 no tiene reservas para el Royal Caribbean Int. de Montevideo");
        p.ver(s.cancelarReserva(2, "San Pablo", "Royal Caribbean Int."), Retorno.Resultado.ERROR_3, "No existe la ciudad San Pablo");
        p.imprimirResultadosPrueba();
    }

    public static void Prueba19_ingresarComentario(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresó Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "El crucero es excelente", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Royal Caribbean Int. de Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "No me gusto nada", -1), Retorno.Resultado.ERROR_1, "El ranking del comentario no está entre 0 y 5");
        p.ver(s.ingresarComentario("Montevideo", "Disney Cruise Line", "El crucero está muy bueno", 4), Retorno.Resultado.ERROR_2, "No se encontró un crucero con ese nombre para Montevideo");
        p.ver(s.ingresarComentario("San Pablo", "Royal Caribbean Int.", "Se pueden mejorar algunas cosas", 3), Retorno.Resultado.ERROR_3, "No se encontró la ciudad San Pablo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Tienen que mejorar la limpieza", 2), Retorno.Resultado.OK, "Se ingresó un comentario en el Royal Caribbean Int. de Montevideo");
        p.imprimirResultadosPrueba();
    }

    public static void Prueba110_listarServicios(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresó Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino"), Retorno.Resultado.OK, "Se ingresó Casino como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Piscina"), Retorno.Resultado.OK, "Se ingresó Piscina como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Masajes"), Retorno.Resultado.OK, "Se ingresó Masajes como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Habitación King"), Retorno.Resultado.OK, "Se ingresó Habitación King Casino como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.listarServicios("Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se listan los serivios del Royal Caribbean Int. en Montevideo");
        p.ver(s.listarServicios("Montevideo", "Disney Cruise Line"), Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.listarServicios("San Pablo", "Royal Caribbean Int."), Retorno.Resultado.ERROR_2, "No existe la ciudad San Pablo");
        p.imprimirResultadosPrueba();
    }

    public static void Prueba111_listarCrucerosCiudad(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("San Pablo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCrucero("San Pablo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresó Royal Caribbean Int. en San Pablo");
        p.ver(s.registrarCrucero("San Pablo", "Carnival Cruise Lines", 4, 2800), Retorno.Resultado.OK, "Se ingresó Carnival Cruise Lines en San Pablo");
        p.ver(s.registrarCrucero("San Pablo", "Celebrity Reflection", 3, 1300), Retorno.Resultado.OK, "Se ingresó Celebrity Reflection en San Pablo");
        p.ver(s.registrarCrucero("San Pablo", "Disney Cruise Line", 5, 2200), Retorno.Resultado.OK, "Se ingresó Disney Cruise Line en San Pablo");
        p.ver(s.listarCrucerosCiudad("San Pablo"), Retorno.Resultado.OK, "Se listan los cruceros de San Pablo por nombre");
        p.ver(s.listarCrucerosCiudad("Lima"), Retorno.Resultado.ERROR_1, "No existe la ciudad Lima");
        p.imprimirResultadosPrueba();
    }

    public static void Prueba112_listarCrucerosRanking(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("Lima"), Retorno.Resultado.OK, "Se ingresó Lima");
        p.ver(s.registrarCiudad("Bogotá"), Retorno.Resultado.OK, "Se ingresó Bogotá");
        p.ver(s.registrarCrucero("Lima", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresó Royal Caribbean Int. en Lima");
        p.ver(s.registrarCrucero("Lima", "Carnival Cruise Lines", 4, 2800), Retorno.Resultado.OK, "Se ingresó Carnival Cruise Lines en Lima");
        p.ver(s.registrarCrucero("Bogotá", "Carnival Cruise Lines", 4, 2800), Retorno.Resultado.OK, "Se ingresó Carnival Cruise Lines en Bogotá");
        p.ver(s.registrarCrucero("Lima", "Celebrity Reflection", 3, 1300), Retorno.Resultado.OK, "Se ingresó Celebrity Reflection en Lima");
        p.ver(s.registrarCrucero("Lima", "Disney Cruise Line", 5, 2200), Retorno.Resultado.OK, "Se ingresó Disney Cruise Line en Lima");
        p.ver(s.ingresarComentario("Lima", "Royal Caribbean Int.", "Recomendable", 3), Retorno.Resultado.OK, "Se ingresó un comentario en el Royal Caribbean Int. de Lima");
        p.ver(s.ingresarComentario("Lima", "Celebrity Reflection", "El crucero es excelente", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Celebrity Reflection de Lima");
        p.ver(s.ingresarComentario("Lima", "Disney Cruise Line", "Descuidada la higiene", 2), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Lima");
        p.ver(s.listarCrucerosCiudad("Lima"), Retorno.Resultado.OK, "Se listan los cruceros de Lima por ranking ascendente");
        p.ver(s.listarCrucerosRankingAsc("Lima"), Retorno.Resultado.OK, "Se listan los cruceros de Lima por ranking ascendente");
        p.ver(s.listarCrucerosRankingAsc("Bogotá"), Retorno.Resultado.OK, "Se listan los cruceros de Bogotá por ranking ascendente");
        p.ver(s.listarCrucerosRankingAsc("New York"), Retorno.Resultado.ERROR_1, "No existe la ciudad New York");
        p.ver(s.listarCrucerosRankingDesc("Lima"), Retorno.Resultado.OK, "Se listan los cruceros de Lima por ranking descendente");
        p.ver(s.ingresarComentario("Lima", "Disney Cruise Line", "Excelente", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Lima");
        p.ver(s.ingresarComentario("Lima", "Disney Cruise Line", "Me encantó", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Lima");
        p.ver(s.listarCrucerosRankingDesc("Lima"), Retorno.Resultado.OK, "Se listan los cruceros de Lima por ranking descendente");
        p.ver(s.listarCrucerosRankingDesc("Buenos Aires"), Retorno.Resultado.ERROR_1, "No existe la ciudad New York");
        p.ver(s.listarCrucerosRanking(), Retorno.Resultado.OK, "Se listan todos los cruceros por ranking");
        p.imprimirResultadosPrueba();
    }

    public static void Prueba114_listarComentarios(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresó Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Excelente", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Me gustó mucho", 4), Retorno.Resultado.OK, "Se ingresó un comentario en el Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Muy recomendable, excelente piscina", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "La comida estaba en mal estado", 2), Retorno.Resultado.OK, "Se ingresó un comentario en el Royal Caribbean Int. en Montevideo");
        p.ver(s.listarComentarios("Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se listan los serivios del Royal Caribbean Int. en Montevideo");
        p.ver(s.listarComentarios("Montevideo", "Disney Cruise Line"), Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.listarComentarios("San Pablo", "Royal Caribbean Int."), Retorno.Resultado.ERROR_2, "No existe la ciudad San Pablo");
        p.imprimirResultadosPrueba();
    }

    public static void Prueba20_buscarCamino(Sistema s, Prueba p) {

        /* última ciudad ingresada es el inicio de la matriz */
        int matriz[][] = {{0, 10, 25, 15, 30, 0}, {10, 0, 20, 0, 0, 0}, {25, 20, 0, 0, 0, 40}, {15, 0, 0, 0, 0, 45}, {30, 0, 0, 0, 0, 25}, {0, 0, 40, 45, 25, 0}};
        s.cargarDistancias(matriz);
        System.out.println(s.buscarCamino("Montevideo", "New York").valorString);
        System.out.println(s.buscarCamino("Lima", "New York").valorString);
        System.out.println(s.buscarCamino("Montevideo", "Montevideo").valorString);
        System.out.println(s.buscarCamino("Montevideo", "Buenos Aires").valorString);
        System.out.println(s.buscarCamino("Montevideo", "Lima").valorString);

    }

    public static void PruebaIncremental(Sistema s, Prueba p) {

        //Crear Sistema
        p.ver(s.crearSistemaReservas(6), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.crearSistemaReservas(0), Retorno.Resultado.OK, "Se creó el sistema de reservas sin límite de ciudades");
        p.ver(s.crearSistemaReservas(-1), Retorno.Resultado.ERROR_1, "La cantidad de ciudades no pueden ser menores a 0");

        //Destruir Sistema
        p.ver(s.destruirSistemaReservas(), Retorno.Resultado.OK, "Se destruyó el sistema de reservas");

        //Registrar Ciudad
        p.ver(s.crearSistemaReservas(6), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCiudad("Santiago"), Retorno.Resultado.OK, "Se ingresó Santiago");
        p.ver(s.registrarCiudad("Lima"), Retorno.Resultado.OK, "Se ingresó Lima");
        p.ver(s.registrarCiudad("San Pablo"), Retorno.Resultado.OK, "Se ingresó San Pablo");
        p.ver(s.registrarCiudad("Panamá"), Retorno.Resultado.OK, "Se ingresó Panamá");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.ERROR_1, "Montevideo ya existe");
        p.ver(s.registrarCiudad("New York"), Retorno.Resultado.OK, "Se ingresó New York");
        p.ver(s.registrarCiudad("Buenos Aires"), Retorno.Resultado.ERROR_2, "Se sobrepasa el límite de ciudades gestionados por el sistema");

        s.ciudades.show();

        //Registrar Crucero
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresó Royal Caribbean Int. en Montevideo");
        p.ver(s.registrarCrucero("Santiago", "Carnival Cruise Lines", 6, 2800), Retorno.Resultado.ERROR_1, "La cantidad de estrellas no está entre 1 y 5");
        p.ver(s.registrarCrucero("Santiago", "Royal Caribbean Int.", 5, -1), Retorno.Resultado.ERROR_2, "La capacidad es menor a 0");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 4, 3100), Retorno.Resultado.ERROR_3, "Ya existe un crucero con ese nombre para Montevideo");
        p.ver(s.registrarCrucero("Asuncion", "Disney Cruise Line", 5, 2200), Retorno.Resultado.ERROR_4, "La ciudad no existe");
        p.ver(s.registrarCrucero("Santiago", "Royal Caribbean Int.", 4, 2000), Retorno.Resultado.OK, "Se registró el crucero en Santiago");
        p.ver(s.registrarCrucero("Santiago", "Disney Cruise Line", 5, 2200), Retorno.Resultado.OK, "Se registró el crucero en Santiago");
        p.ver(s.registrarCrucero("Santiago", "Carnival Cruise Lines", 3, 1800), Retorno.Resultado.OK, "Se registró el crucero en Santiago");
        p.ver(s.listarCrucerosCiudad("Santiago"), Retorno.Resultado.OK, "Listado de Cruceros en Santiago");

        //Ingresar Comentario
        p.ver(s.ingresarComentario("Santiago", "Royal Caribbean Int.", "Me gusto", 4), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Tienen que mejorar la limpieza", 2), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Santiago", "Carnival Cruise Lines", "Excelente", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Carnival Cruise Lines de Santiago");

        //Listar Cruceros Ranking
        s.listarCrucerosRankingAsc("Santiago");
        System.out.println();
        s.listarCrucerosRankingDesc("Santiago");
        System.out.println();
        s.listarCrucerosRanking();

        p.ver(s.ingresarComentario("Santiago", "Royal Caribbean Int.", "No me gustó", 2), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Me encantó", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Me encantó", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Me encantó", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Me encantó", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");

        s.listarCrucerosRankingAsc("Santiago");
        System.out.println();
        s.listarCrucerosRankingDesc("Santiago");
        System.out.println();
        s.listarCrucerosRanking();

        /*
        //Ingresar Servicio
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino"), Retorno.Resultado.OK, "Se ingresó Casino como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Piscina"), Retorno.Resultado.OK, "Se ingresó Piscina como servicio del Royal Caribbean Int. en Montevideo");
        //FALTAN ERRORES DE INGRESAR SERVICIO
        p.ver(s.listarServicios("Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Listado de servicios de Royal Caribbean Int. en Santiago");
         */
        //Imprimir Pruebas
        p.imprimirResultadosPrueba();

    }

}
