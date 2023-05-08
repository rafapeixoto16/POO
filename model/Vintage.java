package model;

import Exceptions.ArtigoNaoExiste;
import Exceptions.TransportadoraNaoExiste;
import Exceptions.UtilizadorNaoExiste;
import Serializacao.Serializacao;

import java.io.Serializable;
import java.time.LocalDate;

import static View.Input.*;
import static java.lang.System.out;

public class Vintage implements Serializable {
    private ListaArtigos listaArtigos;
    private ListaUtilizadores listaUtilizadores;
    private ListaTransportadoras listaTransportadoras;
    private ListaEncomendas listaEncomendas;
    private ListaFaturas listaFaturas;
    private static LocalDate dataSistema;
    public static void incDia(){dataSistema = dataSistema.plusDays(1);}
    public static LocalDate dataAtual(){return dataSistema;}
    public static void setNumeroArtigos(LocalDate data){ dataSistema = data;}
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

    public Sapatilha criaSapatilha(){
        Sapatilha retorno = new Sapatilha();
        retorno.setNovo(getNovo());
        retorno.setNumDonos(getNumDonos());
        retorno.setDescricao(getDescricao());
        retorno.setPrecoBase(getPrecoBase());
        retorno.setTamanho(getTamanhoSapatilha());
        retorno.setAtacadores(getAtacadores());
        retorno.setData(getData());
        retorno.setCor(getCor());
        retorno.setEmailUtilizador(userLigado.getEmail());
        return retorno;
    }

    public Mala criaMala(){
        Mala retorno = new Mala();
        //boolean novo, int numDonos, int avaliacao, String descricao, double precoBase,int dim,String material,LocalDate ano_colecao,String emailUtilizador;
        retorno.setNovo(getNovo());
        retorno.setNumDonos(getNumDonos());
        retorno.setAvaliacao(getAvaliacao());
        retorno.setDescricao(getDescricao());
        retorno.setPrecoBase(getPrecoBase());

        return retorno;
    }
/*
    public TShirt criaTShirt(argumentos){

    }*/

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
                        out.println("Nao existe uma transportadora com codigo " + codigoTransportadora);
                    }
                } catch (ArtigoNaoExiste e) {
                    out.print("Nao existe um artigo com codigo " + artigoString);
                }
            }
        }   while (!artigoString.equals("quit"));

        return encomenda;
    }

    public Transportadora criaTransportadora(){
        Transportadora transportadora = new Transportadora();

        double imposto = getImposto(); //todo de zero a 1???
        transportadora.setImposto(imposto);

        out.println("Nº de dias que a transportadora demora a entregar \n");
        int dias = getInt();
        transportadora.setDiasEntrega(dias);

        return transportadora;
    }
}
