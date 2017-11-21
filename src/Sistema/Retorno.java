package Sistema;

public class Retorno {

    public enum Resultado {
        OK, ERROR_1, ERROR_2, ERROR_3, ERROR_4, ERROR_5, NO_IMPLEMENTADA
    };

    public int valorEntero;
    public String valorString;
    public Resultado resultado;
}
