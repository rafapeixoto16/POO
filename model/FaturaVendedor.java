package model;

import java.util.Objects;

public class FaturaVendedor extends Fatura{
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
        return "Vendedor: "+vendedor.toString()+"\n"
                +"Encomenda :" + super.toString()+"\n";
    }

}

