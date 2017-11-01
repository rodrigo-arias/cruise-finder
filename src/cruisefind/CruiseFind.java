package cruisefind;

public class CruiseFind {

    public static void main(String[] args) {

        //debe recibir la cantidad de ciudades según la letra / Sistema s = new Sistema(7);
        Sistema s = new Sistema();
        Prueba p = new Prueba();

        s.crearSistemaReservas(5);

        Prueba1(s, p);
        //Prueba2(s, p);

    }

    public static void Prueba1(Sistema s, Prueba p) {

        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresó Montevideo");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Montevideo ya existe");
        p.imprimirResultadosPrueba();

    }

    public static void Prueba2(Sistema s, Prueba p) {

        p.ver(s.registrarCiudad("Maldonado").resultado, Retorno.Resultado.OK, "Se ingresó Maldonado");
        p.ver(s.registrarCiudad("Rocha").resultado, Retorno.Resultado.OK, "Se ingresó Rocha");
        p.ver(s.registrarCiudad("Punta del Este").resultado, Retorno.Resultado.ERROR_2, "Se sobrepasa el límite de ciudades");
        p.imprimirResultadosPrueba();

    }
}
