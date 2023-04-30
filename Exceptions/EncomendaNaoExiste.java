package Exceptions;

public class EncomendaNaoExiste extends Exception {
    public EncomendaNaoExiste(){
        super();
    }

    public EncomendaNaoExiste(String mensagem){
        super(mensagem);
    }
}
