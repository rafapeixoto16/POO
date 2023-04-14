import java.util.*;

public class Sapatilha {
    private int tamanho;
    private boolean atacadores; //sapatilhas podem ter: atacadores ou atilhos

    private Date data;
    private String cor;

    //Construtores


    //Getters
    public int getTamanho() {
        return tamanho;
    }

    public boolean isAtacadores() {
        return atacadores;
    }

    public Date getData() {
        return data;
    }

    public String getCor() {
        return cor;
    }


    //Setters
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void setAtacadores(boolean atacadores) {
        this.atacadores = atacadores;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    //Equals

    //Clone
    //toString
    //Hash

}
