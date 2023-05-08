package model;

public class TransportadoraPremium extends Transportadora implements Premium {
    @Override
    public double calculaPrecoFinal() {
        return 0;
    }
}
