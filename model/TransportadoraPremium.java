package model;

public class TransportadoraPremium extends Transportadora implements Premium {
    public TransportadoraPremium(){
        super();
    }

    public TransportadoraPremium(TransportadoraPremium transportadoraPremium){
        super(transportadoraPremium);
    }

    @Override
    public double calculaPrecoFinal() {
        return 0;
    }

    @Override
    public TransportadoraPremium clone(){
        return new TransportadoraPremium(this);
    }

}
