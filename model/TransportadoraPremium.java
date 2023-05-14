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
    }//todo

    @Override
    public TransportadoraPremium clone(){
        return new TransportadoraPremium(this);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;

        if(o == null || this.getClass() != o.getClass())
            return false;

        TransportadoraPremium t = (TransportadoraPremium) o;
        return super.equals(t);
     }
}
