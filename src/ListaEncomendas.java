package src;


import Exceptions.EncomendaJaExistente;
import Exceptions.EncomendaNaoExiste;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaEncomendas implements Serializable {
    private final Map<Integer, Encomenda> listaEncomendas;

    public ListaEncomendas(){
        this.listaEncomendas = new HashMap<>();
    }
    public ListaEncomendas(ListaEncomendas listas){
        this.listaEncomendas = new HashMap<>();
        for (Encomenda encomenda: listas.listaEncomendas.values()){
            this.listaEncomendas.put(encomenda.getCodEnc(),encomenda.clone());
        }
    }
    public Map<Integer, Encomenda> getEncomendasMap(){
        return listaEncomendas;
    }
    public void addEncomenda (Encomenda encomenda) throws EncomendaJaExistente {
        if(encomenda == null){
            throw new NullPointerException("A encomenda nao pode ser um valor nulo");
        }
        if(listaEncomendas.containsKey(encomenda.getCodEnc())){
            throw new EncomendaJaExistente("A encomenda ja existe");
        }

        listaEncomendas.put(encomenda.getCodEnc(),encomenda.clone());
    }
    public boolean existeEncomenda(Integer codigo){
        return listaEncomendas.containsKey(codigo);
    }
    public void removeEncomenda(Integer codigo) throws EncomendaNaoExiste{
        if(codigo == null){
            throw new NullPointerException("O campo codigo encontra-se vazio");
        }
        else if (!existeEncomenda(codigo)) {
            throw new EncomendaNaoExiste("A encomenda com codigo "+ codigo + " nao existe");
        }
        listaEncomendas.remove(codigo);
    }

    public Encomenda getEncomendaLista(Integer codigo) throws EncomendaNaoExiste {
        if(codigo == null){
            throw new NullPointerException("O campo codigo encontra-se vazio");
        }
        else if (!existeEncomenda(codigo)) {
            throw new EncomendaNaoExiste("A encomenda com codigo "+ codigo + " nao existe");
        }
        return listaEncomendas.get(codigo).clone();
    }

    public List<Encomenda> getEncomendasList(){
        return new ArrayList<>(listaEncomendas.values());
    }

    public int numeroEncomendas(){
        return listaEncomendas.size();
    }

    @Override
    public String toString(){
        return "Lista de encomendas{"+"lista = "+listaEncomendas+ '}';
    }

    @Override
    public ListaEncomendas clone(){
        return new ListaEncomendas(this);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if ((o == null) || (this.getClass() != o.getClass())) return false;

        ListaEncomendas encomendas= (ListaEncomendas) o;
        return this.getEncomendasList().equals(encomendas.getEncomendasList());
    }
}
