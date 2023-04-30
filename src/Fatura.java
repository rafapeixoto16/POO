package src;

public class Fatura {
    private Encomenda encomenda;
    private double preco;
    private Utilizador vendedor;
    private Utilizador comprador;

    public Fatura(){
        this.encomenda = null;
        this.preco = 0;
    }

    public Fatura(Fatura fatura){
        this.encomenda = fatura.encomenda;
        this.preco = fatura.preco;
    }
}
