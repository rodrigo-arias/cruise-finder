package Pruebas;

import Sistema.Retorno;
import Sistema.Sistema;
import Sistema.Utilidad;
import org.junit.Test;
import static org.junit.Assert.*;

public class ComentarioTest {

    Utilidad u = new Utilidad();
    Sistema s = new Sistema();

    @Test
    public void registrarCiudad() {
        s.crearSistemaReservas(6);
        assertEquals(Retorno.Resultado.OK, u.retornarResultado(s.registrarCiudad("Montevideo")));
    }
}

/*

p.ver(s.ingresarComentario("Santiago", "Royal Caribbean Int.", "Me gusto", 4), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
p.ver(s.ingresarComentario("Santiago", "Royal Caribbean Int.", "Me gusto", 4), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Tienen que mejorar la limpieza", 2), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
p.ver(s.ingresarComentario("Santiago", "Carnival Cruise Lines", "Excelente", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Carnival Cruise Lines de Santiago");
p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "No me gusto nada", -1), Retorno.Resultado.ERROR_1, "El ranking del comentario no está entre 0 y 5");
p.ver(s.ingresarComentario("Montevideo", "Disney Cruise Line", "El crucero está muy bueno", 4), Retorno.Resultado.ERROR_2, "No se encontró un crucero con ese nombre para Montevideo");
p.ver(s.ingresarComentario("Asunción", "Royal Caribbean Int.", "Se pueden mejorar algunas cosas", 3), Retorno.Resultado.ERROR_3, "No se encontró la ciudad Asunción");
s.listarCrucerosRanking();

p.ver(s.ingresarComentario("Santiago", "Royal Caribbean Int.", "No me gustó", 2), Retorno.Resultado.OK, "Se ingresó un comentario en el Royal Caribbean Int. de Santiago");
p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Me encantó", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Me encantó", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Me encantó", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Me encantó", 5), Retorno.Resultado.OK, "Se ingresó un comentario en el Disney Cruise Line de Santiago");
s.listarCrucerosRanking();

 */
