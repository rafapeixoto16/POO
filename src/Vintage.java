package src;

import Exceptions.ArtigoNaoExiste;
import Exceptions.TransportadoraJaExistente;
import Exceptions.TransportadoraNaoExiste;
import Exceptions.UtilizadorNaoExiste;
import Serializacao.Serializacao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static View.Input.*;

public class Vintage implements Serializable {
    private ListaArtigos listaArtigos;
    private ListaUtilizadores listaUtilizadores;
    private ListaTransportadoras listaTransportadoras;
    private ListaEncomendas listaEncomendas;
    private ListaFaturas listaFaturas;
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

    public Vintage(Vintage vintage){
        this.listaUtilizadores = vintage.listaUtilizadores.clone();
        this.listaArtigos = vintage.listaArtigos.clone();
        this.listaTransportadoras = vintage.listaTransportadoras.clone();
        this.listaEncomendas = vintage.listaEncomendas.clone();
        this.listaFaturas = vintage.listaFaturas.clone();
        this.userLigado = userLigado.clone();
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
            catch (UtilizadorNaoExiste | NullPointerException ignored) {}
        }
    }

    public void logout(){
        userLigado = null;
    }

    public ListaArtigos getListaArtigos() {
        return listaArtigos;
    }

    public ListaUtilizadores getListaUtilizadores() {
        return listaUtilizadores;
    }

    public ListaTransportadoras getListaTransportadoras() {
        return listaTransportadoras;
    }

    public ListaEncomendas getListaEncomendas() {
        return listaEncomendas;
    }

    public ListaFaturas getListaFaturas() {
        return listaFaturas;
    }

    public Utilizador getUserLigado() {
        return userLigado;
    }

    public void setListaArtigos(ListaArtigos listaArtigos) {
        this.listaArtigos = listaArtigos;
    }

    public void setListaUtilizadores(ListaUtilizadores listaUtilizadores) {
        this.listaUtilizadores = listaUtilizadores;
    }

    public void setListaTransportadoras(ListaTransportadoras listaTransportadoras) {
        this.listaTransportadoras = listaTransportadoras;
    }

    public void setListaEncomendas(ListaEncomendas listaEncomendas) {
        this.listaEncomendas = listaEncomendas;
    }

    public void setListaFaturas(ListaFaturas listaFaturas) {
        this.listaFaturas = listaFaturas;
    }

    public void setDataSistema(LocalDate dataSistema) {
        this.dataSistema = dataSistema;
    }

    public void setUserLigado(Utilizador userLigado) {
        this.userLigado = userLigado;
    }

    /*public Sapatilha criaSapatilha(argumentos){

    }

    public Mala criaMala(argumentos){

    }

    public TShirt criaTShirt(argumentos){

    }*/


    public void salvaFicheirosDados(Serializacao ficheiro){
        ficheiro.guardar(this);
    }


    public Encomenda criaEncomenda() {
        Encomenda encomenda = new Encomenda();
        encomenda.setEmailUtilizadorCompra(userLigado.getEmail());
        String artigoString;
        int codigoTransportadora;

        do {
            artigoString = getString();
            if (!artigoString.equals("quit")) {
                try {
                    Artigo artigo = listaArtigos.getArtigoLista(artigoString);
                    codigoTransportadora = getInt();
                    try {
                        Transportadora transportadora = listaTransportadoras.getTransportadoraLista(codigoTransportadora);
                        encomenda.addEncomenda(transportadora,artigo);
                    }
                    catch (TransportadoraNaoExiste e){
                        //todo nao me lembro
                    }
                } catch (ArtigoNaoExiste e) {
                    //todo nao me lembro
                }
            }
        }   while (!artigoString.equals("quit"));

        return encomenda;
    }

    public Transportadora criaTransportadora(){
        Transportadora transportadora = new Transportadora();

        double imposto = getImposto(); //todo de zero a 1???
        transportadora.setImposto(imposto);

        System.out.println("Nº de dias que a transportadora demora a entregar \n");
        int dias = getInt();
        transportadora.setDiasEntrega(dias);

        return transportadora;
    }
}
