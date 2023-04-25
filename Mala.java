import java.time.LocalDate;
import java.util.*;

public class Mala extends Artigo {

    private int dim;
    private String material;
    private LocalDate ano_colecao;


    /**----------------------------------------------
                Construtor para uma nova Mala
     ----------------------------------------------**/

    public Mala() {
    }

    public Mala(boolean novo, int numDonos, int avaliacao, String descricao, double precoBase, double correcaoPreco,String material,LocalDate ano_colecao) {
        super(novo, numDonos, avaliacao, descricao, precoBase, correcaoPreco);
        this.material = material;
        this.ano_colecao = ano_colecao;
    }

    public Mala(Artigo artigo) {
        super(artigo);
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
}
