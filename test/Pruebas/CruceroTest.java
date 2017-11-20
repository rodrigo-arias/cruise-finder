package Pruebas;

import Sistema.Retorno;
import Sistema.Sistema;
import Sistema.Utilidad;
import org.junit.Test;
import static org.junit.Assert.*;

public class CruceroTest {

    Utilidad u = new Utilidad();
    Sistema s = new Sistema();

    @Test
    public void registrarCrucero() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Santiago");
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3)));
    }

    @Test
    public void registrarCruceroErrorEstrellas() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Santiago");
        assertEquals(Retorno.Resultado.ERROR_1, u.retornarResultado(s.registrarCrucero("Santiago", "Carnival Cruise Lines", 6, 2800)));
    }
}
