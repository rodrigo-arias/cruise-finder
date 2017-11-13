package Dominio;

public class Comentario {

    private String comentario;
    private int ranking;

    //==================  Construct  ==================//
    public Comentario(String comentario, int ranking) {
        this.comentario = comentario;
        this.ranking = ranking;
    }

    //==================  Properties  =================//
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    //===================  Métodos  ===================//
    @Override
    public String toString() {
        return this.comentario + " - " + this.ranking;
    }
}
