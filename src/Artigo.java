package src;

import java.io.Serializable;
import java.util.*;

public abstract class Artigo implements Serializable {
    private static int numeroArtigos = 0;
    public static void incTotalArtigos(){numeroArtigos++;}
    public static int numeroArtigosF(){return numeroArtigos;}
    private boolean novo;
    private int numDonos;
    private int avaliacao;
    private String descricao;
    private final String codigo;
    private double precoBase;
    private double correcaoPreco;
    private int numeroUtilizador;

    //Construtores

    /**----------------------------------------------
              Construtor para um novo src.Artigo
     ----------------------------------------------**/
    public Artigo(){
        novo = false;
        numDonos = 0;
        avaliacao = 0;
        descricao = "";
        incTotalArtigos();
        codigo = "A" + numeroArtigosF();
        precoBase = 0;
        correcaoPreco = 0;
        numeroUtilizador = 0;
    }

    /**----------------------------------------------
              Construtor para um novo src.Artigo
     ----------------------------------------------**/
    public Artigo(boolean novo,int numDonos ,int avaliacao, String descricao, double precoBase ,double correcaoPreco,int numeroUtilizador){
        this.avaliacao = avaliacao;
        incTotalArtigos();
        this.codigo ="A" + numeroArtigosF();
        this.novo = novo;
        this.numDonos = numDonos;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.correcaoPreco = correcaoPreco;
        this.numeroUtilizador = numeroUtilizador;
    }

    /**----------------------------------------------
              Construtor para um novo src.Artigo
     ----------------------------------------------**/

    public Artigo (Artigo artigo){
        this.novo = artigo.isNovo();
        this.numDonos = artigo.getNumDonos();
        this.avaliacao = artigo.getAvaliacao();
        this.descricao = artigo.getDescricao();
        this.codigo = artigo.getCodigo();
        this.precoBase = artigo.getCorrecaoPreco();
        this.correcaoPreco = artigo.getCorrecaoPreco();
        this.numeroUtilizador = artigo.getNumeroUtilizador();
    }


    /**----------------------------------------------
                           Getters
     ----------------------------------------------**/
    public boolean isNovo() {
        return novo;
    }
    public int getNumDonos() {
        return numDonos;
    }
    public int getNumeroUtilizador() {
        return numeroUtilizador;
    }
    public int getAvaliacao() {
        return avaliacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public double getCorrecaoPreco() {
        return correcaoPreco;
    }

    /**----------------------------------------------
                        Setters
     ----------------------------------------------**/
    public void setNovo(boolean novo) {
        this.novo = novo;
    }
    public void setNumDonos(int numDonos) {
        this.numDonos = numDonos;
    }
    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }
    public void setCorrecaoPreco(double correcaoPreco) {
        this.correcaoPreco = correcaoPreco;
    }
    public void setNumeroUtilizador(int numeroUtilizador) {
        this.numeroUtilizador = numeroUtilizador;
    }

    //Equals
    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if ((o == null) || (this.getClass() != o.getClass())) return false;

        Artigo umArtigo = (Artigo) o;
        return (this.codigo.equals(umArtigo.codigo) && this.numDonos == umArtigo.numDonos);
    }

    @Override
    public abstract Artigo clone();

    //toString
    @Override
    public String toString() {
        return "Estado do src.Artigo:" +
                "\n    Estado -> " + (novo ? "novo" : "usado") +
                "\n    Numero de Donos -> " + numDonos +
                "\n    Avaliacao -> " + avaliacao + "%" +
                "\n    Descricao -> " + descricao +
                "\n    precoBase -> " + precoBase + "simbEur" +
                "\n    correcaoPreco -> " + correcaoPreco +
                '\n';
    }
    //funcao auxiliar para o toString
    private String auxNovo(boolean novo) {
        if (novo) return "Novo"; else return "Usado";
    }

    //Hash
    @Override
    public int hashCode(){
        return Objects.hash(codigo);
    }

}