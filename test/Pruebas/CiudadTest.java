package Pruebas;

import Sistema.Retorno;
import Sistema.Sistema;
import Sistema.Utilidad;
import org.junit.Test;
import static org.junit.Assert.*;

public class CiudadTest {

    Utilidad u = new Utilidad();
    Sistema s = new Sistema();

    @Test
    public void registrarCiudad() {
        s.crearSistemaReservas(6);
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.registrarCiudad("Montevideo")));
    }

    @Test
    public void registrarCiudadRepetida() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, u.retornarResultado(s.registrarCiudad("Montevideo")));
    }

    @Test
    public void registrarCiudadSobrepasaLimite() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Santiago");
        s.registrarCiudad("Lima");
        s.registrarCiudad("San Pablo");
        s.registrarCiudad("Panamá");
        s.registrarCiudad("New York");
        assertEquals(Retorno.Resultado.ERROR_2, u.retornarResultado(s.registrarCiudad("Buenos Aires")));
    }
}
