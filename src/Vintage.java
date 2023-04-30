package src;

import java.io.Serializable;

public class Vintage implements Serializable {
    private final ListaArtigos listaArtigos;
    private final ListaUtilizadores listaUtilizadores;
    private final ListaTransportadoras listaTransportadoras;
    private final ListaEncomendas listaEncomendas;
    private final ListaFaturas listaFaturas;
    public Vintage(){
        listaArtigos = new ListaArtigos();
        listaUtilizadores = new ListaUtilizadores();
        listaTransportadoras = new ListaTransportadoras();
        listaEncomendas = new ListaEncomendas();
        listaFaturas = new ListaFaturas();
    }

    //todo funçoes de jeito
}
