package Pruebas;

import Sistema.Retorno;
import Sistema.Sistema;
import Sistema.Utilidad;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CiudadTest {

    private Utilidad u;
    private Sistema s;

    @Before
    public void setUp() throws Exception {
        s = new Sistema();
        u = new Utilidad();
        s.crearSistemaReservas(6);
    }

    @Test
    public void registrarCiudad() {
        assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Montevideo").resultado);
        System.out.println(s.ciudades.toString());
    }

    @Test
    public void registrarCiudadRepetida() {
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, s.registrarCiudad("Montevideo").resultado);
    }

    @Test
    public void registrarCiudadSobrepasaLimite() {
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Santiago");
        s.registrarCiudad("Lima");
        s.registrarCiudad("San Pablo");
        s.registrarCiudad("Panamá");
        s.registrarCiudad("New York");
        assertEquals(Retorno.Resultado.ERROR_2, s.registrarCiudad("Buenos Aires").resultado);
        System.out.println();
        System.out.println(s.ciudades.toString());
    }
}
