package model;

import java.io.Serializable;
import java.util.*;

public abstract class Artigo implements Serializable {
    private static int numeroArtigos = 0;
    public static void incTotalArtigos(){numeroArtigos++;}
    public static int numeroArtigosF(){return numeroArtigos;}
    public static void setNumeroArtigos(int num){numeroArtigos = num;}
    public static int getNumeroArtigos(){return numeroArtigos;}
    private boolean novo;
    private int numDonos;
    private int avaliacao;
    private String descricao;
    private final String codigo;
    private double precoBase;
    private String emailUtilizador;
    private Transportadora transportadora;

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
        emailUtilizador = "";
    }

    /**----------------------------------------------
              Construtor para um novo src.Artigo
     ----------------------------------------------**/
    public Artigo(boolean novo,int numDonos ,int avaliacao, String descricao, double precoBase ,String emailUtilizador){
        this.avaliacao = avaliacao;
        incTotalArtigos();
        this.codigo ="A" + numeroArtigosF();
        this.novo = novo;
        this.numDonos = numDonos;
        this.descricao = descricao;
        this.precoBase = precoBase;
        this.emailUtilizador = emailUtilizador;
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
        this.precoBase = artigo.getPrecoBase();
        this.emailUtilizador = artigo.getEmailUtilizador();
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
    public String getEmailUtilizador() {
        return emailUtilizador;
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

    public Transportadora getTransportadora(){
        return transportadora;
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
    public void setEmailUtilizador(String emailUtilizador) {
        this.emailUtilizador = emailUtilizador;
    }
    public void setTransportadora(Transportadora transportadora){
        this.transportadora = transportadora;
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

    public abstract double calculaPrecoFinal();

    //toString
    @Override
    public String toString(){
        return  "\nEstado do Artigo:" +
                "\n    Codigo -> " + codigo +
                "\n    Estado -> " + (novo ? "novo" : "usado") +
                "\n    Numero de Donos -> " + numDonos +
                "\n    Avaliacao -> " + avaliacao + "%" +
                "\n    Descricao -> " + descricao +
                "\n    precoBase -> " + precoBase + " € " +
                "\n    Email do Dono -> " + emailUtilizador +
                "\n    Tranpostador Associada -> " + transportadora +
                '\n';
    }

    @Override
    public int hashCode(){
        return Objects.hash(codigo);
    }

}
