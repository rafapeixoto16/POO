package src;

import java.io.Serializable;
import java.time.LocalDate;

public class Vintage implements Serializable {
    private final ListaArtigos listaArtigos;
    private final ListaUtilizadores listaUtilizadores;
    private final ListaTransportadoras listaTransportadoras;
    private final ListaEncomendas listaEncomendas;
    private final ListaFaturas listaFaturas;
    private LocalDate dataSistema;
    public Vintage(){
        listaArtigos = new ListaArtigos();
        listaUtilizadores = new ListaUtilizadores();
        listaTransportadoras = new ListaTransportadoras();
        listaEncomendas = new ListaEncomendas();
        listaFaturas = new ListaFaturas();
    }

    //todo funçoes de jeito

    public LocalDate avancoTemporal(int dias){
        return dataSistema.plusDays(dias);
    }

    public LocalDate getDataSistema(){
        return dataSistema;
    }
}
