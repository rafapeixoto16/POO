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


    public TShirt(boolean novo, String descricao, String codigo, double precoBase) {
        super(novo, descricao, codigo, precoBase);

    }


}
