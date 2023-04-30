package Exceptions;

public class EncomendaJaExistente extends Exception {
    public EncomendaJaExistente(){
        super();
    }

    public EncomendaJaExistente(String mensagem){
        super(mensagem);
    }
}
