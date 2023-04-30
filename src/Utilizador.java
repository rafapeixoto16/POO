package src;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Utilizador implements Serializable {
    private final Map<Integer, Artigo> vendidos;
    private final Map<Integer,Artigo> comprados;
    private String email;
    private String nome;
    private String morada;
    private int numeroFiscal;
    private double dinheiroVendas;


    /**----------------------------------------------
                        Utilizador
     ----------------------------------------------**/
    public Utilizador(){
        this.vendidos = new HashMap<>();
        this.comprados = new HashMap<>();
        this.email = "";
        this.nome  = "";
        this.morada = "";
        this.numeroFiscal = 0;
        this.dinheiroVendas = 0.0;
    }
    public Utilizador(String email,String nome ,String morada,int numeroFiscal){
        this.vendidos = new HashMap<>();
        this.comprados = new HashMap<>();
        this.email = email;
        this.nome = nome;
        this.morada = morada;
        this.numeroFiscal = numeroFiscal;
        this.dinheiroVendas = 0;
    }

    public Utilizador (Utilizador utilizador){
        this.vendidos = new HashMap<>();
        this.comprados = new HashMap<>();
        vendidos.putAll(utilizador.vendidos);
        comprados.putAll(utilizador.comprados);
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
         return Objects.hash(nome,numeroFiscal,email,morada);
    }

    public void incrementaDinheiroTotal(double acc){
        this.dinheiroVendas += acc;
    }
}
