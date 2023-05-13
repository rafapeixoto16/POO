package Controller;

import Serializacao.Serializacao;
import View.Input;
import model.Artigo;
import model.Mala;
import model.Transportadora;
import model.Vintage;
import model.ListaUtilizadores;

import View.IO;

import java.io.Serial;
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
        this.m = new IO();
     }
     public void inicializador(){
         if(this.ficheiro.getFicheiro().exists())
            this.vintage = ficheiro.carregar();
         else{
             Vintage.setDataAtual(LocalDate.now());
             Vintage.setDinheiroGanho(0);
         }
         this.run();
     }

     public void run(){
         int opcao = this.m.menu2("Menu Principal", IO.opcoesMenuPrincipal);
         switch (opcao){
             case 1:
                 if (this.vintage.login())
                     this.menuUtilizador();
                 else
                     this.run();
                 break;
             case 2:
                 this.sigIn();
                 break;
             case 3:
                 ficheiro.guardar(vintage);
                 break;
         }
     }

    public void sigIn(){
         vintage.criaUtilizador();
         this.run();
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
            case 7:
                out.print(vintage.getUserLigado().toString());
                this.menuUtilizador();
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
                out.println(vintage.getUserLigado().listaArtigosPorVender());
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
                this.artigos();
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
                vintage.criaEncomenda();
                this.encomendas();
                break;
            case 2:
                int codigo = Input.getCodEncomenda();
                vintage.cancelaEncomenda(codigo);
                this.encomendas();
                break;
            case 3:
                vintage.listarEncomendaUser();
                this.encomendas();
                break;
            case 0:
                this.menuUtilizador();
                break;
        }
    }



    public void transportadoras(){
        int opcao = this.m.menu("Transportadoras", IO.opcoesMenuTransportadoras);

        switch (opcao){
            case 1:
                this.criarTransportadora();
                break;
            case 2:
                vintage.listaTransportadoras();
                this.transportadoras();
                break;
            case 3:
                vintage.alterarImposto();
                this.transportadoras();
                break;
            case 4:
                //vintage. todo funcao para alterar a formula da transportadora
                this.transportadoras();
                break;
            case 0:
                this.menuUtilizador();
                break;
        }
    }

    public void criarTransportadora(){
        int opcao = this.m.menu("Criar Transportadora", IO.opcoesMenuCriarTransportadora);

        switch (opcao){
            case 1:
                vintage.criaTransportadora();
                this.transportadoras();
                break;
            case 2:
                vintage.criaTransportadoraPremium();
                this.transportadoras();
                break;
            case 0:
                this.transportadoras();
                break;
        }
    }

    public void faturas(){
        int opcao = this.m.menu("Faturas", IO.opcoesMenuFaturas);

        switch (opcao){
            case 1:
                vintage.listaFaturasComprado();
                this.faturas();
                break;
            case 2:
                vintage.listaFaturasVendas();
                this.faturas();
                break;
            case 0:
                this.menuUtilizador();
                break;
        }
    }

    public void estatisticas(){
        int opcao = this.m.menu("Estatisticas", IO.opcoesMenuEstatisticas);

        switch (opcao){
            case 1:
                this.pTempo();
                break;
            case 2:
                //TODO "Transportadora com maior volume de faturação",
                this.estatisticas();
                break;
            case 3:
                //TODO "Listar as encomendas emitidas por um vendedor"
                String email = Input.getEmail();
                this.vintage.listarEncomendaUser(email);
                break;
            case 4:
                LocalDate data = Input.getDate("Insira uma data de inicio");
                LocalDate date1 = Input.getDate("Insira a data termino");
                this.vintage.getAllFaturasClienteOrdenar(data,date1);
                break;
            case 5:
                LocalDate data2 = Input.getDate("Insira uma data de inicio");
                LocalDate date3 = Input.getDate("Insira a data termino");
                this.vintage.getAllFaturasVendedorOrdenar(data2,date3);
                break;
            case 6:
                out.println(Vintage.getDinheiroGanho());
                break;
            case 0:
                this.menuUtilizador();
                break;
        }
    }

    public void pTempo(){
        int opcao = this.m.menu("Período", IO.opcoesMenuDesdeSemprePeriodo);

        switch (opcao){
            case 1:
                this.vintage.getAllFaturasVendedorTopOrdenar();
                this.estatisticas();
                break;
            case 2:
                LocalDate data1 = Input.getDate("Insira a data de inicio.");
                LocalDate data2 = Input.getDate("Insira a data de termino.");
                this.vintage.getAllFaturasVendedorTopOrdenar(data1,data2);
                this.estatisticas();
                break;
            case 0:
                this.estatisticas();
                break;
        }
    }


    public void tempo(){
        vintage.avancoTemporal();
        this.menuUtilizador();
    }

}
