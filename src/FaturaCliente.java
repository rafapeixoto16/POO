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

    @Override
    public FaturaCliente clone(){
        return new FaturaCliente(this);
    }
}
