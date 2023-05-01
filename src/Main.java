package src;

import Exceptions.UtilizadorJaExistente;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws UtilizadorJaExistente {
        Vintage vintage;
        String ficheiroDados = "ficheiro.dat";
        Serializacao ficheiro = new Serializacao(ficheiroDados);

        if(!ficheiro.getFicheiro().exists()){
            vintage = new Vintage();
            vintage.getListaUtilizadores().addUtilizador(new Utilizador("email","Peixoto","Avenida das Cruzes Frades",309144557));
            System.out.println("O ficheiro nao existe \n");
        }
        else {
            System.out.println("O ficheiro existe \n");
            vintage = ficheiro.carregar();
        }

        if(vintage.getListaUtilizadores().existeUtilizador("email"))
            System.out.print("cheguei aqui");


        vintage.salvaFicheirosDados(ficheiro);
    }

}
