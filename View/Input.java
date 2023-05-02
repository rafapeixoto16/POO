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


}
