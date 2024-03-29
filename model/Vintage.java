package model;

import Exceptions.*;
import View.IO;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import static View.Input.*;
import static java.lang.System.out;

public class Vintage implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
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
        if(listaTransportadoras.getTransportadorasList().isEmpty()){
            IO.error("Nao existem transportadoras disponiveis para adicionar artigos.");
            return;
        }

        Sapatilha retorno = new Sapatilha();

        retorno.setNumDonos(getNumDonos());
        retorno.setNovo(retorno.getNumDonos() == 0);
        retorno.setDescricao(getDescricao());
        retorno.setPrecoBase(getPrecoBase());
        retorno.setAvaliacao(getAvaliacao());
        retorno.setTamanho(getTamanhoSapatilha());
        retorno.setAtacadores(getAtacadores());
        retorno.setData(getData());
        retorno.setCor(getCor());
        retorno.setEmailUtilizador(userLigado.getEmail());

        out.println();
        listaTransportadoras();

        boolean ok = false;
        int codTransp = -1;

        while(!ok){
            codTransp = getCodigoTransportadora();
            if (listaTransportadoras.existeTransportadora(codTransp)) {
                retorno.setTransportadora(codTransp);
                ok = true;
            }
            else
                out.println("Nao existe transportadora com o codigo "+codTransp);
        }
        listaArtigos.addArtigo(retorno);
        userLigado.addArtigosPorVender(retorno);
        out.println("Sapatilha adicionada com sucesso");

    }

    public void criaSapatilhaPremium() {
        if(!(existeTranspPremium())){
            IO.error("Nao existem transportadoras premium disponiveis para adicionar artigos.");
            return;
        }

        SapatilhaPremium retorno = new SapatilhaPremium();

        retorno.setNumDonos(getNumDonos());
        retorno.setNovo(retorno.getNumDonos() == 0);
        retorno.setDescricao(getDescricao());
        retorno.setTamanho(getTamanhoSapatilha());
        retorno.setAvaliacao(getAvaliacao());
        retorno.setAtacadores(getAtacadores());
        retorno.setPrecoBase(getPrecoBase());
        retorno.setData(getData());
        retorno.setCor(getCor());
        retorno.setEmailUtilizador(userLigado.getEmail());

        out.println();
        listaTransportadorasPremium();

        boolean ok = false;
        int codTransp = -1;

        while(!ok){
            codTransp = getCodigoTransportadora();
            if (listaTransportadoras.existeTransportadora(codTransp)){
                try {
                    Transportadora transportadora = listaTransportadoras.getTransportadoraLista(codTransp);
                    if (transportadora instanceof TransportadoraPremium) {
                        ok = true;
                        retorno.setTransportadora(codTransp);
                    } else
                        out.println("Essa transportadora nao leva artigos premium");
                } catch (TransportadoraNaoExiste e) {
                    IO.error("Transportadora premium com o codigo " + codTransp + " nao existe.");
                }
            }
            else
                out.println("Nao existe transportadora premium com o codigo "+codTransp);
        }

        listaArtigos.addArtigo(retorno);
        userLigado.addArtigosPorVender(retorno);
        out.println("Sapatilha premium adicionada com sucesso");
    }

    public void criaMala() {
        if(listaTransportadoras.getTransportadorasList().isEmpty()){
            IO.error("Nao existem transportadoras disponiveis para adicionar artigos.");
            return;
        }
        Mala retorno = new Mala();

        retorno.setNumDonos(getNumDonos());
        retorno.setNovo(retorno.getNumDonos() == 0);
        retorno.setAvaliacao(getAvaliacao());
        retorno.setDescricao(getDescricao());
        retorno.setDim(getDim());
        retorno.setPrecoBase(getPrecoBase());
        retorno.setMaterial(getMaterial());
        retorno.setAno_colecao(getAno_colecao());
        retorno.setEmailUtilizador(userLigado.getEmail());

        out.println();
        listaTransportadoras();

        boolean ok = false;
        int codTransp = -1;

        while(!ok){
            codTransp = getCodigoTransportadora();
            if (listaTransportadoras.existeTransportadora(codTransp)) {
                retorno.setTransportadora(codTransp);
                ok = true;
            }
            else
                out.println("Nao existe transportadora com o codigo "+codTransp);
        }

        listaArtigos.addArtigo(retorno);
        userLigado.addArtigosPorVender(retorno);
        out.println("Mala adicionada com sucesso");
    }

    public void criaMalaPremium() {
        if(!existeTranspPremium()){
            IO.error("Nao existem transportadoras premium disponiveis para adicionar artigos.");
            return;
        }

        MalaPremium retorno = new MalaPremium();

        retorno.setNumDonos(getNumDonos());
        retorno.setNovo(retorno.getNumDonos() == 0);
        retorno.setAvaliacao(getAvaliacao());
        retorno.setDescricao(getDescricao());
        retorno.setDim(getDim());
        retorno.setPrecoBase(getPrecoBase());
        retorno.setMaterial(getMaterial());
        retorno.setAno_colecao(getAno_colecao());
        retorno.setEmailUtilizador(userLigado.getEmail());

        out.println();
        listaTransportadorasPremium();

        boolean ok = false;
        int codTransp = -1;

        while(!ok){
            codTransp = getCodigoTransportadora();
            if (listaTransportadoras.existeTransportadora(codTransp)) {
                try {
                    if (listaTransportadoras.getTransportadoraLista(codTransp) instanceof TransportadoraPremium) {
                        retorno.setTransportadora(codTransp);
                        ok = true;
                    }
                    else
                        out.println("Essa transportadora nao leva artigos premium");
                }catch (TransportadoraNaoExiste e){
                    IO.error("Transportadora com o codigo "+ codTransp +" nao existe.");
                }
            }
            else
                out.println("Nao existe transportadora com o codigo "+codTransp);
        }

        listaArtigos.addArtigo(retorno);
        userLigado.addArtigosPorVender(retorno);
        out.println("Mala premium adicionada com sucesso");
    }

    public void criaTShirt() {
        if(listaTransportadoras.getTransportadorasList().isEmpty()){
            IO.error("Nao existem transportadoras disponiveis para adicionar artigos.");
            return;
        }

        TShirt retorno = new TShirt();

        retorno.setNumDonos(getNumDonos());
        retorno.setNovo(retorno.getNumDonos() == 0);
        retorno.setAvaliacao(getAvaliacao());
        retorno.setDescricao(getDescricao());
        retorno.setPrecoBase(getPrecoBase());
        retorno.setTamanho(getTamanhoTShirt());
        retorno.setPadrao(getPadrao());
        retorno.setEmailUtilizador(userLigado.getEmail());

        out.println();
        listaTransportadoras();

        boolean ok = false;
        int codTransp = -1;

        while(!ok){
            codTransp = getCodigoTransportadora();
            if (listaTransportadoras.existeTransportadora(codTransp)) {
                retorno.setTransportadora(codTransp);
                ok = true;
            }
            else
                out.println("Nao existe transportadora com o codigo "+codTransp);
        }

        retorno.setTransportadora(codTransp);
        listaArtigos.addArtigo(retorno);
        userLigado.addArtigosPorVender(retorno);
        out.println("Tshirt adicionada com sucesso");
    }


    public void criaEncomenda() {
        try{
            if(listaArtigos.getArtigosList().isEmpty()){
                out.println("Nao existem artigos listados.");
                return;
            }

            Encomenda encomenda = new Encomenda();
            encomenda.setEmailUtilizadorCompra(userLigado.getEmail());
            String artigoString = "";

            List<String> usuarios = new ArrayList<>();
            out.println(listaArtigos.toString());

            do {
                out.println("Insira o codigo do artigo que deseja adicionar a sua encomenda");
                out.println("Para concluir a encomenda digite : concluida\n");
                artigoString = getCodigo();

                if (!artigoString.equals("concluida")){
                    try {
                        Artigo artigo = listaArtigos.getArtigoLista(artigoString);

                        if(!artigo.getEmailUtilizador().equals(userLigado.getEmail())) {
                            usuarios.add(artigo.getEmailUtilizador());
                            encomenda.addEncomenda(listaTransportadoras.getTransportadoraLista(artigo.getCodTransportadora()), artigo);
                            listaUtilizadores.getUtilizadores().get(artigo.getEmailUtilizador()).addArtigosVendidos(artigo);
                            listaUtilizadores.getUtilizadores().get(artigo.getEmailUtilizador()).removeArtigosPorVender(artigo);
                            listaArtigos.removeArtigo(artigoString);
                        }
                        else
                            out.println("\nO artigo é seu.");

                    } catch (ArtigoNaoExiste e) {
                        out.println("Nao existe um artigo com codigo " + artigoString +"\n");
                    }catch (TransportadoraNaoExiste e){
                        out.println("Nao existe essa transportadora");
                    }catch (NullPointerException e){
                        out.println("O codigo do artigo nao pode ser null");
                    }
                }
            }while (!artigoString.equals("concluida"));

            if(encomenda.getArtigos().isEmpty()){
                out.println("Nao existem artigos para criar encomenda" );
                return;
            }

            out.println("Encomenda criada com sucesso.\n");

            addDinheiroGanho(encomenda.calculaPercentagemVintage());

            encomenda.setPrecoTotal(encomenda.calculaPrecoEncomenda());

            userLigado.adicionaEncomendasUtilizador(encomenda);

            FaturaCliente faturaCliente = new FaturaCliente();
            faturaCliente.setPreco(encomenda.getPrecoTotal());
            faturaCliente.setEncomenda(encomenda);
            faturaCliente.setCliente(userLigado);

            listaFaturas.addFaturaCliente(encomenda.getCodEnc(),faturaCliente);

            for (String a : usuarios){
                try {
                    FaturaVendedor faturaVendedor = new FaturaVendedor();
                    faturaVendedor.setEncomenda(encomenda);
                    faturaVendedor.setVendedor(listaUtilizadores.getUtilizador(a));
                    faturaVendedor.setPreco(encomenda.calculaPrecoEncomenda());
                    listaFaturas.addFaturaVendedor(encomenda.getCodEnc(), faturaVendedor.clone());
                }
                catch (Exception ignored){}
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
            if(userLigado.encomendaUtilizador(encomendaACancelar)){
                if (encomendaACancelar.validoCancelamentoEncomenda()) {
                    List<Artigo> artigos = encomendaACancelar.getArtigos();

                    for (Artigo a : artigos) {
                        Utilizador dono = listaUtilizadores.getUtilizador(a.getEmailUtilizador());
                        dono.cancelaVenda(a);
                        listaArtigos.addArtigo(a);
                    }

                    userLigado.removeEncomendasUtilizador(encomendaACancelar);
                    listaEncomendas.removeEncomenda(codigoEncomenda);

                    listaFaturas.removeFaturaCliente(encomendaACancelar.getCodEnc());

                    listaFaturas.removeFaturaVendedor(encomendaACancelar.getCodEnc());
                    out.println("Encomenda cancelada com sucesso");

                } else
                    out.println("Essa encomenda ja foi / começou a ser entregue.");
            }
            else
                out.println("A encomenda com codigo "+ codigoEncomenda +" nao lhe pertence.");

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

            int formulaTransportacao = getFormulaTransportacao();
            transportadora.setOpcaoFormula(formulaTransportacao);

            int margemLucro = getMargemLucro();
            transportadora.setMargemLucro(margemLucro);

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
            Transportadora transportadora = new TransportadoraPremium();

            double imposto = (double) getImposto() / 100;
            transportadora.setImposto(imposto);

            out.println("Nº de dias que a transportadora demora a entregar");

            int dias = getDias();
            transportadora.setDiasEntrega(dias);

            int formulaTransportacao = getFormulaTransportacao();
            transportadora.setOpcaoFormula(formulaTransportacao);

            int margemLucro = getMargemLucro();
            transportadora.setMargemLucro(margemLucro);

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

    public void listarEncomendaUser(String codigo){
        ArrayList <Integer> codEncomendas = new ArrayList<>();
        if(listaUtilizadores.existeUtilizador(codigo)){
            for (List<FaturaVendedor> faturaVendedors :listaFaturas.getListaFaturasVenderores().values()){
                for (FaturaVendedor b : faturaVendedors){
                    if(b.getVendedor().getEmail().equals(codigo))
                        codEncomendas.add(b.getEncomenda().getCodEnc());
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int a : codEncomendas){
                try {
                    sb.append(listaEncomendas.getEncomendaLista(a).toString());
                    sb.append("\n");
                }
                catch (Exception ignored){}
            }
            out.println(sb);
            return;
        }

        IO.error("Nao existe um utilizador com o email "+ codigo);
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

        try{
            List<FaturaVendedor> lista = listaFaturas.getFaturasVendedorUserLigado(userLigado.getEmail());

            out.println();

            for(FaturaVendedor a : lista)
            {
                sb.append(a.toString());
            }
            out.println(sb);
        }
        catch (NullPointerException e){
            IO.error("Nao existe para este utilizador");
        }
    }

    public void listaTransportadoras(){
        StringBuilder sb = new StringBuilder();

        for (Transportadora a : listaTransportadoras.getTransportadorasList()){
            sb.append(a.toString());
            sb.append("\n");
        }

        out.println(sb);
    }

    public void listaTransportadorasPremium() {
        StringBuilder sb = new StringBuilder();

        for (Transportadora a : listaTransportadoras.getTransportadorasList()) {
            if (a instanceof TransportadoraPremium) {
                String b = a.toString();
                sb.append(b);
            }
        }

        out.println(sb);
    }

    public boolean existeTranspPremium(){
        boolean retorno = false;
        Iterator<Transportadora> a = listaTransportadoras.getTransportadorasList().iterator();
        Transportadora b;

        while(a.hasNext() && !retorno){
            b = a.next();
            retorno = b instanceof TransportadoraPremium;
        }

        return retorno;
    }

    public void getAllFaturasClienteOrdenar(LocalDate inicio,LocalDate fim) {
        Map<String,Double> retorno = new HashMap<>();

        for (Integer a : listaFaturas.getListaFaturasClientes().keySet()) {
            try {
                if((listaEncomendas.getEncomendaLista(a).getDataEncomenda().isBefore(fim) ||listaEncomendas.getEncomendaLista(a).getDataEncomenda().isEqual(fim))
                        && (listaEncomendas.getEncomendaLista(a).getDataEncomenda().isAfter(inicio) ||listaEncomendas.getEncomendaLista(a).getDataEncomenda().isEqual(inicio) )) {
                    for (FaturaCliente b : listaFaturas.getListaFaturasClientes().get(a)) {

                        if (retorno.containsKey(b.getCliente().getEmail()))
                            retorno.put(b.getCliente().getEmail(), (retorno.get(b.getCliente().getEmail()) + b.getPreco()));
                        else
                            retorno.put(b.getCliente().getEmail(), b.getPreco());
                    }
                }
            }catch (EncomendaNaoExiste ignored){}
        }

        List<Map.Entry<String,Double>> listaOrdenada = new ArrayList<>(retorno.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByValue());

        for (Map.Entry<String,Double> entrada:listaOrdenada)
            out.println("Email cliente: " +entrada.getKey() + " dinheiro gasto: "+entrada.getValue());

    }

    public void getAllFaturasVendedorTopOrdenar(){
        Map<String,Double> retorno = new HashMap<>();

        for (Utilizador b : listaUtilizadores.getUtilizadoresList()){
            if(!retorno.containsKey(b.getEmail()))
                retorno.put(b.getEmail(),b.calculaDinheiroVendas());
            else
                retorno.put(b.getEmail(),b.calculaDinheiroVendas()+retorno.get(b.getEmail()));
        }

        List<Map.Entry<String, Double>> listaOrdenada = new ArrayList<>(retorno.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByValue());

        Map.Entry<String,Double> entrada = listaOrdenada.get(listaOrdenada.size()-1);
        out.println("Email vendedor: " +entrada.getKey() + " dinheiro ganho: "+entrada.getValue());
    }

    public void getAllFaturasVendedorTopOrdenar(LocalDate inicio,LocalDate fim){
        Map<String,Double> retorno = new HashMap<>();

        for (Integer a : listaFaturas.getListaFaturasVenderores().keySet()) {
            try {
                if((listaEncomendas.getEncomendaLista(a).getDataEncomenda().isBefore(fim) || listaEncomendas.getEncomendaLista(a).getDataEncomenda().isEqual(inicio))
                        && (listaEncomendas.getEncomendaLista(a).getDataEncomenda().isAfter(inicio) ||listaEncomendas.getEncomendaLista(a).getDataEncomenda().isEqual(inicio))) {
                    for (FaturaVendedor b : listaFaturas.getListaFaturasVenderores().get(a)) {
                        if (retorno.containsKey(b.getVendedor().getEmail()))
                            retorno.put(b.getVendedor().getEmail(), (retorno.get(b.getVendedor().getEmail()) + b.getPreco()));
                        else
                            retorno.put(b.getVendedor().getEmail(), b.getPreco());
                    }
                }
            }catch (EncomendaNaoExiste encomendaNaoExiste){
                IO.error("ups...");
            }
        }

        List<Map.Entry<String,Double>> listaOrdenada = new ArrayList<>(retorno.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByValue());

        if(listaOrdenada.size()==0)
            return;

        Map.Entry<String,Double> entrada = listaOrdenada.get(listaOrdenada.size()-1);
        out.println("Email vendedor: " +entrada.getKey() + " dinheiro ganho: "+entrada.getValue());
    }


    public void getAllFaturasVendedorOrdenar(LocalDate inicio,LocalDate fim){
        Map<String,Double> retorno = new HashMap<>();

        for (Integer a : listaFaturas.getListaFaturasVenderores().keySet()) {
            try {
                if(listaEncomendas.getEncomendaLista(a).getDataEncomenda().isBefore(fim) && listaEncomendas.getEncomendaLista(a).getDataEncomenda().isAfter(inicio)) {
                    for (FaturaVendedor b : listaFaturas.getListaFaturasVenderores().get(a)) {
                        if (retorno.containsKey(b.getVendedor().getEmail()))
                            retorno.put(b.getVendedor().getEmail(), (retorno.get(b.getVendedor().getEmail()) + b.getPreco()));
                        else
                            retorno.put(b.getVendedor().getEmail(), b.getPreco());
                    }
                }
            }catch (EncomendaNaoExiste ignored){}
        }

        List<Map.Entry<String,Double>> listaOrdenada = new ArrayList<>(retorno.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByValue());

        for (Map.Entry<String,Double> entrada:listaOrdenada){
            out.println("Email vendedor: " +entrada.getKey() + " dinheiro gasto: "+String.format("%.2f",entrada.getValue()));
        }
    }

    public double calculaListaArtigosPreco(List<Artigo> artigos){
        double retorno = 0;

        for (Artigo a : artigos){
            retorno += a.calculaPrecoFinal();
        }

        return retorno;
    }

    public void transportadoraMaiorValor(){
        Map<Integer,Double> transportadora = new HashMap<>();
        for (Encomenda a : listaEncomendas.getEncomendasList()){
            for (Transportadora l : a.retornaKeys()){
                if(transportadora.containsKey(l.getCodTransportadora())){
                    double valorAtual = transportadora.get(l.getCodTransportadora());
                    transportadora.put(l.getCodTransportadora(),l.calculaPrecoFinal(a.getArtigos())+valorAtual);
                }
                else{
                    transportadora.put(l.getCodTransportadora(),l.calculaPrecoFinal(a.getArtigos()));
                }
            }
        }

        List<Map.Entry<Integer,Double>> listaOrdenada = new ArrayList<>(transportadora.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByValue());

        Map.Entry<Integer,Double> entrada = listaOrdenada.get(listaOrdenada.size()-1);
        out.println("Transportadora com maior faturaçao: " +entrada.getKey() + " dinheiro ganho: "+String.format("%.2f €",entrada.getValue()));
    }

    public void ListaArtigoGeral(){
        StringBuilder sb = new StringBuilder();

        for (Artigo b : listaArtigos.getArtigosList()){
            sb.append(b.toString());
        }

        out.println(sb);
    }
}