package src;

import java.io.Serializable;

public class Transportadora implements Serializable {
    private static int numeroTransportadoras = 0;
    public static void incTotalTransp() {numeroTransportadoras++;}
    public static int numeroTransp() {return numeroTransportadoras;}
    private final int codTransportadora;
    private int imposto;

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
    public int getImposto() {
        return imposto;
    }

    public int getCodTransportadora() {
        return codTransportadora;
    }

    public void setImposto(int imposto) {
        this.imposto = imposto;
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
    public Transportadora clone(){
        return new Transportadora(this);
    }
}
