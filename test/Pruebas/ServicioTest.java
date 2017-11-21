package Pruebas;

import Sistema.Retorno;
import Sistema.Sistema;
import Sistema.Utilidad;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ServicioTest {

    private Utilidad u;
    private Sistema s;

    @Before
    public void setUp() throws Exception {
        s = new Sistema();
        u = new Utilidad();
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
    }

    @Test
    public void ingresarServicio() {
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        assertEquals(Retorno.Resultado.OK, s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino").resultado);
    }

    @Test
    public void ingresarServicioErrorCrucero() {
        assertEquals(Retorno.Resultado.ERROR_1, s.ingresarServicio("Montevideo", "Carnival Cruise Lines", "Masajes").resultado);
    }

    @Test
    public void ingresarServicioErrorCiudad() {
        assertEquals(Retorno.Resultado.ERROR_2, s.ingresarServicio("Asunción", "Carnival Cruise Lines", "Masajes").resultado);
    }

    @Test
    public void listarServicios() {
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino");
        s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Piscina");
        s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Masajes");
        assertEquals(Retorno.Resultado.OK, s.listarServicios("Montevideo", "Royal Caribbean Int.").resultado);
    }

    @Test
    public void borrarServicio() {
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Piscina");
        assertEquals(Retorno.Resultado.OK, s.borrarServicio("Montevideo", "Royal Caribbean Int.", "Piscina").resultado);
    }

    @Test
    public void borrarServicioErrorCrucero() {
        assertEquals(Retorno.Resultado.ERROR_1, s.borrarServicio("Montevideo", "Carnival Cruise Lines", "Masajes").resultado);
    }

    @Test
    public void borrarServicioErrorServicio() {
        s.registrarCrucero("Montevideo", "Carnival Cruise Lines", 5, 3);
        assertEquals(Retorno.Resultado.ERROR_2, s.borrarServicio("Montevideo", "Carnival Cruise Lines", "Pensión completa").resultado);
    }

    @Test
    public void borrarServicioErrorCiudad() {
        assertEquals(Retorno.Resultado.ERROR_3, s.borrarServicio("Asunción", "Carnival Cruise Lines", "Masajes").resultado);
    }

    @Test
    public void listarServiciosConBorrado() {
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino");
        s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Piscina");
        s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Masajes");
        s.borrarServicio("Montevideo", "Royal Caribbean Int.", "Piscina");
        assertEquals(Retorno.Resultado.OK, s.listarServicios("Montevideo", "Royal Caribbean Int.").resultado);
    }
}
