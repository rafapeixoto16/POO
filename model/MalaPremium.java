package model;

import java.time.LocalDate;

public class MalaPremium extends Mala implements Premium {
    @Override
    public double calculaPrecoFinal(){
        double precoBase = getPrecoBase();
        int anoAtual = Vintage.dataAtual().getYear();
        int anoMala = this.getAno_colecao().getYear();
        int tamanho = this.getDim();
        return precoBase + (tamanho/precoBase)*0.1*(anoAtual-anoMala)*5;

    }
}
