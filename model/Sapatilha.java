package model;

import java.time.LocalDate;

public class Sapatilha extends Artigo {
    private int tamanho;
    private boolean atacadores; //sapatilhas podem ter: atacadores ou atilhos
    private LocalDate data;
    private String cor;

    //Construtores


    public Sapatilha (){
        super();
        tamanho = 0;
        atacadores = false;
        data = LocalDate.now();
        cor="";
    }

    public Sapatilha(boolean novo,int numDonos ,int avaliacao, String descricao, double precoBase, int tamanho,
    boolean atacadores,LocalDate data,String cor,String emailUtilizador,int codTransportadora ){
        super(novo,numDonos , avaliacao,descricao, precoBase,emailUtilizador,codTransportadora);
        this.tamanho = tamanho;
        this.atacadores = atacadores;
        this.data = data;
        this.cor = cor;

    }

    public Sapatilha (Sapatilha sapatilha){
        super(sapatilha);
        this.tamanho = sapatilha.getTamanho();
        this.atacadores = sapatilha.isAtacadores();
        this.data = sapatilha.getData();
        this.cor = sapatilha.getCor();
    }

    //Getters
    public int getTamanho() {
        return tamanho;
    }

    public boolean isAtacadores() {
        return atacadores;
    }

    public LocalDate getData() {
        return data;
    }

    public String getCor() {
        return cor;
    }

    //Setters
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setAtacadores(boolean atacadores) {
        this.atacadores = atacadores;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double calculaPrecoFinal(){
        double precoFinal = getPrecoBase();

        if(getNovo())
            return precoFinal;

        if(this.data.getDayOfYear() - Vintage.dataAtual().getDayOfYear() > 0 || tamanho > 45){
            precoFinal = precoFinal - precoFinal * getNumDonos() / getAvaliacao() / 100 / 20;
        }

        return precoFinal;
    }
    //Equals
    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if ((o == null) || (this.getClass() != o.getClass())) return false;

        Sapatilha umaSapatilha = (Sapatilha) o;
        return  super.equals(umaSapatilha) && this.tamanho == umaSapatilha.getTamanho() && this.atacadores == umaSapatilha.isAtacadores() &&
                this.cor.equals(umaSapatilha.getCor()) && this.data.equals(umaSapatilha.getData());
    }
    //Clone
    @Override
    public Sapatilha clone(){
        return new Sapatilha(this);
    }

    //toString

    @Override
    public String toString() {
        return super.toString()+ "Caracteristicas da Sapatilha" +
                "\n    Tamanho -> " + tamanho +
                "\n    Tipo -> " + auxAtacadores(atacadores) +
                "\n    Ano de Lançamento -> " + data.getYear() +
                "\n    Cor -> " + cor +
                "\n    Preço Artigo -> "+ String.format("%.2f",calculaPrecoFinal()) +" €\n";
    }

    private String auxAtacadores(boolean atacadores) {
        if (atacadores) return "Atacadores"; else return "Atilhos";
    }
}
