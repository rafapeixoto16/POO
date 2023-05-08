package View;

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
                IO.error(e.getMessage()); //falata criar o metodo (noutra classe) para dar print ao erro
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

    public static LocalDate getDate(String text) {
        out.println(text);
        LocalDate date = null;
        boolean valid = false;
        String format = "dd-mm-aaaa";
        DateTimeFormatter f = DateTimeFormatter.ofPattern(format);

        do {
            try {
                out.print("Data no formato " + format + " : ");
                date = LocalDate.parse(Input.getString(), f);
                if (date != null) {
                    valid = true;
                }
            } catch (DateTimeParseException e) {
                IO.error(e.getMessage());
            }
        } while (!valid);

        return date;
    }

    public static String getEmail() {
        out.print("Email: ");
        String email = Input.getString();
        return email;
    }
    public static String getName() {
        out.print("Nome: ");
        String name = Input.getString();
        return name;
    }

    public static String getMorada() {
        out.print("Morada: ");
        String morada = Input.getString();
        return morada;
    }

    public static String getNIF() {
        out.print("NIF: ");
        String nif = Input.getString();
        return nif;
    }

    public static int getNumDonos() {
        out.print("Número de donos que o Artigo já teve: ");
        int numDonos = Input.getInt();
        return numDonos;
    }

    public static int getAvaliacao() {
        int avaliacao;
        boolean ok = false;
        do {
            out.print("Avaliação do Artigo (valor inteiro entre 0 e 10): ");
            avaliacao = Input.getInt();

            if (avaliacao>=0 && avaliacao <=10)
                ok = true;
            else
                IO.error("Valor para Avaliação Inválido");
        }while (!ok);
        return avaliacao;
    }

    public static String getDescricao() {
        out.print("Descricao do Artigo: ");
        String descricao = Input.getString();
        return descricao;
    }

    public static double getPrecoBase() {
        out.print("Preço Base do Artigo: ");
        double pb = Input.getDouble();
        return pb;
    }

    public static int getDim() {
        out.print("Dimensao da Mala: ");
        int dim = Input.getInt();
        return dim;
    }

    public static String getMaterial() {
        out.print("Material da Mala: ");
        String material = Input.getString();
        return material;
    }

    //Para classe Mala
    public static LocalDate getAno_colecao() { //rever
        out.print("Ano de colecao da mala: ");
        int ano = Input.getInt();
        return LocalDate.of(ano,1,1);
    }

    public static int getTamanhoSapatilha() {
        out.print("Tamanho da Sapatilha: ");
        int tamanho = Input.getInt();
        return tamanho;
    }

    public static boolean getAtacadores() {
        out.print("Atacadores = 1\n");
        out.print("Atilhos = 2\n");
        out.print("Opção: ");
        int op = Input.getInt();
        boolean ok = false;

        while (!ok) {
            op = Input.getInt();
            if (op == 1 || op == 2)
                ok = true;
            else
                out.print("O valor numero inserido tem de ser 1 (Atacadores) ou 2 (Atilhos) \n");
        }

        boolean at;

        at = op == 1;
        return at;
    }

    //Para classe Spatilha
    public static LocalDate getData() { //rever
        out.print("Ano de colecao da Sapatilha: ");
        int ano = Input.getInt();
        LocalDate data = LocalDate.of(ano,1,1);
        return data;
    }

    public static String getCor() {
        out.print("Cor da Spatilha: ");
        String cor = Input.getString();
        return cor;
    }

    public static int getTamanhoTShirt() {
        out.print("XL <- 3\n");
        out.print("L  <- 2\n");
        out.print("M  <- 1\n");
        out.print("S  <- 0\n");
        out.print("Tamanho da TShirt: ");
        int tamanho = Input.getInt();
        return tamanho;
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
            if(padrao == 1 || padrao == 0 || padrao ==2)
                ok = true;
        }
        return padrao;
    }

    //get para o codTransportadora????????

    public static int getImposto() {
        out.print("Imposto: ");
        int imposto = Input.getInt();
        return imposto;
    }

    public static boolean getNovo() {
        out.print("Novo   <- 1\n");
        out.print("Usado  <- 0\n");
        out.print("Estado do artigo: ");
        int padrao = Input.getInt();
        boolean ok = false;

        while (!ok) {
            padrao = Input.getInt();
            if (padrao == 1 || padrao == 0)
                ok = true;
            else
                out.print("O valor numero inserido tem de ser 1 (Novo) ou 0 (Usado) \n");
        }
        boolean at;

        at = padrao == 1;
        return at;
    }
    //diasEntrega?????????????????

}
