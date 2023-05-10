package model;

import java.util.Comparator;

public class OrdenaUtilizadoresVendas implements Comparator<Utilizador>{
    public int compare(Utilizador a, Utilizador b){
        return (int) (a.getDinheiroVendas() - b.getDinheiroVendas());
    }
}