package src;

import java.io.Serializable;

public class Vintage implements Serializable {
    private final ListaArtigos listaArtigos;
    private final ListaUtilizadores listaUtilizadores;



    public Vintage(){
        listaArtigos = new ListaArtigos();
        listaUtilizadores = new ListaUtilizadores();

    }
}
