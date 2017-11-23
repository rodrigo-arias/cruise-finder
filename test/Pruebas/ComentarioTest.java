package Pruebas;

import Sistema.Retorno;
import Sistema.Sistema;
import Sistema.Utilidad;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ComentarioTest {

    private Utilidad u;
    private Sistema s;

    @Before
    public void setUp() throws Exception {
        s = new Sistema();
        u = new Utilidad();
        s.crearSistemaReservas(6);
        s.registrarCiudad("Santiago");
        s.registrarCrucero("Santiago", "Royal Caribbean Int.", 4, 2000);
        s.registrarCrucero("Santiago", "Disney Cruise Line", 5, 2200);
        s.registrarCrucero("Santiago", "Carnival Cruise Lines", 3, 1800);
    }

    @Test
    public void registrarComentario() {
        assertEquals(Retorno.Resultado.OK, s.ingresarComentario("Santiago", "Royal Caribbean Int.", "Me gusto", 4).resultado);
    }

    @Test
    public void registrarComentarioErrorRanking() {
        assertEquals(Retorno.Resultado.ERROR_1, s.ingresarComentario("Santiago", "Royal Caribbean Int.", "No me gusto nada", -1).resultado);
    }

    @Test
    public void registrarComentarioErrorCrucero() {
        assertEquals(Retorno.Resultado.ERROR_2, s.ingresarComentario("Santiago", "Costa Concordia", "El crucero está muy bueno", 4).resultado);
    }

    @Test
    public void registrarComentarioErrorCiudad() {
        assertEquals(Retorno.Resultado.ERROR_3, s.ingresarComentario("Asunción", "Royal Caribbean Int.", "Se pueden mejorar algunas cosas", 3).resultado);
    }

    @Test
    public void listarComentarios() {
        s.ingresarComentario("Santiago", "Royal Caribbean Int.", "Me gusto", 4);
        s.ingresarComentario("Santiago", "Royal Caribbean Int.", "Tienen que mejorar la limpieza", 2);
        s.ingresarComentario("Santiago", "Royal Caribbean Int.", "Excelente", 5);
        assertEquals(Retorno.Resultado.OK, s.listarComentarios("Santiago", "Royal Caribbean Int.").resultado);

    }
}
