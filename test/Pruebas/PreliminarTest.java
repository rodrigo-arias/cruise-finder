package Pruebas;

import Sistema.ISistema;
import Sistema.Retorno;
import Sistema.Sistema;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/* SOBRE ESTE JUEGO DE PRUEBAS
Se presenta un juego de pruebas preliminar NO EXHAUSTIVO que detalla alguna de las pruebas básicas de cada funcionalidad.
El hecho de que el obligatorío testeado pase el 100 % de estas pruebas no implica obtener todos los puntos de las funcionalidades testeadas.
 */
public class PreliminarTest {

    private ISistema sis;
    private Retorno r;

    @Before
    public void setUp() throws Exception {
        sis = new Sistema();
    }

    @Test
    public void testCrearSistemaReservas() {
        assertEquals(Retorno.Resultado.ERROR_1, sis.crearSistemaReservas(-5).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.crearSistemaReservas(-1).resultado);
        assertEquals(Retorno.Resultado.OK, sis.crearSistemaReservas(0).resultado);
        sis = new Sistema();
        assertEquals(Retorno.Resultado.OK, sis.crearSistemaReservas(5).resultado);
    }

    @Test
    public void testDestruirSistemaReservas() {
        sis.crearSistemaReservas(5);
        assertEquals(Retorno.Resultado.OK, sis.destruirSistemaReservas().resultado);
    }

    @Test
    public void testRegistrarCiudad() {
        sis.crearSistemaReservas(4);

        assertEquals(Retorno.Resultado.OK, sis.registrarCiudad("Montevideo").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.registrarCiudad("Montevideo").resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarCiudad("Tarariras").resultado);
    }

    @Test
    public void testRegistrarCrucero() {
        sis.crearSistemaReservas(4);

        sis.registrarCiudad("Montevideo");

        assertEquals(Retorno.Resultado.ERROR_1, sis.registrarCrucero("Montevideo", "Cru1", 0, 100).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.registrarCrucero("Montevideo", "Cru1", 6, 100).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.registrarCrucero("Montevideo", "Cru1", 5, -1).resultado);
        assertEquals(Retorno.Resultado.ERROR_4, sis.registrarCrucero("Melo", "Cru1", 5, 100).resultado);
        assertEquals(Retorno.Resultado.OK, sis.registrarCrucero("Montevideo", "Cru1", 5, 100).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, sis.registrarCrucero("Montevideo", "Cru1", 5, 100).resultado);
    }

    @Test
    public void testIngresarServicio() {
        sis.crearSistemaReservas(4);

        assertEquals(Retorno.Resultado.ERROR_2, sis.ingresarServicio("Tarariras", "Cru1", "Malabares").resultado);
        sis.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, sis.ingresarServicio("Montevideo", "Cru1", "Malabares").resultado);
        sis.registrarCrucero("Montevideo", "Cru1", 5, 100);
        assertEquals(Retorno.Resultado.OK, sis.ingresarServicio("Montevideo", "Cru1", "Malabares").resultado);
    }

    @Test
    public void testBorrarServicio() {
        sis.crearSistemaReservas(4);

        assertEquals(Retorno.Resultado.ERROR_3, sis.borrarServicio("Tarariras", "Cru1", "Malabares").resultado);
        sis.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, sis.borrarServicio("Montevideo", "Cru1", "Malabares").resultado);
        sis.registrarCrucero("Montevideo", "Cru1", 5, 100);
        assertEquals(Retorno.Resultado.ERROR_2, sis.borrarServicio("Montevideo", "Cru1", "Malabares").resultado);
        sis.ingresarServicio("Montevideo", "Cru1", "Malabares");
        assertEquals(Retorno.Resultado.OK, sis.borrarServicio("Montevideo", "Cru1", "Malabares").resultado);

    }

    @Test
    public void testRealizarReserva() {
        sis.crearSistemaReservas(4);
        assertEquals(Retorno.Resultado.ERROR_2, sis.realizarReserva(1, "Tarariras", "Cru1").resultado);
        sis.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, sis.realizarReserva(1, "Montevideo", "Cru1").resultado);
        sis.registrarCrucero("Montevideo", "Cru1", 5, 2);
        assertEquals(Retorno.Resultado.OK, sis.realizarReserva(1, "Montevideo", "Cru1").resultado);
        assertEquals(Retorno.Resultado.OK, sis.realizarReserva(2, "Montevideo", "Cru1").resultado);
        //A lista de espera
        assertEquals(Retorno.Resultado.OK, sis.realizarReserva(3, "Montevideo", "Cru1").resultado);
    }

    @Test
    public void testCancelarReserva() {
        sis.crearSistemaReservas(4);

        assertEquals(Retorno.Resultado.ERROR_3, sis.cancelarReserva(1, "Tarariras", "Cru1").resultado);
        sis.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, sis.cancelarReserva(1, "Montevideo", "Cru1").resultado);
        sis.registrarCrucero("Montevideo", "Cru1", 5, 2);
        assertEquals(Retorno.Resultado.ERROR_2, sis.cancelarReserva(1, "Montevideo", "Cru1").resultado);
        sis.realizarReserva(1, "Montevideo", "Cru1");
        assertEquals(Retorno.Resultado.OK, sis.cancelarReserva(1, "Montevideo", "Cru1").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, sis.cancelarReserva(1, "Montevideo", "Cru1").resultado);
    }

    @Test
    public void testIngresarComentario() {
        sis.crearSistemaReservas(4);

        assertEquals(Retorno.Resultado.ERROR_1, sis.ingresarComentario("Tarariras", "Cru1", "Espantoso!", -1).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, sis.ingresarComentario("Tarariras", "Cru1", "Espantoso!", 6).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, sis.ingresarComentario("Montevideo", "Cru1", "Espantoso!", 1).resultado);
        sis.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_2, sis.ingresarComentario("Montevideo", "Cru1", "Espantoso!", 1).resultado);
        sis.registrarCrucero("Montevideo", "Cru1", 5, 2);
        assertEquals(Retorno.Resultado.OK, sis.ingresarComentario("Montevideo", "Cru1", "Espantoso!", 1).resultado);
    }

    @Test
    public void testListarServicios() {
        sis.crearSistemaReservas(4);
        assertEquals(Retorno.Resultado.ERROR_2, sis.listarServicios("Tarariras", "Cru1").resultado);
        sis.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, sis.listarServicios("Montevideo", "Cru1").resultado);
        sis.registrarCrucero("Montevideo", "Cru1", 5, 2);
        sis.ingresarServicio("Montevideo", "Cru1", "Malabares");
        sis.ingresarServicio("Montevideo", "Cru1", "Orquesta");
        sis.ingresarServicio("Montevideo", "Cru1", "Mago");
        sis.ingresarServicio("Montevideo", "Cru1", "Animador");
        sis.ingresarServicio("Montevideo", "Cru1", "Zoológico");

        r = sis.listarServicios("Montevideo", "Cru1");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        assertTrue(r.valorString.indexOf("Malabares") < r.valorString.indexOf("Orquesta"));
        assertTrue(r.valorString.indexOf("Orquesta") < r.valorString.indexOf("Mago"));
        assertTrue(r.valorString.indexOf("Mago") < r.valorString.indexOf("Animador"));
        assertTrue(r.valorString.indexOf("Animador") < r.valorString.indexOf("Zoológico"));
    }

    @Test
    public void testListarCrucerosCiudad() {

        sis.crearSistemaReservas(4);
        assertEquals(Retorno.Resultado.ERROR_1, sis.listarCrucerosCiudad("Tarariras").resultado);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo", "Cru1", 5, 2);
        sis.ingresarComentario("Montevideo", "Cru1", "Espantoso!", 1);
        sis.registrarCrucero("Montevideo", "Cru4", 5, 2);
        sis.ingresarComentario("Montevideo", "Cru4", "Maomeno!", 3);
        sis.registrarCrucero("Montevideo", "Cru2", 5, 2);
        sis.ingresarComentario("Montevideo", "Cru2", "Biennn!", 4);
        sis.ingresarComentario("Montevideo", "Cru2", "Espantoso!", 2);
        sis.registrarCrucero("Montevideo", "Cru3", 5, 2);
        sis.ingresarComentario("Montevideo", "Cru3", "Esselllente!!", 5);

        r = sis.listarCrucerosCiudad("Montevideo");
        assertEquals(Retorno.Resultado.OK, r.resultado);

        String strR = r.valorString;
        assertTrue(strR.indexOf("Montevideo") > -1);
        assertTrue(strR.indexOf("Cru1") < strR.indexOf("5", strR.indexOf("Cru1"))
                && strR.indexOf("5", strR.indexOf("Cru1")) < strR.indexOf("1", strR.indexOf("5", strR.indexOf("Cru1")))
                && strR.indexOf("1", strR.indexOf("5", strR.indexOf("Cru1"))) < strR.indexOf("Cru2"));
        assertTrue(strR.indexOf("Cru2") < strR.indexOf("5", strR.indexOf("Cru2"))
                && strR.indexOf("5", strR.indexOf("Cru2")) < strR.indexOf("3", strR.indexOf("5", strR.indexOf("Cru2")))
                && strR.indexOf("3", strR.indexOf("5", strR.indexOf("Cru2"))) < strR.indexOf("Cru3"));
        assertTrue(strR.indexOf("Cru3") < strR.indexOf("5", strR.indexOf("Cru3"))
                && strR.indexOf("5", strR.indexOf("Cru3")) < strR.indexOf("5", strR.indexOf("5", strR.indexOf("Cru3")) + 1)
                && strR.indexOf("5", strR.indexOf("5", strR.indexOf("Cru3")) + 1) < strR.indexOf("Cru4"));
        assertTrue(strR.indexOf("Cru4") < strR.indexOf("5", strR.indexOf("Cru4"))
                && strR.indexOf("5", strR.indexOf("Cru4")) < strR.indexOf("3", strR.indexOf("5", strR.indexOf("Cru4"))));

    }

    @Test
    public void testListarCrucerosRankingAsc() {
        sis.crearSistemaReservas(4);
        assertEquals(Retorno.Resultado.ERROR_1, sis.listarCrucerosRankingAsc("Tarariras").resultado);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo", "Cru2", 5, 2);
        sis.ingresarComentario("Montevideo", "Cru2", "Biennn!", 4);
        sis.registrarCrucero("Montevideo", "Cru1", 5, 2);
        sis.ingresarComentario("Montevideo", "Cru1", "Espantoso!", 1);
        sis.registrarCrucero("Montevideo", "Cru3", 5, 2);
        sis.ingresarComentario("Montevideo", "Cru3", "Esselllente!!", 5);
        sis.registrarCrucero("Montevideo", "Cru4", 5, 2);
        sis.ingresarComentario("Montevideo", "Cru4", "Maomeno!", 3);

        r = sis.listarCrucerosRankingAsc("Montevideo");
        assertEquals(Retorno.Resultado.OK, r.resultado);

        String strR = r.valorString;
        assertTrue(strR.indexOf("Montevideo") > -1);
        assertTrue(strR.indexOf("Cru1") < strR.indexOf("1", strR.indexOf("Cru1"))
                && strR.indexOf("1", strR.indexOf("Cru1")) < strR.indexOf("Cru4"));
        assertTrue(strR.indexOf("Cru4") < strR.indexOf("3", strR.indexOf("Cru4"))
                && strR.indexOf("3", strR.indexOf("Cru4")) < strR.indexOf("Cru2"));
        assertTrue(strR.indexOf("Cru2") < strR.indexOf("4", strR.indexOf("Cru2"))
                && strR.indexOf("4", strR.indexOf("Cru2")) < strR.indexOf("Cru3"));
        assertTrue(strR.indexOf("Cru3") < strR.indexOf("5", strR.indexOf("Cru3")));
    }

    @Test
    public void testListarCrucerosRankingDesc() {
        sis.crearSistemaReservas(4);
        assertEquals(Retorno.Resultado.ERROR_1, sis.listarCrucerosRankingAsc("Tarariras").resultado);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo", "Cru2", 5, 2);
        sis.ingresarComentario("Montevideo", "Cru2", "Biennn!", 4);
        sis.registrarCrucero("Montevideo", "Cru1", 5, 2);
        sis.ingresarComentario("Montevideo", "Cru1", "Espantoso!", 1);
        sis.registrarCrucero("Montevideo", "Cru3", 5, 2);
        sis.ingresarComentario("Montevideo", "Cru3", "Esselllente!!", 5);
        sis.registrarCrucero("Montevideo", "Cru4", 5, 2);
        sis.ingresarComentario("Montevideo", "Cru4", "Maomeno!", 3);

        r = sis.listarCrucerosRankingDesc("Montevideo");
        assertEquals(Retorno.Resultado.OK, r.resultado);

        String strR = r.valorString;
        assertTrue(strR.indexOf("Montevideo") > -1);
        assertTrue(strR.indexOf("Cru3") < strR.indexOf("5", strR.indexOf("Cru3"))
                && strR.indexOf("5", strR.indexOf("Cru3")) < strR.indexOf("Cru2"));
        assertTrue(strR.indexOf("Cru2") < strR.indexOf("4", strR.indexOf("Cru2"))
                && strR.indexOf("4", strR.indexOf("Cru2")) < strR.indexOf("Cru4"));
        assertTrue(strR.indexOf("Cru4") < strR.indexOf("3", strR.indexOf("Cru4"))
                && strR.indexOf("3", strR.indexOf("Cru4")) < strR.indexOf("Cru1"));
        assertTrue(strR.indexOf("Cru1") < strR.indexOf("1", strR.indexOf("Cru1")));
    }

    @Test
    public void testListarCrucerosRanking() {

        sis.crearSistemaReservas(4);
        sis.registrarCiudad("Montevideo");
        sis.registrarCiudad("Melo");
        sis.registrarCiudad("Trinidad");
        sis.registrarCrucero("Montevideo", "Cru2", 5, 2);
        sis.ingresarComentario("Montevideo", "Cru2", "Biennn!", 4);
        sis.registrarCrucero("Melo", "Cru1", 5, 2);
        sis.ingresarComentario("Melo", "Cru1", "Espantoso!", 1);
        sis.registrarCrucero("Trinidad", "Cru3", 5, 2);
        sis.ingresarComentario("Trinidad", "Cru3", "Esselllente!!", 5);
        sis.registrarCrucero("Melo", "Cru4", 5, 2);
        sis.ingresarComentario("Melo", "Cru4", "Maomeno!", 3);

        r = sis.listarCrucerosRanking();
        assertEquals(Retorno.Resultado.OK, r.resultado);

        //  REVISAR RESULTADO
        String strR = r.valorString;
        assertTrue(strR.indexOf("Cru3") < strR.indexOf("5", strR.indexOf("Cru3"))
                && strR.indexOf("5", strR.indexOf("Cru3")) < strR.indexOf("Cru2"));
        assertTrue(strR.indexOf("Cru2") < strR.indexOf("4", strR.indexOf("Cru2"))
                && strR.indexOf("4", strR.indexOf("Cru2")) < strR.indexOf("Cru4"));
        assertTrue(strR.indexOf("Cru4") < strR.indexOf("3", strR.indexOf("Cru4"))
                && strR.indexOf("3", strR.indexOf("Cru4")) < strR.indexOf("Cru1"));
        assertTrue(strR.indexOf("Cru1") < strR.indexOf("1", strR.indexOf("Cru1")));
    }

    @Test
    public void testListarComentarios() {
        sis.crearSistemaReservas(4);
        assertEquals(Retorno.Resultado.ERROR_2, sis.listarComentarios("Montevideo", "Cru2").resultado);
        sis.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, sis.listarComentarios("Montevideo", "Cru2").resultado);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo", "Cru2", 5, 2);
        sis.ingresarComentario("Montevideo", "Cru2", "Maomeno!", 3);
        sis.ingresarComentario("Montevideo", "Cru2", "Esselllente!!", 5);
        sis.ingresarComentario("Montevideo", "Cru2", "Espantoso!", 1);
        sis.ingresarComentario("Montevideo", "Cru2", "Biennn!", 4);

        r = sis.listarComentarios("Montevideo", "Cru2");
        assertEquals(Retorno.Resultado.OK, r.resultado);

        String strR = r.valorString;
        assertTrue(strR.indexOf("Biennn") < strR.indexOf("Espantoso"));
        assertTrue(strR.indexOf("Espantoso") < strR.indexOf("Esselllente"));
        assertTrue(strR.indexOf("Esselllente") < strR.indexOf("Maomeno"));
    }

    @Test
    public void testCargarDistancias() {
        sis.crearSistemaReservas(6);
        sis.registrarCiudad("Montevideo");
        sis.registrarCiudad("Santiago");
        sis.registrarCiudad("Lima");
        sis.registrarCiudad("San Pablo");
        sis.registrarCiudad("Panamá");
        sis.registrarCiudad("New York");

        assertEquals(Retorno.Resultado.OK, sis.cargarDistancias(new int[][]{
            {0, 10, 25, 15, 30, 0},
            {10, 0, 20, 0, 0, 0},
            {25, 20, 0, 0, 0, 40},
            {15, 0, 0, 0, 0, 45},
            {30, 0, 0, 0, 0, 25},
            {0, 0, 40, 45, 25, 0}
        }).resultado);
    }

    @Test
    public void testBuscarCamino() {

        sis.crearSistemaReservas(6);
        sis.registrarCiudad("Montevideo");
        sis.registrarCiudad("Santiago");
        sis.registrarCiudad("Lima");
        sis.registrarCiudad("San Pablo");
        sis.registrarCiudad("Panamá");
        sis.registrarCiudad("New York");

        int[][] mat = new int[][]{
            {0, 10, 25, 15, 30, 0},
            {10, 0, 20, 0, 0, 0},
            {25, 20, 0, 0, 0, 40},
            {15, 0, 0, 0, 0, 45},
            {30, 0, 0, 0, 0, 25},
            {0, 0, 40, 45, 25, 0}
        };
        sis.cargarDistancias(new int[][]{
            {0, 10, 25, 15, 30, 0},
            {10, 0, 20, 0, 0, 0},
            {25, 20, 0, 0, 0, 40},
            {15, 0, 0, 0, 0, 45},
            {30, 0, 0, 0, 0, 25},
            {0, 0, 40, 45, 25, 0}
        });

        r = sis.buscarCamino(mat, "Montevideo", "New York");
        assertEquals(Retorno.Resultado.OK, r.resultado);

        String strR = r.valorString;
        assertTrue(strR.indexOf("Montevideo") < strR.indexOf("Panamá"));
        assertTrue(strR.indexOf("Panamá") < strR.indexOf("New York"));
    }

}
