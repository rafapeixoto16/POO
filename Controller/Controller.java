package Controller;

import Serializacao.Serializacao;
import model.Artigo;
import model.Mala;
import model.Transportadora;
import model.Vintage;

import java.time.LocalDate;

import static java.lang.System.out;

public class Controller {
    private static final String ficheiroDados = "ficheiro.dat";
    private Vintage vintage;
    private final Serializacao ficheiro;
     public Controller() {
        this.ficheiro = new Serializacao(ficheiroDados);
        this.vintage = new Vintage();
     }
     public void run(){
         if(ficheiro.getFicheiro().exists())
            this.vintage = ficheiro.carregar();

         else {

         }

         try {
             out.print(" "+ Artigo.getNumeroArtigos()+"\n");
             out.print(" "+ Transportadora.numeroTransp());
             this.ficheiro.guardar(this.vintage);
         }catch (Exception ignored){

         }
     }
}
