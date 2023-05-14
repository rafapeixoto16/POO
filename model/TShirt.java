package model;

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

    public TShirt(){
        super();
        this.padrao = LISO;
        this.tamanho = S;
    }
    public TShirt(boolean novo,int numDonos ,int avaliacao, String descricao, double precoBase ,int tamanho,int padrao,String emailUtilizador,int codTransportadora) {
        super(novo,numDonos,avaliacao, descricao,precoBase,emailUtilizador,codTransportadora);
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

    public double calculaPrecoFinal(){
        double precoFinal = getPrecoBase();

        if(this.getPadrao() == 0 || this.getNovo())
            return precoFinal;


        return precoFinal / 2;
    }

    @Override
    public String toString(){
        return super.toString() + "Caracteristicas da Tshirt" +
                "\n    Tamanho -> " + auxTamanho(this.getTamanho()) +
                "\n    Padrao -> "+ auxPadrao(this.getPadrao())  +
                "\n    Preço Artigo -> "+ String.format("%.2f",calculaPrecoFinal()) +" €\n";
    }

    private String auxTamanho(int tamanho){
        String s;
        if(tamanho==0)
            s="S";

        else if(tamanho == 1)
            s="M";

        else if(tamanho==2)
            s="L";
        else
            s="XL";

        return s;
    }

    private String auxPadrao(int padrao){
        String s;
        if(padrao==0)
            s="Liso";

        else if(padrao == 1)
            s="Riscas";

        else
            s="Palmeiras";

        return s;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if ((o == null) || (this.getClass() != o.getClass())) return false;

        TShirt umaTshirt = (TShirt) o;
        return super.equals(umaTshirt) && this.tamanho == umaTshirt.getTamanho() && this.padrao ==  umaTshirt.padrao;
    }

}
