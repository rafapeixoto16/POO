package src;

import Exceptions.ArtigoJaExistente;

import java.io.Serializable;
import java.util.*;

public class Utilizador implements Serializable {
    private final Map<String, Artigo> artigosVendidos;
    private final List<Integer> encomendas;
    private final Map<String,Artigo> artigosPorVender;
    private final Map<String ,Artigo> artigosComprados;
    private String email;
    private String nome;
    private String morada;
    private int numeroFiscal;
    private double dinheiroVendas;


    /**----------------------------------------------
                        Utilizador
     ----------------------------------------------**/
    public Utilizador(){
        this.artigosVendidos = new HashMap<>();
        this.artigosComprados = new HashMap<>();
        this.artigosPorVender = new HashMap<>();
        this.encomendas = new ArrayList<>();
        this.email = "";
        this.nome  = "";
        this.morada = "";
        this.numeroFiscal = 0;
        this.dinheiroVendas = 0.0;
    }

    public Utilizador(String email,String nome ,String morada,int numeroFiscal){
        this.artigosVendidos = new HashMap<>();
        this.artigosComprados = new HashMap<>();
        this.artigosPorVender = new HashMap<>();
        this.encomendas = new ArrayList<>();
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.numeroFiscal = numeroFiscal;
        this.dinheiroVendas = 0;

    }

    public Utilizador (Utilizador utilizador){
        this.artigosVendidos = new HashMap<>();
        this.artigosComprados = new HashMap<>();
        this.artigosPorVender = new HashMap<>();
        this.encomendas = new ArrayList<>();

        encomendas.addAll(utilizador.encomendas);

        for (Artigo b : utilizador.artigosPorVender.values()){
            this.artigosPorVender.put(b.getCodigo(),b.clone());
        }

        for (Artigo b : utilizador.artigosComprados.values()){
            this.artigosComprados.put(b.getCodigo(),b.clone());
        }

        for (Artigo b : utilizador.artigosVendidos.values()){
            this.artigosVendidos.put(b.getCodigo(),b.clone());
        }

        this.email = utilizador.email;
        this.nome = utilizador.nome;
        this.morada = utilizador.morada;
        this.numeroFiscal = utilizador.numeroFiscal;
        this.dinheiroVendas = utilizador.dinheiroVendas;
    }


    /**----------------------------------------------
                         Getters
     ----------------------------------------------**/

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getMorada() {
        return morada;
    }

    public int getNumeroFiscal() {
        return numeroFiscal;
    }

    public double getDinheiroVendas() {
        return dinheiroVendas;
    }

    /**----------------------------------------------
                        Setters
     ----------------------------------------------**/
    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setNumeroFiscal(int numeroFiscal) {
        this.numeroFiscal = numeroFiscal;
    }

    public void setDinheiroVendas(double dinheiroVendas) {
        this.dinheiroVendas = dinheiroVendas;
    }


    /**----------------------------------------------
                          Clone
     ----------------------------------------------**/

    @Override
    public Utilizador clone(){
        return new Utilizador(this);
    }

    /**----------------------------------------------
                          Equals
     ----------------------------------------------**/

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;

        if ((obj == null) || (this.getClass() != obj.getClass())) return false;

        Utilizador utilizador = (Utilizador) obj;
        return this.nome.equals(utilizador.nome) && this.email.equals(utilizador.email) && this.numeroFiscal == utilizador.numeroFiscal;
    }

    /**----------------------------------------------
                          toString
     ----------------------------------------------**/

    @Override
    public String toString() {
        return "Informaçao do utilizador:" +
                "\n    Nome     -> " + nome +
                "\n    NIF      -> " + numeroFiscal +
                "\n    Email    -> " + email +
                "\n    Morada   -> " + morada +
                "\n    Dinheiro Vendas : " + dinheiroVendas;
    }

    /**----------------------------------------------
                          hashCode
     ----------------------------------------------**/

    @Override
    public int hashCode() {
         return Objects.hash(email);
    }
    public void incrementaDinheiroTotal(double acc){
        this.dinheiroVendas += acc;
    }
    public boolean encomendaUtilizador (Encomenda encomenda){
        return encomendas.contains(encomenda.getCodEnc());
    }
    public void adicionaEncomendasUtilizador (Encomenda encomenda){
        encomendas.add(encomenda.getCodEnc());
    }

    public void removeEncomendasUtilizador (Encomenda encomenda){
        encomendas.remove(Integer.valueOf(encomenda.getCodEnc()));
    }
    public void addCompradosUtilizadores(Artigo artigo){
        artigosComprados.put(artigo.getCodigo(),artigo.clone());
    }

    public void removeCompradosUtilizadores(Artigo artigo){
        artigosComprados.remove(artigo.getCodigo());
    }
    public boolean comprouArtigoUtilizador(Artigo artigo){
        return artigosComprados.containsKey(artigo.getCodigo());
    }
    public void removeArtigosPorVender(Artigo artigo){
        artigosPorVender.remove(artigo.getCodigo());
    }
    public void addArtigosPorVender(Artigo artigo){
        artigosPorVender.put(artigo.getCodigo(),artigo.clone());
    }
    public boolean temArtigoPorVender(Artigo artigo){
        return artigosPorVender.containsKey(artigo.getCodigo());
    }
    public void addArtigosVendidos(Artigo artigo){
        artigosVendidos.put(artigo.getCodigo(),artigo.clone());
    }
    public void removeArtigosVendidos(Artigo artigo) {
        artigosVendidos.remove(artigo.getCodigo());
    }
    public boolean existeArtigosVendidos(Artigo artigo){
        return artigosVendidos.containsKey(artigo.getCodigo());
    }
    public void vendeArtigos(Artigo artigo){
        removeArtigosPorVender(artigo);
        addArtigosVendidos(artigo);
    }
    public void cancelaVenda(Artigo artigo){
        removeArtigosVendidos(artigo);
        addArtigosPorVender(artigo);
    }
}
