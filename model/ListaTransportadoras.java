package model;

import Exceptions.TransportadoraJaExistente;
import Exceptions.TransportadoraNaoExiste;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static View.Input.getCodigoTransportadora;
import static View.Input.getImposto;
import static java.lang.System.out;

public class ListaTransportadoras implements Serializable {
    private final Map<Integer, Transportadora> listaTransportadoras;
    public ListaTransportadoras(){
        this.listaTransportadoras = new HashMap<>();
    }
    public ListaTransportadoras(ListaTransportadoras listas){
        this.listaTransportadoras = new HashMap<>();
        for (Transportadora transportadora: listas.listaTransportadoras.values()){
            this.listaTransportadoras.put(transportadora.getCodTransportadora(),transportadora.clone());
        }
    }
    public Map<Integer, Transportadora> getTransportadorasMap(){
        return listaTransportadoras;
    }
    public void addTransportadora (Transportadora transportadora) throws TransportadoraJaExistente {
        if(transportadora == null){
            throw new NullPointerException("A transportadora nao pode ser um valor nulo");
        }
        if(listaTransportadoras.containsKey(transportadora.getCodTransportadora())){
            throw new TransportadoraJaExistente("A transportadora ja existe");
        }
        listaTransportadoras.put(transportadora.getCodTransportadora(),transportadora.clone());
    }
    public boolean existeTransportadora(Integer codigo){
        return listaTransportadoras.containsKey(codigo);
    }
    public void removeTransportadora(Integer codigo) throws TransportadoraNaoExiste {
        if(codigo == null){
            throw new NullPointerException("O campo codigo encontra-se vazio");
        }
        else if (!existeTransportadora(codigo)) {
            throw new TransportadoraNaoExiste("A transportadora com codigo "+ codigo + " nao existe");
        }
        listaTransportadoras.remove(codigo);
    }

    public Transportadora getTransportadoraLista(Integer codigo) throws TransportadoraNaoExiste {
        if(codigo == null){
            throw new NullPointerException("O campo codigo encontra-se vazio");
        }
        else if (!existeTransportadora(codigo)) {
            throw new TransportadoraNaoExiste("A transportadora com codigo "+ codigo + " nao existe");
        }
        return listaTransportadoras.get(codigo).clone();
    }

    public List<Transportadora> getTransportadorasList(){
        return new ArrayList<>(listaTransportadoras.values());
    }

    public int numeroTransportadoras(){
        return listaTransportadoras.size();
    }

    @Override
    public String toString(){
        return "Lista de transportadoras{"+"lista = "+listaTransportadoras+ '}';
    }

    @Override
    public ListaTransportadoras clone(){
        return new ListaTransportadoras(this);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if ((o == null) || (this.getClass() != o.getClass())) return false;

        ListaTransportadoras transportadoras= (ListaTransportadoras) o;
        return this.getTransportadorasList().equals(transportadoras.getTransportadorasList());
    }


    public void alterarImposto(int idTransp){
        if(listaTransportadoras.containsKey(idTransp) ){
            Transportadora l = listaTransportadoras.get(idTransp);
            l.setImposto(getImposto());
            return;
        }
        out.println("A transportadora com id " + idTransp + " nao existe");
    }

}
