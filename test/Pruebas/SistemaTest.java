package Pruebas;

import Sistema.Retorno;
import Sistema.Sistema;
import Sistema.Utilidad;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class SistemaTest {

    private Utilidad u;
    private Sistema s;

    @Before
    public void setUp() throws Exception {
        s = new Sistema();
        u = new Utilidad();
    }

    @Test
    public void crearSistemaReservasConLimiteCiudades() {
        assertEquals(Retorno.Resultado.OK, s.crearSistemaReservas(6).resultado);
    }

    @Test
    public void crearSistemaReservasSinLimiteCiudades() {
        assertEquals(Retorno.Resultado.OK, s.crearSistemaReservas(0).resultado);
    }

    @Test
    public void crearSistemaReservasConLimiteNegativoCiudades() {
        assertEquals(Retorno.Resultado.ERROR_1, s.crearSistemaReservas(-1).resultado);
    }

    @Test
    public void destruirSistemaReservas() {
        assertEquals(Retorno.Resultado.OK, s.destruirSistemaReservas().resultado);
    }
}
