package Pruebas;

import Sistema.Retorno;
import Sistema.Sistema;
import Sistema.Utilidad;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CruceroTest {

    private Utilidad u;
    private Sistema s;

    @Before
    public void setUp() throws Exception {
        s = new Sistema();
        u = new Utilidad();
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Santiago");
    }

    @Test
    public void registrarCrucero() {
        assertEquals(Retorno.Resultado.OK, s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3).resultado);
    }

    @Test
    public void registrarCruceroErrorEstrellas() {
        assertEquals(Retorno.Resultado.ERROR_1, s.registrarCrucero("Santiago", "Carnival Cruise Lines", 6, 2800).resultado);
    }

    @Test
    public void registrarCruceroErrorCapacidad() {
        assertEquals(Retorno.Resultado.ERROR_2, s.registrarCrucero("Santiago", "Royal Caribbean Int.", 5, -1).resultado);
    }

    @Test
    public void registrarCruceroRepetido() {
        s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3);
        assertEquals(Retorno.Resultado.ERROR_3, s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 4, 3100).resultado);
    }

    @Test
    public void registrarCruceroCiudadNoExiste() {
        assertEquals(Retorno.Resultado.ERROR_4, s.registrarCrucero("Asuncion", "Disney Cruise Line", 5, 2200).resultado);
    }

    @Test
    public void listarCruceros() {
        s.registrarCrucero("Santiago", "Royal Caribbean Int.", 4, 2000);
        s.registrarCrucero("Santiago", "Disney Cruise Line", 5, 2200);
        s.registrarCrucero("Santiago", "Carnival Cruise Lines", 3, 1800);
        assertEquals(Retorno.Resultado.OK, s.listarCrucerosCiudad("Santiago").resultado);
        System.out.println();
    }

    @Test
    public void listarCrucerosCiudadRankingAscDesc() {
        s.registrarCrucero("Santiago", "Royal Caribbean Int.", 4, 2000);
        s.ingresarComentario("Santiago", "Royal Caribbean Int.", "Me gusto", 4);
        s.registrarCrucero("Santiago", "Disney Cruise Line", 5, 2200);
        s.ingresarComentario("Santiago", "Disney Cruise Line", "Muy mala limpieza", 1);
        s.registrarCrucero("Santiago", "Costa Concordia", 3, 1100);
        s.ingresarComentario("Santiago", "Costa Concordia", "Excelente", 5);
        s.registrarCrucero("Santiago", "Carnival Cruise Lines", 3, 1800);
        s.ingresarComentario("Santiago", "Carnival Cruise Lines", "Aceptable", 3);
        assertEquals(Retorno.Resultado.OK, s.listarCrucerosRankingAsc("Santiago").resultado);
        System.out.println();
        assertEquals(Retorno.Resultado.OK, s.listarCrucerosRankingDesc("Santiago").resultado);
        System.out.println();
    }
}
