package Pruebas;

import Dominio.Ciudad;
import Dominio.Crucero;
import Sistema.Retorno;
import Sistema.Sistema;
import Sistema.Utilidad;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReservaTest {

    Utilidad u = new Utilidad();
    Sistema s = new Sistema();

    @Test
    public void realizarReserva() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.realizarReserva(1, "Montevideo", "Royal Caribbean Int.")));
    }

    @Test
    public void realizarReservaErrorCrucero() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, u.retornarResultado(s.realizarReserva(1, "Montevideo", "Disney Cruise Line")));
    }

    @Test
    public void realizarReservaErrorCiudad() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        assertEquals(Retorno.Resultado.ERROR_2, u.retornarResultado(s.realizarReserva(1, "Bogotá", "Royal Caribbean Int.")));
    }

    @Test
    public void realizarReservaClienteToColaEspera() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        s.realizarReserva(1, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(2, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(3, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(4, "Montevideo", "Royal Caribbean Int.");

        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.realizarReserva(5, "Montevideo", "Royal Caribbean Int.")));

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
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        s.realizarReserva(1, "Montevideo", "Royal Caribbean Int.");
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.cancelarReserva(1, "Montevideo", "Royal Caribbean Int.")));
    }

    @Test
    public void cancelarReservaErrorCrucero() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, u.retornarResultado(s.cancelarReserva(1, "Montevideo", "Royal Caribbean Int.")));
    }

    @Test
    public void cancelarReservaErrorCliente() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        assertEquals(Retorno.Resultado.ERROR_2, u.retornarResultado(s.cancelarReserva(1, "Montevideo", "Royal Caribbean Int.")));
    }

    @Test
    public void cancelarReservaErrorCiudad() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        assertEquals(Retorno.Resultado.ERROR_3, u.retornarResultado(s.cancelarReserva(1, "Asunción", "Royal Caribbean Int.")));
    }

    @Test
    public void cancelarReservaClienteColaEsperaToReserva() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        s.realizarReserva(1, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(2, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(3, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(4, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(5, "Montevideo", "Royal Caribbean Int.");

        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.cancelarReserva(2, "Montevideo", "Royal Caribbean Int.")));

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
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        s.realizarReserva(1, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(2, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(3, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(4, "Montevideo", "Royal Caribbean Int.");
        s.realizarReserva(5, "Montevideo", "Royal Caribbean Int.");

        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.cancelarReserva(4, "Montevideo", "Royal Caribbean Int.")));

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
