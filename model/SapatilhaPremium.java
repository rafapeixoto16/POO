package model;

import java.time.LocalDate;

public class SapatilhaPremium extends Sapatilha implements Premium {
    public SapatilhaPremium(){super();}

    public SapatilhaPremium(SapatilhaPremium sapatilhaPremium){
        super(sapatilhaPremium);
    }


    @Override
    public double calculaPrecoFinal(){
        //aumenta 10% do valor a cada ano que passa
        double precoBase = getPrecoBase();
        int anoAtual = Vintage.dataAtual().getYear();
        int anoSapatilha = this.getData().getYear();
        return precoBase + precoBase*0.1*(anoAtual-anoSapatilha);
    }

    @Override
    public SapatilhaPremium clone(){
       return new SapatilhaPremium(this);
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;

        if(o == null || this.getClass() != o.getClass())
            return false;

        SapatilhaPremium t = (SapatilhaPremium) o;
        return super.equals(t);
    }
}
