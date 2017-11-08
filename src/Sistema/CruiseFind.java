package Sistema;

public class CruiseFind {

    public static void main(String[] args) {

        //declaración global
        Sistema s = new Sistema();
        Prueba p = new Prueba();

        //llamada a pruebas
        //Prueba11_crearSistemaReservas(s, p);
        //Prueba12_destruirSistemaReservas(s, p);
        //Prueba13_registrarCiudad(s, p);
        //Prueba14_registrarCrucero(s, p);
        Prueba15_ingresarServicio(s, p);
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

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCiudad("Rocha"), Retorno.Resultado.OK, "Se ingresó Rocha");
        p.ver(s.registrarCiudad("Atlantida"), Retorno.Resultado.OK, "Se ingresó Atlantida");
        p.ver(s.registrarCiudad("Colonia"), Retorno.Resultado.OK, "Se ingresó Colonia");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.ERROR_1, "Montevideo ya existe");
        p.ver(s.registrarCiudad("Punta del Este"), Retorno.Resultado.OK, "Se ingresó Punta del Este");
        p.ver(s.registrarCiudad("Maldonado"), Retorno.Resultado.ERROR_2, "Se sobrepasa el límite de ciudades gestionados por el sistema");
        p.imprimirResultadosPrueba();

    }

    public static void Prueba14_registrarCrucero(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresó Royal Caribbean Int. en Montevideo");
        p.ver(s.registrarCrucero("Rocha", "Carnival Cruise Lines", 6, 2800), Retorno.Resultado.ERROR_1, "La cantidad de estrellas no está entre 1 y 5");
        p.ver(s.registrarCrucero("Rocha", "Royal Caribbean Int.", 5, -1), Retorno.Resultado.ERROR_2, "La capacidad es menor a 0");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 4, 3100), Retorno.Resultado.ERROR_3, "Ya existe un crucero con ese nombre para Montevideo");
        p.ver(s.registrarCrucero("Piriapolis", "Disney Cruise Line", 5, 2200), Retorno.Resultado.ERROR_4, "La ciudad no existe");
        p.imprimirResultadosPrueba();
    }

    public static void Prueba15_ingresarServicio(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3100), Retorno.Resultado.OK, "Se ingresó Royal Caribbean Int. en Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino"), Retorno.Resultado.OK, "Se ingresó Casino como servicio del Royal Caribbean Int. en Montevideo");
        p.imprimirResultadosPrueba();
    }
}
