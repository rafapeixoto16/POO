package model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class FaturaVendedor extends Fatura implements Serializable {
    private Utilizador vendedor;
    public FaturaVendedor (){
        super();
        vendedor = new Utilizador();
    }

    public FaturaVendedor(FaturaVendedor vendedor){
        super(vendedor);
        this.vendedor = vendedor.vendedor.clone();
    }

    public FaturaVendedor(double preco,Encomenda encomenda,Utilizador utilizador){
        super(preco,encomenda);
        this.vendedor = utilizador.clone();
    }

    public Utilizador getVendedor() {
        return vendedor;
    }

    public void setVendedor(Utilizador vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;

        if(o==null || o.getClass() != this.getClass())
            return false;

        FaturaVendedor l = (FaturaVendedor) o;

        return super.equals(l) && this.vendedor.equals(l.vendedor);
    }

    @Override
    public FaturaVendedor clone(){
        return new FaturaVendedor(this);
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(),vendedor);
    }

    @Override
    public String toString(){
        return  "Vendedor: "+vendedor.toString()+"\n"
                + "Encomenda: " + super.toString()+"\n"
                + "Dinheiro da venda: " + calculaPrecoEncomendaVendedor(this.getEncomenda());
    }
    public double calculaPrecoEncomendaVendedor(Encomenda encomenda){
        double retorno = 0;
        List<Artigo> artigos = encomenda.getArtigos();

        for (Artigo a : artigos){
            if (a.getEmailUtilizador().equals(vendedor.getEmail()))
                retorno += a.calculaPrecoFinal();
        }

        return retorno;
    }

}

