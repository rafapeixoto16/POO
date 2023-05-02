package Controller;

import Exceptions.UtilizadorJaExistente;
import src.Serializacao;
import src.Utilizador;
import src.Vintage;

public class Controller {
    private static final String ficheiroDados = "ficheiro.dat";
    private Vintage vintage;
    private Serializacao ficheiro;
     public Controller() {
        this.ficheiro = new Serializacao(ficheiroDados);
        this.vintage = new Vintage();
     }
     public void run(){

     }
}
