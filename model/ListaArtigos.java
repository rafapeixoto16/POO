package model;

import Exceptions.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class ListaArtigos implements Serializable {
    private final Map<String, Artigo> listaArtigos;
    public ListaArtigos(){
        this.listaArtigos = new HashMap<>();
    }
    public ListaArtigos(ListaArtigos listas){
        this.listaArtigos = new HashMap<>();
        for (Artigo artigo : listas.listaArtigos.values()){
            this.listaArtigos.put(artigo.getCodigo(),artigo.clone());
        }
    }
    public Map<String, Artigo> getArtigosMap(){
        return listaArtigos;
    }

    public void addArtigo(Artigo artigo) {
        if(artigo == null)
            throw new NullPointerException("O artigo nao pode ser um valor nulo");

        listaArtigos.put(artigo.getCodigo(),artigo.clone());
    }
    public boolean existeArtigo(String codigo){
        return listaArtigos.containsKey(codigo);
    }
    public void removeArtigo(String codigo) throws ArtigoNaoExiste {
        if(codigo == null || codigo.isEmpty()){
            throw new NullPointerException("O campo codigo encontra-se vazio");
        }
        else if (!existeArtigo(codigo)) {
            throw new ArtigoNaoExiste("O artigo com codigo"+ codigo + "nao existe");
        }
        listaArtigos.remove(codigo);
    }

    public Artigo getArtigoLista(String codigo) throws ArtigoNaoExiste{
        if(codigo.isEmpty()){
            throw new NullPointerException("O campo codigo encontra-se vazio");
        }
        else if (!existeArtigo(codigo)) {
            throw new ArtigoNaoExiste("O artigo com codigo"+ codigo + "nao existe");
        }
        return listaArtigos.get(codigo).clone();
    }

    public List<Artigo> getArtigosList(){
        return new ArrayList<>(listaArtigos.values());
    }

    public int numeroArtigos(){
        return listaArtigos.size();
    }

    @Override
    public String toString(){
        return "Lista de Artigos:\n"+listaArtigos;
    }

    @Override
    public ListaArtigos clone(){
        return new ListaArtigos(this);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if ((o == null) || (this.getClass() != o.getClass())) return false;

        ListaArtigos umArtigo = (ListaArtigos) o;
        return this.getArtigosList().equals(umArtigo.getArtigosList());
    }
}
