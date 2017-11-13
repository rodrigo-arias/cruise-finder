package Sistema;

import Datos.ListaCiudad;
import Dominio.Ciudad;
import Dominio.Comentario;
import Dominio.Crucero;
import Sistema.Retorno.Resultado;

public class Sistema implements ISistema {

    //inicialización de lista de ciudades
    private ListaCiudad<Ciudad> ciudades;

    //Pre: cantCiudades >= 0;
    //Post: Setea la cantidad de ciudades que se pueden ingresar
    @Override
    public Retorno crearSistemaReservas(int cantCiudades) {

        Retorno ret = new Retorno();
        ciudades = new ListaCiudad<>();

        if (cantCiudades >= 0) {
            ciudades.setCantMaxima(cantCiudades);
            ret.resultado = Resultado.OK;
        } else {
            ret.resultado = Resultado.ERROR_1;
        }
        return ret;
    }

    //Pre:
    //Post: Se destruyen la lista ciudades
    @Override
    public Retorno destruirSistemaReservas() {

        Retorno ret = new Retorno();

        ciudades = new ListaCiudad<>();
        System.gc();
        ret.resultado = Resultado.OK;

        return ret;
    }

    //Pre: ciudad != ""
    //Post: Agrega la ciudad al inicio de la lista de ciudades
    @Override
    public Retorno registrarCiudad(String ciudad) {

        Retorno ret = new Retorno();

        if (ciudades.getCantElementos() < ciudades.getCantMaxima() || ciudades.getCantMaxima() == 0) {

            Ciudad nueva = new Ciudad(ciudad);

            if (ciudades.find(nueva) == null) {

                ciudades.insert(nueva);
                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Resultado.ERROR_1;

            }

        } else {
            ret.resultado = Resultado.ERROR_2;
        }
        return ret;
    }

    //Pre: ciudad != "", nombre != ""
    //Post: Agrega el crucero al inicio de la lista de cruceros de la ciudad y
    //con raking 0 en el sistema de reservas
    @Override
    public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad) {

        Retorno ret = new Retorno();
        Ciudad cityTemp = new Ciudad(ciudad);
        Ciudad cityFound = ciudades.find(cityTemp);

        if (estrellas < 1 || estrellas > 5) {
            ret.resultado = Retorno.Resultado.ERROR_1;
        } else if (capacidad < 0) {
            ret.resultado = Resultado.ERROR_2;
        } else {
            if (cityFound == null) {
                ret.resultado = Resultado.ERROR_4;
            } else {

                Crucero nuevo = new Crucero(nombre, ciudad, capacidad, estrellas);
                Crucero cruiseFound = cityFound.getCruceros().find(nuevo);

                if (cruiseFound != null) {
                    ret.resultado = Resultado.ERROR_3;
                } else {
                    cityFound.getCruceros().insert(nuevo);
                    ret.resultado = Resultado.OK;
                }
            }
        }
        return ret;
    }

    @Override
    public Retorno ingresarServicio(String ciudad, String crucero, String servicio) {
        Retorno ret = new Retorno();

        Ciudad cityTemp = new Ciudad(ciudad);
        Ciudad cityFound = ciudades.find(cityTemp);
        Crucero cruiseTemp = new Crucero(crucero);

        if (cityFound != null) {

            Crucero cruiseFound = cityFound.getCruceros().find(cruiseTemp);

            if (cruiseFound != null) {

                cruiseFound.getServicios().insert(servicio);
                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR_2;
        }

        return ret;
    }

    @Override
    public Retorno borrarServicio(String ciudad, String crucero, String servicio) {
        Retorno ret = new Retorno();

        Ciudad cityTemp = new Ciudad(ciudad);
        Ciudad cityFound = ciudades.find(cityTemp);
        Crucero cruiseTemp = new Crucero(crucero);

        if (cityFound != null) {

            Crucero cruiseFound = cityFound.getCruceros().find(cruiseTemp);

            if (cruiseFound != null) {

                if (cruiseFound.getServicios().find(servicio) != null) {
                    cruiseFound.getServicios().delete(servicio);
                    ret.resultado = Resultado.OK;
                } else {
                    ret.resultado = Resultado.ERROR_2;
                }

            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR_3;
        }

        return ret;
    }

    @Override
    public Retorno realizarReserva(int cliente, String ciudad, String crucero) {
        Retorno ret = new Retorno();

        Ciudad cityTemp = new Ciudad(ciudad);
        Ciudad cityFound = ciudades.find(cityTemp);
        Crucero cruiseTemp = new Crucero(crucero);

        if (cityFound != null) {

            Crucero cruiseFound = cityFound.getCruceros().find(cruiseTemp);

            if (cruiseFound != null) {

                int cupos = cruiseFound.getDisponibles();

                if (cupos > 0) {
                    cruiseFound.getReservas().insert(cliente);
                    cruiseFound.setDisponibles(cupos - 1);
                } else {
                    cruiseFound.getEsperas().insert(cliente);
                }

                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR_2;
        }

        return ret;
    }

    @Override
    public Retorno cancelarReserva(int cliente, String ciudad, String crucero) {
        Retorno ret = new Retorno();

        Ciudad cityTemp = new Ciudad(ciudad);
        Ciudad cityFound = ciudades.find(cityTemp);
        Crucero cruiseTemp = new Crucero(crucero);

        if (cityFound != null) {

            Crucero cruiseFound = cityFound.getCruceros().find(cruiseTemp);

            if (cruiseFound != null) {

                if (cruiseFound.getReservas().find(cliente) != null) {
                    cruiseFound.eliminarReserva(cliente);
                    ret.resultado = Resultado.OK;
                } else {
                    ret.resultado = Resultado.ERROR_2;
                }

            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR_3;
        }

        return ret;
    }

    @Override
    public Retorno ingresarComentario(String ciudad, String crucero, String comentario, int ranking) {
        Retorno ret = new Retorno();

        Ciudad cityTemp = new Ciudad(ciudad);
        Ciudad cityFound = ciudades.find(cityTemp);
        Crucero cruiseTemp = new Crucero(crucero);

        if (ranking < 0 || ranking > 5) {
            ret.resultado = Retorno.Resultado.ERROR_1;
        } else if (cityFound != null) {

            Crucero cruiseFound = cityFound.getCruceros().find(cruiseTemp);

            if (cruiseFound != null) {

                Comentario nuevo = new Comentario(comentario, ranking);
                cruiseFound.getComentarios().insert(nuevo);
                cruiseFound.actualizarRanking();
                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Retorno.Resultado.ERROR_2;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR_3;
        }

        return ret;
    }

    @Override
    public Retorno listarServicios(String ciudad, String crucero) {
        Retorno ret = new Retorno();

        Ciudad cityTemp = new Ciudad(ciudad);
        Ciudad cityFound = ciudades.find(cityTemp);
        Crucero cruiseTemp = new Crucero(crucero);

        if (cityFound != null) {

            Crucero cruiseFound = cityFound.getCruceros().find(cruiseTemp);

            if (cruiseFound != null) {

                if (cruiseFound.getServicios().isEmpty()) {
                    System.out.println("No existen servicios registrados en el Crucero " + cruiseFound.getNombre() + " " + cityFound.getNombre());
                } else {
                    System.out.println("Servicios del Crucero " + cruiseFound.getNombre() + " " + cityFound.getNombre());
                    cruiseFound.listarServicios();
                }
                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR_2;
        }

        return ret;
    }

    @Override
    public Retorno listarCrucerosCiudad(String ciudad) {
        Retorno ret = new Retorno();

        Ciudad cityTemp = new Ciudad(ciudad);
        Ciudad cityFound = ciudades.find(cityTemp);

        if (cityFound != null) {

            if (cityFound.getCruceros().isEmpty()) {
                System.out.println("No existen cruceros registrados en " + cityFound.getNombre());
            } else {
                System.out.println("Cruceros en " + cityFound.getNombre());
                cityFound.listarCruceros();
            }
            ret.resultado = Resultado.OK;

        } else {
            ret.resultado = Retorno.Resultado.ERROR_1;
        }
        return ret;
    }

    @Override
    public Retorno listarCrucerosRankingAsc(String ciudad) {
        Retorno ret = new Retorno();

        Ciudad cityTemp = new Ciudad(ciudad);
        Ciudad cityFound = ciudades.find(cityTemp);

        if (cityFound != null) {

            if (cityFound.getCruceros().isEmpty()) {
                System.out.println("No hay registros de Cruceros en el sistema.");
            } else {
                System.out.println("Cruceros ordenados por ranking ascendente");
                cityFound.listarCrucerosRankingAsc(cityFound.getCruceros().getInicio());
            }
            ret.resultado = Resultado.OK;

        } else {
            ret.resultado = Retorno.Resultado.ERROR_1;
        }
        return ret;
    }

    @Override
    public Retorno listarCrucerosRankingDesc(String ciudad) {
        Retorno ret = new Retorno();

        Ciudad cityTemp = new Ciudad(ciudad);
        Ciudad cityFound = ciudades.find(cityTemp);

        if (cityFound != null) {

            if (cityFound.getCruceros().isEmpty()) {
                System.out.println("No hay registros de Cruceros en el sistema.");
            } else {
                System.out.println("Cruceros ordenados por ranking descendente");
                cityFound.listarCrucerosRankingDesc(cityFound.getCruceros().getInicio());
            }
            ret.resultado = Resultado.OK;

        } else {
            ret.resultado = Retorno.Resultado.ERROR_1;
        }
        return ret;
    }

    @Override
    public Retorno listarCrucerosRanking() {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno listarComentarios(String ciudad, String crucero) {
        Retorno ret = new Retorno();

        Ciudad cityTemp = new Ciudad(ciudad);
        Ciudad cityFound = ciudades.find(cityTemp);
        Crucero cruiseTemp = new Crucero(crucero);

        if (cityFound != null) {

            Crucero cruiseFound = cityFound.getCruceros().find(cruiseTemp);

            if (cruiseFound != null) {

                if (cruiseFound.getComentarios().isEmpty()) {
                    System.out.println("No se han agregado comentarios al Crucero " + cruiseFound.getNombre() + " " + cityFound.getNombre());
                } else {
                    cruiseFound.listarComentarios();
                }
                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }

        } else {
            ret.resultado = Retorno.Resultado.ERROR_2;
        }

        return ret;
    }

    @Override
    public Retorno cargarDistancias(int[][] ciudades) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

    @Override
    public Retorno buscarCamino(int[][] m, String origen, String destino) {
        Retorno ret = new Retorno();

        ret.resultado = Resultado.NO_IMPLEMENTADA;

        return ret;
    }

}
