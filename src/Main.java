package src;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Vintage sistema = new Vintage();



        public
        try (FileOutputStream fos = new FileOutputStream("arquivo.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(sistema);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
