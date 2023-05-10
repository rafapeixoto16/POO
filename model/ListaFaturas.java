package model;

import java.io.Serializable;
import java.util.*;

public class ListaFaturas implements Serializable {
    private final Map<Integer, List<FaturaVendedor>> listaFaturasVenderores;
    private final Map<Integer, List<FaturaCliente>> listaFaturasClientes;

    public ListaFaturas() {
        this.listaFaturasVenderores = new HashMap<>();
        this.listaFaturasClientes = new HashMap<>();
    }

    public ListaFaturas(Map<Integer, List<FaturaVendedor>> listaFaturasVenderores, Map<Integer, List<FaturaCliente>> listaFaturasClientes) {
        this.listaFaturasVenderores = new HashMap<>();
        for (Integer i : listaFaturasVenderores.keySet()) {
            List<FaturaVendedor> lista = new ArrayList<>();
            for (FaturaVendedor e : listaFaturasVenderores.get(i)) {
                lista.add(e.clone());
            }
            this.listaFaturasVenderores.put(i, lista);
        }

        this.listaFaturasClientes = new HashMap<>();
        for (Integer i : listaFaturasClientes.keySet()) {
            List<FaturaCliente> lista2 = new ArrayList<>();
            for (FaturaCliente e : listaFaturasClientes.get(i)) {
                lista2.add(e.clone());
            }
            this.listaFaturasClientes.put(i, lista2);
        }
    }

    public ListaFaturas(ListaFaturas listaFaturas) {
        this.listaFaturasVenderores = new HashMap<>();
        for (Integer i : listaFaturas.listaFaturasVenderores.keySet()) {
            List<FaturaVendedor> lista = new ArrayList<>();
            for (FaturaVendedor e : listaFaturas.listaFaturasVenderores.get(i)) {
                lista.add(e.clone());
            }
            this.listaFaturasVenderores.put(i, lista);
        }

        this.listaFaturasClientes = new HashMap<>();
        for (Integer i : listaFaturas.listaFaturasClientes.keySet()) {
            List<FaturaCliente> lista2 = new ArrayList<>();
            for (FaturaCliente e : listaFaturas.listaFaturasClientes.get(i)) {
                lista2.add(e.clone());
            }
            this.listaFaturasClientes.put(i, lista2);
        }
    }

    @Override
    public ListaFaturas clone() {
        return new ListaFaturas(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaFaturasVenderores, listaFaturasClientes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || o.getClass() != this.getClass())
            return false;

        ListaFaturas listaFaturas = (ListaFaturas) o;
        return listaFaturas.listaFaturasClientes.equals(this.listaFaturasClientes) && this.listaFaturasVenderores.equals(listaFaturas.listaFaturasVenderores);
    }

    public void removeFaturaCliente(Integer idEncomenda, List<FaturaCliente> lista) {
        listaFaturasClientes.get(idEncomenda).removeAll(lista);
    }

    public void removeFaturaCliente(Integer idEncomenda) {
        listaFaturasClientes.remove(idEncomenda);
    }

    public void addFaturaCliente(Integer idEncomenda, List<FaturaCliente> lista) {
        if (listaFaturasClientes.containsKey(idEncomenda)) {
            for (FaturaCliente a : lista)
                listaFaturasClientes.get(idEncomenda).add(a.clone());
        } else {
            List<FaturaCliente> lista2 = new ArrayList<>();
            for (FaturaCliente a : lista)
                listaFaturasClientes.get(idEncomenda).add(a.clone());

            listaFaturasClientes.put(idEncomenda,lista2);
        }

    }
    public void addFaturaCliente(Integer idEncomenda,FaturaCliente faturaCliente)
    {
        if (listaFaturasClientes.containsKey(idEncomenda)) {
            listaFaturasClientes.get(idEncomenda).add(faturaCliente.clone());
        }
        else {
            List<FaturaCliente> lista2 = new ArrayList<>();
            lista2.add(faturaCliente);
            listaFaturasClientes.put(idEncomenda,lista2);
        }
    }

    public boolean existeFaturaCliente(Integer idEncomenda,FaturaCliente cliente){
        return listaFaturasClientes.get(idEncomenda).contains(cliente);
    }

    public void removeFaturaVendedor(Integer idEncomenda) {
        listaFaturasVenderores.remove(idEncomenda);
    }

    public void removeFaturaVendedor(Integer idEncomenda,List<FaturaVendedor> lista){
        listaFaturasVenderores.get(idEncomenda).removeAll(lista);
    }

    public void addFaturaVendedor(Integer idEncomenda, List<FaturaVendedor> lista) {
        if (listaFaturasVenderores.containsKey(idEncomenda)) {
            for (FaturaVendedor a : lista)
                listaFaturasVenderores.get(idEncomenda).add(a.clone());
        } else {
            List<FaturaVendedor> lista2 = new ArrayList<>();
            for (FaturaVendedor a : lista)
                listaFaturasVenderores.get(idEncomenda).add(a.clone());

            listaFaturasVenderores.put(idEncomenda,lista2);
        }
    }

    public void addFaturaVendedor(Integer idEncomenda, FaturaVendedor faturaVendedor){
        if (listaFaturasVenderores.containsKey(idEncomenda)) {
            listaFaturasVenderores.get(idEncomenda).add(faturaVendedor.clone());
        }
        else {
            List<FaturaVendedor> lista2 = new ArrayList<>();
            lista2.add(faturaVendedor);
            listaFaturasVenderores.put(idEncomenda,lista2);
        }
    }

    public boolean existeFaturaVendedor(Integer idEncomenda,FaturaVendedor faturaVendedor){
        return listaFaturasVenderores.get(idEncomenda).contains(faturaVendedor);
    }

    @Override
    public String toString(){
        return "Vendedores: "+ listaFaturasVenderores.toString()+"\n"
                +"Clientes: "+ listaFaturasClientes.toString();
    }

}