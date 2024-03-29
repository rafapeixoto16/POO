package View;

import model.Vintage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;


import static java.lang.System.in;
import static java.lang.System.out;
public class Input {
    public static String getString() {
        Scanner input = new Scanner(in);
        boolean ok = false;
        String txt = "";
        while (!ok) {
            try {
                txt = input.nextLine();
                ok = true;
            } catch (InputMismatchException e) {
                IO.error(e.getMessage());
                out.print("Novo Valor(String): ");
                input.nextLine();
            }
        }
        return txt;
    }

    public static int getInt() {
        Scanner input = new Scanner(in);
        boolean ok = false;
        int i = 0;
        while (!ok) {
            try {
                i = input.nextInt();
                ok = true;
            } catch (InputMismatchException e) {
                IO.error(e.getMessage());
                out.print("Novo Valor(Int): ");
                input.nextLine();
            }
        }
        return i;
    }

    public static double getDouble() {
        Scanner input = new Scanner(in);
        boolean ok = false;
        double d = 0.0;
        while (!ok) {
            try {
                d = input.nextDouble();
                ok = true;
            } catch (InputMismatchException e) {
                IO.error(e.getMessage());
                out.print("Novo Valor(Double): ");
                input.nextLine();
            }
        }
        return d;
    }

    public static float getFloat() {
        Scanner input = new Scanner(in);
        boolean ok = false;
        float f = 0.0f;
        while (!ok) {
            try {
                f = input.nextFloat();
                ok = true;
            } catch (InputMismatchException e) {
                IO.error(e.getMessage());
                out.print("Novo Valor(Float): ");
                input.nextLine();
            }
        }
        return f;
    }

    public static boolean getBoolean() {
        Scanner input = new Scanner(in);
        boolean ok = false;
        boolean b = false;

        while (!ok) {
            try {
                b = input.nextBoolean();
                ok = true;
            } catch (InputMismatchException e) {
                IO.error(e.getMessage());
                out.print("Novo Valor(Boolean): ");
                input.nextLine();
            }
        }
        return b;
    }

    public static void getEnter() {
        out.print("\nPressione" + " ENTER " + "para continuar...");
        Input.getString();
    }

    public static int getOption(int max) {
        int option;
        boolean ok = false;

        do {
            out.print("Escolha uma opção: ");
            option = Input.getInt();

            if (option >= 0 && option <= max)
                ok = true;
            else
                IO.error("Opção Inválida");
        } while (!ok);

        return option;
    }

    public static int getDay(int mes){
        out.print("Dia: ");
        boolean ok = false;
        int dia = -1;
        while (!ok){
            dia = getInt();
            if (mes == 2 && dia >= 1 && dia <= 29)
                ok = true;
            else if (((mes == 1) ||( mes == 3) ||( mes == 5) || (mes == 7) || (mes == 8) || (mes == 10) || (mes == 12)) && (dia >= 1) && (dia <= 31))
                ok = true;
            else if ((dia >= 1) && (dia <= 30))
                ok = true;
            else
                IO.error("Dia Inválido");
        }
        return dia;
    }

    public static int getMes(){
        out.print("Mês: ");
        boolean ok = false;
        int mes = -1;
        while (!ok){
            mes = getInt();
            if (mes >= 1 && mes <= 12)
                ok = true;
            else
                IO.error("Mês Inválido");
        }
        return mes;
    }

    public static int getAno(){
        out.print("Ano: ");
        boolean ok = false;
        int anoAtual = LocalDate.now().getYear();
        int ano = -1;
        while (!ok){
            ano = getInt();
            if (ano >= 1900 && ano <= anoAtual)
                ok = true;
            else
                IO.error("Ano Inválido, apenas estão válidos os anos entre 1900 e "+anoAtual);
        }
        return ano;
    }

    public static LocalDate getDate(String string) {
        out.println(string);
        out.print("Data AAAA-MM-DD\n");
        int ano = getAno();
        int mes = getMes();
        int dia = getDay(mes);
        return LocalDate.of(ano,mes,dia);
    }

    public static String getEmail() {
        out.print("Email: ");
        boolean ok = false;
        String email = "";

        while (!ok){
            email = getString();
            if (email != "")
                ok = true;
            else
                IO.error("O Email não pode ser um campo nulo");
        }
        return email;
    }
    public static String getName() {
        out.print("Nome: ");
        boolean ok = false;
        String nome = "";

        while (!ok){
            nome = getString();
            if (nome != "")
                ok = true;
            else
                IO.error("O Nome não pode ser um campo nulo");
        }
        return nome;
    }

    public static String getMorada() {
        out.print("Morada: ");
        boolean ok = false;
        String morada = "";

        while (!ok){
            morada = getString();
            if (morada != "")
                ok = true;
            else
                IO.error("A Morada não pode ser um campo nulo");
        }
        return morada;
    }
    public static int getNIF() {
        out.print("NIF: ");
        int nif = -1;
        boolean ok = false;

        while (!ok) {
            nif = Input.getInt();
            if (nif > 99999999 && nif <= 999999999)
                ok = true;
            else
                IO.error("O nif tem de ter 9 algorismos.\n");
        }
        return nif;
    }

    public static int getNumDonos() {
        out.print("Número de donos que o Artigo já teve (0 se o Artigo for Novo): ");
        int numDonos = Input.getInt();
        return numDonos;
    }

    public static String getDescricao() {
        out.print("Descricao do Artigo: ");
        String descricao = Input.getString();
        return descricao;
    }

    public static double getPrecoBase() {
        out.print("Preço Base do Artigo: ");
        double pb = -1;
        boolean ok = false;

        while (!ok){
            pb = Input.getDouble();
            if (pb>0)
                ok = true;
            else
                IO.error("O Preço Base do artigo tem de ser maior que 0€");
        }
        return pb;
    }

    public static String getCodigo() {
        out.print("Código do Artigo: ");
        String codigo = Input.getString();
        return codigo;
    }

    public static int getDim() {
        out.print("Dimensao da Mala (cm^3): ");
        int dim = -1;

        boolean ok = false;

        while (!ok){
            dim = Input.getInt();
            if (dim>0)
                ok = true;
            else
                IO.error("A dimensão da mala tem de ser maior que 0cm^3");
        }
        return dim;
    }

    public static String getMaterial() {
        out.print("Material da Mala: ");
        String material = "";
        boolean ok = false;

        while (!ok){
            material = Input.getString();
            if(!material.matches("[0-9]+"))
                ok=true;
            else
                IO.error("O material da mala não pode ser um número");
        }
        return material;
    }

    //Para classe Mala

    public static LocalDate getAno_colecao() {
        out.print("Ano de colecao da mala: ");
        int ano = -1;
        boolean ok = false;

        while (!ok) {
            ano = Input.getInt();
            if (ano >= 1900 && ano <= Vintage.dataAtual().getYear())
                ok = true;
            else
                IO.error("O ano do artigo tem ser superior ou igual a 1900");
        }

        return LocalDate.of(ano,1,1);
    }
    public static int getTamanhoSapatilha() {
        out.print("Tamanho da Sapatilha: ");
        int tamanho = -1;
        boolean ok = false;

        while (!ok){
            tamanho = Input.getInt();
            if (tamanho>=13 && tamanho<=60)
                ok = true;
            else
                IO.error("O tamanho da sapatilha tem de ser maior que 13 e menor que 60");
        }
        return tamanho;
    }

    public static boolean getAtacadores() {
        out.print("Atacadores <- 1\n");
        out.print("Atilhos    <- 0\n");
        out.print("Opção: ");
        int op = -1;
        boolean ok = false;

        while (!ok) {
            op = Input.getInt();
            if (op == 1 || op == 0)
                ok = true;
            else
                IO.error("O valor número inserido tem de ser 1 (Atacadores) ou 0 (Atilhos)");
        }

        boolean at;

        at = op == 1;
        return at;
    }

    //Para classe Spatilha
    public static LocalDate getData() {
        out.print("Ano de coleção da Sapatilha: ");
        int ano = -1;
        boolean ok = false;

        while (!ok) {
            ano = Input.getInt();
            if (ano >= 1900 && ano <= Vintage.dataAtual().getYear())
                ok = true;
            else
                IO.error("O ano do artigo tem ser superior ou igual a 1900");
        }

        return LocalDate.of(ano,1,1);
    }
    public static String getCor() {
        out.print("Cor da Spatilha: ");
        String cor = "";
        boolean ok = false;

        while (!ok){
            cor = Input.getString();
            if(!cor.matches("[0-9]+"))
                ok=true;
            else
                IO.error("A cor da sapatilha não pode ser um número");
        }

        return cor;
    }

    public static int getAvaliacao() {
        int avaliacao;
        boolean ok = false;
        do {
            out.print("Avaliação do Artigo (valor inteiro entre 0 e 100): ");
            avaliacao = Input.getInt();

            if (avaliacao>=0 && avaliacao <=100)
                ok = true;
            else
                IO.error("Valor para Avaliação Inválido");
        }while (!ok);
        return avaliacao;
    }

    public static int getTamanhoTShirt() {
        out.print("XL <- 3\n");
        out.print("L  <- 2\n");
        out.print("M  <- 1\n");
        out.print("S  <- 0\n");
        out.print("Tamanho da TShirt: ");
        boolean ok = false;
        int tam = -1;

        while (!ok) {
            tam = Input.getInt();
            if (tam == 0 || tam == 1 || tam == 2 || tam == 3)
                ok = true;
            else
                IO.error("O valor inserido não é válido");
        }
        return tam;
    }

    public static int getPadrao() {
        out.print("Palmeiras <- 2\n");
        out.print("Riscas    <- 1\n");
        out.print("Liso      <- 0\n");
        out.print("Padrão da TShirt: ");
        boolean ok = false;
        int padrao = 3;

        while (!ok){
            padrao = Input.getInt();
            if(padrao == 0 || padrao == 1 || padrao == 2)
                ok = true;
            else
                IO.error("O valor inserido não é válido");
        }
        return padrao;
    }


    public static int getImposto() {
        out.print("Imposto (de 0 a 100): ");
        boolean ok = false;

        int imposto = -1;

        while (!ok){
            imposto = Input.getInt();
            if(imposto >= 0 &&  imposto <=100)
                ok = true;
            else
                IO.error("O imposto tem de ser uma valor de 0 a 100");
        }

        return imposto;
    }


    public static int getCodEncomenda() {
        out.print("Código da Encomenda: ");
        int codigo = Input.getInt();
        return codigo;
    }

    public static int getCodigoTransportadora() {
        out.print("Código da Trasnportadora: ");
        int codigo = Input.getInt();
        return codigo;
    }


    public static int getDias() {
        boolean ok = false;
        int i = 0;
        while (!ok) {
            i = getInt();
            if(i>=0)
                ok = true;
            else
                IO.error("Nao existem dias de entrega menor que 0");
        }
        return i;
    }

    public static int getFormulaTransportacao() {
        out.print("(Valor Base * Margem de Lucro + (1 + Imposto)) * 0.85 <- 3\n");
        out.print("Valor Base + Margem de Lucro * (1 + Imposto)          <- 2\n");
        out.print("(Valor Base * Margem de Lucro * (1 + Imposto)) * 0.9  <- 1\n");

        out.print("Formula escolhida: ");
        int f = -1;
        boolean ok = false;

        while (!ok) {
            f = Input.getInt();
            if (f >=1 && f <=3)
                ok = true;
            else
                IO.error("Nao existe uma formula com esse valor\n");
        }
        return f;
    }

    public static int getMargemLucro(){
        out.print("Insira a margem de lucro: ");
        int f = -1;
        boolean ok = false;

        while (!ok){
            f = Input.getInt();
            if(f>=0)
                ok = true;
            else
                out.println("As transportadoras so aceitam margem de lucro positivas");
        }
        return f;
    }


}
