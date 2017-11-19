package Pruebas;

import Sistema.ISistema;
import Sistema.Retorno;
import Sistema.Sistema;
import org.junit.Test;
import static org.junit.Assert.*;

public class CruceroTest {

    @Test
    public void testDestruirSistemaReservas() {
        ISistema s = new Sistema();
        s.crearSistemaReservas(10);
        assertEquals(Retorno.Resultado.OK, s.destruirSistemaReservas());
    }
}
