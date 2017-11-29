package Pruebas;

import Sistema.Retorno;
import Sistema.Sistema;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DefensaTest {

    private Sistema s;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        s = new Sistema();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCrearSistemaReservas() {
        assertEquals(Retorno.Resultado.ERROR_1, s.crearSistemaReservas(-3).resultado); //No se crea el sistema de reservas por tener tope negativo
        assertEquals(Retorno.Resultado.OK, s.crearSistemaReservas(5).resultado);
    }

    @Test
    public void testRegistrarCiudad() {
        s.crearSistemaReservas(5);
        assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Montevideo").resultado);
        assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Santiago").resultado);
        assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Lima").resultado);
        assertEquals(Retorno.Resultado.OK, s.registrarCiudad("San Pablo").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.registrarCiudad("Montevideo").resultado);//Montevideo ya existe
        assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Panamá").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, s.registrarCiudad("New York").resultado);//No se ingresa New York por superar el tope
    }

    @Test
    public void testRegistrarCrucero() {
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.OK, s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2000).resultado);
        assertEquals(Retorno.Resultado.OK, s.registrarCrucero("Montevideo", "Carnival Cruise Line", 4, 2500).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.registrarCrucero("Montevideo", "Holland America Line", 6, 2800).resultado);//La cantidad de estrellas no está entre 1 y 5
        assertEquals(Retorno.Resultado.ERROR_2, s.registrarCrucero("Montevideo", "Princess Cruises", 5, -1).resultado);//La capacidad es menor a 0
        assertEquals(Retorno.Resultado.ERROR_3, s.registrarCrucero("Montevideo", "MSC Poesia", 4, 3100).resultado);//Ya existe un crucero con ese nombre para Montevideo
        assertEquals(Retorno.Resultado.ERROR_4, s.registrarCrucero("New York", "Norwegian Cruise Line", 5, 3000).resultado);//La ciudad no existe
    }

    @Test
    public void testIngresarServicio() {
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2000);
        assertEquals(Retorno.Resultado.OK, s.ingresarServicio("Montevideo", "MSC Poesia", "Wifi").resultado);
        assertEquals(Retorno.Resultado.OK, s.ingresarServicio("Montevideo", "MSC Poesia", "Shopping a bordo").resultado);
        assertEquals(Retorno.Resultado.OK, s.ingresarServicio("Montevideo", "MSC Poesia", "Guarderia").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.ingresarServicio("Montevideo", "Holland America Line", "Guarderia").resultado);//No existe ese crucero en la ciudad
        assertEquals(Retorno.Resultado.ERROR_2, s.ingresarServicio("New York", "Norwegian Cruise Line", "Guarderia").resultado);//La ciudad no existe
    }

    @Test
    public void testBorrarServicio() {
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2000);
        s.ingresarServicio("Montevideo", "MSC Poesia", "Wifi");
        s.ingresarServicio("Montevideo", "MSC Poesia", "Shopping a bordo");
        assertEquals(Retorno.Resultado.OK, s.borrarServicio("Montevideo", "MSC Poesia", "Wifi").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.borrarServicio("Montevideo", "Holland America Line", "Guarderia").resultado);//No existe ese crucero en la ciudad
        assertEquals(Retorno.Resultado.ERROR_2, s.borrarServicio("Montevideo", "MSC Poesia", "Lavanderia").resultado);//No existe el servicio en el crucero
        assertEquals(Retorno.Resultado.ERROR_3, s.borrarServicio("New York", "Norwegian Cruise Line", "Guarderia").resultado);//La ciudad no existe

    }

    @Test
    public void testRealizarReserva() {
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2);
        assertEquals(Retorno.Resultado.OK, s.realizarReserva(1, "Montevideo", "MSC Poesia").resultado);
        assertEquals(Retorno.Resultado.OK, s.realizarReserva(2, "Montevideo", "MSC Poesia").resultado);
        assertEquals(Retorno.Resultado.OK, s.realizarReserva(3, "Montevideo", "MSC Poesia").resultado);
        assertEquals(Retorno.Resultado.OK, s.realizarReserva(4, "Montevideo", "MSC Poesia").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.realizarReserva(5, "Montevideo", "Holland America Line").resultado);//No existe ese crucero en la ciudad
        assertEquals(Retorno.Resultado.ERROR_2, s.realizarReserva(6, "New York", "Norwegian Cruise Line").resultado);//La ciudad no existe
    }

    @Test
    public void testCancelarReserva() {
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2);
        s.realizarReserva(1, "Montevideo", "MSC Poesia");
        s.realizarReserva(2, "Montevideo", "MSC Poesia");
        s.realizarReserva(3, "Montevideo", "MSC Poesia");
        s.realizarReserva(4, "Montevideo", "MSC Poesia");
        assertEquals(Retorno.Resultado.OK, s.cancelarReserva(2, "Montevideo", "MSC Poesia").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, s.cancelarReserva(8, "Montevideo", "MSC Poesia").resultado);//El cliente no tiene reserva en el crucero
        assertEquals(Retorno.Resultado.ERROR_1, s.cancelarReserva(2, "Montevideo", "Holland America Line").resultado);//No existe ese crucero en la ciudad
        assertEquals(Retorno.Resultado.ERROR_3, s.cancelarReserva(3, "New York", "Holland America Line").resultado);//La ciudad no existe
    }

    @Test
    public void testIngresarComentario() {
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2);
        assertEquals(Retorno.Resultado.OK, s.ingresarComentario("Montevideo", "MSC Poesia", "Muy lindo crucero, personal muy amable", 4).resultado);
        assertEquals(Retorno.Resultado.OK, s.ingresarComentario("Montevideo", "MSC Poesia", "Mala limpieza", 2).resultado);
        assertEquals(Retorno.Resultado.OK, s.ingresarComentario("Montevideo", "MSC Poesia", "Nos gusto mucho el crucero", 3).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.ingresarComentario("Montevideo", "MSC Poesia", "Muy recomendable", 10).resultado);//Ranking mayor a 5
        assertEquals(Retorno.Resultado.ERROR_2, s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Muy lindo crucero, personal muy amable", 4).resultado);//No existe el crucero en la ciudad
        assertEquals(Retorno.Resultado.ERROR_3, s.ingresarComentario("New York", "Royal Caribbean Int.", "Muy lindo crucero, personal muy amable", 4).resultado);//No existe la ciudad

    }

    @Test
    public void testListarServicios() {
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2000);
        s.registrarCiudad("Panamá");
        s.registrarCrucero("Panamá", "Costa Cruise", 3, 2000);
        s.ingresarServicio("Montevideo", "MSC Poesia", "Wifi");
        s.ingresarServicio("Montevideo", "MSC Poesia", "Shopping a bordo");
        assertEquals(Retorno.Resultado.OK, s.listarServicios("Panamá", "Costa Cruise").resultado);
        assertEquals(Retorno.Resultado.OK, s.listarServicios("Montevideo", "MSC Poesia").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.listarServicios("Montevideo", "Disney Cruise Line").resultado);//No existe el crucero en la ciudad
        assertEquals(Retorno.Resultado.ERROR_2, s.listarServicios("Buenos Aires", "MSC Poesia").resultado);//No existe la ciudad
    }

    @Test
    public void testListarCrucerosCiudad() {
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2000);
        s.registrarCrucero("Montevideo", "Carnival Cruise Line", 4, 2500);
        s.registrarCiudad("Panamá");
        s.registrarCrucero("Panamá", "Costa Cruise", 3, 2000);
        assertEquals(Retorno.Resultado.OK, s.listarCrucerosCiudad("Montevideo").resultado);
        assertEquals(Retorno.Resultado.OK, s.listarCrucerosCiudad("Panamá").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.listarCrucerosCiudad("Buenos Aires").resultado);//No existe la ciudad
    }

    @Test
    public void testListarCrucerosRankingAsc() {
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2000);
        s.registrarCrucero("Montevideo", "Carnival Cruise Line", 4, 2500);
        s.registrarCiudad("Panamá");
        s.registrarCrucero("Panamá", "Costa Cruise", 3, 2000);
        s.ingresarComentario("Montevideo", "MSC Poesia", "Muy lindo crucero, personal muy amable", 4);
        assertEquals(Retorno.Resultado.OK, s.listarCrucerosRankingAsc("Montevideo").resultado);
        assertEquals(Retorno.Resultado.OK, s.listarCrucerosRankingAsc("Panamá").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.listarCrucerosRankingAsc("Buenos Aires").resultado);//No existe la ciudad
    }

    @Test
    public void testListarCrucerosRankingDesc() {
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2000);
        s.registrarCrucero("Montevideo", "Carnival Cruise Line", 4, 2500);
        s.registrarCiudad("Panamá");
        s.registrarCrucero("Panamá", "Costa Cruise", 3, 2000);
        s.ingresarComentario("Montevideo", "MSC Poesia", "Muy lindo crucero, personal muy amable", 4);
        assertEquals(Retorno.Resultado.OK, s.listarCrucerosRankingDesc("Montevideo").resultado);
        assertEquals(Retorno.Resultado.OK, s.listarCrucerosRankingDesc("Panamá").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.listarCrucerosRankingDesc("Buenos Aires").resultado);//No existe la ciudad
    }

    @Test
    public void testListarCrucerosRanking() {
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2000);
        s.registrarCrucero("Montevideo", "Carnival Cruise Line", 4, 2500);
        s.registrarCiudad("Panamá");
        s.registrarCrucero("Panamá", "Costa Cruise", 3, 2000);
        s.ingresarComentario("Montevideo", "MSC Poesia", "Muy lindo crucero, personal muy amable", 4);
        assertEquals(Retorno.Resultado.OK, s.listarCrucerosRanking().resultado);
    }

    @Test
    public void testListarComentarios() {
        s.crearSistemaReservas(5);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2);
        s.ingresarComentario("Montevideo", "MSC Poesia", "Muy lindo crucero, personal muy amable", 4);
        s.ingresarComentario("Montevideo", "MSC Poesia", "Mala limpieza", 2);
        s.ingresarComentario("Montevideo", "MSC Poesia", "Nos gusto mucho el crucero", 3);
        assertEquals(Retorno.Resultado.OK, s.listarComentarios("Montevideo", "MSC Poesia").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.listarComentarios("Montevideo", "Disney Cruise Line").resultado);//No existe el crucero en la ciudad
        assertEquals(Retorno.Resultado.ERROR_2, s.listarComentarios("San Francisco", "Disney Cruise Line").resultado);//No existe la ciudad
    }

    @Test
    public void testCargarDistancias() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Santiago");
        s.registrarCiudad("Lima");
        s.registrarCiudad("San Pablo");
        s.registrarCiudad("Panamá");
        s.registrarCiudad("New York");
        int[][] ciudades = {{0, 10, 25, 15, 30, 0}, {10, 0, 20, 0, 0, 0}, {25, 20, 0, 0, 0, 40}, {15, 0, 0, 0, 0, 45}, {30, 0, 0, 0, 0, 25}, {0, 0, 40, 45, 25, 0}};
        assertEquals(Retorno.Resultado.OK, s.cargarDistancias(ciudades).resultado);
    }

    @Test
    public void testBuscarCamino() {
        s.crearSistemaReservas(6);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Santiago");
        s.registrarCiudad("Lima");
        s.registrarCiudad("San Pablo");
        s.registrarCiudad("Panamá");
        s.registrarCiudad("New York");
        int[][] ciudades = {{0, 10, 25, 15, 30, 0}, {10, 0, 20, 0, 0, 0}, {25, 20, 0, 0, 0, 40}, {15, 0, 0, 0, 0, 45}, {30, 0, 0, 0, 0, 25}, {0, 0, 40, 45, 25, 0}};
        s.cargarDistancias(ciudades);
        assertEquals(Retorno.Resultado.OK, s.buscarCamino(ciudades, "Montevideo", "New York").resultado);
    }

    @Test
    public void testDestruirSistemaReservas() {
        s.crearSistemaReservas(5);
        assertEquals(Retorno.Resultado.OK, s.destruirSistemaReservas().resultado);
    }
}
