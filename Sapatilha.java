import java.util.*;
import java.time.LocalDate;

public class Sapatilha {
    private int tamanho;
    private boolean atacadores; //sapatilhas podem ter: atacadores ou atilhos

    private LocalDate data;

    private String cor;

    //Construtores


    //Getters
    public int getTamanho() {
        return tamanho;
    }

    public boolean isAtacadores() {
        return atacadores;
    }

    public LocalDate getData() {
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

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    //Equals
    public boolean equals(Object o){
        if (this == o) return true;

        if ((o == null) || (this.getClass() != o.getClass())) return false;

        Sapatilha umaSapatilha = (Sapatilha) o;
        return ();
    }
    //Clone
    //toString
    //Hash

}
