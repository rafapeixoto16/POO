import java.time.LocalDate;

public class Encomenda {
    private static int numeroEncomendas = 0;
    public static void incTotalEnc(){numeroEncomendas++;}
    public static int numeroEnc(){return numeroEncomendas;}
    private final int codEnc;
    private int dimensao;
    private double precoTotal;
    private LocalDate dataLimite;
    private String estado;
    private double precoNovo;
    private double precoVelho;
    private LocalDate dataEncomenda;

    private Encomenda(){
        this.dimensao = 0;
        incTotalEnc();
        this.codEnc = numeroEnc();
        this.precoNovo = 0;
        this.precoVelho = 0;
        this.estado ="";
        this.dataEncomenda = LocalDate.now();
        this.dataLimite = LocalDate.now();
        this.precoTotal = 0;
    }

    private Encomenda(int dimensao,double precoTotal,double precoNovo,double precoVelho, LocalDate dataLimite, String estado,LocalDate dataEncomenda){
        this.dimensao = dimensao;
        incTotalEnc();
        this.codEnc = numeroEnc();
        this.precoNovo = precoNovo;
        this.precoVelho = precoVelho;
        this.estado =estado;
        this.dataEncomenda = dataEncomenda;
        this.dataLimite = dataLimite;
        this.precoTotal = precoTotal;
    }

    private Encomenda(Encomenda encomenda){
        this.dimensao = encomenda.dimensao;
        this.estado = encomenda.estado;
        this.codEnc = encomenda.codEnc;
        this.precoNovo = encomenda.precoNovo;
        this.precoVelho = encomenda.precoVelho;
        this.dataEncomenda = encomenda.dataEncomenda;
        this.dataLimite = encomenda.dataLimite;
        this.precoTotal = encomenda.precoTotal;
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

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPrecoNovo(double precoNovo) {
        this.precoNovo = precoNovo;
    }

    public void setPrecoVelho(double precoVelho) {
        this.precoVelho = precoVelho;
    }

    public void setDataEncomenda(LocalDate dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
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

    public String getEstado() {
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
    public Encomenda clone(){
        return new Encomenda(this);
    }
}
