package src;

import java.io.Serializable;
import java.util.Map;

public class ListaFaturas implements Serializable {
    private Map<Integer,FaturaVendedor> ListaFaturasVenderores;
    private Map<Integer,FaturaCliente> ListaFaturasClientes;



}
