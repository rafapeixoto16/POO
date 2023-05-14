package model;

import java.awt.*;
import java.io.Serializable;
import java.util.List;

public class Transportadora implements Serializable {
    private static int numeroTransportadoras = 0;
    public static void incTotalTransp() {numeroTransportadoras++;}
    public static int numeroTransp() {return numeroTransportadoras;}
    public static void setNumeroTransportadoras(int i){numeroTransportadoras = i;}
    private final int codTransportadora;
    private double imposto;
    private int diasEntrega;
    private int margemLucro;
    private int opcaoFormula;
    public static final int PEQUENO = 1;
    public static final int MEDIO = 2;
    public static final int GRANDE = 3;
    public Transportadora(){
        incTotalTransp();
        codTransportadora = numeroTransp();
        imposto = 0;
        margemLucro = 0;
        opcaoFormula = 0;
    }

    public Transportadora (int imposto, int margemLucro,int opcaoFormula){
        incTotalTransp();
        codTransportadora = numeroTransp();
        this.imposto = imposto;
        this.margemLucro = margemLucro;
        this.opcaoFormula = opcaoFormula;
    }

    public Transportadora(Transportadora transportadora){
        this.codTransportadora = transportadora.codTransportadora;
        this.imposto = transportadora.imposto;
        this.margemLucro = transportadora.margemLucro;
        this.opcaoFormula = transportadora.opcaoFormula;
        this.diasEntrega = transportadora.diasEntrega;
    }
    public double getImposto() {
        return imposto;
    }

    public int getDiasEntrega() {
        return diasEntrega;
    }

    public int getCodTransportadora() {
        return codTransportadora;
    }

    public int getMargemLucro() {
        return margemLucro;
    }

    public int getOpcaoFormula() {
        return opcaoFormula;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public void setDiasEntrega(int diasEntrega){
        this.diasEntrega = diasEntrega;
    }

    public void setMargemLucro(int margemLucro) {
        this.margemLucro = margemLucro;
    }

    public void setOpcaoFormula(int opcaoFormula) {
        this.opcaoFormula = opcaoFormula;
    }

    @Override
    public boolean equals(Object o){
        if(o == null)
            return false;

        else if(o.getClass() != this.getClass())
            return false;

        Transportadora transportadora = (Transportadora) o;

        return this.getCodTransportadora() == transportadora.getCodTransportadora();
    }

    @Override
    public String toString(){
        return "Transportadora: \n" +
                " Codigo  : " + getCodTransportadora()+"\n" +
                " Imposto : " + getImposto() + "\n"+
                " Margem de Lucro : " + getMargemLucro() + "\n"+
                " Duraçao entrega :"+ getDiasEntrega()+"\n"+
                " Formula para Custo de Expedição :"+ getOpcaoFormula()+"\n";
    }

    @Override
    public Transportadora clone(){
        return new Transportadora(this);
    }

    public double calculaPrecoFinal (List<Artigo> artigos) {
        double precoExpedicao = 0;
        int nArtigo = artigos.size();
        int valorBase;
        if (nArtigo == 1) valorBase = PEQUENO;
        else if (nArtigo >= 2 && nArtigo <= 5) valorBase = MEDIO;
        else valorBase = GRANDE;
        switch (getOpcaoFormula()) {
            case 1:
                precoExpedicao = (valorBase * getMargemLucro() * (1+getImposto())) * 0.9;
                break;
            case 2:
                precoExpedicao = (valorBase + getMargemLucro() * (1+getImposto()));
                break;
            case 3:
                precoExpedicao = (valorBase * getMargemLucro() + (1+getImposto())) * 0.85;
                break;
        }
        return precoExpedicao;
    }
}
