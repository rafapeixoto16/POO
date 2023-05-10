package model;

import java.util.Comparator;

public class OrdenaFaturas implements Comparator<Fatura> {
    public int compare(Fatura a, Fatura b) {return ( int ) ((a.getPreco() - b.getPreco()) * 10);} //todo talvez tirar o 10
}
