package src;

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

    @Override
    public FaturaCliente clone(){
        return new FaturaCliente(this);
    }
}
