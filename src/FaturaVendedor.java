package src;

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

    @Override
    public FaturaVendedor clone(){
        return new FaturaVendedor(this);
    }
}

