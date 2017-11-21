package Pruebas;

import Sistema.Retorno;
import Sistema.Sistema;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/* SOBRE ESTE JUEGO DE PRUEBAS
Se presenta un juego de pruebas preliminar NO EXHAUSTIVO que detalla alguna de las pruebas básicas de cada funcionalidad.
El hecho de que el obligatorio testeado pase el 100 % de estas pruebas no implica obtener todos los puntos de las funcionalidades testeadas.
 */
public class PreliminarTest {

    private Sistema s;
    private Retorno r;

    @Before
    public void setUp() throws Exception {
        s = new Sistema();
    }

    @Test
    public void testCrearSistemaReservas() {
        assertEquals(Retorno.Resultado.ERROR_1, s.crearSistemaReservas(-5).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.crearSistemaReservas(-1).resultado);
        assertEquals(Retorno.Resultado.OK, s.crearSistemaReservas(0).resultado);
        s = new Sistema();
        assertEquals(Retorno.Resultado.OK, s.crearSistemaReservas(5).resultado);
    }

    @Test
    public void testDestruirSistemaReservas() {
        s.crearSistemaReservas(5);
        assertEquals(Retorno.Resultado.OK, s.destruirSistemaReservas().resultado);
    }

    @Test
    public void testRegistrarCiudad() {
        s.crearSistemaReservas(4);

        assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Montevideo").resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.registrarCiudad("Montevideo").resultado);
        assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Tarariras").resultado);
    }

    @Test
    public void testRegistrarCrucero() {
        s.crearSistemaReservas(4);

        s.registrarCiudad("Montevideo");

        assertEquals(Retorno.Resultado.ERROR_1, s.registrarCrucero("Montevideo", "Cru1", 0, 100).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.registrarCrucero("Montevideo", "Cru1", 6, 100).resultado);
        assertEquals(Retorno.Resultado.ERROR_2, s.registrarCrucero("Montevideo", "Cru1", 5, -1).resultado);
        assertEquals(Retorno.Resultado.ERROR_4, s.registrarCrucero("Melo", "Cru1", 5, 100).resultado);
        assertEquals(Retorno.Resultado.OK, s.registrarCrucero("Montevideo", "Cru1", 5, 100).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, s.registrarCrucero("Montevideo", "Cru1", 5, 100).resultado);
    }

    @Test
    public void testIngresarServicio() {
        s.crearSistemaReservas(4);

        assertEquals(Retorno.Resultado.ERROR_2, s.ingresarServicio("Tarariras", "Cru1", "Malabares").resultado);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, s.ingresarServicio("Montevideo", "Cru1", "Malabares").resultado);
        s.registrarCrucero("Montevideo", "Cru1", 5, 100);
        assertEquals(Retorno.Resultado.OK, s.ingresarServicio("Montevideo", "Cru1", "Malabares").resultado);
    }

    @Test
    public void testBorrarServicio() {
        s.crearSistemaReservas(4);

        assertEquals(Retorno.Resultado.ERROR_3, s.borrarServicio("Tarariras", "Cru1", "Malabares").resultado);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, s.borrarServicio("Montevideo", "Cru1", "Malabares").resultado);
        s.registrarCrucero("Montevideo", "Cru1", 5, 100);
        assertEquals(Retorno.Resultado.ERROR_2, s.borrarServicio("Montevideo", "Cru1", "Malabares").resultado);
        s.ingresarServicio("Montevideo", "Cru1", "Malabares");
        assertEquals(Retorno.Resultado.OK, s.borrarServicio("Montevideo", "Cru1", "Malabares").resultado);

    }

    @Test
    public void testRealizarReserva() {
        s.crearSistemaReservas(4);
        assertEquals(Retorno.Resultado.ERROR_2, s.realizarReserva(1, "Tarariras", "Cru1").resultado);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, s.realizarReserva(1, "Montevideo", "Cru1").resultado);
        s.registrarCrucero("Montevideo", "Cru1", 5, 2);
        assertEquals(Retorno.Resultado.OK, s.realizarReserva(1, "Montevideo", "Cru1").resultado);
        assertEquals(Retorno.Resultado.OK, s.realizarReserva(2, "Montevideo", "Cru1").resultado);
        //A lista de espera
        assertEquals(Retorno.Resultado.OK, s.realizarReserva(3, "Montevideo", "Cru1").resultado);
    }

    @Test
    public void testCancelarReserva() {
        s.crearSistemaReservas(4);

        assertEquals(Retorno.Resultado.ERROR_3, s.cancelarReserva(1, "Tarariras", "Cru1").resultado);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, s.cancelarReserva(1, "Montevideo", "Cru1").resultado);
        s.registrarCrucero("Montevideo", "Cru1", 5, 2);
        assertEquals(Retorno.Resultado.ERROR_2, s.cancelarReserva(1, "Montevideo", "Cru1").resultado);
        s.realizarReserva(1, "Montevideo", "Cru1");
        assertEquals(Retorno.Resultado.OK, s.cancelarReserva(1, "Montevideo", "Cru1").resultado);
        assertEquals(Retorno.Resultado.ERROR_2, s.cancelarReserva(1, "Montevideo", "Cru1").resultado);
    }

    @Test
    public void testIngresarComentario() {
        s.crearSistemaReservas(4);

        assertEquals(Retorno.Resultado.ERROR_1, s.ingresarComentario("Tarariras", "Cru1", "Espantoso!", -1).resultado);
        assertEquals(Retorno.Resultado.ERROR_1, s.ingresarComentario("Tarariras", "Cru1", "Espantoso!", 6).resultado);
        assertEquals(Retorno.Resultado.ERROR_3, s.ingresarComentario("Montevideo", "Cru1", "Espantoso!", 1).resultado);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_2, s.ingresarComentario("Montevideo", "Cru1", "Espantoso!", 1).resultado);
        s.registrarCrucero("Montevideo", "Cru1", 5, 2);
        assertEquals(Retorno.Resultado.OK, s.ingresarComentario("Montevideo", "Cru1", "Espantoso!", 1).resultado);
    }

    @Test
    public void testListarServicios() {
        s.crearSistemaReservas(4);
        assertEquals(Retorno.Resultado.ERROR_2, s.listarServicios("Tarariras", "Cru1").resultado);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, s.listarServicios("Montevideo", "Cru1").resultado);
        s.registrarCrucero("Montevideo", "Cru1", 5, 2);
        s.ingresarServicio("Montevideo", "Cru1", "Malabares");
        s.ingresarServicio("Montevideo", "Cru1", "Orquesta");
        s.ingresarServicio("Montevideo", "Cru1", "Mago");
        s.ingresarServicio("Montevideo", "Cru1", "Animador");
        s.ingresarServicio("Montevideo", "Cru1", "Zoológico");
        r = s.listarServicios("Montevideo", "Cru1");
        assertEquals(Retorno.Resultado.OK, r.resultado);
        assertTrue(r.valorString.indexOf("Malabares") < r.valorString.indexOf("Orquesta"));
        assertTrue(r.valorString.indexOf("Orquesta") < r.valorString.indexOf("Mago"));
        assertTrue(r.valorString.indexOf("Mago") < r.valorString.indexOf("Animador"));
        assertTrue(r.valorString.indexOf("Animador") < r.valorString.indexOf("Zoológico"));
    }

    @Test
    public void testListarCrucerosCiudad() {

        s.crearSistemaReservas(4);
        assertEquals(Retorno.Resultado.ERROR_1, s.listarCrucerosCiudad("Tarariras").resultado);
        s.registrarCiudad("Montevideo");
        s.registrarCrucero("Montevideo", "Cru1", 5, 2);
        s.ingresarComentario("Montevideo", "Cru1", "Espantoso!", 1);
        s.registrarCrucero("Montevideo", "Cru4", 5, 2);
        s.ingresarComentario("Montevideo", "Cru4", "Maomeno!", 3);
        s.registrarCrucero("Montevideo", "Cru2", 5, 2);
        s.ingresarComentario("Montevideo", "Cru2", "Biennn!", 4);
        s.ingresarComentario("Montevideo", "Cru2", "Espantoso!", 2);
        s.registrarCrucero("Montevideo", "Cru3", 5, 2);
        s.ingresarComentario("Montevideo", "Cru3", "Esselllente!!", 5);
        r = s.listarCrucerosCiudad("Montevideo");
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

    /*

	@Test
	public void testListarCrucerosRankingAsc() {
		sis.crearSistemaReservas(4);
		assertEquals(Retorno.Resultado.ERROR_1, sis.listarCrucerosRankingAsc("Tarariras").resultado);
		sis.registrarCiudad("Montevideo");
		sis.registrarCrucero("Montevideo", "Cru2", 5, 2);
		sis.ingresarComentario("Montevideo", "Cru2", "Biennn!",4);
		sis.registrarCrucero("Montevideo", "Cru1", 5, 2);
		sis.ingresarComentario("Montevideo", "Cru1", "Espantoso!",1);
		sis.registrarCrucero("Montevideo", "Cru3", 5, 2);
		sis.ingresarComentario("Montevideo", "Cru3", "Esselllente!!",5);
		sis.registrarCrucero("Montevideo", "Cru4", 5, 2);
		sis.ingresarComentario("Montevideo", "Cru4", "Maomeno!",3);
		
		r = sis.listarCrucerosRankingAsc("Montevideo");
		assertEquals(Retorno.Resultado.OK, r.resultado);
		
		String strR = r.valorString;
		assertTrue(strR.indexOf("Montevideo")>-1);
		assertTrue(strR.indexOf("Cru1")<strR.indexOf("1",strR.indexOf("Cru1")) && 
				strR.indexOf("1",strR.indexOf("Cru1"))<strR.indexOf("Cru4"));
		assertTrue(strR.indexOf("Cru4")<strR.indexOf("3",strR.indexOf("Cru4")) && 
				strR.indexOf("3",strR.indexOf("Cru4"))<strR.indexOf("Cru2"));
		assertTrue(strR.indexOf("Cru2")<strR.indexOf("4",strR.indexOf("Cru2")) && 
				strR.indexOf("4",strR.indexOf("Cru2"))<strR.indexOf("Cru3"));
		assertTrue(strR.indexOf("Cru3")<strR.indexOf("5",strR.indexOf("Cru3")));
	}

	@Test
	public void testListarCrucerosRankingDesc() {
		sis.crearSistemaReservas(4);
		assertEquals(Retorno.Resultado.ERROR_1, sis.listarCrucerosRankingAsc("Tarariras").resultado);
		sis.registrarCiudad("Montevideo");
		sis.registrarCrucero("Montevideo", "Cru2", 5, 2);
		sis.ingresarComentario("Montevideo", "Cru2", "Biennn!",4);
		sis.registrarCrucero("Montevideo", "Cru1", 5, 2);
		sis.ingresarComentario("Montevideo", "Cru1", "Espantoso!",1);
		sis.registrarCrucero("Montevideo", "Cru3", 5, 2);
		sis.ingresarComentario("Montevideo", "Cru3", "Esselllente!!",5);
		sis.registrarCrucero("Montevideo", "Cru4", 5, 2);
		sis.ingresarComentario("Montevideo", "Cru4", "Maomeno!",3);
		
		r = sis.listarCrucerosRankingDesc("Montevideo");
		assertEquals(Retorno.Resultado.OK, r.resultado);
		
		String strR = r.valorString;
		assertTrue(strR.indexOf("Montevideo")>-1);
		assertTrue(strR.indexOf("Cru3")<strR.indexOf("5",strR.indexOf("Cru3")) && 
				strR.indexOf("5",strR.indexOf("Cru3"))<strR.indexOf("Cru2"));
		assertTrue(strR.indexOf("Cru2")<strR.indexOf("4",strR.indexOf("Cru2")) && 
				strR.indexOf("4",strR.indexOf("Cru2"))<strR.indexOf("Cru4"));
		assertTrue(strR.indexOf("Cru4")<strR.indexOf("3",strR.indexOf("Cru4")) && 
				strR.indexOf("3",strR.indexOf("Cru4"))<strR.indexOf("Cru1"));
		assertTrue(strR.indexOf("Cru1")<strR.indexOf("1",strR.indexOf("Cru1")));
	}

	@Test
	public void testListarCrucerosRanking() {
	
		sis.crearSistemaReservas(4);
		sis.registrarCiudad("Montevideo");
		sis.registrarCiudad("Melo");
		sis.registrarCiudad("Trinidad");
		sis.registrarCrucero("Montevideo", "Cru2", 5, 2);
		sis.ingresarComentario("Montevideo", "Cru2", "Biennn!",4);
		sis.registrarCrucero("Melo", "Cru1", 5, 2);
		sis.ingresarComentario("Melo", "Cru1", "Espantoso!",1);
		sis.registrarCrucero("Trinidad", "Cru3", 5, 2);
		sis.ingresarComentario("Trinidad", "Cru3", "Esselllente!!",5);
		sis.registrarCrucero("Melo", "Cru4", 5, 2); 
		sis.ingresarComentario("Melo", "Cru4", "Maomeno!",3);
		
		r = sis.listarCrucerosRanking();
		assertEquals(Retorno.Resultado.OK, r.resultado);
		
		//  REVISAR RESULTADO
		String strR = r.valorString;
		assertTrue(strR.indexOf("Montevideo")>-1);
		assertTrue(strR.indexOf("Cru3")<strR.indexOf("5",strR.indexOf("Cru3")) && 
				strR.indexOf("5",strR.indexOf("Cru3"))<strR.indexOf("Cru2"));
		assertTrue(strR.indexOf("Cru2")<strR.indexOf("4",strR.indexOf("Cru2")) && 
				strR.indexOf("4",strR.indexOf("Cru2"))<strR.indexOf("Cru4"));
		assertTrue(strR.indexOf("Cru4")<strR.indexOf("3",strR.indexOf("Cru4")) && 
				strR.indexOf("3",strR.indexOf("Cru4"))<strR.indexOf("Cru1"));
		assertTrue(strR.indexOf("Cru1")<strR.indexOf("1",strR.indexOf("Cru1")));
	}

	@Test
	public void testListarComentarios() {
		sis.crearSistemaReservas(4);
		assertEquals(Retorno.Resultado.ERROR_2, sis.listarComentarios("Montevideo", "Cru2").resultado);
		sis.registrarCiudad("Montevideo");
		assertEquals(Retorno.Resultado.ERROR_1, sis.listarComentarios("Montevideo", "Cru2").resultado);
		sis.registrarCiudad("Montevideo");
		sis.registrarCrucero("Montevideo", "Cru2", 5, 2);
		sis.ingresarComentario("Montevideo", "Cru2", "Biennn!",4);
		sis.ingresarComentario("Montevideo", "Cru2", "Espantoso!",1);
		sis.ingresarComentario("Montevideo", "Cru2", "Esselllente!!",5);
		sis.ingresarComentario("Montevideo", "Cru2", "Maomeno!",3);
		
		r = sis.listarComentarios("Montevideo", "Cru2");
		assertEquals(Retorno.Resultado.OK, r.resultado);
		
		String strR = r.valorString;
		assertTrue(strR.indexOf("Biennn")<strR.indexOf("Espantoso"));
		assertTrue(strR.indexOf("Espantoso")<strR.indexOf("Esselllente"));
		assertTrue(strR.indexOf("Esselllente")<strR.indexOf("Maomeno"));
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

		assertEquals(Retorno.Resultado.OK,sis.cargarDistancias(new int[][] {
			{0,10,25,15,30,0},
			{10,0,20,0,0,0},
			{25,20,0,0,0,40},
			{15,0,0,0,0,45},
			{30,0,0,0,0,25},
			{0,0,40,45,25,0}
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
		
		int[][] mat = new int[][] {
			{0,10,25,15,30,0},
			{10,0,20,0,0,0},
			{25,20,0,0,0,40},
			{15,0,0,0,0,45},
			{30,0,0,0,0,25},
			{0,0,40,45,25,0}
		};
		
		assertEquals(Retorno.Resultado.OK,sis.buscarCamino(mat,"Montevideo","New York").resultado);
		
		String strR = r.valorString;
		assertTrue(strR.indexOf("Montevideo")<strR.indexOf("Panamá"));
		assertTrue(strR.indexOf("Panamá")<strR.indexOf("New York"));
	}
     */
}
