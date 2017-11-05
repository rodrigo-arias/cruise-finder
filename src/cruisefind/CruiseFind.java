package cruisefind;

public class CruiseFind {

    public static void main(String[] args) {

        //declaración global
        Sistema s = new Sistema();
        Prueba p = new Prueba();

        //llamada a pruebas
        Prueba11_crearSistemaReservas(s, p);

        //Prueba13_registrarCiudad(s, p);
    }

    //declaración de pruebas
    public static void Prueba11_crearSistemaReservas(Sistema s, Prueba p) {

        p.ver(s.crearSistemaReservas(5), Retorno.Resultado.OK, "Se creó el sistema de reservas.");
        p.imprimirResultadosPrueba();

    }

    public static void Prueba13_registrarCiudad(Sistema s, Prueba p) {

        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCiudad("Rocha"), Retorno.Resultado.OK, "Se ingresó Rocha");
        p.ver(s.registrarCiudad("Punta del Este"), Retorno.Resultado.ERROR_2, "Se sobrepasa el límite de ciudades");
        p.ver(s.registrarCiudad("Montevideo"), Retorno.Resultado.ERROR_1, "Montevideo ya existe");
        p.imprimirResultadosPrueba();

    }
}
