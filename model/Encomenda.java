package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Encomenda implements Serializable {
    private static int numeroEncomendas = 0;
    public static void incTotalEnc() {
        numeroEncomendas++;
    }
    public static int numeroEnc() {
        return numeroEncomendas;
    }
    public static void setNumEncomenda(int i){
        numeroEncomendas = i;
    }
    private final static double precoNovo = 0.5;
    private final static double precoVelho = 0.25;
    private final int codEnc;
    private double precoTotal;
    private LocalDate dataLimite;
    private boolean estado;
    private LocalDate dataEncomenda;
    private String emailUtilizadorCompra;
    private final Map<Transportadora, List<Artigo>> encomenda;


    public List<Artigo> getArtigos (){
        List<Artigo> retorno = new ArrayList<>();
        for (List<Artigo> a : encomenda.values()){
            for(Artigo b : a){
                retorno.add(b.clone());
            }
        }

        return retorno;
    }

    public Encomenda() {
        this.encomenda = new HashMap<>();
        incTotalEnc();
        this.codEnc = numeroEnc();
        this.estado = false;
        this.dataEncomenda = LocalDate.now();
        this.dataLimite = LocalDate.now();
        this.precoTotal = 0;
        this.emailUtilizadorCompra = "";
    }

    public List<Artigo> getLista(Transportadora transportadora){
        List<Artigo> artigos = new ArrayList<>();

        for (Artigo a : this.encomenda.get(transportadora)){
            artigos.add(a.clone());
        }

        return artigos;
    }



    public List<Transportadora> retornaKeys(Encomenda encomenda){
        List<Transportadora> retorno = new ArrayList<>();
        for (Transportadora a : encomenda.encomenda.keySet()){
            retorno.add(a.clone());
        }
        return retorno;
    }

    public Encomenda(LocalDate dataLimite, boolean estado, LocalDate dataEncomenda, Transportadora transportadora, List<Artigo> artigos, String emailUtilizadorCompra) {
        this.encomenda = new HashMap<>();
        List<Artigo> artigos1 = new ArrayList<>();

        for (Artigo a : artigos) {
            artigos1.add(a.clone());
        }

        this.encomenda.put(transportadora, artigos1);
        this.emailUtilizadorCompra = emailUtilizadorCompra;
        incTotalEnc();
        this.codEnc = numeroEnc();
        this.estado = estado;
        this.dataEncomenda = dataEncomenda;
        this.dataLimite = dataLimite;
        this.precoTotal = 0;
    }

    public Encomenda(Encomenda encomenda) {
        this.encomenda = new HashMap<>();

        for (Transportadora a : encomenda.encomenda.keySet()) {
            List<Artigo> artigos1 = new ArrayList<>();
            for (Artigo b : encomenda.encomenda.get(a)) {
                artigos1.add(b.clone());
            }
            this.encomenda.put(a.clone(), artigos1);
        }

        this.estado = encomenda.estado;
        this.codEnc = encomenda.codEnc;
        this.dataEncomenda = encomenda.dataEncomenda;
        this.dataLimite = encomenda.dataLimite;
        this.precoTotal = encomenda.precoTotal;
    }
    public void setEmailUtilizadorCompra(String emailUtilizadorCompra) {
        this.emailUtilizadorCompra = emailUtilizadorCompra;
    }

    public static void setNumeroEncomendas(int numeroEncomendas) {
        Encomenda.numeroEncomendas = numeroEncomendas;
    }
    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setDataEncomenda(LocalDate dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    public String getEmailUtilizadorCompra() {
        return emailUtilizadorCompra;
    }

    public static int getNumeroEncomendas() {
        return numeroEncomendas;
    }

    public int getCodEnc() {
        return codEnc;
    }

    public int getDimensao() {
        return encomenda.values().size();
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public boolean getEstado() {
        return estado;
    }

    public double getPrecoNovo() {
        return precoNovo;
    }

    public double getPrecoVelho() {
        return precoVelho;
    }

    public LocalDate getDataEncomenda() {
        return dataEncomenda;
    }

    @Override
    public Encomenda clone() {
        return new Encomenda(this);
    }

    @Override
    public String toString(){
        StringBuilder retorno = new StringBuilder();

        for (List<Artigo> a : encomenda.values()){
            for (Artigo b : a){
                retorno.append(b.toString());
            }
        }
        return retorno.toString();
    }

    public void addEncomenda(Transportadora transportadora, List<Artigo> artigos) {
        List<Artigo> artigos1 = new ArrayList<>();
        for (Artigo a : artigos)
            artigos1.add(a.clone());

        this.encomenda.put(transportadora.clone(), artigos1);
    }
    public void removeArtigo(Transportadora transportadora,List<Artigo> artigos){
        List<Artigo> artigos1 = encomenda.get(transportadora);
        artigos1.removeAll(artigos);
        encomenda.remove(transportadora);
        encomenda.put(transportadora,artigos1);
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if(o == null || o.getClass() != this.getClass())
            return false;

        Encomenda encomenda1 = (Encomenda) o;
        return encomenda1.estado == this.estado && this.encomenda.equals(encomenda1.encomenda) && this.dataEncomenda.equals(encomenda1.dataEncomenda)&&
                this.codEnc == encomenda1.codEnc && this.dataLimite.equals(encomenda1.dataLimite) &&
                this.emailUtilizadorCompra.equals(encomenda1.emailUtilizadorCompra);
    }

    public void addEncomenda(Transportadora transportadora, Artigo artigos) {
        if(encomenda.containsKey(transportadora)){
            encomenda.get(transportadora).add(artigos);
        }
        else {
            List<Artigo> artigos1 = new ArrayList<>();
            artigos1.add(artigos);
            this.encomenda.put(transportadora.clone(), artigos1);
        }
    }

    public double calculaPrecoEncomenda (){
        double retorno = 0;
        List<Transportadora> itens = this.encomenda.keySet().stream().toList();

        for (Transportadora a : itens){
            List<Artigo> artigos = this.getLista(a);

            retorno += a.custoExpedicao(artigos);

            for (Artigo b : artigos)
                retorno +=b.calculaPrecoFinal();

        }
        return retorno;
    }

    public boolean validoCancelamentoEncomenda(){
        boolean retorno = true;

        Iterator<Transportadora> it = encomenda.keySet().iterator();
        Transportadora b;

        while (it.hasNext()  && retorno){
            b = it.next();
            if(ChronoUnit.DAYS.between(Vintage.dataAtual(),this.dataEncomenda) > b.getDiasEntrega() + 2)
                retorno = false;
        }
        return retorno;
    }


    public double calculaPercentagemVintage(){
        double retorno = 0;
        for (Transportadora a : this.encomenda.keySet()){
            for (Artigo b : this.encomenda.get(a)){
                if(b.isNovo())
                    retorno+=0.5;
                else
                    retorno+=0.25;
            }
        }
        return retorno;
    }




}