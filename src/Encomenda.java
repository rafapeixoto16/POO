package src;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Encomenda implements Serializable {
    private static int numeroEncomendas = 0;
    public static void incTotalEnc() {
        numeroEncomendas++;
    }
    public static int numeroEnc() {
        return numeroEncomendas;
    }
    private final static double precoNovo = 0.5;
    private final static double precoVelho = 0.25;
    private final int codEnc;
    private int dimensao;
    private double precoTotal;
    private LocalDate dataLimite;
    private boolean estado;
    private LocalDate dataEncomenda;
    private int codUtilizadorCompra;
    private final Map<Transportadora, List<Artigo> > encomenda;

    private Encomenda() {
        this.encomenda = new HashMap<>();
        this.dimensao = 0;
        incTotalEnc();
        this.codEnc = numeroEnc();
        this.estado = false;
        this.dataEncomenda = LocalDate.now();
        this.dataLimite = LocalDate.now();
        this.precoTotal = 0;
    }

    private Encomenda(double precoTotal, LocalDate dataLimite, boolean estado, LocalDate dataEncomenda, Transportadora transportadora, List<Artigo> artigos, int codUtilizadorCompra) {
        this.encomenda = new HashMap<>();
        List<Artigo> artigos1 = new ArrayList<>();

        for (Artigo a : artigos) {
            artigos1.add(a.clone());
        }

        this.encomenda.put(transportadora, artigos1);
        this.codUtilizadorCompra = codUtilizadorCompra;
        this.dimensao = encomenda.values().size();
        incTotalEnc();
        this.codEnc = numeroEnc();
        this.estado = estado;
        this.dataEncomenda = dataEncomenda;
        this.dataLimite = dataLimite;
        this.precoTotal = precoTotal;
    }

    private Encomenda(Encomenda encomenda) {
        this.encomenda = new HashMap<>();

        for (Transportadora a : encomenda.encomenda.keySet()) {
            List<Artigo> artigos1 = new ArrayList<>();
            for (Artigo b : encomenda.encomenda.get(a)) {
                artigos1.add(b.clone());
            }
            this.encomenda.put(a.clone(), artigos1);
        }

        this.dimensao = encomenda.dimensao;
        this.estado = encomenda.estado;
        this.codEnc = encomenda.codEnc;
        this.dataEncomenda = encomenda.dataEncomenda;
        this.dataLimite = encomenda.dataLimite;
        this.precoTotal = encomenda.precoTotal;
    }
    public void setCodUtilizadorCompra(int codUtilizadorCompra) {
        this.codUtilizadorCompra = codUtilizadorCompra;
    }

    public static void setNumeroEncomendas(int numeroEncomendas) {
        Encomenda.numeroEncomendas = numeroEncomendas;
    }

    public void setDimensao(int dimensao) {
        this.dimensao = dimensao;
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

    public int getCodUtilizadorCompra() {
        return codUtilizadorCompra;
    }

    public static int getNumeroEncomendas() {
        return numeroEncomendas;
    }

    public int getCodEnc() {
        return codEnc;
    }

    public int getDimensao() {
        return dimensao;
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
        return "Encomenda :"+getCodEnc()+ "\n" + "dimensao"+getDimensao()+ "";
    }
    public void addEncomenda(Transportadora transportadora, List<Artigo> artigos) {
        List<Artigo> artigos1 = new ArrayList<>();
        for (Artigo a : artigos)
            artigos1.add(a.clone());

        this.encomenda.put(transportadora.clone(), artigos1);
    }
    public void remEncomenda(Transportadora transportadora,List<Artigo> artigos){
        List<Artigo> artigos1 = encomenda.get(transportadora);
        artigos1.removeAll(artigos);
        encomenda.remove(transportadora);
        encomenda.put(transportadora,artigos1);
    }






}