package Exceptions;

public class TransportadoraNaoExiste extends Exception{
    public TransportadoraNaoExiste(){
        super();
    }

    public TransportadoraNaoExiste(String mensagem){
        super(mensagem);
    }
}
