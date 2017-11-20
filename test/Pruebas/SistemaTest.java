package Pruebas;

import Sistema.Retorno;
import Sistema.Sistema;
import Sistema.Utilidad;
import org.junit.Test;
import static org.junit.Assert.*;

public class SistemaTest {

    Utilidad u = new Utilidad();
    Sistema s = new Sistema();

    @Test
    public void crearSistemaReservasConLimiteCiudades() {
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.crearSistemaReservas(6)));
    }

    @Test
    public void crearSistemaReservasSinLimiteCiudades() {
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.crearSistemaReservas(0)));
    }

    @Test
    public void crearSistemaReservasConLimiteNegativoCiudades() {
        assertEquals(Retorno.Resultado.ERROR_1, u.retornarResultado(s.crearSistemaReservas(-1)));
    }

    @Test
    public void destruirSistemaReservas() {
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.destruirSistemaReservas()));
    }
}
