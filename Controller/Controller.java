package Controller;

import Exceptions.UtilizadorJaExistente;
import Serializacao.Serializacao;
import model.Artigo;
import model.Mala;
import model.Utilizador;
import model.Vintage;

import java.time.LocalDate;

import static java.lang.System.out;

public class Controller {
    private static final String ficheiroDados = "ficheiro.dat";
    private Vintage vintage;
    private Serializacao ficheiro;
     public Controller() {
        this.ficheiro = new Serializacao(ficheiroDados);
        this.vintage = new Vintage();
     }
     public void run(){
         this.vintage = ficheiro.carregar();
         try {
             this.vintage.getListaArtigos().addArtigo(new Mala(true,1,10,"Cavalinho",70,4,"couro", LocalDate.of(2023,1,1),"mail2"));
             out.print(" "+ Artigo.getNumeroArtigos()+"\n");
             this.ficheiro.guardar(this.vintage);
         }catch (Exception ignored){

         }
     }
}
