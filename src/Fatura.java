package src;

import java.util.Objects;

public abstract class Fatura {
    private Encomenda encomenda;
    private double preco;

    public Fatura(){
        this.encomenda = null;
        this.preco = 0;
    }

    public Fatura(Fatura fatura){
        this.encomenda = fatura.encomenda.clone();
        this.preco = fatura.preco;
    }

    public Fatura(double preco,Encomenda encomenda){
        this.encomenda = encomenda.clone();
        this.preco = preco;
    }


    public Encomenda getEncomenda() {
        return encomenda;
    }

    public double getPreco() {
        return preco;
    }

    public void setEncomenda(Encomenda encomenda) {
        this.encomenda = encomenda;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString(){
        return "Encomenda"+encomenda.toString()+"\n preço: "+preco;
    }

    @Override
    public boolean equals(Object o){
        if(o==this)
            return true;

        if(o==null || o.getClass() != this.getClass())
            return false;

        Fatura l = (Fatura) o;
        return l.preco == this.preco && this.encomenda == l.encomenda;
    }


    @Override
    public abstract Fatura clone();

    @Override
    public int hashCode() {
        return Objects.hash(encomenda,preco);
    }
}
