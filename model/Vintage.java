package model;

import Exceptions.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static View.Input.*;
import static java.lang.System.out;

public class Vintage implements Serializable {
    private ListaArtigos listaArtigos;
    private ListaUtilizadores listaUtilizadores;
    private ListaTransportadoras listaTransportadoras;
    private ListaEncomendas listaEncomendas;
    private ListaFaturas listaFaturas;
    private static LocalDate dataSistema;
    private static double dinheiroGanho;
    public static void addDinheiroGanho(double dinheiroGanho2){dinheiroGanho += dinheiroGanho2;}
    public static double getDinheiroGanho(){return dinheiroGanho;}
    public static void setDinheiroGanho(double dinheiroGanho1){dinheiroGanho = dinheiroGanho1;}
    public static void incDia() {
        dataSistema = dataSistema.plusDays(1);
    }
    public static LocalDate dataAtual() {
        return dataSistema;
    }
    public static void setDataAtual(LocalDate data) {
        dataSistema = data;
    }
    private Utilizador userLigado;

    public Vintage() {
        listaArtigos = new ListaArtigos();
        listaUtilizadores = new ListaUtilizadores();
        listaTransportadoras = new ListaTransportadoras();
        listaEncomendas = new ListaEncomendas();
        listaFaturas = new ListaFaturas();
        userLigado = new Utilizador();
    }

    public Vintage(Vintage vintage) {
        this.listaUtilizadores = vintage.listaUtilizadores.clone();
        this.listaArtigos = vintage.listaArtigos.clone();
        this.listaTransportadoras = vintage.listaTransportadoras.clone();
        this.listaEncomendas = vintage.listaEncomendas.clone();
        this.listaFaturas = vintage.listaFaturas.clone();
        this.userLigado = userLigado.clone();
    }

    public void avancoTemporal() {
        out.println("Insira quantos dias quer avançar");
        int dias = getDias();
        dataSistema = dataSistema.plusDays(dias);
    }

    public LocalDate getDataSistema() {
        return dataSistema;
    }

    public boolean login() {
        String email = getEmail();

        if (listaUtilizadores.existeUtilizador(email))
        {
            try {
                userLigado = listaUtilizadores.getUtilizadorLista(email);
                return true;
            } catch (UtilizadorNaoExiste | NullPointerException e) {
                out.println("O email: " + email + " nao tem uma conta registada.");
                return false;
            }
        }
        out.println("O email: " + email + " nao tem uma conta registada.");
        return false;
    }

    public void logout() {
        userLigado = null;
    }

    public ListaArtigos getListaArtigos() {
        return listaArtigos;
    }

    public ListaUtilizadores getListaUtilizadores() {
        return listaUtilizadores;
    }

    public ListaTransportadoras getListaTransportadoras() {
        return listaTransportadoras;
    }

    public ListaEncomendas getListaEncomendas() {
        return listaEncomendas;
    }

    public ListaFaturas getListaFaturas() {
        return listaFaturas;
    }

    public Utilizador getUserLigado() {
        return userLigado;
    }

    public void setListaArtigos(ListaArtigos listaArtigos) {
        this.listaArtigos = listaArtigos;
    }

    public void setListaUtilizadores(ListaUtilizadores listaUtilizadores) {
        this.listaUtilizadores = listaUtilizadores;
    }

    public void setListaTransportadoras(ListaTransportadoras listaTransportadoras) {
        this.listaTransportadoras = listaTransportadoras;
    }

    public void setListaEncomendas(ListaEncomendas listaEncomendas) {
        this.listaEncomendas = listaEncomendas;
    }

    public void setListaFaturas(ListaFaturas listaFaturas) {
        this.listaFaturas = listaFaturas;
    }

    public void setDataSistema(LocalDate dataSistema) {
        Vintage.dataSistema = dataSistema;
    }

    public void setUserLigado(Utilizador userLigado) {
        this.userLigado = userLigado;
    }

    public void criaSapatilha() {
        Sapatilha retorno = new Sapatilha();

        retorno.setNovo(getNovo());
        retorno.setNumDonos(getNumDonos());
        retorno.setDescricao(getDescricao());
        retorno.setPrecoBase(getPrecoBase());
        retorno.setAvaliacao(getAvaliacao());
        retorno.setTamanho(getTamanhoSapatilha());
        retorno.setAtacadores(getAtacadores());
        retorno.setData(getData());
        retorno.setCor(getCor());
        retorno.setEmailUtilizador(userLigado.getEmail());

        listaArtigos.addArtigo(retorno);
        userLigado.addArtigosPorVender(retorno);
        out.println("Sapatilha adicionada com sucesso");
    }

    public void criaSapatilhaPremium() {
        SapatilhaPremium retorno = new SapatilhaPremium();

        retorno.setNovo(getNovo());
        retorno.setNumDonos(getNumDonos());
        retorno.setDescricao(getDescricao());
        retorno.setTamanho(getTamanhoSapatilha());
        retorno.setAvaliacao(getAvaliacao());
        retorno.setAtacadores(getAtacadores());
        retorno.setPrecoBase(getPrecoBase());
        retorno.setData(getData());
        retorno.setCor(getCor());
        retorno.setEmailUtilizador(userLigado.getEmail());

        listaArtigos.addArtigo(retorno);
        userLigado.addArtigosPorVender(retorno);
        out.println("Sapatilha premium adicionada com sucesso");
    }

    public void criaMala() {
        Mala retorno = new Mala();

        retorno.setNovo(getNovo());
        retorno.setNumDonos(getNumDonos());
        retorno.setAvaliacao(getAvaliacao());
        retorno.setDescricao(getDescricao());
        retorno.setDim(getDim());
        retorno.setPrecoBase(getPrecoBase());
        retorno.setMaterial(getMaterial());
        retorno.setAno_colecao(getAno_colecao());//todo alterar o getano_colecao
        retorno.setEmailUtilizador(userLigado.getEmail());

        listaArtigos.addArtigo(retorno);
        userLigado.addArtigosPorVender(retorno);
        out.println("Mala adicionada com sucesso");
    }

    public void criaMalaPremium() {
        MalaPremium retorno = new MalaPremium();

        retorno.setNovo(getNovo());
        retorno.setNumDonos(getNumDonos());
        retorno.setAvaliacao(getAvaliacao());
        retorno.setDescricao(getDescricao());
        retorno.setDim(getDim());
        retorno.setPrecoBase(getPrecoBase());
        retorno.setMaterial(getMaterial());
        retorno.setAno_colecao(getAno_colecao());//todo alterar o getano_colecao
        retorno.setEmailUtilizador(userLigado.getEmail());

        listaArtigos.addArtigo(retorno);
        userLigado.addArtigosPorVender(retorno);
        out.println("Mala premium adicionada com sucesso");
    }

    public void criaTShirt() {
        TShirt retorno = new TShirt();

        retorno.setNovo(getNovo());
        retorno.setNumDonos(getNumDonos());
        retorno.setAvaliacao(getAvaliacao());
        retorno.setDescricao(getDescricao());
        retorno.setPrecoBase(getPrecoBase());
        retorno.setTamanho(getTamanhoTShirt());
        retorno.setPadrao(getPadrao());
        retorno.setEmailUtilizador(userLigado.getEmail());

        listaArtigos.addArtigo(retorno);
        userLigado.addArtigosPorVender(retorno);
        out.println("Tshirt adicionada com sucesso");
    }


    public void criaEncomenda() {
        try{
            if(listaTransportadoras.getTransportadorasList().isEmpty()){
                out.println("Nao existem transportadoras");
                return;
            }

            Encomenda encomenda = new Encomenda();
            encomenda.setEmailUtilizadorCompra(userLigado.getEmail());
            String artigoString;
            int codigoTransportadora;
            List<String> usuarios = new ArrayList<>();

            out.println(listaArtigos.toString());

            do {
                out.println("Insira o codigo do artigo que deseja adicionar a sua encomenda");
                out.println("Para concluir a encomenda digite : concluida");
                artigoString = getCodigo();

                if (!artigoString.equals("concluida")){
                    try {
                        Artigo artigo = listaArtigos.getArtigoLista(artigoString);
                        if(!artigo.getEmailUtilizador().equals(userLigado.getEmail())) {
                            usuarios.add(artigo.getEmailUtilizador());

                            if(!listaTransportadoras.getTransportadorasList().isEmpty()) {
                                listaTransportadoras();

                                out.println("Insira o codigo da transportadora");
                                codigoTransportadora = getInt();

                                try {
                                    Transportadora transportadora = listaTransportadoras.getTransportadoraLista(codigoTransportadora);
                                    encomenda.addEncomenda(transportadora, artigo);
                                    listaUtilizadores.getUtilizadores().get(artigo.getEmailUtilizador()).addArtigosVendidos(artigo);
                                }
                                catch (TransportadoraNaoExiste e) {
                                    out.println("Nao existe uma transportadora com codigo " + codigoTransportadora);
                                }

                            }else
                                out.println("De momento nao existem transportadoras");
                        }
                        else
                            out.println("O artigo é seu.");

                    } catch (ArtigoNaoExiste e) {
                        out.println("Nao existe um artigo com codigo " + artigoString);
                    }
                }
            }while (!artigoString.equals("concluida"));

            out.println("Encomenda criada com sucesso.");

            addDinheiroGanho(encomenda.calculaPercentagemVintage());

            userLigado.adicionaEncomendasUtilizador(encomenda);//todo verificar se esta a adicionar
            encomenda.setPrecoTotal(encomenda.calculaPrecoEncomenda());

            FaturaCliente faturaCliente = new FaturaCliente();
            faturaCliente.setPreco(encomenda.getPrecoTotal());
            faturaCliente.setEncomenda(encomenda);
            faturaCliente.setCliente(userLigado);

            listaFaturas.addFaturaCliente(encomenda.getCodEnc(),faturaCliente);

            for (String a : usuarios) {
                FaturaVendedor faturaVendedor = new FaturaVendedor();
                faturaVendedor.setEncomenda(encomenda);
                faturaVendedor.setVendedor(listaUtilizadores.getUtilizador(a));
                faturaVendedor.setPreco(encomenda.calculaPrecoEncomenda());
                listaFaturas.addFaturaVendedor(encomenda.getCodEnc(), faturaVendedor);
            }

            listaEncomendas.addEncomenda(encomenda);
        }
        catch (EncomendaJaExistente e){
            out.println("Essa encomenda ja existe");
        }
    }
    public void cancelaEncomenda(int codigoEncomenda) {
        try{
            Encomenda encomendaACancelar = listaEncomendas.getEncomendaLista(codigoEncomenda);
            if(userLigado.encomendaUtilizador(encomendaACancelar)) {
                if (encomendaACancelar.validoCancelamentoEncomenda()) {
                    List<Artigo> artigos = encomendaACancelar.getArtigos();

                    for (Artigo a : artigos) {
                        Utilizador dono = listaUtilizadores.getUtilizador(a.getEmailUtilizador());
                        dono.cancelaVenda(a);
                    }

                    userLigado.removeEncomendasUtilizador(encomendaACancelar);
                    listaEncomendas.removeEncomenda(codigoEncomenda);

                    listaFaturas.removeFaturaCliente(encomendaACancelar.getCodEnc());

                    //todo altera ir
                    listaFaturas.removeFaturaVendedor(encomendaACancelar.getCodEnc());
                    out.println("Encomenda cancelada com sucesso");
                } else
                    out.println("Essa encomenda ja foi / começou a ser entregue.");
            }
            else
                out.println("A encomenda com codigo "+codigoEncomenda+" nao lhe pertence.");

        }
        catch (EncomendaNaoExiste e) {
            out.println("A encomenda com codigo "+codigoEncomenda +"não existe.");
        }
    }

    public void criaTransportadora() {
        try{
            Transportadora transportadora = new Transportadora();

            double imposto = (double) getImposto() / 100;
            transportadora.setImposto(imposto);

            out.println("Nº de dias que a transportadora demora a entregar");

            int dias = getDias();
            transportadora.setDiasEntrega(dias);

            listaTransportadoras.addTransportadora(transportadora);
            out.println("Transportadora criada com sucesso");
        }
        catch (TransportadoraJaExistente e){
            e.printStackTrace();
            out.println("Transportadora ja existente.");
        }
    }

    public void criaTransportadoraPremium() {
        try{
            TransportadoraPremium transportadora = new TransportadoraPremium();

            double imposto = (double) getImposto() / 100;
            transportadora.setImposto(imposto);

            out.println("Nº de dias que a transportadora demora a entregar");

            int dias = getDias();
            transportadora.setDiasEntrega(dias);

            listaTransportadoras.addTransportadora(transportadora);
            out.println("Transportadora criada com sucesso");
        }
        catch (TransportadoraJaExistente e){
            e.printStackTrace();
            out.println("Transportadora ja existente.");
        }
    }

    public void criaUtilizador(){
        Utilizador retorno = new Utilizador();
        boolean ok = false;

        while(!ok){
            try {
                retorno.setEmail(getEmail());
                retorno.setNome(getName());
                retorno.setMorada(getMorada());
                retorno.setNumeroFiscal(getNIF());
                listaUtilizadores.addUtilizador(retorno);
                ok = true;
                out.println(" Conta criada com sucesso. ");
            }
            catch (UtilizadorJaExistente e){
                out.println("O Email " + retorno.getEmail() + " ja tem uma conta de associado");
            }
        }
    }


    public void removeArtigo (String codigoArtigo){
        try {
            Artigo artigoPorRemover = listaArtigos.getArtigoLista(codigoArtigo);
            if(userLigado.temArtigoPorVender(artigoPorRemover)) {
                listaArtigos . removeArtigo (codigoArtigo) ;
                userLigado . removeArtigosPorVender (artigoPorRemover) ;
            }
            else{
                out.println("Voce nao possui esse artigo");
            }
        }
        catch (ArtigoNaoExiste e){
            out.println("O artigo com codigo " + codigoArtigo + " nao existe.");
        }
    }

    public void alterarImposto(){
        int idTransp = getCodigoTransportadora();
        try {
            Transportadora l = listaTransportadoras.getTransportadoraLista(idTransp);
            l.setImposto(getImposto());
        }
        catch (TransportadoraNaoExiste e){
            e.printStackTrace();
            out.println("A transportadora com id " + idTransp + " nao existe");
        }
    }

    public void listarEncomendaUser(){
        List<Integer> codArtigos = userLigado.retornaCodigoEncomendaUser();

        StringBuilder sb = new StringBuilder();

        for (int a : codArtigos){
            try{
                Encomenda encomenda = listaEncomendas.getEncomendaLista(a);
                sb.append(encomenda.toString());
            }
            catch (EncomendaNaoExiste e){
                out.println("Ups ocurreu um erro...");
            }
        }
        out.println(sb);
    }

    public void listaFaturasComprado(){
        StringBuilder sb = new StringBuilder();
        List<Integer> codEncomendas = userLigado.retornaCodigoEncomendaUser();

        for (int i :codEncomendas){
            for (FaturaCliente a : listaFaturas.getFaturasClienteUserLigado(i)) {
                sb.append(a.toString());
            }
        }
        out.println(sb);
    }

    public void listaFaturasVendas(){
        StringBuilder sb = new StringBuilder();

        List<FaturaVendedor> lista = listaFaturas.getFaturasVendedorUserLigado(userLigado.getEmail());
        for(FaturaVendedor a : lista)
        {
            sb.append(a.toString());
        }

        out.println(sb);
    }

    public void listaTransportadoras(){
        StringBuilder sb = new StringBuilder();

        for (Transportadora a : listaTransportadoras.getTransportadorasList()){
            sb.append(a.toString());
        }

        out.println(sb);
    }

    public void calculaVendas(){

    }
}