package model;

import java.time.LocalDate;

public class MalaPremium extends Mala implements Premium {
    public double calculaPrecoFinal(){
        double precoBase = getPrecoBase();
        int anoAual = LocalDate.now().getYear();
        int anoMala = this.getAno_colecao().getYear();
        int tamanho = this.getDim();
        double precoFinal = precoBase + precoBase*0.1*(anoAual-anoMala);
        return precoFinal;

    }
}
