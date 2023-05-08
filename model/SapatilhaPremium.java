package model;

import java.time.LocalDate;

public class SapatilhaPremium extends Sapatilha implements Premium {
    public double calculaPrecoFinal(){
        //aumenta 10% do valor a cada ano que passa
        double precoBase = getPrecoBase();
        int anoAual = LocalDate.now().getYear();
        int anoSapatilha = this.getData().getYear();
        double precoFinal = precoBase + precoBase*0.1*(anoAual-anoSapatilha);
        return precoFinal;
    }
}
