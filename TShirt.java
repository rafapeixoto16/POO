public class TShirt extends Artigo {
    public static final int S = 0;
    public static final int M = 1;
    public static final int L = 2;
    public static final int XL = 3;

    public static final int LISO = 0;          //liso tem sempre desconto
    public static final int RISCAS = 1;        //outras só tem desconto (50%) se forem usadas
    public static final int PALMEIRAS = 2;

    private int tamanho;
    private int padrao;

    public TShirt(boolean novo,int numDonos ,int avaliacao, String descricao, String codigo, double precoBase ,double correcaoPreco,int tamanho,int padrao) {
        super(novo,numDonos,avaliacao, descricao, codigo, precoBase,correcaoPreco);
        this.padrao = padrao;
        this.tamanho = tamanho;
    }

    public TShirt(TShirt tShirt){
        super(tShirt);
        this.tamanho = tShirt.tamanho;
        this.padrao = tShirt.padrao;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getPadrao() {
        return padrao;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setPadrao(int padrao) {
        this.padrao = padrao;
    }

    @Override
    public Artigo clone() {
        return new TShirt(this);
    }


}
