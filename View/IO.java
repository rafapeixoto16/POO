package View;

import static java.lang.System.out;
public class IO {

    public static final String[] opcoesMenuPrincipal = {
            "Log In",
            "Sig In",
            "Encerrar Programa (grava automáticamente)",
    };


    public static final String[] opcoesMenuUtilizador = {
            "Artigos",
            "Encomendas",
            "Transportadoras",
            "Faturas",
            "Estatisticas",
            "Tempo",
            "Informações do Utilizador"
    };


    public static final String[] opcoesMenuArtigos = {
            "Criar Artigo",
            "Remover Artigo",
            "Listar os meus Artigos",
            "Listar Todos os Artigos"
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
            "Cancelar Encomenda",
            "Listar Encomendas",
    };


    public static final String[] opcoesMenuTransportadoras = {
            "Criar Transportadora",
            "Listar Transportadoras",
            "Alterar Imposto de Transportadorta",
            "Alterar Fórmula para Custo de Expedição de Transportadora"
    };

    public static final String[] opcoesMenuCriarTransportadora = {
            "Transportadora Normal",
            "Transportadora Premium",
    };

    public static final String[] opcoesMenuFaturas = {
            "Ver Faturas de Compras",
            "Ver Faturas de Vendas",
    };


    public static final String[] opcoesMenuEstatisticas = {
            "Vendedor que mais faturou",
            "Transportadora com maior volume de faturação",
            "Listar as encomendas emitidas por um vendedor",
            "Maiores Compradores",
            "Maiores Vendedores",
            "Faturação da Vintage",
    };

    public static final String[] opcoesMenuDesdeSemprePeriodo = {
            "Desde sempre",
            "Indicar Período de Tempo"
    };



    public int menu(String titulo, String[] opcoes) {

        Menu menu = new Menu(titulo, opcoes);
        menu.executa();
        out.println("\n");
        return menu.getOpcao();
    }

    public int menu2(String titulo, String[] opcoes) {

        Menu menu = new Menu(titulo, opcoes);
        menu.executa2();
        out.println("\n");
        return menu.getOpcao();
    }


    public static void error(String error) {
        System.out.println("\nError: " + error);
    }
}
