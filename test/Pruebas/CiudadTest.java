package Pruebas;

import Sistema.ISistema;
import Sistema.Retorno;
import Sistema.Sistema;
import org.junit.Test;
import static org.junit.Assert.*;

public class CiudadTest {

    @Test
    public void testCrearSistema() {
        ISistema s = new Sistema();
        s.crearSistemaReservas(5);
        assertEquals(Retorno.Resultado.OK, s.crearSistemaReservas(5));
    }

    @Test
    public void testRegistrarMontevideo() {
        ISistema s = new Sistema();
        s.crearSistemaReservas(5);
        assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Montevideo"));
    }
}
