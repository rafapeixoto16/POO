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

    public static final String[] opcoesMenuSigIn = {//TODO acho que não é preciso

    };

    public static final String[] opcoesMenuUtilizador = {
            "Artigos",
            "Encomendas",
            "Transportadoras",
            "Faturas",
            "Estatisticas",
    };


    public static final String[] opcoesMenuArtigos = {
            "Adicionar Artigo",
            "Remover Artigo",
            "Listar Artigos",
    };

    public static final String[] opcoesMenuAddArtigo = {
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

    public static final String[] opcoesMenuRmEncomendas = {
            "Código do Artigo para ser removido",
    };

    public static final String[] opcoesMenuEncomendas = {
            "Criar Encomenda",
            "Remover Encomendas",
            "Listar Encomendas",
    };

    public static final String[] opcoesMenuCriarEncomenda = {
            "Adicionar Artigo à Encomenda (código)",
            "Concluir Encomenda",
    };

    public static final String[] opcoesMenuTransportadoras = { //TODO

    };


    public static final String[] opcoesMenuFaturas = { //TODO

    };


    public static final String[] opcoesMenuEstatisticas = { //TODO

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
