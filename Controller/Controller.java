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

    public void encerrar(){ // TODO

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
                String codigo = Input.getCodigo();
                vintage.removeArtigo(codigo);
                this.artigos();
                break;
            case 3:
                vintage.listarArtigos(); //TODO na vintage
                this.artigos();
                break;
            case 0:
                this.menuUtilizador();
                break;
        }
    }

    public void criarArtigo(){
        int opcao = this.m.menu("Criar Artigo", IO.opcoesMenuCriarArtigo);

        switch (opcao){
            case 1:
                this.adicionarSapatilha();
                break;
            case 2:
                vintage.criaTShirt();
                this.criarArtigo();
                break;
            case 3:
                this.adicionarMala();
                break;
            case 0:
                this.artigos();
                break;
        }
    }

    public void adicionarSapatilha(){
        int opcao = this.m.menu("Adicionar Sapatilha", IO.opcoesMenuSapatilhaPeremium);

        switch (opcao){
            case 1:
                vintage.criaSapatilha();
                this.artigos();
                break;
            case 2:
                vintage.criaSapatilhaPremium();
                this.artigos();
                break;
            case 0:
                this.criarArtigo();
                break;
        }
    }

    public void adicionarMala(){
        int opcao = this.m.menu("Adicionar Mala", IO.opcoesMenuMalaPeremium);

        switch (opcao){
            case 1:
                vintage.criaMala();
                this.artigos();
                break;
            case 2:
                vintage.criaMalaPremium();
                this.artigos();
                break;
            case 0:
                this.criarArtigo();
                break;
        }
    }

    public void encomendas(){
        int opcao = this.m.menu("Encomendas", IO.opcoesMenuEncomendas);

        switch (opcao){
            case 1:
                this.criarEncomenda();
                break;
            case 2:
                this.removerEncomenda();
                break;
            case 3:
                vintage.listarEncomendas(); //TODO na vintage
                this.encomendas();
                break;
            case 0:
                this.menuUtilizador();
                break;
        }
    }

    public void criarEncomenda(){ //rever toda esta parte da criacao de encomendas com o Peixoto
        int opcao = this.m.menu("Criar Encomenda", IO.opcoesMenuCriarEncomenda);

        switch (opcao){
            case 1:
                //vintage.f(); TODO funcao que adiciona artigo á Encomenda
                this.criarEncomenda();
                break;
            case 2:
                vintage.concluirEncomenda();//TODO na vintage
                this.encomendas();
                break;
            case 0:
                this.criarEncomenda(); //OU não é possivel voltar atras
                                        //OU é adicionada ao menu uma opcao para cancelar a encomenda
                                        // OU quando volta cancela a encomenda
                break;
        }
    }


    public void removerEncomenda(){
        int opcao = this.m.menu("Remover Encomenda", IO.opcoesMenuRmEncomendas);

        switch (opcao){
            case 1:
                vintage.removeEncomenda(); //removeEncomenda != cancelaEncomenda??
                this.encomendas();
                break;
            case 0:
                this.encomendas();
                break;
        }
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
