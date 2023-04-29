import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ListaArtigos implements Serializable {
    private final Map<String,Artigo> listaArtigos;

    public ListaArtigos(){
        this.listaArtigos = new HashMap<>();
    }

    public ListaArtigos(ListaArtigos listas){
        this.listaArtigos = new HashMap<>();
        for (Artigo artigo : listas.listaArtigos.values()){
            this.listaArtigos.put(artigo.getCodigo(),artigo.clone());
        }
    }
    public Map<String,Artigo> getListaArtigos(){
        return listaArtigos;
    }

    public void addArtigo(Artigo artigo) throws ArtigoJaExistente {
        if(artigo == null){
            throw new NullPointerException("O artigo nao pode ser um valor nulo");
        }
        if(listaArtigos.containsKey(artigo.getCodigo())){
            throw new ArtigoJaExistente("O artigo ja existe");
        }
        else
        {
            listaArtigos.put(artigo.getCodigo(),artigo.clone());
        }
    }
    public boolean existeArtigo(String codigo){
        return listaArtigos.containsKey(codigo);
    }





}
