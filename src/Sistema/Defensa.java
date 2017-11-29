package Sistema;

public class Defensa {

    public static void main(String[] args) {
        Sistema S = new Sistema();
        Prueba P = new Prueba();

        //prueba0(S, P);
        //preuba1(S, P);
//       prueba2(S,P);
//       prueba3(S,P);
//       prueba4(S,P);
//       prueba5(S,P);
//       prueba6(S,P);
//       prueba7(S,P);
//       prueba8(S,P);
//       prueba9(S,P);
//       prueba10(S,P);
//       prueba11(S,P);
//       prueba12(S,P);
//       prueba13(S,P);
//       prueba14(S,P);
        //prueba15(S, P);
        caminoCorto(S, P);
        mayorCantCiudades(S, P);
    }

    public static void prueba0(Sistema s, Prueba p) {

        System.out.println("------------------CREACION DEL SISTEMA------------------");
        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se crea el sistema de reservas con un tope de 5 ciudades");
        p.ver(s.crearSistemaReservas(-3), Retorno.Resultado.ERROR_1, "No se crea el sistema de reservas por tener tope negativo");

        System.out.println("------------------INGRESO DE CIUDADES------------------");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCiudad("Santiago"), Retorno.Resultado.OK, "Se ingresa Santiago");
        p.ver(s.registrarCiudad("Lima"), Retorno.Resultado.OK, "Se ingresa Lima");
        p.ver(s.registrarCiudad("San Pablo"), Retorno.Resultado.OK, "Se ingresa San Pablo");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.ERROR_1, "Montevideo ya existe");
        p.ver(s.registrarCiudad("Panamá"), Retorno.Resultado.OK, "Se ingresa Panamá");
        p.ver(s.registrarCiudad("New York"), Retorno.Resultado.ERROR_2, "No se ingresa New York, por superar el tope");

        System.out.println("------------------LISTO CIUDADES------------------");
        s.ciudades.toString();//listo ciudades ingresadas

        System.out.println("------------------REGISTRO CRUCEROS------------------");
        p.ver(s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2000), Retorno.Resultado.OK, "Se registra crucero MSC a Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Carnival Cruise Line", 4, 2500), Retorno.Resultado.OK, "Se registra crucero Carnival a Montevideo");
        p.ver(s.registrarCrucero("Panamá", "Costa Cruise", 3, 3000), Retorno.Resultado.OK, "Se registra crucero Costa Cruise a Panamá");
        p.ver(s.registrarCrucero("San Pablo", "Royal Caribbean Int.", 5, 4000), Retorno.Resultado.OK, "Se registra crucero Royal Caribbean Int. a San Pablo");
        p.ver(s.registrarCrucero("Santiago", "Disney Cruise Line", 4, 3200), Retorno.Resultado.OK, "Se registra crucero Disney Cruise Line a Santiago");
        p.ver(s.registrarCrucero("Santiago", "Holland America Line", 6, 2800), Retorno.Resultado.ERROR_1, "La cantidad de estrellas no está entre 1 y 5");
        p.ver(s.registrarCrucero("Santiago", "Princess Cruises", 5, -1), Retorno.Resultado.ERROR_2, "La capacidad es menor a 0");
        p.ver(s.registrarCrucero("Montevideo", "MSC Poesia", 4, 3100), Retorno.Resultado.ERROR_3, "Ya existe un crucero con ese nombre para Montevideo");
        p.ver(s.registrarCrucero("New York", "Norwegian Cruise Line", 5, 3000), Retorno.Resultado.ERROR_4, "La ciudad no existe");

        System.out.println("------------------LISTO CRUCEROS INGRESADOS------------------");
        //s.LCrucero.mostrarTodos();//listo cruceros ingresados

        System.out.println("------------------REGISTRO SERVICIOS------------------");
        p.ver(s.ingresarServicio("Montevideo", "MSC Poesia", "Wifi"), Retorno.Resultado.OK, "Servicio wifi en MSC Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "MSC Poesia", "Shopping a bordo"), Retorno.Resultado.OK, "Servicio Shopping a bordo en MSC Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "MSC Poesia", "Guarderia"), Retorno.Resultado.OK, "Servicio guarderia en MSC Montevideo");
        p.ver(s.ingresarServicio("San Pablo", "Royal Caribbean Int.", "Wifi"), Retorno.Resultado.OK, "Servicio wifi en Royal San Pablo");
        p.ver(s.ingresarServicio("San Pablo", "Royal Caribbean Int.", "Shopping a bordo"), Retorno.Resultado.OK, "Servicio Shopping a bordo en Royal San Pablo");
        p.ver(s.ingresarServicio("San Pablo", "Royal Caribbean Int.", "Guarderia"), Retorno.Resultado.OK, "Servicio guarderia en Royal San Pablo");
        p.ver(s.ingresarServicio("San Pablo", "Holland America Line", "Guarderia"), Retorno.Resultado.ERROR_1, "No existe ese crucero en la ciudad");
        p.ver(s.ingresarServicio("New York", "Norwegian Cruise Line", "Guarderia"), Retorno.Resultado.ERROR_2, "La ciudad no existe");

        System.out.println("------------------ELIMINO SERVICIOS------------------");
        p.ver(s.borrarServicio("Montevideo", "MSC Poesia", "Wifi"), Retorno.Resultado.OK, "Borro servicio wifi en MSC Montevideo");
        p.ver(s.borrarServicio("San Pablo", "Holland America Line", "Guarderia"), Retorno.Resultado.ERROR_1, "No existe ese crucero en la ciudad");
        p.ver(s.borrarServicio("Montevideo", "MSC Poesia", "Lavanderia"), Retorno.Resultado.ERROR_2, "No existe el servicio en el crucero");
        p.ver(s.borrarServicio("New York", "Norwegian Cruise Line", "Guarderia"), Retorno.Resultado.ERROR_3, "La ciudad no existe");

        System.out.println("------------------REALIZO RESERVAS------------------");
        p.ver(s.realizarReserva(1, "Montevideo", "MSC Poesia"), Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(2, "Montevideo", "MSC Poesia"), Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(3, "Montevideo", "MSC Poesia"), Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(4, "Montevideo", "MSC Poesia"), Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(5, "Montevideo", "MSC Poesia"), Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(6, "San Pablo", "Holland America Line"), Retorno.Resultado.ERROR_1, "No existe ese crucero en la ciudad");
        p.ver(s.realizarReserva(7, "New York", "Norwegian Cruise Line"), Retorno.Resultado.ERROR_2, "La ciudad no existe");

        System.out.println("------------------CANCELO RESERVAS------------------");
        p.ver(s.cancelarReserva(2, "Montevideo", "MSC Poesia"), Retorno.Resultado.OK, "Se elimina reserva");
        p.ver(s.cancelarReserva(8, "Montevideo", "MSC Poesia"), Retorno.Resultado.ERROR_2, "El cliente no tiene reserva en el crucero");
        p.ver(s.cancelarReserva(2, "Montevideo", "Holland America Line"), Retorno.Resultado.ERROR_1, "No existe ese crucero en la ciudad");
        p.ver(s.cancelarReserva(3, "New York", "Holland America Line"), Retorno.Resultado.ERROR_3, "La ciudad no existe");

        System.out.println("------------------INGRESO COMENTARIO------------------");
        p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Muy lindo crucero, personal muy amable", 4), Retorno.Resultado.OK, "Se ingresa comentario a crucero Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Montevideo", "MSC Poesia", "Muy lindo crucero, personal muy amable", 4), Retorno.Resultado.OK, "Se ingresa comentario a crucero MSC Poesia de Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "MSC Poesia", "Mala limpieza", 2), Retorno.Resultado.OK, "Se ingresa comentario a crucero MSC Poesia de Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "MSC Poesia", "Nos gusto mucho el crucero", 3), Retorno.Resultado.OK, "Se ingresa comentario a crucero MSC Poesia de Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "MSC Poesia", "Muy recomendable", 10), Retorno.Resultado.ERROR_1, "Ranking mayor a 5");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Muy lindo crucero, personal muy amable", 4), Retorno.Resultado.ERROR_2, "No existe el crucero en la ciudad");
        p.ver(s.ingresarComentario("New York", "Royal Caribbean Int.", "Muy lindo crucero, personal muy amable", 4), Retorno.Resultado.ERROR_3, "No existe la ciudad");

        System.out.println("------------------LISTO SERVICIOS------------------");
        p.ver(s.listarServicios("Panamá", "Costa Cruise"), Retorno.Resultado.OK, "Se listan servicios de crucero");
        p.ver(s.listarServicios("Montevideo", "MSC Poesia"), Retorno.Resultado.OK, "Se listan servicios de crucero");
        p.ver(s.listarServicios("Montevideo", "Disney Cruise Line"), Retorno.Resultado.ERROR_1, "No existe el crucero en la ciudad");
        p.ver(s.listarServicios("Buenos Aires", "MSC Poesia"), Retorno.Resultado.ERROR_2, "No existe la ciudad");

        System.out.println("------------------LISTO CRUCEROS POR CIUDAD------------------");
        p.ver(s.listarCrucerosCiudad("Montevideo"), Retorno.Resultado.OK, "Lista de cruceros en Montevideo");
        p.ver(s.listarCrucerosCiudad("Lima"), Retorno.Resultado.OK, "Lista de cruceros en Lima");
        p.ver(s.listarCrucerosCiudad("Panamá"), Retorno.Resultado.OK, "Lista de cruceros en Panamá");
        p.ver(s.listarCrucerosCiudad("Buenos Aires"), Retorno.Resultado.ERROR_1, "No existe la ciudad");

        System.out.println("------------------LISTO CRUCEROS POR RANKING ASCENDENTE PARA UNA CIUDAD------------------");
        p.ver(s.listarCrucerosRankingAsc("Montevideo"), Retorno.Resultado.OK, "Lista de cruceros en Montevideo");
        p.ver(s.listarCrucerosRankingAsc("Lima"), Retorno.Resultado.OK, "Lista de cruceros en Lima");
        p.ver(s.listarCrucerosRankingAsc("Panamá"), Retorno.Resultado.OK, "Lista de cruceros en Panamá");
        p.ver(s.listarCrucerosRankingAsc("Buenos Aires"), Retorno.Resultado.ERROR_1, "No existe la ciudad");

        System.out.println("------------------LISTO CRUCEROS POR RANKING DESCENDENTE PARA UNA CIUDAD------------------");
        p.ver(s.listarCrucerosRankingDesc("Montevideo"), Retorno.Resultado.OK, "Lista de cruceros en Montevideo");
        p.ver(s.listarCrucerosRankingDesc("Lima"), Retorno.Resultado.OK, "Lista de cruceros en Lima");
        p.ver(s.listarCrucerosRankingDesc("Panamá"), Retorno.Resultado.OK, "Lista de cruceros en Panamá");
        p.ver(s.listarCrucerosRankingDesc("Buenos Aires"), Retorno.Resultado.ERROR_1, "No existe la ciudad");

        System.out.println("------------------LISTO TODOS LOS CRUCEROS POR RANKING------------------");
        p.ver(s.listarCrucerosRanking(), Retorno.Resultado.OK, "Listado de cruceros por ranking");

        System.out.println("------------------LISTO COMENTARIOS------------------");
        p.ver(s.listarComentarios("Montevideo", "MSC Poesia"), Retorno.Resultado.OK, "Listado de comentarios");
        p.ver(s.listarComentarios("Santiago", "Disney Cruise Line"), Retorno.Resultado.OK, "Listado de comentarios");
        p.ver(s.listarComentarios("Lima", "Disney Cruise Line"), Retorno.Resultado.ERROR_1, "No existe el crucero en la ciudad");
        p.ver(s.listarComentarios("San Francisco", "Disney Cruise Line"), Retorno.Resultado.ERROR_2, "No existe la ciudad");

        System.out.println("------------------CAMINO MAS CORTO------------------");
        int[][] ciudades = {{0, 10, 25, 15, 30, 0}, {10, 0, 20, 0, 0, 0}, {25, 20, 0, 0, 0, 40}, {15, 0, 0, 0, 0, 45}, {30, 0, 0, 0, 0, 25}, {0, 0, 40, 45, 25, 0}};
        p.ver(s.cargarDistancias(ciudades), Retorno.Resultado.ERROR_1, "Se cargan las distancias");
        /* SE MODIFICÓ RETORNO DE CARGAR DISTANCIAS, SE LE ENVÍA UNA MATRIZ CON MAS CIUDADES DE LAS QUE SOPORTA EL SISTEMA */
        p.ver(s.buscarCamino(ciudades, "Montevideo", "Santiago"), Retorno.Resultado.OK, "Buscar camino mas corto");

        System.out.println("------------------SE DESTRUYE EL SISTEMA DE RESERVAS------------------");
        p.ver(s.destruirSistemaReservas(), Retorno.Resultado.OK, "Se elimina el sistema de reservas");

        p.imprimirResultadosPrueba();
    }

    public static void preuba1(Sistema s, Prueba p) {
        s.crearSistemaReservas(0);
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se registra Montevideo");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.ERROR_1, "Se intenta registrar Montevideo nuevamente");
        p.ver(s.registrarCiudad("Tacuarembo"), Retorno.Resultado.OK, "Se registra Tacuarembo");
        p.ver(s.registrarCiudad("Maldonado"), Retorno.Resultado.OK, "Se registra Maldonado");
        p.ver(s.registrarCiudad("Rocha"), Retorno.Resultado.OK, "Se registra Rocha");
        p.ver(s.registrarCiudad("Flores"), Retorno.Resultado.OK, "Se registra Flores");
        p.ver(s.registrarCiudad("Atlantida"), Retorno.Resultado.OK, "Se registra Atlantida");
        /* SE MODIFICÓ RETORNO DE REGISTRAR "ATLANTIDA" NO DEBERÍA DEVOLVER ERROR */
        p.imprimirResultadosPrueba();
    }

    public static void prueba2(Sistema s, Prueba p) {
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se registra Montevideo");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.ERROR_1, "Se intenta registrar Montevideo nuevamente");
        p.ver(s.registrarCiudad("Maldonado"), Retorno.Resultado.OK, "Se registra Maldonado");
        p.ver(s.registrarCiudad("Rocha"), Retorno.Resultado.OK, "Se registra Rocha");
        p.ver(s.registrarCiudad("Flores"), Retorno.Resultado.OK, "Se registra Flores");
        p.ver(s.registrarCiudad("Punta del este"), Retorno.Resultado.OK, "Se registra Punta del Este");
        p.ver(s.registrarCiudad("Atlantida"), Retorno.Resultado.OK, "Se registra Atlantida");
        p.imprimirResultadosPrueba();
    }

    //_crearSistemaReservas
    public static void prueba3(Sistema s, Prueba p) {
        p.ver(s.crearSistemaReservas(4), Retorno.Resultado.OK, "Se crea el sistema de reservas para 4 ciudades");
        p.ver(s.crearSistemaReservas(0), Retorno.Resultado.OK, "Se crea el sistema de reservas sin limite de ciudades");
        p.ver(s.crearSistemaReservas(-1), Retorno.Resultado.ERROR_1, "La cantidad de ciudades no pueden ser menores a 0");
        p.imprimirResultadosPrueba();
    }

    //_destruirSistemaReservas
    public static void prueba4(Sistema s, Prueba p) {
        p.ver(s.crearSistemaReservas(1), Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.destruirSistemaReservas(), Retorno.Resultado.OK, "Se destruye el sistema de reservas");
        p.imprimirResultadosPrueba();
    }

    //_registrarCiudad
    public static void prueba5(Sistema s, Prueba p) {
        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCiudad("Santiago"), Retorno.Resultado.OK, "Se ingresa Santiago");
        p.ver(s.registrarCiudad("Lima"), Retorno.Resultado.OK, "Se ingresa Lima");
        p.ver(s.registrarCiudad("San Pablo"), Retorno.Resultado.OK, "Se ingresa San Pablo");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.ERROR_1, "Montevideo que ya existe");
        p.ver(s.registrarCiudad("New York"), Retorno.Resultado.OK, "Se ingresa New York");
        p.ver(s.registrarCiudad("Buenos Aires"), Retorno.Resultado.ERROR_2, "Se ingresa BsAires pero sobrepasa el limite de ciudades definido");
        p.imprimirResultadosPrueba();
    }

    //_registrarCrucero
    public static void prueba6(Sistema s, Prueba p) {
        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creÃ³ el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
        p.ver(s.registrarCrucero("Santiago", "Carnival Cruise Lines", 6, 2800), Retorno.Resultado.ERROR_1, "Se intenta agregar Carnival Cruise Lines pero La cantidad de estrellas no esta  entre 1 y 5");
        p.ver(s.registrarCrucero("Santiago", "Royal Caribbean Int.", 5, -1), Retorno.Resultado.ERROR_2, "Se intenta agregar Royal Caribbean Int pero La capacidad es menor a 0");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 4, 3100), Retorno.Resultado.ERROR_3, "Se intenta agregar Royal Caribbean Int. pero Ya existe un crucero con ese nombre para Montevideo");
        p.ver(s.registrarCrucero("Lima", "Disney Cruise Line", 5, 2200), Retorno.Resultado.ERROR_4, "Se intenta agregar Disney Cruise Line pero La ciudad no existe");
        p.ver(s.registrarCiudad("Santiago"), Retorno.Resultado.OK, "Se ingresa Santiago");
        p.ver(s.registrarCrucero("Santiago", "Disney Cruise Line", 5, 2200), Retorno.Resultado.OK, "Se registra Disney Cruise Line en Santiago");
        p.ver(s.listarCrucerosCiudad("Montevideo"), Retorno.Resultado.OK, "Listado de Cruceros en Montevideo");
        p.ver(s.listarCrucerosCiudad("Santiago"), Retorno.Resultado.OK, "Listado de Cruceros en Santiago");
        p.imprimirResultadosPrueba();
    }

//_ingresarServicio
    public static void prueba7(Sistema s, Prueba p) {
        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creÃ³ el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresÃ³ Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino"), Retorno.Resultado.OK, "Se ingresa servicio Casino en Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Wifi"), Retorno.Resultado.OK, "Se ingresa servicio Wifi en Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "All Inclusive"), Retorno.Resultado.OK, "Se ingresa servicio All Inclusive en Royal Caribbean Int. en Montevideo");
        p.imprimirResultadosPrueba();
    }

//_borrarServicio
    public static void prueba8(Sistema s, Prueba p) {
        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino"), Retorno.Resultado.OK, "Se ingresa Casino como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.borrarServicio("Montevideo", "Disney Cruise Line", "Casino"), Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.borrarServicio("Montevideo", "Royal Caribbean Int.", "Piscina"), Retorno.Resultado.ERROR_2, "No existe un servicio Piscina en el Royal Caribbean Int.");
        p.ver(s.borrarServicio("Santiago", "Royal Caribbean Int.", "Casino"), Retorno.Resultado.ERROR_3, "No existe la ciudad Santiago");
        p.imprimirResultadosPrueba();
    }

//_realizarRerserva
    public static void prueba9(Sistema s, Prueba p) {
        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3), Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
        p.ver(s.realizarReserva(1, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realiza la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(2, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realiza la reserva del cliente 2 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(3, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realiza la reserva del cliente 3 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(4, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "El cliente 4 queda en lista de espera para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(5, "Montevideo", "Disney Cruise Line"), Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.realizarReserva(6, "San Pablo", "Royal Caribbean Int."), Retorno.Resultado.ERROR_2, "Se intenta agregar crucero a ciuedad que No existe la ciudad San Pablo");
        p.imprimirResultadosPrueba();
    }

//_cancelarRerserva
    public static void prueba10(Sistema s, Prueba p) {
        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creÃ³ el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresÃ³ Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3), Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
        p.ver(s.realizarReserva(1, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realiza la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(2, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realiza la reserva del cliente 2 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(1, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se realiza la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(4, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "El cliente 4 queda en lista de espera para el Royal Caribbean Int. de Montevideo");
        p.ver(s.cancelarReserva(1, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se cancela la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo, pasa el cliente 4 de a lista de espera");
        p.ver(s.cancelarReserva(5, "Montevideo", "Disney Cruise Line"), Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.cancelarReserva(7, "Montevideo", "Royal Caribbean Int."), Retorno.Resultado.ERROR_2, "El cliente 7 no tiene reservas para el Royal Caribbean Int. de Montevideo");
        p.ver(s.cancelarReserva(2, "San Pablo", "Royal Caribbean Int."), Retorno.Resultado.ERROR_3, "No existe la ciudad San Pablo");
        p.imprimirResultadosPrueba();
    }

//_ingresarComentario
    public static void prueba11(Sistema s, Prueba p) {
        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresÃ³ Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "El crucero es excelente", 5), Retorno.Resultado.OK, "Se ingresa un comentario en el Royal Caribbean Int. de Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "No me gusto nada", -1), Retorno.Resultado.ERROR_1, "El ranking del comentario no estÃ¡ entre 0 y 5");
        p.ver(s.ingresarComentario("Montevideo", "Disney Cruise Line", "El crucero esta¡ muy bueno", 4), Retorno.Resultado.ERROR_2, "No se encontra un crucero con ese nombre para Montevideo");
        p.ver(s.ingresarComentario("San Pablo", "Royal Caribbean Int.", "Se pueden mejorar algunas cosas", 3), Retorno.Resultado.ERROR_3, "No se encontra la ciudad San Pablo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Tienen que mejorar la limpieza", 2), Retorno.Resultado.OK, "Se ingresa un comentario en el Royal Caribbean Int. de Montevideo");
        p.imprimirResultadosPrueba();
    }

//_listarServicios
    public static void prueba12(Sistema s, Prueba p) {
        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino"), Retorno.Resultado.OK, "Se ingresa Casino como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Piscina"), Retorno.Resultado.OK, "Se ingresa Piscina como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Masajes"), Retorno.Resultado.OK, "Se ingresa Masajes como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "HabitaciÃ³n King"), Retorno.Resultado.OK, "Se ingresa HabitaciÃ³n King Casino como servicio del Royal Caribbean Int. en Montevideo");
        p.ver(s.listarServicios("Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se listan los serivios del Royal Caribbean Int. en Montevideo");
        p.ver(s.listarServicios("Montevideo", "Disney Cruise Line"), Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.listarServicios("San Pablo", "Royal Caribbean Int."), Retorno.Resultado.ERROR_2, "No existe la ciudad San Pablo");
        p.imprimirResultadosPrueba();
    }

//_listarCrucerosCiudad
    public static void prueba13(Sistema s, Prueba p) {
        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creÃ³ el sistema de reservas");
        p.ver(s.registrarCiudad("San Pablo"), Retorno.Resultado.OK, "Se ingresÃ³ Montevideo");
        p.ver(s.registrarCrucero("San Pablo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en San Pablo");
        p.ver(s.registrarCrucero("San Pablo", "Carnival Cruise Lines", 4, 2800), Retorno.Resultado.OK, "Se ingresa Carnival Cruise Lines en San Pablo");
        p.ver(s.registrarCrucero("San Pablo", "Celebrity Reflection", 3, 1300), Retorno.Resultado.OK, "Se ingresa Celebrity Reflection en San Pablo");
        p.ver(s.registrarCrucero("San Pablo", "Disney Cruise Line", 5, 2200), Retorno.Resultado.OK, "Se ingresa Disney Cruise Line en San Pablo");
        p.ver(s.listarCrucerosCiudad("San Pablo"), Retorno.Resultado.OK, "Se listan los cruceros de San Pablo por nombre");
        p.ver(s.listarCrucerosCiudad("Lima"), Retorno.Resultado.ERROR_1, "No existe la ciudad Lima");
        p.imprimirResultadosPrueba();
    }

//_listarCrucerosRanking
    public static void prueba14(Sistema s, Prueba p) {
        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Lima"), Retorno.Resultado.OK, "Se ingresa Lima");
        p.ver(s.registrarCrucero("Lima", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Lima");
        p.ver(s.registrarCrucero("Lima", "Carnival Cruise Lines", 4, 2800), Retorno.Resultado.OK, "Se ingresa Carnival Cruise Lines en Lima");
        p.ver(s.registrarCrucero("Lima", "Celebrity Reflection", 3, 1300), Retorno.Resultado.OK, "Se ingresa Celebrity Reflection en Lima");
        p.ver(s.registrarCrucero("Lima", "Disney Cruise Line", 5, 2200), Retorno.Resultado.OK, "Se ingresa Disney Cruise Line en Lima");
        p.ver(s.ingresarComentario("Lima", "Royal Caribbean Int.", "Recomendable", 3), Retorno.Resultado.OK, "Se ingresa un comentario en el Royal Caribbean Int. de Lima");
        p.ver(s.ingresarComentario("Lima", "Celebrity Reflection", "El crucero es excelente", 5), Retorno.Resultado.OK, "Se ingresa un comentario en el Celebrity Reflection de Lima");
        p.ver(s.ingresarComentario("Lima", "Disney Cruise Line", "Descuidada la higiene", 2), Retorno.Resultado.OK, "Se ingresa un comentario en el Disney Cruise Line de Lima");
        p.ver(s.listarCrucerosRankingAsc("Lima"), Retorno.Resultado.OK, "Se listan los cruceros de Lima por ranking ascendente");
        p.ver(s.listarCrucerosRankingAsc("New York"), Retorno.Resultado.ERROR_1, "No existe la ciudad New York");
        p.ver(s.listarCrucerosRankingDesc("Lima"), Retorno.Resultado.OK, "Se listan los cruceros de Lima por ranking descendente");
        p.ver(s.listarCrucerosRankingDesc("Buenos Aires"), Retorno.Resultado.ERROR_1, "No existe la ciudad New York");
        p.imprimirResultadosPrueba();
    }

//_listarComentarios
    public static void prueba15(Sistema s, Prueba p) {
        s.destruirSistemaReservas();
        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Excelente", 5), Retorno.Resultado.OK, "Se ingresa un comentario en el Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Me gusta mucho", 4), Retorno.Resultado.OK, "Se ingresa un comentario en el Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Muy recomendable, excelente piscina", 5), Retorno.Resultado.OK, "Se ingresa un comentario en el Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "La comida estaba en mal estado", 2), Retorno.Resultado.OK, "Se ingresa un comentario en el Royal Caribbean Int. en Montevideo");
        p.ver(s.listarComentarios("Montevideo", "Royal Caribbean Int."), Retorno.Resultado.OK, "Se listan los serivios del Royal Caribbean Int. en Montevideo");
        p.ver(s.listarComentarios("Montevideo", "Disney Cruise Line"), Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.listarComentarios("San Pablo", "Royal Caribbean Int."), Retorno.Resultado.ERROR_2, "No existe la ciudad San Pablo");

        //camino mas corto
        int[][] matdistancias = new int[][]{
            {0, 10, 25, 15, 30, 0},
            {10, 0, 20, 0, 0, 0},
            {25, 20, 0, 0, 0, 40},
            {15, 0, 0, 0, 0, 45},
            {30, 0, 0, 0, 0, 25},
            {0, 0, 40, 45, 25, 0}
        };
        p.ver(s.cargarDistancias(matdistancias), Retorno.Resultado.ERROR_1, "Se cargo matriz de distancias");
        /* SE MODIFICÓ RETORNO DE CARGAR DISTANCIAS, SE LE ENVÍA UNA MATRIZ CON MAS CIUDADES DE LAS QUE SOPORTA EL SISTEMA */
        p.imprimirResultadosPrueba();

    }

    public static void caminoCorto(Sistema s, Prueba p) {

        s.crearSistemaReservas(6);
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCiudad("Buenos Aires"), Retorno.Resultado.OK, "Se ingresó Santiago");
        p.ver(s.registrarCiudad("POA"), Retorno.Resultado.OK, "Se ingresó Lima");
        p.ver(s.registrarCiudad("Río de Janeiro"), Retorno.Resultado.OK, "Se ingresó San Pablo");
        p.ver(s.registrarCiudad("Miami"), Retorno.Resultado.OK, "Se ingresó Panamá");
        p.ver(s.registrarCiudad("San Pablo"), Retorno.Resultado.OK, "Se ingresó New York");

        int[][] matrizDistance = {
            {0, 7, 9, 0, 0, 14},
            {7, 0, 10, 15, 4, 0},
            {9, 10, 0, 11, 3, 2},
            {0, 15, 11, 0, 6, 0},
            {0, 14, 3, 6, 0, 9},
            {14, 0, 2, 0, 9, 0}};

        System.out.println(s.buscarCamino(matrizDistance, "Montevideo", "Miami").valorString);
    }

    public static void mayorCantCiudades(Sistema s, Prueba p) {

        s.destruirSistemaReservas();
        s.crearSistemaReservas(6);
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCiudad("Buenos Aires"), Retorno.Resultado.OK, "Se ingresó Santiago");
        p.ver(s.registrarCiudad("San Pablo"), Retorno.Resultado.OK, "Se ingresó New York");

        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3), Retorno.Resultado.OK, "Se ingresó el crucero");
        p.ver(s.registrarCrucero("Buenos Aires", "Carnival Cruise Lines", 4, 2800), Retorno.Resultado.OK, "Se ingresó el crucero");
        p.ver(s.registrarCrucero("Buenos Aires", "Costa Concordia", 4, 2800), Retorno.Resultado.OK, "Se ingresó el crucero");
        p.ver(s.registrarCrucero("Buenos Aires", "Royal Caribbean Int.", 5, 3), Retorno.Resultado.OK, "Se ingresó el crucero");

        System.out.println(s.ciudades.mayorCantidadCruceros());
    }
}
//---------------------------------------------------------
