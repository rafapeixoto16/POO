package Exceptions;

public class UtilizadorNaoExiste extends Exception{
    public UtilizadorNaoExiste(){
        super();
    }

    public UtilizadorNaoExiste(String mensagem){
        super(mensagem);
    }
}
