package View;

import static java.lang.System.out;
public class IO {

    public static final String[] opcoesMenuPrincipal = {
            "Log In",
            "Sig In",
            "Encerrar Programa (grava automáticamente)",
    };

    public static final String[] opcoesMenuLogIn = {
            "Inserir Email",
    };


    public static final String[] opcoesMenuUtilizador = {
            "Artigos",
            "Encomendas",
            "Transportadoras",
            "Faturas",
            "Estatisticas",
            "Tempo"
    };


    public static final String[] opcoesMenuArtigos = {
            "Criar Artigo",
            "Remover Artigo",
            "Listar Artigos",
    };

    public static final String[] opcoesMenuCriarArtigo = {
            "Adicionar Sapatilha",
            "Adicionar T-Shirt",
            "Adicionar Mala",
    };

    public static final String[] opcoesMenuSapatilhaPeremium = {
            "Sapatilha Normal",
            "Sapatilha Premium",
    };

    public static final String[] opcoesMenuMalaPeremium = {
            "Mala Normal",
            "Mala Premium",
    };


    public static final String[] opcoesMenuEncomendas = {
            "Criar Encomenda",
            "Remover Encomendas",
            "Listar Encomendas",
    };

    public static final String[] opcoesMenuCriarEncomenda = {
            "Adicionar Artigo à Encomenda (código)",
            "Concluir Encomenda",
            //"Cancelar Encomenda"
    };
    public static final String[] opcoesMenuRmEncomendas = {
            "Código da Encomenda para ser removida",
    };

    public static final String[] opcoesMenuTransportadoras = {
            "Criar Transportadora",
            "Alterar Imposto de Transportadorta",
    };

    public static final String[] opcoesMenuCriarTransportadora = {
            "Transportadora Normal",
            "Transportadora Premium",
    };

    public static final String[] opcoesMenuFaturas = { //TODO

    };


    public static final String[] opcoesMenuEstatisticas = { //TODO
            "Vendedor que mais faturou",
            "Transportadora com maior volume de faturação",
            "", //listar as encomendas emitidas por um vendedor
            "Maiores Compradores",
            "Maiores Vendedores",
            "Faturação da Vintage",
    };


    public static final String[] opcoesMenuTempo = { //TODO

    };



    public int menu(String titulo, String[] opcoes) {

        Menu menu = new Menu(titulo, opcoes);
        menu.executa();
        out.println("\n");
        return menu.getOpcao();
    }


    public static void error(String error) {
        System.out.println("\nError: " + error);
    }
}
