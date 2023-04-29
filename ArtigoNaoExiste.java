public class ArtigoNaoExiste extends Exception{
    public ArtigoNaoExiste(){
        super();
    }

    public ArtigoNaoExiste(String mensagem){
        super(mensagem);
    }
}
