package src;

import java.io.Serializable;
import java.util.*;

public class ListaFaturas implements Serializable {
    private final Map<String, List<FaturaVendedor>> listaFaturasVenderores;
    private final Map<String, List<FaturaCliente>> listaFaturasClientes;

    public ListaFaturas() {
        this.listaFaturasVenderores = new HashMap<>();
        this.listaFaturasClientes = new HashMap<>();
    }

    public ListaFaturas(Map<String, List<FaturaVendedor>> listaFaturasVenderores, Map<String, List<FaturaCliente>> listaFaturasClientes) {
        this.listaFaturasVenderores = new HashMap<>();
        for (String i : listaFaturasVenderores.keySet()) {
            List<FaturaVendedor> lista = new ArrayList<>();
            for (FaturaVendedor e : listaFaturasVenderores.get(i)) {
                lista.add(e.clone());
            }
            this.listaFaturasVenderores.put(i, lista);
        }

        this.listaFaturasClientes = new HashMap<>();
        for (String i : listaFaturasClientes.keySet()) {
            List<FaturaCliente> lista2 = new ArrayList<>();
            for (FaturaCliente e : listaFaturasClientes.get(i)) {
                lista2.add(e.clone());
            }
            this.listaFaturasClientes.put(i, lista2);
        }
    }

    public ListaFaturas(ListaFaturas listaFaturas) {
        this.listaFaturasVenderores = new HashMap<>();
        for (String i : listaFaturas.listaFaturasVenderores.keySet()) {
            List<FaturaVendedor> lista = new ArrayList<>();
            for (FaturaVendedor e : listaFaturas.listaFaturasVenderores.get(i)) {
                lista.add(e.clone());
            }
            this.listaFaturasVenderores.put(i, lista);
        }

        this.listaFaturasClientes = new HashMap<>();
        for (String i : listaFaturas.listaFaturasClientes.keySet()) {
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

    public void removeFaturaCliente(String email, List<FaturaCliente> lista) {
        listaFaturasClientes.get(email).removeAll(lista);
    }

    public void removeFaturaCliente(String email, FaturaCliente faturaCliente) {
        listaFaturasClientes.get(email).remove(faturaCliente);
    }

    public void addFaturaCliente(String email, List<FaturaCliente> lista) {
        if (listaFaturasClientes.containsKey(email)) {
            for (FaturaCliente a : lista)
                listaFaturasClientes.get(email).add(a.clone());
        } else {
            List<FaturaCliente> lista2 = new ArrayList<>();
            for (FaturaCliente a : lista)
                listaFaturasClientes.get(email).add(a.clone());

            listaFaturasClientes.put(email,lista2);
        }

    }
    public void addFaturaCliente(String email,FaturaCliente faturaCliente)
    {
        if (listaFaturasClientes.containsKey(email)) {
            listaFaturasClientes.get(email).add(faturaCliente.clone());
        }
        else {
            List<FaturaCliente> lista2 = new ArrayList<>();
            lista2.add(faturaCliente);
            listaFaturasClientes.put(email,lista2);
        }
    }

    public boolean existeFaturaCliente(String email,FaturaCliente cliente){
        return listaFaturasClientes.get(email).contains(cliente);
    }

    public void removeFaturaVendedor(String email,FaturaVendedor faturaVendedor) {
        listaFaturasVenderores.get(email).remove(faturaVendedor);
    }

    public void removeFaturaVendedor(String email,List<FaturaVendedor> lista){
        listaFaturasVenderores.get(email).removeAll(lista);
    }

    public void addFaturaVendedor(String email, List<FaturaVendedor> lista) {
        if (listaFaturasVenderores.containsKey(email)) {
            for (FaturaVendedor a : lista)
                listaFaturasVenderores.get(email).add(a.clone());
        } else {
            List<FaturaVendedor> lista2 = new ArrayList<>();
            for (FaturaVendedor a : lista)
                listaFaturasVenderores.get(email).add(a.clone());

            listaFaturasVenderores.put(email,lista2);
        }
    }

    public void addFaturaVendedor(String email,FaturaVendedor faturaVendedor){
        if (listaFaturasVenderores.containsKey(email)) {
            listaFaturasVenderores.get(email).add(faturaVendedor.clone());
        }
        else {
            List<FaturaVendedor> lista2 = new ArrayList<>();
            lista2.add(faturaVendedor);
            listaFaturasVenderores.put(email,lista2);
        }
    }

    public boolean existeFaturaVendedor(String email,FaturaVendedor faturaVendedor){
        return listaFaturasVenderores.get(email).contains(faturaVendedor);
    }

    @Override
    public String toString(){
        return "Vendedores: "+listaFaturasVenderores.toString()+"\n"
                +"Clientes: "+listaFaturasClientes.toString();
    }




}