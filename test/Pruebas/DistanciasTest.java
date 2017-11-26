package Pruebas;

import Sistema.Retorno;
import Sistema.Sistema;
import Sistema.Utilidad;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DistanciasTest {

    private Utilidad u;
    private Sistema s;

    @Before
    public void setUp() throws Exception {
        s = new Sistema();
        u = new Utilidad();
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Santiago");
        s.registrarCiudad("Lima");
        s.registrarCiudad("San Pablo");
        s.registrarCiudad("Panamá");
        s.registrarCiudad("New York");
    }

    @Test
    public void registrarCargarMatriz() {

        int[][] matrizDistance = {
            {0, 10, 25, 15, 30, 0},
            {10, 0, 20, 0, 0, 0},
            {25, 20, 0, 0, 0, 40},
            {15, 0, 0, 0, 0, 45},
            {30, 0, 0, 0, 0, 25},
            {0, 0, 40, 45, 25, 0}};

        assertEquals(Retorno.Resultado.OK, s.cargarDistancias(matrizDistance).resultado);
    }

    @Test
    public void registrarCargarMatrizSobrepasaLimite() {

        int[][] matrizError = {
            {0, 10, 25, 15, 30, 0},
            {10, 0, 20, 0, 0, 0},
            {25, 20, 0, 0, 0, 40},
            {15, 0, 0, 0, 0, 45},
            {30, 0, 0, 0, 0, 25},
            {0, 0, 40, 45, 25, 0},
            {0, 0, 0, 0, 0, 0}};

        assertEquals(Retorno.Resultado.ERROR_1, s.cargarDistancias(matrizError).resultado);
    }

    @Test
    public void registrarCaminoMasCorto() {

        int[][] matrizDistance = {
            {0, 10, 25, 15, 30, 0},
            {10, 0, 20, 0, 0, 0},
            {25, 20, 0, 0, 0, 40},
            {15, 0, 0, 0, 0, 45},
            {30, 0, 0, 0, 0, 25},
            {0, 0, 40, 45, 25, 0}};

        assertEquals(Retorno.Resultado.OK, s.buscarCamino(matrizDistance, "Montevideo", "New York").resultado);
        System.out.println(s.buscarCamino(matrizDistance, "Montevideo", "New York").valorString);
    }

}
