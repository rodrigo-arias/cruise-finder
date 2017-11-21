package Pruebas;

import Dominio.Ciudad;
import Dominio.Crucero;
import Sistema.Retorno;
import Sistema.Sistema;
import Sistema.Utilidad;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ReservaTest {

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
    public void realizarReserva() {
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        assertEquals(Retorno.Resultado.OK, s.realizarReserva(1, "Montevideo", "Royal Caribbean Int.").resultado);
    }

    @Test
    public void realizarReservaErrorCrucero() {
        assertEquals(Retorno.Resultado.ERROR_1, s.realizarReserva(1, "Montevideo", "Disney Cruise Line").resultado);
    }

    @Test
    public void realizarReservaErrorCiudad() {
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        assertEquals(Retorno.Resultado.ERROR_2, s.realizarReserva(1, "Bogotá", "Royal Caribbean Int.").resultado);
    }

    @Test
    public void realizarReservaClienteToColaEspera() {
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        s.realizarReserva(1, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(2, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(3, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(4, "Montevideo", "Royal Caribbean Int.");

        assertEquals(Retorno.Resultado.OK, s.realizarReserva(5, "Montevideo", "Royal Caribbean Int.").resultado);

        Ciudad citytemp = new Ciudad("Montevideo");
        Ciudad cityfound = s.ciudades.find(citytemp);
        Crucero cruisetemp = new Crucero("Royal Caribbean Int.", "Montevideo");
        Crucero cruisefound = cityfound.getCruceros().find(cruisetemp);
        System.out.println("Se agregan tres reservas y dos colas de espera");
        cruisefound.getReservas().show();
        cruisefound.getEsperas().show();
        System.out.println();
    }

    @Test
    public void cancelarReserva() {
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        s.realizarReserva(1, "Montevideo", "Royal Caribbean Int.");
        assertEquals(Retorno.Resultado.OK, s.cancelarReserva(1, "Montevideo", "Royal Caribbean Int.").resultado);
    }

    @Test
    public void cancelarReservaErrorCrucero() {
        assertEquals(Retorno.Resultado.ERROR_1, s.cancelarReserva(1, "Montevideo", "Royal Caribbean Int.").resultado);
    }

    @Test
    public void cancelarReservaErrorCliente() {
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        assertEquals(Retorno.Resultado.ERROR_2, s.cancelarReserva(1, "Montevideo", "Royal Caribbean Int.").resultado);
    }

    @Test
    public void cancelarReservaErrorCiudad() {
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        assertEquals(Retorno.Resultado.ERROR_3, s.cancelarReserva(1, "Asunción", "Royal Caribbean Int.").resultado);
    }

    @Test
    public void cancelarReservaClienteColaEsperaToReserva() {
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        s.realizarReserva(1, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(2, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(3, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(4, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(5, "Montevideo", "Royal Caribbean Int.");

        assertEquals(Retorno.Resultado.OK, s.cancelarReserva(2, "Montevideo", "Royal Caribbean Int.").resultado);

        Ciudad citytemp = new Ciudad("Montevideo");
        Ciudad cityfound = s.ciudades.find(citytemp);
        Crucero cruisetemp = new Crucero("Royal Caribbean Int.", "Montevideo");
        Crucero cruisefound = cityfound.getCruceros().find(cruisetemp);
        System.out.println("Se borra reserva y se agrega al primero de cola de espera");
        cruisefound.getReservas().show();
        cruisefound.getEsperas().show();
        System.out.println();
    }

    @Test
    public void cancelarReservaClienteColaEspera() {
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        s.realizarReserva(1, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(2, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(3, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(4, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(5, "Montevideo", "Royal Caribbean Int.");

        assertEquals(Retorno.Resultado.OK, s.cancelarReserva(4, "Montevideo", "Royal Caribbean Int.").resultado);

        Ciudad citytemp = new Ciudad("Montevideo");
        Ciudad cityfound = s.ciudades.find(citytemp);
        Crucero cruisetemp = new Crucero("Royal Caribbean Int.", "Montevideo");
        Crucero cruisefound = cityfound.getCruceros().find(cruisetemp);
        System.out.println("Se borra de cola de espera");
        cruisefound.getReservas().show();
        cruisefound.getEsperas().show();
        System.out.println();
    }
}
