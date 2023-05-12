package model;

import java.time.LocalDate;

public class Mala extends Artigo {
    private int dim;
    private String material;
    private LocalDate ano_colecao;

    /**----------------------------------------------
                Construtor para uma nova src.Mala
     ----------------------------------------------**/
    public Mala() {
        super();
        this.dim = 0;
        this.material = "";
        this.ano_colecao = LocalDate.now();
    }

    public Mala(boolean novo, int numDonos, int avaliacao, String descricao, double precoBase,int dim,String material,LocalDate ano_colecao,String emailUtilizador) {
        super(novo, numDonos, avaliacao, descricao, precoBase,emailUtilizador);
        this.dim = dim;
        this.material = material;
        this.ano_colecao = ano_colecao;
    }

    public Mala(Mala mala) {
        super(mala);
        this.dim = mala.dim;
        this.material = mala.material;
        this.ano_colecao = mala.ano_colecao;
    }

    /**----------------------------------------------
                         Getters
     ----------------------------------------------**/
    public int getDim() {
        return dim;
    }

    public String getMaterial() {
        return material;
    }

    public LocalDate getAno_colecao() {
        return ano_colecao;
    }

    /**----------------------------------------------
                        Setters
     ----------------------------------------------**/
    public void setDim(int dim) {
        this.dim = dim;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setAno_colecao(LocalDate ano_colecao) {
        this.ano_colecao = ano_colecao;
    }

    //Clone
    @Override
    public Mala clone(){
        return new Mala(this);
    }


    public double calculaPrecoFinal(){
        double precoFinal = getPrecoBase();
        double desconto = precoFinal - ( dim / precoFinal ) * (getAno_colecao().getDayOfYear() - Vintage.dataAtual().getDayOfYear());

        if(desconto <= 0)
            precoFinal = precoFinal * 0.95;

        else
            precoFinal = precoFinal - desconto;


        return precoFinal;
    }
    @Override
    public String toString(){
        return super.toString() + "Estado da Mala"+
                "\n    Dimensao -> "+ dim+
                "\n    Material -> "+ material+
                "\n    Ano de Lançamento -> "+ ano_colecao.getYear();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if ((o == null) || (this.getClass() != o.getClass())) return false;

        Mala umArtigo = (Mala) o;
        return super.equals(umArtigo) && this.dim == umArtigo.dim && this.ano_colecao.equals(umArtigo.ano_colecao) &&
                this.material.equals(umArtigo.material);
    }
}
