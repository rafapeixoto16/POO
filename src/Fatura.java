package src;

import java.util.Objects;

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
        this.comprador = fatura.comprador.clone();
        this.vendedor = fatura.vendedor.clone();
    }

    public Encomenda getEncomenda() {
        return encomenda;
    }

    public double getPreco() {
        return preco;
    }

    public Utilizador getVendedor() {
        return vendedor;
    }

    public Utilizador getComprador() {
        return comprador;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setVendedor(Utilizador vendedor) {
        this.vendedor = vendedor;
    }

    public void setComprador(Utilizador comprador) {
        this.comprador = comprador;
    }

    @Override
    public String toString(){
        return "Encomenda"+encomenda.toString()+"\npreço "+preco +
                "\n comprador : "+comprador.toString() +"\n vendedor :" + vendedor.toString();
    }


    @Override
    public Fatura clone(){
        return new Fatura(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(encomenda,vendedor,comprador);
    }
}
