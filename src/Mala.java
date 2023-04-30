package src;

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

    public Mala(boolean novo, int numDonos, int avaliacao, String descricao, double precoBase, double correcaoPreco,int dim,String material,LocalDate ano_colecao,int numeroUtilizador) {
        super(novo, numDonos, avaliacao, descricao, precoBase, correcaoPreco,numeroUtilizador);
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

    @Override
    public String toString(){
        return "Estado da src.Mala"+
                "\n Dimensao -> "+ dim+
                "\n Material -> "+ material+
                "\n Ano Launch -> "+ ano_colecao;//!todo
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
