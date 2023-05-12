package model;

import java.io.Serializable;

public class Transportadora implements Serializable {
    private static int numeroTransportadoras = 0;
    public static void incTotalTransp() {numeroTransportadoras++;}
    public static int numeroTransp() {return numeroTransportadoras;}
    public static void setNumeroTransportadoras(int i){numeroTransportadoras = i;}
    private final int codTransportadora;
    private double imposto;
    private int diasEntrega;
    public Transportadora(){
        incTotalTransp();
        codTransportadora = numeroTransp();
        imposto = 0;
    }

    public Transportadora (int imposto){
        incTotalTransp();
        codTransportadora = numeroTransp();
        this.imposto = imposto;
    }

    public Transportadora(Transportadora transportadora){
        this.codTransportadora = transportadora.codTransportadora;
        this.imposto = transportadora.imposto;
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

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    public void setDiasEntrega(int diasEntrega){
        this.diasEntrega = diasEntrega;
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
                " Duraçao entrega :"+ getDiasEntrega()+"\n";
    }

    @Override
    public Transportadora clone(){
        return new Transportadora(this);
    }
}
