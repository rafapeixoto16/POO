package Exceptions;

public class TransportadoraJaExistente extends Exception {
    public TransportadoraJaExistente(){
        super();
    }

    public TransportadoraJaExistente(String mensagem){
        super(mensagem);
    }

}
