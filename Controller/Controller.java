package Controller;

import Serializacao.Serializacao;
import View.Input;
import model.Artigo;
import model.Mala;
import model.Transportadora;
import model.Vintage;
import model.ListaUtilizadores;

import View.IO;

import java.time.LocalDate;

import static java.lang.System.out;

public class Controller {
    private static final String ficheiroDados = "ficheiro.dat";
    private Vintage vintage;
    private IO m;
    private final Serializacao ficheiro;
     public Controller() {
        this.ficheiro = new Serializacao(ficheiroDados);
        this.vintage = new Vintage();
     }
     public void inicializador(){
         if(this.ficheiro.getFicheiro().exists())
            this.vintage = ficheiro.carregar();
         else
             Vintage.setDataAtual(LocalDate.now());
         this.run();
     }

     public void run(){
         int opcao = this.m.menu("Menu Principal", IO.opcoesMenuPrincipal);
         switch (opcao){
             case 1:
                 this.logIn();
                 break;
             case 2:
                 this.sigIn();
                 break;
             case 0:
                 this.encerrar();
                 break;
         }
     }
    public void logIn(){
         int opcao = this.m.menu("Log In", IO.opcoesMenuLogIn);

         switch (opcao){
             case 1:
                 String mail = Input.getEmail();
                 vintage.login(mail);
                 this.menuUtilizador();
                 break;
             case 0:
                 this.run();
                 break;
         }
    }

    public void sigIn(){
         vintage.criaUtilizador();
         this.run();
    }

    public void encerrar(){

    }

    public void menuUtilizador(){
        int opcao = this.m.menu("Menu do Utilizador", IO.opcoesMenuUtilizador);

        switch (opcao){
            case 1:
                this.artigos();
                break;
            case 2:
                this.encomendas();
                break;
            case 3:
                this.transportadoras();
                break;
            case 4:
                this.faturas();
                break;
            case 5:
                this.estatisticas();
                break;
            case 6:
                this.tempo();
                break;
            case 0:
                this.run();
                break;
        }
    }

    public void artigos(){
        int opcao = this.m.menu("Menu de Artigos", IO.opcoesMenuArtigos);

        switch (opcao){
            case 1:
                this.criarArtigo();
                break;
            case 2:
                vintage.removeArtigo();
                this.artigos();
                break;
            case 3:

        }
    }

    public void criarArtigo(){

    }

    public void encomendas(){

    }

    public void transportadoras(){

    }

    public void faturas(){

    }

    public void estatisticas(){

    }

    public void tempo(){

    }
}
