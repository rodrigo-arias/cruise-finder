package Sistema;

import Datos.ListaCiudad;
import Datos.ListaIndice;
import Dominio.Ciudad;
import Dominio.Comentario;
import Dominio.Crucero;
import Sistema.Retorno.Resultado;

public class Sistema implements ISistema {

    //Inicialización de variables de sistema
    protected ListaCiudad<Ciudad> ciudades;
    protected ListaIndice<Crucero> indices;
    protected int dimension;
    protected int matriz[][];

    Utilidad utils = new Utilidad();

    //Pre:
    //Post: determina limite de ciudades del sistema | inicializa listas del sistema
    @Override
    public Retorno crearSistemaReservas(int cantCiudades) {

        Retorno ret = new Retorno();

        ciudades = new ListaCiudad<>();
        indices = new ListaIndice<>();

        if (cantCiudades >= 0) {
            ciudades.setCantMaxima(cantCiudades);
            dimension = cantCiudades;
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
        dimension = 0;
        matriz = null;
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
                ret.resultado = Resultado.OK;
            } else {
                ret.resultado = Resultado.ERROR_1;
            }
        } else {
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
                ret.resultado = Resultado.ERROR_4;
            } else {

                Crucero nuevo = new Crucero(nombre, ciudad, capacidad, estrellas);
                Crucero cruisefound = cityfound.getCruceros().find(nuevo);

                if (cruisefound != null) {
                    ret.resultado = Resultado.ERROR_3;
                } else {
                    cityfound.getCruceros().insert(nuevo);
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
                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }

        } else {
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
                    cruisefound.getEsperas().insert(cliente);
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

                if (cruisefound.getReservas().find(cliente) != null) {
                    cruisefound.eliminarReserva(cliente);
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

                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Retorno.Resultado.ERROR_2;
            }
        } else {
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
                ret.resultado = Resultado.OK;

            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }

        } else {
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
            System.out.println();
        }
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

            } else {
                ret.resultado = Retorno.Resultado.ERROR_1;
            }
        } else {
            ret.resultado = Retorno.Resultado.ERROR_2;
        }
        return ret;
    }

    //Pre: sistema creado | el orden de la matriz debe coincidir con el de las ciudades del sistema
    //Post: carga la matriz del sistema con las distancias de las ciudades
    @Override
    public Retorno cargarDistancias(int[][] ciudades) {

        Retorno ret = new Retorno();
        matriz = new int[dimension][dimension];

        if (ciudades[0].length == dimension && ciudades.length == dimension) {

            matriz = ciudades;

            ret.resultado = Resultado.OK;
        } else {
            ret.resultado = Resultado.ERROR_1;
        }

        return ret;
    }

    //Pre: sistema creado | lista de ciudades != null | matriz con distancias cargadas
    //Post:
    @Override
    public Retorno buscarCamino(String origen, String destino) {

        Retorno ret = new Retorno();

        int o = ciudades.findIndex(origen);
        int d = ciudades.findIndex(destino);

        if (o == -1) {
            ret.resultado = Resultado.ERROR_1;
            System.out.println("La ciudad origen no existe en el sistema");

        } else if (d == -1) {
            ret.resultado = Resultado.ERROR_2;
            System.out.println("La ciudad destino no existe en el sistema");
        } else if (o == d) {
            ret.resultado = Resultado.ERROR_3;
            System.out.println("Ingrese una ciudad origen y destino distintas");
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
                System.out.println("El camino es directo " + ciudades.findByIndex(o) + " a " + ciudades.findByIndex(d) + " distancia " + matriz[o][d]);
            } else {
                System.out.println("El camino mas corto es " + ciudades.findByIndex(o) + " - " + ciudades.findByIndex(escala) + " - " + ciudades.findByIndex(d));
            }
            ret.resultado = Resultado.OK;
        }
        return ret;
    }
}
