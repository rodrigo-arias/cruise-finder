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

    @Test
    public void registrarCruceroErrorCapacidad() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Santiago");
        assertEquals(Retorno.Resultado.ERROR_2, u.retornarResultado(s.registrarCrucero("Santiago", "Royal Caribbean Int.", 5, -1)));
    }

    @Test
    public void registrarCruceroRepetido() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        assertEquals(Retorno.Resultado.ERROR_3, u.retornarResultado(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 4, 3100)));
    }

    @Test
    public void registrarCruceroCiudadNoExiste() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Santiago");
        assertEquals(Retorno.Resultado.ERROR_4, u.retornarResultado(s.registrarCrucero("Asuncion", "Disney Cruise Line", 5, 2200)));
    }

    @Test
    public void listarCruceros() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Santiago");
        s.registrarCrucero("Santiago", "Royal Caribbean Int.", 4, 2000);
        s.registrarCrucero("Santiago", "Disney Cruise Line", 5, 2200);
        s.registrarCrucero("Santiago", "Carnival Cruise Lines", 3, 1800);
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.listarCrucerosCiudad("Santiago")));
    }
}
