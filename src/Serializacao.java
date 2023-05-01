package src;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import src.*;



public class Serializacao {
    private final File ficheiro;

    public Serializacao(String ficheiro) {
        this.ficheiro = new File(ficheiro);
    }

    public File getFicheiro() {
        return ficheiro;
    }

    //Carrega/lê a Vintage de ficheiro
    public Vintage carregar() {
        try (FileInputStream fileIn = new FileInputStream(ficheiro);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (Vintage) in.readObject();
        }catch(IOException | ClassNotFoundException ex) {
            throw new RuntimeException(String.format(
                    "Ocorreu um erro ao ler o ficheiro de dados: %s",
                    ex.getLocalizedMessage()), ex);
        }
    }

    //Guarda a Vintage em ficheiro
    public void guardar(Vintage vintage) {
        try (FileOutputStream fileOut = new FileOutputStream(ficheiro);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            try {
                out.writeObject(vintage);
            } catch (IOException ex) {
                throw new RuntimeException(String.format(
                        "Ocorreu um erro ao guardar o ficheiro de dados: %s",
                        ex.getLocalizedMessage()), ex);
            }
        } catch (IOException ex) {
            throw new RuntimeException(String.format(
                    "Ocorreu um erro ao guardar o ficheiro de dados: %s",
                    ex.getLocalizedMessage()), ex);
        }
    }
}

