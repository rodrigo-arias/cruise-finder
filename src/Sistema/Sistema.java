package Sistema;

import Datos.ListaCiudad;
import Datos.ListaIndice;
import Dominio.Ciudad;
import Dominio.Comentario;
import Dominio.Crucero;
import Sistema.Retorno.Resultado;

public class Sistema implements ISistema {

    //Inicialización de variables de sistema
    public ListaCiudad<Ciudad> ciudades;
    public ListaIndice<Crucero> indices;
    private int limite;
    Utilidad utils = new Utilidad();

    //Pre:
    //Post: determina limite de ciudades del sistema | inicializa listas del sistema
    @Override
    public Retorno crearSistemaReservas(int cantCiudades) {

        Retorno ret = new Retorno();

        if (cantCiudades >= 0) {
            ciudades = new ListaCiudad<>();
            indices = new ListaIndice<>();

            ciudades.setCantMaxima(cantCiudades);
            limite = cantCiudades;
            ret.resultado = Resultado.OK;
        } else {
            ret.resultado = Resultado.ERROR_1;
        }
        return ret;
    }

    //Pre:
    //Post: reinicia las variables del sistema
    @Override
    public Retorno destruirSistemaReservas() {

        Retorno ret = new Retorno();

        ciudades = new ListaCiudad<>();
        indices = new ListaIndice<>();
        limite = 0;
        System.gc();

        ret.resultado = Resultado.OK;

        return ret;
    }

    //Pre: sistema creado | ciudad != ""
    //Post: agrega la ciudad al inicio de la lista de ciudades
    @Override
    public Retorno registrarCiudad(String ciudad) {

        Retorno ret = new Retorno();

        if (ciudades.getCantElementos() < ciudades.getCantMaxima() || ciudades.getCantMaxima() == 0) {

            Ciudad nueva = new Ciudad(ciudad);

            if (ciudades.find(nueva) == null) {

                ciudades.insert(nueva);
                ret.valorString = nueva.toString();
                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Resultado.ERROR_1;
            }
        } else {
            /* se agregó ERROR 2: sobrepasa el límite de ciudades soportadas por el sistema */
            ret.resultado = Resultado.ERROR_2;
        }
        return ret;
    }

    //Pre: sistema creado | ciudad != "" | nombre != ""
    //Post: agrega el crucero al inicio de la lista de cruceros de la ciudad con raking 0
    @Override
    public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad) {

        Retorno ret = new Retorno();

        Ciudad citytemp = new Ciudad(ciudad);
        Ciudad cityfound = ciudades.find(citytemp);

        if (estrellas < 1 || estrellas > 5) {
            ret.resultado = Retorno.Resultado.ERROR_1;
        } else if (capacidad < 0) {
            ret.resultado = Resultado.ERROR_2;
        } else {
            if (cityfound == null) {
                /* se controla primero el ERROR 4 (existencia de la ciudad), luego el ERROR 3 (existencia del crucero) */
                ret.resultado = Resultado.ERROR_4;
            } else {

                Crucero nuevo = new Crucero(nombre, ciudad, capacidad, estrellas);
                Crucero cruisefound = cityfound.getCruceros().find(nuevo);

                if (cruisefound != null) {
                    ret.resultado = Resultado.ERROR_3;
                } else {
                    cityfound.getCruceros().insert(nuevo);
                    ret.valorString = nuevo.toString();
                    ret.resultado = Resultado.OK;

                    utils.insertarIndiceRanking(indices, nuevo);
                }
            }
        }
        return ret;
    }

    //Pre: sistema creado | ciudad =! "" | nombre != "" | servicio != ""
    //Post: agrega el servicio al inicio de la lista de servicios del crucero para la ciudad
    @Override
    public Retorno ingresarServicio(String ciudad, String crucero, String servicio) {

        Retorno ret = new Retorno();

        Ciudad citytemp = new Ciudad(ciudad);
        Ciudad cityfound = ciudades.find(citytemp);
        Crucero cruisetemp = new Crucero(crucero, ciudad);

        if (cityfound != null) {

            Crucero cruisefound = cityfound.getCruceros().find(cruisetemp);

            if (cruisefound != null) {

                cruisefound.getServicios().insert(servicio);
                ret.valorString = servicio;
                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }

        } else {
            /* se controla primero el ERROR 2 (existencia de la ciudad), luego el ERROR 1 (existencia del crucero) */
            ret.resultado = Retorno.Resultado.ERROR_2;
        }
        return ret;
    }

    //Pre: sistema creado
    //Post: borra el servicio de la lista de servicios del crucero para la ciudad
    @Override
    public Retorno borrarServicio(String ciudad, String crucero, String servicio) {

        Retorno ret = new Retorno();

        Ciudad citytemp = new Ciudad(ciudad);
        Ciudad cityfound = ciudades.find(citytemp);
        Crucero cruisetemp = new Crucero(crucero, ciudad);

        if (cityfound != null) {

            Crucero cruisefound = cityfound.getCruceros().find(cruisetemp);

            if (cruisefound != null) {

                if (cruisefound.getServicios().find(servicio) != null) {
                    cruisefound.getServicios().delete(servicio);
                    ret.valorString = servicio;
                    ret.resultado = Resultado.OK;
                } else {
                    ret.resultado = Resultado.ERROR_2;
                }

            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }

        } else {
            /* se controla primero el ERROR 3 (existencia de la ciudad), luego el ERROR 1 (existencia del crucero) */
            ret.resultado = Retorno.Resultado.ERROR_3;
        }
        return ret;
    }

    //Pre: sistema creado | ciudad =! "" | crucero =! ""
    //Post: agrega el cliente a la lista de reservas o cola de espera del crucero para la ciudad
    @Override
    public Retorno realizarReserva(int cliente, String ciudad, String crucero) {

        Retorno ret = new Retorno();

        Ciudad citytemp = new Ciudad(ciudad);
        Ciudad cityfound = ciudades.find(citytemp);
        Crucero cruisetemp = new Crucero(crucero, ciudad);

        if (cityfound != null) {

            Crucero cruisefound = cityfound.getCruceros().find(cruisetemp);

            if (cruisefound != null) {

                int cupos = cruisefound.getDisponibles();

                if (cupos > 0) {
                    cruisefound.getReservas().insert(cliente);
                    cruisefound.setDisponibles(cupos - 1);
                } else {
                    cruisefound.getEsperas().enqueue(cliente);
                }
                ret.valorEntero = cliente;
                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }

        } else {
            /* se controla primero el ERROR 2 (existencia de la ciudad), luego el ERROR 1 (existencia del crucero) */
            ret.resultado = Retorno.Resultado.ERROR_2;
        }

        return ret;
    }

    //Pre: sistema creado
    //Post: borra el cliente de la lista de reservas y agrega si hay, al primer cliente en cola de espera
    @Override
    public Retorno cancelarReserva(int cliente, String ciudad, String crucero) {

        Retorno ret = new Retorno();

        Ciudad citytemp = new Ciudad(ciudad);
        Ciudad cityfound = ciudades.find(citytemp);
        Crucero cruisetemp = new Crucero(crucero, ciudad);

        if (cityfound != null) {

            Crucero cruisefound = cityfound.getCruceros().find(cruisetemp);

            if (cruisefound != null) {

                if (!cruisefound.getReservas().isEmpty() && cruisefound.getReservas().find(cliente) != null) {

                    cruisefound.eliminarReserva(cliente);
                    ret.valorEntero = cliente;
                    ret.resultado = Resultado.OK;

                } else {
                    ret.resultado = Resultado.ERROR_2;
                }
            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }
        } else {
            /* se controla primero el ERROR 3 (existencia de la ciudad), luego el ERROR 1 (existencia del crucero) */
            ret.resultado = Retorno.Resultado.ERROR_3;
        }
        return ret;
    }

    //Pre: sistema creado | ciudad =! "" | crucero =! "" | comentario != ""
    //Post: agrega un comentario en el crucero para la ciudad y reordena el índice por ranking
    @Override
    public Retorno ingresarComentario(String ciudad, String crucero, String comentario, int ranking) {

        Retorno ret = new Retorno();

        Ciudad citytemp = new Ciudad(ciudad);
        Ciudad cityfound = ciudades.find(citytemp);
        Crucero cruisetemp = new Crucero(crucero, ciudad);

        if (ranking < 0 || ranking > 5) {
            ret.resultado = Retorno.Resultado.ERROR_1;
        } else if (cityfound != null) {

            Crucero cruisefound = cityfound.getCruceros().find(cruisetemp);

            if (cruisefound != null) {

                Comentario nuevo = new Comentario(comentario, ranking);
                cruisefound.getComentarios().insert(nuevo);
                cruisefound.actualizarRanking();

                utils.actualizarIndiceRanking(indices, cruisefound);
                ret.valorString = nuevo.toString();
                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Retorno.Resultado.ERROR_2;
            }
        } else {
            /* se controla primero el ERROR 3 (existencia de la ciudad), luego el ERROR 2 (existencia del crucero) */
            ret.resultado = Retorno.Resultado.ERROR_3;
        }
        return ret;
    }

    //Pre: sistema creado
    //Post: lista los servicios del crucero para la ciudad, numerados del mas reciente al mas antiguo
    @Override
    public Retorno listarServicios(String ciudad, String crucero) {

        Retorno ret = new Retorno();

        Ciudad citytemp = new Ciudad(ciudad);
        Ciudad cityfound = ciudades.find(citytemp);
        Crucero cruisetemp = new Crucero(crucero, ciudad);

        if (cityfound != null) {

            Crucero cruisefound = cityfound.getCruceros().find(cruisetemp);

            if (cruisefound != null) {

                if (cruisefound.getServicios().isEmpty()) {
                    System.out.println("No existen servicios registrados en el Crucero " + cruisefound.getNombre() + " " + cityfound.getNombre());
                } else {
                    System.out.println("Servicios del Crucero " + cruisefound.getNombre() + " " + cityfound.getNombre());
                    cruisefound.listarServicios();
                }
                ret.valorString = cruisefound.getServicios().toString();
                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }

        } else {
            /* se controla primero el ERROR 2 (existencia de la ciudad), luego el ERROR 1 (existencia del crucero) */
            ret.resultado = Retorno.Resultado.ERROR_2;
        }
        return ret;
    }

    //Pre: sistema creado
    //Post: lista los curceros de la ciudad por orden alfábetico con nombre, estrellas y ranking
    @Override
    public Retorno listarCrucerosCiudad(String ciudad) {

        Retorno ret = new Retorno();

        Ciudad citytemp = new Ciudad(ciudad);
        Ciudad cityfound = ciudades.find(citytemp);

        if (cityfound != null) {

            if (cityfound.getCruceros().isEmpty()) {
                System.out.println("No existen cruceros registrados en " + cityfound.getNombre());
            } else {
                System.out.println("Cruceros en " + cityfound.getNombre());
                cityfound.listarCruceros();
            }
            ret.valorString = cityfound.getCruceros().toString();
            ret.resultado = Resultado.OK;
        } else {
            ret.resultado = Retorno.Resultado.ERROR_1;
        }
        return ret;
    }

    //Pre: sistema creado
    //Post: lista los cruceros de la ciudad por orden de ranking ascendente con nombre y ranking
    @Override
    public Retorno listarCrucerosRankingAsc(String ciudad) {

        Retorno ret = new Retorno();

        Ciudad citytemp = new Ciudad(ciudad);
        Ciudad cityfound = ciudades.find(citytemp);

        if (cityfound != null) {

            if (cityfound.getCruceros().isEmpty()) {
                System.out.println("No hay registros de Cruceros en el sistema.");
            } else {
                System.out.println("Cruceros ordenados por ranking ascendente");
                System.out.println(ciudad);
                utils.listarIndiceRankingAsc(indices.getInicio(), ciudad);
            }
            ret.valorString = indices.toStringAsc(ciudad);
            ret.resultado = Resultado.OK;

        } else {
            ret.resultado = Retorno.Resultado.ERROR_1;
        }
        return ret;
    }

    //Pre: sistema creado
    //Post: lista los cruceros de la ciudad por orden de ranking descendente con nombre y ranking
    @Override
    public Retorno listarCrucerosRankingDesc(String ciudad) {

        Retorno ret = new Retorno();

        Ciudad citytemp = new Ciudad(ciudad);
        Ciudad cityfound = ciudades.find(citytemp);

        if (cityfound != null) {

            if (cityfound.getCruceros().isEmpty()) {
                System.out.println("No hay registros de Cruceros en el sistema.");
            } else {
                System.out.println("Cruceros ordenados por ranking descendente");
                System.out.println(ciudad);

                utils.listarIndiceRankingDesc(indices.getInicio(), ciudad);
            }
            ret.valorString = indices.toStringDesc(indices.getInicio(), ciudad);
            ret.resultado = Resultado.OK;
        } else {
            ret.resultado = Retorno.Resultado.ERROR_1;
        }
        return ret;
    }

    //Pre: sistema creado
    //Post: lista los cruceros del sistema por orden de ranking descendente con ciudad, nombre y ranking
    @Override
    public Retorno listarCrucerosRanking() {
        Retorno ret = new Retorno();

        if (indices.isEmpty()) {
            System.out.println("No hay registros de Cruceros en el sistema.");
        } else {
            System.out.println("Cruceros ordenados por ranking");

            utils.listarIndiceRanking(indices.getInicio());
        }
        ret.valorString = indices.toString(indices.getInicio());
        ret.resultado = Resultado.OK;

        return ret;
    }

    //Pre: sistema creado
    //Post: lista los comentarios del crucero para la ciudad, numerados del mas reciente al mas antiguo
    @Override
    public Retorno listarComentarios(String ciudad, String crucero) {

        Retorno ret = new Retorno();

        Ciudad citytemp = new Ciudad(ciudad);
        Ciudad cityfound = ciudades.find(citytemp);
        Crucero cruisetemp = new Crucero(crucero, ciudad);

        if (cityfound != null) {

            Crucero cruisefound = cityfound.getCruceros().find(cruisetemp);

            if (cruisefound != null) {

                if (cruisefound.getComentarios().isEmpty()) {
                    System.out.println("No se han agregado comentarios al Crucero " + cruisefound.getNombre() + " " + cityfound.getNombre());
                } else {
                    System.out.println("Servicios del Crucero " + cruisefound.getNombre() + " " + cityfound.getNombre());
                    cruisefound.listarComentarios();
                }
                ret.resultado = Resultado.OK;
                ret.valorString = cruisefound.getComentarios().toString();
            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }
        } else {
            /* se controla primero el ERROR 2 (existencia de la ciudad), luego el ERROR 1 (existencia del crucero) */
            ret.resultado = Retorno.Resultado.ERROR_2;
        }
        return ret;
    }

    //Pre: sistema creado | el orden de la matriz debe coincidir con el de registro de ciudades
    //Post: carga la matriz con las distancias de las ciudades
    @Override
    public Retorno cargarDistancias(int[][] ciudades) {

        Retorno ret = new Retorno();

        if (limite == 0 || limite > 0 && (ciudades[0].length <= limite && ciudades.length <= limite)) {
            int[][] matriz = new int[ciudades[0].length][ciudades.length];
            ret.resultado = Resultado.OK;
        } else {
            /* se agregó ERROR 2: la matriz ciudades sobrepasa el límite de ciudades soportadas por el sistema */
            ret.resultado = Resultado.ERROR_1;
        }
        return ret;
    }

    //Pre: sistema creado | lista de ciudades != null | matriz con distancias cargadas
    //Post: retorna el camino mas corto entre el origen y el destino limitado a una escala
    @Override
    public Retorno buscarCamino(int[][] matriz, String origen, String destino) {

        Retorno ret = new Retorno();

        int o = ciudades.findIndex(origen);
        int d = ciudades.findIndex(destino);

        if (o == -1) {
            /* se agregó ERROR 1: la ciudad origen no está registrada en el sistema */
            ret.resultado = Resultado.ERROR_1;
            ret.valorString = "La ciudad origen no existe en el sistema";

        } else if (d == -1) {
            /* se agregó ERROR 2: la ciudad destino no está registrada en el sistema */
            ret.resultado = Resultado.ERROR_2;
            ret.valorString = "La ciudad destino no existe en el sistema";
        } else if (o == d) {
            /* se agregó ERROR 3: se intenta búscar la misma ciudad origen y destino */
            ret.resultado = Resultado.ERROR_3;
            ret.valorString = "Ingrese una ciudad origen y destino distintas";
        } else {

            int columnas = matriz[0].length;
            int escala = 0;
            int distancia = Integer.MAX_VALUE;
            int aux;

            for (int i = 0; i < columnas; i++) {
                aux = matriz[o][i] + matriz[d][i];
                if (matriz[o][i] != 0 && matriz[d][i] != 0 && aux < distancia) {
                    distancia = aux;
                    escala = i;
                }
            }

            if (matriz[o][d] != 0 && distancia > matriz[o][d]) {
                ret.valorString = "El camino es directo " + ciudades.findByIndex(o) + " a " + ciudades.findByIndex(d) + " distancia " + matriz[o][d];
            } else {
                ret.valorString = "El camino mas corto es " + ciudades.findByIndex(o) + " - " + ciudades.findByIndex(escala) + " - " + ciudades.findByIndex(d);
            }
            ret.resultado = Resultado.OK;
        }
        return ret;
    }
}
