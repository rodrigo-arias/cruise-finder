package Pruebas;

import Sistema.Retorno;
import Sistema.Sistema;
import Sistema.Utilidad;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServicioTest {

    Utilidad u = new Utilidad();
    Sistema s = new Sistema();

    @Test
    public void ingresarServicio() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino")));
    }

    @Test
    public void ingresarServicioErrorCrucero() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, u.retornarResultado(s.ingresarServicio("Montevideo", "Carnival Cruise Lines", "Masajes")));
    }

    @Test
    public void ingresarServicioErrorCiudad() {
        s.crearSistemaReservas(6);
        assertEquals(Retorno.Resultado.ERROR_2, u.retornarResultado(s.ingresarServicio("Montevideo", "Carnival Cruise Lines", "Masajes")));
    }

    @Test
    public void listarServicios() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino");
        s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Piscina");
        s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Masajes");
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.listarServicios("Montevideo", "Royal Caribbean Int.")));
    }

    @Test
    public void borrarServicio() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Piscina");
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.borrarServicio("Montevideo", "Royal Caribbean Int.", "Piscina")));
    }

    @Test
    public void borrarServicioErrorCrucero() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, u.retornarResultado(s.borrarServicio("Montevideo", "Carnival Cruise Lines", "Masajes")));
    }

    @Test
    public void borrarServicioErrorServicio() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Carnival Cruise Lines", 5, 3);
        assertEquals(Retorno.Resultado.ERROR_2, u.retornarResultado(s.borrarServicio("Montevideo", "Carnival Cruise Lines", "Pensión completa")));
    }

    @Test
    public void borrarServicioErrorCiudad() {
        s.crearSistemaReservas(6);
        assertEquals(Retorno.Resultado.ERROR_3, u.retornarResultado(s.borrarServicio("Montevideo", "Carnival Cruise Lines", "Masajes")));
    }

    @Test
    public void listarServiciosConBorrado() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Casino");
        s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Piscina");
        s.ingresarServicio("Montevideo", "Royal Caribbean Int.", "Masajes");
        s.borrarServicio("Montevideo", "Royal Caribbean Int.", "Piscina");
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.listarServicios("Montevideo", "Royal Caribbean Int.")));
    }

}
