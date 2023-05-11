package model;

import Exceptions.UtilizadorJaExistente;
import Exceptions.UtilizadorNaoExiste;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaUtilizadores implements Serializable {
    private final Map<String, Utilizador> listaUtilizadores;
    public ListaUtilizadores(){
        this.listaUtilizadores = new HashMap<>();
    }
    public ListaUtilizadores(ListaUtilizadores listaUtilizadores){
        this.listaUtilizadores = new HashMap<>();
        for (Utilizador utilizador : listaUtilizadores.listaUtilizadores.values()){
            this.listaUtilizadores.put(utilizador.getEmail(),utilizador.clone());
        }
    }
    public Map<String, Utilizador> getUtilizadores(){
        return listaUtilizadores;
    }

    public void addUtilizador(Utilizador utilizador) throws UtilizadorJaExistente {
        if(utilizador == null){
            throw new NullPointerException("O utilizador nao pode ser um valor nulo");
        }
        if(listaUtilizadores.containsKey(utilizador.getEmail())){
            throw new UtilizadorJaExistente("O utilizador ja existe");
        }
        listaUtilizadores.put(utilizador.getEmail(),utilizador.clone());
    }

    public Utilizador getUtilizador(String email){
        return listaUtilizadores.get(email);
    }

    public boolean existeUtilizador(String codigo){
        return listaUtilizadores.containsKey(codigo);
    }
    public void removeArtigo(String codigo) throws UtilizadorNaoExiste {
        if(codigo == null){
            throw new NullPointerException("O campo codigo encontra-se vazio");
        }
        else if (!existeUtilizador(codigo)) {
            throw new UtilizadorNaoExiste("O utilizador com email"+ codigo + "nao existe");
        }
        listaUtilizadores.remove(codigo);
    }

    public Utilizador getUtilizadorLista(String codigo) throws UtilizadorNaoExiste{
        if(codigo.isEmpty()){
            throw new NullPointerException("O campo codigo encontra-se vazio");
        }
        else if (!existeUtilizador(codigo)) {
            throw new UtilizadorNaoExiste("O utilizador com email "+ codigo + " nao existe");
        }
        return listaUtilizadores.get(codigo);
    }

    public List<Utilizador> getUtilizadoresList(){
        return new ArrayList<>(listaUtilizadores.values());
    }

    public int numeroUtilizadores(){
        return listaUtilizadores.size();
    }

    @Override
    public String toString(){
        return "Lista de utilizadores{"+"lista = "+listaUtilizadores+ '}';
    }

    @Override
    public ListaUtilizadores clone(){
        return new ListaUtilizadores(this);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if ((o == null) || (this.getClass() != o.getClass())) return false;

        ListaUtilizadores listaUtilizadores1 = (ListaUtilizadores) o;
            return this.getUtilizadoresList().equals(listaUtilizadores1.getUtilizadoresList());
    }


}
