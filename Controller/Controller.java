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
         if(this.ficheiro.getFicheiro().exists())
            this.vintage = ficheiro.carregar();

         else
             Vintage.setDataAtual(LocalDate.now());

         try {
             out.print(" "+ Artigo.getNumeroArtigos()+"\n");
             vintage.getListaArtigos().addArtigo(new Mala(true,1,10,"Cavalinho",70,4,"couro", LocalDate.of(2023,1,1),"mail"));
             out.print(" "+ Artigo.getNumeroArtigos()+"\n");
             out.print(" "+ Transportadora.numeroTransp() + "\n");
             out.println(" "+Vintage.dataAtual());
             Vintage.incDia();
             this.ficheiro.guardar(this.vintage);
         }catch (Exception ignored){

         }
     }
}
