package Pruebas;

import Sistema.ISistema;
import Sistema.Retorno;
import Sistema.Sistema;
import Sistema.Utilidad;
import org.junit.Test;
import static org.junit.Assert.*;

public class SistemaTest {

    Utilidad u = new Utilidad();

    @Test
    public void crearSistemaReservasConLimiteCiudades() {
        ISistema s = new Sistema();
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.crearSistemaReservas(5)));
    }

    @Test
    public void crearSistemaReservasSinLimiteCiudades() {
        ISistema s = new Sistema();
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.crearSistemaReservas(0)));
    }

    @Test
    public void crearSistemaReservasConLimiteNegativoCiudades() {
        ISistema s = new Sistema();
        assertEquals(Retorno.Resultado.ERROR_1, u.retornarResultado(s.crearSistemaReservas(-1)));
    }
}
