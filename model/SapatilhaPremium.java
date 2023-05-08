package model;

import java.time.LocalDate;

public class SapatilhaPremium extends Sapatilha implements Premium {
    @Override
    public double calculaPrecoFinal(){
        //aumenta 10% do valor a cada ano que passa
        double precoBase = getPrecoBase();
        int anoAtual = Vintage.dataAtual().getYear();
        int anoSapatilha = this.getData().getYear();
        double precoFinal = precoBase + precoBase*0.1*(anoAtual-anoSapatilha);
        return precoFinal;
    }
}
