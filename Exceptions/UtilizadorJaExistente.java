package Exceptions;

public class UtilizadorJaExistente extends Exception {
    public UtilizadorJaExistente(){
        super();
    }
    public UtilizadorJaExistente(String mensagem){
        super(mensagem);
    }
}
