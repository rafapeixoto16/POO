package src;

import Exceptions.UtilizadorNaoExiste;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class Vintage implements Serializable {
    private final ListaArtigos listaArtigos;
    private final ListaUtilizadores listaUtilizadores;
    private final ListaTransportadoras listaTransportadoras;
    private final ListaEncomendas listaEncomendas;
    private final ListaFaturas listaFaturas;
    private LocalDate dataSistema;
    private Utilizador userLigado;
    public Vintage(){
        listaArtigos = new ListaArtigos();
        listaUtilizadores = new ListaUtilizadores();
        listaTransportadoras = new ListaTransportadoras();
        listaEncomendas = new ListaEncomendas();
        listaFaturas = new ListaFaturas();
        userLigado = new Utilizador();
    }

    //todo funçoes de jeito

    public LocalDate avancoTemporal(int dias){
        return dataSistema.plusDays(dias);
    }

    public LocalDate getDataSistema(){
        return dataSistema;
    }

    public void login(String email) {
        if(listaUtilizadores.existeUtilizador(email)){
            try {
                userLigado = listaUtilizadores.getUtilizadorLista(email);
            }
            catch (UtilizadorNaoExiste | NullPointerException exception ) {}
        }
    }
}
