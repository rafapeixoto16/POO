package Controller;

import Serializacao.Serializacao;
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
