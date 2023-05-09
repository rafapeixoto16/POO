package model;

import java.util.Objects;

public class FaturaCliente extends Fatura {
    private Utilizador cliente;

    public FaturaCliente (){
        super();
        cliente = new Utilizador();
    }

    public FaturaCliente(FaturaCliente cliente){
        super(cliente);
        this.cliente = cliente.cliente.clone();
    }

    public FaturaCliente(double preco,Encomenda encomenda,Utilizador utilizador){
        super(preco,encomenda);
        this.cliente = utilizador.clone();
    }

    public Utilizador getCliente() {
        return cliente;
    }

    public void setCliente(Utilizador cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;

        if(o==null || o.getClass() != this.getClass())
            return false;

        FaturaCliente l = (FaturaCliente) o;

        return super.equals(l) && this.cliente.equals(l.cliente);
    }

    @Override
    public FaturaCliente clone(){
        return new FaturaCliente(this);
    }

    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(),cliente);
    }

    @Override
    public String toString(){
        return "Clientes: " + cliente.toString() + "\n"
                +"Encomenda: "+super.toString();
    }

    //todo funçao calcula preço preço
}
